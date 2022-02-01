package com.tencent.mm.plugin.webview.luggage.d;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import java.util.Map;

public final class b
  implements WebResourceRequest
{
  private boolean CoQ;
  private boolean CoR;
  private Map<String, String> CoS;
  private String bWk;
  private boolean mIsRedirect;
  private Uri mUri;
  
  public b(Uri paramUri, boolean paramBoolean1, boolean paramBoolean2, String paramString, Map<String, String> paramMap)
  {
    this.mUri = paramUri;
    this.CoQ = paramBoolean1;
    this.mIsRedirect = false;
    this.CoR = paramBoolean2;
    this.bWk = paramString;
    this.CoS = paramMap;
  }
  
  public final String getMethod()
  {
    return this.bWk;
  }
  
  public final Map<String, String> getRequestHeaders()
  {
    return this.CoS;
  }
  
  public final Uri getUrl()
  {
    return this.mUri;
  }
  
  public final boolean hasGesture()
  {
    return this.CoR;
  }
  
  public final boolean isForMainFrame()
  {
    return this.CoQ;
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