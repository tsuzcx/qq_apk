package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a;
import io.flutter.a.a.b;
import io.flutter.a.a.p;
import io.flutter.embedding.engine.dart.DartExecutor;

public final class c
{
  public final b<String> IZr;
  
  public c(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10218);
    this.IZr = new b(paramDartExecutor, "flutter/lifecycle", p.JbB);
    AppMethodBeat.o(10218);
  }
  
  public final void fuV()
  {
    AppMethodBeat.i(10219);
    a.ftS();
    this.IZr.eA("AppLifecycleState.inactive");
    AppMethodBeat.o(10219);
  }
  
  public final void fuW()
  {
    AppMethodBeat.i(10220);
    a.ftS();
    this.IZr.eA("AppLifecycleState.resumed");
    AppMethodBeat.o(10220);
  }
  
  public final void fuX()
  {
    AppMethodBeat.i(10221);
    a.ftS();
    this.IZr.eA("AppLifecycleState.paused");
    AppMethodBeat.o(10221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.c.c
 * JD-Core Version:    0.7.0.1
 */