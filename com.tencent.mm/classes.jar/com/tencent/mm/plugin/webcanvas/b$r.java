package com.tencent.mm.plugin.webcanvas;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.a.a;
import d.g.b.q;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "invoke"})
final class b$r
  extends q
  implements a<p>
{
  b$r(b paramb)
  {
    super(0);
  }
  
  private p eLl()
  {
    AppMethodBeat.i(214096);
    if (((com.tencent.mm.sdk.platformtools.i.DEBUG) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (bu.flY())) && (com.tencent.mm.vfs.i.fv(b.eLb())))
    {
      ad.i(b.b(this.Dyt), "wxaPkg use debug path");
      localObject1 = (p)new WxaPkg(b.eLb());
      ((p)localObject1).aZr();
      com.tencent.mm.plugin.report.service.g.yhR.f(20781, new Object[] { "wxfedb0854e2b1820d", Integer.valueOf(0), Integer.valueOf(b.a((p)localObject1)), Integer.valueOf(0), "" });
      AppMethodBeat.o(214096);
      return localObject1;
    }
    Object localObject1 = g.Dzc;
    localObject1 = g.eLq();
    Object localObject2 = g.Dzc;
    if ((g.eLp() == 1) && (com.tencent.mm.vfs.i.fv((String)localObject1)))
    {
      ad.i(b.b(this.Dyt), "wxaPkg use preview path");
      localObject1 = (p)new WxaPkg((String)localObject1);
      ((p)localObject1).aZr();
      com.tencent.mm.plugin.report.service.g.yhR.f(20781, new Object[] { "wxfedb0854e2b1820d", Integer.valueOf(0), Integer.valueOf(b.a((p)localObject1)), Integer.valueOf(1), "" });
      AppMethodBeat.o(214096);
      return localObject1;
    }
    localObject2 = (p)new com.tencent.mm.plugin.appbrand.appcache.f(aj.getContext(), "jsapi/webtimeline.wspkg");
    ((p)localObject2).aZr();
    try
    {
      i = b.a((p)localObject2);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        label445:
        int i = 0;
        ad.e(b.b(this.Dyt), "wxaPkg handle error: " + localException1.getMessage());
        Object localObject3 = f.DyX;
        f.Cj(48L);
        com.tencent.mm.plugin.report.service.g.yhR.f(20781, new Object[] { "wxf337cbaa27790d8e", Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(3), localException1.getMessage() });
      }
    }
    try
    {
      if (com.tencent.mm.vfs.i.fv((String)localObject1))
      {
        localObject1 = (p)new WxaPkg((String)localObject1);
        ((p)localObject1).aZr();
        int j = b.a((p)localObject1);
        ad.i(b.b(this.Dyt), "wxaPkg resVersion=" + j + " assetsVersion=" + i + ' ');
        if (j <= i) {
          break label603;
        }
        ad.i(b.b(this.Dyt), "wxaPkg use resPkg");
        localObject3 = f.DyX;
        f.Cj(47L);
        localObject3 = g.Dzc;
        j = g.aFD("wxfedb0854e2b1820d");
        com.tencent.mm.plugin.report.service.g.yhR.f(20781, new Object[] { "wxfedb0854e2b1820d", Integer.valueOf(j), Integer.valueOf(b.a((p)localObject1)), Integer.valueOf(3), "" });
        AppMethodBeat.o(214096);
        return localObject1;
      }
      ad.i(b.b(this.Dyt), "wxaPkg use assets version:".concat(String.valueOf(i)));
    }
    catch (Exception localException2)
    {
      break label510;
      break label445;
    }
    localObject1 = f.DyX;
    f.Cj(46L);
    com.tencent.mm.plugin.report.service.g.yhR.f(20781, new Object[] { "wxfedb0854e2b1820d", Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(2), "" });
    AppMethodBeat.o(214096);
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.b.r
 * JD-Core Version:    0.7.0.1
 */