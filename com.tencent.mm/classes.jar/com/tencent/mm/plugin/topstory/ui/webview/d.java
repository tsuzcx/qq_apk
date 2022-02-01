package com.tencent.mm.plugin.topstory.ui.webview;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dnp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;

public final class d
  extends ac
{
  private c Byt;
  private dnp dLe;
  
  public d(dnp paramdnp, c paramc)
  {
    this.dLe = paramdnp;
    this.Byt = paramc;
  }
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(126576);
    ad.i("MicroMsg.TopStory.TopStoryWebViewClient", "shouldOverrideUrlLoading %s", new Object[] { paramString });
    boolean bool = super.a(paramWebView, paramString);
    AppMethodBeat.o(126576);
    return bool;
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(126575);
    ad.i("MicroMsg.TopStory.TopStoryWebViewClient", "onPageFinished %s  %d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    super.b(paramWebView, paramString);
    com.tencent.mm.plugin.topstory.ui.d.c(this.dLe, "pageFinish", System.currentTimeMillis());
    AppMethodBeat.o(126575);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(126574);
    com.tencent.mm.plugin.topstory.ui.d.c(this.dLe, "pageStart", System.currentTimeMillis());
    ad.i("MicroMsg.TopStory.TopStoryWebViewClient", "onPageStarted %s %d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    super.b(paramWebView, paramString, paramBitmap);
    AppMethodBeat.o(126574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.d
 * JD-Core Version:    0.7.0.1
 */