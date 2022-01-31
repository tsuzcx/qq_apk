package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class r
  extends a
{
  int xru = 0;
  int xrv = 0;
  
  public r()
  {
    this.xqq = 278;
  }
  
  public final byte[] gE(int paramInt1, int paramInt2)
  {
    this.xru = 10;
    byte[] arrayOfByte = new byte[this.xru];
    util.C(arrayOfByte, 0, this.xrv);
    util.E(arrayOfByte, 1, paramInt1);
    util.E(arrayOfByte, 5, paramInt2);
    util.C(arrayOfByte, 9, 0);
    super.KP(this.xqq);
    super.aa(arrayOfByte, this.xru);
    super.cUF();
    return super.cUB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.r
 * JD-Core Version:    0.7.0.1
 */