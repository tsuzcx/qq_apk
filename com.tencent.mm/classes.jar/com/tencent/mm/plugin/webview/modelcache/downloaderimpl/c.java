package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import com.tencent.mm.pluginsdk.g.a.c.j;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.pluginsdk.g.a.c.m;
import com.tencent.mm.pluginsdk.g.a.c.n.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.ConcurrentHashMap;

public final class c
  extends n.a<e>
{
  private static final ConcurrentHashMap<String, Boolean> rhQ = new ConcurrentHashMap();
  
  public c(e parame)
  {
    super(parame);
  }
  
  public static void clearCache()
  {
    rhQ.clear();
  }
  
  protected final m a(j paramj)
  {
    if (rhQ.putIfAbsent(((e)aci()).bjl(), Boolean.TRUE) != null)
    {
      y.i("MicroMsg.ResDownloader.WebViewCacheDownloadNetworkRequestHandler", "request urlKey = %s, already downloading this file", new Object[] { ((e)aci()).rVT });
      return null;
    }
    paramj = super.a(paramj);
    rhQ.remove(((e)aci()).bjl());
    return paramj;
  }
  
  public final String acb()
  {
    return "WebViewCache";
  }
  
  public final boolean acc()
  {
    return true;
  }
  
  public final boolean acd()
  {
    return false;
  }
  
  public final boolean ace()
  {
    return true;
  }
  
  public final boolean acg()
  {
    return false;
  }
  
  public final boolean ct(long paramLong)
  {
    if (!super.ct(paramLong)) {}
    while (paramLong >= 5242880L) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modelcache.downloaderimpl.c
 * JD-Core Version:    0.7.0.1
 */