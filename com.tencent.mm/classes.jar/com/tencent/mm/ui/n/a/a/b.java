package com.tencent.mm.ui.n.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appstorage.ad;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.ui.n.a.e;

public final class b
  extends a
{
  public b(e parame)
  {
    super(parame);
  }
  
  protected final r hXu()
  {
    AppMethodBeat.i(230962);
    hXt();
    Object localObject = new WxaPkg(hXt().bnR());
    ((WxaPkg)localObject).bGl();
    localObject = new ad((WxaPkg)localObject);
    AppMethodBeat.o(230962);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.n.a.a.b
 * JD-Core Version:    0.7.0.1
 */