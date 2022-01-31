package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.compatible.e.c;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip.model.VoipScoreState;
import com.tencent.mm.plugin.voip.model.j;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.cee;
import com.tencent.mm.protocal.c.cfj;
import com.tencent.mm.protocal.c.cfp;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class b$1
  implements f
{
  b$1(b paramb) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 0;
    com.tencent.mm.plugin.voip.a.a.Logi(this.pUh.TAG, "Anwser response:" + paramInt1 + " errCode:" + paramInt2 + " status:" + this.pUh.pQA.mStatus);
    if (this.pUh.pQA.mStatus == 1)
    {
      com.tencent.mm.plugin.voip.a.a.Logi(this.pUh.TAG, "reject ok!");
      return;
    }
    if (this.pUh.pQA.mStatus != 4)
    {
      com.tencent.mm.plugin.voip.a.a.Loge(this.pUh.TAG, "Anwser response not within WAITCONNECT, ignored.");
      return;
    }
    if (paramInt1 != 0)
    {
      if (paramInt1 == 4)
      {
        this.pUh.pQA.pQe.pWi.pQU = 12;
        this.pUh.pQA.pQe.pWi.pQV = paramInt2;
        this.pUh.pQA.s(1, paramInt2, "");
        return;
      }
      this.pUh.pQA.pQe.pWi.pQU = 12;
      this.pUh.pQA.pQe.pWi.pQV = paramInt2;
      this.pUh.pQA.s(1, -9004, "");
      return;
    }
    paramString = (cee)this.pUh.bRC();
    this.pUh.pQA.pQe.lpD = paramString.sST;
    this.pUh.pQA.pQe.lpE = paramString.sSU;
    this.pUh.pQA.pQe.lpL = paramString.tSL;
    this.pUh.pQA.pQe.pVf = paramString.tSY;
    this.pUh.pQA.pQe.pVg = paramString.tSZ;
    this.pUh.pQA.pQe.pVh = paramString.tTa;
    this.pUh.pQA.pQe.pVi = paramString.tTb;
    this.pUh.pQA.pQe.pVk = paramString.tTd;
    this.pUh.pQA.pQe.pVj = paramString.tTi;
    this.pUh.pQA.pQe.pUJ = paramString.tSP;
    this.pUh.pQA.pQe.pVm = paramString.tTk;
    this.pUh.pQA.Ad(paramString.tSN);
    this.pUh.pQA.pQe.pUL = paramString.tSQ;
    if (paramString.tSR.tFK >= 12)
    {
      paramm = ByteBuffer.wrap(paramString.tSR.tFM.toByteArray(), 8, 4);
      ByteOrder localByteOrder1 = ByteOrder.nativeOrder();
      ByteOrder localByteOrder2 = paramm.order();
      paramInt1 = paramm.getInt();
      com.tencent.mm.plugin.voip.a.a.Logd(this.pUh.TAG, "steve:nSvrBaseBRTuneRatio1:" + paramInt1 + ", nativeOrder:" + localByteOrder1 + ", bbOrder:" + localByteOrder2);
      this.pUh.pQA.pQe.pVl = paramInt1;
    }
    com.tencent.mm.plugin.voip.a.a.Logi(this.pUh.TAG, "onAnwserResp: audioTsdfBeyond3G = " + this.pUh.pQA.pQe.pVf + ",audioTsdEdge = " + this.pUh.pQA.pQe.pVg + ",passthroughQosAlgorithm = " + this.pUh.pQA.pQe.pVh + ",fastPlayRepair = " + this.pUh.pQA.pQe.pVi + ", audioDtx = " + this.pUh.pQA.pQe.pVk + ", switchtcppktCnt=" + this.pUh.pQA.pQe.pUI + ", SvrCfgListV=" + this.pUh.pQA.pQe.pVj + ", setMaxBRForRelay=" + this.pUh.pQA.pQe.pVm + ", RedirectreqThreshold=" + paramString.tSM.tUs + ", BothSideSwitchFlag=" + paramString.tSM.tUt + ", WifiScanInterval=" + paramString.tSQ + ", BaseBRTuneRatio=" + this.pUh.pQA.pQe.pVl);
    this.pUh.pQA.pQe.pVn = paramString.tTh;
    this.pUh.pQA.pQe.pVo = paramString.tTl;
    com.tencent.mm.plugin.voip.a.a.Logi(this.pUh.TAG, "answerResp AudioAecMode5 = " + this.pUh.pQA.pQe.pVn);
    boolean bool2 = v2protocal.bRK();
    paramm = com.tencent.mm.bw.a.uav;
    boolean bool3 = com.tencent.mm.bw.a.cpo();
    boolean bool1;
    int j;
    if (com.tencent.mm.plugin.voip.b.bPz() == 0)
    {
      bool1 = true;
      paramInt2 = q.dyd.dwE;
      j = this.pUh.pQA.pQe.pUJ >> 4 & 0x7;
      paramInt1 = i;
      if (bool2)
      {
        paramInt1 = i;
        if (paramInt2 != 0)
        {
          paramInt1 = i;
          if (bool3)
          {
            paramInt1 = i;
            if (bool1)
            {
              if (paramInt2 <= 0) {
                break label1431;
              }
              paramInt1 = paramInt2;
            }
          }
        }
      }
      label972:
      com.tencent.mm.plugin.voip.a.a.Logi(this.pUh.TAG, "NetSceneAnswerResp set voipbeauty local=" + bool2 + ", server=" + j + ", blacklist=" + paramInt2 + ", isLibReady=" + bool3 + ",isLibInitOK=" + bool1 + ", UICallback" + this.pUh.pQA.pQf + ", finalFlag=" + paramInt1);
      if (this.pUh.pQA.pQf != null) {
        this.pUh.pQA.pQf.setVoipBeauty(paramInt1);
      }
      this.pUh.pQA.pQe.pVM = paramInt1;
      this.pUh.pQA.pQe.pVN = j;
      this.pUh.pQA.pPE = true;
      com.tencent.mm.plugin.voip.a.a.Logi(this.pUh.TAG, "answer ok, roomid =" + this.pUh.pQA.pQe.lpD + ",memberid = " + this.pUh.pQA.pQe.lpL);
      paramString = paramString.tSM;
      if (paramString.lpZ <= 0) {
        break label1445;
      }
      paramString.lpZ -= 1;
      com.tencent.mm.plugin.voip.a.a.Logi(this.pUh.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + paramString.lpZ + "] from answerresp relaydata");
    }
    for (;;)
    {
      com.tencent.mm.plugin.voip.a.a.Logi(this.pUh.TAG, "answer with relayData peerid.length =" + paramString.tSF.szp.tFK);
      com.tencent.mm.plugin.voip.a.a.Logi(this.pUh.TAG, "answer with relayData capinfo.length =" + paramString.tSG.szp.tFK);
      this.pUh.pQA.Ac(paramString.tTX);
      this.pUh.pQA.pQq.a(paramString.tUx, paramString.tUw, this.pUh.pQA.pQe.lpD, this.pUh.pQA.pQe.lpE);
      try
      {
        g.DS().O(new b.1.1(this, paramString));
        return;
      }
      catch (Exception paramString)
      {
        y.e(this.pUh.TAG, "get proxy ip fail..");
        return;
      }
      bool1 = false;
      break;
      label1431:
      paramInt1 = i;
      if (j < 0) {
        break label972;
      }
      paramInt1 = j;
      break label972;
      label1445:
      paramString.lpZ = 1;
      com.tencent.mm.plugin.voip.a.a.Logi(this.pUh.TAG, "zhengxue[LOGIC]:got no EncryptStrategy in answerresp mrdata");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.b.1
 * JD-Core Version:    0.7.0.1
 */