package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.c;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public final class h
  extends a
{
  int LWR;
  int LWS;
  int LWT;
  
  public h()
  {
    AppMethodBeat.i(88135);
    this.LWR = 1;
    this.LWS = 1;
    this.LWT = 69;
    this.LVT = 262;
    this.LWS = util.LXP;
    if (util.LXP <= 2)
    {
      this.LWR = 1;
      this.LWT = 69;
      AppMethodBeat.o(88135);
      return;
    }
    this.LWR = 2;
    this.LWT = 90;
    AppMethodBeat.o(88135);
  }
  
  public final byte[] a(int paramInt1, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt2, byte[] paramArrayOfByte5)
  {
    AppMethodBeat.i(88136);
    if (util.LXP <= 2)
    {
      paramArrayOfByte5 = new byte[this.LWT];
      util.V(paramArrayOfByte5, 0, this.LWR);
      util.W(paramArrayOfByte5, 2, util.gfE());
      util.W(paramArrayOfByte5, 6, this.LWS);
      util.W(paramArrayOfByte5, 10, 522017402);
      util.W(paramArrayOfByte5, 14, paramInt1);
      util.c(paramArrayOfByte5, 18, paramLong);
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte5, 26, paramArrayOfByte1.length);
      paramInt1 = paramArrayOfByte1.length + 26;
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte5, paramInt1, paramArrayOfByte2.length);
      paramInt1 += paramArrayOfByte2.length;
      util.U(paramArrayOfByte5, paramInt1, 1);
      paramInt1 += 1;
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte5, paramInt1, paramArrayOfByte3.length);
      System.arraycopy(paramArrayOfByte4, 0, paramArrayOfByte5, paramInt1 + paramArrayOfByte3.length, paramArrayOfByte4.length);
      paramArrayOfByte1 = new byte[24];
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte1, 0, paramArrayOfByte3.length);
      util.c(paramArrayOfByte1, 16, paramLong);
      paramArrayOfByte1 = c.di(paramArrayOfByte1);
      paramArrayOfByte1 = d.a(paramArrayOfByte5, paramArrayOfByte5.length, paramArrayOfByte1);
      this.LWT = paramArrayOfByte1.length;
      super.ajl(this.LVT);
      super.ae(paramArrayOfByte1, this.LWT);
      super.gfx();
      paramArrayOfByte1 = super.gft();
      AppMethodBeat.o(88136);
      return paramArrayOfByte1;
    }
    byte[] arrayOfByte = new byte[this.LWT];
    util.V(arrayOfByte, 0, this.LWR);
    util.W(arrayOfByte, 2, util.gfE());
    util.W(arrayOfByte, 6, this.LWS);
    util.W(arrayOfByte, 10, 522017402);
    util.W(arrayOfByte, 14, paramInt1);
    util.c(arrayOfByte, 18, paramLong);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 26, paramArrayOfByte1.length);
    paramInt1 = paramArrayOfByte1.length + 26;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramInt1, paramArrayOfByte2.length);
    paramInt1 += paramArrayOfByte2.length;
    util.U(arrayOfByte, paramInt1, 1);
    paramInt1 += 1;
    System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, paramInt1, paramArrayOfByte3.length);
    paramInt1 += paramArrayOfByte3.length;
    System.arraycopy(paramArrayOfByte4, 0, arrayOfByte, paramInt1, paramArrayOfByte4.length);
    paramInt1 += paramArrayOfByte4.length;
    util.W(arrayOfByte, paramInt1, 0);
    paramInt1 += 4;
    util.U(arrayOfByte, paramInt1, paramInt2);
    if ((paramArrayOfByte5 == null) || (paramArrayOfByte5.length <= 0))
    {
      paramArrayOfByte1 = new byte[16];
      util.W(paramArrayOfByte1, 0, util.gfE());
      util.W(paramArrayOfByte1, 4, util.gfE());
      util.W(paramArrayOfByte1, 8, util.gfE());
      util.W(paramArrayOfByte1, 12, util.gfE());
    }
    for (;;)
    {
      paramArrayOfByte1 = new byte[24];
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte1, 0, paramArrayOfByte3.length);
      util.c(paramArrayOfByte1, 16, paramLong);
      paramArrayOfByte1 = c.di(paramArrayOfByte1);
      paramArrayOfByte1 = d.a(arrayOfByte, arrayOfByte.length, paramArrayOfByte1);
      this.LWT = paramArrayOfByte1.length;
      super.ajl(this.LVT);
      super.ae(paramArrayOfByte1, this.LWT);
      super.gfx();
      paramArrayOfByte1 = gft();
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