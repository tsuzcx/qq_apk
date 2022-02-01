package com.tencent.mm.plugin.webview.luggage.d;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import java.util.Map;

public final class b
  implements WebResourceRequest
{
  private boolean AWD;
  private boolean AWE;
  private Map<String, String> AWF;
  private String bZn;
  private boolean mIsRedirect;
  private Uri mUri;
  
  public b(Uri paramUri, boolean paramBoolean1, boolean paramBoolean2, String paramString, Map<String, String> paramMap)
  {
    this.mUri = paramUri;
    this.AWD = paramBoolean1;
    this.mIsRedirect = false;
    this.AWE = paramBoolean2;
    this.bZn = paramString;
    this.AWF = paramMap;
  }
  
  public final String getMethod()
  {
    return this.bZn;
  }
  
  public final Map<String, String> getRequestHeaders()
  {
    return this.AWF;
  }
  
  public final Uri getUrl()
  {
    return this.mUri;
  }
  
  public final boolean hasGesture()
  {
    return this.AWE;
  }
  
  public final boolean isForMainFrame()
  {
    return this.AWD;
  }
  
  public final boolean isRedirect()
  {
    return this.mIsRedirect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.d.b
 * JD-Core Version:    0.7.0.1
 */