package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.c;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public final class h
  extends a
{
  int Kji;
  int Kjj;
  int Kjk;
  
  public h()
  {
    AppMethodBeat.i(88135);
    this.Kji = 1;
    this.Kjj = 1;
    this.Kjk = 69;
    this.Kik = 262;
    this.Kjj = util.Kkg;
    if (util.Kkg <= 2)
    {
      this.Kji = 1;
      this.Kjk = 69;
      AppMethodBeat.o(88135);
      return;
    }
    this.Kji = 2;
    this.Kjk = 90;
    AppMethodBeat.o(88135);
  }
  
  public final byte[] a(int paramInt1, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt2, byte[] paramArrayOfByte5)
  {
    AppMethodBeat.i(88136);
    if (util.Kkg <= 2)
    {
      paramArrayOfByte5 = new byte[this.Kjk];
      util.W(paramArrayOfByte5, 0, this.Kji);
      util.X(paramArrayOfByte5, 2, util.fMO());
      util.X(paramArrayOfByte5, 6, this.Kjj);
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
      paramArrayOfByte1 = c.di(paramArrayOfByte1);
      paramArrayOfByte1 = d.a(paramArrayOfByte5, paramArrayOfByte5.length, paramArrayOfByte1);
      this.Kjk = paramArrayOfByte1.length;
      super.agp(this.Kik);
      super.af(paramArrayOfByte1, this.Kjk);
      super.fMH();
      paramArrayOfByte1 = super.fMD();
      AppMethodBeat.o(88136);
      return paramArrayOfByte1;
    }
    byte[] arrayOfByte = new byte[this.Kjk];
    util.W(arrayOfByte, 0, this.Kji);
    util.X(arrayOfByte, 2, util.fMO());
    util.X(arrayOfByte, 6, this.Kjj);
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
      util.X(paramArrayOfByte1, 0, util.fMO());
      util.X(paramArrayOfByte1, 4, util.fMO());
      util.X(paramArrayOfByte1, 8, util.fMO());
      util.X(paramArrayOfByte1, 12, util.fMO());
    }
    for (;;)
    {
      paramArrayOfByte1 = new byte[24];
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte1, 0, paramArrayOfByte3.length);
      util.c(paramArrayOfByte1, 16, paramLong);
      paramArrayOfByte1 = c.di(paramArrayOfByte1);
      paramArrayOfByte1 = d.a(arrayOfByte, arrayOfByte.length, paramArrayOfByte1);
      this.Kjk = paramArrayOfByte1.length;
      super.agp(this.Kik);
      super.af(paramArrayOfByte1, this.Kjk);
      super.fMH();
      paramArrayOfByte1 = fMD();
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