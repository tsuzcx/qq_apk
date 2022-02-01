package com.tencent.mm.plugin.webview.luggage.webview_impl;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import java.util.Map;

public final class b
  implements WebResourceRequest
{
  private boolean IXl;
  private boolean IXm;
  private Map<String, String> IXn;
  private String csu;
  private boolean mIsRedirect;
  private Uri mUri;
  
  public b(Uri paramUri, boolean paramBoolean1, boolean paramBoolean2, String paramString, Map<String, String> paramMap)
  {
    this.mUri = paramUri;
    this.IXl = paramBoolean1;
    this.mIsRedirect = false;
    this.IXm = paramBoolean2;
    this.csu = paramString;
    this.IXn = paramMap;
  }
  
  public final String getMethod()
  {
    return this.csu;
  }
  
  public final Map<String, String> getRequestHeaders()
  {
    return this.IXn;
  }
  
  public final Uri getUrl()
  {
    return this.mUri;
  }
  
  public final boolean hasGesture()
  {
    return this.IXm;
  }
  
  public final boolean isForMainFrame()
  {
    return this.IXl;
  }
  
  public final boolean isRedirect()
  {
    return this.mIsRedirect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.webview_impl.b
 * JD-Core Version:    0.7.0.1
 */