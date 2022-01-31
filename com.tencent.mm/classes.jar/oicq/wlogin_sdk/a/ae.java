package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ae
  extends a
{
  int CNQ = 0;
  int uYN = 0;
  
  public ae()
  {
    this.CMD = 322;
  }
  
  public final byte[] cN(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(96494);
    this.CNQ = (paramArrayOfByte.length + 4);
    byte[] arrayOfByte = new byte[this.CNQ];
    util.O(arrayOfByte, 0, this.uYN);
    util.O(arrayOfByte, 2, paramArrayOfByte.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    super.Wr(this.CMD);
    super.ab(arrayOfByte, arrayOfByte.length);
    super.ere();
    paramArrayOfByte = super.era();
    AppMethodBeat.o(96494);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ae
 * JD-Core Version:    0.7.0.1
 */