package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.b;
import io.flutter.plugin.a.f;
import java.util.HashMap;
import java.util.Map;

public final class h
{
  public final b<Object> KMU;
  
  public h(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10269);
    this.KMU = new b(paramDartExecutor, "flutter/settings", f.KOW);
    AppMethodBeat.o(10269);
  }
  
  public final a fNG()
  {
    AppMethodBeat.i(10270);
    a locala = new a(this.KMU);
    AppMethodBeat.o(10270);
    return locala;
  }
  
  public static final class a
  {
    private final b<Object> KMU;
    private Map<String, Object> KOd;
    
    a(b<Object> paramb)
    {
      AppMethodBeat.i(10280);
      this.KOd = new HashMap();
      this.KMU = paramb;
      AppMethodBeat.o(10280);
    }
    
    public final a a(h.b paramb)
    {
      AppMethodBeat.i(10283);
      this.KOd.put("platformBrightness", paramb.name);
      AppMethodBeat.o(10283);
      return this;
    }
    
    public final a ci(float paramFloat)
    {
      AppMethodBeat.i(10281);
      this.KOd.put("textScaleFactor", Float.valueOf(paramFloat));
      AppMethodBeat.o(10281);
      return this;
    }
    
    public final void send()
    {
      AppMethodBeat.i(10284);
      new StringBuilder("Sending message: \ntextScaleFactor: ").append(this.KOd.get("textScaleFactor")).append("\nalwaysUse24HourFormat: ").append(this.KOd.get("alwaysUse24HourFormat")).append("\nplatformBrightness: ").append(this.KOd.get("platformBrightness"));
      a.fMD();
      this.KMU.eC(this.KOd);
      AppMethodBeat.o(10284);
    }
    
    public final a zi(boolean paramBoolean)
    {
      AppMethodBeat.i(10282);
      this.KOd.put("alwaysUse24HourFormat", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(10282);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.c.h
 * JD-Core Version:    0.7.0.1
 */