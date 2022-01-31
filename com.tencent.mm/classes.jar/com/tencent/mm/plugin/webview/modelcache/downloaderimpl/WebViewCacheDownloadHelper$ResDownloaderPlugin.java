package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import android.util.SparseArray;
import com.tencent.mm.pluginsdk.g.a.c.g;
import com.tencent.mm.pluginsdk.g.a.c.h;
import com.tencent.mm.pluginsdk.g.a.c.i;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.pluginsdk.g.a.c.n.a;
import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.c.q.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public final class WebViewCacheDownloadHelper$ResDownloaderPlugin
  implements g
{
  private final com.tencent.mm.pluginsdk.g.a.c.d rhO = new WebViewCacheDownloadHelper.ResDownloaderPlugin.1(this);
  
  public final String acb()
  {
    return "WebViewCache";
  }
  
  public final n.a c(l paraml)
  {
    if ((paraml == null) || (!(paraml instanceof e)))
    {
      y.e("MicroMsg.ResDownloader.WebViewCacheDownloadHelper", "getNetworkRequestHandler, get invalid request = " + paraml);
      return null;
    }
    return new c((e)paraml);
  }
  
  public final void ccB()
  {
    q.a.clL().a("WebViewCache", this.rhO);
  }
  
  public final h ccC()
  {
    return new d();
  }
  
  public final void onAccountRelease()
  {
    c.clearCache();
    ??? = q.a.clL();
    com.tencent.mm.pluginsdk.g.a.c.d locald = this.rhO;
    if (((q)???).gaO)
    {
      Object localObject3 = ((q)???).rXP;
      if (locald != null)
      {
        int i = "WebViewCache".hashCode();
        synchronized (((i)localObject3).rXu)
        {
          localObject3 = (List)((i)localObject3).rXt.get(i);
          if (localObject3 == null) {
            return;
          }
          ((List)localObject3).remove(locald);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper.ResDownloaderPlugin
 * JD-Core Version:    0.7.0.1
 */