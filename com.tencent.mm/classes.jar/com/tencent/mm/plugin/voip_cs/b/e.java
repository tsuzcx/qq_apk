package com.tencent.mm.plugin.voip_cs.b;

import android.os.Looper;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.bnm;
import com.tencent.mm.protocal.c.ceb;
import com.tencent.mm.protocal.c.cec;
import com.tencent.mm.protocal.c.ceg;
import com.tencent.mm.protocal.c.cei;
import com.tencent.mm.protocal.c.cem;
import com.tencent.mm.protocal.c.cep;
import com.tencent.mm.protocal.c.ces;
import com.tencent.mm.protocal.c.ceu;
import com.tencent.mm.protocal.c.cfm;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  implements com.tencent.mm.ah.f
{
  public int lpN = 0;
  public int pQo = 0;
  public b qdU;
  public int qdV = 0;
  public int qdW = 0;
  public int qdX = 0;
  public byte[] qdY = null;
  public int qdZ = 0;
  public int qdr = 0;
  public int qea = 0;
  public int qeb = 0;
  public String qec = "";
  public int qed = 0;
  public int qee = 999;
  public am qef = new am(Looper.getMainLooper(), new e.1(this), true);
  public am qeg = new am(Looper.getMainLooper(), new e.2(this), true);
  
  private static void b(int paramInt1, int paramInt2, m paramm)
  {
    y.i("MicroMsg.voipcs.VoipCSService", "Redirect response:" + paramInt1 + " errCode:" + paramInt2);
    if (paramInt2 != 0)
    {
      y.i("MicroMsg.voipcs.VoipCSService", " redirect response with error code:" + paramInt2);
      return;
    }
    paramm = (cep)((com.tencent.mm.plugin.voip_cs.b.c.d)paramm).dmK.ecF.ecN;
    y.i("MicroMsg.voipcs.VoipCSService", "roomid " + paramm.tTo + " key " + paramm.sSU + "relay addr cnt " + paramm.syZ.size());
    paramm = paramm.syZ;
    cec localcec = new cec();
    Iterator localIterator = paramm.iterator();
    while (localIterator.hasNext())
    {
      ceg localceg = (ceg)localIterator.next();
      ceb localceb = new ceb();
      c.bSO();
      localceb.tNg = com.tencent.mm.plugin.voip_cs.b.b.a.Qh(localceg.tpY);
      localceb.tAA = localceg.tAA;
      localcec.tST.add(localceb);
    }
    localcec.tSS = paramm.size();
    c.bSO().qeL.a(localcec, localcec, null, 0, 0);
  }
  
  public final void a(ceu paramceu)
  {
    if ((paramceu.tTy <= this.qdV) || (c.bSP().qeb == 3)) {}
    for (;;)
    {
      return;
      y.i("MicroMsg.voipcs.VoipCSService", "get callee sync resp,notifySeq:" + paramceu.tTy + ",calleeMemberId:" + paramceu.tTz + ",calleeStatus:" + paramceu.tTA + ",calleeSubStatus:" + paramceu.tTB + ",recv roomId:" + paramceu.tTo + ",recv roomKey:" + paramceu.sSU);
      if ((c.bSO().qeL.pUA != 0L) && (c.bSO().qeL.pUA != paramceu.tTo))
      {
        y.i("MicroMsg.voipcs.VoipCSService", "csRoomId:" + c.bSO().qeL.pUA + ",recv roomId:" + paramceu.tTo + ",current and recv not equal!!");
        return;
      }
      this.qdV = paramceu.tTy;
      this.qdr = paramceu.tTz;
      this.qdW = paramceu.tTA;
      this.qdX = paramceu.tTB;
      c.bSQ().qdr = this.qdr;
      if (this.qdW == 2)
      {
        y.i("MicroMsg.voipcs.VoipCSService", "callee accept!");
        this.qef.stopTimer();
        bSU();
        c.bSO().qeL.lpE = paramceu.sSU;
        y.i("MicroMsg.voipcs.VoipCSService", "csroomId:" + paramceu.tTo + ",roomkey:" + paramceu.sSU);
        if (paramceu.tTC != null)
        {
          paramceu = paramceu.tTC.toByteArray();
          this.qdY = paramceu;
          if ((c.bSO().qeL.field_capInfo == null) || (this.qdY == null)) {
            continue;
          }
          paramceu = c.bSQ();
          y.d("MicroMsg.VoipCSReportHelper", "markUserAccept");
          if (paramceu.qdE == 0L)
          {
            paramceu.qdQ = ((int)(System.currentTimeMillis() / 1000L));
            paramceu.qdE = (paramceu.qdQ - paramceu.qdO);
          }
          c.bSO().qeL.pUC = this.qdY;
          y.i("MicroMsg.voipcs.VoipCSService", "calleeCapDump is " + Arrays.toString(c.bSO().qeL.pUC));
          y.i("MicroMsg.voipcs.VoipCSService", "calleeCap length:" + this.qdY.length);
          if ((c.bSO().qeL.pUC != null) && (c.bSO().qeL.exchangeCabInfo(c.bSO().qeL.pUC, c.bSO().qeL.pUC.length) < 0)) {
            y.i("MicroMsg.voipcs.VoipCSService", "exchangeCabInfo fail!");
          }
          if (c.bSO().qeL.pUF != null) {
            break label756;
          }
        }
        label756:
        for (int i = 0;; i = c.bSO().qeL.pUF.length)
        {
          i = c.bSO().qeL.setConfigInfo(c.bSO().qeL.pUz, c.bSO().qeL.pUA, c.bSO().qeL.lpL, c.bSO().qeL.lpE, c.bSO().qeL.field_peerId, 1, c.bSO().qeL.pUG, c.bSO().qeL.pUH, c.bSO().qeL.pUE, i, c.bSO().qeL.pUF, this.qee, 1, c.bSO().qeL.netType, c.bSO().qeL.pVz, c.bSO().qeL.pVA, 255, 0, 0, null);
          if (i != 0) {
            y.e("MicroMsg.voipcs.VoipCSService", "setConfig fail, ret:%d", new Object[] { Integer.valueOf(i) });
          }
          i = c.bSO().qeL.connectToPeer();
          if (i != 0) {
            y.e("MicroMsg.voipcs.VoipCSService", "connectToPeer fail, ret:%d", new Object[] { Integer.valueOf(i) });
          }
          if (this.qeg.crl()) {
            this.qeg.S(50000L, 50000L);
          }
          c.bSQ().qdx = 1;
          return;
          paramceu = null;
          break;
        }
      }
      else if ((this.qdW != 0) && (this.qdW != 1) && (this.qdW == 3))
      {
        y.i("MicroMsg.voipcs.VoipCSService", "callee hangup!");
        c.bSQ().aYU = 5;
        c.bSQ().bSR();
        c.bSQ().qdB = 2;
        if (this.qdX == 1) {
          c.bSQ().qdt = 12;
        }
        while (this.qdU != null)
        {
          this.qdU.AB(1);
          return;
          if (this.qdX == 3) {
            c.bSQ().qdt = 99;
          }
        }
      }
    }
  }
  
  public final void bSU()
  {
    g.Dk().a(818, this);
    com.tencent.mm.plugin.voip_cs.b.c.f localf = new com.tencent.mm.plugin.voip_cs.b.c.f(c.bSO().qeL.pUA, c.bSO().qeL.lpE, this.qdV);
    g.Dk().a(localf, 0);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.voipcs.VoipCSService", "onSceneEnd :netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    Object localObject1;
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (paramm.getType() == 823)
      {
        paramm = (cem)((com.tencent.mm.plugin.voip_cs.b.c.c)paramm).dmK.ecF.ecN;
        long l1 = paramm.tTo;
        long l2 = paramm.sSU;
        Object localObject2 = paramm.syZ;
        localObject1 = paramm.tTx;
        this.lpN = paramm.tTt;
        this.qee = paramm.tTw;
        y.i("MicroMsg.voipcs.VoipCSService", "tcpStartCnt : " + this.qee);
        c.bSO().qeL.pUH = paramm.lpU;
        this.qdZ = paramm.lpO;
        c.bSO().qeL.pVz = paramm.lpZ;
        c.bSO().qeL.pVA = paramm.tAR.toByteArray();
        c.bSO().qeL.pUG = paramm.lpV;
        paramString = new cec();
        Iterator localIterator = ((List)localObject2).iterator();
        ceg localceg;
        ceb localceb;
        while (localIterator.hasNext())
        {
          localceg = (ceg)localIterator.next();
          localceb = new ceb();
          c.bSO();
          localceb.tNg = com.tencent.mm.plugin.voip_cs.b.b.a.Qh(localceg.tpY);
          localceb.tAA = localceg.tAA;
          paramString.tST.add(localceb);
        }
        paramString.tSS = ((List)localObject2).size();
        localObject2 = new cec();
        localIterator = ((List)localObject1).iterator();
        while (localIterator.hasNext())
        {
          localceg = (ceg)localIterator.next();
          localceb = new ceb();
          c.bSO();
          localceb.tNg = com.tencent.mm.plugin.voip_cs.b.b.a.Qh(localceg.tpY);
          localceb.tAA = localceg.tAA;
          ((cec)localObject2).tST.add(localceb);
        }
        ((cec)localObject2).tSS = ((List)localObject1).size();
        c.bSO().qeL.pUA = l1;
        c.bSO().qeL.lpE = l2;
        y.i("MicroMsg.voipcs.VoipCSService", "recv invite resp csRoomId : " + l1 + ",roomKey:" + l2);
        c.bSO().qeL.pVJ = paramm.tTu;
        c.bSO().qeL.pVK = paramm.tTv;
        paramm = new cfm();
        paramm.tUF = 0;
        paramm.tUG = 0;
        paramm.tUH = 0;
        paramm.userName = "";
        paramm.foj = "";
        if (c.bSO().qeL.a(paramString, paramString, paramString, paramm, null) != 0) {
          y.i("MicroMsg.voipcs.VoipCSService", "setIp fail!");
        }
        paramString = c.bSQ();
        paramm = this.qec;
        y.d("MicroMsg.VoipCSReportHelper", "setVoipCSBaseInfo");
        paramString.qdp = l1;
        paramString.lpE = l2;
        paramString.qdq = paramm;
        if (this.qef.crl())
        {
          if (this.lpN > 0)
          {
            paramString = this.qef;
            l1 = this.lpN * 1000;
            paramString.S(l1, l1);
          }
        }
        else
        {
          paramString = c.bSQ();
          y.d("MicroMsg.VoipCSReportHelper", "markRecvInvite");
          if (paramString.qdO != 0) {
            paramString.qdP = ((int)(System.currentTimeMillis() / 1000L));
          }
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          this.qef.S(4000L, 4000L);
          break;
          if (paramm.getType() == 818)
          {
            paramString = (ceu)((com.tencent.mm.plugin.voip_cs.b.c.f)paramm).dmK.ecF.ecN;
            y.i("MicroMsg.voipcs.VoipCSService", "sync status = " + paramString.tTA + ",notifySeq = " + paramString.tTy);
            a(paramString);
            return;
          }
          if (paramm.getType() == 880)
          {
            paramString = (cei)((com.tencent.mm.plugin.voip_cs.b.c.a)paramm).dmK.ecF.ecN;
            if ((c.bSO().qeL.pUA == paramString.tTo) && (c.bSO().qeL.lpE == paramString.sSU)) {
              y.i("MicroMsg.voipcs.VoipCSService", "hangup success!");
            }
            g.Dk().b(880, this);
            c.bSQ().AC(com.tencent.mm.plugin.voip_cs.b.a.a.bSW().pTJ.bSB());
            return;
          }
          if (paramm.getType() == 106)
          {
            localObject1 = (com.tencent.mm.plugin.messenger.a.f)paramm;
            paramm = "";
            paramString = "";
            if (((com.tencent.mm.plugin.messenger.a.f)localObject1).bhH() != null)
            {
              paramm = ((com.tencent.mm.plugin.messenger.a.f)localObject1).bhH().sLD;
              paramString = ((com.tencent.mm.plugin.messenger.a.f)localObject1).bhH().tmw.tFO;
            }
            for (;;)
            {
              this.qdU.fd(paramm, paramString);
              return;
              y.i("MicroMsg.voipcs.VoipCSService", "search Or Recommend items is null or empty !");
            }
          }
          if (paramm.getType() == 285)
          {
            b(paramInt1, paramInt2, paramm);
            return;
          }
        } while (paramm.getType() != 312);
        paramString = (ces)((com.tencent.mm.plugin.voip_cs.b.c.e)paramm).dmK.ecF.ecN;
      } while ((paramString.tTo != c.bSO().qeL.pUA) || (paramString.sSU != c.bSO().qeL.lpE));
      y.i("MicroMsg.voipcs.VoipCSService", "report data success!");
      return;
      y.i("MicroMsg.voipcs.VoipCSService", "onSceneEnd  resp error!:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 != 0) && (paramInt1 != 4))
      {
        this.qed = -1;
        this.qdU.onError(10);
        return;
      }
      if (paramm.getType() == 823)
      {
        if (paramInt2 == 406)
        {
          y.i("MicroMsg.voipcs.VoipCSService", "CS_INVITE_RESP_REPEAT_INVTIE 503..");
          return;
        }
        c.bSQ().aYU = 1;
        this.qed = 823;
        this.qdU.onError(paramInt2);
        return;
      }
    } while ((paramm.getType() == 880) || (paramm.getType() == 818) || (paramm.getType() != 106));
    this.qdU.fd("", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.e
 * JD-Core Version:    0.7.0.1
 */