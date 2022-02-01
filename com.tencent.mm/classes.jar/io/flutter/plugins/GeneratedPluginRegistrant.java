package io.flutter.plugins;

import com.github.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.shim.ShimPluginRegistry;
import io.flutter.plugins.connectivity.ConnectivityPlugin;
import io.flutter.plugins.pathprovider.PathProviderPlugin;
import java.lang.reflect.Method;

public final class GeneratedPluginRegistrant
{
  private static final String TAG = "MicroMsg.Flutter.GeneratedPluginRegistrant";
  
  private static boolean alreadyRegisteredWith(io.flutter.plugin.common.PluginRegistry paramPluginRegistry)
  {
    AppMethodBeat.i(189587);
    String str = GeneratedPluginRegistrant.class.getCanonicalName();
    if (paramPluginRegistry.hasPlugin(str))
    {
      AppMethodBeat.o(189587);
      return true;
    }
    paramPluginRegistry.registrarFor(str);
    AppMethodBeat.o(189587);
    return false;
  }
  
  public static void registerWith(FlutterEngine paramFlutterEngine)
  {
    AppMethodBeat.i(189581);
    new ShimPluginRegistry(paramFlutterEngine);
    paramFlutterEngine.getPlugins().add(new com.e.a.a());
    paramFlutterEngine.getPlugins().add(new ConnectivityPlugin());
    paramFlutterEngine.getPlugins().add(new d.a.a.a.a());
    paramFlutterEngine.getPlugins().add(new com.dataxad.flutter_mailer.a());
    paramFlutterEngine.getPlugins().add(new com.tencent.mm.flutter.c.a());
    paramFlutterEngine.getPlugins().add(new com.tencent.mm.flutter.a.a());
    paramFlutterEngine.getPlugins().add(new io.a.a.a.a.a());
    paramFlutterEngine.getPlugins().add(new com.d.a.a());
    paramFlutterEngine.getPlugins().add(new com.tencent.mm.flutter.plugin.a());
    paramFlutterEngine.getPlugins().add(new b());
    paramFlutterEngine.getPlugins().add(new d.a.a.b.a());
    paramFlutterEngine.getPlugins().add(new PathProviderPlugin());
    paramFlutterEngine.getPlugins().add(new f.a.a.a.a());
    paramFlutterEngine.getPlugins().add(new com.i.a.c());
    paramFlutterEngine.getPlugins().add(new com.tencent.mm.flutter.b.a.d());
    paramFlutterEngine.getPlugins().add(new com.tencent.liteapp.c());
    paramFlutterEngine.getPlugins().add(new com.tencent.wxa.d());
    paramFlutterEngine.getPlugins().add(new com.d.b.a());
    try
    {
      Class.forName("com.tencent.mm.plugin.flutter.model.ChannelRegistrant").getMethod("registerWith", new Class[] { FlutterEngine.class }).invoke(null, new Object[] { paramFlutterEngine });
      AppMethodBeat.o(189581);
      return;
    }
    catch (ClassNotFoundException paramFlutterEngine)
    {
      AppMethodBeat.o(189581);
      return;
    }
    catch (Exception paramFlutterEngine)
    {
      AppMethodBeat.o(189581);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.plugins.GeneratedPluginRegistrant
 * JD-Core Version:    0.7.0.1
 */