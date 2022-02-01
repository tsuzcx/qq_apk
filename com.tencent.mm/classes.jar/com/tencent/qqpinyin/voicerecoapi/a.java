package com.tencent.qqpinyin.voicerecoapi;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static int MAX_FRAME_SIZE = 2000;
  private byte[] Znl;
  public byte[] Znm;
  private long Znn;
  public long Zno;
  public TRSpeexNative Znp;
  
  public a()
  {
    AppMethodBeat.i(87694);
    this.Znl = null;
    this.Znm = null;
    this.Znn = 0L;
    this.Zno = 0L;
    this.Znp = new TRSpeexNative();
    AppMethodBeat.o(87694);
  }
  
  public final byte[] aj(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(87696);
    if (this.Znn == 0L)
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
    paramInt = this.Znp.nativeTRSpeexEncode(this.Znn, paramArrayOfByte, 0, paramInt, this.Znl);
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
    System.arraycopy(this.Znl, 0, paramArrayOfByte, 0, paramInt);
    AppMethodBeat.o(87696);
    return paramArrayOfByte;
  }
  
  public final int inP()
  {
    AppMethodBeat.i(87695);
    if (this.Znn != 0L)
    {
      AppMethodBeat.o(87695);
      return -103;
    }
    long l = this.Znp.nativeTRSpeexInit();
    if (l == -1L)
    {
      int i = (int)l;
      AppMethodBeat.o(87695);
      return i;
    }
    this.Znn = l;
    this.Znl = new byte[MAX_FRAME_SIZE * 10];
    AppMethodBeat.o(87695);
    return 0;
  }
  
  public final int inQ()
  {
    AppMethodBeat.i(87697);
    if (this.Znn == 0L)
    {
      AppMethodBeat.o(87697);
      return -102;
    }
    this.Znl = null;
    int i = this.Znp.nativeTRSpeexRelease(this.Znn);
    this.Znn = 0L;
    AppMethodBeat.o(87697);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.qqpinyin.voicerecoapi.a
 * JD-Core Version:    0.7.0.1
 */