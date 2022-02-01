package io.flutter.embedding.engine.systemchannels;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.StringCodec;

public class LifecycleChannel
{
  private static final String TAG = "LifecycleChannel";
  public final BasicMessageChannel<String> channel;
  
  public LifecycleChannel(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10218);
    this.channel = new BasicMessageChannel(paramDartExecutor, "flutter/lifecycle", StringCodec.INSTANCE);
    AppMethodBeat.o(10218);
  }
  
  public void appIsDetached()
  {
    AppMethodBeat.i(190303);
    Log.v("LifecycleChannel", "Sending AppLifecycleState.detached message.");
    this.channel.send("AppLifecycleState.detached");
    AppMethodBeat.o(190303);
  }
  
  public void appIsInactive()
  {
    AppMethodBeat.i(10219);
    Log.v("LifecycleChannel", "Sending AppLifecycleState.inactive message.");
    this.channel.send("AppLifecycleState.inactive");
    AppMethodBeat.o(10219);
  }
  
  public void appIsPaused()
  {
    AppMethodBeat.i(10221);
    Log.v("LifecycleChannel", "Sending AppLifecycleState.paused message.");
    this.channel.send("AppLifecycleState.paused");
    AppMethodBeat.o(10221);
  }
  
  public void appIsResumed()
  {
    AppMethodBeat.i(10220);
    Log.v("LifecycleChannel", "Sending AppLifecycleState.resumed message.");
    this.channel.send("AppLifecycleState.resumed");
    AppMethodBeat.o(10220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.LifecycleChannel
 * JD-Core Version:    0.7.0.1
 */