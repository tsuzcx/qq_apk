package com.tencent.mm.plugin.voip_cs.c;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmm;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.protocal.protobuf.esq;
import com.tencent.mm.protocal.protobuf.esr;
import com.tencent.mm.protocal.protobuf.esv;
import com.tencent.mm.protocal.protobuf.esx;
import com.tencent.mm.protocal.protobuf.etb;
import com.tencent.mm.protocal.protobuf.ete;
import com.tencent.mm.protocal.protobuf.eth;
import com.tencent.mm.protocal.protobuf.etj;
import com.tencent.mm.protocal.protobuf.euh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  implements i
{
  public int GWg;
  public b HrE;
  public int HrF;
  public int HrG;
  public int HrH;
  public byte[] HrI;
  public int HrJ;
  public int HrK;
  public int HrL;
  public String HrM;
  public int HrN;
  public int HrO;
  public MTimerHandler HrP;
  public MTimerHandler HrQ;
  public int Hrb;
  public int ypQ;
  
  public e()
  {
    AppMethodBeat.i(125358);
    this.HrF = 0;
    this.Hrb = 0;
    this.HrG = 0;
    this.HrH = 0;
    this.HrI = null;
    this.ypQ = 0;
    this.HrJ = 0;
    this.HrK = 0;
    this.HrL = 0;
    this.HrM = "";
    this.GWg = 0;
    this.HrN = 0;
    this.HrO = 999;
    this.HrP = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125356);
        Log.v("MicroMsg.voipcs.VoipCSService", "voipcs repeat sync");
        e.this.fMz();
        AppMethodBeat.o(125356);
        return true;
      }
    }, true);
    this.HrQ = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125357);
        Log.v("MicroMsg.voipcs.VoipCSService", "voipcs heart beat");
        Object localObject = e.this;
        g.azz().a(795, (i)localObject);
        localObject = new com.tencent.mm.plugin.voip_cs.c.c.b(c.fMr().Hsv.Haw, c.fMr().Hsv.ypH);
        g.azz().a((q)localObject, 0);
        AppMethodBeat.o(125357);
        return true;
      }
    }, true);
    AppMethodBeat.o(125358);
  }
  
  private static void c(int paramInt1, int paramInt2, q paramq)
  {
    AppMethodBeat.i(125361);
    Log.i("MicroMsg.voipcs.VoipCSService", "Redirect response:" + paramInt1 + " errCode:" + paramInt2);
    if (paramInt2 != 0)
    {
      Log.i("MicroMsg.voipcs.VoipCSService", " redirect response with error code:".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(125361);
      return;
    }
    paramq = (ete)((com.tencent.mm.plugin.voip_cs.c.c.d)paramq).rr.iLL.iLR;
    Log.i("MicroMsg.voipcs.VoipCSService", "roomid " + paramq.NeG + " key " + paramq.Lta + "relay addr cnt " + paramq.KMD.size());
    Object localObject1 = paramq.KMD;
    paramq = new esr();
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      esv localesv = (esv)((Iterator)localObject2).next();
      esq localesq = new esq();
      localesq.NgC = localesv.MpA;
      localesq.MKe = localesv.MKe;
      paramq.NpZ.add(localesq);
    }
    paramq.NpY = ((List)localObject1).size();
    localObject1 = new dmm();
    localObject2 = new dml();
    ((dml)localObject2).LqX = 0;
    ((dml)localObject2).LqY = "";
    ((dml)localObject2).LqZ = "";
    ((dml)localObject2).Lra = 4;
    ((dml)localObject2).Lrb = 4;
    ((dml)localObject2).Lrc = 2;
    ((dml)localObject2).MPX = paramq;
    ((dml)localObject2).MPY = new esr();
    ((dmm)localObject1).MQa.add(localObject2);
    ((dmm)localObject1).MPZ = 1;
    paramq = null;
    try
    {
      localObject1 = ((dmm)localObject1).toByteArray();
      paramq = (q)localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.voipcs.VoipCSService", "conn info to byte array fail..");
      }
    }
    if (paramq != null)
    {
      paramInt1 = c.fMr().Hsv.AddNewRelayConns(paramq, paramq.length, 1);
      if (paramInt1 != 0) {
        com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.voipcs.VoipCSService", "redirect relay conns fail ret:".concat(String.valueOf(paramInt1)));
      }
    }
    AppMethodBeat.o(125361);
  }
  
  public final void a(etj parametj)
  {
    AppMethodBeat.i(125362);
    if ((parametj.NqC <= this.HrF) || (c.fMs().HrL == 3))
    {
      AppMethodBeat.o(125362);
      return;
    }
    Log.i("MicroMsg.voipcs.VoipCSService", "get callee sync resp,notifySeq:" + parametj.NqC + ",calleeMemberId:" + parametj.NqD + ",calleeStatus:" + parametj.NqE + ",calleeSubStatus:" + parametj.NqF + ",recv roomId:" + parametj.NeG + ",recv roomKey:" + parametj.Lta);
    if ((c.fMr().Hsv.Haw != 0L) && (c.fMr().Hsv.Haw != parametj.NeG))
    {
      Log.i("MicroMsg.voipcs.VoipCSService", "csRoomId:" + c.fMr().Hsv.Haw + ",recv roomId:" + parametj.NeG + ",current and recv not equal!!");
      AppMethodBeat.o(125362);
      return;
    }
    this.HrF = parametj.NqC;
    this.Hrb = parametj.NqD;
    this.HrG = parametj.NqE;
    this.HrH = parametj.NqF;
    c.fMt().Hrb = this.Hrb;
    if (this.HrG == 2)
    {
      Log.i("MicroMsg.voipcs.VoipCSService", "callee accept!");
      this.HrP.stopTimer();
      fMz();
      c.fMr().Hsv.ypH = parametj.Lta;
      Log.i("MicroMsg.voipcs.VoipCSService", "csroomId:" + parametj.NeG + ",roomkey:" + parametj.Lta);
      if (parametj.NqG != null) {}
      for (parametj = parametj.NqG.toByteArray();; parametj = null)
      {
        this.HrI = parametj;
        if (c.fMr().Hsv.field_capInfo != null) {
          break;
        }
        AppMethodBeat.o(125362);
        return;
      }
      if (this.HrI == null)
      {
        AppMethodBeat.o(125362);
        return;
      }
      c.fMt().fMv();
      c.fMr().Hsv.Hay = this.HrI;
      Log.i("MicroMsg.voipcs.VoipCSService", "calleeCapDump is " + Arrays.toString(c.fMr().Hsv.Hay));
      Log.i("MicroMsg.voipcs.VoipCSService", "calleeCap length:" + this.HrI.length);
      if ((c.fMr().Hsv.Hay != null) && (c.fMr().Hsv.exchangeCabInfo(c.fMr().Hsv.Hay, c.fMr().Hsv.Hay.length) < 0)) {
        Log.i("MicroMsg.voipcs.VoipCSService", "exchangeCabInfo fail!");
      }
      int i;
      if (c.fMr().Hsv.HaB == null)
      {
        i = 0;
        i = c.fMr().Hsv.setConfigInfo(c.fMr().Hsv.Hav, c.fMr().Hsv.Haw, c.fMr().Hsv.ypO, c.fMr().Hsv.ypH, c.fMr().Hsv.field_peerId, 1, c.fMr().Hsv.HaC, c.fMr().Hsv.HaD, c.fMr().Hsv.HaA, i, c.fMr().Hsv.HaB, this.HrO, 1, c.fMr().Hsv.netType, c.fMr().Hsv.HbJ, c.fMr().Hsv.HbK, 255, 0, 0, null, 0, 0, 0, 0, "", "", 0);
        if (i != 0) {
          Log.e("MicroMsg.voipcs.VoipCSService", "setConfig fail, ret:%d", new Object[] { Integer.valueOf(i) });
        }
        if (c.fMr().Hsv.HbZ != null) {
          break label763;
        }
        com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.voipcs.VoipCSService", "relay conns buf null");
      }
      for (;;)
      {
        if (this.HrQ.stopped()) {
          this.HrQ.startTimer(50000L);
        }
        c.fMt().Hrh = 1;
        AppMethodBeat.o(125362);
        return;
        i = c.fMr().Hsv.HaB.length;
        break;
        label763:
        i = c.fMr().Hsv.AddNewRelayConns(c.fMr().Hsv.HbZ, c.fMr().Hsv.HbZ.length, 0);
        if (i < 0) {
          com.tencent.mm.plugin.voip.b.e.Loge("MicroMsg.voipcs.VoipCSService", "add relayconns err:".concat(String.valueOf(i)));
        }
      }
    }
    if ((this.HrG != 0) && (this.HrG != 1) && (this.HrG == 3))
    {
      Log.i("MicroMsg.voipcs.VoipCSService", "callee hangup!");
      c.fMt().dataType = 5;
      c.fMt().fMu();
      c.fMt().Hrl = 2;
      if (this.HrH != 1) {
        break label906;
      }
      c.fMt().Hrd = 12;
    }
    for (;;)
    {
      if (this.HrE != null) {
        this.HrE.aeh(1);
      }
      AppMethodBeat.o(125362);
      return;
      label906:
      if (this.HrH == 3) {
        c.fMt().Hrd = 99;
      }
    }
  }
  
  public final void aY(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(125360);
    Log.i("MicroMsg.voipcs.VoipCSService", "start netscene invite for username:" + paramString1 + ",appid:" + paramString2 + ",voipCSContext:" + paramString3);
    this.HrM = paramString1;
    this.HrL = 1;
    Object localObject1 = c.fMt();
    Log.d("MicroMsg.VoipCSReportHelper", "markSendInvite");
    if (((d)localObject1).Hry == 0) {
      ((d)localObject1).Hry = ((int)(System.currentTimeMillis() / 1000L));
    }
    Object localObject2 = null;
    localObject1 = localObject2;
    if (paramString3 != null)
    {
      localObject1 = localObject2;
      if (!paramString3.equals("")) {
        localObject1 = paramString3.getBytes();
      }
    }
    g.azz().a(823, this);
    c.fMr().Hsv.ypJ = ((int)(System.currentTimeMillis() / 1000L));
    paramString1 = new com.tencent.mm.plugin.voip_cs.c.c.c(c.fMr().Hsv.ypJ, paramString1, c.fMr().Hsv.netType, (byte[])localObject1, c.fMr().Hsv.field_capInfo, paramString2);
    Log.i("MicroMsg.voipcs.VoipCSService", "capDump is " + Arrays.toString(c.fMr().Hsv.field_capInfo));
    g.azz().a(paramString1, 0);
    AppMethodBeat.o(125360);
  }
  
  public final int fMy()
  {
    return this.HrL;
  }
  
  public final void fMz()
  {
    AppMethodBeat.i(125359);
    g.azz().a(818, this);
    com.tencent.mm.plugin.voip_cs.c.c.f localf = new com.tencent.mm.plugin.voip_cs.c.c.f(c.fMr().Hsv.Haw, c.fMr().Hsv.ypH, this.HrF);
    g.azz().a(localf, 0);
    AppMethodBeat.o(125359);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(125363);
    Log.i("MicroMsg.voipcs.VoipCSService", "onSceneEnd :netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Object localObject1;
      if (paramq.getType() == 823)
      {
        paramq = (etb)((com.tencent.mm.plugin.voip_cs.c.c.c)paramq).rr.iLL.iLR;
        long l1 = paramq.NeG;
        long l2 = paramq.Lta;
        Object localObject2 = paramq.KMD;
        localObject1 = paramq.NqB;
        this.ypQ = paramq.Ndy;
        this.HrO = paramq.NqA;
        Log.i("MicroMsg.voipcs.VoipCSService", "tcpStartCnt : " + this.HrO);
        c.fMr().Hsv.HaD = paramq.ypX;
        this.HrJ = paramq.ypR;
        c.fMr().Hsv.HbJ = paramq.yqc;
        c.fMr().Hsv.HbK = paramq.MKv.toByteArray();
        c.fMr().Hsv.HaC = paramq.ypY;
        paramString = new esr();
        Iterator localIterator = ((List)localObject2).iterator();
        esv localesv;
        esq localesq;
        while (localIterator.hasNext())
        {
          localesv = (esv)localIterator.next();
          localesq = new esq();
          localesq.NgC = localesv.MpA;
          localesq.MKe = localesv.MKe;
          paramString.NpZ.add(localesq);
        }
        paramString.NpY = ((List)localObject2).size();
        localObject2 = new esr();
        localIterator = ((List)localObject1).iterator();
        while (localIterator.hasNext())
        {
          localesv = (esv)localIterator.next();
          localesq = new esq();
          localesq.NgC = localesv.MpA;
          localesq.MKe = localesv.MKe;
          ((esr)localObject2).NpZ.add(localesq);
        }
        ((esr)localObject2).NpY = ((List)localObject1).size();
        c.fMr().Hsv.Haw = l1;
        c.fMr().Hsv.ypH = l2;
        Log.i("MicroMsg.voipcs.VoipCSService", "recv invite resp csRoomId : " + l1 + ",roomKey:" + l2);
        c.fMr().Hsv.HbT = paramq.Nqy;
        c.fMr().Hsv.HbU = paramq.Nqz;
        paramq = new euh();
        paramq.oXT = 0;
        paramq.GWx = 0;
        paramq.GWw = 0;
        paramq.userName = "";
        paramq.dQC = "";
        paramq = new dml();
        paramq.LqX = 0;
        paramq.LqY = "";
        paramq.LqZ = "";
        paramq.Lra = 4;
        paramq.Lrb = 4;
        paramq.Lrc = 2;
        paramq.MPX = paramString;
        paramq.MPY = ((esr)localObject2);
        paramString = new dmm();
        paramString.MPZ = 1;
        paramString.MQa = new LinkedList();
        paramString.MQa.add(paramq);
        try
        {
          c.fMr().Hsv.HbZ = paramString.toByteArray();
          paramString = c.fMt();
          paramq = this.HrM;
          Log.d("MicroMsg.VoipCSReportHelper", "setVoipCSBaseInfo");
          paramString.roomId = l1;
          paramString.ypH = l2;
          paramString.Hra = paramq;
          if (this.HrP.stopped())
          {
            if (this.ypQ > 0) {
              this.HrP.startTimer(this.ypQ * 1000);
            }
          }
          else
          {
            paramString = c.fMt();
            Log.d("MicroMsg.VoipCSReportHelper", "markRecvInvite");
            if (paramString.Hry != 0) {
              paramString.Hrz = ((int)(System.currentTimeMillis() / 1000L));
            }
            AppMethodBeat.o(125363);
            return;
          }
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            Log.e("MicroMsg.voipcs.VoipCSService", "relay conn info to byte array fail..");
            continue;
            this.HrP.startTimer(4000L);
          }
        }
      }
      if (paramq.getType() == 818)
      {
        paramString = (etj)((com.tencent.mm.plugin.voip_cs.c.c.f)paramq).rr.iLL.iLR;
        Log.i("MicroMsg.voipcs.VoipCSService", "sync status = " + paramString.NqE + ",notifySeq = " + paramString.NqC);
        a(paramString);
        AppMethodBeat.o(125363);
        return;
      }
      if (paramq.getType() == 880)
      {
        paramString = (esx)((com.tencent.mm.plugin.voip_cs.c.c.a)paramq).rr.iLL.iLR;
        if ((c.fMr().Hsv.Haw == paramString.NeG) && (c.fMr().Hsv.ypH == paramString.Lta)) {
          Log.i("MicroMsg.voipcs.VoipCSService", "hangup success!");
        }
        g.azz().b(880, this);
        c.fMt().aei(com.tencent.mm.plugin.voip_cs.c.a.a.fMB().qtg.fKX());
        AppMethodBeat.o(125363);
        return;
      }
      if (paramq.getType() == 106)
      {
        localObject1 = (com.tencent.mm.plugin.messenger.a.f)paramq;
        paramq = "";
        paramString = "";
        if (((com.tencent.mm.plugin.messenger.a.f)localObject1).eiq() != null)
        {
          paramq = ((com.tencent.mm.plugin.messenger.a.f)localObject1).eiq().Lir;
          paramString = ((com.tencent.mm.plugin.messenger.a.f)localObject1).eiq().Mjj.MTo;
        }
        for (;;)
        {
          this.HrE.ln(paramq, paramString);
          AppMethodBeat.o(125363);
          return;
          Log.i("MicroMsg.voipcs.VoipCSService", "search Or Recommend items is null or empty !");
        }
      }
      if (paramq.getType() == 285)
      {
        c(paramInt1, paramInt2, paramq);
        AppMethodBeat.o(125363);
        return;
      }
      if (paramq.getType() == 312)
      {
        paramString = (eth)((com.tencent.mm.plugin.voip_cs.c.c.e)paramq).rr.iLL.iLR;
        if ((paramString.NeG == c.fMr().Hsv.Haw) && (paramString.Lta == c.fMr().Hsv.ypH)) {
          Log.i("MicroMsg.voipcs.VoipCSService", "report data success!");
        }
        AppMethodBeat.o(125363);
      }
    }
    else
    {
      Log.i("MicroMsg.voipcs.VoipCSService", "onSceneEnd  resp error!:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 != 0) && (paramInt1 != 4))
      {
        this.HrN = -1;
        this.HrE.onError(10);
        AppMethodBeat.o(125363);
        return;
      }
      if (paramq.getType() == 823)
      {
        if (paramInt2 == 406)
        {
          Log.i("MicroMsg.voipcs.VoipCSService", "CS_INVITE_RESP_REPEAT_INVTIE 503..");
          AppMethodBeat.o(125363);
          return;
        }
        c.fMt().dataType = 1;
        this.HrN = 823;
        this.HrE.onError(paramInt2);
        AppMethodBeat.o(125363);
        return;
      }
      if ((paramq.getType() != 880) && (paramq.getType() != 818) && (paramq.getType() == 106)) {
        this.HrE.ln("", "");
      }
    }
    AppMethodBeat.o(125363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.e
 * JD-Core Version:    0.7.0.1
 */