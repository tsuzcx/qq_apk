package com.tencent.mm.plugin.voip_cs.c;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.plugin.voip_cs.c.c.f;
import com.tencent.mm.protocal.protobuf.cny;
import com.tencent.mm.protocal.protobuf.cnz;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.dqy;
import com.tencent.mm.protocal.protobuf.dqz;
import com.tencent.mm.protocal.protobuf.drd;
import com.tencent.mm.protocal.protobuf.drf;
import com.tencent.mm.protocal.protobuf.drj;
import com.tencent.mm.protocal.protobuf.drm;
import com.tencent.mm.protocal.protobuf.drp;
import com.tencent.mm.protocal.protobuf.drr;
import com.tencent.mm.protocal.protobuf.dsp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  implements com.tencent.mm.ak.g
{
  public int ABU;
  public int AUy;
  public b AVb;
  public int AVc;
  public int AVd;
  public int AVe;
  public byte[] AVf;
  public int AVg;
  public int AVh;
  public int AVi;
  public String AVj;
  public int AVk;
  public int AVl;
  public au AVm;
  public au AVn;
  public int tIP;
  
  public e()
  {
    AppMethodBeat.i(125358);
    this.AVc = 0;
    this.AUy = 0;
    this.AVd = 0;
    this.AVe = 0;
    this.AVf = null;
    this.tIP = 0;
    this.AVg = 0;
    this.AVh = 0;
    this.AVi = 0;
    this.AVj = "";
    this.ABU = 0;
    this.AVk = 0;
    this.AVl = 999;
    this.AVm = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125356);
        ac.v("MicroMsg.voipcs.VoipCSService", "voipcs repeat sync");
        e.this.enK();
        AppMethodBeat.o(125356);
        return true;
      }
    }, true);
    this.AVn = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125357);
        ac.v("MicroMsg.voipcs.VoipCSService", "voipcs heart beat");
        Object localObject = e.this;
        com.tencent.mm.kernel.g.agi().a(795, (com.tencent.mm.ak.g)localObject);
        localObject = new com.tencent.mm.plugin.voip_cs.c.c.b(c.enC().AVR.AGg, c.enC().AVR.tIG);
        com.tencent.mm.kernel.g.agi().a((n)localObject, 0);
        AppMethodBeat.o(125357);
        return true;
      }
    }, true);
    AppMethodBeat.o(125358);
  }
  
  private static void c(int paramInt1, int paramInt2, n paramn)
  {
    AppMethodBeat.i(125361);
    ac.i("MicroMsg.voipcs.VoipCSService", "Redirect response:" + paramInt1 + " errCode:" + paramInt2);
    if (paramInt2 != 0)
    {
      ac.i("MicroMsg.voipcs.VoipCSService", " redirect response with error code:".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(125361);
      return;
    }
    paramn = (drm)((com.tencent.mm.plugin.voip_cs.c.c.d)paramn).rr.hvs.hvw;
    ac.i("MicroMsg.voipcs.VoipCSService", "roomid " + paramn.FOh + " key " + paramn.Exg + "relay addr cnt " + paramn.DVd.size());
    Object localObject1 = paramn.DVd;
    paramn = new dqz();
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      drd localdrd = (drd)((Iterator)localObject2).next();
      dqy localdqy = new dqy();
      localdqy.FPS = localdrd.Fgt;
      localdqy.FvP = localdrd.FvP;
      paramn.FYx.add(localdqy);
    }
    paramn.FYw = ((List)localObject1).size();
    localObject1 = new cnz();
    localObject2 = new cny();
    ((cny)localObject2).Evo = 0;
    ((cny)localObject2).Evp = "";
    ((cny)localObject2).Evq = "";
    ((cny)localObject2).Evr = 4;
    ((cny)localObject2).Evs = 4;
    ((cny)localObject2).Evt = 2;
    ((cny)localObject2).FBc = paramn;
    ((cny)localObject2).FBd = new dqz();
    ((cnz)localObject1).FBf.add(localObject2);
    ((cnz)localObject1).FBe = 1;
    paramn = null;
    try
    {
      localObject1 = ((cnz)localObject1).toByteArray();
      paramn = (n)localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.voipcs.VoipCSService", "conn info to byte array fail..");
      }
    }
    if (paramn != null)
    {
      paramInt1 = c.enC().AVR.AddNewRelayConns(paramn, paramn.length, 1);
      if (paramInt1 != 0) {
        com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.voipcs.VoipCSService", "redirect relay conns fail ret:".concat(String.valueOf(paramInt1)));
      }
    }
    AppMethodBeat.o(125361);
  }
  
  public final void a(drr paramdrr)
  {
    AppMethodBeat.i(125362);
    if ((paramdrr.FZa <= this.AVc) || (c.enD().AVi == 3))
    {
      AppMethodBeat.o(125362);
      return;
    }
    ac.i("MicroMsg.voipcs.VoipCSService", "get callee sync resp,notifySeq:" + paramdrr.FZa + ",calleeMemberId:" + paramdrr.FZb + ",calleeStatus:" + paramdrr.FZc + ",calleeSubStatus:" + paramdrr.FZd + ",recv roomId:" + paramdrr.FOh + ",recv roomKey:" + paramdrr.Exg);
    if ((c.enC().AVR.AGg != 0L) && (c.enC().AVR.AGg != paramdrr.FOh))
    {
      ac.i("MicroMsg.voipcs.VoipCSService", "csRoomId:" + c.enC().AVR.AGg + ",recv roomId:" + paramdrr.FOh + ",current and recv not equal!!");
      AppMethodBeat.o(125362);
      return;
    }
    this.AVc = paramdrr.FZa;
    this.AUy = paramdrr.FZb;
    this.AVd = paramdrr.FZc;
    this.AVe = paramdrr.FZd;
    c.enE().AUy = this.AUy;
    if (this.AVd == 2)
    {
      ac.i("MicroMsg.voipcs.VoipCSService", "callee accept!");
      this.AVm.stopTimer();
      enK();
      c.enC().AVR.tIG = paramdrr.Exg;
      ac.i("MicroMsg.voipcs.VoipCSService", "csroomId:" + paramdrr.FOh + ",roomkey:" + paramdrr.Exg);
      if (paramdrr.FZe != null) {}
      for (paramdrr = paramdrr.FZe.toByteArray();; paramdrr = null)
      {
        this.AVf = paramdrr;
        if (c.enC().AVR.field_capInfo != null) {
          break;
        }
        AppMethodBeat.o(125362);
        return;
      }
      if (this.AVf == null)
      {
        AppMethodBeat.o(125362);
        return;
      }
      c.enE().enG();
      c.enC().AVR.AGi = this.AVf;
      ac.i("MicroMsg.voipcs.VoipCSService", "calleeCapDump is " + Arrays.toString(c.enC().AVR.AGi));
      ac.i("MicroMsg.voipcs.VoipCSService", "calleeCap length:" + this.AVf.length);
      if ((c.enC().AVR.AGi != null) && (c.enC().AVR.exchangeCabInfo(c.enC().AVR.AGi, c.enC().AVR.AGi.length) < 0)) {
        ac.i("MicroMsg.voipcs.VoipCSService", "exchangeCabInfo fail!");
      }
      int i;
      if (c.enC().AVR.AGl == null)
      {
        i = 0;
        i = c.enC().AVR.setConfigInfo(c.enC().AVR.AGf, c.enC().AVR.AGg, c.enC().AVR.tIN, c.enC().AVR.tIG, c.enC().AVR.field_peerId, 1, c.enC().AVR.AGm, c.enC().AVR.AGn, c.enC().AVR.AGk, i, c.enC().AVR.AGl, this.AVl, 1, c.enC().AVR.netType, c.enC().AVR.AHt, c.enC().AVR.AHu, 255, 0, 0, null, 0, 0, 0, 0, "", "", 0);
        if (i != 0) {
          ac.e("MicroMsg.voipcs.VoipCSService", "setConfig fail, ret:%d", new Object[] { Integer.valueOf(i) });
        }
        if (c.enC().AVR.AHI != null) {
          break label766;
        }
        com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.voipcs.VoipCSService", "relay conns buf null");
      }
      for (;;)
      {
        if (this.AVn.eVs()) {
          this.AVn.au(50000L, 50000L);
        }
        c.enE().AUE = 1;
        AppMethodBeat.o(125362);
        return;
        i = c.enC().AVR.AGl.length;
        break;
        label766:
        i = c.enC().AVR.AddNewRelayConns(c.enC().AVR.AHI, c.enC().AVR.AHI.length, 0);
        if (i < 0) {
          com.tencent.mm.plugin.voip.b.d.Loge("MicroMsg.voipcs.VoipCSService", "add relayconns err:".concat(String.valueOf(i)));
        }
      }
    }
    if ((this.AVd != 0) && (this.AVd != 1) && (this.AVd == 3))
    {
      ac.i("MicroMsg.voipcs.VoipCSService", "callee hangup!");
      c.enE().dataType = 5;
      c.enE().enF();
      c.enE().AUI = 2;
      if (this.AVe != 1) {
        break label909;
      }
      c.enE().AUA = 12;
    }
    for (;;)
    {
      if (this.AVb != null) {
        this.AVb.Ti(1);
      }
      AppMethodBeat.o(125362);
      return;
      label909:
      if (this.AVe == 3) {
        c.enE().AUA = 99;
      }
    }
  }
  
  public final void aG(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(125360);
    ac.i("MicroMsg.voipcs.VoipCSService", "start netscene invite for username:" + paramString1 + ",appid:" + paramString2 + ",voipCSContext:" + paramString3);
    this.AVj = paramString1;
    this.AVi = 1;
    Object localObject1 = c.enE();
    ac.d("MicroMsg.VoipCSReportHelper", "markSendInvite");
    if (((d)localObject1).AUV == 0) {
      ((d)localObject1).AUV = ((int)(System.currentTimeMillis() / 1000L));
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
    com.tencent.mm.kernel.g.agi().a(823, this);
    c.enC().AVR.tII = ((int)(System.currentTimeMillis() / 1000L));
    paramString1 = new com.tencent.mm.plugin.voip_cs.c.c.c(c.enC().AVR.tII, paramString1, c.enC().AVR.netType, (byte[])localObject1, c.enC().AVR.field_capInfo, paramString2);
    ac.i("MicroMsg.voipcs.VoipCSService", "capDump is " + Arrays.toString(c.enC().AVR.field_capInfo));
    com.tencent.mm.kernel.g.agi().a(paramString1, 0);
    AppMethodBeat.o(125360);
  }
  
  public final int enJ()
  {
    return this.AVi;
  }
  
  public final void enK()
  {
    AppMethodBeat.i(125359);
    com.tencent.mm.kernel.g.agi().a(818, this);
    f localf = new f(c.enC().AVR.AGg, c.enC().AVR.tIG, this.AVc);
    com.tencent.mm.kernel.g.agi().a(localf, 0);
    AppMethodBeat.o(125359);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(125363);
    ac.i("MicroMsg.voipcs.VoipCSService", "onSceneEnd :netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Object localObject1;
      if (paramn.getType() == 823)
      {
        paramn = (drj)((com.tencent.mm.plugin.voip_cs.c.c.c)paramn).rr.hvs.hvw;
        long l1 = paramn.FOh;
        long l2 = paramn.Exg;
        Object localObject2 = paramn.DVd;
        localObject1 = paramn.FYZ;
        this.tIP = paramn.FMY;
        this.AVl = paramn.FYY;
        ac.i("MicroMsg.voipcs.VoipCSService", "tcpStartCnt : " + this.AVl);
        c.enC().AVR.AGn = paramn.tIW;
        this.AVg = paramn.tIQ;
        c.enC().AVR.AHt = paramn.tJb;
        c.enC().AVR.AHu = paramn.Fwg.toByteArray();
        c.enC().AVR.AGm = paramn.tIX;
        paramString = new dqz();
        Iterator localIterator = ((List)localObject2).iterator();
        drd localdrd;
        dqy localdqy;
        while (localIterator.hasNext())
        {
          localdrd = (drd)localIterator.next();
          localdqy = new dqy();
          localdqy.FPS = localdrd.Fgt;
          localdqy.FvP = localdrd.FvP;
          paramString.FYx.add(localdqy);
        }
        paramString.FYw = ((List)localObject2).size();
        localObject2 = new dqz();
        localIterator = ((List)localObject1).iterator();
        while (localIterator.hasNext())
        {
          localdrd = (drd)localIterator.next();
          localdqy = new dqy();
          localdqy.FPS = localdrd.Fgt;
          localdqy.FvP = localdrd.FvP;
          ((dqz)localObject2).FYx.add(localdqy);
        }
        ((dqz)localObject2).FYw = ((List)localObject1).size();
        c.enC().AVR.AGg = l1;
        c.enC().AVR.tIG = l2;
        ac.i("MicroMsg.voipcs.VoipCSService", "recv invite resp csRoomId : " + l1 + ",roomKey:" + l2);
        c.enC().AVR.AHD = paramn.FYW;
        c.enC().AVR.AHE = paramn.FYX;
        paramn = new dsp();
        paramn.ngZ = 0;
        paramn.ACo = 0;
        paramn.ACn = 0;
        paramn.userName = "";
        paramn.dlV = "";
        paramn = new cny();
        paramn.Evo = 0;
        paramn.Evp = "";
        paramn.Evq = "";
        paramn.Evr = 4;
        paramn.Evs = 4;
        paramn.Evt = 2;
        paramn.FBc = paramString;
        paramn.FBd = ((dqz)localObject2);
        paramString = new cnz();
        paramString.FBe = 1;
        paramString.FBf = new LinkedList();
        paramString.FBf.add(paramn);
        try
        {
          c.enC().AVR.AHI = paramString.toByteArray();
          paramString = c.enE();
          paramn = this.AVj;
          ac.d("MicroMsg.VoipCSReportHelper", "setVoipCSBaseInfo");
          paramString.roomId = l1;
          paramString.tIG = l2;
          paramString.AUx = paramn;
          if (this.AVm.eVs())
          {
            if (this.tIP > 0)
            {
              paramString = this.AVm;
              l1 = this.tIP * 1000;
              paramString.au(l1, l1);
            }
          }
          else
          {
            paramString = c.enE();
            ac.d("MicroMsg.VoipCSReportHelper", "markRecvInvite");
            if (paramString.AUV != 0) {
              paramString.AUW = ((int)(System.currentTimeMillis() / 1000L));
            }
            AppMethodBeat.o(125363);
            return;
          }
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            ac.e("MicroMsg.voipcs.VoipCSService", "relay conn info to byte array fail..");
            continue;
            this.AVm.au(4000L, 4000L);
          }
        }
      }
      if (paramn.getType() == 818)
      {
        paramString = (drr)((f)paramn).rr.hvs.hvw;
        ac.i("MicroMsg.voipcs.VoipCSService", "sync status = " + paramString.FZc + ",notifySeq = " + paramString.FZa);
        a(paramString);
        AppMethodBeat.o(125363);
        return;
      }
      if (paramn.getType() == 880)
      {
        paramString = (drf)((com.tencent.mm.plugin.voip_cs.c.c.a)paramn).rr.hvs.hvw;
        if ((c.enC().AVR.AGg == paramString.FOh) && (c.enC().AVR.tIG == paramString.Exg)) {
          ac.i("MicroMsg.voipcs.VoipCSService", "hangup success!");
        }
        com.tencent.mm.kernel.g.agi().b(880, this);
        c.enE().Tj(com.tencent.mm.plugin.voip_cs.c.a.a.enM().oue.emJ());
        AppMethodBeat.o(125363);
        return;
      }
      if (paramn.getType() == 106)
      {
        localObject1 = (com.tencent.mm.plugin.messenger.a.g)paramn;
        paramn = "";
        paramString = "";
        if (((com.tencent.mm.plugin.messenger.a.g)localObject1).dcj() != null)
        {
          paramn = ((com.tencent.mm.plugin.messenger.a.g)localObject1).dcj().Eof;
          paramString = ((com.tencent.mm.plugin.messenger.a.g)localObject1).dcj().Fbd.FEm;
        }
        for (;;)
        {
          this.AVb.jU(paramn, paramString);
          AppMethodBeat.o(125363);
          return;
          ac.i("MicroMsg.voipcs.VoipCSService", "search Or Recommend items is null or empty !");
        }
      }
      if (paramn.getType() == 285)
      {
        c(paramInt1, paramInt2, paramn);
        AppMethodBeat.o(125363);
        return;
      }
      if (paramn.getType() == 312)
      {
        paramString = (drp)((com.tencent.mm.plugin.voip_cs.c.c.e)paramn).rr.hvs.hvw;
        if ((paramString.FOh == c.enC().AVR.AGg) && (paramString.Exg == c.enC().AVR.tIG)) {
          ac.i("MicroMsg.voipcs.VoipCSService", "report data success!");
        }
        AppMethodBeat.o(125363);
      }
    }
    else
    {
      ac.i("MicroMsg.voipcs.VoipCSService", "onSceneEnd  resp error!:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 != 0) && (paramInt1 != 4))
      {
        this.AVk = -1;
        this.AVb.onError(10);
        AppMethodBeat.o(125363);
        return;
      }
      if (paramn.getType() == 823)
      {
        if (paramInt2 == 406)
        {
          ac.i("MicroMsg.voipcs.VoipCSService", "CS_INVITE_RESP_REPEAT_INVTIE 503..");
          AppMethodBeat.o(125363);
          return;
        }
        c.enE().dataType = 1;
        this.AVk = 823;
        this.AVb.onError(paramInt2);
        AppMethodBeat.o(125363);
        return;
      }
      if ((paramn.getType() != 880) && (paramn.getType() != 818) && (paramn.getType() == 106)) {
        this.AVb.jU("", "");
      }
    }
    AppMethodBeat.o(125363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.e
 * JD-Core Version:    0.7.0.1
 */