package com.tencent.xweb.x5;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.xweb.r;
import java.util.Map;

public final class a$e
  implements WebResourceRequest
{
  public r BHR;
  
  private a$e(r paramr)
  {
    this.BHR = paramr;
  }
  
  public static WebResourceRequest a(r paramr)
  {
    AppMethodBeat.i(84782);
    if (paramr == null)
    {
      AppMethodBeat.o(84782);
      return null;
    }
    paramr = new e(paramr);
    AppMethodBeat.o(84782);
    return paramr;
  }
  
  public final String getMethod()
  {
    AppMethodBeat.i(84786);
    String str = this.BHR.getMethod();
    AppMethodBeat.o(84786);
    return str;
  }
  
  public final Map<String, String> getRequestHeaders()
  {
    AppMethodBeat.i(84787);
    Map localMap = this.BHR.getRequestHeaders();
    AppMethodBeat.o(84787);
    return localMap;
  }
  
  public final Uri getUrl()
  {
    AppMethodBeat.i(84783);
    Uri localUri = this.BHR.getUrl();
    AppMethodBeat.o(84783);
    return localUri;
  }
  
  public final boolean hasGesture()
  {
    AppMethodBeat.i(84785);
    boolean bool = this.BHR.hasGesture();
    AppMethodBeat.o(84785);
    return bool;
  }
  
  public final boolean isForMainFrame()
  {
    AppMethodBeat.i(84784);
    boolean bool = this.BHR.isForMainFrame();
    AppMethodBeat.o(84784);
    return bool;
  }
  
  public final boolean isRedirect()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.a.e
 * JD-Core Version:    0.7.0.1
 */