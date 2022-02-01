package com.tencent.xweb.x5.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;

public final class i
  implements c
{
  public final boolean getCanReboot()
  {
    AppMethodBeat.i(154149);
    boolean bool = WebView.getTbsNeedReboot();
    AppMethodBeat.o(154149);
    return bool;
  }
  
  public final String getCrashExtraMessage(Context paramContext)
  {
    AppMethodBeat.i(154148);
    paramContext = WebView.getCrashExtraMessage(paramContext);
    AppMethodBeat.o(154148);
    return paramContext;
  }
  
  public final int getTbsCoreVersion(Context paramContext)
  {
    AppMethodBeat.i(154146);
    int i = WebView.getTbsCoreVersion(paramContext);
    AppMethodBeat.o(154146);
    return i;
  }
  
  public final int getTbsSDKVersion(Context paramContext)
  {
    AppMethodBeat.i(154147);
    int i = WebView.getTbsSDKVersion(paramContext);
    AppMethodBeat.o(154147);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.x5.sdk.i
 * JD-Core Version:    0.7.0.1
 */