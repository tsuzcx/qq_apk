package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Set;
import java.util.regex.Pattern;

final class WebViewUI$17
  implements DownloadListener
{
  WebViewUI$17(WebViewUI paramWebViewUI) {}
  
  public final void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    int m = 1;
    y.i("MicroMsg.WebViewUI", "edw onDownloadStart, url = " + paramString1 + ", mimetype = " + paramString4 + ", userAgent = " + paramString2);
    int i = this.rpH.getIntent().getIntExtra("key_download_restrict", 0);
    paramString2 = this.rpH.getIntent().getStringExtra("key_function_id");
    if (!bk.bl(paramString2)) {
      h.nFQ.f(14596, new Object[] { paramString2, Integer.valueOf(i), Integer.valueOf(0) });
    }
    if (i == 1)
    {
      y.e("MicroMsg.WebViewUI", "not allow download file : %s", new Object[] { paramString1 });
      return;
    }
    if ((paramString4 != null) && (paramString4.equalsIgnoreCase("application/vnd.android.package-archive")))
    {
      y.v("MicroMsg.WebViewUI", "edw onDownloadStart, report download url: %s", new Object[] { paramString1 });
      e.a(this.rpH.gGn, 11154, new Object[] { paramString1 });
    }
    for (int j = 1;; j = 0)
    {
      if ((this.rpH.gGo == null) || (this.rpH.gGo.cdI() == null))
      {
        y.e("MicroMsg.WebViewUI", "onDownloadStart fail, wvPerm is null");
        return;
      }
      int k;
      if (paramString4 != null)
      {
        boolean bool1 = WebViewUI.H(this.rpH);
        y.i("MicroMsg.WebViewUI", "onDownloadStart configOpen:%s", new Object[] { Boolean.valueOf(bool1) });
        paramString2 = WebViewUI.Tw(paramString3);
        if ((paramString2 != null) && (Pattern.matches("(?i).*\\.(doc|ppt|xls|docx|pptx|xlsx|wps|dps|et|txt|pdf)$", paramString2)))
        {
          k = 1;
          boolean bool2 = a.rxn.contains(paramString4.toLowerCase());
          if (!bool1) {
            break label356;
          }
          i = m;
          if (k == 0)
          {
            if (!bool2) {
              break label356;
            }
            i = m;
          }
        }
      }
      for (;;)
      {
        if ((i == 0) && (!this.rpH.gGo.cdI().hi(24)) && (!WebViewUI.I(this.rpH)))
        {
          y.e("MicroMsg.WebViewUI", "onDownloadStart permission fail");
          return;
          k = 0;
          break;
          label356:
          i = 0;
          continue;
        }
        if (j != 0)
        {
          WebViewUI.a(this.rpH, paramString1, paramLong);
          return;
        }
        paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
        paramString1.addFlags(268435456);
        try
        {
          this.rpH.startActivity(paramString1);
          return;
        }
        catch (Exception paramString1)
        {
          y.e("MicroMsg.WebViewUI", "startActivity fail, e = " + paramString1.getMessage());
          return;
        }
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.17
 * JD-Core Version:    0.7.0.1
 */