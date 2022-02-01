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
  public final b<Object> NaX;
  
  public h(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10269);
    this.NaX = new b(paramDartExecutor, "flutter/settings", f.NcZ);
    AppMethodBeat.o(10269);
  }
  
  public final a gjH()
  {
    AppMethodBeat.i(10270);
    a locala = new a(this.NaX);
    AppMethodBeat.o(10270);
    return locala;
  }
  
  public static final class a
  {
    private final b<Object> NaX;
    private Map<String, Object> Ncg;
    
    a(b<Object> paramb)
    {
      AppMethodBeat.i(10280);
      this.Ncg = new HashMap();
      this.NaX = paramb;
      AppMethodBeat.o(10280);
    }
    
    public final a Aj(boolean paramBoolean)
    {
      AppMethodBeat.i(10282);
      this.Ncg.put("alwaysUse24HourFormat", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(10282);
      return this;
    }
    
    public final a a(h.b paramb)
    {
      AppMethodBeat.i(10283);
      this.Ncg.put("platformBrightness", paramb.name);
      AppMethodBeat.o(10283);
      return this;
    }
    
    public final a cl(float paramFloat)
    {
      AppMethodBeat.i(10281);
      this.Ncg.put("textScaleFactor", Float.valueOf(paramFloat));
      AppMethodBeat.o(10281);
      return this;
    }
    
    public final void send()
    {
      AppMethodBeat.i(10284);
      new StringBuilder("Sending message: \ntextScaleFactor: ").append(this.Ncg.get("textScaleFactor")).append("\nalwaysUse24HourFormat: ").append(this.Ncg.get("alwaysUse24HourFormat")).append("\nplatformBrightness: ").append(this.Ncg.get("platformBrightness"));
      a.giD();
      this.NaX.eI(this.Ncg);
      AppMethodBeat.o(10284);
    }
  }
  
  public static enum b
  {
    public String name;
    
    static
    {
      AppMethodBeat.i(10268);
      Nch = new b("light", 0, "light");
      Nci = new b("dark", 1, "dark");
      Ncj = new b[] { Nch, Nci };
      AppMethodBeat.o(10268);
    }
    
    private b(String paramString)
    {
      this.name = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.c.h
 * JD-Core Version:    0.7.0.1
 */