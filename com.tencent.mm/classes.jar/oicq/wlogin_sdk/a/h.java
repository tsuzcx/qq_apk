package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.c;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public final class h
  extends a
{
  int abGK;
  int abGL;
  int abGM;
  
  public h()
  {
    AppMethodBeat.i(88135);
    this.abGK = 1;
    this.abGL = 1;
    this.abGM = 69;
    this.abFM = 262;
    this.abGL = util.abHH;
    if (util.abHH <= 2)
    {
      this.abGK = 1;
      this.abGM = 69;
      AppMethodBeat.o(88135);
      return;
    }
    this.abGK = 2;
    this.abGM = 90;
    AppMethodBeat.o(88135);
  }
  
  public final byte[] a(long paramLong1, int paramInt1, long paramLong2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt2, byte[] paramArrayOfByte5)
  {
    AppMethodBeat.i(187837);
    if (util.abHH <= 2)
    {
      paramArrayOfByte5 = new byte[this.abGM];
      util.ai(paramArrayOfByte5, 0, this.abGK);
      util.aj(paramArrayOfByte5, 2, util.iUQ());
      util.aj(paramArrayOfByte5, 6, this.abGL);
      util.aj(paramArrayOfByte5, 10, 522017402);
      util.aj(paramArrayOfByte5, 14, paramInt1);
      util.c(paramArrayOfByte5, 18, paramLong2);
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte5, 26, paramArrayOfByte1.length);
      paramInt1 = paramArrayOfByte1.length + 26;
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte5, paramInt1, paramArrayOfByte2.length);
      paramInt1 += paramArrayOfByte2.length;
      util.ah(paramArrayOfByte5, paramInt1, 1);
      paramInt1 += 1;
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte5, paramInt1, paramArrayOfByte3.length);
      System.arraycopy(paramArrayOfByte4, 0, paramArrayOfByte5, paramInt1 + paramArrayOfByte3.length, paramArrayOfByte4.length);
      paramArrayOfByte1 = new byte[24];
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte1, 0, paramArrayOfByte3.length);
      util.c(paramArrayOfByte1, 16, paramLong2);
      paramArrayOfByte1 = c.dT(paramArrayOfByte1);
      paramArrayOfByte1 = d.b(paramArrayOfByte5, paramArrayOfByte5.length, paramArrayOfByte1);
      this.abGM = paramArrayOfByte1.length;
      super.aGe(this.abFM);
      super.am(paramArrayOfByte1, this.abGM);
      super.iUJ();
      paramArrayOfByte1 = super.iUF();
      AppMethodBeat.o(187837);
      return paramArrayOfByte1;
    }
    byte[] arrayOfByte = new byte[this.abGM];
    util.ai(arrayOfByte, 0, this.abGK);
    util.aj(arrayOfByte, 2, util.iUQ());
    util.aj(arrayOfByte, 6, this.abGL);
    util.aj(arrayOfByte, 10, 522017402);
    util.aj(arrayOfByte, 14, paramInt1);
    util.c(arrayOfByte, 18, paramLong2);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 26, paramArrayOfByte1.length);
    paramInt1 = paramArrayOfByte1.length + 26;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramInt1, paramArrayOfByte2.length);
    paramInt1 += paramArrayOfByte2.length;
    util.ah(arrayOfByte, paramInt1, 1);
    paramInt1 += 1;
    System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, paramInt1, paramArrayOfByte3.length);
    paramInt1 += paramArrayOfByte3.length;
    System.arraycopy(paramArrayOfByte4, 0, arrayOfByte, paramInt1, paramArrayOfByte4.length);
    paramInt1 += paramArrayOfByte4.length;
    util.aj(arrayOfByte, paramInt1, 0);
    paramInt1 += 4;
    util.ah(arrayOfByte, paramInt1, paramInt2);
    if ((paramArrayOfByte5 == null) || (paramArrayOfByte5.length <= 0))
    {
      paramArrayOfByte1 = new byte[16];
      util.aj(paramArrayOfByte1, 0, util.iUQ());
      util.aj(paramArrayOfByte1, 4, util.iUQ());
      util.aj(paramArrayOfByte1, 8, util.iUQ());
      util.aj(paramArrayOfByte1, 12, util.iUQ());
    }
    for (;;)
    {
      paramArrayOfByte1 = new byte[24];
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte1, 0, paramArrayOfByte3.length);
      util.c(paramArrayOfByte1, 16, paramLong2);
      paramArrayOfByte1 = c.dT(paramArrayOfByte1);
      paramArrayOfByte1 = d.b(arrayOfByte, arrayOfByte.length, paramArrayOfByte1);
      this.abGM = paramArrayOfByte1.length;
      super.aGe(this.abFM);
      super.am(paramArrayOfByte1, this.abGM);
      super.iUJ();
      paramArrayOfByte1 = iUF();
      AppMethodBeat.o(187837);
      return paramArrayOfByte1;
      System.arraycopy(paramArrayOfByte5, 0, arrayOfByte, paramInt1 + 1, paramArrayOfByte5.length);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     oicq.wlogin_sdk.a.h
 * JD-Core Version:    0.7.0.1
 */