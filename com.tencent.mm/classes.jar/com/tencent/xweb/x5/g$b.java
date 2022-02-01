package com.tencent.xweb.x5;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class g$b
  implements com.tencent.xweb.WebResourceRequest
{
  private Map<String, String> Fjf;
  private boolean MQX;
  private boolean MQY;
  private String method;
  private Uri url;
  
  public g$b(com.tencent.smtt.export.external.interfaces.WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(153848);
    this.url = paramWebResourceRequest.getUrl();
    this.MQX = paramWebResourceRequest.isForMainFrame();
    this.MQY = paramWebResourceRequest.hasGesture();
    this.method = paramWebResourceRequest.getMethod();
    this.Fjf = paramWebResourceRequest.getRequestHeaders();
    AppMethodBeat.o(153848);
  }
  
  public final String getMethod()
  {
    return this.method;
  }
  
  public final Map<String, String> getRequestHeaders()
  {
    return this.Fjf;
  }
  
  public final Uri getUrl()
  {
    return this.url;
  }
  
  public final boolean hasGesture()
  {
    return this.MQY;
  }
  
  public final boolean isForMainFrame()
  {
    return this.MQX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.g.b
 * JD-Core Version:    0.7.0.1
 */