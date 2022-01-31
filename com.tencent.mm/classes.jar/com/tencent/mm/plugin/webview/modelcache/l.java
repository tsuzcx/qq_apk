package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.sdk.platformtools.y;

public final class l
{
  final String appId;
  final String bTY;
  final String ceG;
  final String ceH;
  final int ceI;
  final String rhl;
  final a rhm;
  
  public l(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    this.appId = paramString1;
    this.ceG = paramString2;
    this.rhl = paramString3;
    this.ceI = paramInt;
    this.ceH = paramString4;
    y.i("MicroMsg.WebViewCacheResWriter", "init WebViewCacheResWriter, appId = %s, domain = %s, mainURL = %s, cacheType = %d", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt) });
    this.rhm = a.Su(paramString1);
    if (this.rhm != null)
    {
      paramString1 = this.rhm;
      paramString2 = String.format("%d_%d_%d_%d", new Object[] { Integer.valueOf(paramString2.hashCode()), Integer.valueOf(paramInt), Integer.valueOf(paramString3.hashCode()), Integer.valueOf(paramString4.hashCode()) });
      this.bTY = (paramString1.path + "/" + paramString2);
      return;
    }
    this.bTY = null;
    y.e("MicroMsg.WebViewCacheResWriter", "get null appIdResDir");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modelcache.l
 * JD-Core Version:    0.7.0.1
 */