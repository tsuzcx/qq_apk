package com.tencent.xweb.sys;

import android.net.Uri;
import android.os.Build.VERSION;
import android.webkit.WebResourceRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a.a;
import com.tencent.xweb.r;
import java.util.Map;

public final class c$e
  implements r
{
  private boolean BHm;
  private boolean BHn;
  a BHo;
  private String method;
  private Uri url;
  private Map<String, String> vOs;
  
  public c$e(WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(84658);
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.url = paramWebResourceRequest.getUrl();
      this.BHm = paramWebResourceRequest.isForMainFrame();
      this.BHn = paramWebResourceRequest.hasGesture();
      this.method = paramWebResourceRequest.getMethod();
      this.vOs = paramWebResourceRequest.getRequestHeaders();
      this.BHo = new a(this);
    }
    AppMethodBeat.o(84658);
  }
  
  public final String getMethod()
  {
    return this.method;
  }
  
  public final Map<String, String> getRequestHeaders()
  {
    return this.vOs;
  }
  
  public final Uri getUrl()
  {
    return this.url;
  }
  
  public final boolean hasGesture()
  {
    return this.BHn;
  }
  
  public final boolean isForMainFrame()
  {
    return this.BHm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.sys.c.e
 * JD-Core Version:    0.7.0.1
 */