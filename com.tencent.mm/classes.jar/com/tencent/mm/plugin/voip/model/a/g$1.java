package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.compatible.e.c;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.model.j;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.cfh;
import com.tencent.mm.protocal.c.cfi;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class g$1
  implements f
{
  g$1(g paramg) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.NetSceneVoipInvite", "Invite response:" + paramInt1 + " errCode:" + paramInt2 + " status:" + this.pUn.pQA.mStatus);
    if (this.pUn.pQA.mStatus != 2)
    {
      com.tencent.mm.plugin.voip.a.a.Loge("MicroMsg.NetSceneVoipInvite", " invite response with error status:" + this.pUn.pQA.mStatus + " should:2");
      return;
    }
    cfi localcfi = (cfi)this.pUn.bRC();
    this.pUn.pQA.pQe.pVf = localcfi.tSY;
    this.pUn.pQA.pQe.pVg = localcfi.tSZ;
    this.pUn.pQA.pQe.pVh = localcfi.tTa;
    this.pUn.pQA.pQe.pVi = localcfi.tTb;
    this.pUn.pQA.pQe.pVk = localcfi.tTd;
    this.pUn.pQA.pQe.pVj = localcfi.tTi;
    this.pUn.pQA.pQe.pVL = localcfi.tTV;
    this.pUn.pQA.pQe.pUJ = localcfi.tSP;
    this.pUn.pQA.pQe.pVm = localcfi.tTk;
    this.pUn.pQA.Ad(localcfi.tSN);
    this.pUn.pQA.pQe.pUL = localcfi.tSQ;
    if ((localcfi.tSR != null) && (localcfi.tSR.tFK >= 12))
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(localcfi.tSR.tFM.toByteArray(), 8, 4);
      ByteOrder localByteOrder1 = ByteOrder.nativeOrder();
      ByteOrder localByteOrder2 = localByteBuffer.order();
      i = localByteBuffer.getInt();
      com.tencent.mm.plugin.voip.a.a.Logd("MicroMsg.NetSceneVoipInvite", "steve:nSvrBaseBRTuneRatio1:" + i + ", nativeOrder:" + localByteOrder1 + ", bbOrder:" + localByteOrder2);
      this.pUn.pQA.pQe.pVl = i;
    }
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.NetSceneVoipInvite", "setSvrConfig onInviteResp: audioTsdfBeyond3G = " + this.pUn.pQA.pQe.pVf + ",audioTsdEdge = " + this.pUn.pQA.pQe.pVg + ",passthroughQosAlgorithm = " + this.pUn.pQA.pQe.pVh + ",fastPlayRepair = " + this.pUn.pQA.pQe.pVi + ", audioDtx = " + this.pUn.pQA.pQe.pVk + ",switchtcpPktCnt = " + this.pUn.pQA.pQe.pUI + ",SvrCfgListV = " + this.pUn.pQA.pQe.pVj + ", setMaxBRForRelay=" + this.pUn.pQA.pQe.pVm + ",EnableDataAccept = " + this.pUn.pQA.pQe.pVL + ",WifiScanInterval = " + this.pUn.pQA.pQe.pUL + ",BaseBRTuneRatio=" + this.pUn.pQA.pQe.pVl);
    this.pUn.pQA.pQe.pVn = localcfi.tTh;
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.NetSceneVoipInvite", "inviteResp AudioAecMode5 = " + this.pUn.pQA.pQe.pVn);
    this.pUn.pQA.pQe.pVo = localcfi.tTl;
    com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.NetSceneVoipInvite", "inviteResp AudioEnableXnoiseSup = " + this.pUn.pQA.pQe.pVo);
    int i = com.tencent.mm.plugin.voip.a.a.getNetType(ae.getContext());
    if (paramInt1 != 0)
    {
      if (paramInt1 == 4)
      {
        com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.NetSceneVoipInvite", "RoomId in InviteResp: " + localcfi.sST + "," + localcfi.sSU);
        switch (paramInt2)
        {
        default: 
          this.pUn.pQA.pQe.pWi.pQU = 12;
          this.pUn.pQA.pQe.pWi.pRg = 99;
          h.nFQ.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRd()), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRe()), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRf()), Integer.valueOf(5), Integer.valueOf(i) });
        }
        for (;;)
        {
          this.pUn.pQA.pQe.pWi.pQV = paramInt2;
          this.pUn.pQA.s(1, paramInt2, paramString);
          return;
          this.pUn.pQA.pPE = true;
          this.pUn.pQA.pPG = false;
          this.pUn.pQA.pPF = false;
          this.pUn.pQA.pQe.pVe = 0;
          this.pUn.pQA.pQe.pVd = 0;
          this.pUn.pQA.setStatus(3);
          this.pUn.pQA.pQe.lpD = localcfi.sST;
          this.pUn.pQA.pQe.lpE = localcfi.sSU;
          this.pUn.pQA.pQe.lpL = localcfi.tAN;
          paramString = (cfh)((g)paramm).bRD();
          this.pUn.pQA.pQf.Ai(paramString.tLL);
          return;
          this.pUn.pQA.pQe.pWi.pQU = 13;
          this.pUn.pQA.pQe.pWi.pRg = 2;
          h.nFQ.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRd()), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRe()), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRf()), Integer.valueOf(2), Integer.valueOf(i) });
          continue;
          this.pUn.pQA.pQe.pWi.pQU = 13;
          this.pUn.pQA.pQe.pWi.pRg = 9;
          h.nFQ.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRd()), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRe()), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRf()), Integer.valueOf(2), Integer.valueOf(i) });
          continue;
          this.pUn.pQA.pQe.pWi.pQU = 12;
          this.pUn.pQA.pQe.pWi.pRg = 12;
          h.nFQ.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRd()), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRe()), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRf()), Integer.valueOf(8), Integer.valueOf(i) });
          continue;
          this.pUn.pQA.pQe.pWi.pQU = 12;
          this.pUn.pQA.pQe.pWi.pRg = 1;
          h.nFQ.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRd()), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRe()), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRf()), Integer.valueOf(3), Integer.valueOf(i) });
          continue;
          this.pUn.pQA.pQe.pWi.pQU = 12;
          this.pUn.pQA.pQe.pWi.pRg = 10;
          h.nFQ.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRd()), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRe()), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRf()), Integer.valueOf(7), Integer.valueOf(i) });
          continue;
          this.pUn.pQA.pQe.pWi.pQU = 13;
          this.pUn.pQA.pQe.pWi.pRg = 11;
          h.nFQ.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRd()), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRe()), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRf()), Integer.valueOf(4), Integer.valueOf(i) });
          continue;
          y.i("MicroMsg.NetSceneVoipInvite", "invite fail cuz server unavailable! reInvtieInterval is : " + localcfi.tTW + " seconds!");
          com.tencent.mm.plugin.voip.b.bPx().pTx = System.currentTimeMillis();
          if (localcfi.tTW != 0) {
            com.tencent.mm.plugin.voip.b.bPx().pTy = (localcfi.tTW * 1000);
          } else {
            com.tencent.mm.plugin.voip.b.bPx().pTy = 30000L;
          }
        }
      }
      this.pUn.pQA.pQe.pWi.pQU = 12;
      this.pUn.pQA.pQe.pWi.pQV = paramInt2;
      this.pUn.pQA.pQe.pWi.pRg = 99;
      h.nFQ.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRd()), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRe()), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRf()), Integer.valueOf(9), Integer.valueOf(i) });
      this.pUn.pQA.s(1, -9004, "");
      return;
    }
    this.pUn.pQA.setStatus(4);
    this.pUn.pQA.pQe.lpD = localcfi.sST;
    this.pUn.pQA.pQe.lpE = localcfi.sSU;
    this.pUn.pQA.pQe.lpL = localcfi.tAN;
    h.nFQ.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRd()), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRe()), Long.valueOf(com.tencent.mm.plugin.voip.b.bPx().bRf()), Integer.valueOf(1), Integer.valueOf(i) });
    if (localcfi.tTU > 0)
    {
      paramString = this.pUn.pQA;
      long l = localcfi.tTU * 1000;
      paramString.pQs.S(l, l);
    }
    com.tencent.mm.plugin.voip.b.bPx().bRn();
    boolean bool2 = v2protocal.bRK();
    paramString = com.tencent.mm.bw.a.uav;
    boolean bool3 = com.tencent.mm.bw.a.cpo();
    boolean bool1;
    int j;
    if (com.tencent.mm.plugin.voip.b.bPz() == 0)
    {
      bool1 = true;
      paramInt2 = q.dyd.dwE;
      i = this.pUn.pQA.pQe.pUJ >> 4 & 0x7;
      j = 0;
      paramInt1 = j;
      if (bool2)
      {
        paramInt1 = j;
        if (paramInt2 != 0)
        {
          paramInt1 = j;
          if (bool3)
          {
            paramInt1 = j;
            if (bool1)
            {
              if (paramInt2 <= 0) {
                break label2546;
              }
              paramInt1 = paramInt2;
            }
          }
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.NetSceneVoipInvite", "NetSceneInviteResp set voipbeauty local=" + bool2 + ", server=" + i + ", blacklist=" + paramInt2 + ", isLibReady=" + bool3 + ",isLibInitOK=" + bool1 + ", UICallback" + this.pUn.pQA.pQf + ", finalFlag=" + paramInt1);
      if (this.pUn.pQA.pQf != null) {
        this.pUn.pQA.pQf.setVoipBeauty(paramInt1);
      }
      this.pUn.pQA.pQe.pVM = paramInt1;
      this.pUn.pQA.pQe.pVN = i;
      com.tencent.mm.plugin.voip.a.a.Logi("MicroMsg.NetSceneVoipInvite", "invite ok, roomid =" + this.pUn.pQA.pQe.lpD + ",memberid = " + this.pUn.pQA.pQe.lpL + "VoipSyncInterval = " + localcfi.tTU);
      this.pUn.pQA.pQf.bQF();
      return;
      bool1 = false;
      break;
      label2546:
      paramInt1 = j;
      if (i >= 0) {
        paramInt1 = i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.g.1
 * JD-Core Version:    0.7.0.1
 */