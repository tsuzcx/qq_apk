package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum k$c
{
  private final String Nbq;
  
  static
  {
    AppMethodBeat.i(10260);
    Ncx = new c("CHARACTERS", 0, "TextCapitalization.characters");
    Ncy = new c("WORDS", 1, "TextCapitalization.words");
    Ncz = new c("SENTENCES", 2, "TextCapitalization.sentences");
    NcA = new c("NONE", 3, "TextCapitalization.none");
    NcB = new c[] { Ncx, Ncy, Ncz, NcA };
    AppMethodBeat.o(10260);
  }
  
  private k$c(String paramString)
  {
    this.Nbq = paramString;
  }
  
  static c bdA(String paramString)
  {
    AppMethodBeat.i(10259);
    c[] arrayOfc = values();
    int j = arrayOfc.length;
    int i = 0;
    while (i < j)
    {
      c localc = arrayOfc[i];
      if (localc.Nbq.equals(paramString))
      {
        AppMethodBeat.o(10259);
        return localc;
      }
      i += 1;
    }
    paramString = new NoSuchFieldException("No such TextCapitalization: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(10259);
    throw paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     io.flutter.embedding.engine.c.k.c
 * JD-Core Version:    0.7.0.1
 */