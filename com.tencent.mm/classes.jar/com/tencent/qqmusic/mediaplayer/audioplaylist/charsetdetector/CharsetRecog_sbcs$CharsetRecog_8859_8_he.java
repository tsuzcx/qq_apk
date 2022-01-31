package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import com.tencent.matrix.trace.core.AppMethodBeat;

class CharsetRecog_sbcs$CharsetRecog_8859_8_he
  extends CharsetRecog_sbcs.CharsetRecog_8859_8
{
  private static int[] ngrams = { 2154725, 2154732, 2155753, 2155756, 2155758, 2155760, 2157040, 2157810, 2157817, 2158053, 2158057, 2158565, 2158569, 2160869, 2160873, 2161376, 2161381, 2161385, 14688484, 14688492, 14688493, 14688506, 14738464, 14738916, 14740512, 14741024, 14754020, 14754029, 14754042, 14950628, 14950633, 14950636, 14950637, 14950639, 14950648, 14950650, 15002656, 15065120, 15066144, 15196192, 15327264, 15327520, 15328288, 15474916, 15474925, 15474938, 15528480, 15530272, 15591913, 15591920, 15591928, 15605988, 15605997, 15606010, 15655200, 15655968, 15918112, 16326884, 16326893, 16326906, 16376864, 16441376, 16442400, 16442857 };
  
  public String getLanguage()
  {
    return "he";
  }
  
  public CharsetMatch match(CharsetDetector paramCharsetDetector)
  {
    AppMethodBeat.i(104746);
    if (paramCharsetDetector.fC1Bytes) {}
    int i;
    for (String str = "windows-1255";; str = "ISO-8859-8")
    {
      i = match(paramCharsetDetector, ngrams, byteMap);
      if (i != 0) {
        break;
      }
      AppMethodBeat.o(104746);
      return null;
    }
    paramCharsetDetector = new CharsetMatch(paramCharsetDetector, this, i, str, "he");
    AppMethodBeat.o(104746);
    return paramCharsetDetector;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_sbcs.CharsetRecog_8859_8_he
 * JD-Core Version:    0.7.0.1
 */