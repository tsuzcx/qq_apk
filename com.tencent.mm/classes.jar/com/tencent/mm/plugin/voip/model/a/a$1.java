package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.bv.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.voip.model.j;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.cea;
import com.tencent.mm.protocal.c.cfj;
import com.tencent.mm.protocal.c.cfp;
import com.tencent.mm.sdk.platformtools.ai;

final class a$1
  implements f
{
  a$1(a parama) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final m paramm)
  {
    com.tencent.mm.plugin.voip.a.a.Logi(this.pUe.TAG, "ack response:" + paramInt1 + " errCode:" + paramInt2 + " status:" + this.pUe.pQA.mStatus);
    if (this.pUe.pQA.mStatus == 1)
    {
      com.tencent.mm.plugin.voip.a.a.Logi(this.pUe.TAG, "reject ok!");
      return;
    }
    if (this.pUe.pQA.mStatus != 3)
    {
      com.tencent.mm.plugin.voip.a.a.Loge(this.pUe.TAG, "ack response not within WAITCONNECT, ignored.");
      return;
    }
    if (paramInt1 != 0)
    {
      if (paramInt1 == 4)
      {
        this.pUe.pQA.pQe.pWi.pQU = 12;
        this.pUe.pQA.pQe.pWi.pQV = paramInt2;
        this.pUe.pQA.s(1, paramInt2, "");
        return;
      }
      this.pUe.pQA.pQe.pWi.pQU = 12;
      this.pUe.pQA.pQe.pWi.pQV = paramInt2;
      this.pUe.pQA.s(1, -9004, "");
      return;
    }
    paramString = (cea)this.pUe.bRC();
    if (paramString.tSE != 1)
    {
      com.tencent.mm.plugin.voip.a.a.Logi(this.pUe.TAG, "onVoipAckResp: do not use preconnect");
      return;
    }
    this.pUe.pQA.pPG = true;
    this.pUe.pQA.pQe.pVd = 1;
    this.pUe.pQA.pQe.lpD = paramString.sST;
    this.pUe.pQA.pQe.lpE = paramString.sSU;
    this.pUe.pQA.pQe.lpL = paramString.tSL;
    this.pUe.pQA.pQe.pUJ = paramString.tSP;
    this.pUe.pQA.pQe.pUL = paramString.tSQ;
    this.pUe.pQA.Ad(paramString.tSN);
    com.tencent.mm.plugin.voip.a.a.Logi(this.pUe.TAG, "ack ok, roomid =" + this.pUe.pQA.pQe.lpD + ",memberid = " + this.pUe.pQA.pQe.lpL);
    paramm = paramString.tSM;
    if (paramm.lpZ > 0)
    {
      paramm.lpZ -= 1;
      com.tencent.mm.plugin.voip.a.a.Logi(this.pUe.TAG, "zhengxue[ENCRYPT] got encryptStrategy[" + paramm.lpZ + "] from ackresp relaydata");
    }
    for (;;)
    {
      com.tencent.mm.plugin.voip.a.a.Logi(this.pUe.TAG, "ack with switchtcpcnt  =" + this.pUe.pQA.pQe.pUI + " RedirectReqThreshold =" + paramm.tUs + " BothSideSwitchFlag =" + paramm.tUt + " WifiScanInterval =" + paramString.tSQ);
      this.pUe.pQA.pQe.pVC = paramm.tUt;
      if ((paramm.tUv != null) && (paramm.tUv.tFM != null)) {
        this.pUe.pQA.pQe.pUK = paramm.tUv.tFM.toByteArray();
      }
      this.pUe.pQA.Ac(paramm.tTX);
      this.pUe.pQA.aR(paramm.tSF.szp.tFM.toByteArray());
      if ((paramm.tUe != null) && (paramm.tUe.tFM != null) && (paramm.tUq != null) && (paramm.tUq.tFM != null)) {
        this.pUe.pQA.a(paramm.tUe.tFM.toByteArray(), paramm.tUd, paramm.lpZ, paramm.tUq.tFM.toByteArray());
      }
      this.pUe.pQA.h(paramm.tUh, paramm.tUi, paramm.tUj, paramm.tUk, paramm.tUl);
      this.pUe.pQA.aS(paramm.tSG.szp.tFM.toByteArray());
      g.DS().O(new Runnable()
      {
        public final void run()
        {
          a.1.this.pUe.pQA.a(paramm.tTY, paramm.tTZ, paramm.tUg, paramm.tUz);
          a.1.this.pUe.pQA.Ab(paramm.tUp);
          a.1.this.pUe.pQA.Aa(paramm.tUs);
          if ((paramm.tUn != null) && (paramm.tUo != null)) {
            a.1.this.pUe.pQA.b(paramm.tUm, paramm.tUn.tFM.toByteArray(), paramm.tUo.tFM.toByteArray());
          }
          com.tencent.mm.plugin.voip.a.a.Logi(a.1.this.pUe.TAG, "ack success, try connect channel");
          a.1.this.pUe.pQA.bQg();
        }
      });
      return;
      paramm.lpZ = 1;
      com.tencent.mm.plugin.voip.a.a.Logi(this.pUe.TAG, "zhengxue[LOGIC]:got no EncryptStrategy in ackresp mrdata");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.a.1
 * JD-Core Version:    0.7.0.1
 */