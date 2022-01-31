package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.ah.e.a;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.cd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class n$1
  implements bx.a
{
  n$1(n paramn) {}
  
  public final void a(e.a parama)
  {
    parama = parama.dBs;
    if (parama.svH == null) {}
    while (bk.bl(aa.a(parama.svH))) {
      return;
    }
    y.d("MicroMsg.WebViewCacheSubCoreToolsExtension", "can not do brand pre-push");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modelcache.n.1
 * JD-Core Version:    0.7.0.1
 */