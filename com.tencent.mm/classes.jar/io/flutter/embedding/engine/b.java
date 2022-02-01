package io.flutter.embedding.engine;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static b MZA;
  private final Map<String, a> MZB;
  
  b()
  {
    AppMethodBeat.i(10117);
    this.MZB = new HashMap();
    AppMethodBeat.o(10117);
  }
  
  public static b gjf()
  {
    AppMethodBeat.i(10116);
    if (MZA == null) {
      MZA = new b();
    }
    b localb = MZA;
    AppMethodBeat.o(10116);
    return localb;
  }
  
  public final a bdo(String paramString)
  {
    AppMethodBeat.i(10118);
    paramString = (a)this.MZB.get(paramString);
    AppMethodBeat.o(10118);
    return paramString;
  }
  
  public final void bdp(String paramString)
  {
    AppMethodBeat.i(10119);
    this.MZB.remove(paramString);
    AppMethodBeat.o(10119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.b
 * JD-Core Version:    0.7.0.1
 */