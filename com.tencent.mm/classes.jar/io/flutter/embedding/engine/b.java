package io.flutter.embedding.engine;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class b
{
  private static b KLy;
  private final Map<String, a> KLz;
  
  b()
  {
    AppMethodBeat.i(10117);
    this.KLz = new HashMap();
    AppMethodBeat.o(10117);
  }
  
  public static b fNd()
  {
    AppMethodBeat.i(10116);
    if (KLy == null) {
      KLy = new b();
    }
    b localb = KLy;
    AppMethodBeat.o(10116);
    return localb;
  }
  
  public final a aVH(String paramString)
  {
    AppMethodBeat.i(10118);
    paramString = (a)this.KLz.get(paramString);
    AppMethodBeat.o(10118);
    return paramString;
  }
  
  public final void aVI(String paramString)
  {
    AppMethodBeat.i(10119);
    this.KLz.remove(paramString);
    AppMethodBeat.o(10119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.embedding.engine.b
 * JD-Core Version:    0.7.0.1
 */