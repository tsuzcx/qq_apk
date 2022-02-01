package io.flutter.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.a.a;
import io.flutter.embedding.engine.a.a.2;
import io.flutter.embedding.engine.a.a.b;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FlutterMain
{
  private static boolean isRunningInRobolectricTest;
  
  static
  {
    AppMethodBeat.i(9749);
    isRunningInRobolectricTest = false;
    AppMethodBeat.o(9749);
  }
  
  public static void ensureInitializationComplete(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(9742);
    if (isRunningInRobolectricTest)
    {
      AppMethodBeat.o(9742);
      return;
    }
    a.hwT().ensureInitializationComplete(paramContext, paramArrayOfString);
    AppMethodBeat.o(9742);
  }
  
  public static void ensureInitializationCompleteAsync(Context paramContext, String[] paramArrayOfString, Handler paramHandler, Runnable paramRunnable)
  {
    AppMethodBeat.i(9743);
    if (isRunningInRobolectricTest)
    {
      AppMethodBeat.o(9743);
      return;
    }
    a locala = a.hwT();
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      paramContext = new IllegalStateException("ensureInitializationComplete must be called on the main thread");
      AppMethodBeat.o(9743);
      throw paramContext;
    }
    if (locala.SPf == null)
    {
      paramContext = new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
      AppMethodBeat.o(9743);
      throw paramContext;
    }
    if (locala.SPe)
    {
      paramHandler.post(paramRunnable);
      AppMethodBeat.o(9743);
      return;
    }
    Executors.newSingleThreadExecutor().execute(new a.2(locala, paramContext, paramArrayOfString, paramHandler, paramRunnable));
    AppMethodBeat.o(9743);
  }
  
  public static String findAppBundlePath()
  {
    AppMethodBeat.i(214930);
    String str = a.hwT().SPc;
    AppMethodBeat.o(214930);
    return str;
  }
  
  @Deprecated
  public static String findAppBundlePath(Context paramContext)
  {
    AppMethodBeat.i(214931);
    paramContext = a.hwT().SPc;
    AppMethodBeat.o(214931);
    return paramContext;
  }
  
  public static String getLookupKeyForAsset(String paramString)
  {
    AppMethodBeat.i(9747);
    paramString = a.hwT().btd(paramString);
    AppMethodBeat.o(9747);
    return paramString;
  }
  
  public static String getLookupKeyForAsset(String paramString1, String paramString2)
  {
    AppMethodBeat.i(9748);
    paramString1 = a.hwT().getLookupKeyForAsset(paramString1, paramString2);
    AppMethodBeat.o(9748);
    return paramString1;
  }
  
  @Deprecated
  public static void setIsRunningInRobolectricTest(boolean paramBoolean)
  {
    isRunningInRobolectricTest = paramBoolean;
  }
  
  public static void startInitialization(Context paramContext)
  {
    AppMethodBeat.i(9740);
    if (isRunningInRobolectricTest)
    {
      AppMethodBeat.o(9740);
      return;
    }
    a.hwT().startInitialization(paramContext);
    AppMethodBeat.o(9740);
  }
  
  public static void startInitialization(Context paramContext, a parama)
  {
    AppMethodBeat.i(9741);
    if (isRunningInRobolectricTest)
    {
      AppMethodBeat.o(9741);
      return;
    }
    a.b localb = new a.b();
    localb.logTag = parama.logTag;
    a.hwT().a(paramContext, localb);
    AppMethodBeat.o(9741);
  }
  
  public static final class a
  {
    String logTag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.view.FlutterMain
 * JD-Core Version:    0.7.0.1
 */