package com.tencent.mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.el;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.widget.a.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import java.util.HashSet;
import java.util.Set;

public final class e
{
  private static final e DWp;
  Set<WidgetData> DWq;
  com.tencent.mm.plugin.websearch.widget.a.b DWr;
  boolean Vp;
  
  static
  {
    AppMethodBeat.i(116644);
    DWp = new e();
    AppMethodBeat.o(116644);
  }
  
  public e()
  {
    AppMethodBeat.i(116641);
    this.DWq = new HashSet();
    g.ajS();
    this.DWr = new com.tencent.mm.plugin.websearch.widget.a.b(g.ajR().gDX);
    eQx();
    AppMethodBeat.o(116641);
  }
  
  public static e eQw()
  {
    AppMethodBeat.i(116640);
    if (!ak.cpe())
    {
      localObject = new RuntimeException("can not call this out of mm process");
      AppMethodBeat.o(116640);
      throw ((Throwable)localObject);
    }
    Object localObject = DWp;
    AppMethodBeat.o(116640);
    return localObject;
  }
  
  public final void b(WidgetData paramWidgetData, String paramString)
  {
    AppMethodBeat.i(116643);
    if (this.DWq.contains(paramWidgetData))
    {
      u.i("WidgetSafeModeProxyImpl", "widget js error appid %s, err %s", new Object[] { paramWidgetData.DUM.hNv, paramString });
      v.md(31);
      el localel = new el().oa(paramWidgetData.DUM.hNv);
      localel.ejC = paramWidgetData.DUM.cRx;
      localel.ejz = 20L;
      localel.ejA = System.currentTimeMillis();
      localel.ob(az.iW(ak.getContext())).oc(paramString).aLH();
      paramString = new a();
      paramString.field_appid = paramWidgetData.DUM.hNv;
      if (this.DWr.get(paramString, new String[0]))
      {
        paramString.field_pkgVersion = paramWidgetData.DUM.version;
        paramString.field_jsExceptionCount += 1;
        this.DWr.update(paramString, new String[0]);
        AppMethodBeat.o(116643);
        return;
      }
      paramString.field_pkgVersion = paramWidgetData.DUM.version;
      paramString.field_jsExceptionCount = 1;
      paramString.field_beginTimestamp = System.currentTimeMillis();
      this.DWr.insert(paramString);
    }
    AppMethodBeat.o(116643);
  }
  
  final void eQx()
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