package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.b;
import io.flutter.plugin.a.p;

public final class c
{
  public final b<String> SPQ;
  
  public c(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10218);
    this.SPQ = new b(paramDartExecutor, "flutter/lifecycle", p.SSt);
    AppMethodBeat.o(10218);
  }
  
  public final void hxc()
  {
    AppMethodBeat.i(10219);
    a.hwd();
    this.SPQ.eN("AppLifecycleState.inactive");
    AppMethodBeat.o(10219);
  }
  
  public final void hxd()
  {
    AppMethodBeat.i(10220);
    a.hwd();
    this.SPQ.eN("AppLifecycleState.resumed");
    AppMethodBeat.o(10220);
  }
  
  public final void hxe()
  {
    AppMethodBeat.i(10221);
    a.hwd();
    this.SPQ.eN("AppLifecycleState.paused");
    AppMethodBeat.o(10221);
  }
  
  public final void hxf()
  {
    AppMethodBeat.i(214997);
    a.hwd();
    this.SPQ.eN("AppLifecycleState.detached");
    AppMethodBeat.o(214997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.c.c
 * JD-Core Version:    0.7.0.1
 */