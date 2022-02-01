package io.flutter.embedding.engine.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.p;

public final class d
{
  public final io.flutter.plugin.a.b<String> aasl;
  
  public d(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10218);
    this.aasl = new io.flutter.plugin.a.b(paramDartExecutor, "flutter/lifecycle", p.aauU);
    AppMethodBeat.o(10218);
  }
  
  public final void iBd()
  {
    AppMethodBeat.i(10219);
    io.flutter.b.iAd();
    this.aasl.b("AppLifecycleState.inactive", null);
    AppMethodBeat.o(10219);
  }
  
  public final void iBe()
  {
    AppMethodBeat.i(10220);
    io.flutter.b.iAd();
    this.aasl.b("AppLifecycleState.resumed", null);
    AppMethodBeat.o(10220);
  }
  
  public final void iBf()
  {
    AppMethodBeat.i(10221);
    io.flutter.b.iAd();
    this.aasl.b("AppLifecycleState.paused", null);
    AppMethodBeat.o(10221);
  }
  
  public final void iBg()
  {
    AppMethodBeat.i(255842);
    io.flutter.b.iAd();
    this.aasl.b("AppLifecycleState.detached", null);
    AppMethodBeat.o(255842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.b.d
 * JD-Core Version:    0.7.0.1
 */