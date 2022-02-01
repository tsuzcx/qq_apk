package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a;
import io.flutter.a.a.b;
import io.flutter.a.a.f;
import io.flutter.embedding.engine.dart.DartExecutor;
import java.util.HashMap;
import java.util.Map;

public final class j
{
  public final b<Object> IZr;
  
  public j(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10235);
    this.IZr = new b(paramDartExecutor, "flutter/system", f.Jbs);
    AppMethodBeat.o(10235);
  }
  
  public final void fvb()
  {
    AppMethodBeat.i(10236);
    a.ftS();
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("type", "memoryPressure");
    this.IZr.eA(localHashMap);
    AppMethodBeat.o(10236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.c.j
 * JD-Core Version:    0.7.0.1
 */