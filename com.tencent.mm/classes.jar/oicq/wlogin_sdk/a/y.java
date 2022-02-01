package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class y
  extends a
{
  int OoF = 0;
  
  public y()
  {
    this.Ony = 292;
  }
  
  private static int ak(byte[] paramArrayOfByte, int paramInt)
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
    int n = ak(paramArrayOfByte1, 16);
    int m = ak(paramArrayOfByte2, 16);
    int k = ak(paramArrayOfByte3, 16);
    int j = ak(paramArrayOfByte4, 32);
    int i = ak(paramArrayOfByte5, 16);
    this.OoF = (n + 2 + 2 + m + 2 + 2 + k + 2 + j + 2 + i);
    byte[] arrayOfByte = new byte[this.OoF];
    util.X(arrayOfByte, 0, n);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 2, n);
    n += 2;
    util.X(arrayOfByte, n, m);
    n += 2;
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, n, m);
    m = n + m;
    util.X(arrayOfByte, m, paramInt);
    paramInt = m + 2;
    util.X(arrayOfByte, paramInt, k);
    paramInt += 2;
    System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, paramInt, k);
    paramInt += k;
    util.X(arrayOfByte, paramInt, j);
    paramInt += 2;
    System.arraycopy(paramArrayOfByte4, 0, arrayOfByte, paramInt, j);
    paramInt += j;
    util.X(arrayOfByte, paramInt, i);
    System.arraycopy(paramArrayOfByte5, 0, arrayOfByte, paramInt + 2, i);
    super.amG(this.Ony);
    super.aj(arrayOfByte, this.OoF);
    super.gCx();
    paramArrayOfByte1 = super.gCt();
    AppMethodBeat.o(88112);
    return paramArrayOfByte1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.y
 * JD-Core Version:    0.7.0.1
 */