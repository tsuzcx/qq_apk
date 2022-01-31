package com.tencent.mm.ui.appbrand;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class a$2
  implements n.c
{
  a$2(a parama) {}
  
  public final void a(l paraml)
  {
    if (this.uRJ.uRH == null)
    {
      y.e("MicroMsg.AppBrandSerivceActionSheet", "resetOnCreateMenuListener, state is null");
      return;
    }
    this.uRJ.uRH.a(paraml);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.appbrand.a.2
 * JD-Core Version:    0.7.0.1
 */