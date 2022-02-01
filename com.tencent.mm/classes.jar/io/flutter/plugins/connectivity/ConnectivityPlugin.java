package io.flutter.plugins.connectivity;

import android.content.Context;
import android.net.ConnectivityManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry.Registrar;

public class ConnectivityPlugin
  implements FlutterPlugin
{
  private EventChannel eventChannel;
  private MethodChannel methodChannel;
  
  public static void registerWith(PluginRegistry.Registrar paramRegistrar)
  {
    AppMethodBeat.i(189617);
    new ConnectivityPlugin().setupChannels(paramRegistrar.messenger(), paramRegistrar.context());
    AppMethodBeat.o(189617);
  }
  
  private void setupChannels(BinaryMessenger paramBinaryMessenger, Context paramContext)
  {
    AppMethodBeat.i(189622);
    this.methodChannel = new MethodChannel(paramBinaryMessenger, "plugins.flutter.io/connectivity");
    this.eventChannel = new EventChannel(paramBinaryMessenger, "plugins.flutter.io/connectivity_status");
    Connectivity localConnectivity = new Connectivity((ConnectivityManager)paramContext.getSystemService("connectivity"));
    paramBinaryMessenger = new ConnectivityMethodChannelHandler(localConnectivity);
    paramContext = new ConnectivityBroadcastReceiver(paramContext, localConnectivity);
    this.methodChannel.setMethodCallHandler(paramBinaryMessenger);
    this.eventChannel.setStreamHandler(paramContext);
    AppMethodBeat.o(189622);
  }
  
  private void teardownChannels()
  {
    AppMethodBeat.i(189628);
    this.methodChannel.setMethodCallHandler(null);
    this.eventChannel.setStreamHandler(null);
    this.methodChannel = null;
    this.eventChannel = null;
    AppMethodBeat.o(189628);
  }
  
  public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(189638);
    setupChannels(paramFlutterPluginBinding.getBinaryMessenger(), paramFlutterPluginBinding.getApplicationContext());
    AppMethodBeat.o(189638);
  }
  
  public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(189646);
    teardownChannels();
    AppMethodBeat.o(189646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.plugins.connectivity.ConnectivityPlugin
 * JD-Core Version:    0.7.0.1
 */