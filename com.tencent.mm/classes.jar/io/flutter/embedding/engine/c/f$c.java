package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum f$c
{
  private String MEk;
  
  static
  {
    AppMethodBeat.i(10275);
    MEm = new c("PLAIN_TEXT", "text/plain");
    MEn = new c[] { MEm };
    AppMethodBeat.o(10275);
  }
  
  private f$c(String paramString)
  {
    Object localObject;
    this.MEk = localObject;
  }
  
  static c bbQ(String paramString)
  {
    AppMethodBeat.i(10274);
    c[] arrayOfc = values();
    int j = arrayOfc.length;
    int i = 0;
    while (i < j)
    {
      c localc = arrayOfc[i];
      if (localc.MEk.equals(paramString))
      {
        AppMethodBeat.o(10274);
        return localc;
      }
      i += 1;
    }
    paramString = new NoSuchFieldException("No such ClipboardContentFormat: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(10274);
    throw paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     io.flutter.embedding.engine.c.f.c
 * JD-Core Version:    0.7.0.1
 */