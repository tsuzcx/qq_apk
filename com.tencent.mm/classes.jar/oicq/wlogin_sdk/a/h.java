package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.c;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public final class h
  extends a
{
  int ajHO;
  int ajHP;
  int ajHQ;
  
  public h()
  {
    AppMethodBeat.i(88135);
    this.ajHO = 1;
    this.ajHP = 1;
    this.ajHQ = 69;
    this.ajGQ = 262;
    this.ajHP = util.ajIM;
    if (util.ajIM <= 2)
    {
      this.ajHO = 1;
      this.ajHQ = 69;
      AppMethodBeat.o(88135);
      return;
    }
    this.ajHO = 2;
    this.ajHQ = 90;
    AppMethodBeat.o(88135);
  }
  
  public final byte[] a(long paramLong1, int paramInt1, long paramLong2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt2, byte[] paramArrayOfByte5)
  {
    AppMethodBeat.i(186471);
    if (util.ajIM <= 2)
    {
      paramArrayOfByte5 = new byte[this.ajHQ];
      util.ag(paramArrayOfByte5, 0, this.ajHO);
      util.ah(paramArrayOfByte5, 2, util.kGr());
      util.ah(paramArrayOfByte5, 6, this.ajHP);
      util.ah(paramArrayOfByte5, 10, 522017402);
      util.ah(paramArrayOfByte5, 14, paramInt1);
      util.c(paramArrayOfByte5, 18, paramLong2);
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte5, 26, paramArrayOfByte1.length);
      paramInt1 = paramArrayOfByte1.length + 26;
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte5, paramInt1, paramArrayOfByte2.length);
      paramInt1 += paramArrayOfByte2.length;
      util.af(paramArrayOfByte5, paramInt1, 1);
      paramInt1 += 1;
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte5, paramInt1, paramArrayOfByte3.length);
      System.arraycopy(paramArrayOfByte4, 0, paramArrayOfByte5, paramInt1 + paramArrayOfByte3.length, paramArrayOfByte4.length);
      paramArrayOfByte1 = new byte[24];
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte1, 0, paramArrayOfByte3.length);
      util.c(paramArrayOfByte1, 16, paramLong2);
      paramArrayOfByte1 = c.dW(paramArrayOfByte1);
      paramArrayOfByte1 = d.c(paramArrayOfByte5, paramArrayOfByte5.length, paramArrayOfByte1);
      this.ajHQ = paramArrayOfByte1.length;
      super.aMR(this.ajGQ);
      super.an(paramArrayOfByte1, this.ajHQ);
      super.kGk();
      paramArrayOfByte1 = super.kGg();
      AppMethodBeat.o(186471);
      return paramArrayOfByte1;
    }
    byte[] arrayOfByte = new byte[this.ajHQ];
    util.ag(arrayOfByte, 0, this.ajHO);
    util.ah(arrayOfByte, 2, util.kGr());
    util.ah(arrayOfByte, 6, this.ajHP);
    util.ah(arrayOfByte, 10, 522017402);
    util.ah(arrayOfByte, 14, paramInt1);
    util.c(arrayOfByte, 18, paramLong2);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 26, paramArrayOfByte1.length);
    paramInt1 = paramArrayOfByte1.length + 26;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramInt1, paramArrayOfByte2.length);
    paramInt1 += paramArrayOfByte2.length;
    util.af(arrayOfByte, paramInt1, 1);
    paramInt1 += 1;
    System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, paramInt1, paramArrayOfByte3.length);
    paramInt1 += paramArrayOfByte3.length;
    System.arraycopy(paramArrayOfByte4, 0, arrayOfByte, paramInt1, paramArrayOfByte4.length);
    paramInt1 += paramArrayOfByte4.length;
    util.ah(arrayOfByte, paramInt1, 0);
    paramInt1 += 4;
    util.af(arrayOfByte, paramInt1, paramInt2);
    if ((paramArrayOfByte5 == null) || (paramArrayOfByte5.length <= 0))
    {
      paramArrayOfByte1 = new byte[16];
      util.ah(paramArrayOfByte1, 0, util.kGr());
      util.ah(paramArrayOfByte1, 4, util.kGr());
      util.ah(paramArrayOfByte1, 8, util.kGr());
      util.ah(paramArrayOfByte1, 12, util.kGr());
    }
    for (;;)
    {
      paramArrayOfByte1 = new byte[24];
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte1, 0, paramArrayOfByte3.length);
      util.c(paramArrayOfByte1, 16, paramLong2);
      paramArrayOfByte1 = c.dW(paramArrayOfByte1);
      paramArrayOfByte1 = d.c(arrayOfByte, arrayOfByte.length, paramArrayOfByte1);
      this.ajHQ = paramArrayOfByte1.length;
      super.aMR(this.ajGQ);
      super.an(paramArrayOfByte1, this.ajHQ);
      super.kGk();
      paramArrayOfByte1 = kGg();
      AppMethodBeat.o(186471);
      return paramArrayOfByte1;
      System.arraycopy(paramArrayOfByte5, 0, arrayOfByte, paramInt1 + 1, paramArrayOfByte5.length);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     oicq.wlogin_sdk.a.h
 * JD-Core Version:    0.7.0.1
 */