package io.flutter.embedding.engine;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static b SOl;
  private final Map<String, a> SOm;
  
  b()
  {
    AppMethodBeat.i(10117);
    this.SOm = new HashMap();
    AppMethodBeat.o(10117);
  }
  
  public static b hwG()
  {
    AppMethodBeat.i(10116);
    if (SOl == null) {
      SOl = new b();
    }
    b localb = SOl;
    AppMethodBeat.o(10116);
    return localb;
  }
  
  public final a bta(String paramString)
  {
    AppMethodBeat.i(10118);
    paramString = (a)this.SOm.get(paramString);
    AppMethodBeat.o(10118);
    return paramString;
  }
  
  public final void btb(String paramString)
  {
    AppMethodBeat.i(10119);
    this.SOm.remove(paramString);
    AppMethodBeat.o(10119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.b
 * JD-Core Version:    0.7.0.1
 */