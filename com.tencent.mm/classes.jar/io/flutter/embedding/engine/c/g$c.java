package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum g$c
{
  private String SQl;
  
  static
  {
    AppMethodBeat.i(10275);
    SQn = new c("PLAIN_TEXT", "text/plain");
    SQo = new c[] { SQn };
    AppMethodBeat.o(10275);
  }
  
  private g$c(String paramString)
  {
    Object localObject;
    this.SQl = localObject;
  }
  
  static c bti(String paramString)
  {
    AppMethodBeat.i(10274);
    c[] arrayOfc = values();
    int j = arrayOfc.length;
    int i = 0;
    while (i < j)
    {
      c localc = arrayOfc[i];
      if (localc.SQl.equals(paramString))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     io.flutter.embedding.engine.c.g.c
 * JD-Core Version:    0.7.0.1
 */