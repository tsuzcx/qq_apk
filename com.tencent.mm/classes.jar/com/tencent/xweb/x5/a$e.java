package com.tencent.xweb.x5;

import android.net.Uri;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.xweb.l;
import java.util.Map;

public final class a$e
  implements WebResourceRequest
{
  public l xkm;
  
  private a$e(l paraml)
  {
    this.xkm = paraml;
  }
  
  public static WebResourceRequest a(l paraml)
  {
    if (paraml == null) {
      return null;
    }
    return new e(paraml);
  }
  
  public final String getMethod()
  {
    return this.xkm.getMethod();
  }
  
  public final Map<String, String> getRequestHeaders()
  {
    return this.xkm.getRequestHeaders();
  }
  
  public final Uri getUrl()
  {
    return this.xkm.getUrl();
  }
  
  public final boolean hasGesture()
  {
    return this.xkm.hasGesture();
  }
  
  public final boolean isForMainFrame()
  {
    return this.xkm.isForMainFrame();
  }
  
  public final boolean isRedirect()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.a.e
 * JD-Core Version:    0.7.0.1
 */