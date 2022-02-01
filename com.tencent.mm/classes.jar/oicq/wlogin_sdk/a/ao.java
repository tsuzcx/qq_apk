package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ao
  extends a
{
  int OoX = 0;
  int OoY = 0;
  
  public ao()
  {
    this.Ony = 2;
  }
  
  public final byte[] s(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(88109);
    this.OoX = (paramArrayOfByte1.length + 6 + paramArrayOfByte2.length);
    byte[] arrayOfByte = new byte[this.OoX];
    util.X(arrayOfByte, 0, this.OoY);
    util.X(arrayOfByte, 2, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 4, paramArrayOfByte1.length);
    int i = paramArrayOfByte1.length + 4;
    util.X(arrayOfByte, i, paramArrayOfByte2.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, i + 2, paramArrayOfByte2.length);
    super.amG(this.Ony);
    super.aj(arrayOfByte, this.OoX);
    super.gCx();
    paramArrayOfByte1 = super.gCt();
    AppMethodBeat.o(88109);
    return paramArrayOfByte1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ao
 * JD-Core Version:    0.7.0.1
 */