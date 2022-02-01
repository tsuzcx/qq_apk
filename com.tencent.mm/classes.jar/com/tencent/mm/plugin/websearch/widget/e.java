package com.tencent.mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.hr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.widget.a.a;
import com.tencent.mm.plugin.websearch.widget.a.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.HashSet;
import java.util.Set;

public final class e
{
  private static final e IIg;
  Set<WidgetData> IIh;
  b IIi;
  boolean VC;
  
  static
  {
    AppMethodBeat.i(116644);
    IIg = new e();
    AppMethodBeat.o(116644);
  }
  
  public e()
  {
    AppMethodBeat.i(116641);
    this.IIh = new HashSet();
    g.aAi();
    this.IIi = new b(g.aAh().hqK);
    fYW();
    AppMethodBeat.o(116641);
  }
  
  public static e fYV()
  {
    AppMethodBeat.i(116640);
    if (!MMApplicationContext.isMMProcess())
    {
      localObject = new RuntimeException("can not call this out of mm process");
      AppMethodBeat.o(116640);
      throw ((Throwable)localObject);
    }
    Object localObject = IIg;
    AppMethodBeat.o(116640);
    return localObject;
  }
  
  public final void b(WidgetData paramWidgetData, String paramString)
  {
    AppMethodBeat.i(116643);
    if (this.IIh.contains(paramWidgetData))
    {
      u.i("WidgetSafeModeProxyImpl", "widget js error appid %s, err %s", new Object[] { paramWidgetData.IFG.iIA, paramString });
      v.pl(31);
      hr localhr = new hr().vt(paramWidgetData.IFG.iIA);
      localhr.eBS = paramWidgetData.IFG.serviceType;
      localhr.eMi = 20L;
      localhr.eMj = System.currentTimeMillis();
      localhr.vu(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).vv(paramString).bfK();
      paramString = new a();
      paramString.field_appid = paramWidgetData.IFG.iIA;
      if (this.IIi.get(paramString, new String[0]))
      {
        paramString.field_pkgVersion = paramWidgetData.IFG.version;
        paramString.field_jsExceptionCount += 1;
        this.IIi.update(paramString, new String[0]);
        AppMethodBeat.o(116643);
        return;
      }
      paramString.field_pkgVersion = paramWidgetData.IFG.version;
      paramString.field_jsExceptionCount = 1;
      paramString.field_beginTimestamp = System.currentTimeMillis();
      this.IIi.insert(paramString);
    }
    AppMethodBeat.o(116643);
  }
  
  final void fYW()
  {
    AppMethodBeat.i(116642);
    ThreadPool.post(new e.1(this), "WidgetSafeModeProxyImpl");
    AppMethodBeat.o(116642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.e
 * JD-Core Version:    0.7.0.1
 */