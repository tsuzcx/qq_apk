package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class y
  extends a
{
  int xrx = 0;
  
  public y()
  {
    this.xqq = 292;
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
  
  public final byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5)
  {
    int n = ab(paramArrayOfByte1, 16);
    int m = ab(paramArrayOfByte2, 16);
    int k = ab(paramArrayOfByte3, 16);
    int j = ab(paramArrayOfByte4, 32);
    int i = ab(paramArrayOfByte5, 16);
    this.xrx = (n + 2 + 2 + m + 2 + 2 + k + 2 + j + 2 + i);
    byte[] arrayOfByte = new byte[this.xrx];
    util.D(arrayOfByte, 0, n);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 2, n);
    n += 2;
    util.D(arrayOfByte, n, m);
    n += 2;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, n, m);
    m = n + m;
    util.D(arrayOfByte, m, paramInt);
    paramInt = m + 2;
    util.D(arrayOfByte, paramInt, k);
    paramInt += 2;
    System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, paramInt, k);
    paramInt += k;
    util.D(arrayOfByte, paramInt, j);
    paramInt += 2;
    System.arraycopy(paramArrayOfByte4, 0, arrayOfByte, paramInt, j);
    paramInt += j;
    util.D(arrayOfByte, paramInt, i);
    System.arraycopy(paramArrayOfByte5, 0, arrayOfByte, paramInt + 2, i);
    super.KP(this.xqq);
    super.aa(arrayOfByte, this.xrx);
    super.cUF();
    return super.cUB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.y
 * JD-Core Version:    0.7.0.1
 */