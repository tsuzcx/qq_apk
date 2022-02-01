package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a;
import io.flutter.a.a.b;
import io.flutter.a.a.f;
import io.flutter.embedding.engine.dart.DartExecutor;
import java.util.HashMap;
import java.util.Map;

public final class h
{
  public final b<Object> IZr;
  
  public h(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10269);
    this.IZr = new b(paramDartExecutor, "flutter/settings", f.Jbs);
    AppMethodBeat.o(10269);
  }
  
  public final a fva()
  {
    AppMethodBeat.i(10270);
    a locala = new a(this.IZr);
    AppMethodBeat.o(10270);
    return locala;
  }
  
  public static final class a
  {
    private final b<Object> IZr;
    private Map<String, Object> JaA;
    
    a(b<Object> paramb)
    {
      AppMethodBeat.i(10280);
      this.JaA = new HashMap();
      this.IZr = paramb;
      AppMethodBeat.o(10280);
    }
    
    public final a a(h.b paramb)
    {
      AppMethodBeat.i(10283);
      this.JaA.put("platformBrightness", paramb.name);
      AppMethodBeat.o(10283);
      return this;
    }
    
    public final a bT(float paramFloat)
    {
      AppMethodBeat.i(10281);
      this.JaA.put("textScaleFactor", Float.valueOf(paramFloat));
      AppMethodBeat.o(10281);
      return this;
    }
    
    public final void send()
    {
      AppMethodBeat.i(10284);
      new StringBuilder("Sending message: \ntextScaleFactor: ").append(this.JaA.get("textScaleFactor")).append("\nalwaysUse24HourFormat: ").append(this.JaA.get("alwaysUse24HourFormat")).append("\nplatformBrightness: ").append(this.JaA.get("platformBrightness"));
      a.ftS();
      this.IZr.eA(this.JaA);
      AppMethodBeat.o(10284);
    }
    
    public final a xQ(boolean paramBoolean)
    {
      AppMethodBeat.i(10282);
      this.JaA.put("alwaysUse24HourFormat", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(10282);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.c.h
 * JD-Core Version:    0.7.0.1
 */