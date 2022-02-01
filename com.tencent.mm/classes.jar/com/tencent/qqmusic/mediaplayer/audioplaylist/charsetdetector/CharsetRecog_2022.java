package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import com.tencent.matrix.trace.core.AppMethodBeat;

abstract class CharsetRecog_2022
  extends CharsetRecognizer
{
  int match(byte[] paramArrayOfByte, int paramInt, byte[][] paramArrayOfByte1)
  {
    int i = 0;
    int j = 0;
    int m = 0;
    int k = 0;
    if (k < paramInt)
    {
      if (paramArrayOfByte[k] != 27) {
        break label216;
      }
      int n = 0;
      for (;;)
      {
        if (n >= paramArrayOfByte1.length) {
          break label122;
        }
        byte[] arrayOfByte = paramArrayOfByte1[n];
        if (paramInt - k >= arrayOfByte.length)
        {
          int i1 = 1;
          while (i1 < arrayOfByte.length)
          {
            if (arrayOfByte[i1] != paramArrayOfByte[(k + i1)]) {
              break label113;
            }
            i1 += 1;
          }
          m += 1;
          k += arrayOfByte.length - 1;
          k += 1;
          break;
        }
        label113:
        n += 1;
      }
      label122:
      j += 1;
    }
    label216:
    for (;;)
    {
      if ((paramArrayOfByte[k] == 14) || (paramArrayOfByte[k] == 15))
      {
        i += 1;
        break;
        if (m == 0) {}
        do
        {
          return 0;
          j = (m * 100 - j * 100) / (m + j);
          paramInt = j;
          if (m + i < 5) {
            paramInt = j - (5 - (m + i)) * 10;
          }
        } while (paramInt < 0);
        return paramInt;
      }
      break;
    }
  }
  
  static class CharsetRecog_2022CN
    extends CharsetRecog_2022
  {
    private byte[][] escapeSequences;
    
    CharsetRecog_2022CN()
    {
      AppMethodBeat.i(76617);
      byte[] arrayOfByte1 = { 27, 36, 43, 74 };
      byte[] arrayOfByte2 = { 27, 36, 43, 76 };
      byte[] arrayOfByte3 = { 27, 36, 43, 77 };
      this.escapeSequences = new byte[][] { { 27, 36, 41, 65 }, { 27, 36, 41, 71 }, { 27, 36, 42, 72 }, { 27, 36, 41, 69 }, { 27, 36, 43, 73 }, arrayOfByte1, { 27, 36, 43, 75 }, arrayOfByte2, arrayOfByte3, { 27, 78 }, { 27, 79 } };
      AppMethodBeat.o(76617);
    }
    
    String getName()
    {
      return "ISO-2022-CN";
    }
    
    CharsetMatch match(CharsetDetector paramCharsetDetector)
    {
      AppMethodBeat.i(76618);
      int i = match(paramCharsetDetector.fInputBytes, paramCharsetDetector.fInputLen, this.escapeSequences);
      if (i == 0)
      {
        AppMethodBeat.o(76618);
        return null;
      }
      paramCharsetDetector = new CharsetMatch(paramCharsetDetector, this, i);
      AppMethodBeat.o(76618);
      return paramCharsetDetector;
    }
  }
  
  static class CharsetRecog_2022JP
    extends CharsetRecog_2022
  {
    private byte[][] escapeSequences;
    
    CharsetRecog_2022JP()
    {
      AppMethodBeat.i(76646);
      this.escapeSequences = new byte[][] { { 27, 36, 40, 67 }, { 27, 36, 40, 68 }, { 27, 36, 64 }, { 27, 36, 65 }, { 27, 36, 66 }, { 27, 38, 64 }, { 27, 40, 66 }, { 27, 40, 72 }, { 27, 40, 73 }, { 27, 40, 74 }, { 27, 46, 65 }, { 27, 46, 70 } };
      AppMethodBeat.o(76646);
    }
    
    String getName()
    {
      return "ISO-2022-JP";
    }
    
    CharsetMatch match(CharsetDetector paramCharsetDetector)
    {
      AppMethodBeat.i(76647);
      int i = match(paramCharsetDetector.fInputBytes, paramCharsetDetector.fInputLen, this.escapeSequences);
      if (i == 0)
      {
        AppMethodBeat.o(76647);
        return null;
      }
      paramCharsetDetector = new CharsetMatch(paramCharsetDetector, this, i);
      AppMethodBeat.o(76647);
      return paramCharsetDetector;
    }
  }
  
  static class CharsetRecog_2022KR
    extends CharsetRecog_2022
  {
    private byte[][] escapeSequences = { { 27, 36, 41, 67 } };
    
    String getName()
    {
      return "ISO-2022-KR";
    }
    
    CharsetMatch match(CharsetDetector paramCharsetDetector)
    {
      int i = match(paramCharsetDetector.fInputBytes, paramCharsetDetector.fInputLen, this.escapeSequences);
      if (i == 0) {
        return null;
      }
      return new CharsetMatch(paramCharsetDetector, this, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_2022
 * JD-Core Version:    0.7.0.1
 */