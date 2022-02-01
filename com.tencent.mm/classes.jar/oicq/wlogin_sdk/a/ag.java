package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.d;
import oicq.wlogin_sdk.tools.util;

public final class ag
  extends a
{
  public int LXj = 0;
  
  public ag()
  {
    this.LVT = 324;
  }
  
  public final byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5)
  {
    AppMethodBeat.i(88113);
    int m;
    int k;
    if (paramArrayOfByte1 != null)
    {
      m = paramArrayOfByte1.length + 0;
      k = 1;
    }
    for (;;)
    {
      int i = k;
      int j = m;
      if (paramArrayOfByte2 != null)
      {
        j = m + paramArrayOfByte2.length;
        i = k + 1;
      }
      k = i;
      m = j;
      if (paramArrayOfByte3 != null)
      {
        m = j + paramArrayOfByte3.length;
        k = i + 1;
      }
      j = k;
      i = m;
      if (paramArrayOfByte4 != null)
      {
        i = m + paramArrayOfByte4.length;
        j = k + 1;
      }
      byte[] arrayOfByte = new byte[i + 2];
      util.V(arrayOfByte, 0, j);
      if (paramArrayOfByte1 != null) {
        System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 2, paramArrayOfByte1.length);
      }
      for (j = paramArrayOfByte1.length + 2;; j = 2)
      {
        i = j;
        if (paramArrayOfByte2 != null)
        {
          System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, j, paramArrayOfByte2.length);
          i = j + paramArrayOfByte2.length;
        }
        j = i;
        if (paramArrayOfByte3 != null)
        {
          System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, i, paramArrayOfByte3.length);
          j = i + paramArrayOfByte3.length;
        }
        if (paramArrayOfByte4 != null) {
          System.arraycopy(paramArrayOfByte4, 0, arrayOfByte, j, paramArrayOfByte4.length);
        }
        paramArrayOfByte1 = d.a(arrayOfByte, arrayOfByte.length, paramArrayOfByte5);
        this.LXj = paramArrayOfByte1.length;
        super.ajl(this.LVT);
        super.ae(paramArrayOfByte1, paramArrayOfByte1.length);
        super.gfx();
        paramArrayOfByte1 = super.gft();
        AppMethodBeat.o(88113);
        return paramArrayOfByte1;
      }
      k = 0;
      m = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ag
 * JD-Core Version:    0.7.0.1
 */