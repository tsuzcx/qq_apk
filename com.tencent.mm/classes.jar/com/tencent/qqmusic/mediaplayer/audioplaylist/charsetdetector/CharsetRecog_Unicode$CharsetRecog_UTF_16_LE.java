package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import com.tencent.matrix.trace.core.AppMethodBeat;

class CharsetRecog_Unicode$CharsetRecog_UTF_16_LE
  extends CharsetRecog_Unicode
{
  String getName()
  {
    return "UTF-16LE";
  }
  
  CharsetMatch match(CharsetDetector paramCharsetDetector)
  {
    AppMethodBeat.i(104713);
    byte[] arrayOfByte = paramCharsetDetector.fRawInput;
    int j = 10;
    int m = Math.min(arrayOfByte.length, 30);
    int k = 0;
    for (;;)
    {
      int i = j;
      if (k < m - 1)
      {
        i = codeUnit16FromBytes(arrayOfByte[(k + 1)], arrayOfByte[k]);
        if ((k != 0) || (i != 65279)) {
          break label108;
        }
        i = 100;
      }
      label108:
      do
      {
        do
        {
          j = i;
          if (m < 4)
          {
            j = i;
            if (i < 100) {
              j = 0;
            }
          }
          if (j <= 0) {
            break;
          }
          paramCharsetDetector = new CharsetMatch(paramCharsetDetector, this, j);
          AppMethodBeat.o(104713);
          return paramCharsetDetector;
          j = adjustConfidence(i, j);
          i = j;
        } while (j == 0);
        i = j;
      } while (j == 100);
      k += 2;
    }
    AppMethodBeat.o(104713);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode.CharsetRecog_UTF_16_LE
 * JD-Core Version:    0.7.0.1
 */