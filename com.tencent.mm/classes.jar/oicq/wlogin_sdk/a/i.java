package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class i
  extends a
{
  int Ooz = 6;
  
  public i()
  {
    this.Ony = 263;
  }
  
  public final byte[] gCz()
  {
    AppMethodBeat.i(88131);
    byte[] arrayOfByte = new byte[this.Ooz];
    util.X(arrayOfByte, 0, 0);
    util.W(arrayOfByte, 2, 1);
    util.X(arrayOfByte, 3, 102400);
    util.W(arrayOfByte, 5, 1);
    super.amG(this.Ony);
    super.aj(arrayOfByte, this.Ooz);
    super.gCx();
    arrayOfByte = super.gCt();
    AppMethodBeat.o(88131);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.i
 * JD-Core Version:    0.7.0.1
 */