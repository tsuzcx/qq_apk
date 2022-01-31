package com.tencent.xweb.x5;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.xweb.WebView.c;
import org.xwalk.core.Log;

final class X5WebFactory$b
{
  private static boolean BIl = false;
  private static boolean lNR = false;
  
  public static void a(Context paramContext, WebView.c paramc)
  {
    AppMethodBeat.i(84868);
    if (lNR)
    {
      AppMethodBeat.o(84868);
      return;
    }
    Log.i("X5WebFactory.preIniter", "preInit");
    lNR = true;
    QbSdk.preInit(paramContext, new X5WebFactory.b.1(paramc));
    AppMethodBeat.o(84868);
  }
  
  public static boolean hasInited()
  {
    return lNR;
  }
  
  public static boolean isCoreReady()
  {
    return BIl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.x5.X5WebFactory.b
 * JD-Core Version:    0.7.0.1
 */