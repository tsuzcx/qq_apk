package com.tencent.mm.ui.appbrand;

import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.o;

final class c$3
  implements am.a
{
  c$3(c paramc) {}
  
  public final boolean tC()
  {
    c localc = this.uRT;
    y.d("MicroMsg.AppBrandServiceImageBubble", "hide");
    if (localc.sgx != null) {
      localc.sgx.dismiss();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.c.3
 * JD-Core Version:    0.7.0.1
 */