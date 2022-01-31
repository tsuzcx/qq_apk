package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class r
  extends a
{
  int CNH = 0;
  int CNI = 0;
  
  public r()
  {
    this.CMD = 278;
  }
  
  public final byte[] iS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(96501);
    this.CNH = 10;
    byte[] arrayOfByte = new byte[this.CNH];
    util.N(arrayOfByte, 0, this.CNI);
    util.P(arrayOfByte, 1, paramInt1);
    util.P(arrayOfByte, 5, paramInt2);
    util.N(arrayOfByte, 9, 0);
    super.Wr(this.CMD);
    super.ab(arrayOfByte, this.CNH);
    super.ere();
    arrayOfByte = super.era();
    AppMethodBeat.o(96501);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.r
 * JD-Core Version:    0.7.0.1
 */