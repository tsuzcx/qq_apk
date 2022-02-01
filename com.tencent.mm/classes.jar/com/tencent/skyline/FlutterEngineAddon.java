package com.tencent.skyline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/skyline/FlutterEngineAddon;", "", "flutterEngine", "Lio/flutter/embedding/engine/FlutterEngine;", "invokeMethodChannel", "Lio/flutter/plugin/common/MethodChannel;", "(Lio/flutter/embedding/engine/FlutterEngine;Lio/flutter/plugin/common/MethodChannel;)V", "getFlutterEngine", "()Lio/flutter/embedding/engine/FlutterEngine;", "getInvokeMethodChannel", "()Lio/flutter/plugin/common/MethodChannel;", "skyline_android_lib_release"}, k=1, mv={1, 1, 16})
public final class FlutterEngineAddon
{
  private final FlutterEngine flutterEngine;
  private final MethodChannel invokeMethodChannel;
  
  public FlutterEngineAddon(FlutterEngine paramFlutterEngine, MethodChannel paramMethodChannel)
  {
    AppMethodBeat.i(210678);
    this.flutterEngine = paramFlutterEngine;
    this.invokeMethodChannel = paramMethodChannel;
    AppMethodBeat.o(210678);
  }
  
  public final FlutterEngine getFlutterEngine()
  {
    return this.flutterEngine;
  }
  
  public final MethodChannel getInvokeMethodChannel()
  {
    return this.invokeMethodChannel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.skyline.FlutterEngineAddon
 * JD-Core Version:    0.7.0.1
 */