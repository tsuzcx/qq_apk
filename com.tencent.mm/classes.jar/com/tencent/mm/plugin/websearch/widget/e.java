package com.tencent.mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.do;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.storage.c;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class e
{
  private static final e Cbt;
  Set<WidgetData> Cbu;
  com.tencent.mm.plugin.websearch.widget.a.b Cbv;
  boolean Tz;
  
  static
  {
    AppMethodBeat.i(116644);
    Cbt = new e();
    AppMethodBeat.o(116644);
  }
  
  public e()
  {
    AppMethodBeat.i(116641);
    this.Cbu = new HashSet();
    g.agS();
    this.Cbv = new com.tencent.mm.plugin.websearch.widget.a.b(g.agR().ghG);
    exV();
    AppMethodBeat.o(116641);
  }
  
  public static e exU()
  {
    AppMethodBeat.i(116640);
    if (!ai.ciE())
    {
      localObject = new RuntimeException("can not call this out of mm process");
      AppMethodBeat.o(116640);
      throw ((Throwable)localObject);
    }
    Object localObject = Cbt;
    AppMethodBeat.o(116640);
    return localObject;
  }
  
  public final void b(WidgetData paramWidgetData, String paramString)
  {
    AppMethodBeat.i(116643);
    if (this.Cbu.contains(paramWidgetData))
    {
      u.i("WidgetSafeModeProxyImpl", "widget js error appid %s, err %s", new Object[] { paramWidgetData.BZS.hsk, paramString });
      v.lA(31);
      do localdo = new do().ly(paramWidgetData.BZS.hsk);
      localdo.dSn = paramWidgetData.BZS.cFI;
      localdo.dSk = 20L;
      localdo.dSl = System.currentTimeMillis();
      localdo.lz(ax.iH(ai.getContext())).lA(paramString).aHZ();
      paramString = new com.tencent.mm.plugin.websearch.widget.a.a();
      paramString.field_appid = paramWidgetData.BZS.hsk;
      if (this.Cbv.get(paramString, new String[0]))
      {
        paramString.field_pkgVersion = paramWidgetData.BZS.version;
        paramString.field_jsExceptionCount += 1;
        this.Cbv.update(paramString, new String[0]);
        AppMethodBeat.o(116643);
        return;
      }
      paramString.field_pkgVersion = paramWidgetData.BZS.version;
      paramString.field_jsExceptionCount = 1;
      paramString.field_beginTimestamp = System.currentTimeMillis();
      this.Cbv.insert(paramString);
    }
    AppMethodBeat.o(116643);
  }
  
  final void exV()
  {
    AppMethodBeat.i(116642);
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(116639);
        Object localObject = a.a.geG;
        localObject = com.tencent.mm.ipcinvoker.wx_extension.a.a.tJ("100458");
        if (localObject == null)
        {
          ac.i("WidgetSafeModeProxyImpl", "ABTEST_LAYERID_SEARCH_WIDGET_SAFE_MODE_SWITCH item is null");
          AppMethodBeat.o(116639);
          return;
        }
        e locale = e.this;
        if ((((c)localObject).isValid()) && ("1".equals(((c)localObject).eYV().get("isOpen")))) {}
        for (boolean bool = true;; bool = false)
        {
          e.a(locale, bool);
          AppMethodBeat.o(116639);
          return;
        }
      }
    }, "WidgetSafeModeProxyImpl");
    AppMethodBeat.o(116642);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.e
 * JD-Core Version:    0.7.0.1
 */