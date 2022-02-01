package io.flutter.embedding.engine.systemchannels;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;

public class NavigationChannel
{
  private static final String TAG = "NavigationChannel";
  public final MethodChannel channel;
  
  public NavigationChannel(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10237);
    this.channel = new MethodChannel(paramDartExecutor, "flutter/navigation", JSONMethodCodec.INSTANCE);
    AppMethodBeat.o(10237);
  }
  
  public void popRoute()
  {
    AppMethodBeat.i(10240);
    Log.v("NavigationChannel", "Sending message to pop route.");
    this.channel.invokeMethod("popRoute", null);
    AppMethodBeat.o(10240);
  }
  
  public void pushRoute(String paramString)
  {
    AppMethodBeat.i(10239);
    Log.v("NavigationChannel", "Sending message to push route '" + paramString + "'");
    this.channel.invokeMethod("pushRoute", paramString);
    AppMethodBeat.o(10239);
  }
  
  public void setInitialRoute(String paramString)
  {
    AppMethodBeat.i(10238);
    Log.v("NavigationChannel", "Sending message to set initial route to '" + paramString + "'");
    this.channel.invokeMethod("setInitialRoute", paramString);
    AppMethodBeat.o(10238);
  }
  
  public void setMethodCallHandler(MethodChannel.MethodCallHandler paramMethodCallHandler)
  {
    AppMethodBeat.i(190259);
    this.channel.setMethodCallHandler(paramMethodCallHandler);
    AppMethodBeat.o(190259);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.NavigationChannel
 * JD-Core Version:    0.7.0.1
 */