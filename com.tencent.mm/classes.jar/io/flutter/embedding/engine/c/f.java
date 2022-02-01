package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.g;
import io.flutter.plugin.a.k;

public final class f
{
  public final k bbv;
  
  public f(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10237);
    this.bbv = new k(paramDartExecutor, "flutter/navigation", g.SSl);
    AppMethodBeat.o(10237);
  }
  
  public final void dLr()
  {
    AppMethodBeat.i(10240);
    a.hwd();
    this.bbv.a("popRoute", null, null);
    AppMethodBeat.o(10240);
  }
  
  public final void setInitialRoute(String paramString)
  {
    AppMethodBeat.i(10238);
    new StringBuilder("Sending message to set initial route to '").append(paramString).append("'");
    a.hwd();
    this.bbv.a("setInitialRoute", paramString, null);
    AppMethodBeat.o(10238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     io.flutter.embedding.engine.c.f
 * JD-Core Version:    0.7.0.1
 */