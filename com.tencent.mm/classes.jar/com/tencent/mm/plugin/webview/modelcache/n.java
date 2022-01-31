package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.model.au;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.sdk.platformtools.y;

public final class n
{
  public final bx.a rhn = new n.1(this);
  public final com.tencent.mm.sdk.b.c rho = new n.2(this);
  public final com.tencent.mm.sdk.b.c rhp = new n.3(this);
  
  public static void ccw()
  {
    Object localObject = null;
    try
    {
      com.tencent.mm.model.c localc = au.Hx();
      localObject = localc;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.WebViewCacheSubCoreToolsExtension", "setupSFS, getAccStg, exception = %s", new Object[] { localException });
      }
    }
    if (localObject == null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modelcache.n
 * JD-Core Version:    0.7.0.1
 */