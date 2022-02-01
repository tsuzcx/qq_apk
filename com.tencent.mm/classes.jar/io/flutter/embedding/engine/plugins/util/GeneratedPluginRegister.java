package io.flutter.embedding.engine.plugins.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import java.lang.reflect.Method;

public class GeneratedPluginRegister
{
  private static final String TAG = "GeneratedPluginsRegister";
  
  public static void registerGeneratedPlugins(FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(190315);
    try
    {
      Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", new Class[] { FlutterEngine.class }).invoke(null, new Object[] { paramFlutterEngine });
      AppMethodBeat.o(190315);
      return;
    }
    catch (Exception localException)
    {
      Log.w("GeneratedPluginsRegister", "Tried to automatically register plugins with FlutterEngine (" + paramFlutterEngine + ") but could not find and invoke the GeneratedPluginRegistrant.");
      AppMethodBeat.o(190315);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister
 * JD-Core Version:    0.7.0.1
 */