package io.flutter.plugins.connectivity.patched;

import android.content.Context;
import android.net.ConnectivityManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.EventChannel.EventSink;
import io.flutter.plugin.common.EventChannel.StreamHandler;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.g;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cm;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lio/flutter/plugins/connectivity/patched/PatchedConnectivityPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "connectivity", "Lio/flutter/plugins/connectivity/patched/PatchedConnectivity;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "eventChannel", "Lio/flutter/plugin/common/EventChannel;", "methodChannel", "Lio/flutter/plugin/common/MethodChannel;", "onAttachedToEngine", "", "binding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "teardownChannels", "Companion", "SafeStreamHandler", "plugin-flutter_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PatchedConnectivityPlugin
  implements FlutterPlugin, MethodChannel.MethodCallHandler
{
  public static final PatchedConnectivityPlugin.Companion Companion;
  private static final String TAG = "MicroMsg.PatchedConnectivityPlugin";
  private PatchedConnectivity connectivity;
  private aq coroutineScope;
  private EventChannel eventChannel;
  private MethodChannel methodChannel;
  
  static
  {
    AppMethodBeat.i(189657);
    Companion = new PatchedConnectivityPlugin.Companion(null);
    AppMethodBeat.o(189657);
  }
  
  public PatchedConnectivityPlugin()
  {
    AppMethodBeat.i(189627);
    this.coroutineScope = ar.d((f)g.aiwf);
    AppMethodBeat.o(189627);
  }
  
  private final void teardownChannels()
  {
    AppMethodBeat.i(189634);
    Object localObject = this.methodChannel;
    if (localObject != null) {
      ((MethodChannel)localObject).setMethodCallHandler(null);
    }
    localObject = this.eventChannel;
    if (localObject != null) {
      ((EventChannel)localObject).setStreamHandler(null);
    }
    this.methodChannel = null;
    this.eventChannel = null;
    AppMethodBeat.o(189634);
  }
  
  public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(189667);
    s.u(paramFlutterPluginBinding, "binding");
    Object localObject1 = paramFlutterPluginBinding.getApplicationContext().getSystemService("connectivity");
    if (localObject1 == null)
    {
      paramFlutterPluginBinding = new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
      AppMethodBeat.o(189667);
      throw paramFlutterPluginBinding;
    }
    this.connectivity = new PatchedConnectivity((ConnectivityManager)localObject1);
    this.coroutineScope = ar.kBZ();
    localObject1 = new MethodChannel(paramFlutterPluginBinding.getBinaryMessenger(), "plugins.flutter.io/connectivity");
    ((MethodChannel)localObject1).setMethodCallHandler((MethodChannel.MethodCallHandler)this);
    Object localObject2 = ah.aiuX;
    this.methodChannel = ((MethodChannel)localObject1);
    localObject1 = new EventChannel(paramFlutterPluginBinding.getBinaryMessenger(), "plugins.flutter.io/connectivity_status");
    paramFlutterPluginBinding = paramFlutterPluginBinding.getApplicationContext();
    s.s(paramFlutterPluginBinding, "binding.applicationContext");
    localObject2 = this.connectivity;
    s.checkNotNull(localObject2);
    ((EventChannel)localObject1).setStreamHandler((EventChannel.StreamHandler)new SafeStreamHandler((EventChannel.StreamHandler)new PatchedConnectivityBroadcastReceiver(paramFlutterPluginBinding, (PatchedConnectivity)localObject2, this.coroutineScope)));
    paramFlutterPluginBinding = ah.aiuX;
    this.eventChannel = ((EventChannel)localObject1);
    AppMethodBeat.o(189667);
  }
  
  public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(189680);
    s.u(paramFlutterPluginBinding, "binding");
    ar.a(this.coroutineScope, null);
    teardownChannels();
    AppMethodBeat.o(189680);
  }
  
  public final void onMethodCall(MethodCall paramMethodCall, final MethodChannel.Result paramResult)
  {
    AppMethodBeat.i(189692);
    s.u(paramMethodCall, "call");
    s.u(paramResult, "result");
    j.a(this.coroutineScope, (f)bg.kCh().kCK(), null, (m)new k(paramMethodCall, paramResult)
    {
      Object L$0;
      int label;
      
      public final d<ah> create(Object paramAnonymousObject, d<?> paramAnonymousd)
      {
        AppMethodBeat.i(189700);
        paramAnonymousObject = (d)new 1(this.$call, paramResult, jdField_this, paramAnonymousd);
        AppMethodBeat.o(189700);
        return paramAnonymousObject;
      }
      
      public final Object invoke(aq paramAnonymousaq, d<? super ah> paramAnonymousd)
      {
        AppMethodBeat.i(189708);
        paramAnonymousaq = ((1)create(paramAnonymousaq, paramAnonymousd)).invokeSuspend(ah.aiuX);
        AppMethodBeat.o(189708);
        return paramAnonymousaq;
      }
      
      public final Object invokeSuspend(Object paramAnonymousObject)
      {
        AppMethodBeat.i(189694);
        Object localObject3 = a.aiwj;
        Object localObject1;
        Object localObject2;
        switch (this.label)
        {
        default: 
          paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(189694);
          throw paramAnonymousObject;
        case 0: 
          ResultKt.throwOnFailure(paramAnonymousObject);
          if (s.p(this.$call.method, "check"))
          {
            paramAnonymousObject = paramResult;
            localObject1 = PatchedConnectivityPlugin.access$getConnectivity$p(jdField_this);
            if (localObject1 == null)
            {
              localObject1 = "none";
              localObject2 = paramAnonymousObject;
              ((MethodChannel.Result)localObject2).success(localObject1);
            }
          }
          break;
        }
        for (;;)
        {
          paramAnonymousObject = ah.aiuX;
          AppMethodBeat.o(189694);
          return paramAnonymousObject;
          localObject2 = (d)this;
          this.L$0 = paramAnonymousObject;
          this.label = 1;
          localObject2 = ((PatchedConnectivity)localObject1).networkType((d)localObject2);
          localObject1 = localObject2;
          if (localObject2 == localObject3)
          {
            AppMethodBeat.o(189694);
            return localObject3;
            localObject2 = (MethodChannel.Result)this.L$0;
            ResultKt.throwOnFailure(paramAnonymousObject);
            localObject1 = paramAnonymousObject;
            paramAnonymousObject = localObject2;
          }
          localObject3 = (String)localObject1;
          localObject1 = localObject3;
          localObject2 = paramAnonymousObject;
          if (localObject3 != null) {
            break;
          }
          localObject1 = "none";
          localObject2 = paramAnonymousObject;
          break;
          paramResult.notImplemented();
        }
      }
    }, 2);
    AppMethodBeat.o(189692);
  }
  
  @Metadata(d1={""}, d2={"Lio/flutter/plugins/connectivity/patched/PatchedConnectivityPlugin$SafeStreamHandler;", "Lio/flutter/plugin/common/EventChannel$StreamHandler;", "impl", "(Lio/flutter/plugin/common/EventChannel$StreamHandler;)V", "onCancel", "", "arguments", "", "onListen", "events", "Lio/flutter/plugin/common/EventChannel$EventSink;", "plugin-flutter_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class SafeStreamHandler
    implements EventChannel.StreamHandler
  {
    private final EventChannel.StreamHandler impl;
    
    public SafeStreamHandler(EventChannel.StreamHandler paramStreamHandler)
    {
      AppMethodBeat.i(189676);
      this.impl = paramStreamHandler;
      AppMethodBeat.o(189676);
    }
    
    public final void onCancel(Object paramObject)
    {
      AppMethodBeat.i(189696);
      try
      {
        this.impl.onCancel(paramObject);
        AppMethodBeat.o(189696);
        return;
      }
      finally
      {
        Log.printErrStackTrace("MicroMsg.PatchedConnectivityPlugin", paramObject, s.X("onCancel() occurs an exception: ", paramObject), new Object[0]);
        AppMethodBeat.o(189696);
      }
    }
    
    public final void onListen(Object paramObject, EventChannel.EventSink paramEventSink)
    {
      AppMethodBeat.i(189687);
      try
      {
        this.impl.onListen(paramObject, paramEventSink);
        AppMethodBeat.o(189687);
        return;
      }
      finally
      {
        Log.printErrStackTrace("MicroMsg.PatchedConnectivityPlugin", paramObject, s.X("onListen() occurs an exception: ", paramObject), new Object[0]);
        AppMethodBeat.o(189687);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.plugins.connectivity.patched.PatchedConnectivityPlugin
 * JD-Core Version:    0.7.0.1
 */