package com.tencent.qqpinyin.voicerecoapi;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static int MAX_FRAME_SIZE = 2000;
  private byte[] ahrT;
  public byte[] ahrU;
  private long ahrV;
  public long ahrW;
  public TRSpeexNative ahrX;
  
  public a()
  {
    AppMethodBeat.i(87694);
    this.ahrT = null;
    this.ahrU = null;
    this.ahrV = 0L;
    this.ahrW = 0L;
    this.ahrX = new TRSpeexNative();
    AppMethodBeat.o(87694);
  }
  
  public final byte[] ak(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(87696);
    if (this.ahrV == 0L)
    {
      paramArrayOfByte = new b(-102);
      AppMethodBeat.o(87696);
      throw paramArrayOfByte;
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      paramArrayOfByte = new b(-104);
      AppMethodBeat.o(87696);
      throw paramArrayOfByte;
    }
    paramInt = this.ahrX.nativeTRSpeexEncode(this.ahrV, paramArrayOfByte, 0, paramInt, this.ahrT);
    if (paramInt < 0)
    {
      paramArrayOfByte = new b(paramInt);
      AppMethodBeat.o(87696);
      throw paramArrayOfByte;
    }
    if (paramInt == 0)
    {
      AppMethodBeat.o(87696);
      return null;
    }
    paramArrayOfByte = new byte[paramInt];
    System.arraycopy(this.ahrT, 0, paramArrayOfByte, 0, paramInt);
    AppMethodBeat.o(87696);
    return paramArrayOfByte;
  }
  
  public final int jXa()
  {
    AppMethodBeat.i(87695);
    if (this.ahrV != 0L)
    {
      AppMethodBeat.o(87695);
      return -103;
    }
    long l = this.ahrX.nativeTRSpeexInit();
    if (l == -1L)
    {
      int i = (int)l;
      AppMethodBeat.o(87695);
      return i;
    }
    this.ahrV = l;
    this.ahrT = new byte[MAX_FRAME_SIZE * 10];
    AppMethodBeat.o(87695);
    return 0;
  }
  
  public final int jXb()
  {
    AppMethodBeat.i(87697);
    if (this.ahrV == 0L)
    {
      AppMethodBeat.o(87697);
      return -102;
    }
    this.ahrT = null;
    int i = this.ahrX.nativeTRSpeexRelease(this.ahrV);
    this.ahrV = 0L;
    AppMethodBeat.o(87697);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.qqpinyin.voicerecoapi.a
 * JD-Core Version:    0.7.0.1
 */