package com.tencent.mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.mn;
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
  private static final e Wth;
  Set<WidgetData> Wti;
  b Wtj;
  boolean hU;
  
  static
  {
    AppMethodBeat.i(116644);
    Wth = new e();
    AppMethodBeat.o(116644);
  }
  
  public e()
  {
    AppMethodBeat.i(116641);
    this.Wti = new HashSet();
    h.baF();
    this.Wtj = new b(h.baE().mCN);
    this.hU = true;
    AppMethodBeat.o(116641);
  }
  
  public static e irc()
  {
    AppMethodBeat.i(116640);
    if (!MMApplicationContext.isMMProcess())
    {
      localObject = new RuntimeException("can not call this out of mm process");
      AppMethodBeat.o(116640);
      throw ((Throwable)localObject);
    }
    Object localObject = Wth;
    AppMethodBeat.o(116640);
    return localObject;
  }
  
  public final void b(WidgetData paramWidgetData, String paramString)
  {
    AppMethodBeat.i(116643);
    if (this.Wti.contains(paramWidgetData))
    {
      u.i("WidgetSafeModeProxyImpl", "widget js error appid %s, err %s", new Object[] { paramWidgetData.Wqn.oqe, paramString });
      v.rG(31);
      mn localmn = new mn().uY(paramWidgetData.Wqn.oqe);
      localmn.iKD = paramWidgetData.Wqn.serviceType;
      localmn.jbJ = 20L;
      localmn.jbK = System.currentTimeMillis();
      localmn.uZ(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext())).va(paramString).bMH();
      paramString = new a();
      paramString.field_appid = paramWidgetData.Wqn.oqe;
      if (this.Wtj.get(paramString, new String[0]))
      {
        paramString.field_pkgVersion = paramWidgetData.Wqn.version;
        paramString.field_jsExceptionCount += 1;
        this.Wtj.update(paramString, new String[0]);
        AppMethodBeat.o(116643);
        return;
      }
      paramString.field_pkgVersion = paramWidgetData.Wqn.version;
      paramString.field_jsExceptionCount = 1;
      paramString.field_beginTimestamp = System.currentTimeMillis();
      this.Wtj.insert(paramString);
    }
    AppMethodBeat.o(116643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.e
 * JD-Core Version:    0.7.0.1
 */