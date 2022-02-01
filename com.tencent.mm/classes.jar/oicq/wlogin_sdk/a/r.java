package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class r
  extends a
{
  int ajHU = 0;
  int ajHV = 0;
  
  public r()
  {
    this.ajGQ = 278;
  }
  
  public final byte[] qE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88140);
    this.ajHU = 10;
    byte[] arrayOfByte = new byte[this.ajHU];
    util.af(arrayOfByte, 0, this.ajHV);
    util.ah(arrayOfByte, 1, paramInt1);
    util.ah(arrayOfByte, 5, paramInt2);
    util.af(arrayOfByte, 9, 0);
    super.aMR(this.ajGQ);
    super.an(arrayOfByte, this.ajHU);
    super.kGk();
    arrayOfByte = super.kGg();
    AppMethodBeat.o(88140);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     oicq.wlogin_sdk.a.r
 * JD-Core Version:    0.7.0.1
 */