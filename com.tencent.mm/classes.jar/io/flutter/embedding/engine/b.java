package io.flutter.embedding.engine;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static b aaqj;
  private final Map<String, a> aaqk;
  
  b()
  {
    AppMethodBeat.i(10117);
    this.aaqk = new HashMap();
    AppMethodBeat.o(10117);
  }
  
  public static b iAJ()
  {
    AppMethodBeat.i(10116);
    if (aaqj == null) {
      aaqj = new b();
    }
    b localb = aaqj;
    AppMethodBeat.o(10116);
    return localb;
  }
  
  public final a bGc(String paramString)
  {
    AppMethodBeat.i(10118);
    paramString = (a)this.aaqk.get(paramString);
    AppMethodBeat.o(10118);
    return paramString;
  }
  
  public final void bGd(String paramString)
  {
    AppMethodBeat.i(10119);
    this.aaqk.remove(paramString);
    AppMethodBeat.o(10119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.embedding.engine.b
 * JD-Core Version:    0.7.0.1
 */