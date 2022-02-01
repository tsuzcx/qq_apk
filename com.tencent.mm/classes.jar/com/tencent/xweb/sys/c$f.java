package com.tencent.xweb.sys;

import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a.a;
import java.util.Map;

public final class c$f
  implements com.tencent.xweb.WebResourceRequest
{
  private Map<String, String> JZZ;
  private boolean SEb;
  private boolean SEc;
  a SEd;
  private String method;
  private Uri url;
  
  public c$f(android.webkit.WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(153666);
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.url = paramWebResourceRequest.getUrl();
      this.SEb = paramWebResourceRequest.isForMainFrame();
      this.SEc = paramWebResourceRequest.hasGesture();
      this.method = paramWebResourceRequest.getMethod();
      this.JZZ = paramWebResourceRequest.getRequestHeaders();
      this.SEd = new a(this);
    }
    AppMethodBeat.o(153666);
  }
  
  public final String getMethod()
  {
    return this.method;
  }
  
  public final Map<String, String> getRequestHeaders()
  {
    return this.JZZ;
  }
  
  public final Uri getUrl()
  {
    return this.url;
  }
  
  public final boolean hasGesture()
  {
    return this.SEc;
  }
  
  public final boolean isForMainFrame()
  {
    return this.SEb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.sys.c.f
 * JD-Core Version:    0.7.0.1
 */