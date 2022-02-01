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
final class c$m
  extends q
  implements a<p>
{
  c$m(c paramc)
  {
    super(0);
  }
  
  private p eOT()
  {
    AppMethodBeat.i(213932);
    long l = System.currentTimeMillis();
    Object localObject1;
    if (((j.DEBUG) || (j.IS_FLAVOR_RED) || (bv.fpT())) && (o.fB(c.eOK())))
    {
      ae.i(c.b(this.DQa), "bizPkg use debug path");
      localObject1 = (p)new WxaPkg(c.eOK());
      ((p)localObject1).aZO();
      com.tencent.mm.plugin.report.service.g.yxI.f(20781, new Object[] { "wxf337cbaa27790d8e", Integer.valueOf(0), Integer.valueOf(c.a((p)localObject1)), Integer.valueOf(0), "" });
    }
    for (;;)
    {
      Object localObject2 = this.DQa.DPL;
      l = System.currentTimeMillis() - l;
      ((b)localObject2).L(123L, 1L);
      ((b)localObject2).L(124L, l);
      ae.i("MicroMsg.WebCanvasPerformanceReporter", "performance: [bizPkg]:" + l + " ms");
      AppMethodBeat.o(213932);
      return localObject1;
      localObject1 = h.DQL;
      if (h.eOY() == 1) {}
      for (localObject1 = h.aGV("wxf337cbaa27790d8e");; localObject1 = h.aGU("wxf337cbaa27790d8e"))
      {
        localObject2 = h.DQL;
        if ((h.eOY() != 1) || (!o.fB((String)localObject1))) {
          break label325;
        }
        ae.i(c.b(this.DQa), "bizPkg use preview path");
        localObject1 = (p)new WxaPkg((String)localObject1);
        ((p)localObject1).aZO();
        com.tencent.mm.plugin.report.service.g.yxI.f(20781, new Object[] { "wxf337cbaa27790d8e", Integer.valueOf(0), Integer.valueOf(c.a((p)localObject1)), Integer.valueOf(1), "" });
        break;
      }
      label325:
      localObject2 = (p)new f(ak.getContext(), "jsapi/index.wspkg");
      ((p)localObject2).aZO();
      j = 0;
      try
      {
        i = c.a((p)localObject2);
        j = i;
        if (o.fB((String)localObject1))
        {
          j = i;
          localObject1 = (p)new WxaPkg((String)localObject1);
          j = i;
          ((p)localObject1).aZO();
          j = i;
          int m = c.a((p)localObject1);
          j = i;
          ae.i(c.b(this.DQa), "bizPkg resVersion=" + m + " assetsVersion=" + i + ' ');
          k = i;
          if (m <= i) {
            break;
          }
          j = i;
          localObject3 = h.DQL;
          j = i;
          k = i;
          if (!h.a((p)localObject1, this.DQa.eOF())) {
            break;
          }
          j = i;
          ae.i(c.b(this.DQa), "bizPkg use resPkg");
          j = i;
          localObject3 = g.DQG;
          j = i;
          g.CH(57L);
          j = i;
          localObject3 = h.DQL;
          j = i;
          k = h.aGX("wxf337cbaa27790d8e");
          j = i;
          com.tencent.mm.plugin.report.service.g.yxI.f(20781, new Object[] { "wxf337cbaa27790d8e", Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(3), "" });
          continue;
        }
        j = i;
        ae.i(c.b(this.DQa), "bizPkg use assets version:".concat(String.valueOf(i)));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.printErrStackTrace(c.b(this.DQa), (Throwable)localException, "bizPkg handle error", new Object[0]);
          Object localObject3 = g.DQG;
          g.CH(58L);
          com.tencent.mm.plugin.report.service.g.yxI.f(20781, new Object[] { "wxf337cbaa27790d8e", Integer.valueOf(0), Integer.valueOf(j), Integer.valueOf(3), localException.getMessage() });
          int k = j;
          int i = k;
        }
      }
      localObject1 = g.DQG;
      g.CH(56L);
      com.tencent.mm.plugin.report.service.g.yxI.f(20781, new Object[] { "wxf337cbaa27790d8e", Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(2), "" });
      localObject1 = localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webcanvas.c.m
 * JD-Core Version:    0.7.0.1
 */