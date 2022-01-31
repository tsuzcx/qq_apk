package com.tencent.mm.plugin.webview.luggage.d;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import java.util.Map;

public final class b
  implements WebResourceRequest
{
  private String bxW;
  private boolean mIsRedirect;
  private Uri mUri;
  private boolean uVa;
  private boolean uVb;
  private Map<String, String> uVc;
  
  public b(Uri paramUri, boolean paramBoolean1, boolean paramBoolean2, String paramString, Map<String, String> paramMap)
  {
    this.mUri = paramUri;
    this.uVa = paramBoolean1;
    this.mIsRedirect = false;
    this.uVb = paramBoolean2;
    this.bxW = paramString;
    this.uVc = paramMap;
  }
  
  public final String getMethod()
  {
    return this.bxW;
  }
  
  public final Map<String, String> getRequestHeaders()
  {
    return this.uVc;
  }
  
  public final Uri getUrl()
  {
    return this.mUri;
  }
  
  public final boolean hasGesture()
  {
    return this.uVb;
  }
  
  public final boolean isForMainFrame()
  {
    return this.uVa;
  }
  
  public final boolean isRedirect()
  {
    return this.mIsRedirect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.d.b
 * JD-Core Version:    0.7.0.1
 */