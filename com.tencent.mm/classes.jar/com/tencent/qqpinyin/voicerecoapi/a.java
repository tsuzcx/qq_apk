package com.tencent.qqpinyin.voicerecoapi;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static int MAX_FRAME_SIZE = 2000;
  private byte[] LLe;
  public byte[] LLf;
  private long LLg;
  public long LLh;
  public TRSpeexNative LLi;
  
  public a()
  {
    AppMethodBeat.i(87694);
    this.LLe = null;
    this.LLf = null;
    this.LLg = 0L;
    this.LLh = 0L;
    this.LLi = new TRSpeexNative();
    AppMethodBeat.o(87694);
  }
  
  public final byte[] ac(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(87696);
    if (this.LLg == 0L)
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
    paramInt = this.LLi.nativeTRSpeexEncode(this.LLg, paramArrayOfByte, 0, paramInt, this.LLe);
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
    System.arraycopy(this.LLe, 0, paramArrayOfByte, 0, paramInt);
    AppMethodBeat.o(87696);
    return paramArrayOfByte;
  }
  
  public final int fTF()
  {
    AppMethodBeat.i(87695);
    if (this.LLg != 0L)
    {
      AppMethodBeat.o(87695);
      return -103;
    }
    long l = this.LLi.nativeTRSpeexInit();
    if (l == -1L)
    {
      int i = (int)l;
      AppMethodBeat.o(87695);
      return i;
    }
    this.LLg = l;
    this.LLe = new byte[MAX_FRAME_SIZE * 10];
    AppMethodBeat.o(87695);
    return 0;
  }
  
  public final int fTG()
  {
    AppMethodBeat.i(87697);
    if (this.LLg == 0L)
    {
      AppMethodBeat.o(87697);
      return -102;
    }
    this.LLe = null;
    int i = this.LLi.nativeTRSpeexRelease(this.LLg);
    this.LLg = 0L;
    AppMethodBeat.o(87697);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqpinyin.voicerecoapi.a
 * JD-Core Version:    0.7.0.1
 */