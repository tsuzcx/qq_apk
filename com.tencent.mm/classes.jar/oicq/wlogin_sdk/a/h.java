package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.c;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public final class h
  extends a
{
  int CNB;
  int CNC;
  int CND;
  
  public h()
  {
    AppMethodBeat.i(96496);
    this.CNB = 1;
    this.CNC = 1;
    this.CND = 69;
    this.CMD = 262;
    this.CNC = util.COy;
    if (util.COy <= 2)
    {
      this.CNB = 1;
      this.CND = 69;
      AppMethodBeat.o(96496);
      return;
    }
    this.CNB = 2;
    this.CND = 90;
    AppMethodBeat.o(96496);
  }
  
  public final byte[] a(int paramInt1, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt2, byte[] paramArrayOfByte5)
  {
    AppMethodBeat.i(96497);
    if (util.COy <= 2)
    {
      paramArrayOfByte5 = new byte[this.CND];
      util.O(paramArrayOfByte5, 0, this.CNB);
      util.P(paramArrayOfByte5, 2, util.erl());
      util.P(paramArrayOfByte5, 6, this.CNC);
      util.P(paramArrayOfByte5, 10, 522017402);
      util.P(paramArrayOfByte5, 14, paramInt1);
      util.c(paramArrayOfByte5, 18, paramLong);
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte5, 26, paramArrayOfByte1.length);
      paramInt1 = paramArrayOfByte1.length + 26;
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte5, paramInt1, paramArrayOfByte2.length);
      paramInt1 += paramArrayOfByte2.length;
      util.N(paramArrayOfByte5, paramInt1, 1);
      paramInt1 += 1;
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte5, paramInt1, paramArrayOfByte3.length);
      System.arraycopy(paramArrayOfByte4, 0, paramArrayOfByte5, paramInt1 + paramArrayOfByte3.length, paramArrayOfByte4.length);
      paramArrayOfByte1 = new byte[24];
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte1, 0, paramArrayOfByte3.length);
      util.c(paramArrayOfByte1, 16, paramLong);
      paramArrayOfByte1 = c.cQ(paramArrayOfByte1);
      paramArrayOfByte1 = d.a(paramArrayOfByte5, paramArrayOfByte5.length, paramArrayOfByte1);
      this.CND = paramArrayOfByte1.length;
      super.Wr(this.CMD);
      super.ab(paramArrayOfByte1, this.CND);
      super.ere();
      paramArrayOfByte1 = super.era();
      AppMethodBeat.o(96497);
      return paramArrayOfByte1;
    }
    byte[] arrayOfByte = new byte[this.CND];
    util.O(arrayOfByte, 0, this.CNB);
    util.P(arrayOfByte, 2, util.erl());
    util.P(arrayOfByte, 6, this.CNC);
    util.P(arrayOfByte, 10, 522017402);
    util.P(arrayOfByte, 14, paramInt1);
    util.c(arrayOfByte, 18, paramLong);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 26, paramArrayOfByte1.length);
    paramInt1 = paramArrayOfByte1.length + 26;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramInt1, paramArrayOfByte2.length);
    paramInt1 += paramArrayOfByte2.length;
    util.N(arrayOfByte, paramInt1, 1);
    paramInt1 += 1;
    System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, paramInt1, paramArrayOfByte3.length);
    paramInt1 += paramArrayOfByte3.length;
    System.arraycopy(paramArrayOfByte4, 0, arrayOfByte, paramInt1, paramArrayOfByte4.length);
    paramInt1 += paramArrayOfByte4.length;
    util.P(arrayOfByte, paramInt1, 0);
    paramInt1 += 4;
    util.N(arrayOfByte, paramInt1, paramInt2);
    if ((paramArrayOfByte5 == null) || (paramArrayOfByte5.length <= 0))
    {
      paramArrayOfByte1 = new byte[16];
      util.P(paramArrayOfByte1, 0, util.erl());
      util.P(paramArrayOfByte1, 4, util.erl());
      util.P(paramArrayOfByte1, 8, util.erl());
      util.P(paramArrayOfByte1, 12, util.erl());
    }
    for (;;)
    {
      paramArrayOfByte1 = new byte[24];
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte1, 0, paramArrayOfByte3.length);
      util.c(paramArrayOfByte1, 16, paramLong);
      paramArrayOfByte1 = c.cQ(paramArrayOfByte1);
      paramArrayOfByte1 = d.a(arrayOfByte, arrayOfByte.length, paramArrayOfByte1);
      this.CND = paramArrayOfByte1.length;
      super.Wr(this.CMD);
      super.ab(paramArrayOfByte1, this.CND);
      super.ere();
      paramArrayOfByte1 = era();
      AppMethodBeat.o(96497);
      return paramArrayOfByte1;
      System.arraycopy(paramArrayOfByte5, 0, arrayOfByte, paramInt1 + 1, paramArrayOfByte5.length);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.h
 * JD-Core Version:    0.7.0.1
 */