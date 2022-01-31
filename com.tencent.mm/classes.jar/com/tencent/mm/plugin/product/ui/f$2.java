package com.tencent.mm.plugin.product.ui;

import com.tencent.mm.h.a.mp;
import com.tencent.mm.h.a.mp.b;
import com.tencent.mm.plugin.product.b.c;
import com.tencent.mm.protocal.c.cm;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class f$2
  implements Runnable
{
  f$2(f paramf, mp parammp) {}
  
  public final void run()
  {
    y.d("MicroMsg.MallProductUI", "JSOAUTH errCode[%s], isAccept[%s]", new Object[] { Integer.valueOf(this.mTQ.bWa.errCode), Boolean.valueOf(this.mTQ.bWa.bWb) });
    if (this.mTQ.bWa.errCode == 0)
    {
      c localc = f.c(this.mTP);
      mp localmp = this.mTQ;
      cm localcm = new cm();
      localcm.hPY = localmp.bWa.userName;
      localcm.svW = localmp.bWa.bWd;
      localcm.svX = localmp.bWa.bWe;
      localcm.ffi = localmp.bWa.bWf;
      localcm.ffj = localmp.bWa.bWg;
      localcm.ffq = localmp.bWa.bWh;
      localcm.kSY = localmp.bWa.bWi;
      if ((!bk.bl(localcm.hPY)) && (!bk.bl(localcm.svW))) {
        localc.mRV = localcm;
      }
    }
    f.d(this.mTP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.f.2
 * JD-Core Version:    0.7.0.1
 */