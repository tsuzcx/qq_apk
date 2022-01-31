package com.tencent.xweb.xwalk;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a.a;
import com.tencent.xweb.r;
import java.util.Map;
import org.xwalk.core.XWalkWebResourceRequest;

public final class f$i
  implements r
{
  private boolean BHm;
  private boolean BHn;
  a BHo;
  private String method;
  private Uri url;
  private Map<String, String> vOs;
  
  public f$i(XWalkWebResourceRequest paramXWalkWebResourceRequest)
  {
    AppMethodBeat.i(85229);
    this.url = paramXWalkWebResourceRequest.getUrl();
    this.BHm = paramXWalkWebResourceRequest.isForMainFrame();
    this.BHn = paramXWalkWebResourceRequest.hasGesture();
    this.method = paramXWalkWebResourceRequest.getMethod();
    this.vOs = paramXWalkWebResourceRequest.getRequestHeaders();
    this.BHo = new a(this);
    AppMethodBeat.o(85229);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.f.i
 * JD-Core Version:    0.7.0.1
 */