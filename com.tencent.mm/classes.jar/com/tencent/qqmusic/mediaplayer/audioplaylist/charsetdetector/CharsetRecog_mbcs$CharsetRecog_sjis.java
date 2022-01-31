package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

class CharsetRecog_mbcs$CharsetRecog_sjis
  extends CharsetRecog_mbcs
{
  static int[] commonChars = { 33088, 33089, 33090, 33093, 33115, 33129, 33130, 33141, 33142, 33440, 33442, 33444, 33449, 33450, 33451, 33453, 33455, 33457, 33459, 33461, 33463, 33469, 33470, 33473, 33476, 33477, 33478, 33480, 33481, 33484, 33485, 33500, 33504, 33511, 33512, 33513, 33514, 33520, 33521, 33601, 33603, 33614, 33615, 33624, 33630, 33634, 33639, 33653, 33654, 33673, 33674, 33675, 33677, 33683, 36502, 37882, 38314 };
  
  public String getLanguage()
  {
    return "ja";
  }
  
  String getName()
  {
    return "Shift_JIS";
  }
  
  CharsetMatch match(CharsetDetector paramCharsetDetector)
  {
    int i = match(paramCharsetDetector, commonChars);
    if (i == 0) {
      return null;
    }
    return new CharsetMatch(paramCharsetDetector, this, i);
  }
  
  boolean nextChar(CharsetRecog_mbcs.iteratedChar paramiteratedChar, CharsetDetector paramCharsetDetector)
  {
    paramiteratedChar.error = false;
    int i = paramiteratedChar.nextByte(paramCharsetDetector);
    paramiteratedChar.charValue = i;
    if (i < 0) {}
    int j;
    do
    {
      return false;
      if ((i <= 127) || ((i > 160) && (i <= 223))) {
        return true;
      }
      j = paramiteratedChar.nextByte(paramCharsetDetector);
    } while (j < 0);
    paramiteratedChar.charValue = (i << 8 | j);
    if (((j < 64) || (j > 127)) && ((j < 128) || (j > 255))) {
      paramiteratedChar.error = true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_mbcs.CharsetRecog_sjis
 * JD-Core Version:    0.7.0.1
 */