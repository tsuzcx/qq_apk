package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class aj
  extends a
{
  public aj()
  {
    this.LVT = 327;
  }
  
  private static int dh(byte[] paramArrayOfByte)
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
  
  public final byte[] q(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(88139);
    int j = dh(paramArrayOfByte1);
    int i = dh(paramArrayOfByte2);
    byte[] arrayOfByte = new byte[j + 6 + 2 + i];
    util.d(arrayOfByte, 0, 522017402L);
    util.V(arrayOfByte, 4, j);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 6, j);
    j += 6;
    util.V(arrayOfByte, j, i);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, j + 2, i);
    super.ajl(this.LVT);
    super.ae(arrayOfByte, arrayOfByte.length);
    super.gfx();
    paramArrayOfByte1 = super.gft();
    AppMethodBeat.o(88139);
    return paramArrayOfByte1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.aj
 * JD-Core Version:    0.7.0.1
 */