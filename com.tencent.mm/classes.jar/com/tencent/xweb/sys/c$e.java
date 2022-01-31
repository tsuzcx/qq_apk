package com.tencent.xweb.sys;

import android.net.Uri;
import android.os.Build.VERSION;
import android.webkit.WebResourceRequest;
import com.tencent.xweb.a.a;
import com.tencent.xweb.l;
import java.util.Map;

public final class c$e
  implements l
{
  private String method;
  private Map<String, String> rXB;
  private Uri xjH;
  private boolean xjI;
  private boolean xjJ;
  a xjK;
  
  public c$e(WebResourceRequest paramWebResourceRequest)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.xjH = paramWebResourceRequest.getUrl();
      this.xjI = paramWebResourceRequest.isForMainFrame();
      this.xjJ = paramWebResourceRequest.hasGesture();
      this.method = paramWebResourceRequest.getMethod();
      this.rXB = paramWebResourceRequest.getRequestHeaders();
      this.xjK = new a(this);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.xweb.sys.c.e
 * JD-Core Version:    0.7.0.1
 */