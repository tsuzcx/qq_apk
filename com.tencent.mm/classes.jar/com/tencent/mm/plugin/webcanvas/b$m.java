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
final class b$m
  extends q
  implements a<p>
{
  b$m(b paramb)
  {
    super(0);
  }
  
  private p eLl()
  {
    AppMethodBeat.i(214090);
    if (((com.tencent.mm.sdk.platformtools.i.DEBUG) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED) || (bu.flY())) && (com.tencent.mm.vfs.i.fv(b.eLc())))
    {
      ad.i(b.b(this.Dyt), "bizPkg use debug path");
      localObject1 = (p)new WxaPkg(b.eLc());
      ((p)localObject1).aZr();
      com.tencent.mm.plugin.report.service.g.yhR.f(20781, new Object[] { "wxf337cbaa27790d8e", Integer.valueOf(0), Integer.valueOf(b.a((p)localObject1)), Integer.valueOf(0), "" });
      AppMethodBeat.o(214090);
      return localObject1;
    }
    Object localObject1 = g.Dzc;
    if (g.eLp() == 1) {}
    for (localObject1 = g.aFB("wxf337cbaa27790d8e");; localObject1 = g.aFA("wxf337cbaa27790d8e"))
    {
      localObject2 = g.Dzc;
      if ((g.eLp() != 1) || (!com.tencent.mm.vfs.i.fv((String)localObject1))) {
        break;
      }
      ad.i(b.b(this.Dyt), "bizPkg use preview path");
      localObject1 = (p)new WxaPkg((String)localObject1);
      ((p)localObject1).aZr();
      com.tencent.mm.plugin.report.service.g.yhR.f(20781, new Object[] { "wxf337cbaa27790d8e", Integer.valueOf(0), Integer.valueOf(b.a((p)localObject1)), Integer.valueOf(1), "" });
      AppMethodBeat.o(214090);
      return localObject1;
    }
    Object localObject2 = (p)new com.tencent.mm.plugin.appbrand.appcache.f(aj.getContext(), "jsapi/index.wspkg");
    ((p)localObject2).aZr();
    try
    {
      i = b.a((p)localObject2);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        label499:
        int i = 0;
        ad.e(b.b(this.Dyt), "bizPkg handle error: " + localException1.getMessage());
        Object localObject3 = f.DyX;
        f.Cj(58L);
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
        ad.i(b.b(this.Dyt), "bizPkg resVersion=" + j + " assetsVersion=" + i + ' ');
        if (j <= i) {
          break label662;
        }
        localObject3 = g.Dzc;
        if (!g.a((p)localObject1, this.Dyt.eKX())) {
          break label662;
        }
        ad.i(b.b(this.Dyt), "bizPkg use resPkg");
        localObject3 = f.DyX;
        f.Cj(57L);
        localObject3 = g.Dzc;
        int k = g.aFD("wxf337cbaa27790d8e");
        com.tencent.mm.plugin.report.service.g.yhR.f(20781, new Object[] { "wxf337cbaa27790d8e", Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(3), "" });
        AppMethodBeat.o(214090);
        return localObject1;
      }
      ad.i(b.b(this.Dyt), "bizPkg use assets version:".concat(String.valueOf(i)));
    }
    catch (Exception localException2)
    {
      break label566;
      break label499;
    }
    localObject1 = f.DyX;
    f.Cj(56L);
    com.tencent.mm.plugin.report.service.g.yhR.f(20781, new Object[] { "wxf337cbaa27790d8e", Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(2), "" });
    AppMethodBeat.o(214090);
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.b.m
 * JD-Core Version:    0.7.0.1
 */