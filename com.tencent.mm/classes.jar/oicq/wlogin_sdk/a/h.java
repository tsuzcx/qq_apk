package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.c;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public final class h
  extends a
{
  int Oow;
  int Oox;
  int Ooy;
  
  public h()
  {
    AppMethodBeat.i(88135);
    this.Oow = 1;
    this.Oox = 1;
    this.Ooy = 69;
    this.Ony = 262;
    this.Oox = util.Opu;
    if (util.Opu <= 2)
    {
      this.Oow = 1;
      this.Ooy = 69;
      AppMethodBeat.o(88135);
      return;
    }
    this.Oow = 2;
    this.Ooy = 90;
    AppMethodBeat.o(88135);
  }
  
  public final byte[] a(int paramInt1, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt2, byte[] paramArrayOfByte5)
  {
    AppMethodBeat.i(88136);
    if (util.Opu <= 2)
    {
      paramArrayOfByte5 = new byte[this.Ooy];
      util.X(paramArrayOfByte5, 0, this.Oow);
      util.Y(paramArrayOfByte5, 2, util.gCE());
      util.Y(paramArrayOfByte5, 6, this.Oox);
      util.Y(paramArrayOfByte5, 10, 522017402);
      util.Y(paramArrayOfByte5, 14, paramInt1);
      util.c(paramArrayOfByte5, 18, paramLong);
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte5, 26, paramArrayOfByte1.length);
      paramInt1 = paramArrayOfByte1.length + 26;
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte5, paramInt1, paramArrayOfByte2.length);
      paramInt1 += paramArrayOfByte2.length;
      util.W(paramArrayOfByte5, paramInt1, 1);
      paramInt1 += 1;
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte5, paramInt1, paramArrayOfByte3.length);
      System.arraycopy(paramArrayOfByte4, 0, paramArrayOfByte5, paramInt1 + paramArrayOfByte3.length, paramArrayOfByte4.length);
      paramArrayOfByte1 = new byte[24];
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte1, 0, paramArrayOfByte3.length);
      util.c(paramArrayOfByte1, 16, paramLong);
      paramArrayOfByte1 = c.ds(paramArrayOfByte1);
      paramArrayOfByte1 = d.a(paramArrayOfByte5, paramArrayOfByte5.length, paramArrayOfByte1);
      this.Ooy = paramArrayOfByte1.length;
      super.amG(this.Ony);
      super.aj(paramArrayOfByte1, this.Ooy);
      super.gCx();
      paramArrayOfByte1 = super.gCt();
      AppMethodBeat.o(88136);
      return paramArrayOfByte1;
    }
    byte[] arrayOfByte = new byte[this.Ooy];
    util.X(arrayOfByte, 0, this.Oow);
    util.Y(arrayOfByte, 2, util.gCE());
    util.Y(arrayOfByte, 6, this.Oox);
    util.Y(arrayOfByte, 10, 522017402);
    util.Y(arrayOfByte, 14, paramInt1);
    util.c(arrayOfByte, 18, paramLong);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 26, paramArrayOfByte1.length);
    paramInt1 = paramArrayOfByte1.length + 26;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramInt1, paramArrayOfByte2.length);
    paramInt1 += paramArrayOfByte2.length;
    util.W(arrayOfByte, paramInt1, 1);
    paramInt1 += 1;
    System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, paramInt1, paramArrayOfByte3.length);
    paramInt1 += paramArrayOfByte3.length;
    System.arraycopy(paramArrayOfByte4, 0, arrayOfByte, paramInt1, paramArrayOfByte4.length);
    paramInt1 += paramArrayOfByte4.length;
    util.Y(arrayOfByte, paramInt1, 0);
    paramInt1 += 4;
    util.W(arrayOfByte, paramInt1, paramInt2);
    if ((paramArrayOfByte5 == null) || (paramArrayOfByte5.length <= 0))
    {
      paramArrayOfByte1 = new byte[16];
      util.Y(paramArrayOfByte1, 0, util.gCE());
      util.Y(paramArrayOfByte1, 4, util.gCE());
      util.Y(paramArrayOfByte1, 8, util.gCE());
      util.Y(paramArrayOfByte1, 12, util.gCE());
    }
    for (;;)
    {
      paramArrayOfByte1 = new byte[24];
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte1, 0, paramArrayOfByte3.length);
      util.c(paramArrayOfByte1, 16, paramLong);
      paramArrayOfByte1 = c.ds(paramArrayOfByte1);
      paramArrayOfByte1 = d.a(arrayOfByte, arrayOfByte.length, paramArrayOfByte1);
      this.Ooy = paramArrayOfByte1.length;
      super.amG(this.Ony);
      super.aj(paramArrayOfByte1, this.Ooy);
      super.gCx();
      paramArrayOfByte1 = gCt();
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