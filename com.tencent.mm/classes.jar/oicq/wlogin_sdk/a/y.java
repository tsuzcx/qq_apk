package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class y
  extends a
{
  int LXa = 0;
  
  public y()
  {
    this.LVT = 292;
  }
  
  private static int af(byte[] paramArrayOfByte, int paramInt)
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
    int n = af(paramArrayOfByte1, 16);
    int m = af(paramArrayOfByte2, 16);
    int k = af(paramArrayOfByte3, 16);
    int j = af(paramArrayOfByte4, 32);
    int i = af(paramArrayOfByte5, 16);
    this.LXa = (n + 2 + 2 + m + 2 + 2 + k + 2 + j + 2 + i);
    byte[] arrayOfByte = new byte[this.LXa];
    util.V(arrayOfByte, 0, n);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 2, n);
    n += 2;
    util.V(arrayOfByte, n, m);
    n += 2;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, n, m);
    m = n + m;
    util.V(arrayOfByte, m, paramInt);
    paramInt = m + 2;
    util.V(arrayOfByte, paramInt, k);
    paramInt += 2;
    System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, paramInt, k);
    paramInt += k;
    util.V(arrayOfByte, paramInt, j);
    paramInt += 2;
    System.arraycopy(paramArrayOfByte4, 0, arrayOfByte, paramInt, j);
    paramInt += j;
    util.V(arrayOfByte, paramInt, i);
    System.arraycopy(paramArrayOfByte5, 0, arrayOfByte, paramInt + 2, i);
    super.ajl(this.LVT);
    super.ae(arrayOfByte, this.LXa);
    super.gfx();
    paramArrayOfByte1 = super.gft();
    AppMethodBeat.o(88112);
    return paramArrayOfByte1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.y
 * JD-Core Version:    0.7.0.1
 */