package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.c.c;

class WebView$5
  implements android.webkit.DownloadListener
{
  WebView$5(WebView paramWebView, DownloadListener paramDownloadListener) {}
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    AppMethodBeat.i(54352);
    if (this.a == null)
    {
      if (WebView.a(this.b) == null) {}
      for (paramString2 = null;; paramString2 = WebView.a(this.b).getApplicationInfo())
      {
        if ((paramString2 == null) || (!"com.tencent.mm".equals(paramString2.packageName))) {
          c.a(WebView.a(this.b), paramString1, null, null);
        }
        AppMethodBeat.o(54352);
        return;
      }
    }
    this.a.onDownloadStart(paramString1, paramString2, paramString3, paramString4, paramLong);
    AppMethodBeat.o(54352);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView.5
 * JD-Core Version:    0.7.0.1
 */