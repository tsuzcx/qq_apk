package com.tencent.mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.widget.a.a;
import com.tencent.mm.plugin.websearch.widget.a.b;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import java.util.HashSet;
import java.util.Set;

public final class e
{
  private static final e uMv;
  boolean LB;
  Set<WidgetData> uMw;
  b uMx;
  
  static
  {
    AppMethodBeat.i(91449);
    uMv = new e();
    AppMethodBeat.o(91449);
  }
  
  public e()
  {
    AppMethodBeat.i(91446);
    this.uMw = new HashSet();
    g.RM();
    this.uMx = new b(g.RL().eHS);
    cZQ();
    AppMethodBeat.o(91446);
  }
  
  public static e dac()
  {
    AppMethodBeat.i(91445);
    if (!ah.brt())
    {
      localObject = new RuntimeException("can not call this out of mm process");
      AppMethodBeat.o(91445);
      throw ((Throwable)localObject);
    }
    Object localObject = uMv;
    AppMethodBeat.o(91445);
    return localObject;
  }
  
  public final void b(WidgetData paramWidgetData, String paramString)
  {
    AppMethodBeat.i(91448);
    if (this.uMw.contains(paramWidgetData))
    {
      u.i("WidgetSafeModeProxyImpl", "widget js error appid %s, err %s", new Object[] { paramWidgetData.uKA.fqf, paramString });
      v.kS(31);
      af localaf = new af().fB(paramWidgetData.uKA.fqf);
      localaf.cUl = paramWidgetData.uKA.fmF;
      localaf.cUh = 20L;
      localaf.cUi = System.currentTimeMillis();
      localaf.fC(at.gU(ah.getContext())).fD(paramString).ake();
      paramString = new a();
      paramString.field_appid = paramWidgetData.uKA.fqf;
      if (this.uMx.get(paramString, new String[0]))
      {
        paramString.field_pkgVersion = paramWidgetData.uKA.version;
        paramString.field_jsExceptionCount += 1;
        this.uMx.update(paramString, new String[0]);
        AppMethodBeat.o(91448);
        return;
      }
      paramString.field_pkgVersion = paramWidgetData.uKA.version;
      paramString.field_jsExceptionCount = 1;
      paramString.field_beginTimestamp = System.currentTimeMillis();
      this.uMx.insert(paramString);
    }
    AppMethodBeat.o(91448);
  }
  
  final void cZQ()
  {
    AppMethodBeat.i(91447);
    d.post(new e.1(this), "WidgetSafeModeProxyImpl");
    AppMethodBeat.o(91447);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.e
 * JD-Core Version:    0.7.0.1
 */