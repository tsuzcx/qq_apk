package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_2022
 * JD-Core Version:    0.7.0.1
 */