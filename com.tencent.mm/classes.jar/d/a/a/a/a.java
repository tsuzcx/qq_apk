package d.a.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;

public final class a
  implements FlutterPlugin
{
  MethodChannel channel;
  
  public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(186508);
    BinaryMessenger localBinaryMessenger = paramFlutterPluginBinding.getBinaryMessenger();
    paramFlutterPluginBinding = paramFlutterPluginBinding.getApplicationContext();
    this.channel = new MethodChannel(localBinaryMessenger, "dev.fluttercommunity.plus/device_info");
    paramFlutterPluginBinding = new b(paramFlutterPluginBinding.getContentResolver(), paramFlutterPluginBinding.getPackageManager());
    this.channel.setMethodCallHandler(paramFlutterPluginBinding);
    AppMethodBeat.o(186508);
  }
  
  public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(186510);
    this.channel.setMethodCallHandler(null);
    this.channel = null;
    AppMethodBeat.o(186510);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */