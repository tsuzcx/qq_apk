package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.c;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public final class h
  extends a
{
  int NRq;
  int NRr;
  int NRs;
  
  public h()
  {
    AppMethodBeat.i(88135);
    this.NRq = 1;
    this.NRr = 1;
    this.NRs = 69;
    this.NQs = 262;
    this.NRr = util.NSo;
    if (util.NSo <= 2)
    {
      this.NRq = 1;
      this.NRs = 69;
      AppMethodBeat.o(88135);
      return;
    }
    this.NRq = 2;
    this.NRs = 90;
    AppMethodBeat.o(88135);
  }
  
  public final byte[] a(int paramInt1, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt2, byte[] paramArrayOfByte5)
  {
    AppMethodBeat.i(88136);
    if (util.NSo <= 2)
    {
      paramArrayOfByte5 = new byte[this.NRs];
      util.W(paramArrayOfByte5, 0, this.NRq);
      util.X(paramArrayOfByte5, 2, util.gyc());
      util.X(paramArrayOfByte5, 6, this.NRr);
      util.X(paramArrayOfByte5, 10, 522017402);
      util.X(paramArrayOfByte5, 14, paramInt1);
      util.c(paramArrayOfByte5, 18, paramLong);
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte5, 26, paramArrayOfByte1.length);
      paramInt1 = paramArrayOfByte1.length + 26;
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte5, paramInt1, paramArrayOfByte2.length);
      paramInt1 += paramArrayOfByte2.length;
      util.V(paramArrayOfByte5, paramInt1, 1);
      paramInt1 += 1;
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte5, paramInt1, paramArrayOfByte3.length);
      System.arraycopy(paramArrayOfByte4, 0, paramArrayOfByte5, paramInt1 + paramArrayOfByte3.length, paramArrayOfByte4.length);
      paramArrayOfByte1 = new byte[24];
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte1, 0, paramArrayOfByte3.length);
      util.c(paramArrayOfByte1, 16, paramLong);
      paramArrayOfByte1 = c.dp(paramArrayOfByte1);
      paramArrayOfByte1 = d.a(paramArrayOfByte5, paramArrayOfByte5.length, paramArrayOfByte1);
      this.NRs = paramArrayOfByte1.length;
      super.alW(this.NQs);
      super.af(paramArrayOfByte1, this.NRs);
      super.gxV();
      paramArrayOfByte1 = super.gxR();
      AppMethodBeat.o(88136);
      return paramArrayOfByte1;
    }
    byte[] arrayOfByte = new byte[this.NRs];
    util.W(arrayOfByte, 0, this.NRq);
    util.X(arrayOfByte, 2, util.gyc());
    util.X(arrayOfByte, 6, this.NRr);
    util.X(arrayOfByte, 10, 522017402);
    util.X(arrayOfByte, 14, paramInt1);
    util.c(arrayOfByte, 18, paramLong);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 26, paramArrayOfByte1.length);
    paramInt1 = paramArrayOfByte1.length + 26;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramInt1, paramArrayOfByte2.length);
    paramInt1 += paramArrayOfByte2.length;
    util.V(arrayOfByte, paramInt1, 1);
    paramInt1 += 1;
    System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, paramInt1, paramArrayOfByte3.length);
    paramInt1 += paramArrayOfByte3.length;
    System.arraycopy(paramArrayOfByte4, 0, arrayOfByte, paramInt1, paramArrayOfByte4.length);
    paramInt1 += paramArrayOfByte4.length;
    util.X(arrayOfByte, paramInt1, 0);
    paramInt1 += 4;
    util.V(arrayOfByte, paramInt1, paramInt2);
    if ((paramArrayOfByte5 == null) || (paramArrayOfByte5.length <= 0))
    {
      paramArrayOfByte1 = new byte[16];
      util.X(paramArrayOfByte1, 0, util.gyc());
      util.X(paramArrayOfByte1, 4, util.gyc());
      util.X(paramArrayOfByte1, 8, util.gyc());
      util.X(paramArrayOfByte1, 12, util.gyc());
    }
    for (;;)
    {
      paramArrayOfByte1 = new byte[24];
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte1, 0, paramArrayOfByte3.length);
      util.c(paramArrayOfByte1, 16, paramLong);
      paramArrayOfByte1 = c.dp(paramArrayOfByte1);
      paramArrayOfByte1 = d.a(arrayOfByte, arrayOfByte.length, paramArrayOfByte1);
      this.NRs = paramArrayOfByte1.length;
      super.alW(this.NQs);
      super.af(paramArrayOfByte1, this.NRs);
      super.gxV();
      paramArrayOfByte1 = gxR();
      AppMethodBeat.o(88136);
      return paramArrayOfByte1;
      System.arraycopy(paramArrayOfByte5, 0, arrayOfByte, paramInt1 + 1, paramArrayOfByte5.length);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.h
 * JD-Core Version:    0.7.0.1
 */