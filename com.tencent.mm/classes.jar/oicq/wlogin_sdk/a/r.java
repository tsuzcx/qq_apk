package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class r
  extends a
{
  int LWX = 0;
  int LWY = 0;
  
  public r()
  {
    this.LVT = 278;
  }
  
  public final byte[] lp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88140);
    this.LWX = 10;
    byte[] arrayOfByte = new byte[this.LWX];
    util.U(arrayOfByte, 0, this.LWY);
    util.W(arrayOfByte, 1, paramInt1);
    util.W(arrayOfByte, 5, paramInt2);
    util.U(arrayOfByte, 9, 0);
    super.ajl(this.LVT);
    super.ae(arrayOfByte, this.LWX);
    super.gfx();
    arrayOfByte = super.gft();
    AppMethodBeat.o(88140);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.r
 * JD-Core Version:    0.7.0.1
 */