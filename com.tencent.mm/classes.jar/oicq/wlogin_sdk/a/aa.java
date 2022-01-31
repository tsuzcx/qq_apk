package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class aa
  extends a
{
  int xrA = 0;
  
  public aa()
  {
    this.xqq = 296;
  }
  
  private static int ab(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length > paramInt) {
        return paramInt;
      }
      return paramArrayOfByte.length;
    }
    return 0;
  }
  
  public final byte[] a(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int j = ab(paramArrayOfByte1, 32);
    int i = ab(paramArrayOfByte2, 16);
    this.xrA = (j + 11 + 2 + i + 2);
    byte[] arrayOfByte = new byte[this.xrA];
    util.D(arrayOfByte, 0, 0);
    util.C(arrayOfByte, 2, paramInt1);
    util.C(arrayOfByte, 3, paramInt2);
    util.C(arrayOfByte, 4, paramInt3);
    util.E(arrayOfByte, 5, 0);
    util.D(arrayOfByte, 9, j);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 11, j);
    paramInt1 = j + 11;
    util.D(arrayOfByte, paramInt1, i);
    paramInt1 += 2;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramInt1, i);
    util.D(arrayOfByte, paramInt1 + i, 0);
    super.KP(this.xqq);
    super.aa(arrayOfByte, this.xrA);
    super.cUF();
    return super.cUB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.aa
 * JD-Core Version:    0.7.0.1
 */