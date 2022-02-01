package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.b;
import io.flutter.plugin.a.f;
import java.util.HashMap;
import java.util.Map;

public final class l
{
  public final b<Object> SPQ;
  
  public l(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10235);
    this.SPQ = new b(paramDartExecutor, "flutter/system", f.SSk);
    AppMethodBeat.o(10235);
  }
  
  public final void hxj()
  {
    AppMethodBeat.i(10236);
    a.hwd();
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("type", "memoryPressure");
    this.SPQ.eN(localHashMap);
    AppMethodBeat.o(10236);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.c.l
 * JD-Core Version:    0.7.0.1
 */