package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class i
  extends a
{
  int CNE = 6;
  
  public i()
  {
    this.CMD = 263;
  }
  
  public final byte[] erg()
  {
    AppMethodBeat.i(96492);
    byte[] arrayOfByte = new byte[this.CNE];
    util.O(arrayOfByte, 0, 0);
    util.N(arrayOfByte, 2, 1);
    util.O(arrayOfByte, 3, 102400);
    util.N(arrayOfByte, 5, 1);
    super.Wr(this.CMD);
    super.ab(arrayOfByte, this.CNE);
    super.ere();
    arrayOfByte = super.era();
    AppMethodBeat.o(96492);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.i
 * JD-Core Version:    0.7.0.1
 */