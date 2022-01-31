package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class WebViewExtension$1
  extends WebViewExtensionInterface
{
  public final int getHostByName(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(85526);
    if (WebViewExtension.access$000() != null)
    {
      int i = WebViewExtension.access$000().getHostByName(paramString, paramList);
      AppMethodBeat.o(85526);
      return i;
    }
    AppMethodBeat.o(85526);
    return 0;
  }
  
  public final Object onMiscCallBack(String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(85525);
    if (WebViewExtension.access$000() != null)
    {
      paramString = WebViewExtension.access$000().onMiscCallBack(paramString, paramVarArgs);
      AppMethodBeat.o(85525);
      return paramString;
    }
    AppMethodBeat.o(85525);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.xwalk.core.WebViewExtension.1
 * JD-Core Version:    0.7.0.1
 */