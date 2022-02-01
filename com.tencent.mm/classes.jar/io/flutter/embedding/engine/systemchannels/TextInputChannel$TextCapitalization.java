package io.flutter.embedding.engine.systemchannels;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum TextInputChannel$TextCapitalization
{
  private final String encodedName;
  
  static
  {
    AppMethodBeat.i(10260);
    CHARACTERS = new TextCapitalization("CHARACTERS", 0, "TextCapitalization.characters");
    WORDS = new TextCapitalization("WORDS", 1, "TextCapitalization.words");
    SENTENCES = new TextCapitalization("SENTENCES", 2, "TextCapitalization.sentences");
    NONE = new TextCapitalization("NONE", 3, "TextCapitalization.none");
    $VALUES = new TextCapitalization[] { CHARACTERS, WORDS, SENTENCES, NONE };
    AppMethodBeat.o(10260);
  }
  
  private TextInputChannel$TextCapitalization(String paramString)
  {
    this.encodedName = paramString;
  }
  
  static TextCapitalization fromValue(String paramString)
  {
    AppMethodBeat.i(10259);
    TextCapitalization[] arrayOfTextCapitalization = values();
    int j = arrayOfTextCapitalization.length;
    int i = 0;
    while (i < j)
    {
      TextCapitalization localTextCapitalization = arrayOfTextCapitalization[i];
      if (localTextCapitalization.encodedName.equals(paramString))
      {
        AppMethodBeat.o(10259);
        return localTextCapitalization;
      }
      i += 1;
    }
    paramString = new NoSuchFieldException("No such TextCapitalization: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(10259);
    throw paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     io.flutter.embedding.engine.systemchannels.TextInputChannel.TextCapitalization
 * JD-Core Version:    0.7.0.1
 */