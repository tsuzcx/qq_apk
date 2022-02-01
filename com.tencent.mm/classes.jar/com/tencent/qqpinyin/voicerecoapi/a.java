package com.tencent.qqpinyin.voicerecoapi;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static int MAX_FRAME_SIZE = 2000;
  private byte[] JRm;
  public byte[] JRn;
  private long JRo;
  public long JRp;
  public TRSpeexNative JRq;
  
  public a()
  {
    AppMethodBeat.i(87694);
    this.JRm = null;
    this.JRn = null;
    this.JRo = 0L;
    this.JRp = 0L;
    this.JRq = new TRSpeexNative();
    AppMethodBeat.o(87694);
  }
  
  public final byte[] ab(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(87696);
    if (this.JRo == 0L)
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
    paramInt = this.JRq.nativeTRSpeexEncode(this.JRo, paramArrayOfByte, 0, paramInt, this.JRm);
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
    System.arraycopy(this.JRm, 0, paramArrayOfByte, 0, paramInt);
    AppMethodBeat.o(87696);
    return paramArrayOfByte;
  }
  
  public final int fCp()
  {
    AppMethodBeat.i(87695);
    if (this.JRo != 0L)
    {
      AppMethodBeat.o(87695);
      return -103;
    }
    long l = this.JRq.nativeTRSpeexInit();
    if (l == -1L)
    {
      int i = (int)l;
      AppMethodBeat.o(87695);
      return i;
    }
    this.JRo = l;
    this.JRm = new byte[MAX_FRAME_SIZE * 10];
    AppMethodBeat.o(87695);
    return 0;
  }
  
  public final int fCq()
  {
    AppMethodBeat.i(87697);
    if (this.JRo == 0L)
    {
      AppMethodBeat.o(87697);
      return -102;
    }
    this.JRm = null;
    int i = this.JRq.nativeTRSpeexRelease(this.JRo);
    this.JRo = 0L;
    AppMethodBeat.o(87697);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.qqpinyin.voicerecoapi.a
 * JD-Core Version:    0.7.0.1
 */