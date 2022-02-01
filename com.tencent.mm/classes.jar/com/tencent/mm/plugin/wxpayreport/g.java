package com.tencent.mm.plugin.wxpayreport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wxpayreport/WcPayCommBizReport;", "", "()V", "BIZ_ID_BTN_DISABLE", "", "BIZ_ID_CGI", "BIZ_ID_JNI", "BIZ_ID_JSAPI", "BIZ_ID_OTHERS", "BIZ_ID_SOTER", "BIZ_ID_VIEW_EXPOSURE", "KV_STAT_24610", "", "commonReport", "", "bizType", "bizId", "errorCode", "errorMsg", "plugin-wxpay-report_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g XIU;
  
  static
  {
    AppMethodBeat.i(261107);
    XIU = new g();
    AppMethodBeat.o(261107);
  }
  
  public static void O(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(261097);
    s.u(paramString1, "bizType");
    s.u(paramString2, "bizId");
    s.u(paramString3, "errorCode");
    s.u(paramString4, "errorMsg");
    h.OAn.b(24610, new Object[] { paramString1, paramString2, paramString3, paramString4 });
    AppMethodBeat.o(261097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wxpayreport.g
 * JD-Core Version:    0.7.0.1
 */