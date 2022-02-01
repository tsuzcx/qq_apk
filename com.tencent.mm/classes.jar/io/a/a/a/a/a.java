package io.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lio/github/ponnamkarthik/toast/fluttertoast/FlutterToastPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "()V", "channel", "Lio/flutter/plugin/common/MethodChannel;", "onAttachedToEngine", "", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "p0", "setupChannel", "messenger", "Lio/flutter/plugin/common/BinaryMessenger;", "context", "Landroid/content/Context;", "teardownChannel", "Companion", "fluttertoast_release"}, k=1, mv={1, 1, 16})
public final class a
  implements FlutterPlugin
{
  public static final a.a aiuw;
  private MethodChannel channel;
  
  static
  {
    AppMethodBeat.i(189472);
    aiuw = new a.a((byte)0);
    AppMethodBeat.o(189472);
  }
  
  public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(189480);
    s.t(paramFlutterPluginBinding, "binding");
    Object localObject = paramFlutterPluginBinding.getBinaryMessenger();
    s.r(localObject, "binding.binaryMessenger");
    paramFlutterPluginBinding = paramFlutterPluginBinding.getApplicationContext();
    s.r(paramFlutterPluginBinding, "binding.applicationContext");
    s.t(localObject, "messenger");
    s.t(paramFlutterPluginBinding, "context");
    this.channel = new MethodChannel((BinaryMessenger)localObject, "PonnamKarthik/fluttertoast");
    paramFlutterPluginBinding = new b(paramFlutterPluginBinding);
    localObject = this.channel;
    if (localObject != null)
    {
      ((MethodChannel)localObject).setMethodCallHandler((MethodChannel.MethodCallHandler)paramFlutterPluginBinding);
      AppMethodBeat.o(189480);
      return;
    }
    AppMethodBeat.o(189480);
  }
  
  public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(189482);
    s.t(paramFlutterPluginBinding, "p0");
    paramFlutterPluginBinding = this.channel;
    if (paramFlutterPluginBinding != null) {
      paramFlutterPluginBinding.setMethodCallHandler(null);
    }
    this.channel = null;
    AppMethodBeat.o(189482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.a.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */