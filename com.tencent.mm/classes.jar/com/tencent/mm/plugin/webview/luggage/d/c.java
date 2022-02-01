package com.tencent.mm.plugin.webview.luggage.d;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import java.util.Map;

public final class c
  implements WebResourceRequest
{
  private boolean PTB;
  private boolean PTC;
  private Map<String, String> PTD;
  private String cqz;
  private boolean mIsRedirect;
  private Uri mUri;
  
  public c(Uri paramUri, boolean paramBoolean1, boolean paramBoolean2, String paramString, Map<String, String> paramMap)
  {
    this.mUri = paramUri;
    this.PTB = paramBoolean1;
    this.mIsRedirect = false;
    this.PTC = paramBoolean2;
    this.cqz = paramString;
    this.PTD = paramMap;
  }
  
  public final String getMethod()
  {
    return this.cqz;
  }
  
  public final Map<String, String> getRequestHeaders()
  {
    return this.PTD;
  }
  
  public final Uri getUrl()
  {
    return this.mUri;
  }
  
  public final boolean hasGesture()
  {
    return this.PTC;
  }
  
  public final boolean isForMainFrame()
  {
    return this.PTB;
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