package com.tencent.mm.plugin.wxpayreport;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.ce.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wxpayreport/WcPayKeyBizReport;", "", "()V", "BIZ_TYPE_BTN_DISABLE", "", "BIZ_TYPE_CGI", "BIZ_TYPE_JSAPI", "BIZ_TYPE_OTHERS", "BIZ_TYPE_SOTER", "BIZ_TYPE_VIEW_EXPOSURE", "KV_STAT_24610", "", "caremode", "commonReport", "", "bizType", "bizId", "errorCode", "errorMsg", "darkmode", "fontscale", "makeViewId", "resId", "activity", "Landroid/app/Activity;", "reportBtnNoResponse", "viewId", "reportCGI", "cgiUrl", "reportJSAPI", "functionId", "reportViewExposure", "plugin-wxpay-report_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h XIV;
  
  static
  {
    AppMethodBeat.i(261149);
    XIV = new h();
    AppMethodBeat.o(261149);
  }
  
  public static void O(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(261115);
    s.u(paramString1, "bizType");
    s.u(paramString2, "bizId");
    s.u(paramString3, "errorCode");
    s.u(paramString4, "errorMsg");
    com.tencent.mm.plugin.report.service.h.OAn.b(24610, new Object[] { paramString1, paramString2, paramString3, paramString4, Integer.valueOf(iFD()), "", Integer.valueOf(iFE()), Integer.valueOf(iFF()) });
    AppMethodBeat.o(261115);
  }
  
  public static void bx(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(261105);
    s.u(paramString1, "functionId");
    s.u(paramString2, "errorCode");
    com.tencent.mm.plugin.report.service.h.OAn.b(24610, new Object[] { "4", paramString1, paramString2, paramString3, "", Integer.valueOf(iFD()), Integer.valueOf(iFE()), Integer.valueOf(iFF()) });
    AppMethodBeat.o(261105);
  }
  
  public static String f(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(261144);
    s.u(paramString, "resId");
    if (paramActivity != null)
    {
      paramString = paramActivity.getClass().getSimpleName() + '-' + paramString;
      AppMethodBeat.o(261144);
      return paramString;
    }
    AppMethodBeat.o(261144);
    return paramString;
  }
  
  static int iFD()
  {
    AppMethodBeat.i(261123);
    if (aw.isDarkMode())
    {
      AppMethodBeat.o(261123);
      return 1;
    }
    AppMethodBeat.o(261123);
    return 0;
  }
  
  static int iFE()
  {
    AppMethodBeat.i(261131);
    if (b.iRp())
    {
      AppMethodBeat.o(261131);
      return 1;
    }
    AppMethodBeat.o(261131);
    return 0;
  }
  
  static int iFF()
  {
    AppMethodBeat.i(261134);
    if (a.getScaleSize(MMApplicationContext.getContext()) > 1.0F)
    {
      AppMethodBeat.o(261134);
      return 1;
    }
    AppMethodBeat.o(261134);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpayreport.h
 * JD-Core Version:    0.7.0.1
 */