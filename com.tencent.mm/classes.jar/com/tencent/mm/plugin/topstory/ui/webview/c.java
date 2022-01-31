package com.tencent.mm.plugin.topstory.ui.webview;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.protocal.c.byb;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import com.tencent.xweb.p;
import java.io.ByteArrayInputStream;

public final class c
  extends p
{
  private byb cbF;
  private b pIo;
  
  public c(byb parambyb, b paramb)
  {
    this.cbF = parambyb;
    this.pIo = paramb;
  }
  
  private m PP(String paramString)
  {
    m localm = null;
    byte[] arrayOfByte;
    boolean bool;
    if (paramString.startsWith("file:///data/data/com.tencent.mm/files/public/fts_browse/res/app.html"))
    {
      arrayOfByte = this.pIo.pIh;
      this.pIo.pIh = null;
      if (arrayOfByte == null) {
        break label198;
      }
      localm = new m("text/html", "utf8", new ByteArrayInputStream(arrayOfByte));
      bool = true;
    }
    for (;;)
    {
      if (bool) {
        y.i("MicroMsg.TopStory.TopStoryWebViewClient", "tryToGetResourceFromCache useMemoryCache: %b url: %s", new Object[] { Boolean.valueOf(bool), paramString });
      }
      return localm;
      if (paramString.startsWith("file:///data/data/com.tencent.mm/files/public/fts_browse/res/dist/style.css"))
      {
        arrayOfByte = this.pIo.pIj;
        this.pIo.pIj = null;
        if (arrayOfByte != null)
        {
          localm = new m("text/css", "utf8", new ByteArrayInputStream(arrayOfByte));
          bool = true;
        }
      }
      else if (paramString.startsWith("file:///data/data/com.tencent.mm/files/public/fts_browse/res/dist/build.js"))
      {
        arrayOfByte = this.pIo.pIi;
        this.pIo.pIi = null;
        if (arrayOfByte != null)
        {
          localm = new m("application/x-javascript", "utf8", new ByteArrayInputStream(arrayOfByte));
          bool = true;
          continue;
        }
      }
      label198:
      bool = false;
    }
  }
  
  public final m a(WebView paramWebView, l paraml)
  {
    m localm2 = PP(paraml.getUrl().toString());
    m localm1 = localm2;
    if (localm2 == null) {
      localm1 = super.a(paramWebView, paraml);
    }
    return localm1;
  }
  
  public final m a(WebView paramWebView, l paraml, Bundle paramBundle)
  {
    m localm2 = PP(paraml.getUrl().toString());
    m localm1 = localm2;
    if (localm2 == null) {
      localm1 = super.a(paramWebView, paraml, paramBundle);
    }
    return localm1;
  }
  
  public final void a(WebView paramWebView, String paramString)
  {
    y.i("MicroMsg.TopStory.TopStoryWebViewClient", "onPageFinished %s  %d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    super.a(paramWebView, paramString);
    d.c(this.cbF, "pageFinish", System.currentTimeMillis());
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    d.c(this.cbF, "pageStart", System.currentTimeMillis());
    y.i("MicroMsg.TopStory.TopStoryWebViewClient", "onPageStarted %s %d", new Object[] { paramString, Long.valueOf(Thread.currentThread().getId()) });
    super.b(paramWebView, paramString, paramBitmap);
  }
  
  public final boolean b(WebView paramWebView, String paramString)
  {
    y.i("MicroMsg.TopStory.TopStoryWebViewClient", "shouldOverrideUrlLoading %s", new Object[] { paramString });
    return super.b(paramWebView, paramString);
  }
  
  public final m c(WebView paramWebView, String paramString)
  {
    m localm2 = PP(paramString);
    m localm1 = localm2;
    if (localm2 == null) {
      localm1 = super.c(paramWebView, paramString);
    }
    return localm1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.webview.c
 * JD-Core Version:    0.7.0.1
 */