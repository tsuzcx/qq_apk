package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.cl.b;
import com.tencent.mm.h.a.bn;
import com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;

final class n$3
  extends c<bn>
{
  n$3(n paramn)
  {
    this.udX = bn.class.getName().hashCode();
  }
  
  private static boolean a(bn parambn)
  {
    if ((parambn == null) || (!(parambn instanceof bn))) {
      return false;
    }
    if (ae.getContext() != null) {
      b.afs("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
    }
    com.tencent.mm.vfs.e.K(com.tencent.mm.compatible.util.e.dzP, true);
    WebViewCacheDownloadHelper.ccA();
    n.ccw();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modelcache.n.3
 * JD-Core Version:    0.7.0.1
 */