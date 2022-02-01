package io.flutter.view;

import android.content.Context;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.loader.FlutterLoader.Settings;

@Deprecated
public class FlutterMain
{
  public static void ensureInitializationComplete(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(9742);
    FlutterInjector.instance().flutterLoader().ensureInitializationComplete(paramContext, paramArrayOfString);
    AppMethodBeat.o(9742);
  }
  
  public static void ensureInitializationCompleteAsync(Context paramContext, String[] paramArrayOfString, Handler paramHandler, Runnable paramRunnable)
  {
    AppMethodBeat.i(9743);
    FlutterInjector.instance().flutterLoader().ensureInitializationCompleteAsync(paramContext, paramArrayOfString, paramHandler, paramRunnable);
    AppMethodBeat.o(9743);
  }
  
  public static String findAppBundlePath()
  {
    AppMethodBeat.i(190560);
    String str = FlutterInjector.instance().flutterLoader().findAppBundlePath();
    AppMethodBeat.o(190560);
    return str;
  }
  
  @Deprecated
  public static String findAppBundlePath(Context paramContext)
  {
    AppMethodBeat.i(190570);
    paramContext = FlutterInjector.instance().flutterLoader().findAppBundlePath();
    AppMethodBeat.o(190570);
    return paramContext;
  }
  
  public static String getLookupKeyForAsset(String paramString)
  {
    AppMethodBeat.i(9747);
    paramString = FlutterInjector.instance().flutterLoader().getLookupKeyForAsset(paramString);
    AppMethodBeat.o(9747);
    return paramString;
  }
  
  public static String getLookupKeyForAsset(String paramString1, String paramString2)
  {
    AppMethodBeat.i(9748);
    paramString1 = FlutterInjector.instance().flutterLoader().getLookupKeyForAsset(paramString1, paramString2);
    AppMethodBeat.o(9748);
    return paramString1;
  }
  
  public static void startInitialization(Context paramContext)
  {
    AppMethodBeat.i(9740);
    FlutterInjector.instance().flutterLoader().startInitialization(paramContext);
    AppMethodBeat.o(9740);
  }
  
  public static void startInitialization(Context paramContext, Settings paramSettings)
  {
    AppMethodBeat.i(9741);
    FlutterLoader.Settings localSettings = new FlutterLoader.Settings();
    localSettings.setLogTag(paramSettings.getLogTag());
    FlutterInjector.instance().flutterLoader().startInitialization(paramContext, localSettings);
    AppMethodBeat.o(9741);
  }
  
  public static class Settings
  {
    private String logTag;
    
    public String getLogTag()
    {
      return this.logTag;
    }
    
    public void setLogTag(String paramString)
    {
      this.logTag = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.view.FlutterMain
 * JD-Core Version:    0.7.0.1
 */