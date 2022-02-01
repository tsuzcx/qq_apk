package com.tencent.xweb.x5;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class g$b
  implements com.tencent.xweb.WebResourceRequest
{
  private Map<String, String> JZZ;
  private boolean SEb;
  private boolean SEc;
  private String method;
  private Uri url;
  
  public g$b(com.tencent.smtt.export.external.interfaces.WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(153848);
    this.url = paramWebResourceRequest.getUrl();
    this.SEb = paramWebResourceRequest.isForMainFrame();
    this.SEc = paramWebResourceRequest.hasGesture();
    this.method = paramWebResourceRequest.getMethod();
    this.JZZ = paramWebResourceRequest.getRequestHeaders();
    AppMethodBeat.o(153848);
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
 * Qualified Name:     com.tencent.xweb.x5.g.b
 * JD-Core Version:    0.7.0.1
 */