package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class b
  extends a
{
  int xrb = 4;
  int xrc = 14;
  int xrd = 1;
  int xre = 20;
  byte[] xrf = new byte[2];
  
  public b()
  {
    this.xqq = 1;
  }
  
  public final Boolean cUG()
  {
    if (this.xra < 20) {
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(true);
  }
  
  public final byte[] g(long paramLong, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[this.xre];
    util.D(arrayOfByte, 0, this.xrd);
    util.E(arrayOfByte, 2, util.cUM());
    util.E(arrayOfByte, 6, (int)paramLong);
    util.d(arrayOfByte, 10, util.cUO());
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 14, paramArrayOfByte.length);
    util.D(arrayOfByte, paramArrayOfByte.length + 14, 0);
    super.KP(this.xqq);
    super.aa(arrayOfByte, this.xre);
    super.cUF();
    return super.cUB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.b
 * JD-Core Version:    0.7.0.1
 */