package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.b;
import io.flutter.plugin.a.p;

public final class c
{
  public final b<String> NaX;
  
  public c(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10218);
    this.NaX = new b(paramDartExecutor, "flutter/lifecycle", p.Ndi);
    AppMethodBeat.o(10218);
  }
  
  public final void gjA()
  {
    AppMethodBeat.i(10219);
    a.giD();
    this.NaX.eI("AppLifecycleState.inactive");
    AppMethodBeat.o(10219);
  }
  
  public final void gjB()
  {
    AppMethodBeat.i(10220);
    a.giD();
    this.NaX.eI("AppLifecycleState.resumed");
    AppMethodBeat.o(10220);
  }
  
  public final void gjC()
  {
    AppMethodBeat.i(10221);
    a.giD();
    this.NaX.eI("AppLifecycleState.paused");
    AppMethodBeat.o(10221);
  }
  
  public final void gjD()
  {
    AppMethodBeat.i(197849);
    a.giD();
    this.NaX.eI("AppLifecycleState.detached");
    AppMethodBeat.o(197849);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.c.c
 * JD-Core Version:    0.7.0.1
 */