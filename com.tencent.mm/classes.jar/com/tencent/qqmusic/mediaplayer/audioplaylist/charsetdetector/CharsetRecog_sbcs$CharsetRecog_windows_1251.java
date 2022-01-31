package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import com.tencent.matrix.trace.core.AppMethodBeat;

class CharsetRecog_sbcs$CharsetRecog_windows_1251
  extends CharsetRecog_sbcs
{
  private static byte[] byteMap = { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 0, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 32, 32, 32, 32, 32, 32, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 32, 32, 32, 32, 32, -112, -125, 32, -125, 32, 32, 32, 32, 32, 32, -102, 32, -100, -99, -98, -97, -112, 32, 32, 32, 32, 32, 32, 32, 32, 32, -102, 32, -100, -99, -98, -97, 32, -94, -94, -68, 32, -76, 32, 32, -72, 32, -70, 32, 32, 32, 32, -65, 32, 32, -77, -77, -76, -75, 32, 32, -72, 32, -70, 32, -68, -66, -66, -65, -32, -31, -30, -29, -28, -27, -26, -25, -24, -23, -22, -21, -20, -19, -18, -17, -16, -15, -14, -13, -12, -11, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1, -32, -31, -30, -29, -28, -27, -26, -25, -24, -23, -22, -21, -20, -19, -18, -17, -16, -15, -14, -13, -12, -11, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1 };
  private static int[] ngrams = { 2155040, 2155246, 2155758, 2156512, 2156576, 2157280, 2157294, 2158048, 2158053, 2158305, 2158574, 2158576, 2158816, 2159086, 2159090, 2159342, 2160626, 2162162, 14740968, 14742268, 14937632, 15068156, 15068648, 15069682, 15069728, 15212783, 15263008, 15263776, 15269664, 15459821, 15460384, 15465709, 15589408, 15590688, 15591653, 15591679, 15592992, 15593186, 15605986, 15605999, 15606001, 15655456, 15655648, 15655918, 15657248, 15657980, 15658016, 15659506, 15724267, 15724773, 15724776, 15724782, 15786210, 15787492, 15856352, 15856354, 15856360, 15859488, 15918571, 15920672, 15920880, 15924256, 16249582, 16512288 };
  
  public String getLanguage()
  {
    return "ru";
  }
  
  public String getName()
  {
    return "windows-1251";
  }
  
  public CharsetMatch match(CharsetDetector paramCharsetDetector)
  {
    AppMethodBeat.i(104743);
    int i = match(paramCharsetDetector, ngrams, byteMap);
    if (i == 0)
    {
      AppMethodBeat.o(104743);
      return null;
    }
    paramCharsetDetector = new CharsetMatch(paramCharsetDetector, this, i);
    AppMethodBeat.o(104743);
    return paramCharsetDetector;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_sbcs.CharsetRecog_windows_1251
 * JD-Core Version:    0.7.0.1
 */