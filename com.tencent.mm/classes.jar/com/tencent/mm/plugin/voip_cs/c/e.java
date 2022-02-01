package com.tencent.mm.plugin.voip_cs.c;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.protocal.protobuf.ctv;
import com.tencent.mm.protocal.protobuf.ctw;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.cyw;
import com.tencent.mm.protocal.protobuf.dyj;
import com.tencent.mm.protocal.protobuf.dyk;
import com.tencent.mm.protocal.protobuf.dyo;
import com.tencent.mm.protocal.protobuf.dyq;
import com.tencent.mm.protocal.protobuf.dyu;
import com.tencent.mm.protocal.protobuf.dyx;
import com.tencent.mm.protocal.protobuf.dza;
import com.tencent.mm.protocal.protobuf.dzc;
import com.tencent.mm.protocal.protobuf.eaa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  implements com.tencent.mm.ak.f
{
  public b CMO;
  public int CMP;
  public int CMQ;
  public int CMR;
  public byte[] CMS;
  public int CMT;
  public int CMU;
  public int CMV;
  public String CMW;
  public int CMX;
  public int CMY;
  public aw CMZ;
  public int CMl;
  public aw CNa;
  public int Csu;
  public int uXp;
  
  public e()
  {
    AppMethodBeat.i(125358);
    this.CMP = 0;
    this.CMl = 0;
    this.CMQ = 0;
    this.CMR = 0;
    this.CMS = null;
    this.uXp = 0;
    this.CMT = 0;
    this.CMU = 0;
    this.CMV = 0;
    this.CMW = "";
    this.Csu = 0;
    this.CMX = 0;
    this.CMY = 999;
    this.CMZ = new aw(Looper.getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125356);
        ae.v("MicroMsg.voipcs.VoipCSService", "voipcs repeat sync");
        e.this.eFr();
        AppMethodBeat.o(125356);
        return true;
      }
    }, true);
    this.CNa = new aw(Looper.getMainLooper(), new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125357);
        ae.v("MicroMsg.voipcs.VoipCSService", "voipcs heart beat");
        Object localObject = e.this;
        g.ajj().a(795, (com.tencent.mm.ak.f)localObject);
        localObject = new com.tencent.mm.plugin.voip_cs.c.c.b(c.eFj().CNE.CwH, c.eFj().CNE.uXg);
        g.ajj().a((n)localObject, 0);
        AppMethodBeat.o(125357);
        return true;
      }
    }, true);
    AppMethodBeat.o(125358);
  }
  
  private static void c(int paramInt1, int paramInt2, n paramn)
  {
    AppMethodBeat.i(125361);
    ae.i("MicroMsg.voipcs.VoipCSService", "Redirect response:" + paramInt1 + " errCode:" + paramInt2);
    if (paramInt2 != 0)
    {
      ae.i("MicroMsg.voipcs.VoipCSService", " redirect response with error code:".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(125361);
      return;
    }
    paramn = (dyx)((com.tencent.mm.plugin.voip_cs.c.c.d)paramn).rr.hQE.hQJ;
    ae.i("MicroMsg.voipcs.VoipCSService", "roomid " + paramn.HSD + " key " + paramn.Gxr + "relay addr cnt " + paramn.FSU.size());
    Object localObject1 = paramn.FSU;
    paramn = new dyk();
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      dyo localdyo = (dyo)((Iterator)localObject2).next();
      dyj localdyj = new dyj();
      localdyj.HUk = localdyo.Hjx;
      localdyj.Hzv = localdyo.Hzv;
      paramn.IdB.add(localdyj);
    }
    paramn.IdA = ((List)localObject1).size();
    localObject1 = new ctw();
    localObject2 = new ctv();
    ((ctv)localObject2).Gvr = 0;
    ((ctv)localObject2).Gvs = "";
    ((ctv)localObject2).Gvt = "";
    ((ctv)localObject2).Gvu = 4;
    ((ctv)localObject2).Gvv = 4;
    ((ctv)localObject2).Gvw = 2;
    ((ctv)localObject2).HEP = paramn;
    ((ctv)localObject2).HEQ = new dyk();
    ((ctw)localObject1).HES.add(localObject2);
    ((ctw)localObject1).HER = 1;
    paramn = null;
    try
    {
      localObject1 = ((ctw)localObject1).toByteArray();
      paramn = (n)localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e("MicroMsg.voipcs.VoipCSService", "conn info to byte array fail..");
      }
    }
    if (paramn != null)
    {
      paramInt1 = c.eFj().CNE.AddNewRelayConns(paramn, paramn.length, 1);
      if (paramInt1 != 0) {
        com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.voipcs.VoipCSService", "redirect relay conns fail ret:".concat(String.valueOf(paramInt1)));
      }
    }
    AppMethodBeat.o(125361);
  }
  
  public final void a(dzc paramdzc)
  {
    AppMethodBeat.i(125362);
    if ((paramdzc.Iee <= this.CMP) || (c.eFk().CMV == 3))
    {
      AppMethodBeat.o(125362);
      return;
    }
    ae.i("MicroMsg.voipcs.VoipCSService", "get callee sync resp,notifySeq:" + paramdzc.Iee + ",calleeMemberId:" + paramdzc.Ief + ",calleeStatus:" + paramdzc.Ieg + ",calleeSubStatus:" + paramdzc.Ieh + ",recv roomId:" + paramdzc.HSD + ",recv roomKey:" + paramdzc.Gxr);
    if ((c.eFj().CNE.CwH != 0L) && (c.eFj().CNE.CwH != paramdzc.HSD))
    {
      ae.i("MicroMsg.voipcs.VoipCSService", "csRoomId:" + c.eFj().CNE.CwH + ",recv roomId:" + paramdzc.HSD + ",current and recv not equal!!");
      AppMethodBeat.o(125362);
      return;
    }
    this.CMP = paramdzc.Iee;
    this.CMl = paramdzc.Ief;
    this.CMQ = paramdzc.Ieg;
    this.CMR = paramdzc.Ieh;
    c.eFl().CMl = this.CMl;
    if (this.CMQ == 2)
    {
      ae.i("MicroMsg.voipcs.VoipCSService", "callee accept!");
      this.CMZ.stopTimer();
      eFr();
      c.eFj().CNE.uXg = paramdzc.Gxr;
      ae.i("MicroMsg.voipcs.VoipCSService", "csroomId:" + paramdzc.HSD + ",roomkey:" + paramdzc.Gxr);
      if (paramdzc.Iei != null) {}
      for (paramdzc = paramdzc.Iei.toByteArray();; paramdzc = null)
      {
        this.CMS = paramdzc;
        if (c.eFj().CNE.field_capInfo != null) {
          break;
        }
        AppMethodBeat.o(125362);
        return;
      }
      if (this.CMS == null)
      {
        AppMethodBeat.o(125362);
        return;
      }
      c.eFl().eFn();
      c.eFj().CNE.CwJ = this.CMS;
      ae.i("MicroMsg.voipcs.VoipCSService", "calleeCapDump is " + Arrays.toString(c.eFj().CNE.CwJ));
      ae.i("MicroMsg.voipcs.VoipCSService", "calleeCap length:" + this.CMS.length);
      if ((c.eFj().CNE.CwJ != null) && (c.eFj().CNE.exchangeCabInfo(c.eFj().CNE.CwJ, c.eFj().CNE.CwJ.length) < 0)) {
        ae.i("MicroMsg.voipcs.VoipCSService", "exchangeCabInfo fail!");
      }
      int i;
      if (c.eFj().CNE.CwM == null)
      {
        i = 0;
        i = c.eFj().CNE.setConfigInfo(c.eFj().CNE.CwG, c.eFj().CNE.CwH, c.eFj().CNE.uXn, c.eFj().CNE.uXg, c.eFj().CNE.field_peerId, 1, c.eFj().CNE.CwN, c.eFj().CNE.CwO, c.eFj().CNE.CwL, i, c.eFj().CNE.CwM, this.CMY, 1, c.eFj().CNE.netType, c.eFj().CNE.CxV, c.eFj().CNE.CxW, 255, 0, 0, null, 0, 0, 0, 0, "", "", 0);
        if (i != 0) {
          ae.e("MicroMsg.voipcs.VoipCSService", "setConfig fail, ret:%d", new Object[] { Integer.valueOf(i) });
        }
        if (c.eFj().CNE.Cyk != null) {
          break label766;
        }
        com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.voipcs.VoipCSService", "relay conns buf null");
      }
      for (;;)
      {
        if (this.CNa.foU()) {
          this.CNa.ay(50000L, 50000L);
        }
        c.eFl().CMr = 1;
        AppMethodBeat.o(125362);
        return;
        i = c.eFj().CNE.CwM.length;
        break;
        label766:
        i = c.eFj().CNE.AddNewRelayConns(c.eFj().CNE.Cyk, c.eFj().CNE.Cyk.length, 0);
        if (i < 0) {
          com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.voipcs.VoipCSService", "add relayconns err:".concat(String.valueOf(i)));
        }
      }
    }
    if ((this.CMQ != 0) && (this.CMQ != 1) && (this.CMQ == 3))
    {
      ae.i("MicroMsg.voipcs.VoipCSService", "callee hangup!");
      c.eFl().dataType = 5;
      c.eFl().eFm();
      c.eFl().CMv = 2;
      if (this.CMR != 1) {
        break label909;
      }
      c.eFl().CMn = 12;
    }
    for (;;)
    {
      if (this.CMO != null) {
        this.CMO.VI(1);
      }
      AppMethodBeat.o(125362);
      return;
      label909:
      if (this.CMR == 3) {
        c.eFl().CMn = 99;
      }
    }
  }
  
  public final void aN(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(125360);
    ae.i("MicroMsg.voipcs.VoipCSService", "start netscene invite for username:" + paramString1 + ",appid:" + paramString2 + ",voipCSContext:" + paramString3);
    this.CMW = paramString1;
    this.CMV = 1;
    Object localObject1 = c.eFl();
    ae.d("MicroMsg.VoipCSReportHelper", "markSendInvite");
    if (((d)localObject1).CMI == 0) {
      ((d)localObject1).CMI = ((int)(System.currentTimeMillis() / 1000L));
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
    g.ajj().a(823, this);
    c.eFj().CNE.uXi = ((int)(System.currentTimeMillis() / 1000L));
    paramString1 = new com.tencent.mm.plugin.voip_cs.c.c.c(c.eFj().CNE.uXi, paramString1, c.eFj().CNE.netType, (byte[])localObject1, c.eFj().CNE.field_capInfo, paramString2);
    ae.i("MicroMsg.voipcs.VoipCSService", "capDump is " + Arrays.toString(c.eFj().CNE.field_capInfo));
    g.ajj().a(paramString1, 0);
    AppMethodBeat.o(125360);
  }
  
  public final int eFq()
  {
    return this.CMV;
  }
  
  public final void eFr()
  {
    AppMethodBeat.i(125359);
    g.ajj().a(818, this);
    com.tencent.mm.plugin.voip_cs.c.c.f localf = new com.tencent.mm.plugin.voip_cs.c.c.f(c.eFj().CNE.CwH, c.eFj().CNE.uXg, this.CMP);
    g.ajj().a(localf, 0);
    AppMethodBeat.o(125359);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(125363);
    ae.i("MicroMsg.voipcs.VoipCSService", "onSceneEnd :netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Object localObject1;
      if (paramn.getType() == 823)
      {
        paramn = (dyu)((com.tencent.mm.plugin.voip_cs.c.c.c)paramn).rr.hQE.hQJ;
        long l1 = paramn.HSD;
        long l2 = paramn.Gxr;
        Object localObject2 = paramn.FSU;
        localObject1 = paramn.Ied;
        this.uXp = paramn.HRu;
        this.CMY = paramn.Iec;
        ae.i("MicroMsg.voipcs.VoipCSService", "tcpStartCnt : " + this.CMY);
        c.eFj().CNE.CwO = paramn.uXw;
        this.CMT = paramn.uXq;
        c.eFj().CNE.CxV = paramn.uXB;
        c.eFj().CNE.CxW = paramn.HzM.toByteArray();
        c.eFj().CNE.CwN = paramn.uXx;
        paramString = new dyk();
        Iterator localIterator = ((List)localObject2).iterator();
        dyo localdyo;
        dyj localdyj;
        while (localIterator.hasNext())
        {
          localdyo = (dyo)localIterator.next();
          localdyj = new dyj();
          localdyj.HUk = localdyo.Hjx;
          localdyj.Hzv = localdyo.Hzv;
          paramString.IdB.add(localdyj);
        }
        paramString.IdA = ((List)localObject2).size();
        localObject2 = new dyk();
        localIterator = ((List)localObject1).iterator();
        while (localIterator.hasNext())
        {
          localdyo = (dyo)localIterator.next();
          localdyj = new dyj();
          localdyj.HUk = localdyo.Hjx;
          localdyj.Hzv = localdyo.Hzv;
          ((dyk)localObject2).IdB.add(localdyj);
        }
        ((dyk)localObject2).IdA = ((List)localObject1).size();
        c.eFj().CNE.CwH = l1;
        c.eFj().CNE.uXg = l2;
        ae.i("MicroMsg.voipcs.VoipCSService", "recv invite resp csRoomId : " + l1 + ",roomKey:" + l2);
        c.eFj().CNE.Cyf = paramn.Iea;
        c.eFj().CNE.Cyg = paramn.Ieb;
        paramn = new eaa();
        paramn.nMX = 0;
        paramn.CsO = 0;
        paramn.CsN = 0;
        paramn.userName = "";
        paramn.dyO = "";
        paramn = new ctv();
        paramn.Gvr = 0;
        paramn.Gvs = "";
        paramn.Gvt = "";
        paramn.Gvu = 4;
        paramn.Gvv = 4;
        paramn.Gvw = 2;
        paramn.HEP = paramString;
        paramn.HEQ = ((dyk)localObject2);
        paramString = new ctw();
        paramString.HER = 1;
        paramString.HES = new LinkedList();
        paramString.HES.add(paramn);
        try
        {
          c.eFj().CNE.Cyk = paramString.toByteArray();
          paramString = c.eFl();
          paramn = this.CMW;
          ae.d("MicroMsg.VoipCSReportHelper", "setVoipCSBaseInfo");
          paramString.roomId = l1;
          paramString.uXg = l2;
          paramString.CMk = paramn;
          if (this.CMZ.foU())
          {
            if (this.uXp > 0)
            {
              paramString = this.CMZ;
              l1 = this.uXp * 1000;
              paramString.ay(l1, l1);
            }
          }
          else
          {
            paramString = c.eFl();
            ae.d("MicroMsg.VoipCSReportHelper", "markRecvInvite");
            if (paramString.CMI != 0) {
              paramString.CMJ = ((int)(System.currentTimeMillis() / 1000L));
            }
            AppMethodBeat.o(125363);
            return;
          }
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            ae.e("MicroMsg.voipcs.VoipCSService", "relay conn info to byte array fail..");
            continue;
            this.CMZ.ay(4000L, 4000L);
          }
        }
      }
      if (paramn.getType() == 818)
      {
        paramString = (dzc)((com.tencent.mm.plugin.voip_cs.c.c.f)paramn).rr.hQE.hQJ;
        ae.i("MicroMsg.voipcs.VoipCSService", "sync status = " + paramString.Ieg + ",notifySeq = " + paramString.Iee);
        a(paramString);
        AppMethodBeat.o(125363);
        return;
      }
      if (paramn.getType() == 880)
      {
        paramString = (dyq)((com.tencent.mm.plugin.voip_cs.c.c.a)paramn).rr.hQE.hQJ;
        if ((c.eFj().CNE.CwH == paramString.HSD) && (c.eFj().CNE.uXg == paramString.Gxr)) {
          ae.i("MicroMsg.voipcs.VoipCSService", "hangup success!");
        }
        g.ajj().b(880, this);
        c.eFl().VJ(com.tencent.mm.plugin.voip_cs.c.a.a.eFt().ped.eEp());
        AppMethodBeat.o(125363);
        return;
      }
      if (paramn.getType() == 106)
      {
        localObject1 = (com.tencent.mm.plugin.messenger.a.f)paramn;
        paramn = "";
        paramString = "";
        if (((com.tencent.mm.plugin.messenger.a.f)localObject1).doB() != null)
        {
          paramn = ((com.tencent.mm.plugin.messenger.a.f)localObject1).doB().GnN;
          paramString = ((com.tencent.mm.plugin.messenger.a.f)localObject1).doB().Hed.HId;
        }
        for (;;)
        {
          this.CMO.kv(paramn, paramString);
          AppMethodBeat.o(125363);
          return;
          ae.i("MicroMsg.voipcs.VoipCSService", "search Or Recommend items is null or empty !");
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
        paramString = (dza)((com.tencent.mm.plugin.voip_cs.c.c.e)paramn).rr.hQE.hQJ;
        if ((paramString.HSD == c.eFj().CNE.CwH) && (paramString.Gxr == c.eFj().CNE.uXg)) {
          ae.i("MicroMsg.voipcs.VoipCSService", "report data success!");
        }
        AppMethodBeat.o(125363);
      }
    }
    else
    {
      ae.i("MicroMsg.voipcs.VoipCSService", "onSceneEnd  resp error!:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 != 0) && (paramInt1 != 4))
      {
        this.CMX = -1;
        this.CMO.onError(10);
        AppMethodBeat.o(125363);
        return;
      }
      if (paramn.getType() == 823)
      {
        if (paramInt2 == 406)
        {
          ae.i("MicroMsg.voipcs.VoipCSService", "CS_INVITE_RESP_REPEAT_INVTIE 503..");
          AppMethodBeat.o(125363);
          return;
        }
        c.eFl().dataType = 1;
        this.CMX = 823;
        this.CMO.onError(paramInt2);
        AppMethodBeat.o(125363);
        return;
      }
      if ((paramn.getType() != 880) && (paramn.getType() != 818) && (paramn.getType() == 106)) {
        this.CMO.kv("", "");
      }
    }
    AppMethodBeat.o(125363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.e
 * JD-Core Version:    0.7.0.1
 */