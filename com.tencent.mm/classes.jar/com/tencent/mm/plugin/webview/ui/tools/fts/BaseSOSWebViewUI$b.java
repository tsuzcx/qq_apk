package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.core.f;
import com.tencent.mm.plugin.webview.core.j;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;

final class BaseSOSWebViewUI$b
  extends k
{
  BaseSOSWebViewUI.b.a Jnu;
  
  private BaseSOSWebViewUI$b(BaseSOSWebViewUI paramBaseSOSWebViewUI)
  {
    AppMethodBeat.i(211213);
    this.Jnu = new BaseSOSWebViewUI.b.a(this, (byte)0);
    AppMethodBeat.o(211213);
  }
  
  private static WebResourceResponse aXq(String paramString)
  {
    AppMethodBeat.i(211218);
    Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "url=%s | thread=%d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    paramString = Uri.parse(paramString);
    try
    {
      paramString = s.openRead(paramString.getQueryParameter("path"));
      if (paramString != null)
      {
        paramString = new WebResourceResponse("image/*", "utf8", paramString);
        AppMethodBeat.o(211218);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
      AppMethodBeat.o(211218);
    }
    return null;
  }
  
  public final boolean aXQ(String paramString)
  {
    AppMethodBeat.i(211214);
    if (this.Jnm.IRT)
    {
      AppMethodBeat.o(211214);
      return true;
    }
    boolean bool = super.aXQ(paramString);
    AppMethodBeat.o(211214);
    return bool;
  }
  
  public final WebResourceResponse b(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(211217);
    if ((paramWebResourceRequest != null) && (paramWebResourceRequest.getUrl() != null) && (paramWebResourceRequest.getUrl().toString().startsWith("weixin://fts")))
    {
      paramWebView = aXq(paramWebResourceRequest.getUrl().toString());
      AppMethodBeat.o(211217);
      return paramWebView;
    }
    AppMethodBeat.o(211217);
    return null;
  }
  
  public final boolean e(String paramString, Intent paramIntent)
  {
    AppMethodBeat.i(211215);
    this.Jnm.ggI();
    boolean bool = super.e(paramString, paramIntent);
    AppMethodBeat.o(211215);
    return bool;
  }
  
  public final f gai()
  {
    return this.Jnu;
  }
  
  public final j gaj()
  {
    AppMethodBeat.i(211216);
    b localb = new b((byte)0);
    AppMethodBeat.o(211216);
    return localb;
  }
  
  final class b
    extends j
  {
    private b() {}
    
    public final void cpR()
    {
      AppMethodBeat.i(211212);
      BaseSOSWebViewUI.b(BaseSOSWebViewUI.b.this.Jnm);
      BaseSOSWebViewUI.b.this.Jnm.ggH();
      AppMethodBeat.o(211212);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.b
 * JD-Core Version:    0.7.0.1
 */