package com.tencent.mm.ui.l.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appstorage.ab;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.ui.l.a.e;

public final class b
  extends a
{
  public b(e parame)
  {
    super(parame);
  }
  
  protected final q gWJ()
  {
    AppMethodBeat.i(234429);
    Object localObject = new WxaPkg(this.QlN.bes());
    ((WxaPkg)localObject).bvf();
    localObject = new ab((WxaPkg)localObject);
    AppMethodBeat.o(234429);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.l.a.a.b
 * JD-Core Version:    0.7.0.1
 */