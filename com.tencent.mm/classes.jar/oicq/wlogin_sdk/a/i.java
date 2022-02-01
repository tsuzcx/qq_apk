package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class i
  extends a
{
  int LWU = 6;
  
  public i()
  {
    this.LVT = 263;
  }
  
  public final byte[] gfz()
  {
    AppMethodBeat.i(88131);
    byte[] arrayOfByte = new byte[this.LWU];
    util.V(arrayOfByte, 0, 0);
    util.U(arrayOfByte, 2, 1);
    util.V(arrayOfByte, 3, 102400);
    util.U(arrayOfByte, 5, 1);
    super.ajl(this.LVT);
    super.ae(arrayOfByte, this.LWU);
    super.gfx();
    arrayOfByte = super.gft();
    AppMethodBeat.o(88131);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.i
 * JD-Core Version:    0.7.0.1
 */