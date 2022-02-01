package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.g;
import io.flutter.plugin.a.k;

public final class e
{
  public final k vOr;
  
  public e(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10237);
    this.vOr = new k(paramDartExecutor, "flutter/navigation", g.Nda);
    AppMethodBeat.o(10237);
  }
  
  public final void bds(String paramString)
  {
    AppMethodBeat.i(10239);
    new StringBuilder("Sending message to push route '").append(paramString).append("'");
    a.giD();
    this.vOr.a("pushRoute", paramString, null);
    AppMethodBeat.o(10239);
  }
  
  public final void cSQ()
  {
    AppMethodBeat.i(10240);
    a.giD();
    this.vOr.a("popRoute", null, null);
    AppMethodBeat.o(10240);
  }
  
  public final void setInitialRoute(String paramString)
  {
    AppMethodBeat.i(10238);
    new StringBuilder("Sending message to set initial route to '").append(paramString).append("'");
    a.giD();
    this.vOr.a("setInitialRoute", paramString, null);
    AppMethodBeat.o(10238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.c.e
 * JD-Core Version:    0.7.0.1
 */