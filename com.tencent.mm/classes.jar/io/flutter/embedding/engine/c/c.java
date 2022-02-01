package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.b;
import io.flutter.plugin.a.p;

public final class c
{
  public final b<String> KMU;
  
  public c(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10218);
    this.KMU = new b(paramDartExecutor, "flutter/lifecycle", p.KPf);
    AppMethodBeat.o(10218);
  }
  
  public final void fNA()
  {
    AppMethodBeat.i(10220);
    a.fMD();
    this.KMU.eC("AppLifecycleState.resumed");
    AppMethodBeat.o(10220);
  }
  
  public final void fNB()
  {
    AppMethodBeat.i(10221);
    a.fMD();
    this.KMU.eC("AppLifecycleState.paused");
    AppMethodBeat.o(10221);
  }
  
  public final void fNC()
  {
    AppMethodBeat.i(192818);
    a.fMD();
    this.KMU.eC("AppLifecycleState.detached");
    AppMethodBeat.o(192818);
  }
  
  public final void fNz()
  {
    AppMethodBeat.i(10219);
    a.fMD();
    this.KMU.eC("AppLifecycleState.inactive");
    AppMethodBeat.o(10219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.c.c
 * JD-Core Version:    0.7.0.1
 */