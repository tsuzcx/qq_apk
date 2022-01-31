package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

abstract class CharsetRecog_Unicode$CharsetRecog_UTF_32
  extends CharsetRecog_Unicode
{
  abstract int getChar(byte[] paramArrayOfByte, int paramInt);
  
  abstract String getName();
  
  CharsetMatch match(CharsetDetector paramCharsetDetector)
  {
    int n = 0;
    byte[] arrayOfByte = paramCharsetDetector.fRawInput;
    int i1 = paramCharsetDetector.fRawLength / 4 * 4;
    if (i1 == 0) {
      return null;
    }
    if (getChar(arrayOfByte, 0) == 65279) {}
    for (int i = 1;; i = 0)
    {
      int j = 0;
      int k = 0;
      int m = 0;
      if (j < i1)
      {
        int i2 = getChar(arrayOfByte, j);
        if ((i2 < 0) || (i2 >= 1114111) || ((i2 >= 55296) && (i2 <= 57343))) {
          k += 1;
        }
        for (;;)
        {
          j += 4;
          break;
          m += 1;
        }
      }
      if ((i != 0) && (k == 0)) {
        i = 100;
      }
      while (i == 0)
      {
        return null;
        if ((i != 0) && (m > k * 10))
        {
          i = 80;
        }
        else if ((m > 3) && (k == 0))
        {
          i = 100;
        }
        else if ((m > 0) && (k == 0))
        {
          i = 80;
        }
        else
        {
          i = n;
          if (m > k * 10) {
            i = 25;
          }
        }
      }
      return new CharsetMatch(paramCharsetDetector, this, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode.CharsetRecog_UTF_32
 * JD-Core Version:    0.7.0.1
 */