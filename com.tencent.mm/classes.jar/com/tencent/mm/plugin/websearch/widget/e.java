package com.tencent.mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ca;
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
  private static final e AJc;
  Set<WidgetData> AJd;
  com.tencent.mm.plugin.websearch.widget.a.b AJe;
  boolean SE;
  
  static
  {
    AppMethodBeat.i(116644);
    AJc = new e();
    AppMethodBeat.o(116644);
  }
  
  public e()
  {
    AppMethodBeat.i(116641);
    this.AJd = new HashSet();
    g.afC();
    this.AJe = new com.tencent.mm.plugin.websearch.widget.a.b(g.afB().gda);
    eiB();
    AppMethodBeat.o(116641);
  }
  
  public static e eiA()
  {
    AppMethodBeat.i(116640);
    if (!aj.cbv())
    {
      localObject = new RuntimeException("can not call this out of mm process");
      AppMethodBeat.o(116640);
      throw ((Throwable)localObject);
    }
    Object localObject = AJc;
    AppMethodBeat.o(116640);
    return localObject;
  }
  
  public final void b(WidgetData paramWidgetData, String paramString)
  {
    AppMethodBeat.i(116643);
    if (this.AJd.contains(paramWidgetData))
    {
      u.i("WidgetSafeModeProxyImpl", "widget js error appid %s, err %s", new Object[] { paramWidgetData.AHB.gRK, paramString });
      v.lI(31);
      ca localca = new ca().iI(paramWidgetData.AHB.gRK);
      localca.dQy = paramWidgetData.AHB.cIB;
      localca.dQv = 20L;
      localca.dQw = System.currentTimeMillis();
      localca.iJ(ay.iw(aj.getContext())).iK(paramString).aBj();
      paramString = new a();
      paramString.field_appid = paramWidgetData.AHB.gRK;
      if (this.AJe.get(paramString, new String[0]))
      {
        paramString.field_pkgVersion = paramWidgetData.AHB.version;
        paramString.field_jsExceptionCount += 1;
        this.AJe.update(paramString, new String[0]);
        AppMethodBeat.o(116643);
        return;
      }
      paramString.field_pkgVersion = paramWidgetData.AHB.version;
      paramString.field_jsExceptionCount = 1;
      paramString.field_beginTimestamp = System.currentTimeMillis();
      this.AJe.insert(paramString);
    }
    AppMethodBeat.o(116643);
  }
  
  final void eiB()
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