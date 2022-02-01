package io.flutter.embedding.engine.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum k$c
{
  private final String MEk;
  
  static
  {
    AppMethodBeat.i(10260);
    MFr = new c("CHARACTERS", 0, "TextCapitalization.characters");
    MFs = new c("WORDS", 1, "TextCapitalization.words");
    MFt = new c("SENTENCES", 2, "TextCapitalization.sentences");
    MFu = new c("NONE", 3, "TextCapitalization.none");
    MFv = new c[] { MFr, MFs, MFt, MFu };
    AppMethodBeat.o(10260);
  }
  
  private k$c(String paramString)
  {
    this.MEk = paramString;
  }
  
  static c bbW(String paramString)
  {
    AppMethodBeat.i(10259);
    c[] arrayOfc = values();
    int j = arrayOfc.length;
    int i = 0;
    while (i < j)
    {
      c localc = arrayOfc[i];
      if (localc.MEk.equals(paramString))
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