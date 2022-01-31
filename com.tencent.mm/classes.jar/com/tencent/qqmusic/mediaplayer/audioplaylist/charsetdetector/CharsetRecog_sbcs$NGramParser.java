package com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector;

class CharsetRecog_sbcs$NGramParser
{
  private static final int N_GRAM_MASK = 16777215;
  protected int byteIndex = 0;
  protected byte[] byteMap;
  private int hitCount;
  private int ngram = 0;
  private int ngramCount;
  private int[] ngramList;
  protected byte spaceChar;
  
  public CharsetRecog_sbcs$NGramParser(int[] paramArrayOfInt, byte[] paramArrayOfByte)
  {
    this.ngramList = paramArrayOfInt;
    this.byteMap = paramArrayOfByte;
    this.ngram = 0;
    this.hitCount = 0;
    this.ngramCount = 0;
  }
  
  private void lookup(int paramInt)
  {
    this.ngramCount += 1;
    if (search(this.ngramList, paramInt) >= 0) {
      this.hitCount += 1;
    }
  }
  
  private int nextByte(CharsetDetector paramCharsetDetector)
  {
    if (this.byteIndex >= paramCharsetDetector.fInputLen) {
      return -1;
    }
    paramCharsetDetector = paramCharsetDetector.fInputBytes;
    int i = this.byteIndex;
    this.byteIndex = (i + 1);
    return paramCharsetDetector[i] & 0xFF;
  }
  
  private static int search(int[] paramArrayOfInt, int paramInt)
  {
    int j = 32;
    if (paramArrayOfInt[32] <= paramInt) {}
    for (;;)
    {
      int i = j;
      if (paramArrayOfInt[(j + 16)] <= paramInt) {
        i = j + 16;
      }
      j = i;
      if (paramArrayOfInt[(i + 8)] <= paramInt) {
        j = i + 8;
      }
      i = j;
      if (paramArrayOfInt[(j + 4)] <= paramInt) {
        i = j + 4;
      }
      j = i;
      if (paramArrayOfInt[(i + 2)] <= paramInt) {
        j = i + 2;
      }
      i = j;
      if (paramArrayOfInt[(j + 1)] <= paramInt) {
        i = j + 1;
      }
      j = i;
      if (paramArrayOfInt[i] > paramInt) {
        j = i - 1;
      }
      if (j >= 0)
      {
        i = j;
        if (paramArrayOfInt[j] == paramInt) {}
      }
      else
      {
        i = -1;
      }
      return i;
      j = 0;
    }
  }
  
  protected void addByte(int paramInt)
  {
    this.ngram = ((this.ngram << 8) + (paramInt & 0xFF) & 0xFFFFFF);
    lookup(this.ngram);
  }
  
  public int parse(CharsetDetector paramCharsetDetector)
  {
    return parse(paramCharsetDetector, (byte)32);
  }
  
  public int parse(CharsetDetector paramCharsetDetector, byte paramByte)
  {
    this.spaceChar = paramByte;
    parseCharacters(paramCharsetDetector);
    addByte(this.spaceChar);
    double d = this.hitCount / this.ngramCount;
    if (d > 0.33D) {
      return 98;
    }
    return (int)(d * 300.0D);
  }
  
  protected void parseCharacters(CharsetDetector paramCharsetDetector)
  {
    int i = 0;
    for (;;)
    {
      int j = nextByte(paramCharsetDetector);
      if (j < 0) {
        break;
      }
      j = this.byteMap[j];
      if (j != 0)
      {
        if ((j != this.spaceChar) || (i == 0)) {
          addByte(j);
        }
        if (j == this.spaceChar) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetRecog_sbcs.NGramParser
 * JD-Core Version:    0.7.0.1
 */