package com.tencent.xweb.x5;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class d$b
  implements com.tencent.xweb.WebResourceRequest
{
  private Map<String, String> XWH;
  private boolean aikA;
  private boolean aikB;
  private Uri aikz;
  private String method;
  
  public d$b(com.tencent.smtt.export.external.interfaces.WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(153848);
    if (paramWebResourceRequest != null)
    {
      this.aikz = paramWebResourceRequest.getUrl();
      this.aikA = paramWebResourceRequest.isForMainFrame();
      this.aikB = paramWebResourceRequest.hasGesture();
      this.method = paramWebResourceRequest.getMethod();
      this.XWH = paramWebResourceRequest.getRequestHeaders();
    }
    AppMethodBeat.o(153848);
  }
  
  public final String getMethod()
  {
    return this.method;
  }
  
  public final Map<String, String> getRequestHeaders()
  {
    return this.XWH;
  }
  
  public final Uri getUrl()
  {
    return this.aikz;
  }
  
  public final boolean hasGesture()
  {
    return this.aikB;
  }
  
  public final boolean isForMainFrame()
  {
    return this.aikA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.x5.d.b
 * JD-Core Version:    0.7.0.1
 */