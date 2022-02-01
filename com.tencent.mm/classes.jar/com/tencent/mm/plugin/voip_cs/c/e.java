package com.tencent.mm.plugin.voip_cs.c;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.plugin.voip_cs.c.c.f;
import com.tencent.mm.protocal.protobuf.cir;
import com.tencent.mm.protocal.protobuf.cis;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.protocal.protobuf.dli;
import com.tencent.mm.protocal.protobuf.dlm;
import com.tencent.mm.protocal.protobuf.dlo;
import com.tencent.mm.protocal.protobuf.dls;
import com.tencent.mm.protocal.protobuf.dlv;
import com.tencent.mm.protocal.protobuf.dly;
import com.tencent.mm.protocal.protobuf.dma;
import com.tencent.mm.protocal.protobuf.dmy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  implements com.tencent.mm.al.g
{
  public int sBh;
  public b zCO;
  public int zCP;
  public int zCQ;
  public int zCR;
  public byte[] zCS;
  public int zCT;
  public int zCU;
  public int zCV;
  public String zCW;
  public int zCX;
  public int zCY;
  public av zCZ;
  public int zCl;
  public av zDa;
  public int zjk;
  
  public e()
  {
    AppMethodBeat.i(125358);
    this.zCP = 0;
    this.zCl = 0;
    this.zCQ = 0;
    this.zCR = 0;
    this.zCS = null;
    this.sBh = 0;
    this.zCT = 0;
    this.zCU = 0;
    this.zCV = 0;
    this.zCW = "";
    this.zjk = 0;
    this.zCX = 0;
    this.zCY = 999;
    this.zCZ = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125356);
        ad.v("MicroMsg.voipcs.VoipCSService", "voipcs repeat sync");
        e.this.dYo();
        AppMethodBeat.o(125356);
        return true;
      }
    }, true);
    this.zDa = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(125357);
        ad.v("MicroMsg.voipcs.VoipCSService", "voipcs heart beat");
        Object localObject = e.this;
        com.tencent.mm.kernel.g.aeS().a(795, (com.tencent.mm.al.g)localObject);
        localObject = new com.tencent.mm.plugin.voip_cs.c.c.b(c.dYg().zDE.zns, c.dYg().zDE.sAY);
        com.tencent.mm.kernel.g.aeS().a((n)localObject, 0);
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
    paramn = (dlv)((com.tencent.mm.plugin.voip_cs.c.c.d)paramn).rr.gUT.gUX;
    ad.i("MicroMsg.voipcs.VoipCSService", "roomid " + paramn.Erf + " key " + paramn.Dea + "relay addr cnt " + paramn.CCG.size());
    Object localObject1 = paramn.CCG;
    paramn = new dli();
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      dlm localdlm = (dlm)((Iterator)localObject2).next();
      dlh localdlh = new dlh();
      localdlh.EsQ = localdlm.DKe;
      localdlh.DYT = localdlm.DYT;
      paramn.EBk.add(localdlh);
    }
    paramn.EBj = ((List)localObject1).size();
    localObject1 = new cis();
    localObject2 = new cir();
    ((cir)localObject2).Dch = 0;
    ((cir)localObject2).Dci = "";
    ((cir)localObject2).Dcj = "";
    ((cir)localObject2).Dck = 4;
    ((cir)localObject2).Dcl = 4;
    ((cir)localObject2).Dcm = 2;
    ((cir)localObject2).Eec = paramn;
    ((cir)localObject2).Eed = new dli();
    ((cis)localObject1).Eef.add(localObject2);
    ((cis)localObject1).Eee = 1;
    paramn = null;
    try
    {
      localObject1 = ((cis)localObject1).toByteArray();
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
      paramInt1 = c.dYg().zDE.AddNewRelayConns(paramn, paramn.length, 1);
      if (paramInt1 != 0) {
        com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.voipcs.VoipCSService", "redirect relay conns fail ret:".concat(String.valueOf(paramInt1)));
      }
    }
    AppMethodBeat.o(125361);
  }
  
  public final void a(dma paramdma)
  {
    AppMethodBeat.i(125362);
    if ((paramdma.EBN <= this.zCP) || (c.dYh().zCV == 3))
    {
      AppMethodBeat.o(125362);
      return;
    }
    ad.i("MicroMsg.voipcs.VoipCSService", "get callee sync resp,notifySeq:" + paramdma.EBN + ",calleeMemberId:" + paramdma.EBO + ",calleeStatus:" + paramdma.EBP + ",calleeSubStatus:" + paramdma.EBQ + ",recv roomId:" + paramdma.Erf + ",recv roomKey:" + paramdma.Dea);
    if ((c.dYg().zDE.zns != 0L) && (c.dYg().zDE.zns != paramdma.Erf))
    {
      ad.i("MicroMsg.voipcs.VoipCSService", "csRoomId:" + c.dYg().zDE.zns + ",recv roomId:" + paramdma.Erf + ",current and recv not equal!!");
      AppMethodBeat.o(125362);
      return;
    }
    this.zCP = paramdma.EBN;
    this.zCl = paramdma.EBO;
    this.zCQ = paramdma.EBP;
    this.zCR = paramdma.EBQ;
    c.dYi().zCl = this.zCl;
    if (this.zCQ == 2)
    {
      ad.i("MicroMsg.voipcs.VoipCSService", "callee accept!");
      this.zCZ.stopTimer();
      dYo();
      c.dYg().zDE.sAY = paramdma.Dea;
      ad.i("MicroMsg.voipcs.VoipCSService", "csroomId:" + paramdma.Erf + ",roomkey:" + paramdma.Dea);
      if (paramdma.EBR != null) {}
      for (paramdma = paramdma.EBR.toByteArray();; paramdma = null)
      {
        this.zCS = paramdma;
        if (c.dYg().zDE.field_capInfo != null) {
          break;
        }
        AppMethodBeat.o(125362);
        return;
      }
      if (this.zCS == null)
      {
        AppMethodBeat.o(125362);
        return;
      }
      c.dYi().dYk();
      c.dYg().zDE.znu = this.zCS;
      ad.i("MicroMsg.voipcs.VoipCSService", "calleeCapDump is " + Arrays.toString(c.dYg().zDE.znu));
      ad.i("MicroMsg.voipcs.VoipCSService", "calleeCap length:" + this.zCS.length);
      if ((c.dYg().zDE.znu != null) && (c.dYg().zDE.exchangeCabInfo(c.dYg().zDE.znu, c.dYg().zDE.znu.length) < 0)) {
        ad.i("MicroMsg.voipcs.VoipCSService", "exchangeCabInfo fail!");
      }
      int i;
      if (c.dYg().zDE.znx == null)
      {
        i = 0;
        i = c.dYg().zDE.setConfigInfo(c.dYg().zDE.znr, c.dYg().zDE.zns, c.dYg().zDE.sBf, c.dYg().zDE.sAY, c.dYg().zDE.field_peerId, 1, c.dYg().zDE.zny, c.dYg().zDE.znz, c.dYg().zDE.znw, i, c.dYg().zDE.znx, this.zCY, 1, c.dYg().zDE.netType, c.dYg().zDE.zoE, c.dYg().zDE.zoF, 255, 0, 0, null, 0, 0, 0, 0, "", "", 0);
        if (i != 0) {
          ad.e("MicroMsg.voipcs.VoipCSService", "setConfig fail, ret:%d", new Object[] { Integer.valueOf(i) });
        }
        if (c.dYg().zDE.zoT != null) {
          break label766;
        }
        com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.voipcs.VoipCSService", "relay conns buf null");
      }
      for (;;)
      {
        if (this.zDa.eFX()) {
          this.zDa.av(50000L, 50000L);
        }
        c.dYi().zCr = 1;
        AppMethodBeat.o(125362);
        return;
        i = c.dYg().zDE.znx.length;
        break;
        label766:
        i = c.dYg().zDE.AddNewRelayConns(c.dYg().zDE.zoT, c.dYg().zDE.zoT.length, 0);
        if (i < 0) {
          com.tencent.mm.plugin.voip.b.c.Loge("MicroMsg.voipcs.VoipCSService", "add relayconns err:".concat(String.valueOf(i)));
        }
      }
    }
    if ((this.zCQ != 0) && (this.zCQ != 1) && (this.zCQ == 3))
    {
      ad.i("MicroMsg.voipcs.VoipCSService", "callee hangup!");
      c.dYi().dataType = 5;
      c.dYi().dYj();
      c.dYi().zCv = 2;
      if (this.zCR != 1) {
        break label909;
      }
      c.dYi().zCn = 12;
    }
    for (;;)
    {
      if (this.zCO != null) {
        this.zCO.QZ(1);
      }
      AppMethodBeat.o(125362);
      return;
      label909:
      if (this.zCR == 3) {
        c.dYi().zCn = 99;
      }
    }
  }
  
  public final void aE(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(125360);
    ad.i("MicroMsg.voipcs.VoipCSService", "start netscene invite for username:" + paramString1 + ",appid:" + paramString2 + ",voipCSContext:" + paramString3);
    this.zCW = paramString1;
    this.zCV = 1;
    Object localObject1 = c.dYi();
    ad.d("MicroMsg.VoipCSReportHelper", "markSendInvite");
    if (((d)localObject1).zCI == 0) {
      ((d)localObject1).zCI = ((int)(System.currentTimeMillis() / 1000L));
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
    com.tencent.mm.kernel.g.aeS().a(823, this);
    c.dYg().zDE.sBa = ((int)(System.currentTimeMillis() / 1000L));
    paramString1 = new com.tencent.mm.plugin.voip_cs.c.c.c(c.dYg().zDE.sBa, paramString1, c.dYg().zDE.netType, (byte[])localObject1, c.dYg().zDE.field_capInfo, paramString2);
    ad.i("MicroMsg.voipcs.VoipCSService", "capDump is " + Arrays.toString(c.dYg().zDE.field_capInfo));
    com.tencent.mm.kernel.g.aeS().a(paramString1, 0);
    AppMethodBeat.o(125360);
  }
  
  public final int dYn()
  {
    return this.zCV;
  }
  
  public final void dYo()
  {
    AppMethodBeat.i(125359);
    com.tencent.mm.kernel.g.aeS().a(818, this);
    f localf = new f(c.dYg().zDE.zns, c.dYg().zDE.sAY, this.zCP);
    com.tencent.mm.kernel.g.aeS().a(localf, 0);
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
        paramn = (dls)((com.tencent.mm.plugin.voip_cs.c.c.c)paramn).rr.gUT.gUX;
        long l1 = paramn.Erf;
        long l2 = paramn.Dea;
        Object localObject2 = paramn.CCG;
        localObject1 = paramn.EBM;
        this.sBh = paramn.EpW;
        this.zCY = paramn.EBL;
        ad.i("MicroMsg.voipcs.VoipCSService", "tcpStartCnt : " + this.zCY);
        c.dYg().zDE.znz = paramn.sBo;
        this.zCT = paramn.sBi;
        c.dYg().zDE.zoE = paramn.sBt;
        c.dYg().zDE.zoF = paramn.DZk.toByteArray();
        c.dYg().zDE.zny = paramn.sBp;
        paramString = new dli();
        Iterator localIterator = ((List)localObject2).iterator();
        dlm localdlm;
        dlh localdlh;
        while (localIterator.hasNext())
        {
          localdlm = (dlm)localIterator.next();
          localdlh = new dlh();
          localdlh.EsQ = localdlm.DKe;
          localdlh.DYT = localdlm.DYT;
          paramString.EBk.add(localdlh);
        }
        paramString.EBj = ((List)localObject2).size();
        localObject2 = new dli();
        localIterator = ((List)localObject1).iterator();
        while (localIterator.hasNext())
        {
          localdlm = (dlm)localIterator.next();
          localdlh = new dlh();
          localdlh.EsQ = localdlm.DKe;
          localdlh.DYT = localdlm.DYT;
          ((dli)localObject2).EBk.add(localdlh);
        }
        ((dli)localObject2).EBj = ((List)localObject1).size();
        c.dYg().zDE.zns = l1;
        c.dYg().zDE.sAY = l2;
        ad.i("MicroMsg.voipcs.VoipCSService", "recv invite resp csRoomId : " + l1 + ",roomKey:" + l2);
        c.dYg().zDE.zoO = paramn.EBJ;
        c.dYg().zDE.zoP = paramn.EBK;
        paramn = new dmy();
        paramn.mEU = 0;
        paramn.zjE = 0;
        paramn.zjD = 0;
        paramn.userName = "";
        paramn.dom = "";
        paramn = new cir();
        paramn.Dch = 0;
        paramn.Dci = "";
        paramn.Dcj = "";
        paramn.Dck = 4;
        paramn.Dcl = 4;
        paramn.Dcm = 2;
        paramn.Eec = paramString;
        paramn.Eed = ((dli)localObject2);
        paramString = new cis();
        paramString.Eee = 1;
        paramString.Eef = new LinkedList();
        paramString.Eef.add(paramn);
        try
        {
          c.dYg().zDE.zoT = paramString.toByteArray();
          paramString = c.dYi();
          paramn = this.zCW;
          ad.d("MicroMsg.VoipCSReportHelper", "setVoipCSBaseInfo");
          paramString.roomId = l1;
          paramString.sAY = l2;
          paramString.zCk = paramn;
          if (this.zCZ.eFX())
          {
            if (this.sBh > 0)
            {
              paramString = this.zCZ;
              l1 = this.sBh * 1000;
              paramString.av(l1, l1);
            }
          }
          else
          {
            paramString = c.dYi();
            ad.d("MicroMsg.VoipCSReportHelper", "markRecvInvite");
            if (paramString.zCI != 0) {
              paramString.zCJ = ((int)(System.currentTimeMillis() / 1000L));
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
            this.zCZ.av(4000L, 4000L);
          }
        }
      }
      if (paramn.getType() == 818)
      {
        paramString = (dma)((f)paramn).rr.gUT.gUX;
        ad.i("MicroMsg.voipcs.VoipCSService", "sync status = " + paramString.EBP + ",notifySeq = " + paramString.EBN);
        a(paramString);
        AppMethodBeat.o(125363);
        return;
      }
      if (paramn.getType() == 880)
      {
        paramString = (dlo)((com.tencent.mm.plugin.voip_cs.c.c.a)paramn).rr.gUT.gUX;
        if ((c.dYg().zDE.zns == paramString.Erf) && (c.dYg().zDE.sAY == paramString.Dea)) {
          ad.i("MicroMsg.voipcs.VoipCSService", "hangup success!");
        }
        com.tencent.mm.kernel.g.aeS().b(880, this);
        c.dYi().Ra(com.tencent.mm.plugin.voip_cs.c.a.a.dYq().zmt.dXo());
        AppMethodBeat.o(125363);
        return;
      }
      if (paramn.getType() == 106)
      {
        localObject1 = (com.tencent.mm.plugin.messenger.a.g)paramn;
        paramn = "";
        paramString = "";
        if (((com.tencent.mm.plugin.messenger.a.g)localObject1).cOA() != null)
        {
          paramn = ((com.tencent.mm.plugin.messenger.a.g)localObject1).cOA().CVv;
          paramString = ((com.tencent.mm.plugin.messenger.a.g)localObject1).cOA().DFJ.Ehn;
        }
        for (;;)
        {
          this.zCO.jx(paramn, paramString);
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
        paramString = (dly)((com.tencent.mm.plugin.voip_cs.c.c.e)paramn).rr.gUT.gUX;
        if ((paramString.Erf == c.dYg().zDE.zns) && (paramString.Dea == c.dYg().zDE.sAY)) {
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
        this.zCX = -1;
        this.zCO.onError(10);
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
        c.dYi().dataType = 1;
        this.zCX = 823;
        this.zCO.onError(paramInt2);
        AppMethodBeat.o(125363);
        return;
      }
      if ((paramn.getType() != 880) && (paramn.getType() != 818) && (paramn.getType() == 106)) {
        this.zCO.jx("", "");
      }
    }
    AppMethodBeat.o(125363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.e
 * JD-Core Version:    0.7.0.1
 */