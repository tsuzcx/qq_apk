package com.tencent.mm.plugin.voip_cs.c;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.dwc;
import com.tencent.mm.protocal.protobuf.dwd;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.ebp;
import com.tencent.mm.protocal.protobuf.fdb;
import com.tencent.mm.protocal.protobuf.fdc;
import com.tencent.mm.protocal.protobuf.fdg;
import com.tencent.mm.protocal.protobuf.fdi;
import com.tencent.mm.protocal.protobuf.fdm;
import com.tencent.mm.protocal.protobuf.fdp;
import com.tencent.mm.protocal.protobuf.fds;
import com.tencent.mm.protocal.protobuf.fdu;
import com.tencent.mm.protocal.protobuf.fes;
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
  public int DPS;
  public int NMt;
  public int OiM;
  public MTimerHandler OjA;
  public MTimerHandler OjB;
  public b Ojp;
  public int Ojq;
  public int Ojr;
  public int Ojs;
  public byte[] Ojt;
  public int Oju;
  public int Ojv;
  public int Ojw;
  public String Ojx;
  public int Ojy;
  public int Ojz;
  
  public e()
  {
    AppMethodBeat.i(125358);
    this.Ojq = 0;
    this.OiM = 0;
    this.Ojr = 0;
    this.Ojs = 0;
    this.Ojt = null;
    this.DPS = 0;
    this.Oju = 0;
    this.Ojv = 0;
    this.Ojw = 0;
    this.Ojx = "";
    this.NMt = 0;
    this.Ojy = 0;
    this.Ojz = 999;
    this.OjA = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125356);
        Log.v("MicroMsg.voipcs.VoipCSService", "voipcs repeat sync");
        e.this.gFd();
        AppMethodBeat.o(125356);
        return true;
      }
    }, true);
    this.OjB = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125357);
        Log.v("MicroMsg.voipcs.VoipCSService", "voipcs heart beat");
        Object localObject = e.this;
        h.aGY().a(795, (i)localObject);
        localObject = new com.tencent.mm.plugin.voip_cs.c.c.b(c.gEV().Okf.NQI, c.gEV().Okf.DPJ);
        h.aGY().a((q)localObject, 0);
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
    paramq = (fdp)d.c.b(((com.tencent.mm.plugin.voip_cs.c.c.d)paramq).rr.lBS);
    Log.i("MicroMsg.voipcs.VoipCSService", "roomid " + paramq.Urf + " key " + paramq.Svv + "relay addr cnt " + paramq.RNx.size());
    Object localObject1 = paramq.RNx;
    paramq = new fdc();
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      fdg localfdg = (fdg)((Iterator)localObject2).next();
      fdb localfdb = new fdb();
      localfdb.Utg = localfdg.TVX;
      localfdb.TVY = localfdg.TVY;
      paramq.UCV.add(localfdb);
    }
    paramq.UCU = ((List)localObject1).size();
    localObject1 = new dwd();
    localObject2 = new dwc();
    ((dwc)localObject2).Ssu = 0;
    ((dwc)localObject2).Ssv = "";
    ((dwc)localObject2).Ssw = "";
    ((dwc)localObject2).Ssx = 4;
    ((dwc)localObject2).Ssy = 4;
    ((dwc)localObject2).Ssz = 2;
    ((dwc)localObject2).Ucb = paramq;
    ((dwc)localObject2).Ucc = new fdc();
    ((dwd)localObject1).Uce.add(localObject2);
    ((dwd)localObject1).Ucd = 1;
    paramq = null;
    try
    {
      localObject1 = ((dwd)localObject1).toByteArray();
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
      paramInt1 = c.gEV().Okf.AddNewRelayConns(paramq, paramq.length, 1);
      if (paramInt1 != 0) {
        com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.voipcs.VoipCSService", "redirect relay conns fail ret:".concat(String.valueOf(paramInt1)));
      }
    }
    AppMethodBeat.o(125361);
  }
  
  public final void a(fdu paramfdu)
  {
    AppMethodBeat.i(125362);
    if ((paramfdu.UDy <= this.Ojq) || (c.gEW().Ojw == 3))
    {
      AppMethodBeat.o(125362);
      return;
    }
    Log.i("MicroMsg.voipcs.VoipCSService", "get callee sync resp,notifySeq:" + paramfdu.UDy + ",calleeMemberId:" + paramfdu.UDz + ",calleeStatus:" + paramfdu.UDA + ",calleeSubStatus:" + paramfdu.UDB + ",recv roomId:" + paramfdu.Urf + ",recv roomKey:" + paramfdu.Svv);
    if ((c.gEV().Okf.NQI != 0L) && (c.gEV().Okf.NQI != paramfdu.Urf))
    {
      Log.i("MicroMsg.voipcs.VoipCSService", "csRoomId:" + c.gEV().Okf.NQI + ",recv roomId:" + paramfdu.Urf + ",current and recv not equal!!");
      AppMethodBeat.o(125362);
      return;
    }
    this.Ojq = paramfdu.UDy;
    this.OiM = paramfdu.UDz;
    this.Ojr = paramfdu.UDA;
    this.Ojs = paramfdu.UDB;
    c.gEX().OiM = this.OiM;
    if (this.Ojr == 2)
    {
      Log.i("MicroMsg.voipcs.VoipCSService", "callee accept!");
      this.OjA.stopTimer();
      gFd();
      c.gEV().Okf.DPJ = paramfdu.Svv;
      Log.i("MicroMsg.voipcs.VoipCSService", "csroomId:" + paramfdu.Urf + ",roomkey:" + paramfdu.Svv);
      if (paramfdu.UDC != null) {}
      for (paramfdu = paramfdu.UDC.toByteArray();; paramfdu = null)
      {
        this.Ojt = paramfdu;
        if (c.gEV().Okf.field_capInfo != null) {
          break;
        }
        AppMethodBeat.o(125362);
        return;
      }
      if (this.Ojt == null)
      {
        AppMethodBeat.o(125362);
        return;
      }
      c.gEX().gEZ();
      c.gEV().Okf.NQK = this.Ojt;
      Log.i("MicroMsg.voipcs.VoipCSService", "calleeCapDump is " + Arrays.toString(c.gEV().Okf.NQK));
      Log.i("MicroMsg.voipcs.VoipCSService", "calleeCap length:" + this.Ojt.length);
      if ((c.gEV().Okf.NQK != null) && (c.gEV().Okf.exchangeCabInfo(c.gEV().Okf.NQK, c.gEV().Okf.NQK.length) < 0)) {
        Log.i("MicroMsg.voipcs.VoipCSService", "exchangeCabInfo fail!");
      }
      int i;
      if (c.gEV().Okf.NQN == null)
      {
        i = 0;
        i = c.gEV().Okf.setConfigInfo(c.gEV().Okf.NQH, c.gEV().Okf.NQI, c.gEV().Okf.DPQ, c.gEV().Okf.DPJ, c.gEV().Okf.field_peerId, 1, c.gEV().Okf.NQO, c.gEV().Okf.NQP, c.gEV().Okf.NQM, i, c.gEV().Okf.NQN, this.Ojz, 1, c.gEV().Okf.netType, c.gEV().Okf.NRV, c.gEV().Okf.NRW, 255, 0, 0, null, 0, 0, 0, 0, "", "", "");
        if (i != 0) {
          Log.e("MicroMsg.voipcs.VoipCSService", "setConfig fail, ret:%d", new Object[] { Integer.valueOf(i) });
        }
        if (c.gEV().Okf.NSl != null) {
          break label764;
        }
        com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.voipcs.VoipCSService", "relay conns buf null");
      }
      for (;;)
      {
        if (this.OjB.stopped()) {
          this.OjB.startTimer(50000L);
        }
        c.gEX().OiS = 1;
        AppMethodBeat.o(125362);
        return;
        i = c.gEV().Okf.NQN.length;
        break;
        label764:
        i = c.gEV().Okf.AddNewRelayConns(c.gEV().Okf.NSl, c.gEV().Okf.NSl.length, 0);
        if (i < 0) {
          com.tencent.mm.plugin.voip.c.e.Loge("MicroMsg.voipcs.VoipCSService", "add relayconns err:".concat(String.valueOf(i)));
        }
      }
    }
    if ((this.Ojr != 0) && (this.Ojr != 1) && (this.Ojr == 3))
    {
      Log.i("MicroMsg.voipcs.VoipCSService", "callee hangup!");
      c.gEX().dataType = 5;
      c.gEX().gEY();
      c.gEX().OiW = 2;
      if (this.Ojs != 1) {
        break label907;
      }
      c.gEX().OiO = 12;
    }
    for (;;)
    {
      if (this.Ojp != null) {
        this.Ojp.alU(1);
      }
      AppMethodBeat.o(125362);
      return;
      label907:
      if (this.Ojs == 3) {
        c.gEX().OiO = 99;
      }
    }
  }
  
  public final void aS(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(125360);
    Log.i("MicroMsg.voipcs.VoipCSService", "start netscene invite for username:" + paramString1 + ",appid:" + paramString2 + ",voipCSContext:" + paramString3);
    this.Ojx = paramString1;
    this.Ojw = 1;
    Object localObject1 = c.gEX();
    Log.d("MicroMsg.VoipCSReportHelper", "markSendInvite");
    if (((d)localObject1).Ojj == 0) {
      ((d)localObject1).Ojj = ((int)(System.currentTimeMillis() / 1000L));
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
    h.aGY().a(823, this);
    c.gEV().Okf.DPL = ((int)(System.currentTimeMillis() / 1000L));
    paramString1 = new com.tencent.mm.plugin.voip_cs.c.c.c(c.gEV().Okf.DPL, paramString1, c.gEV().Okf.netType, (byte[])localObject1, c.gEV().Okf.field_capInfo, paramString2);
    Log.i("MicroMsg.voipcs.VoipCSService", "capDump is " + Arrays.toString(c.gEV().Okf.field_capInfo));
    h.aGY().a(paramString1, 0);
    AppMethodBeat.o(125360);
  }
  
  public final int gFc()
  {
    return this.Ojw;
  }
  
  public final void gFd()
  {
    AppMethodBeat.i(125359);
    h.aGY().a(818, this);
    com.tencent.mm.plugin.voip_cs.c.c.f localf = new com.tencent.mm.plugin.voip_cs.c.c.f(c.gEV().Okf.NQI, c.gEV().Okf.DPJ, this.Ojq);
    h.aGY().a(localf, 0);
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
        paramq = (fdm)d.c.b(((com.tencent.mm.plugin.voip_cs.c.c.c)paramq).rr.lBS);
        long l1 = paramq.Urf;
        long l2 = paramq.Svv;
        Object localObject2 = paramq.RNx;
        localObject1 = paramq.UDx;
        this.DPS = paramq.UpV;
        this.Ojz = paramq.UDw;
        Log.i("MicroMsg.voipcs.VoipCSService", "tcpStartCnt : " + this.Ojz);
        c.gEV().Okf.NQP = paramq.DPZ;
        this.Oju = paramq.DPT;
        c.gEV().Okf.NRV = paramq.DQe;
        c.gEV().Okf.NRW = paramq.TWp.toByteArray();
        c.gEV().Okf.NQO = paramq.DQa;
        paramString = new fdc();
        Iterator localIterator = ((List)localObject2).iterator();
        fdg localfdg;
        fdb localfdb;
        while (localIterator.hasNext())
        {
          localfdg = (fdg)localIterator.next();
          localfdb = new fdb();
          localfdb.Utg = localfdg.TVX;
          localfdb.TVY = localfdg.TVY;
          paramString.UCV.add(localfdb);
        }
        paramString.UCU = ((List)localObject2).size();
        localObject2 = new fdc();
        localIterator = ((List)localObject1).iterator();
        while (localIterator.hasNext())
        {
          localfdg = (fdg)localIterator.next();
          localfdb = new fdb();
          localfdb.Utg = localfdg.TVX;
          localfdb.TVY = localfdg.TVY;
          ((fdc)localObject2).UCV.add(localfdb);
        }
        ((fdc)localObject2).UCU = ((List)localObject1).size();
        c.gEV().Okf.NQI = l1;
        c.gEV().Okf.DPJ = l2;
        Log.i("MicroMsg.voipcs.VoipCSService", "recv invite resp csRoomId : " + l1 + ",roomKey:" + l2);
        c.gEV().Okf.NSf = paramq.UDu;
        c.gEV().Okf.NSg = paramq.UDv;
        paramq = new fes();
        paramq.rZU = 0;
        paramq.NMK = 0;
        paramq.NMJ = 0;
        paramq.userName = "";
        paramq.fJS = "";
        paramq = new dwc();
        paramq.Ssu = 0;
        paramq.Ssv = "";
        paramq.Ssw = "";
        paramq.Ssx = 4;
        paramq.Ssy = 4;
        paramq.Ssz = 2;
        paramq.Ucb = paramString;
        paramq.Ucc = ((fdc)localObject2);
        paramString = new dwd();
        paramString.Ucd = 1;
        paramString.Uce = new LinkedList();
        paramString.Uce.add(paramq);
        try
        {
          c.gEV().Okf.NSl = paramString.toByteArray();
          paramString = c.gEX();
          paramq = this.Ojx;
          Log.d("MicroMsg.VoipCSReportHelper", "setVoipCSBaseInfo");
          paramString.roomId = l1;
          paramString.DPJ = l2;
          paramString.OiL = paramq;
          if (this.OjA.stopped())
          {
            if (this.DPS > 0) {
              this.OjA.startTimer(this.DPS * 1000);
            }
          }
          else
          {
            paramString = c.gEX();
            Log.d("MicroMsg.VoipCSReportHelper", "markRecvInvite");
            if (paramString.Ojj != 0) {
              paramString.Ojk = ((int)(System.currentTimeMillis() / 1000L));
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
            this.OjA.startTimer(4000L);
          }
        }
      }
      if (paramq.getType() == 818)
      {
        paramString = (fdu)d.c.b(((com.tencent.mm.plugin.voip_cs.c.c.f)paramq).rr.lBS);
        Log.i("MicroMsg.voipcs.VoipCSService", "sync status = " + paramString.UDA + ",notifySeq = " + paramString.UDy);
        a(paramString);
        AppMethodBeat.o(125363);
        return;
      }
      if (paramq.getType() == 880)
      {
        paramString = (fdi)d.c.b(((com.tencent.mm.plugin.voip_cs.c.c.a)paramq).rr.lBS);
        if ((c.gEV().Okf.NQI == paramString.Urf) && (c.gEV().Okf.DPJ == paramString.Svv)) {
          Log.i("MicroMsg.voipcs.VoipCSService", "hangup success!");
        }
        h.aGY().b(880, this);
        c.gEX().alV(com.tencent.mm.plugin.voip_cs.c.a.a.gFf().tRS.gDx());
        AppMethodBeat.o(125363);
        return;
      }
      if (paramq.getType() == 106)
      {
        localObject1 = (com.tencent.mm.plugin.messenger.a.f)paramq;
        paramq = "";
        paramString = "";
        if (((com.tencent.mm.plugin.messenger.a.f)localObject1).eRV() != null)
        {
          paramq = ((com.tencent.mm.plugin.messenger.a.f)localObject1).eRV().SjI;
          paramString = ((com.tencent.mm.plugin.messenger.a.f)localObject1).eRV().TtX.Ufy;
        }
        for (;;)
        {
          this.Ojp.lK(paramq, paramString);
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
        paramString = (fds)d.c.b(((com.tencent.mm.plugin.voip_cs.c.c.e)paramq).rr.lBS);
        if ((paramString.Urf == c.gEV().Okf.NQI) && (paramString.Svv == c.gEV().Okf.DPJ)) {
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
        this.Ojy = -1;
        this.Ojp.kv(10);
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
        c.gEX().dataType = 1;
        this.Ojy = 823;
        this.Ojp.kv(paramInt2);
        AppMethodBeat.o(125363);
        return;
      }
      if ((paramq.getType() != 880) && (paramq.getType() != 818) && (paramq.getType() == 106)) {
        this.Ojp.lK("", "");
      }
    }
    AppMethodBeat.o(125363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.e
 * JD-Core Version:    0.7.0.1
 */