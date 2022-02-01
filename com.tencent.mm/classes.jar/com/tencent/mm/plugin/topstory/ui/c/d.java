package com.tencent.mm.plugin.topstory.ui.c;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.webview.j;
import com.tencent.mm.protocal.protobuf.fnt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView;

public final class d
  extends j
{
  private fnt ieC;
  
  public d(fnt paramfnt)
  {
    super(1);
    this.ieC = paramfnt;
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(126575);
    Log.i("MicroMsg.TopStory.TopStoryWebViewClient", "onPageFinished %s  %d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    super.b(paramWebView, paramString);
    com.tencent.mm.plugin.topstory.ui.d.c(this.ieC, "pageFinish", System.currentTimeMillis());
    AppMethodBeat.o(126575);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(126574);
    com.tencent.mm.plugin.topstory.ui.d.c(this.ieC, "pageStart", System.currentTimeMillis());
    Log.i("MicroMsg.TopStory.TopStoryWebViewClient", "onPageStarted %s %d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    super.b(paramWebView, paramString, paramBitmap);
    AppMethodBeat.o(126574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.c.d
 * JD-Core Version:    0.7.0.1
 */