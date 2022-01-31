package com.tencent.xweb.x5;

import android.net.Uri;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.xweb.l;
import java.util.Map;

public final class g$b
  implements l
{
  private String method;
  private Map<String, String> rXB;
  private Uri xjH;
  private boolean xjI;
  private boolean xjJ;
  
  public g$b(WebResourceRequest paramWebResourceRequest)
  {
    this.xjH = paramWebResourceRequest.getUrl();
    this.xjI = paramWebResourceRequest.isForMainFrame();
    this.xjJ = paramWebResourceRequest.hasGesture();
    this.method = paramWebResourceRequest.getMethod();
    this.rXB = paramWebResourceRequest.getRequestHeaders();
  }
  
  public final String getMethod()
  {
    return this.method;
  }
  
  public final Map<String, String> getRequestHeaders()
  {
    return this.rXB;
  }
  
  public final Uri getUrl()
  {
    return this.xjH;
  }
  
  public final boolean hasGesture()
  {
    return this.xjJ;
  }
  
  public final boolean isForMainFrame()
  {
    return this.xjI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.x5.g.b
 * JD-Core Version:    0.7.0.1
 */