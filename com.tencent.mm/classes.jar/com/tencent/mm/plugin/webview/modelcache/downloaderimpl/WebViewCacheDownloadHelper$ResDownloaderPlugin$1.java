package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import com.tencent.mm.pluginsdk.g.a.c.d;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.pluginsdk.g.a.d.a;

final class WebViewCacheDownloadHelper$ResDownloaderPlugin$1
  implements d
{
  WebViewCacheDownloadHelper$ResDownloaderPlugin$1(WebViewCacheDownloadHelper.ResDownloaderPlugin paramResDownloaderPlugin) {}
  
  private static void SE(String paramString)
  {
    paramString = q.a.clL().Wl(paramString);
    if (paramString != null) {
      a.Wp(paramString.field_filePath);
    }
  }
  
  public final void SD(String paramString)
  {
    SE(paramString);
  }
  
  public final void a(String paramString, m paramm)
  {
    b.c(paramString, paramm);
  }
  
  public final String acb()
  {
    return "WebViewCache";
  }
  
  public final void b(String paramString, m paramm)
  {
    SE(paramString);
    b.c(paramString, paramm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper.ResDownloaderPlugin.1
 * JD-Core Version:    0.7.0.1
 */