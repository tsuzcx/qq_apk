package io.flutter.embedding.engine.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.a.f;
import java.util.HashMap;
import java.util.Map;

public final class k
{
  public final io.flutter.plugin.a.b<Object> aasl;
  
  public k(DartExecutor paramDartExecutor)
  {
    AppMethodBeat.i(10269);
    this.aasl = new io.flutter.plugin.a.b(paramDartExecutor, "flutter/settings", f.aauL);
    AppMethodBeat.o(10269);
  }
  
  public final a iBk()
  {
    AppMethodBeat.i(10270);
    a locala = new a(this.aasl);
    AppMethodBeat.o(10270);
    return locala;
  }
  
  public static final class a
  {
    private final io.flutter.plugin.a.b<Object> aasl;
    private Map<String, Object> aatJ;
    
    a(io.flutter.plugin.a.b<Object> paramb)
    {
      AppMethodBeat.i(10280);
      this.aatJ = new HashMap();
      this.aasl = paramb;
      AppMethodBeat.o(10280);
    }
    
    public final a Jc(boolean paramBoolean)
    {
      AppMethodBeat.i(10282);
      this.aatJ.put("alwaysUse24HourFormat", Boolean.valueOf(paramBoolean));
      AppMethodBeat.o(10282);
      return this;
    }
    
    public final a a(k.b paramb)
    {
      AppMethodBeat.i(10283);
      this.aatJ.put("platformBrightness", paramb.name);
      AppMethodBeat.o(10283);
      return this;
    }
    
    public final a dl(float paramFloat)
    {
      AppMethodBeat.i(10281);
      this.aatJ.put("textScaleFactor", Float.valueOf(paramFloat));
      AppMethodBeat.o(10281);
      return this;
    }
    
    public final void gOA()
    {
      AppMethodBeat.i(10284);
      new StringBuilder("Sending message: \ntextScaleFactor: ").append(this.aatJ.get("textScaleFactor")).append("\nalwaysUse24HourFormat: ").append(this.aatJ.get("alwaysUse24HourFormat")).append("\nplatformBrightness: ").append(this.aatJ.get("platformBrightness"));
      io.flutter.b.iAd();
      this.aasl.b(this.aatJ, null);
      AppMethodBeat.o(10284);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.b.k
 * JD-Core Version:    0.7.0.1
 */