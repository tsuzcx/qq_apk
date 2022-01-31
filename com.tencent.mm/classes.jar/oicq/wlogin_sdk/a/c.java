package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class c
  extends a
{
  int xrg = 1;
  int xrh = util.xsl;
  int xri = 22;
  
  public c()
  {
    this.xqq = 256;
  }
  
  public final byte[] KQ(int paramInt)
  {
    byte[] arrayOfByte = new byte[this.xri];
    util.D(arrayOfByte, 0, this.xrg);
    util.E(arrayOfByte, 2, this.xrh);
    util.E(arrayOfByte, 6, 522017402);
    util.E(arrayOfByte, 10, 1);
    util.E(arrayOfByte, 14, paramInt);
    util.E(arrayOfByte, 18, 8256);
    super.KP(this.xqq);
    super.aa(arrayOfByte, this.xri);
    super.cUF();
    return super.cUB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.c
 * JD-Core Version:    0.7.0.1
 */