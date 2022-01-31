package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class an
  extends a
{
  int xrL = 22;
  int xrM = 1;
  int xrN = 1536;
  
  public an()
  {
    this.xqq = 24;
  }
  
  public final byte[] Z(int paramInt, long paramLong)
  {
    byte[] arrayOfByte = new byte[this.xrL];
    util.D(arrayOfByte, 0, this.xrM);
    util.E(arrayOfByte, 2, this.xrN);
    util.E(arrayOfByte, 6, 522017402);
    util.E(arrayOfByte, 10, paramInt);
    util.E(arrayOfByte, 14, (int)paramLong);
    util.D(arrayOfByte, 18, 0);
    util.D(arrayOfByte, 20, 0);
    super.KP(this.xqq);
    super.aa(arrayOfByte, this.xrL);
    super.cUF();
    return super.cUB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.an
 * JD-Core Version:    0.7.0.1
 */