package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.a.d;

class bu
  implements android.webkit.DownloadListener
{
  bu(WebView paramWebView, DownloadListener paramDownloadListener) {}
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    AppMethodBeat.i(139429);
    if (this.a == null)
    {
      if (WebView.a(this.b) == null) {}
      for (paramString2 = null;; paramString2 = WebView.a(this.b).getApplicationInfo())
      {
        if ((paramString2 == null) || (!"com.tencent.mm".equals(paramString2.packageName))) {
          d.a(WebView.a(this.b), paramString1, null, null);
        }
        AppMethodBeat.o(139429);
        return;
      }
    }
    this.a.onDownloadStart(paramString1, paramString2, paramString3, paramString4, paramLong);
    AppMethodBeat.o(139429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.bu
 * JD-Core Version:    0.7.0.1
 */