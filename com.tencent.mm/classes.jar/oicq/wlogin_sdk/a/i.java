package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class i
  extends a
{
  int ajHR = 6;
  
  public i()
  {
    this.ajGQ = 263;
  }
  
  public final byte[] kGm()
  {
    AppMethodBeat.i(88131);
    byte[] arrayOfByte = new byte[this.ajHR];
    util.ag(arrayOfByte, 0, 0);
    util.af(arrayOfByte, 2, 1);
    util.ag(arrayOfByte, 3, 102400);
    util.af(arrayOfByte, 5, 1);
    super.aMR(this.ajGQ);
    super.an(arrayOfByte, this.ajHR);
    super.kGk();
    arrayOfByte = super.kGg();
    AppMethodBeat.o(88131);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     oicq.wlogin_sdk.a.i
 * JD-Core Version:    0.7.0.1
 */