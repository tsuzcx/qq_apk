package com.tencent.mm.plugin.voip_cs.c;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.protocal.protobuf.ctb;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.cyc;
import com.tencent.mm.protocal.protobuf.dws;
import com.tencent.mm.protocal.protobuf.dwt;
import com.tencent.mm.protocal.protobuf.dwx;
import com.tencent.mm.protocal.protobuf.dwz;
import com.tencent.mm.protocal.protobuf.dxd;
import com.tencent.mm.protocal.protobuf.dxg;
import com.tencent.mm.protocal.protobuf.dxj;
import com.tencent.mm.protocal.protobuf.dxl;
import com.tencent.mm.protocal.protobuf.dyj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  implements com.tencent.mm.al.f
{
  public int CaT;
  public int CuG;
  public b Cvj;
  public int Cvk;
  public int Cvl;
  public int Cvm;
  public byte[] Cvn;
  public int Cvo;
  public int Cvp;
  public int Cvq;
  public String Cvr;
  public int Cvs;
  public int Cvt;
  public av Cvu;
  public av Cvv;
  public int uLC;
  
  public e()
  {
    AppMethodBeat.i(125358);
    this.Cvk = 0;
    this.CuG = 0;
    this.Cvl = 0;
    this.Cvm = 0;
    this.Cvn = null;
    this.uLC = 0;
    this.Cvo = 0;
    this.Cvp = 0;
    this.Cvq = 0;
    this.Cvr = "";
    this.CaT = 0;
    this.Cvs = 0;
    this.Cvt = 999;
    this.Cvu = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125356);
        ad.v("MicroMsg.voipcs.VoipCSService", "voipcs repeat sync");
        e.this.eBJ();
        AppMethodBeat.o(125356);
        return true;
      }
    }, true);
    this.Cvv = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125357);
        ad.v("MicroMsg.voipcs.VoipCSService", "voipcs heart beat");
        Object localObject = e.this;
        g.aiU().a(795, (com.tencent.mm.al.f)localObject);
        localObject = new com.tencent.mm.plugin.voip_cs.c.c.b(c.eBB().CvZ.Cfg, c.eBB().CvZ.uLt);
        g.aiU().a((n)localObject, 0);
        AppMethodBeat.o(125357);
        return true;
      }
    }, true);
    AppMethodBeat.o(125358);
  }
  
  private static void c(int paramInt1, int paramInt2, n paramn)
  {
    AppMethodBeat.i(125361);
    ad.i("MicroMsg.voipcs.VoipCSService", "Redirect response:" + paramInt1 + " errCode:" + paramInt2);
    if (paramInt2 != 0)
    {
      ad.i("MicroMsg.voipcs.VoipCSService", " redirect response with error code:".concat(String.valueOf(paramInt2)));
      AppMethodBeat.o(125361);
      return;
    }
    paramn = (dxg)((com.tencent.mm.plugin.voip_cs.c.c.d)paramn).rr.hNL.hNQ;
    ad.i("MicroMsg.voipcs.VoipCSService", "roomid " + paramn.HyS + " key " + paramn.GeJ + "relay addr cnt " + paramn.FAy.size());
    Object localObject1 = paramn.FAy;
    paramn = new dwt();
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      dwx localdwx = (dwx)((Iterator)localObject2).next();
      dws localdws = new dws();
      localdws.HAx = localdwx.GPW;
      localdws.HfV = localdwx.HfV;
      paramn.HJt.add(localdws);
    }
    paramn.HJs = ((List)localObject1).size();
    localObject1 = new ctc();
    localObject2 = new ctb();
    ((ctb)localObject2).GcK = 0;
    ((ctb)localObject2).GcL = "";
    ((ctb)localObject2).GcM = "";
    ((ctb)localObject2).GcN = 4;
    ((ctb)localObject2).GcO = 4;
    ((ctb)localObject2).GcP = 2;
    ((ctb)localObject2).Hlp = paramn;
    ((ctb)localObject2).Hlq = new dwt();
    ((ctc)localObject1).Hls.add(localObject2);
    ((ctc)localObject1).Hlr = 1;
    paramn = null;
    try
    {
      localObject1 = ((ctc)localObject1).toByteArray();
      paramn = (n)localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.voipcs.VoipCSService", "conn info to byte array fail..");
      }
    }
    if (paramn != null)
    {
      paramInt1 = c.eBB().CvZ.AddNewRelayConns(paramn, paramn.length, 1);
      if (paramInt1 != 0) {
        com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.voipcs.VoipCSService", "redirect relay conns fail ret:".concat(String.valueOf(paramInt1)));
      }
    }
    AppMethodBeat.o(125361);
  }
  
  public final void a(dxl paramdxl)
  {
    AppMethodBeat.i(125362);
    if ((paramdxl.HJW <= this.Cvk) || (c.eBC().Cvq == 3))
    {
      AppMethodBeat.o(125362);
      return;
    }
    ad.i("MicroMsg.voipcs.VoipCSService", "get callee sync resp,notifySeq:" + paramdxl.HJW + ",calleeMemberId:" + paramdxl.HJX + ",calleeStatus:" + paramdxl.HJY + ",calleeSubStatus:" + paramdxl.HJZ + ",recv roomId:" + paramdxl.HyS + ",recv roomKey:" + paramdxl.GeJ);
    if ((c.eBB().CvZ.Cfg != 0L) && (c.eBB().CvZ.Cfg != paramdxl.HyS))
    {
      ad.i("MicroMsg.voipcs.VoipCSService", "csRoomId:" + c.eBB().CvZ.Cfg + ",recv roomId:" + paramdxl.HyS + ",current and recv not equal!!");
      AppMethodBeat.o(125362);
      return;
    }
    this.Cvk = paramdxl.HJW;
    this.CuG = paramdxl.HJX;
    this.Cvl = paramdxl.HJY;
    this.Cvm = paramdxl.HJZ;
    c.eBD().CuG = this.CuG;
    if (this.Cvl == 2)
    {
      ad.i("MicroMsg.voipcs.VoipCSService", "callee accept!");
      this.Cvu.stopTimer();
      eBJ();
      c.eBB().CvZ.uLt = paramdxl.GeJ;
      ad.i("MicroMsg.voipcs.VoipCSService", "csroomId:" + paramdxl.HyS + ",roomkey:" + paramdxl.GeJ);
      if (paramdxl.HKa != null) {}
      for (paramdxl = paramdxl.HKa.toByteArray();; paramdxl = null)
      {
        this.Cvn = paramdxl;
        if (c.eBB().CvZ.field_capInfo != null) {
          break;
        }
        AppMethodBeat.o(125362);
        return;
      }
      if (this.Cvn == null)
      {
        AppMethodBeat.o(125362);
        return;
      }
      c.eBD().eBF();
      c.eBB().CvZ.Cfi = this.Cvn;
      ad.i("MicroMsg.voipcs.VoipCSService", "calleeCapDump is " + Arrays.toString(c.eBB().CvZ.Cfi));
      ad.i("MicroMsg.voipcs.VoipCSService", "calleeCap length:" + this.Cvn.length);
      if ((c.eBB().CvZ.Cfi != null) && (c.eBB().CvZ.exchangeCabInfo(c.eBB().CvZ.Cfi, c.eBB().CvZ.Cfi.length) < 0)) {
        ad.i("MicroMsg.voipcs.VoipCSService", "exchangeCabInfo fail!");
      }
      int i;
      if (c.eBB().CvZ.Cfl == null)
      {
        i = 0;
        i = c.eBB().CvZ.setConfigInfo(c.eBB().CvZ.Cff, c.eBB().CvZ.Cfg, c.eBB().CvZ.uLA, c.eBB().CvZ.uLt, c.eBB().CvZ.field_peerId, 1, c.eBB().CvZ.Cfm, c.eBB().CvZ.Cfn, c.eBB().CvZ.Cfk, i, c.eBB().CvZ.Cfl, this.Cvt, 1, c.eBB().CvZ.netType, c.eBB().CvZ.Cgu, c.eBB().CvZ.Cgv, 255, 0, 0, null, 0, 0, 0, 0, "", "", 0);
        if (i != 0) {
          ad.e("MicroMsg.voipcs.VoipCSService", "setConfig fail, ret:%d", new Object[] { Integer.valueOf(i) });
        }
        if (c.eBB().CvZ.CgJ != null) {
          break label766;
        }
        com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.voipcs.VoipCSService", "relay conns buf null");
      }
      for (;;)
      {
        if (this.Cvv.fkZ()) {
          this.Cvv.az(50000L, 50000L);
        }
        c.eBD().CuM = 1;
        AppMethodBeat.o(125362);
        return;
        i = c.eBB().CvZ.Cfl.length;
        break;
        label766:
        i = c.eBB().CvZ.AddNewRelayConns(c.eBB().CvZ.CgJ, c.eBB().CvZ.CgJ.length, 0);
        if (i < 0) {
          com.tencent.mm.plugin.voip.b.f.Loge("MicroMsg.voipcs.VoipCSService", "add relayconns err:".concat(String.valueOf(i)));
        }
      }
    }
    if ((this.Cvl != 0) && (this.Cvl != 1) && (this.Cvl == 3))
    {
      ad.i("MicroMsg.voipcs.VoipCSService", "callee hangup!");
      c.eBD().dataType = 5;
      c.eBD().eBE();
      c.eBD().CuQ = 2;
      if (this.Cvm != 1) {
        break label909;
      }
      c.eBD().CuI = 12;
    }
    for (;;)
    {
      if (this.Cvj != null) {
        this.Cvj.Vb(1);
      }
      AppMethodBeat.o(125362);
      return;
      label909:
      if (this.Cvm == 3) {
        c.eBD().CuI = 99;
      }
    }
  }
  
  public final void aN(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(125360);
    ad.i("MicroMsg.voipcs.VoipCSService", "start netscene invite for username:" + paramString1 + ",appid:" + paramString2 + ",voipCSContext:" + paramString3);
    this.Cvr = paramString1;
    this.Cvq = 1;
    Object localObject1 = c.eBD();
    ad.d("MicroMsg.VoipCSReportHelper", "markSendInvite");
    if (((d)localObject1).Cvd == 0) {
      ((d)localObject1).Cvd = ((int)(System.currentTimeMillis() / 1000L));
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
    g.aiU().a(823, this);
    c.eBB().CvZ.uLv = ((int)(System.currentTimeMillis() / 1000L));
    paramString1 = new com.tencent.mm.plugin.voip_cs.c.c.c(c.eBB().CvZ.uLv, paramString1, c.eBB().CvZ.netType, (byte[])localObject1, c.eBB().CvZ.field_capInfo, paramString2);
    ad.i("MicroMsg.voipcs.VoipCSService", "capDump is " + Arrays.toString(c.eBB().CvZ.field_capInfo));
    g.aiU().a(paramString1, 0);
    AppMethodBeat.o(125360);
  }
  
  public final int eBI()
  {
    return this.Cvq;
  }
  
  public final void eBJ()
  {
    AppMethodBeat.i(125359);
    g.aiU().a(818, this);
    com.tencent.mm.plugin.voip_cs.c.c.f localf = new com.tencent.mm.plugin.voip_cs.c.c.f(c.eBB().CvZ.Cfg, c.eBB().CvZ.uLt, this.Cvk);
    g.aiU().a(localf, 0);
    AppMethodBeat.o(125359);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(125363);
    ad.i("MicroMsg.voipcs.VoipCSService", "onSceneEnd :netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      Object localObject1;
      if (paramn.getType() == 823)
      {
        paramn = (dxd)((com.tencent.mm.plugin.voip_cs.c.c.c)paramn).rr.hNL.hNQ;
        long l1 = paramn.HyS;
        long l2 = paramn.GeJ;
        Object localObject2 = paramn.FAy;
        localObject1 = paramn.HJV;
        this.uLC = paramn.HxJ;
        this.Cvt = paramn.HJU;
        ad.i("MicroMsg.voipcs.VoipCSService", "tcpStartCnt : " + this.Cvt);
        c.eBB().CvZ.Cfn = paramn.uLJ;
        this.Cvo = paramn.uLD;
        c.eBB().CvZ.Cgu = paramn.uLO;
        c.eBB().CvZ.Cgv = paramn.Hgm.toByteArray();
        c.eBB().CvZ.Cfm = paramn.uLK;
        paramString = new dwt();
        Iterator localIterator = ((List)localObject2).iterator();
        dwx localdwx;
        dws localdws;
        while (localIterator.hasNext())
        {
          localdwx = (dwx)localIterator.next();
          localdws = new dws();
          localdws.HAx = localdwx.GPW;
          localdws.HfV = localdwx.HfV;
          paramString.HJt.add(localdws);
        }
        paramString.HJs = ((List)localObject2).size();
        localObject2 = new dwt();
        localIterator = ((List)localObject1).iterator();
        while (localIterator.hasNext())
        {
          localdwx = (dwx)localIterator.next();
          localdws = new dws();
          localdws.HAx = localdwx.GPW;
          localdws.HfV = localdwx.HfV;
          ((dwt)localObject2).HJt.add(localdws);
        }
        ((dwt)localObject2).HJs = ((List)localObject1).size();
        c.eBB().CvZ.Cfg = l1;
        c.eBB().CvZ.uLt = l2;
        ad.i("MicroMsg.voipcs.VoipCSService", "recv invite resp csRoomId : " + l1 + ",roomKey:" + l2);
        c.eBB().CvZ.CgE = paramn.HJS;
        c.eBB().CvZ.CgF = paramn.HJT;
        paramn = new dyj();
        paramn.nHv = 0;
        paramn.Cbn = 0;
        paramn.Cbm = 0;
        paramn.userName = "";
        paramn.dxJ = "";
        paramn = new ctb();
        paramn.GcK = 0;
        paramn.GcL = "";
        paramn.GcM = "";
        paramn.GcN = 4;
        paramn.GcO = 4;
        paramn.GcP = 2;
        paramn.Hlp = paramString;
        paramn.Hlq = ((dwt)localObject2);
        paramString = new ctc();
        paramString.Hlr = 1;
        paramString.Hls = new LinkedList();
        paramString.Hls.add(paramn);
        try
        {
          c.eBB().CvZ.CgJ = paramString.toByteArray();
          paramString = c.eBD();
          paramn = this.Cvr;
          ad.d("MicroMsg.VoipCSReportHelper", "setVoipCSBaseInfo");
          paramString.roomId = l1;
          paramString.uLt = l2;
          paramString.CuF = paramn;
          if (this.Cvu.fkZ())
          {
            if (this.uLC > 0)
            {
              paramString = this.Cvu;
              l1 = this.uLC * 1000;
              paramString.az(l1, l1);
            }
          }
          else
          {
            paramString = c.eBD();
            ad.d("MicroMsg.VoipCSReportHelper", "markRecvInvite");
            if (paramString.Cvd != 0) {
              paramString.Cve = ((int)(System.currentTimeMillis() / 1000L));
            }
            AppMethodBeat.o(125363);
            return;
          }
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            ad.e("MicroMsg.voipcs.VoipCSService", "relay conn info to byte array fail..");
            continue;
            this.Cvu.az(4000L, 4000L);
          }
        }
      }
      if (paramn.getType() == 818)
      {
        paramString = (dxl)((com.tencent.mm.plugin.voip_cs.c.c.f)paramn).rr.hNL.hNQ;
        ad.i("MicroMsg.voipcs.VoipCSService", "sync status = " + paramString.HJY + ",notifySeq = " + paramString.HJW);
        a(paramString);
        AppMethodBeat.o(125363);
        return;
      }
      if (paramn.getType() == 880)
      {
        paramString = (dwz)((com.tencent.mm.plugin.voip_cs.c.c.a)paramn).rr.hNL.hNQ;
        if ((c.eBB().CvZ.Cfg == paramString.HyS) && (c.eBB().CvZ.uLt == paramString.GeJ)) {
          ad.i("MicroMsg.voipcs.VoipCSService", "hangup success!");
        }
        g.aiU().b(880, this);
        c.eBD().Vc(com.tencent.mm.plugin.voip_cs.c.a.a.eBL().oXA.eAH());
        AppMethodBeat.o(125363);
        return;
      }
      if (paramn.getType() == 106)
      {
        localObject1 = (com.tencent.mm.plugin.messenger.a.f)paramn;
        paramn = "";
        paramString = "";
        if (((com.tencent.mm.plugin.messenger.a.f)localObject1).dlC() != null)
        {
          paramn = ((com.tencent.mm.plugin.messenger.a.f)localObject1).dlC().FVo;
          paramString = ((com.tencent.mm.plugin.messenger.a.f)localObject1).dlC().GKC.HoB;
        }
        for (;;)
        {
          this.Cvj.ko(paramn, paramString);
          AppMethodBeat.o(125363);
          return;
          ad.i("MicroMsg.voipcs.VoipCSService", "search Or Recommend items is null or empty !");
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
        paramString = (dxj)((com.tencent.mm.plugin.voip_cs.c.c.e)paramn).rr.hNL.hNQ;
        if ((paramString.HyS == c.eBB().CvZ.Cfg) && (paramString.GeJ == c.eBB().CvZ.uLt)) {
          ad.i("MicroMsg.voipcs.VoipCSService", "report data success!");
        }
        AppMethodBeat.o(125363);
      }
    }
    else
    {
      ad.i("MicroMsg.voipcs.VoipCSService", "onSceneEnd  resp error!:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 != 0) && (paramInt1 != 4))
      {
        this.Cvs = -1;
        this.Cvj.onError(10);
        AppMethodBeat.o(125363);
        return;
      }
      if (paramn.getType() == 823)
      {
        if (paramInt2 == 406)
        {
          ad.i("MicroMsg.voipcs.VoipCSService", "CS_INVITE_RESP_REPEAT_INVTIE 503..");
          AppMethodBeat.o(125363);
          return;
        }
        c.eBD().dataType = 1;
        this.Cvs = 823;
        this.Cvj.onError(paramInt2);
        AppMethodBeat.o(125363);
        return;
      }
      if ((paramn.getType() != 880) && (paramn.getType() != 818) && (paramn.getType() == 106)) {
        this.Cvj.ko("", "");
      }
    }
    AppMethodBeat.o(125363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.e
 * JD-Core Version:    0.7.0.1
 */