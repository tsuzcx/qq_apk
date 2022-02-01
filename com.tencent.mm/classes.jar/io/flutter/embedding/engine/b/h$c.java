package io.flutter.embedding.engine.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum h$c
{
  private String aasG;
  
  static
  {
    AppMethodBeat.i(10275);
    aasI = new c("PLAIN_TEXT", "text/plain");
    aasJ = new c[] { aasI };
    AppMethodBeat.o(10275);
  }
  
  private h$c(String paramString)
  {
    Object localObject;
    this.aasG = localObject;
  }
  
  static c bGl(String paramString)
  {
    AppMethodBeat.i(10274);
    c[] arrayOfc = values();
    int j = arrayOfc.length;
    int i = 0;
    while (i < j)
    {
      c localc = arrayOfc[i];
      if (localc.aasG.equals(paramString))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     io.flutter.embedding.engine.b.h.c
 * JD-Core Version:    0.7.0.1
 */