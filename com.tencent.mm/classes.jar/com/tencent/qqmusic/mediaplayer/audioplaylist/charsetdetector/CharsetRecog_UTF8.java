package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import com.tencent.matrix.trace.core.AppMethodBeat;

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
    AppMethodBeat.i(76644);
    byte[] arrayOfByte = paramCharsetDetector.fRawInput;
    if ((paramCharsetDetector.fRawLength >= 3) && ((arrayOfByte[0] & 0xFF) == 239) && ((arrayOfByte[1] & 0xFF) == 187) && ((arrayOfByte[2] & 0xFF) == 191)) {}
    for (int m = 1;; m = 0)
    {
      int i = 0;
      int i1 = 0;
      int n = 0;
      int j;
      int k;
      label115:
      int i3;
      int i2;
      if (i < paramCharsetDetector.fRawLength)
      {
        j = arrayOfByte[i];
        if ((j & 0x80) == 0) {
          break label403;
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
              break label242;
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
          break label115;
        }
        if ((j & 0xF8) == 240)
        {
          k = 3;
          j = i;
          i = k;
          break label115;
        }
        j = i1 + 1;
        i2 = n;
        k = i;
        continue;
        label242:
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
            AppMethodBeat.o(76644);
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
          paramCharsetDetector = new CharsetMatch(paramCharsetDetector, this, i);
          AppMethodBeat.o(76644);
          return paramCharsetDetector;
        }
        else
        {
          j = i3;
          break label115;
          label403:
          j = i1;
          i2 = n;
          k = i;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_UTF8
 * JD-Core Version:    0.7.0.1
 */