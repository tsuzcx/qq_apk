package io.flutter.embedding.engine;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.dart.DartExecutor.DartEntrypoint;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"spawnExport", "Lio/flutter/embedding/engine/FlutterEngine;", "context", "Landroid/content/Context;", "dartEntrypoint", "Lio/flutter/embedding/engine/dart/DartExecutor$DartEntrypoint;", "entryPoint", "", "skyline_android_lib_release"}, k=2, mv={1, 1, 16})
public final class FlutterEngineExportKt
{
  public static final FlutterEngine spawnExport(FlutterEngine paramFlutterEngine, Context paramContext, DartExecutor.DartEntrypoint paramDartEntrypoint, String paramString)
  {
    AppMethodBeat.i(189968);
    s.t(paramFlutterEngine, "$this$spawnExport");
    s.t(paramContext, "context");
    s.t(paramDartEntrypoint, "dartEntrypoint");
    s.t(paramString, "entryPoint");
    paramFlutterEngine = paramFlutterEngine.spawn(paramContext, paramDartEntrypoint, paramString);
    AppMethodBeat.o(189968);
    return paramFlutterEngine;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     io.flutter.embedding.engine.FlutterEngineExportKt
 * JD-Core Version:    0.7.0.1
 */