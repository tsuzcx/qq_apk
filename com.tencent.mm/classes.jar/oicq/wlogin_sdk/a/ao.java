package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ao
  extends a
{
  int xrO = 0;
  int xrP = 0;
  
  public ao()
  {
    this.xqq = 2;
  }
  
  public final byte[] n(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.xrO = (paramArrayOfByte1.length + 6 + paramArrayOfByte2.length);
    byte[] arrayOfByte = new byte[this.xrO];
    util.D(arrayOfByte, 0, this.xrP);
    util.D(arrayOfByte, 2, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 4, paramArrayOfByte1.length);
    int i = paramArrayOfByte1.length + 4;
    util.D(arrayOfByte, i, paramArrayOfByte2.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, i + 2, paramArrayOfByte2.length);
    super.KP(this.xqq);
    super.aa(arrayOfByte, this.xrO);
    super.cUF();
    return super.cUB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ao
 * JD-Core Version:    0.7.0.1
 */