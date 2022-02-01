package com.tencent.mm.plugin.topstory.ui.webview;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.xweb.WebView;

public final class d
  extends com.tencent.xweb.ac
{
  private c AgH;
  private dia dyS;
  
  public d(dia paramdia, c paramc)
  {
    this.dyS = paramdia;
    this.AgH = paramc;
  }
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(126576);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.TopStory.TopStoryWebViewClient", "shouldOverrideUrlLoading %s", new Object[] { paramString });
    boolean bool = super.a(paramWebView, paramString);
    AppMethodBeat.o(126576);
    return bool;
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(126575);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.TopStory.TopStoryWebViewClient", "onPageFinished %s  %d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    super.b(paramWebView, paramString);
    com.tencent.mm.plugin.topstory.ui.d.c(this.dyS, "pageFinish", System.currentTimeMillis());
    AppMethodBeat.o(126575);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(126574);
    com.tencent.mm.plugin.topstory.ui.d.c(this.dyS, "pageStart", System.currentTimeMillis());
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.TopStory.TopStoryWebViewClient", "onPageStarted %s %d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    super.b(paramWebView, paramString, paramBitmap);
    AppMethodBeat.o(126574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.d
 * JD-Core Version:    0.7.0.1
 */