package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import android.os.Looper;
import com.tencent.mm.h.a.uf;
import com.tencent.mm.vfs.e;

public final class WebViewCacheDownloadHelper
{
  private static final byte[] rhM = new byte[0];
  private static volatile WebViewCacheDownloadHelper rhN = null;
  
  static void a(f paramf)
  {
    uf localuf = new uf();
    localuf.ceF.url = paramf.url;
    localuf.ceF.filePath = paramf.filePath;
    localuf.ceF.version = paramf.version;
    localuf.ceF.appId = paramf.appId;
    localuf.ceF.ceG = paramf.ceG;
    localuf.ceF.ceH = paramf.ceH;
    localuf.ceF.ceI = paramf.ceI;
    localuf.ceF.aRN = paramf.aRN;
    localuf.ceF.exception = paramf.exception;
    localuf.ceF.ceJ = paramf.ceJ;
    com.tencent.mm.sdk.b.a.udP.a(localuf, Looper.getMainLooper());
  }
  
  public static void ccA()
  {
    e.K(a.rhL, true);
  }
  
  public static WebViewCacheDownloadHelper ccz()
  {
    if (rhN == null) {}
    synchronized (rhM)
    {
      if (rhN == null) {
        rhN = new WebViewCacheDownloadHelper();
      }
      return rhN;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper
 * JD-Core Version:    0.7.0.1
 */