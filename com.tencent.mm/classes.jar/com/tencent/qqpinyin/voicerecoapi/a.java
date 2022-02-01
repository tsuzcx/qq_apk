package com.tencent.qqpinyin.voicerecoapi;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static int MAX_FRAME_SIZE = 2000;
  private byte[] RKE;
  public byte[] RKF;
  private long RKG;
  public long RKH;
  public TRSpeexNative RKI;
  
  public a()
  {
    AppMethodBeat.i(87694);
    this.RKE = null;
    this.RKF = null;
    this.RKG = 0L;
    this.RKH = 0L;
    this.RKI = new TRSpeexNative();
    AppMethodBeat.o(87694);
  }
  
  public final byte[] ah(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(87696);
    if (this.RKG == 0L)
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
    paramInt = this.RKI.nativeTRSpeexEncode(this.RKG, paramArrayOfByte, 0, paramInt, this.RKE);
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
    System.arraycopy(this.RKE, 0, paramArrayOfByte, 0, paramInt);
    AppMethodBeat.o(87696);
    return paramArrayOfByte;
  }
  
  public final int hkr()
  {
    AppMethodBeat.i(87695);
    if (this.RKG != 0L)
    {
      AppMethodBeat.o(87695);
      return -103;
    }
    long l = this.RKI.nativeTRSpeexInit();
    if (l == -1L)
    {
      int i = (int)l;
      AppMethodBeat.o(87695);
      return i;
    }
    this.RKG = l;
    this.RKE = new byte[MAX_FRAME_SIZE * 10];
    AppMethodBeat.o(87695);
    return 0;
  }
  
  public final int hks()
  {
    AppMethodBeat.i(87697);
    if (this.RKG == 0L)
    {
      AppMethodBeat.o(87697);
      return -102;
    }
    this.RKE = null;
    int i = this.RKI.nativeTRSpeexRelease(this.RKG);
    this.RKG = 0L;
    AppMethodBeat.o(87697);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqpinyin.voicerecoapi.a
 * JD-Core Version:    0.7.0.1
 */