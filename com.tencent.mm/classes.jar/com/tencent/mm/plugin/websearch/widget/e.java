package com.tencent.mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.jw;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.modelappbrand.v;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.widget.a.a;
import com.tencent.mm.plugin.websearch.widget.a.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.HashSet;
import java.util.Set;

public final class e
{
  private static final e PCC;
  Set<WidgetData> PCD;
  b PCE;
  boolean gZ;
  
  static
  {
    AppMethodBeat.i(116644);
    PCC = new e();
    AppMethodBeat.o(116644);
  }
  
  public e()
  {
    AppMethodBeat.i(116641);
    this.PCD = new HashSet();
    h.aHH();
    this.PCE = new b(h.aHG().kcF);
    this.gZ = true;
    AppMethodBeat.o(116641);
  }
  
  public static e gRL()
  {
    AppMethodBeat.i(116640);
    if (!MMApplicationContext.isMMProcess())
    {
      localObject = new RuntimeException("can not call this out of mm process");
      AppMethodBeat.o(116640);
      throw ((Throwable)localObject);
    }
    Object localObject = PCC;
    AppMethodBeat.o(116640);
    return localObject;
  }
  
  public final void b(WidgetData paramWidgetData, String paramString)
  {
    AppMethodBeat.i(116643);
    if (this.PCD.contains(paramWidgetData))
    {
      u.i("WidgetSafeModeProxyImpl", "widget js error appid %s, err %s", new Object[] { paramWidgetData.PzY.lyD, paramString });
      v.rE(31);
      jw localjw = new jw().AS(paramWidgetData.PzY.lyD);
      localjw.gyo = paramWidgetData.PzY.serviceType;
      localjw.gLX = 20L;
      localjw.gLY = System.currentTimeMillis();
      localjw.AT(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).AU(paramString).bpa();
      paramString = new a();
      paramString.field_appid = paramWidgetData.PzY.lyD;
      if (this.PCE.get(paramString, new String[0]))
      {
        paramString.field_pkgVersion = paramWidgetData.PzY.version;
        paramString.field_jsExceptionCount += 1;
        this.PCE.update(paramString, new String[0]);
        AppMethodBeat.o(116643);
        return;
      }
      paramString.field_pkgVersion = paramWidgetData.PzY.version;
      paramString.field_jsExceptionCount = 1;
      paramString.field_beginTimestamp = System.currentTimeMillis();
      this.PCE.insert(paramString);
    }
    AppMethodBeat.o(116643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.e
 * JD-Core Version:    0.7.0.1
 */