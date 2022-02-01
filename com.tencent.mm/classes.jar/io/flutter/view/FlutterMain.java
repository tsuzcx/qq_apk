package io.flutter.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a;
import io.flutter.embedding.engine.a.b;
import io.flutter.embedding.engine.a.c;
import io.flutter.embedding.engine.a.c.2;
import io.flutter.embedding.engine.a.c.b;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Deprecated
public class FlutterMain
{
  public static void ensureInitializationComplete(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(9742);
    a.iAc().aanR.ensureInitializationComplete(paramContext, paramArrayOfString);
    AppMethodBeat.o(9742);
  }
  
  public static void ensureInitializationCompleteAsync(Context paramContext, String[] paramArrayOfString, Handler paramHandler, Runnable paramRunnable)
  {
    AppMethodBeat.i(9743);
    c localc = a.iAc().aanR;
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      paramContext = new IllegalStateException("ensureInitializationComplete must be called on the main thread");
      AppMethodBeat.o(9743);
      throw paramContext;
    }
    if (localc.aarp == null)
    {
      paramContext = new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
      AppMethodBeat.o(9743);
      throw paramContext;
    }
    if (localc.initialized)
    {
      paramHandler.post(paramRunnable);
      AppMethodBeat.o(9743);
      return;
    }
    Executors.newSingleThreadExecutor().execute(new c.2(localc, paramContext, paramArrayOfString, paramHandler, paramRunnable));
    AppMethodBeat.o(9743);
  }
  
  public static String findAppBundlePath()
  {
    AppMethodBeat.i(255291);
    String str = a.iAc().aanR.aarr.aarl;
    AppMethodBeat.o(255291);
    return str;
  }
  
  @Deprecated
  public static String findAppBundlePath(Context paramContext)
  {
    AppMethodBeat.i(255292);
    paramContext = a.iAc().aanR.aarr.aarl;
    AppMethodBeat.o(255292);
    return paramContext;
  }
  
  public static String getLookupKeyForAsset(String paramString)
  {
    AppMethodBeat.i(9747);
    paramString = a.iAc().aanR.bGf(paramString);
    AppMethodBeat.o(9747);
    return paramString;
  }
  
  public static String getLookupKeyForAsset(String paramString1, String paramString2)
  {
    AppMethodBeat.i(9748);
    paramString1 = a.iAc().aanR.getLookupKeyForAsset(paramString1, paramString2);
    AppMethodBeat.o(9748);
    return paramString1;
  }
  
  public static void startInitialization(Context paramContext)
  {
    AppMethodBeat.i(9740);
    a.iAc().aanR.startInitialization(paramContext);
    AppMethodBeat.o(9740);
  }
  
  public static void startInitialization(Context paramContext, a parama)
  {
    AppMethodBeat.i(9741);
    c.b localb = new c.b();
    localb.logTag = parama.logTag;
    a.iAc().aanR.a(paramContext, localb);
    AppMethodBeat.o(9741);
  }
  
  public static class a
  {
    String logTag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.view.FlutterMain
 * JD-Core Version:    0.7.0.1
 */