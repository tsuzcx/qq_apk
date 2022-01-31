package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.plugin.voip.a.a;
import com.tencent.mm.plugin.voip.model.j;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.cfj;
import com.tencent.mm.protocal.c.cfp;
import com.tencent.mm.sdk.platformtools.y;

final class b$1$1
  implements Runnable
{
  b$1$1(b.1 param1, cfj paramcfj) {}
  
  public final void run()
  {
    com.tencent.mm.plugin.voip.b.bPx().bRn();
    a.Logi(this.pUi.pUh.TAG, "steve:doublelink timer started!");
    this.pUi.pUh.pQA.a(this.pUf.tTY, this.pUf.tTZ, this.pUf.tUg, this.pUf.tUz);
    if (this.pUf.tSF.szp.tFM != null)
    {
      this.pUi.pUh.pQA.aR(this.pUf.tSF.szp.tFM.toByteArray());
      if ((this.pUf.tUe != null) && (this.pUf.tUe.tFM != null) && (this.pUf.tUq != null) && (this.pUf.tUq.tFM != null)) {
        this.pUi.pUh.pQA.a(this.pUf.tUe.tFM.toByteArray(), this.pUf.tUd, this.pUf.lpZ, this.pUf.tUq.tFM.toByteArray());
      }
      this.pUi.pUh.pQA.h(this.pUf.tUh, this.pUf.tUi, this.pUf.tUj, this.pUf.tUk, this.pUf.tUl);
      this.pUi.pUh.pQA.Ab(this.pUf.tUp);
      if ((this.pUf.tUn != null) && (this.pUf.tUo != null) && (this.pUf.tUn.tFM != null) && (this.pUf.tUo.tFM != null)) {
        this.pUi.pUh.pQA.b(this.pUf.tUm, this.pUf.tUn.tFM.toByteArray(), this.pUf.tUo.tFM.toByteArray());
      }
      if (this.pUf.tSG.szp.tFM == null) {
        break label626;
      }
      this.pUi.pUh.pQA.aS(this.pUf.tSG.szp.tFM.toByteArray());
      label411:
      this.pUi.pUh.pQA.Aa(this.pUf.tUs);
      this.pUi.pUh.pQA.pQe.pVC = this.pUf.tUt;
      if ((this.pUf.tUv != null) && (this.pUf.tUv.tFM != null)) {
        this.pUi.pUh.pQA.pQe.pUK = this.pUf.tUv.tFM.toByteArray();
      }
      if (!this.pUi.pUh.pQA.pPG) {
        break label714;
      }
      this.pUi.pUh.pQA.pPG = false;
      if (this.pUi.pUh.pQA.pPC != true) {
        break label644;
      }
      a.Logi(this.pUi.pUh.TAG, "channel pre-connect already success, start talk");
      this.pUi.pUh.pQA.bQa();
    }
    for (;;)
    {
      this.pUi.pUh.pQA.bQi();
      this.pUi.pUh.pQA.bQg();
      return;
      y.e(this.pUi.pUh.TAG, "multiRelayData.PeerId.Buffer.getBuffer() is null");
      break;
      label626:
      y.e(this.pUi.pUh.TAG, "multiRelayData.CapInfo.Buffer.getBuffer() is null");
      break label411;
      label644:
      if (this.pUi.pUh.pQA.pPF == true)
      {
        a.Logi(this.pUi.pUh.TAG, "channel pre-connect already failed");
        this.pUi.pUh.pQA.s(1, -9000, "");
        return;
      }
      a.Logi(this.pUi.pUh.TAG, "channel pre-connect still connecting...");
      continue;
      label714:
      y.i(this.pUi.pUh.TAG, "isPreConnect is false");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.b.1.1
 * JD-Core Version:    0.7.0.1
 */