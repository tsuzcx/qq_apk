package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ae
  extends a
{
  int OoL = 0;
  int OoM = 0;
  
  public ae()
  {
    this.Ony = 322;
  }
  
  public final byte[] dp(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88133);
    this.OoM = (paramArrayOfByte.length + 4);
    byte[] arrayOfByte = new byte[this.OoM];
    util.X(arrayOfByte, 0, this.OoL);
    util.X(arrayOfByte, 2, paramArrayOfByte.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    super.amG(this.Ony);
    super.aj(arrayOfByte, arrayOfByte.length);
    super.gCx();
    paramArrayOfByte = super.gCt();
    AppMethodBeat.o(88133);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ae
 * JD-Core Version:    0.7.0.1
 */