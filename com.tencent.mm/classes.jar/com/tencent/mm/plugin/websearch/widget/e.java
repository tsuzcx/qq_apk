package com.tencent.mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ej;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.widget.a.a;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import java.util.HashSet;
import java.util.Set;

public final class e
{
  private static final e DEr;
  Set<WidgetData> DEs;
  com.tencent.mm.plugin.websearch.widget.a.b DEt;
  boolean Vp;
  
  static
  {
    AppMethodBeat.i(116644);
    DEr = new e();
    AppMethodBeat.o(116644);
  }
  
  public e()
  {
    AppMethodBeat.i(116641);
    this.DEs = new HashSet();
    g.ajD();
    this.DEt = new com.tencent.mm.plugin.websearch.widget.a.b(g.ajC().gBq);
    eMM();
    AppMethodBeat.o(116641);
  }
  
  public static e eML()
  {
    AppMethodBeat.i(116640);
    if (!aj.cnC())
    {
      localObject = new RuntimeException("can not call this out of mm process");
      AppMethodBeat.o(116640);
      throw ((Throwable)localObject);
    }
    Object localObject = DEr;
    AppMethodBeat.o(116640);
    return localObject;
  }
  
  public final void b(WidgetData paramWidgetData, String paramString)
  {
    AppMethodBeat.i(116643);
    if (this.DEs.contains(paramWidgetData))
    {
      u.i("WidgetSafeModeProxyImpl", "widget js error appid %s, err %s", new Object[] { paramWidgetData.DCO.hKC, paramString });
      v.ma(31);
      ej localej = new ej().nF(paramWidgetData.DCO.hKC);
      localej.ehS = paramWidgetData.DCO.cQN;
      localej.ehP = 20L;
      localej.ehQ = System.currentTimeMillis();
      localej.nG(ay.iR(aj.getContext())).nH(paramString).aLk();
      paramString = new a();
      paramString.field_appid = paramWidgetData.DCO.hKC;
      if (this.DEt.get(paramString, new String[0]))
      {
        paramString.field_pkgVersion = paramWidgetData.DCO.version;
        paramString.field_jsExceptionCount += 1;
        this.DEt.update(paramString, new String[0]);
        AppMethodBeat.o(116643);
        return;
      }
      paramString.field_pkgVersion = paramWidgetData.DCO.version;
      paramString.field_jsExceptionCount = 1;
      paramString.field_beginTimestamp = System.currentTimeMillis();
      this.DEt.insert(paramString);
    }
    AppMethodBeat.o(116643);
  }
  
  final void eMM()
  {
    AppMethodBeat.i(116642);
    com.tencent.mm.sdk.g.b.c(new e.1(this), "WidgetSafeModeProxyImpl");
    AppMethodBeat.o(116642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.e
 * JD-Core Version:    0.7.0.1
 */