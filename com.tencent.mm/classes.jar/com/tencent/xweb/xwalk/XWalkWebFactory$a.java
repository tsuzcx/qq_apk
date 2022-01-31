package com.tencent.xweb.xwalk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtension;
import org.xwalk.core.WebViewExtensionListener;

final class XWalkWebFactory$a
{
  private static boolean BHs = false;
  private static boolean BIl = false;
  private static boolean lNR = false;
  
  public static boolean hasInited()
  {
    return lNR;
  }
  
  public static boolean hasInitedCallback()
  {
    return BHs;
  }
  
  public static void initCallback(WebViewExtensionListener paramWebViewExtensionListener)
  {
    AppMethodBeat.i(85398);
    if (BHs)
    {
      AppMethodBeat.o(85398);
      return;
    }
    Log.i("XWebViewHelper", "initCallback");
    WebViewExtension.SetExtension(paramWebViewExtensionListener);
    BHs = true;
    AppMethodBeat.o(85398);
  }
  
  public static boolean isCoreReady()
  {
    return BIl;
  }
  
  public static boolean jX(Context paramContext)
  {
    AppMethodBeat.i(85397);
    boolean bool;
    if (lNR)
    {
      bool = lNR;
      AppMethodBeat.o(85397);
      return bool;
    }
    Log.i("XWebViewHelper", "preInit");
    if (j.fL(paramContext))
    {
      Log.i("XWebViewHelper", "preInit finished");
      lNR = true;
      BIl = true;
    }
    for (;;)
    {
      bool = lNR;
      AppMethodBeat.o(85397);
      return bool;
      Log.i("XWebViewHelper", "preInit xwalk is not available");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.XWalkWebFactory.a
 * JD-Core Version:    0.7.0.1
 */