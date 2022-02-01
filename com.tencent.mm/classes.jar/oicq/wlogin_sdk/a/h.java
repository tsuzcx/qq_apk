package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.c;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public final class h
  extends a
{
  int Udv;
  int Udw;
  int Udx;
  
  public h()
  {
    AppMethodBeat.i(88135);
    this.Udv = 1;
    this.Udw = 1;
    this.Udx = 69;
    this.Ucx = 262;
    this.Udw = util.Ues;
    if (util.Ues <= 2)
    {
      this.Udv = 1;
      this.Udx = 69;
      AppMethodBeat.o(88135);
      return;
    }
    this.Udv = 2;
    this.Udx = 90;
    AppMethodBeat.o(88135);
  }
  
  public final byte[] a(long paramLong1, int paramInt1, long paramLong2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt2, byte[] paramArrayOfByte5)
  {
    AppMethodBeat.i(209829);
    if (util.Ues <= 2)
    {
      paramArrayOfByte5 = new byte[this.Udx];
      util.ah(paramArrayOfByte5, 0, this.Udv);
      util.ai(paramArrayOfByte5, 2, util.hPI());
      util.ai(paramArrayOfByte5, 6, this.Udw);
      util.ai(paramArrayOfByte5, 10, 522017402);
      util.ai(paramArrayOfByte5, 14, paramInt1);
      util.c(paramArrayOfByte5, 18, paramLong2);
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte5, 26, paramArrayOfByte1.length);
      paramInt1 = paramArrayOfByte1.length + 26;
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte5, paramInt1, paramArrayOfByte2.length);
      paramInt1 += paramArrayOfByte2.length;
      util.ag(paramArrayOfByte5, paramInt1, 1);
      paramInt1 += 1;
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte5, paramInt1, paramArrayOfByte3.length);
      System.arraycopy(paramArrayOfByte4, 0, paramArrayOfByte5, paramInt1 + paramArrayOfByte3.length, paramArrayOfByte4.length);
      paramArrayOfByte1 = new byte[24];
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte1, 0, paramArrayOfByte3.length);
      util.c(paramArrayOfByte1, 16, paramLong2);
      paramArrayOfByte1 = c.du(paramArrayOfByte1);
      paramArrayOfByte1 = d.a(paramArrayOfByte5, paramArrayOfByte5.length, paramArrayOfByte1);
      this.Udx = paramArrayOfByte1.length;
      super.awj(this.Ucx);
      super.ak(paramArrayOfByte1, this.Udx);
      super.hPB();
      paramArrayOfByte1 = super.hPx();
      AppMethodBeat.o(209829);
      return paramArrayOfByte1;
    }
    byte[] arrayOfByte = new byte[this.Udx];
    util.ah(arrayOfByte, 0, this.Udv);
    util.ai(arrayOfByte, 2, util.hPI());
    util.ai(arrayOfByte, 6, this.Udw);
    util.ai(arrayOfByte, 10, 522017402);
    util.ai(arrayOfByte, 14, paramInt1);
    util.c(arrayOfByte, 18, paramLong2);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 26, paramArrayOfByte1.length);
    paramInt1 = paramArrayOfByte1.length + 26;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramInt1, paramArrayOfByte2.length);
    paramInt1 += paramArrayOfByte2.length;
    util.ag(arrayOfByte, paramInt1, 1);
    paramInt1 += 1;
    System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, paramInt1, paramArrayOfByte3.length);
    paramInt1 += paramArrayOfByte3.length;
    System.arraycopy(paramArrayOfByte4, 0, arrayOfByte, paramInt1, paramArrayOfByte4.length);
    paramInt1 += paramArrayOfByte4.length;
    util.ai(arrayOfByte, paramInt1, 0);
    paramInt1 += 4;
    util.ag(arrayOfByte, paramInt1, paramInt2);
    if ((paramArrayOfByte5 == null) || (paramArrayOfByte5.length <= 0))
    {
      paramArrayOfByte1 = new byte[16];
      util.ai(paramArrayOfByte1, 0, util.hPI());
      util.ai(paramArrayOfByte1, 4, util.hPI());
      util.ai(paramArrayOfByte1, 8, util.hPI());
      util.ai(paramArrayOfByte1, 12, util.hPI());
    }
    for (;;)
    {
      paramArrayOfByte1 = new byte[24];
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte1, 0, paramArrayOfByte3.length);
      util.c(paramArrayOfByte1, 16, paramLong2);
      paramArrayOfByte1 = c.du(paramArrayOfByte1);
      paramArrayOfByte1 = d.a(arrayOfByte, arrayOfByte.length, paramArrayOfByte1);
      this.Udx = paramArrayOfByte1.length;
      super.awj(this.Ucx);
      super.ak(paramArrayOfByte1, this.Udx);
      super.hPB();
      paramArrayOfByte1 = hPx();
      AppMethodBeat.o(209829);
      return paramArrayOfByte1;
      System.arraycopy(paramArrayOfByte5, 0, arrayOfByte, paramInt1 + 1, paramArrayOfByte5.length);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.h
 * JD-Core Version:    0.7.0.1
 */