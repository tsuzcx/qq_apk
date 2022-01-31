package com.tencent.qqpinyin.voicerecoapi;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static int MAX_FRAME_SIZE = 2000;
  private byte[] BhI;
  public byte[] BhJ;
  private int BhK;
  public int BhL;
  public TRSpeexNative BhM;
  
  public a()
  {
    AppMethodBeat.i(35432);
    this.BhI = null;
    this.BhJ = null;
    this.BhK = 0;
    this.BhL = 0;
    this.BhM = new TRSpeexNative();
    AppMethodBeat.o(35432);
  }
  
  public final byte[] Y(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(35434);
    if (this.BhK == 0)
    {
      paramArrayOfByte = new b(-102);
      AppMethodBeat.o(35434);
      throw paramArrayOfByte;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      paramArrayOfByte = new b(-104);
      AppMethodBeat.o(35434);
      throw paramArrayOfByte;
    }
    paramInt = this.BhM.nativeTRSpeexEncode(this.BhK, paramArrayOfByte, 0, paramInt, this.BhI);
    if (paramInt < 0)
    {
      paramArrayOfByte = new b(paramInt);
      AppMethodBeat.o(35434);
      throw paramArrayOfByte;
    }
    if (paramInt == 0)
    {
      AppMethodBeat.o(35434);
      return null;
    }
    paramArrayOfByte = new byte[paramInt];
    System.arraycopy(this.BhI, 0, paramArrayOfByte, 0, paramInt);
    AppMethodBeat.o(35434);
    return paramArrayOfByte;
  }
  
  public final int dUe()
  {
    AppMethodBeat.i(35433);
    if (this.BhK != 0)
    {
      AppMethodBeat.o(35433);
      return -103;
    }
    int i = this.BhM.nativeTRSpeexInit();
    if (i == -1)
    {
      AppMethodBeat.o(35433);
      return i;
    }
    this.BhK = i;
    this.BhI = new byte[MAX_FRAME_SIZE * 10];
    AppMethodBeat.o(35433);
    return 0;
  }
  
  public final int dUf()
  {
    AppMethodBeat.i(35435);
    if (this.BhK == 0)
    {
      AppMethodBeat.o(35435);
      return -102;
    }
    this.BhI = null;
    int i = this.BhM.nativeTRSpeexRelease(this.BhK);
    this.BhK = 0;
    AppMethodBeat.o(35435);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.qqpinyin.voicerecoapi.a
 * JD-Core Version:    0.7.0.1
 */