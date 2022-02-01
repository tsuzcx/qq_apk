package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class r
  extends a
{
  int NRw = 0;
  int NRx = 0;
  
  public r()
  {
    this.NQs = 278;
  }
  
  public final byte[] lE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88140);
    this.NRw = 10;
    byte[] arrayOfByte = new byte[this.NRw];
    util.V(arrayOfByte, 0, this.NRx);
    util.X(arrayOfByte, 1, paramInt1);
    util.X(arrayOfByte, 5, paramInt2);
    util.V(arrayOfByte, 9, 0);
    super.alW(this.NQs);
    super.af(arrayOfByte, this.NRw);
    super.gxV();
    arrayOfByte = super.gxR();
    AppMethodBeat.o(88140);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.r
 * JD-Core Version:    0.7.0.1
 */