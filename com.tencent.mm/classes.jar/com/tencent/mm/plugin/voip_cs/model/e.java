package com.tencent.mm.plugin.voip_cs.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.protocal.protobuf.epe;
import com.tencent.mm.protocal.protobuf.epf;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.evg;
import com.tencent.mm.protocal.protobuf.fzn;
import com.tencent.mm.protocal.protobuf.fzo;
import com.tencent.mm.protocal.protobuf.fzs;
import com.tencent.mm.protocal.protobuf.fzu;
import com.tencent.mm.protocal.protobuf.fzy;
import com.tencent.mm.protocal.protobuf.gab;
import com.tencent.mm.protocal.protobuf.gae;
import com.tencent.mm.protocal.protobuf.gag;
import com.tencent.mm.protocal.protobuf.gbe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  implements com.tencent.mm.am.h
{
  public int JHd;
  public b UXK;
  public int UXL;
  public int UXM;
  public int UXN;
  public byte[] UXO;
  public int UXP;
  public int UXQ;
  public int UXR;
  public String UXS;
  public int UXT;
  public int UXU;
  public MTimerHandler UXV;
  public MTimerHandler UXW;
  public int UXh;
  public int Uzf;
  
  public e()
  {
    AppMethodBeat.i(125358);
    this.UXL = 0;
    this.UXh = 0;
    this.UXM = 0;
    this.UXN = 0;
    this.UXO = null;
    this.JHd = 0;
    this.UXP = 0;
    this.UXQ = 0;
    this.UXR = 0;
    this.UXS = "";
    this.Uzf = 0;
    this.UXT = 0;
    this.UXU = 999;
    this.UXV = new MTimerHandler(Looper.getMainLooper(), new e.1(this), true);
    this.UXW = new MTimerHandler(Looper.getMainLooper(), new e.2(this), true);
    AppMethodBeat.o(125358);
  }
  
  private static void e(int paramInt1, int paramInt2, p paramp)
  {
    AppMethodBeat.i(125361);
    Log.i("MicroMsg.voipcs.VoipCSService", "Redirect response:" + paramInt1 + " errCode:" + paramInt2);
    if (paramInt2 != 0)
    {
      Log.i("MicroMsg.voipcs.VoipCSService", " redirect response with error code:".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(125361);
      return;
    }
    paramp = (gab)c.c.b(((com.tencent.mm.plugin.voip_cs.model.c.d)paramp).rr.otC);
    Log.i("MicroMsg.voipcs.VoipCSService", "roomid " + paramp.abKe + " key " + paramp.ZvA + "relay addr cnt " + paramp.YKL.size());
    Object localObject1 = paramp.YKL;
    paramp = new fzo();
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      fzs localfzs = (fzs)((Iterator)localObject2).next();
      fzn localfzn = new fzn();
      localfzn.abMn = localfzs.abmM;
      localfzn.abmN = localfzs.abmN;
      paramp.abXg.add(localfzn);
    }
    paramp.abXf = ((List)localObject1).size();
    localObject1 = new epf();
    localObject2 = new epe();
    ((epe)localObject2).ZrC = 0;
    ((epe)localObject2).ZrD = "";
    ((epe)localObject2).ZrE = "";
    ((epe)localObject2).ZrF = 4;
    ((epe)localObject2).ZrG = 4;
    ((epe)localObject2).ZrH = 2;
    ((epe)localObject2).abto = paramp;
    ((epe)localObject2).abtp = new fzo();
    ((epf)localObject1).abtr.add(localObject2);
    ((epf)localObject1).abtq = 1;
    paramp = null;
    try
    {
      localObject1 = ((epf)localObject1).toByteArray();
      paramp = (p)localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.voipcs.VoipCSService", "conn info to byte array fail..");
      }
    }
    if (paramp != null)
    {
      paramInt1 = c.idW().UYC.AddNewRelayConns(paramp, paramp.length, 1);
      if (paramInt1 != 0) {
        g.Loge("MicroMsg.voipcs.VoipCSService", "redirect relay conns fail ret:".concat(String.valueOf(paramInt1)));
      }
    }
    AppMethodBeat.o(125361);
  }
  
  public final void a(gag paramgag)
  {
    AppMethodBeat.i(125362);
    if ((paramgag.abXJ <= this.UXL) || (c.idX().UXR == 3))
    {
      AppMethodBeat.o(125362);
      return;
    }
    Log.i("MicroMsg.voipcs.VoipCSService", "get callee sync resp,notifySeq:" + paramgag.abXJ + ",calleeMemberId:" + paramgag.abXK + ",calleeStatus:" + paramgag.abXL + ",calleeSubStatus:" + paramgag.abXM + ",recv roomId:" + paramgag.abKe + ",recv roomKey:" + paramgag.ZvA);
    if ((c.idW().UYC.UDu != 0L) && (c.idW().UYC.UDu != paramgag.abKe))
    {
      Log.i("MicroMsg.voipcs.VoipCSService", "csRoomId:" + c.idW().UYC.UDu + ",recv roomId:" + paramgag.abKe + ",current and recv not equal!!");
      AppMethodBeat.o(125362);
      return;
    }
    this.UXL = paramgag.abXJ;
    this.UXh = paramgag.abXK;
    this.UXM = paramgag.abXL;
    this.UXN = paramgag.abXM;
    c.idY().UXh = this.UXh;
    if (this.UXM == 2)
    {
      Log.i("MicroMsg.voipcs.VoipCSService", "callee accept!");
      this.UXV.stopTimer();
      ied();
      c.idW().UYC.Hnt = paramgag.ZvA;
      Log.i("MicroMsg.voipcs.VoipCSService", "csroomId:" + paramgag.abKe + ",roomkey:" + paramgag.ZvA);
      if (paramgag.abXN != null) {}
      for (paramgag = paramgag.abXN.toByteArray();; paramgag = null)
      {
        this.UXO = paramgag;
        if (c.idW().UYC.field_capInfo != null) {
          break;
        }
        AppMethodBeat.o(125362);
        return;
      }
      if (this.UXO == null)
      {
        AppMethodBeat.o(125362);
        return;
      }
      c.idY().iea();
      c.idW().UYC.UDw = this.UXO;
      Log.i("MicroMsg.voipcs.VoipCSService", "calleeCapDump is " + Arrays.toString(c.idW().UYC.UDw));
      Log.i("MicroMsg.voipcs.VoipCSService", "calleeCap length:" + this.UXO.length);
      if ((c.idW().UYC.UDw != null) && (c.idW().UYC.exchangeCabInfo(c.idW().UYC.UDw, c.idW().UYC.UDw.length) < 0)) {
        Log.i("MicroMsg.voipcs.VoipCSService", "exchangeCabInfo fail!");
      }
      int i;
      if (c.idW().UYC.UDz == null)
      {
        i = 0;
        i = c.idW().UYC.setConfigInfo(c.idW().UYC.UDt, c.idW().UYC.UDu, c.idW().UYC.JHb, c.idW().UYC.Hnt, c.idW().UYC.field_peerId, 1, c.idW().UYC.UDA, c.idW().UYC.UDB, c.idW().UYC.UDy, i, c.idW().UYC.UDz, this.UXU, 1, c.idW().UYC.netType, c.idW().UYC.UFa, c.idW().UYC.UFb, 255, 0, 0, null, 0, 0, 0, 0, "", "", "");
        if (i != 0) {
          Log.e("MicroMsg.voipcs.VoipCSService", "setConfig fail, ret:%d", new Object[] { Integer.valueOf(i) });
        }
        if (c.idW().UYC.UFq != null) {
          break label764;
        }
        g.Loge("MicroMsg.voipcs.VoipCSService", "relay conns buf null");
      }
      for (;;)
      {
        if (this.UXW.stopped()) {
          this.UXW.startTimer(50000L);
        }
        c.idY().UXn = 1;
        AppMethodBeat.o(125362);
        return;
        i = c.idW().UYC.UDz.length;
        break;
        label764:
        i = c.idW().UYC.AddNewRelayConns(c.idW().UYC.UFq, c.idW().UYC.UFq.length, 0);
        if (i < 0) {
          g.Loge("MicroMsg.voipcs.VoipCSService", "add relayconns err:".concat(String.valueOf(i)));
        }
      }
    }
    if ((this.UXM != 0) && (this.UXM != 1) && (this.UXM == 3))
    {
      Log.i("MicroMsg.voipcs.VoipCSService", "callee hangup!");
      c.idY().dataType = 5;
      c.idY().idZ();
      c.idY().UXr = 2;
      if (this.UXN != 1) {
        break label907;
      }
      c.idY().UXj = 12;
    }
    for (;;)
    {
      if (this.UXK != null) {
        this.UXK.arC(1);
      }
      AppMethodBeat.o(125362);
      return;
      label907:
      if (this.UXN == 3) {
        c.idY().UXj = 99;
      }
    }
  }
  
  public final void bk(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(125360);
    Log.i("MicroMsg.voipcs.VoipCSService", "start netscene invite for username:" + paramString1 + ",appid:" + paramString2 + ",voipCSContext:" + paramString3);
    this.UXS = paramString1;
    this.UXR = 1;
    Object localObject1 = c.idY();
    Log.d("MicroMsg.VoipCSReportHelper", "markSendInvite");
    if (((d)localObject1).UXE == 0) {
      ((d)localObject1).UXE = ((int)(System.currentTimeMillis() / 1000L));
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
    com.tencent.mm.kernel.h.aZW().a(823, this);
    c.idW().UYC.JGW = ((int)(System.currentTimeMillis() / 1000L));
    paramString1 = new com.tencent.mm.plugin.voip_cs.model.c.c(c.idW().UYC.JGW, paramString1, c.idW().UYC.netType, (byte[])localObject1, c.idW().UYC.field_capInfo, paramString2);
    Log.i("MicroMsg.voipcs.VoipCSService", "capDump is " + Arrays.toString(c.idW().UYC.field_capInfo));
    com.tencent.mm.kernel.h.aZW().a(paramString1, 0);
    AppMethodBeat.o(125360);
  }
  
  public final void ied()
  {
    AppMethodBeat.i(125359);
    com.tencent.mm.kernel.h.aZW().a(818, this);
    com.tencent.mm.plugin.voip_cs.model.c.f localf = new com.tencent.mm.plugin.voip_cs.model.c.f(c.idW().UYC.UDu, c.idW().UYC.Hnt, this.UXL);
    com.tencent.mm.kernel.h.aZW().a(localf, 0);
    AppMethodBeat.o(125359);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(125363);
    Log.i("MicroMsg.voipcs.VoipCSService", "onSceneEnd :netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramp.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Object localObject1;
      if (paramp.getType() == 823)
      {
        paramp = (fzy)c.c.b(((com.tencent.mm.plugin.voip_cs.model.c.c)paramp).rr.otC);
        long l1 = paramp.abKe;
        long l2 = paramp.ZvA;
        Object localObject2 = paramp.YKL;
        localObject1 = paramp.abXI;
        this.JHd = paramp.abIU;
        this.UXU = paramp.abXH;
        Log.i("MicroMsg.voipcs.VoipCSService", "tcpStartCnt : " + this.UXU);
        c.idW().UYC.UDB = paramp.JHk;
        this.UXP = paramp.JHe;
        c.idW().UYC.UFa = paramp.JHp;
        c.idW().UYC.UFb = paramp.abne.toByteArray();
        c.idW().UYC.UDA = paramp.JHl;
        paramString = new fzo();
        Iterator localIterator = ((List)localObject2).iterator();
        fzs localfzs;
        fzn localfzn;
        while (localIterator.hasNext())
        {
          localfzs = (fzs)localIterator.next();
          localfzn = new fzn();
          localfzn.abMn = localfzs.abmM;
          localfzn.abmN = localfzs.abmN;
          paramString.abXg.add(localfzn);
        }
        paramString.abXf = ((List)localObject2).size();
        localObject2 = new fzo();
        localIterator = ((List)localObject1).iterator();
        while (localIterator.hasNext())
        {
          localfzs = (fzs)localIterator.next();
          localfzn = new fzn();
          localfzn.abMn = localfzs.abmM;
          localfzn.abmN = localfzs.abmN;
          ((fzo)localObject2).abXg.add(localfzn);
        }
        ((fzo)localObject2).abXf = ((List)localObject1).size();
        c.idW().UYC.UDu = l1;
        c.idW().UYC.Hnt = l2;
        Log.i("MicroMsg.voipcs.VoipCSService", "recv invite resp csRoomId : " + l1 + ",roomKey:" + l2);
        c.idW().UYC.UFk = paramp.abXF;
        c.idW().UYC.UFl = paramp.abXG;
        paramp = new gbe();
        paramp.vll = 0;
        paramp.Uzy = 0;
        paramp.Uzx = 0;
        paramp.userName = "";
        paramp.hPy = "";
        paramp = new epe();
        paramp.ZrC = 0;
        paramp.ZrD = "";
        paramp.ZrE = "";
        paramp.ZrF = 4;
        paramp.ZrG = 4;
        paramp.ZrH = 2;
        paramp.abto = paramString;
        paramp.abtp = ((fzo)localObject2);
        paramString = new epf();
        paramString.abtq = 1;
        paramString.abtr = new LinkedList();
        paramString.abtr.add(paramp);
        try
        {
          c.idW().UYC.UFq = paramString.toByteArray();
          paramString = c.idY();
          paramp = this.UXS;
          Log.d("MicroMsg.VoipCSReportHelper", "setVoipCSBaseInfo");
          paramString.roomId = l1;
          paramString.Hnt = l2;
          paramString.UXg = paramp;
          if (this.UXV.stopped())
          {
            if (this.JHd > 0) {
              this.UXV.startTimer(this.JHd * 1000);
            }
          }
          else
          {
            paramString = c.idY();
            Log.d("MicroMsg.VoipCSReportHelper", "markRecvInvite");
            if (paramString.UXE != 0) {
              paramString.UXF = ((int)(System.currentTimeMillis() / 1000L));
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
            this.UXV.startTimer(4000L);
          }
        }
      }
      if (paramp.getType() == 818)
      {
        paramString = (gag)c.c.b(((com.tencent.mm.plugin.voip_cs.model.c.f)paramp).rr.otC);
        Log.i("MicroMsg.voipcs.VoipCSService", "sync status = " + paramString.abXL + ",notifySeq = " + paramString.abXJ);
        a(paramString);
        AppMethodBeat.o(125363);
        return;
      }
      if (paramp.getType() == 880)
      {
        paramString = (fzu)c.c.b(((com.tencent.mm.plugin.voip_cs.model.c.a)paramp).rr.otC);
        if ((c.idW().UYC.UDu == paramString.abKe) && (c.idW().UYC.Hnt == paramString.ZvA)) {
          Log.i("MicroMsg.voipcs.VoipCSService", "hangup success!");
        }
        com.tencent.mm.kernel.h.aZW().b(880, this);
        c.idY().arD(com.tencent.mm.plugin.voip_cs.model.a.a.ief().wVi.ict());
        AppMethodBeat.o(125363);
        return;
      }
      if (paramp.getType() == 106)
      {
        localObject1 = (com.tencent.mm.plugin.messenger.a.f)paramp;
        paramp = "";
        paramString = "";
        if (((com.tencent.mm.plugin.messenger.a.f)localObject1).gaH() != null)
        {
          paramp = ((com.tencent.mm.plugin.messenger.a.f)localObject1).gaH().ZhO;
          paramString = ((com.tencent.mm.plugin.messenger.a.f)localObject1).gaH().aaIz.abwM;
        }
        for (;;)
        {
          this.UXK.nw(paramp, paramString);
          AppMethodBeat.o(125363);
          return;
          Log.i("MicroMsg.voipcs.VoipCSService", "search Or Recommend items is null or empty !");
        }
      }
      if (paramp.getType() == 285)
      {
        e(paramInt1, paramInt2, paramp);
        AppMethodBeat.o(125363);
        return;
      }
      if (paramp.getType() == 312)
      {
        paramString = (gae)c.c.b(((com.tencent.mm.plugin.voip_cs.model.c.e)paramp).rr.otC);
        if ((paramString.abKe == c.idW().UYC.UDu) && (paramString.ZvA == c.idW().UYC.Hnt)) {
          Log.i("MicroMsg.voipcs.VoipCSService", "report data success!");
        }
        AppMethodBeat.o(125363);
      }
    }
    else
    {
      Log.i("MicroMsg.voipcs.VoipCSService", "onSceneEnd  resp error!:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramp.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 != 0) && (paramInt1 != 4))
      {
        this.UXT = -1;
        this.UXK.oc(10);
        AppMethodBeat.o(125363);
        return;
      }
      if (paramp.getType() == 823)
      {
        if (paramInt2 == 406)
        {
          Log.i("MicroMsg.voipcs.VoipCSService", "CS_INVITE_RESP_REPEAT_INVTIE 503..");
          AppMethodBeat.o(125363);
          return;
        }
        c.idY().dataType = 1;
        this.UXT = 823;
        this.UXK.oc(paramInt2);
        AppMethodBeat.o(125363);
        return;
      }
      if ((paramp.getType() != 880) && (paramp.getType() != 818) && (paramp.getType() == 106)) {
        this.UXK.nw("", "");
      }
    }
    AppMethodBeat.o(125363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.model.e
 * JD-Core Version:    0.7.0.1
 */