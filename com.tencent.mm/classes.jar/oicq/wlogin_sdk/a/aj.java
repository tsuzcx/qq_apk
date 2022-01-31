package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class aj
  extends a
{
  public aj()
  {
    this.xqq = 327;
  }
  
  private static int ce(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length > 32) {
        return 32;
      }
      return paramArrayOfByte.length;
    }
    return 0;
  }
  
  public final byte[] m(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int j = ce(paramArrayOfByte1);
    int i = ce(paramArrayOfByte2);
    byte[] arrayOfByte = new byte[j + 6 + 2 + i];
    util.d(arrayOfByte, 0, 522017402L);
    util.D(arrayOfByte, 4, j);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 6, j);
    j += 6;
    util.D(arrayOfByte, j, i);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, j + 2, i);
    super.KP(this.xqq);
    super.aa(arrayOfByte, arrayOfByte.length);
    super.cUF();
    return super.cUB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.aj
 * JD-Core Version:    0.7.0.1
 */