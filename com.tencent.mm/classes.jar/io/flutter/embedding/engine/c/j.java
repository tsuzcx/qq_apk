package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.b;
import io.flutter.plugin.a.f;
import java.util.HashMap;
import java.util.Map;

public final class j
{
  public final b<Object> SPQ;
  
  public j(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10269);
    this.SPQ = new b(paramDartExecutor, "flutter/settings", f.SSk);
    AppMethodBeat.o(10269);
  }
  
  public final a hxi()
  {
    AppMethodBeat.i(10270);
    a locala = new a(this.SPQ);
    AppMethodBeat.o(10270);
    return locala;
  }
  
  public static final class a
  {
    private final b<Object> SPQ;
    private Map<String, Object> SRk;
    
    a(b<Object> paramb)
    {
      AppMethodBeat.i(10280);
      this.SRk = new HashMap();
      this.SPQ = paramb;
      AppMethodBeat.o(10280);
    }
    
    public final a Ez(boolean paramBoolean)
    {
      AppMethodBeat.i(10282);
      this.SRk.put("alwaysUse24HourFormat", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(10282);
      return this;
    }
    
    public final a a(j.b paramb)
    {
      AppMethodBeat.i(10283);
      this.SRk.put("platformBrightness", paramb.name);
      AppMethodBeat.o(10283);
      return this;
    }
    
    public final a cQ(float paramFloat)
    {
      AppMethodBeat.i(10281);
      this.SRk.put("textScaleFactor", Float.valueOf(paramFloat));
      AppMethodBeat.o(10281);
      return this;
    }
    
    public final void send()
    {
      AppMethodBeat.i(10284);
      new StringBuilder("Sending message: \ntextScaleFactor: ").append(this.SRk.get("textScaleFactor")).append("\nalwaysUse24HourFormat: ").append(this.SRk.get("alwaysUse24HourFormat")).append("\nplatformBrightness: ").append(this.SRk.get("platformBrightness"));
      a.hwd();
      this.SPQ.eN(this.SRk);
      AppMethodBeat.o(10284);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.c.j
 * JD-Core Version:    0.7.0.1
 */