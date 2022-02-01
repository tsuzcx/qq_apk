package com.tencent.qqpinyin.voicerecoapi;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static int MAX_FRAME_SIZE = 2000;
  private byte[] Mid;
  public byte[] Mie;
  private long Mif;
  public long Mig;
  public TRSpeexNative Mih;
  
  public a()
  {
    AppMethodBeat.i(87694);
    this.Mid = null;
    this.Mie = null;
    this.Mif = 0L;
    this.Mig = 0L;
    this.Mih = new TRSpeexNative();
    AppMethodBeat.o(87694);
  }
  
  public final byte[] ag(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(87696);
    if (this.Mif == 0L)
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
    paramInt = this.Mih.nativeTRSpeexEncode(this.Mif, paramArrayOfByte, 0, paramInt, this.Mid);
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
    System.arraycopy(this.Mid, 0, paramArrayOfByte, 0, paramInt);
    AppMethodBeat.o(87696);
    return paramArrayOfByte;
  }
  
  public final int fYf()
  {
    AppMethodBeat.i(87695);
    if (this.Mif != 0L)
    {
      AppMethodBeat.o(87695);
      return -103;
    }
    long l = this.Mih.nativeTRSpeexInit();
    if (l == -1L)
    {
      int i = (int)l;
      AppMethodBeat.o(87695);
      return i;
    }
    this.Mif = l;
    this.Mid = new byte[MAX_FRAME_SIZE * 10];
    AppMethodBeat.o(87695);
    return 0;
  }
  
  public final int fYg()
  {
    AppMethodBeat.i(87697);
    if (this.Mif == 0L)
    {
      AppMethodBeat.o(87697);
      return -102;
    }
    this.Mid = null;
    int i = this.Mih.nativeTRSpeexRelease(this.Mif);
    this.Mif = 0L;
    AppMethodBeat.o(87697);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqpinyin.voicerecoapi.a
 * JD-Core Version:    0.7.0.1
 */