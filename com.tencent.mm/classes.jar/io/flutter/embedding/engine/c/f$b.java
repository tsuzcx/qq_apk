package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum f$b
{
  private String MEk;
  
  static
  {
    AppMethodBeat.i(10228);
    MEi = new b("LIGHT", 0, "Brightness.light");
    MEj = new b("DARK", 1, "Brightness.dark");
    MEl = new b[] { MEi, MEj };
    AppMethodBeat.o(10228);
  }
  
  private f$b(String paramString)
  {
    this.MEk = paramString;
  }
  
  static b bbP(String paramString)
  {
    AppMethodBeat.i(10227);
    b[] arrayOfb = values();
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      b localb = arrayOfb[i];
      if (localb.MEk.equals(paramString))
      {
        AppMethodBeat.o(10227);
        return localb;
      }
      i += 1;
    }
    paramString = new NoSuchFieldException("No such Brightness: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(10227);
    throw paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     io.flutter.embedding.engine.c.f.b
 * JD-Core Version:    0.7.0.1
 */