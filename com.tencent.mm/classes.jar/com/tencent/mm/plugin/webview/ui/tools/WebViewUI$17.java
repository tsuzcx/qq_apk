package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Set;
import java.util.regex.Pattern;

final class WebViewUI$17
  implements DownloadListener
{
  WebViewUI$17(WebViewUI paramWebViewUI) {}
  
  public final void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    int k = 1;
    AppMethodBeat.i(7837);
    ab.i("MicroMsg.WebViewUI", "edw onDownloadStart, url = " + paramString1 + ", mimetype = " + paramString4 + ", userAgent = " + paramString2);
    int i = this.vgz.getIntent().getIntExtra("key_download_restrict", 0);
    paramString2 = this.vgz.getIntent().getStringExtra("key_function_id");
    if (!bo.isNullOrNil(paramString2)) {
      h.qsU.e(14596, new Object[] { paramString2, Integer.valueOf(i), Integer.valueOf(0) });
    }
    if (i == 1)
    {
      ab.e("MicroMsg.WebViewUI", "not allow download file : %s", new Object[] { paramString1 });
      AppMethodBeat.o(7837);
      return;
    }
    if ((paramString4 != null) && (paramString4.equalsIgnoreCase("application/vnd.android.package-archive")))
    {
      ab.v("MicroMsg.WebViewUI", "edw onDownloadStart, report download url: %s", new Object[] { paramString1 });
      g.a(this.vgz.igU, 11154, new Object[] { paramString1 });
    }
    if ((this.vgz.igV == null) || (this.vgz.igV.ddV() == null))
    {
      ab.e("MicroMsg.WebViewUI", "onDownloadStart fail, wvPerm is null");
      AppMethodBeat.o(7837);
      return;
    }
    int j;
    if (paramString4 != null)
    {
      boolean bool1 = WebViewUI.f(this.vgz);
      ab.i("MicroMsg.WebViewUI", "onDownloadStart configOpen:%s", new Object[] { Boolean.valueOf(bool1) });
      paramString2 = WebViewUI.aiy(paramString3);
      if ((paramString2 != null) && (Pattern.matches("(?i).*\\.(doc|ppt|xls|docx|pptx|xlsx|wps|dps|et|txt|pdf)$", paramString2)))
      {
        j = 1;
        boolean bool2 = a.vog.contains(paramString4.toLowerCase());
        if (!bool1) {
          break label377;
        }
        i = k;
        if (j == 0)
        {
          if (!bool2) {
            break label377;
          }
          i = k;
        }
      }
    }
    for (;;)
    {
      if ((i == 0) && (!this.vgz.igV.ddV().jy(24)) && (!WebViewUI.g(this.vgz)))
      {
        ab.e("MicroMsg.WebViewUI", "onDownloadStart permission fail");
        AppMethodBeat.o(7837);
        return;
        j = 0;
        break;
        label377:
        i = 0;
        continue;
      }
      paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
      paramString1.addFlags(268435456);
      try
      {
        this.vgz.startActivity(paramString1);
        AppMethodBeat.o(7837);
        return;
      }
      catch (Exception paramString1)
      {
        ab.e("MicroMsg.WebViewUI", "startActivity fail, e = " + paramString1.getMessage());
        AppMethodBeat.o(7837);
        return;
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.17
 * JD-Core Version:    0.7.0.1
 */