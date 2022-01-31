package com.tencent.xweb.xwalk;

import android.content.Context;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtension;
import org.xwalk.core.WebViewExtensionListener;

final class XWalkWebFactory$a
{
  private static boolean jEt = false;
  private static boolean xjO = false;
  private static boolean xkG = false;
  
  public static boolean hasInited()
  {
    return jEt;
  }
  
  public static boolean hasInitedCallback()
  {
    return xjO;
  }
  
  public static void initCallback(WebViewExtensionListener paramWebViewExtensionListener)
  {
    if (xjO) {
      return;
    }
    Log.i("XWebViewHelper", "initCallback");
    WebViewExtension.SetExtension(paramWebViewExtensionListener);
    xjO = true;
  }
  
  public static boolean iq(Context paramContext)
  {
    if (jEt) {
      return jEt;
    }
    Log.i("XWebViewHelper", "preInit");
    if (h.eL(paramContext))
    {
      Log.i("XWebViewHelper", "preInit finished");
      jEt = true;
      xkG = true;
    }
    for (;;)
    {
      return jEt;
      Log.i("XWebViewHelper", "preInit xwalk is not available");
    }
  }
  
  public static boolean isCoreReady()
  {
    return xkG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.XWalkWebFactory.a
 * JD-Core Version:    0.7.0.1
 */