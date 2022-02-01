package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class r
  extends a
{
  int OoC = 0;
  int OoD = 0;
  
  public r()
  {
    this.Ony = 278;
  }
  
  public final byte[] lL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88140);
    this.OoC = 10;
    byte[] arrayOfByte = new byte[this.OoC];
    util.W(arrayOfByte, 0, this.OoD);
    util.Y(arrayOfByte, 1, paramInt1);
    util.Y(arrayOfByte, 5, paramInt2);
    util.W(arrayOfByte, 9, 0);
    super.amG(this.Ony);
    super.aj(arrayOfByte, this.OoC);
    super.gCx();
    arrayOfByte = super.gCt();
    AppMethodBeat.o(88140);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.r
 * JD-Core Version:    0.7.0.1
 */