package com.tencent.xweb.sys;

import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a.a;
import java.util.Map;

public final class c$e
  implements com.tencent.xweb.WebResourceRequest
{
  private Map<String, String> BTs;
  private boolean IQX;
  private boolean IQY;
  a IQZ;
  private String method;
  private Uri url;
  
  public c$e(android.webkit.WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(153666);
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.url = paramWebResourceRequest.getUrl();
      this.IQX = paramWebResourceRequest.isForMainFrame();
      this.IQY = paramWebResourceRequest.hasGesture();
      this.method = paramWebResourceRequest.getMethod();
      this.BTs = paramWebResourceRequest.getRequestHeaders();
      this.IQZ = new a(this);
    }
    AppMethodBeat.o(153666);
  }
  
  public final String getMethod()
  {
    return this.method;
  }
  
  public final Map<String, String> getRequestHeaders()
  {
    return this.BTs;
  }
  
  public final Uri getUrl()
  {
    return this.url;
  }
  
  public final boolean hasGesture()
  {
    return this.IQY;
  }
  
  public final boolean isForMainFrame()
  {
    return this.IQX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.sys.c.e
 * JD-Core Version:    0.7.0.1
 */