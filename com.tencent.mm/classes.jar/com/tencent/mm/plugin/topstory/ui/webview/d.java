package com.tencent.mm.plugin.topstory.ui.webview;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cko;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import com.tencent.xweb.s;
import com.tencent.xweb.w;
import java.io.ByteArrayInputStream;

public final class d
  extends w
{
  private cko cKi;
  private c tmf;
  
  public d(cko paramcko, c paramc)
  {
    this.cKi = paramcko;
    this.tmf = paramc;
  }
  
  private s aer(String paramString)
  {
    s locals = null;
    AppMethodBeat.i(2174);
    byte[] arrayOfByte;
    boolean bool;
    if (paramString.startsWith("file:///data/data/com.tencent.mm/files/public/fts_browse/res/app.html"))
    {
      arrayOfByte = this.tmf.tlW;
      this.tmf.tlW = null;
      if (arrayOfByte == null) {
        break label210;
      }
      locals = new s("text/html", "utf8", new ByteArrayInputStream(arrayOfByte));
      bool = true;
    }
    for (;;)
    {
      if (bool) {
        ab.i("MicroMsg.TopStory.TopStoryWebViewClient", "tryToGetResourceFromCache useMemoryCache: %b url: %s", new Object[] { Boolean.valueOf(bool), paramString });
      }
      AppMethodBeat.o(2174);
      return locals;
      if (paramString.startsWith("file:///data/data/com.tencent.mm/files/public/fts_browse/res/dist/style.css"))
      {
        arrayOfByte = this.tmf.tlY;
        this.tmf.tlY = null;
        if (arrayOfByte != null)
        {
          locals = new s("text/css", "utf8", new ByteArrayInputStream(arrayOfByte));
          bool = true;
        }
      }
      else if (paramString.startsWith("file:///data/data/com.tencent.mm/files/public/fts_browse/res/dist/build.js"))
      {
        arrayOfByte = this.tmf.tlX;
        this.tmf.tlX = null;
        if (arrayOfByte != null)
        {
          locals = new s("application/x-javascript", "utf8", new ByteArrayInputStream(arrayOfByte));
          bool = true;
          continue;
        }
      }
      label210:
      bool = false;
    }
  }
  
  public final s a(WebView paramWebView, r paramr)
  {
    AppMethodBeat.i(2172);
    s locals2 = aer(paramr.getUrl().toString());
    s locals1 = locals2;
    if (locals2 == null) {
      locals1 = super.a(paramWebView, paramr);
    }
    AppMethodBeat.o(2172);
    return locals1;
  }
  
  public final s a(WebView paramWebView, r paramr, Bundle paramBundle)
  {
    AppMethodBeat.i(2173);
    s locals2 = aer(paramr.getUrl().toString());
    s locals1 = locals2;
    if (locals2 == null) {
      locals1 = super.a(paramWebView, paramr, paramBundle);
    }
    AppMethodBeat.o(2173);
    return locals1;
  }
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(2170);
    ab.i("MicroMsg.TopStory.TopStoryWebViewClient", "shouldOverrideUrlLoading %s", new Object[] { paramString });
    boolean bool = super.a(paramWebView, paramString);
    AppMethodBeat.o(2170);
    return bool;
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(2169);
    ab.i("MicroMsg.TopStory.TopStoryWebViewClient", "onPageFinished %s  %d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    super.b(paramWebView, paramString);
    com.tencent.mm.plugin.topstory.ui.d.c(this.cKi, "pageFinish", System.currentTimeMillis());
    AppMethodBeat.o(2169);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(2168);
    com.tencent.mm.plugin.topstory.ui.d.c(this.cKi, "pageStart", System.currentTimeMillis());
    ab.i("MicroMsg.TopStory.TopStoryWebViewClient", "onPageStarted %s %d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    super.b(paramWebView, paramString, paramBitmap);
    AppMethodBeat.o(2168);
  }
  
  public final s c(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(2171);
    s locals2 = aer(paramString);
    s locals1 = locals2;
    if (locals2 == null) {
      locals1 = super.c(paramWebView, paramString);
    }
    AppMethodBeat.o(2171);
    return locals1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.d
 * JD-Core Version:    0.7.0.1
 */