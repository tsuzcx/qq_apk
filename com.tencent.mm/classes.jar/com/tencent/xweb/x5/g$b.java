package com.tencent.xweb.x5;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.xweb.r;
import java.util.Map;

public final class g$b
  implements r
{
  private boolean BHm;
  private boolean BHn;
  private String method;
  private Uri url;
  private Map<String, String> vOs;
  
  public g$b(WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(84824);
    this.url = paramWebResourceRequest.getUrl();
    this.BHm = paramWebResourceRequest.isForMainFrame();
    this.BHn = paramWebResourceRequest.hasGesture();
    this.method = paramWebResourceRequest.getMethod();
    this.vOs = paramWebResourceRequest.getRequestHeaders();
    AppMethodBeat.o(84824);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.x5.g.b
 * JD-Core Version:    0.7.0.1
 */