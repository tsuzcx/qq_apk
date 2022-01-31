package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.h.a.qr;
import com.tencent.mm.h.a.qr.b;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.sdk.platformtools.y;

final class ac$1
  implements Runnable
{
  ac$1(ac paramac, qr paramqr, avn paramavn) {}
  
  public final void run()
  {
    y.i("MicroMsg.SightCdnUpload", "event callback errcode %d", new Object[] { Integer.valueOf(this.orl.bZW.result) });
    if (this.orl.bZW.result >= 0)
    {
      ac.a(this.orn);
      this.orn.a(this.orm);
      return;
    }
    this.orn.onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ac.1
 * JD-Core Version:    0.7.0.1
 */