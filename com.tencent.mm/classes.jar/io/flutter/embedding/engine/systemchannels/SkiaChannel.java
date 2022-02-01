package io.flutter.embedding.engine.systemchannels;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodChannel;

public class SkiaChannel
{
  private static final String TAG = "SkiaChannel";
  public final MethodChannel channel;
  
  public SkiaChannel(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(190266);
    this.channel = new MethodChannel(paramDartExecutor, "flutter/skia", JSONMethodCodec.INSTANCE);
    AppMethodBeat.o(190266);
  }
  
  public void setResourceCacheMaxBytes(int paramInt)
  {
    AppMethodBeat.i(190275);
    this.channel.invokeMethod("Skia.setResourceCacheMaxBytes", Integer.valueOf(paramInt));
    AppMethodBeat.o(190275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.SkiaChannel
 * JD-Core Version:    0.7.0.1
 */