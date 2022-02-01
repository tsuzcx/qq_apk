package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class an
  extends a
{
  int OoU = 22;
  int OoV = 1;
  int OoW = 1536;
  
  public an()
  {
    this.Ony = 24;
  }
  
  public final byte[] ba(int paramInt, long paramLong)
  {
    AppMethodBeat.i(88143);
    byte[] arrayOfByte = new byte[this.OoU];
    util.X(arrayOfByte, 0, this.OoV);
    util.Y(arrayOfByte, 2, this.OoW);
    util.Y(arrayOfByte, 6, 522017402);
    util.Y(arrayOfByte, 10, paramInt);
    util.Y(arrayOfByte, 14, (int)paramLong);
    util.X(arrayOfByte, 18, 0);
    util.X(arrayOfByte, 20, 0);
    super.amG(this.Ony);
    super.aj(arrayOfByte, this.OoU);
    super.gCx();
    arrayOfByte = super.gCt();
    AppMethodBeat.o(88143);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.an
 * JD-Core Version:    0.7.0.1
 */