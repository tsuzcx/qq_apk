package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ae
  extends a
{
  int rjE = 0;
  int xrD = 0;
  
  public ae()
  {
    this.xqq = 322;
  }
  
  public final byte[] cc(byte[] paramArrayOfByte)
  {
    this.xrD = (paramArrayOfByte.length + 4);
    byte[] arrayOfByte = new byte[this.xrD];
    util.D(arrayOfByte, 0, this.rjE);
    util.D(arrayOfByte, 2, paramArrayOfByte.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    super.KP(this.xqq);
    super.aa(arrayOfByte, arrayOfByte.length);
    super.cUF();
    return super.cUB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ae
 * JD-Core Version:    0.7.0.1
 */