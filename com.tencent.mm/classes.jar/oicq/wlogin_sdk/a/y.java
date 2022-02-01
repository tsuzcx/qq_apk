package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class y
  extends a
{
  int UdE = 0;
  
  public y()
  {
    this.Ucx = 292;
  }
  
  private static int al(byte[] paramArrayOfByte, int paramInt)
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
    AppMethodBeat.i(88112);
    int n = al(paramArrayOfByte1, 16);
    int m = al(paramArrayOfByte2, 16);
    int k = al(paramArrayOfByte3, 16);
    int j = al(paramArrayOfByte4, 32);
    int i = al(paramArrayOfByte5, 16);
    this.UdE = (n + 2 + 2 + m + 2 + 2 + k + 2 + j + 2 + i);
    byte[] arrayOfByte = new byte[this.UdE];
    util.ah(arrayOfByte, 0, n);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 2, n);
    n += 2;
    util.ah(arrayOfByte, n, m);
    n += 2;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, n, m);
    m = n + m;
    util.ah(arrayOfByte, m, paramInt);
    paramInt = m + 2;
    util.ah(arrayOfByte, paramInt, k);
    paramInt += 2;
    System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, paramInt, k);
    paramInt += k;
    util.ah(arrayOfByte, paramInt, j);
    paramInt += 2;
    System.arraycopy(paramArrayOfByte4, 0, arrayOfByte, paramInt, j);
    paramInt += j;
    util.ah(arrayOfByte, paramInt, i);
    System.arraycopy(paramArrayOfByte5, 0, arrayOfByte, paramInt + 2, i);
    super.awj(this.Ucx);
    super.ak(arrayOfByte, this.UdE);
    super.hPB();
    paramArrayOfByte1 = super.hPx();
    AppMethodBeat.o(88112);
    return paramArrayOfByte1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.y
 * JD-Core Version:    0.7.0.1
 */