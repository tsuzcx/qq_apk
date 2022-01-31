package com.tencent.qqpinyin.voicerecoapi;

public final class a
{
  public static int MAX_FRAME_SIZE = 2000;
  private byte[] wKh = null;
  public byte[] wKi = null;
  private int wKj = 0;
  public int wKk = 0;
  public TRSpeexNative wKl = new TRSpeexNative();
  
  public final byte[] X(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.wKj == 0) {
      throw new b(-102);
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      throw new b(-104);
    }
    paramInt = this.wKl.nativeTRSpeexEncode(this.wKj, paramArrayOfByte, 0, paramInt, this.wKh);
    if (paramInt < 0) {
      throw new b(paramInt);
    }
    if (paramInt == 0) {
      return null;
    }
    paramArrayOfByte = new byte[paramInt];
    System.arraycopy(this.wKh, 0, paramArrayOfByte, 0, paramInt);
    return paramArrayOfByte;
  }
  
  public final int cOq()
  {
    int i;
    if (this.wKj != 0) {
      i = -103;
    }
    int j;
    do
    {
      return i;
      j = this.wKl.nativeTRSpeexInit();
      i = j;
    } while (j == -1);
    this.wKj = j;
    this.wKh = new byte[MAX_FRAME_SIZE * 10];
    return 0;
  }
  
  public final int cOr()
  {
    if (this.wKj == 0) {
      return -102;
    }
    this.wKh = null;
    int i = this.wKl.nativeTRSpeexRelease(this.wKj);
    this.wKj = 0;
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.qqpinyin.voicerecoapi.a
 * JD-Core Version:    0.7.0.1
 */