package com.tencent.qqpinyin.voicerecoapi;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static int MAX_FRAME_SIZE = 2000;
  private byte[] IpC;
  public byte[] IpD;
  private long IpE;
  public long IpF;
  public TRSpeexNative IpG;
  
  public a()
  {
    AppMethodBeat.i(87694);
    this.IpC = null;
    this.IpD = null;
    this.IpE = 0L;
    this.IpF = 0L;
    this.IpG = new TRSpeexNative();
    AppMethodBeat.o(87694);
  }
  
  public final byte[] ac(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(87696);
    if (this.IpE == 0L)
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
    paramInt = this.IpG.nativeTRSpeexEncode(this.IpE, paramArrayOfByte, 0, paramInt, this.IpC);
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
    System.arraycopy(this.IpC, 0, paramArrayOfByte, 0, paramInt);
    AppMethodBeat.o(87696);
    return paramArrayOfByte;
  }
  
  public final int flY()
  {
    AppMethodBeat.i(87695);
    if (this.IpE != 0L)
    {
      AppMethodBeat.o(87695);
      return -103;
    }
    long l = this.IpG.nativeTRSpeexInit();
    if (l == -1L)
    {
      int i = (int)l;
      AppMethodBeat.o(87695);
      return i;
    }
    this.IpE = l;
    this.IpC = new byte[MAX_FRAME_SIZE * 10];
    AppMethodBeat.o(87695);
    return 0;
  }
  
  public final int flZ()
  {
    AppMethodBeat.i(87697);
    if (this.IpE == 0L)
    {
      AppMethodBeat.o(87697);
      return -102;
    }
    this.IpC = null;
    int i = this.IpG.nativeTRSpeexRelease(this.IpE);
    this.IpE = 0L;
    AppMethodBeat.o(87697);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqpinyin.voicerecoapi.a
 * JD-Core Version:    0.7.0.1
 */