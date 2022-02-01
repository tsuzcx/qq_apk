package io.flutter.embedding.engine;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static b MCv;
  private final Map<String, a> MCw;
  
  b()
  {
    AppMethodBeat.i(10117);
    this.MCw = new HashMap();
    AppMethodBeat.o(10117);
  }
  
  public static b geD()
  {
    AppMethodBeat.i(10116);
    if (MCv == null) {
      MCv = new b();
    }
    b localb = MCv;
    AppMethodBeat.o(10116);
    return localb;
  }
  
  public final a bbK(String paramString)
  {
    AppMethodBeat.i(10118);
    paramString = (a)this.MCw.get(paramString);
    AppMethodBeat.o(10118);
    return paramString;
  }
  
  public final void bbL(String paramString)
  {
    AppMethodBeat.i(10119);
    this.MCw.remove(paramString);
    AppMethodBeat.o(10119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.b
 * JD-Core Version:    0.7.0.1
 */