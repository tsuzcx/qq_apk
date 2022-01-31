package com.tencent.xweb.x5;

import android.content.Context;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.xweb.WebView.c;
import org.xwalk.core.Log;

final class X5WebFactory$b
{
  private static boolean jEt = false;
  private static boolean xkG = false;
  
  public static void a(Context paramContext, WebView.c paramc)
  {
    if (jEt) {
      return;
    }
    Log.i("X5WebFactory.preIniter", "preInit");
    jEt = true;
    QbSdk.preInit(paramContext, new X5WebFactory.b.1(paramc));
  }
  
  public static boolean hasInited()
  {
    return jEt;
  }
  
  public static boolean isCoreReady()
  {
    return xkG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.x5.X5WebFactory.b
 * JD-Core Version:    0.7.0.1
 */