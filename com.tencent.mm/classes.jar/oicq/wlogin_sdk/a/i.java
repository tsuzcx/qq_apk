package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class i
  extends a
{
  int NRt = 6;
  
  public i()
  {
    this.NQs = 263;
  }
  
  public final byte[] gxX()
  {
    AppMethodBeat.i(88131);
    byte[] arrayOfByte = new byte[this.NRt];
    util.W(arrayOfByte, 0, 0);
    util.V(arrayOfByte, 2, 1);
    util.W(arrayOfByte, 3, 102400);
    util.V(arrayOfByte, 5, 1);
    super.alW(this.NQs);
    super.af(arrayOfByte, this.NRt);
    super.gxV();
    arrayOfByte = super.gxR();
    AppMethodBeat.o(88131);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.i
 * JD-Core Version:    0.7.0.1
 */