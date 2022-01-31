package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

class CharsetRecog_UTF8
  extends CharsetRecognizer
{
  String getName()
  {
    return "UTF-8";
  }
  
  CharsetMatch match(CharsetDetector paramCharsetDetector)
  {
    int i4 = 0;
    byte[] arrayOfByte = paramCharsetDetector.fRawInput;
    if ((paramCharsetDetector.fRawLength >= 3) && ((arrayOfByte[0] & 0xFF) == 239) && ((arrayOfByte[1] & 0xFF) == 187) && ((arrayOfByte[2] & 0xFF) == 191)) {}
    for (int m = 1;; m = 0)
    {
      int i = 0;
      int i1 = 0;
      int n = 0;
      int j;
      int k;
      label110:
      int i3;
      int i2;
      if (i < paramCharsetDetector.fRawLength)
      {
        j = arrayOfByte[i];
        if ((j & 0x80) == 0) {
          break label386;
        }
        if ((j & 0xE0) == 192)
        {
          k = 1;
          j = i;
          i = k;
          i3 = j + 1;
          j = i1;
          i2 = n;
          k = i3;
          if (i3 < paramCharsetDetector.fRawLength)
          {
            if ((arrayOfByte[i3] & 0xC0) == 128) {
              break label237;
            }
            j = i1 + 1;
            k = i3;
            i2 = n;
          }
        }
      }
      for (;;)
      {
        i = k + 1;
        i1 = j;
        n = i2;
        break;
        if ((j & 0xF0) == 224)
        {
          k = 2;
          j = i;
          i = k;
          break label110;
        }
        if ((j & 0xF8) == 240)
        {
          k = 3;
          j = i;
          i = k;
          break label110;
        }
        j = i1 + 1;
        i2 = n;
        k = i;
        continue;
        label237:
        i -= 1;
        if (i == 0)
        {
          i2 = n + 1;
          j = i1;
          k = i3;
          continue;
          if ((m != 0) && (i1 == 0)) {
            i = 100;
          }
          while (i == 0)
          {
            return null;
            if ((m != 0) && (n > i1 * 10))
            {
              i = 80;
            }
            else if ((n > 3) && (i1 == 0))
            {
              i = 100;
            }
            else if ((n > 0) && (i1 == 0))
            {
              i = 80;
            }
            else if ((n == 0) && (i1 == 0))
            {
              i = 15;
            }
            else
            {
              i = i4;
              if (n > i1 * 10) {
                i = 25;
              }
            }
          }
          return new CharsetMatch(paramCharsetDetector, this, i);
        }
        else
        {
          j = i3;
          break label110;
          label386:
          j = i1;
          i2 = n;
          k = i;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_UTF8
 * JD-Core Version:    0.7.0.1
 */