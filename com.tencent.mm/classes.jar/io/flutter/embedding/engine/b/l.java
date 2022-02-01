package io.flutter.embedding.engine.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.f;
import java.util.HashMap;
import java.util.Map;

public final class l
{
  public final io.flutter.plugin.a.b<Object> aasl;
  
  public l(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10235);
    this.aasl = new io.flutter.plugin.a.b(paramDartExecutor, "flutter/system", f.aauL);
    AppMethodBeat.o(10235);
  }
  
  public final void iBl()
  {
    AppMethodBeat.i(10236);
    io.flutter.b.iAd();
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("type", "memoryPressure");
    this.aasl.b(localHashMap, null);
    AppMethodBeat.o(10236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.b.l
 * JD-Core Version:    0.7.0.1
 */