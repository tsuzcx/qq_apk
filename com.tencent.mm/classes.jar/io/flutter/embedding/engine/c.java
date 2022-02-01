package io.flutter.embedding.engine;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  private static c IYw;
  private final Map<String, a> IYx;
  
  c()
  {
    AppMethodBeat.i(10117);
    this.IYx = new HashMap();
    AppMethodBeat.o(10117);
  }
  
  public static c fuE()
  {
    AppMethodBeat.i(10116);
    if (IYw == null) {
      IYw = new c();
    }
    c localc = IYw;
    AppMethodBeat.o(10116);
    return localc;
  }
  
  public final a aPJ(String paramString)
  {
    AppMethodBeat.i(10118);
    paramString = (a)this.IYx.get(paramString);
    AppMethodBeat.o(10118);
    return paramString;
  }
  
  public final void aPK(String paramString)
  {
    AppMethodBeat.i(10119);
    this.IYx.remove(paramString);
    AppMethodBeat.o(10119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.c
 * JD-Core Version:    0.7.0.1
 */