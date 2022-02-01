package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class i
  extends a
{
  int Udy = 6;
  
  public i()
  {
    this.Ucx = 263;
  }
  
  public final byte[] hPD()
  {
    AppMethodBeat.i(88131);
    byte[] arrayOfByte = new byte[this.Udy];
    util.ah(arrayOfByte, 0, 0);
    util.ag(arrayOfByte, 2, 1);
    util.ah(arrayOfByte, 3, 102400);
    util.ag(arrayOfByte, 5, 1);
    super.awj(this.Ucx);
    super.ak(arrayOfByte, this.Udy);
    super.hPB();
    arrayOfByte = super.hPx();
    AppMethodBeat.o(88131);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.i
 * JD-Core Version:    0.7.0.1
 */