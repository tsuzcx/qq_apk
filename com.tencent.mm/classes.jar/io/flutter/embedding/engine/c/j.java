package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.b;
import io.flutter.plugin.a.f;
import java.util.HashMap;
import java.util.Map;

public final class j
{
  public final b<Object> KMU;
  
  public j(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10235);
    this.KMU = new b(paramDartExecutor, "flutter/system", f.KOW);
    AppMethodBeat.o(10235);
  }
  
  public final void fNH()
  {
    AppMethodBeat.i(10236);
    a.fMD();
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("type", "memoryPressure");
    this.KMU.eC(localHashMap);
    AppMethodBeat.o(10236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.c.j
 * JD-Core Version:    0.7.0.1
 */