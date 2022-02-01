package io.flutter.embedding.engine.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.b;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.k;

public final class g
{
  public final k aKT;
  
  public g(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10237);
    this.aKT = new k(paramDartExecutor, "flutter/navigation", io.flutter.plugin.a.g.aauM);
    AppMethodBeat.o(10237);
  }
  
  public final void bGj(String paramString)
  {
    AppMethodBeat.i(10239);
    new StringBuilder("Sending message to push route '").append(paramString).append("'");
    b.iAd();
    this.aKT.a("pushRoute", paramString, null);
    AppMethodBeat.o(10239);
  }
  
  public final void epW()
  {
    AppMethodBeat.i(10240);
    b.iAd();
    this.aKT.a("popRoute", null, null);
    AppMethodBeat.o(10240);
  }
  
  public final void setInitialRoute(String paramString)
  {
    AppMethodBeat.i(10238);
    new StringBuilder("Sending message to set initial route to '").append(paramString).append("'");
    b.iAd();
    this.aKT.a("setInitialRoute", paramString, null);
    AppMethodBeat.o(10238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.b.g
 * JD-Core Version:    0.7.0.1
 */