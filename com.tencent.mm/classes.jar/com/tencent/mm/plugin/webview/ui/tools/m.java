package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.io.UnsupportedEncodingException;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/WebViewThirdAdReporter;", "", "()V", "TAG", "", "TYPE_PAGE_LOAD_FINISHED", "", "TYPE_PAGE_LOAD_START", "errCode", "getErrCode", "()I", "setErrCode", "(I)V", "doThirdAdReport", "", "intent", "Landroid/content/Intent;", "url", "done", "", "plugin-webview_release"})
public final class m
{
  public static final m Ecx;
  private static int errCode;
  
  static
  {
    AppMethodBeat.i(82544);
    Ecx = new m();
    AppMethodBeat.o(82544);
  }
  
  public static void a(Intent paramIntent, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(82543);
    p.h(paramString, "url");
    if (paramIntent == null)
    {
      AppMethodBeat.o(82543);
      return;
    }
    paramIntent = (Bundle)paramIntent.getParcelableExtra("ad_report_bundle");
    String str2;
    int j;
    int k;
    if ((paramIntent != null) && (paramIntent.getBoolean("ad_need_report", false)))
    {
      ad.i("MicroMsg.WebViewThirdAdReporter", "adReportArgs is not null and isADReport is true");
      str2 = paramIntent.getString("ad_report_ux_info");
      j = paramIntent.getInt("ad_report_scene", 0);
      k = paramIntent.getInt("ad_report_source", 0);
      if (!TextUtils.isEmpty((CharSequence)paramIntent.getString("ad_report_sns_id"))) {
        break label283;
      }
    }
    for (paramIntent = paramIntent.getString("ad_report_sns_id");; paramIntent = "")
    {
      try
      {
        String str1 = q.encode(paramString, "UTF-8");
        p.g(str1, "URLEncoder.encode(url, \"UTF-8\")");
        paramString = str1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          long l;
          label283:
          ad.e("MicroMsg.WebViewThirdAdReporter", "url encode error url = %s", new Object[] { paramString });
          paramString = "";
          continue;
          int i = 0;
        }
      }
      l = System.currentTimeMillis();
      if (!paramBoolean) {
        break;
      }
      i = 1;
      g.yhR.f(16972, new Object[] { paramIntent, Integer.valueOf(j), str2, Integer.valueOf(k), "", paramString, Integer.valueOf(i), Integer.valueOf(errCode), Long.valueOf(l) });
      ad.i("MicroMsg.WebViewThirdAdReporter", "%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { paramIntent, Integer.valueOf(j), str2, Integer.valueOf(k), "", paramString, Integer.valueOf(i), Integer.valueOf(errCode), Long.valueOf(l) });
      AppMethodBeat.o(82543);
      return;
    }
  }
  
  public static void setErrCode(int paramInt)
  {
    errCode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.m
 * JD-Core Version:    0.7.0.1
 */