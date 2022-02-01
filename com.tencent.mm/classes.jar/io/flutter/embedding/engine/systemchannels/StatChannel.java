package io.flutter.embedding.engine.systemchannels;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodChannel;

public class StatChannel
{
  private static final String TAG = "StatChannel";
  public final MethodChannel channel;
  
  public StatChannel(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(190263);
    this.channel = new MethodChannel(paramDartExecutor, "flutter/data_stat", JSONMethodCodec.INSTANCE);
    AppMethodBeat.o(190263);
  }
  
  public void reportMemoryUsage() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.StatChannel
 * JD-Core Version:    0.7.0.1
 */