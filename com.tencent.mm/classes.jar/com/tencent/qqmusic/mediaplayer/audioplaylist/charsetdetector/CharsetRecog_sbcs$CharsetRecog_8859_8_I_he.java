package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import com.tencent.matrix.trace.core.AppMethodBeat;

class CharsetRecog_sbcs$CharsetRecog_8859_8_I_he
  extends CharsetRecog_sbcs.CharsetRecog_8859_8
{
  private static int[] ngrams = { 2154725, 2154727, 2154729, 2154746, 2154985, 2154990, 2155744, 2155749, 2155753, 2155758, 2155762, 2155769, 2155770, 2157792, 2157796, 2158304, 2159340, 2161132, 14744096, 14950624, 14950625, 14950628, 14950636, 14950638, 14950649, 15001056, 15065120, 15068448, 15068960, 15071264, 15071776, 15278308, 15328288, 15328762, 15329773, 15330592, 15331104, 15333408, 15333920, 15474912, 15474916, 15523872, 15524896, 15540448, 15540449, 15540452, 15540460, 15540462, 15540473, 15655968, 15671524, 15787040, 15788320, 15788525, 15920160, 16261348, 16312813, 16378912, 16392416, 16392417, 16392420, 16392428, 16392430, 16392441 };
  
  public String getLanguage()
  {
    return "he";
  }
  
  public String getName()
  {
    return "ISO-8859-8-I";
  }
  
  public CharsetMatch match(CharsetDetector paramCharsetDetector)
  {
    AppMethodBeat.i(104764);
    if (paramCharsetDetector.fC1Bytes) {}
    int i;
    for (String str = "windows-1255";; str = "ISO-8859-8-I")
    {
      i = match(paramCharsetDetector, ngrams, byteMap);
      if (i != 0) {
        break;
      }
      AppMethodBeat.o(104764);
      return null;
    }
    paramCharsetDetector = new CharsetMatch(paramCharsetDetector, this, i, str, "he");
    AppMethodBeat.o(104764);
    return paramCharsetDetector;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_sbcs.CharsetRecog_8859_8_I_he
 * JD-Core Version:    0.7.0.1
 */