package io.flutter.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.a.a;
import io.flutter.embedding.engine.a.a.1;
import io.flutter.embedding.engine.a.a.a;
import java.io.File;

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
    a.fNr().ensureInitializationComplete(paramContext, paramArrayOfString);
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
    a locala = a.fNr();
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      paramContext = new IllegalStateException("ensureInitializationComplete must be called on the main thread");
      AppMethodBeat.o(9743);
      throw paramContext;
    }
    if (locala.KMt == null)
    {
      paramContext = new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
      AppMethodBeat.o(9743);
      throw paramContext;
    }
    if (!locala.KMr) {
      new Thread(new a.1(locala, paramContext, paramArrayOfString, paramHandler, paramRunnable)).start();
    }
    AppMethodBeat.o(9743);
  }
  
  public static String findAppBundlePath()
  {
    AppMethodBeat.i(192795);
    String str = a.fNr().KMp;
    AppMethodBeat.o(192795);
    return str;
  }
  
  @Deprecated
  public static String findAppBundlePath(Context paramContext)
  {
    AppMethodBeat.i(192796);
    paramContext = a.fNr().KMp;
    AppMethodBeat.o(192796);
    return paramContext;
  }
  
  public static String getLookupKeyForAsset(String paramString)
  {
    AppMethodBeat.i(9747);
    paramString = a.fNr().getLookupKeyForAsset(paramString);
    AppMethodBeat.o(9747);
    return paramString;
  }
  
  public static String getLookupKeyForAsset(String paramString1, String paramString2)
  {
    AppMethodBeat.i(9748);
    paramString1 = a.fNr().getLookupKeyForAsset("packages" + File.separator + paramString2 + File.separator + paramString1);
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
    a.fNr().startInitialization(paramContext);
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
    a.a locala = new a.a();
    locala.kSu = parama.kSu;
    a.fNr().a(paramContext, locala);
    AppMethodBeat.o(9741);
  }
  
  public static final class a
  {
    String kSu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.view.FlutterMain
 * JD-Core Version:    0.7.0.1
 */