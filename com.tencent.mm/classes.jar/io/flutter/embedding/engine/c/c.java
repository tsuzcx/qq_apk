package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.b;
import io.flutter.plugin.a.p;

public final class c
{
  public final b<String> MDR;
  
  public c(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10218);
    this.MDR = new b(paramDartExecutor, "flutter/lifecycle", p.MGc);
    AppMethodBeat.o(10218);
  }
  
  public final void geY()
  {
    AppMethodBeat.i(10219);
    a.gea();
    this.MDR.eF("AppLifecycleState.inactive");
    AppMethodBeat.o(10219);
  }
  
  public final void geZ()
  {
    AppMethodBeat.i(10220);
    a.gea();
    this.MDR.eF("AppLifecycleState.resumed");
    AppMethodBeat.o(10220);
  }
  
  public final void gfa()
  {
    AppMethodBeat.i(10221);
    a.gea();
    this.MDR.eF("AppLifecycleState.paused");
    AppMethodBeat.o(10221);
  }
  
  public final void gfb()
  {
    AppMethodBeat.i(213267);
    a.gea();
    this.MDR.eF("AppLifecycleState.detached");
    AppMethodBeat.o(213267);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.c.c
 * JD-Core Version:    0.7.0.1
 */