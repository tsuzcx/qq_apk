package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class aj
  extends a
{
  public aj()
  {
    this.Ony = 327;
  }
  
  private static int dr(byte[] paramArrayOfByte)
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
  
  public final byte[] r(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(88139);
    int j = dr(paramArrayOfByte1);
    int i = dr(paramArrayOfByte2);
    byte[] arrayOfByte = new byte[j + 6 + 2 + i];
    util.d(arrayOfByte, 0, 522017402L);
    util.X(arrayOfByte, 4, j);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 6, j);
    j += 6;
    util.X(arrayOfByte, j, i);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, j + 2, i);
    super.amG(this.Ony);
    super.aj(arrayOfByte, arrayOfByte.length);
    super.gCx();
    paramArrayOfByte1 = super.gCt();
    AppMethodBeat.o(88139);
    return paramArrayOfByte1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.aj
 * JD-Core Version:    0.7.0.1
 */