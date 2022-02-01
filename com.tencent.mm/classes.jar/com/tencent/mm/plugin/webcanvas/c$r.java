package com.tencent.mm.plugin.webcanvas;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ac.b;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkg;
import com.tencent.mm.plugin.appbrand.appcache.f;
import com.tencent.mm.plugin.appbrand.appcache.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.vfs.o;
import d.g.a.a;
import d.g.b.q;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "invoke"})
final class c$r
  extends q
  implements a<p>
{
  c$r(c paramc)
  {
    super(0);
  }
  
  private p eOT()
  {
    AppMethodBeat.i(213938);
    long l = System.currentTimeMillis();
    Object localObject1;
    if (((j.DEBUG) || (j.IS_FLAVOR_RED) || (bv.fpT())) && (o.fB(c.eOJ())))
    {
      ae.i(c.b(this.DQa), "wxaPkg use debug path");
      localObject1 = (p)new WxaPkg(c.eOJ());
      ((p)localObject1).aZO();
      com.tencent.mm.plugin.report.service.g.yxI.f(20781, new Object[] { "wxfedb0854e2b1820d", Integer.valueOf(0), Integer.valueOf(c.a((p)localObject1)), Integer.valueOf(0), "" });
    }
    for (;;)
    {
      Object localObject2 = this.DQa.DPL;
      l = System.currentTimeMillis() - l;
      ((b)localObject2).L(120L, 1L);
      ((b)localObject2).L(121L, l);
      ae.i("MicroMsg.WebCanvasPerformanceReporter", "performance: [basePkg]:" + l + " ms");
      AppMethodBeat.o(213938);
      return localObject1;
      localObject1 = h.DQL;
      localObject2 = h.eOZ();
      localObject1 = h.DQL;
      if ((h.eOY() == 1) && (o.fB((String)localObject2)))
      {
        ae.i(c.b(this.DQa), "wxaPkg use preview path");
        localObject1 = (p)new WxaPkg((String)localObject2);
        ((p)localObject1).aZO();
        com.tencent.mm.plugin.report.service.g.yxI.f(20781, new Object[] { "wxfedb0854e2b1820d", Integer.valueOf(0), Integer.valueOf(c.a((p)localObject1)), Integer.valueOf(1), "" });
      }
      else
      {
        localObject1 = (p)new f(ak.getContext(), "jsapi/webtimeline.wspkg");
        ((p)localObject1).aZO();
        j = 0;
      }
      try
      {
        i = c.a((p)localObject1);
        j = i;
        if (o.fB((String)localObject2))
        {
          j = i;
          localObject2 = (p)new WxaPkg((String)localObject2);
          j = i;
          ((p)localObject2).aZO();
          j = i;
          int k = c.a((p)localObject2);
          j = i;
          ae.i(c.b(this.DQa), "wxaPkg resVersion=" + k + " assetsVersion=" + i + ' ');
          j = i;
          if (k <= i) {
            break;
          }
          j = i;
          ae.i(c.b(this.DQa), "wxaPkg use resPkg");
          j = i;
          localObject3 = g.DQG;
          j = i;
          g.CH(47L);
          j = i;
          localObject3 = h.DQL;
          j = i;
          k = h.aGX("wxfedb0854e2b1820d");
          j = i;
          com.tencent.mm.plugin.report.service.g.yxI.f(20781, new Object[] { "wxfedb0854e2b1820d", Integer.valueOf(k), Integer.valueOf(c.a((p)localObject2)), Integer.valueOf(3), "" });
          localObject1 = localObject2;
          continue;
        }
        j = i;
        ae.i(c.b(this.DQa), "wxaPkg use assets version:".concat(String.valueOf(i)));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.printErrStackTrace(c.b(this.DQa), (Throwable)localException, "wxaPkg handle error", new Object[0]);
          Object localObject3 = g.DQG;
          g.CH(48L);
          com.tencent.mm.plugin.report.service.g.yxI.f(20781, new Object[] { "wxf337cbaa27790d8e", Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(3), localException.getMessage() });
          int i = j;
        }
      }
      localObject2 = g.DQG;
      g.CH(46L);
      com.tencent.mm.plugin.report.service.g.yxI.f(20781, new Object[] { "wxfedb0854e2b1820d", Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(2), "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.c.r
 * JD-Core Version:    0.7.0.1
 */