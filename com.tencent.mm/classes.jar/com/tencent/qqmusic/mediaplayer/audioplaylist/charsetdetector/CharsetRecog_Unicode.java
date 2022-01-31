package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_Unicode
 * JD-Core Version:    0.7.0.1
 */