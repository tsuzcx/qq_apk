package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

class CharsetRecog_sbcs$CharsetRecog_8859_7_el
  extends CharsetRecog_sbcs.CharsetRecog_8859_7
{
  private static int[] ngrams = { 2154989, 2154992, 2155497, 2155753, 2156016, 2156320, 2157281, 2157797, 2158049, 2158368, 2158817, 2158831, 2158833, 2159604, 2159605, 2159847, 2159855, 14672160, 14754017, 14754036, 14805280, 14806304, 14807292, 14807584, 14936545, 15067424, 15069728, 15147252, 15199520, 15200800, 15278324, 15327520, 15330014, 15331872, 15393257, 15393268, 15525152, 15540449, 15540453, 15540464, 15589664, 15725088, 15725856, 15790069, 15790575, 15793184, 15868129, 15868133, 15868138, 15868144, 15868148, 15983904, 15984416, 15987951, 16048416, 16048617, 16050157, 16050162, 16050666, 16052000, 16052213, 16054765, 16379168, 16706848 };
  
  public String getLanguage()
  {
    return "el";
  }
  
  public CharsetMatch match(CharsetDetector paramCharsetDetector)
  {
    if (paramCharsetDetector.fC1Bytes) {}
    int i;
    for (String str = "windows-1253";; str = "ISO-8859-7")
    {
      i = match(paramCharsetDetector, ngrams, byteMap);
      if (i != 0) {
        break;
      }
      return null;
    }
    return new CharsetMatch(paramCharsetDetector, this, i, str, "el");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_sbcs.CharsetRecog_8859_7_el
 * JD-Core Version:    0.7.0.1
 */