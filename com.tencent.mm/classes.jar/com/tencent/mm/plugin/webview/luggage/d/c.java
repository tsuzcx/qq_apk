package com.tencent.mm.plugin.webview.luggage.d;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import java.util.Map;

public final class c
  implements WebResourceRequest
{
  private boolean WKn;
  private boolean WKo;
  private Map<String, String> WKp;
  private String eir;
  private boolean mIsRedirect;
  private Uri mUri;
  
  public c(Uri paramUri, boolean paramBoolean1, boolean paramBoolean2, String paramString, Map<String, String> paramMap)
  {
    this.mUri = paramUri;
    this.WKn = paramBoolean1;
    this.mIsRedirect = false;
    this.WKo = paramBoolean2;
    this.eir = paramString;
    this.WKp = paramMap;
  }
  
  public final String getMethod()
  {
    return this.eir;
  }
  
  public final Map<String, String> getRequestHeaders()
  {
    return this.WKp;
  }
  
  public final Uri getUrl()
  {
    return this.mUri;
  }
  
  public final boolean hasGesture()
  {
    return this.WKo;
  }
  
  public final boolean isForMainFrame()
  {
    return this.WKn;
  }
  
  public final boolean isRedirect()
  {
    return this.mIsRedirect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.d.c
 * JD-Core Version:    0.7.0.1
 */