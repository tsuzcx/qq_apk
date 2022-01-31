package com.tencent.mm.plugin.voip_cs.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip.video.h;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.crn;
import com.tencent.mm.protocal.protobuf.crr;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.protocal.protobuf.crx;
import com.tencent.mm.protocal.protobuf.csa;
import com.tencent.mm.protocal.protobuf.csd;
import com.tencent.mm.protocal.protobuf.csf;
import com.tencent.mm.protocal.protobuf.csx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  implements com.tencent.mm.ai.f
{
  public int nNj;
  public b tKH;
  public int tKI;
  public int tKJ;
  public int tKK;
  public byte[] tKL;
  public int tKM;
  public int tKN;
  public int tKO;
  public String tKP;
  public int tKQ;
  public int tKR;
  public ap tKS;
  public ap tKT;
  public int tKe;
  public int tvt;
  
  public e()
  {
    AppMethodBeat.i(135306);
    this.tKI = 0;
    this.tKe = 0;
    this.tKJ = 0;
    this.tKK = 0;
    this.tKL = null;
    this.nNj = 0;
    this.tKM = 0;
    this.tKN = 0;
    this.tKO = 0;
    this.tKP = "";
    this.tvt = 0;
    this.tKQ = 0;
    this.tKR = 999;
    this.tKS = new ap(Looper.getMainLooper(), new e.1(this), true);
    this.tKT = new ap(Looper.getMainLooper(), new e.2(this), true);
    AppMethodBeat.o(135306);
  }
  
  private static void b(int paramInt1, int paramInt2, m paramm)
  {
    AppMethodBeat.i(135309);
    ab.i("MicroMsg.voipcs.VoipCSService", "Redirect response:" + paramInt1 + " errCode:" + paramInt2);
    if (paramInt2 != 0)
    {
      ab.i("MicroMsg.voipcs.VoipCSService", " redirect response with error code:".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(135309);
      return;
    }
    paramm = (csa)((com.tencent.mm.plugin.voip_cs.b.c.d)paramm).rr.fsW.fta;
    ab.i("MicroMsg.voipcs.VoipCSService", "roomid " + paramm.xSP + " key " + paramm.wQQ + "relay addr cnt " + paramm.wtb.size());
    paramm = paramm.wtb;
    crn localcrn = new crn();
    Iterator localIterator = paramm.iterator();
    while (localIterator.hasNext())
    {
      crr localcrr = (crr)localIterator.next();
      crm localcrm = new crm();
      c.cQm();
      localcrm.xTC = com.tencent.mm.plugin.voip_cs.b.b.a.aeO(localcrr.xpV);
      localcrm.xCi = localcrr.xCi;
      localcrn.yal.add(localcrm);
    }
    localcrn.yak = paramm.size();
    c.cQm().tLy.a(localcrn, localcrn, null, 0, 0);
    AppMethodBeat.o(135309);
  }
  
  public final void a(csf paramcsf)
  {
    AppMethodBeat.i(135310);
    if ((paramcsf.yaP <= this.tKI) || (c.cQn().tKO == 3))
    {
      AppMethodBeat.o(135310);
      return;
    }
    ab.i("MicroMsg.voipcs.VoipCSService", "get callee sync resp,notifySeq:" + paramcsf.yaP + ",calleeMemberId:" + paramcsf.yaQ + ",calleeStatus:" + paramcsf.yaR + ",calleeSubStatus:" + paramcsf.yaS + ",recv roomId:" + paramcsf.xSP + ",recv roomKey:" + paramcsf.wQQ);
    if ((c.cQm().tLy.tAb != 0L) && (c.cQm().tLy.tAb != paramcsf.xSP))
    {
      ab.i("MicroMsg.voipcs.VoipCSService", "csRoomId:" + c.cQm().tLy.tAb + ",recv roomId:" + paramcsf.xSP + ",current and recv not equal!!");
      AppMethodBeat.o(135310);
      return;
    }
    this.tKI = paramcsf.yaP;
    this.tKe = paramcsf.yaQ;
    this.tKJ = paramcsf.yaR;
    this.tKK = paramcsf.yaS;
    c.cQo().tKe = this.tKe;
    if (this.tKJ == 2)
    {
      ab.i("MicroMsg.voipcs.VoipCSService", "callee accept!");
      this.tKS.stopTimer();
      cQt();
      c.cQm().tLy.nNa = paramcsf.wQQ;
      ab.i("MicroMsg.voipcs.VoipCSService", "csroomId:" + paramcsf.xSP + ",roomkey:" + paramcsf.wQQ);
      if (paramcsf.yaT != null) {}
      for (paramcsf = paramcsf.yaT.toByteArray();; paramcsf = null)
      {
        this.tKL = paramcsf;
        if (c.cQm().tLy.field_capInfo != null) {
          break;
        }
        AppMethodBeat.o(135310);
        return;
      }
      if (this.tKL == null)
      {
        AppMethodBeat.o(135310);
        return;
      }
      c.cQo().cQq();
      c.cQm().tLy.tAd = this.tKL;
      ab.i("MicroMsg.voipcs.VoipCSService", "calleeCapDump is " + Arrays.toString(c.cQm().tLy.tAd));
      ab.i("MicroMsg.voipcs.VoipCSService", "calleeCap length:" + this.tKL.length);
      if ((c.cQm().tLy.tAd != null) && (c.cQm().tLy.exchangeCabInfo(c.cQm().tLy.tAd, c.cQm().tLy.tAd.length) < 0)) {
        ab.i("MicroMsg.voipcs.VoipCSService", "exchangeCabInfo fail!");
      }
      if (c.cQm().tLy.tAg == null) {}
      for (int i = 0;; i = c.cQm().tLy.tAg.length)
      {
        i = c.cQm().tLy.setConfigInfo(c.cQm().tLy.tAa, c.cQm().tLy.tAb, c.cQm().tLy.nNh, c.cQm().tLy.nNa, c.cQm().tLy.field_peerId, 1, c.cQm().tLy.tAh, c.cQm().tLy.tAi, c.cQm().tLy.tAf, i, c.cQm().tLy.tAg, this.tKR, 1, c.cQm().tLy.netType, c.cQm().tLy.tBe, c.cQm().tLy.tBf, 255, 0, 0, null, 0);
        if (i != 0) {
          ab.e("MicroMsg.voipcs.VoipCSService", "setConfig fail, ret:%d", new Object[] { Integer.valueOf(i) });
        }
        i = c.cQm().tLy.connectToPeer();
        if (i != 0) {
          ab.e("MicroMsg.voipcs.VoipCSService", "connectToPeer fail, ret:%d", new Object[] { Integer.valueOf(i) });
        }
        if (this.tKT.dtj()) {
          this.tKT.ag(50000L, 50000L);
        }
        c.cQo().tKk = 1;
        AppMethodBeat.o(135310);
        return;
      }
    }
    if ((this.tKJ != 0) && (this.tKJ != 1) && (this.tKJ == 3))
    {
      ab.i("MicroMsg.voipcs.VoipCSService", "callee hangup!");
      c.cQo().dataType = 5;
      c.cQo().cQp();
      c.cQo().tKo = 2;
      if (this.tKK != 1) {
        break label855;
      }
      c.cQo().tKg = 12;
    }
    for (;;)
    {
      if (this.tKH != null) {
        this.tKH.Ic(1);
      }
      AppMethodBeat.o(135310);
      return;
      label855:
      if (this.tKK == 3) {
        c.cQo().tKg = 99;
      }
    }
  }
  
  public final void as(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(135308);
    ab.i("MicroMsg.voipcs.VoipCSService", "start netscene invite for username:" + paramString1 + ",appid:" + paramString2 + ",voipCSContext:" + paramString3);
    this.tKP = paramString1;
    this.tKO = 1;
    Object localObject1 = c.cQo();
    ab.d("MicroMsg.VoipCSReportHelper", "markSendInvite");
    if (((d)localObject1).tKB == 0) {
      ((d)localObject1).tKB = ((int)(System.currentTimeMillis() / 1000L));
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
    g.Rc().a(823, this);
    c.cQm().tLy.nNc = ((int)(System.currentTimeMillis() / 1000L));
    paramString1 = new com.tencent.mm.plugin.voip_cs.b.c.c(c.cQm().tLy.nNc, paramString1, c.cQm().tLy.netType, (byte[])localObject1, c.cQm().tLy.field_capInfo, paramString2);
    ab.i("MicroMsg.voipcs.VoipCSService", "capDump is " + Arrays.toString(c.cQm().tLy.field_capInfo));
    g.Rc().a(paramString1, 0);
    AppMethodBeat.o(135308);
  }
  
  public final void cQt()
  {
    AppMethodBeat.i(135307);
    g.Rc().a(818, this);
    com.tencent.mm.plugin.voip_cs.b.c.f localf = new com.tencent.mm.plugin.voip_cs.b.c.f(c.cQm().tLy.tAb, c.cQm().tLy.nNa, this.tKI);
    g.Rc().a(localf, 0);
    AppMethodBeat.o(135307);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(135311);
    ab.i("MicroMsg.voipcs.VoipCSService", "onSceneEnd :netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Object localObject1;
      if (paramm.getType() == 823)
      {
        paramm = (crx)((com.tencent.mm.plugin.voip_cs.b.c.c)paramm).rr.fsW.fta;
        long l1 = paramm.xSP;
        long l2 = paramm.wQQ;
        Object localObject2 = paramm.wtb;
        localObject1 = paramm.yaO;
        this.nNj = paramm.xRC;
        this.tKR = paramm.yaN;
        ab.i("MicroMsg.voipcs.VoipCSService", "tcpStartCnt : " + this.tKR);
        c.cQm().tLy.tAi = paramm.nNq;
        this.tKM = paramm.nNk;
        c.cQm().tLy.tBe = paramm.nNv;
        c.cQm().tLy.tBf = paramm.xCz.toByteArray();
        c.cQm().tLy.tAh = paramm.nNr;
        paramString = new crn();
        Iterator localIterator = ((List)localObject2).iterator();
        crr localcrr;
        crm localcrm;
        while (localIterator.hasNext())
        {
          localcrr = (crr)localIterator.next();
          localcrm = new crm();
          c.cQm();
          localcrm.xTC = com.tencent.mm.plugin.voip_cs.b.b.a.aeO(localcrr.xpV);
          localcrm.xCi = localcrr.xCi;
          paramString.yal.add(localcrm);
        }
        paramString.yak = ((List)localObject2).size();
        localObject2 = new crn();
        localIterator = ((List)localObject1).iterator();
        while (localIterator.hasNext())
        {
          localcrr = (crr)localIterator.next();
          localcrm = new crm();
          c.cQm();
          localcrm.xTC = com.tencent.mm.plugin.voip_cs.b.b.a.aeO(localcrr.xpV);
          localcrm.xCi = localcrr.xCi;
          ((crn)localObject2).yal.add(localcrm);
        }
        ((crn)localObject2).yak = ((List)localObject1).size();
        c.cQm().tLy.tAb = l1;
        c.cQm().tLy.nNa = l2;
        ab.i("MicroMsg.voipcs.VoipCSService", "recv invite resp csRoomId : " + l1 + ",roomKey:" + l2);
        c.cQm().tLy.tBo = paramm.yaL;
        c.cQm().tLy.tBp = paramm.yaM;
        paramm = new csx();
        paramm.ybW = 0;
        paramm.ybX = 0;
        paramm.ybY = 0;
        paramm.userName = "";
        paramm.gFE = "";
        if (c.cQm().tLy.a(paramString, paramString, paramString, paramm, null) != 0) {
          ab.i("MicroMsg.voipcs.VoipCSService", "setIp fail!");
        }
        paramString = c.cQo();
        paramm = this.tKP;
        ab.d("MicroMsg.VoipCSReportHelper", "setVoipCSBaseInfo");
        paramString.tKc = l1;
        paramString.nNa = l2;
        paramString.tKd = paramm;
        if (this.tKS.dtj())
        {
          if (this.nNj <= 0) {
            break label693;
          }
          paramString = this.tKS;
          l1 = this.nNj * 1000;
          paramString.ag(l1, l1);
        }
        for (;;)
        {
          paramString = c.cQo();
          ab.d("MicroMsg.VoipCSReportHelper", "markRecvInvite");
          if (paramString.tKB != 0) {
            paramString.tKC = ((int)(System.currentTimeMillis() / 1000L));
          }
          AppMethodBeat.o(135311);
          return;
          label693:
          this.tKS.ag(4000L, 4000L);
        }
      }
      if (paramm.getType() == 818)
      {
        paramString = (csf)((com.tencent.mm.plugin.voip_cs.b.c.f)paramm).rr.fsW.fta;
        ab.i("MicroMsg.voipcs.VoipCSService", "sync status = " + paramString.yaR + ",notifySeq = " + paramString.yaP);
        a(paramString);
        AppMethodBeat.o(135311);
        return;
      }
      if (paramm.getType() == 880)
      {
        paramString = (crt)((com.tencent.mm.plugin.voip_cs.b.c.a)paramm).rr.fsW.fta;
        if ((c.cQm().tLy.tAb == paramString.xSP) && (c.cQm().tLy.nNa == paramString.wQQ)) {
          ab.i("MicroMsg.voipcs.VoipCSService", "hangup success!");
        }
        g.Rc().b(880, this);
        c.cQo().Id(com.tencent.mm.plugin.voip_cs.b.a.a.cQv().tzl.cPO());
        AppMethodBeat.o(135311);
        return;
      }
      if (paramm.getType() == 106)
      {
        localObject1 = (com.tencent.mm.plugin.messenger.a.f)paramm;
        paramm = "";
        paramString = "";
        if (((com.tencent.mm.plugin.messenger.a.f)localObject1).bPI() != null)
        {
          paramm = ((com.tencent.mm.plugin.messenger.a.f)localObject1).bPI().wJq;
          paramString = ((com.tencent.mm.plugin.messenger.a.f)localObject1).bPI().xmi.xJE;
        }
        for (;;)
        {
          this.tKH.gU(paramm, paramString);
          AppMethodBeat.o(135311);
          return;
          ab.i("MicroMsg.voipcs.VoipCSService", "search Or Recommend items is null or empty !");
        }
      }
      if (paramm.getType() == 285)
      {
        b(paramInt1, paramInt2, paramm);
        AppMethodBeat.o(135311);
        return;
      }
      if (paramm.getType() == 312)
      {
        paramString = (csd)((com.tencent.mm.plugin.voip_cs.b.c.e)paramm).rr.fsW.fta;
        if ((paramString.xSP == c.cQm().tLy.tAb) && (paramString.wQQ == c.cQm().tLy.nNa)) {
          ab.i("MicroMsg.voipcs.VoipCSService", "report data success!");
        }
        AppMethodBeat.o(135311);
      }
    }
    else
    {
      ab.i("MicroMsg.voipcs.VoipCSService", "onSceneEnd  resp error!:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 != 0) && (paramInt1 != 4))
      {
        this.tKQ = -1;
        this.tKH.onError(10);
        AppMethodBeat.o(135311);
        return;
      }
      if (paramm.getType() == 823)
      {
        if (paramInt2 == 406)
        {
          ab.i("MicroMsg.voipcs.VoipCSService", "CS_INVITE_RESP_REPEAT_INVTIE 503..");
          AppMethodBeat.o(135311);
          return;
        }
        c.cQo().dataType = 1;
        this.tKQ = 823;
        this.tKH.onError(paramInt2);
        AppMethodBeat.o(135311);
        return;
      }
      if ((paramm.getType() != 880) && (paramm.getType() != 818) && (paramm.getType() == 106)) {
        this.tKH.gU("", "");
      }
    }
    AppMethodBeat.o(135311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.e
 * JD-Core Version:    0.7.0.1
 */