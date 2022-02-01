package io.flutter.embedding.engine.systemchannels;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.JSONMessageCodec;
import java.util.HashMap;
import java.util.Map;

public class SystemChannel
{
  private static final String TAG = "SystemChannel";
  public final BasicMessageChannel<Object> channel;
  
  public SystemChannel(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10235);
    this.channel = new BasicMessageChannel(paramDartExecutor, "flutter/system", JSONMessageCodec.INSTANCE);
    AppMethodBeat.o(10235);
  }
  
  public void sendMemoryPressureWarning()
  {
    AppMethodBeat.i(10236);
    Log.v("SystemChannel", "Sending memory pressure warning to Flutter.");
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("type", "memoryPressure");
    this.channel.send(localHashMap);
    AppMethodBeat.o(10236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.SystemChannel
 * JD-Core Version:    0.7.0.1
 */