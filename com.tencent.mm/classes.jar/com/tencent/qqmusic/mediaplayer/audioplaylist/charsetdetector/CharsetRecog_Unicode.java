package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

import com.tencent.matrix.trace.core.AppMethodBeat;

abstract class CharsetRecog_Unicode
  extends CharsetRecognizer
{
  static int adjustConfidence(int paramInt1, int paramInt2)
  {
    int i = 100;
    if (paramInt1 == 0) {
      paramInt1 = paramInt2 - 10;
    }
    for (;;)
    {
      if (paramInt1 < 0) {
        paramInt2 = 0;
      }
      do
      {
        return paramInt2;
        if (((paramInt1 < 32) || (paramInt1 > 255)) && (paramInt1 != 10)) {
          break label57;
        }
        paramInt1 = paramInt2 + 10;
        break;
        paramInt2 = i;
      } while (paramInt1 > 100);
      return paramInt1;
      label57:
      paramInt1 = paramInt2;
    }
  }
  
  static int codeUnit16FromBytes(byte paramByte1, byte paramByte2)
  {
    return (paramByte1 & 0xFF) << 8 | paramByte2 & 0xFF;
  }
  
  abstract String getName();
  
  abstract CharsetMatch match(CharsetDetector paramCharsetDetector);
  
  static class CharsetRecog_UTF_16_BE
    extends CharsetRecog_Unicode
  {
    String getName()
    {
      return "UTF-16BE";
    }
    
    CharsetMatch match(CharsetDetector paramCharsetDetector)
    {
      AppMethodBeat.i(76615);
      byte[] arrayOfByte = paramCharsetDetector.fRawInput;
      int j = 10;
      int m = Math.min(arrayOfByte.length, 30);
      int k = 0;
      for (;;)
      {
        int i = j;
        if (k < m - 1)
        {
          i = codeUnit16FromBytes(arrayOfByte[k], arrayOfByte[(k + 1)]);
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
            AppMethodBeat.o(76615);
            return paramCharsetDetector;
            j = adjustConfidence(i, j);
            i = j;
          } while (j == 0);
          i = j;
        } while (j == 100);
        k += 2;
      }
      AppMethodBeat.o(76615);
      return null;
    }
  }
  
  static class CharsetRecog_UTF_16_LE
    extends CharsetRecog_Unicode
  {
    String getName()
    {
      return "UTF-16LE";
    }
    
    CharsetMatch match(CharsetDetector paramCharsetDetector)
    {
      AppMethodBeat.i(76619);
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
            AppMethodBeat.o(76619);
            return paramCharsetDetector;
            j = adjustConfidence(i, j);
            i = j;
          } while (j == 0);
          i = j;
        } while (j == 100);
        k += 2;
      }
      AppMethodBeat.o(76619);
      return null;
    }
  }
  
  static abstract class CharsetRecog_UTF_32
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
  
  static class CharsetRecog_UTF_32_BE
    extends CharsetRecog_Unicode.CharsetRecog_UTF_32
  {
    int getChar(byte[] paramArrayOfByte, int paramInt)
    {
      return (paramArrayOfByte[(paramInt + 0)] & 0xFF) << 24 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8 | paramArrayOfByte[(paramInt + 3)] & 0xFF;
    }
    
    String getName()
    {
      return "UTF-32BE";
    }
  }
  
  static class CharsetRecog_UTF_32_LE
    extends CharsetRecog_Unicode.CharsetRecog_UTF_32
  {
    int getChar(byte[] paramArrayOfByte, int paramInt)
    {
      return (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8 | paramArrayOfByte[(paramInt + 0)] & 0xFF;
    }
    
    String getName()
    {
      return "UTF-32LE";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode
 * JD-Core Version:    0.7.0.1
 */