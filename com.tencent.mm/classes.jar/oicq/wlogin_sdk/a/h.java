package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.c;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public final class h
  extends a
{
  int xro = 1;
  int xrp = 1;
  int xrq = 69;
  
  public h()
  {
    this.xqq = 262;
    if (util.xsl <= 2)
    {
      this.xro = 1;
      this.xrq = 69;
      return;
    }
    this.xro = 2;
    this.xrq = 90;
  }
  
  public final byte[] a(int paramInt1, long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt2, byte[] paramArrayOfByte5)
  {
    if (util.xsl <= 2)
    {
      paramArrayOfByte5 = new byte[this.xrq];
      util.D(paramArrayOfByte5, 0, this.xro);
      util.E(paramArrayOfByte5, 2, util.cUM());
      util.E(paramArrayOfByte5, 6, this.xrp);
      util.E(paramArrayOfByte5, 10, 522017402);
      util.E(paramArrayOfByte5, 14, paramInt1);
      util.c(paramArrayOfByte5, 18, paramLong);
      System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte5, 26, paramArrayOfByte1.length);
      paramInt1 = paramArrayOfByte1.length + 26;
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte5, paramInt1, paramArrayOfByte2.length);
      paramInt1 += paramArrayOfByte2.length;
      util.C(paramArrayOfByte5, paramInt1, 1);
      paramInt1 += 1;
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte5, paramInt1, paramArrayOfByte3.length);
      System.arraycopy(paramArrayOfByte4, 0, paramArrayOfByte5, paramInt1 + paramArrayOfByte3.length, paramArrayOfByte4.length);
      paramArrayOfByte1 = new byte[24];
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte1, 0, paramArrayOfByte3.length);
      util.c(paramArrayOfByte1, 16, paramLong);
      paramArrayOfByte1 = c.cf(paramArrayOfByte1);
      paramArrayOfByte1 = d.a(paramArrayOfByte5, paramArrayOfByte5.length, paramArrayOfByte1);
      this.xrq = paramArrayOfByte1.length;
      super.KP(this.xqq);
      super.aa(paramArrayOfByte1, this.xrq);
      super.cUF();
      return super.cUB();
    }
    byte[] arrayOfByte = new byte[this.xrq];
    util.D(arrayOfByte, 0, this.xro);
    util.E(arrayOfByte, 2, util.cUM());
    util.E(arrayOfByte, 6, this.xrp);
    util.E(arrayOfByte, 10, 522017402);
    util.E(arrayOfByte, 14, paramInt1);
    util.c(arrayOfByte, 18, paramLong);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 26, paramArrayOfByte1.length);
    paramInt1 = paramArrayOfByte1.length + 26;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramInt1, paramArrayOfByte2.length);
    paramInt1 += paramArrayOfByte2.length;
    util.C(arrayOfByte, paramInt1, 1);
    paramInt1 += 1;
    System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, paramInt1, paramArrayOfByte3.length);
    paramInt1 += paramArrayOfByte3.length;
    System.arraycopy(paramArrayOfByte4, 0, arrayOfByte, paramInt1, paramArrayOfByte4.length);
    paramInt1 += paramArrayOfByte4.length;
    util.E(arrayOfByte, paramInt1, 0);
    paramInt1 += 4;
    util.C(arrayOfByte, paramInt1, paramInt2);
    if ((paramArrayOfByte5 == null) || (paramArrayOfByte5.length <= 0))
    {
      paramArrayOfByte1 = new byte[16];
      util.E(paramArrayOfByte1, 0, util.cUM());
      util.E(paramArrayOfByte1, 4, util.cUM());
      util.E(paramArrayOfByte1, 8, util.cUM());
      util.E(paramArrayOfByte1, 12, util.cUM());
    }
    for (;;)
    {
      paramArrayOfByte1 = new byte[24];
      System.arraycopy(paramArrayOfByte3, 0, paramArrayOfByte1, 0, paramArrayOfByte3.length);
      util.c(paramArrayOfByte1, 16, paramLong);
      paramArrayOfByte1 = c.cf(paramArrayOfByte1);
      paramArrayOfByte1 = d.a(arrayOfByte, arrayOfByte.length, paramArrayOfByte1);
      this.xrq = paramArrayOfByte1.length;
      super.KP(this.xqq);
      super.aa(paramArrayOfByte1, this.xrq);
      super.cUF();
      return cUB();
      System.arraycopy(paramArrayOfByte5, 0, arrayOfByte, paramInt1 + 1, paramArrayOfByte5.length);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.h
 * JD-Core Version:    0.7.0.1
 */