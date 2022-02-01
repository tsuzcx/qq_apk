package com.tencent.xweb.pinus;

import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.ab;
import java.util.Map;

public final class g$f
  implements com.tencent.xweb.WebResourceRequest
{
  private Map<String, String> XWH;
  private boolean aikA;
  private boolean aikB;
  ab aikC;
  private Uri aikz;
  private String method;
  
  public g$f(android.webkit.WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(213274);
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.aikz = paramWebResourceRequest.getUrl();
      this.aikA = paramWebResourceRequest.isForMainFrame();
      this.aikB = paramWebResourceRequest.hasGesture();
      this.method = paramWebResourceRequest.getMethod();
      this.XWH = paramWebResourceRequest.getRequestHeaders();
      this.aikC = new ab(this);
    }
    AppMethodBeat.o(213274);
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
 * Qualified Name:     com.tencent.xweb.pinus.g.f
 * JD-Core Version:    0.7.0.1
 */