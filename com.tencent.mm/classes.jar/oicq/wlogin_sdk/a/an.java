package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class an
  extends a
{
  int CNY = 22;
  int CNZ = 1;
  int COa = 1536;
  
  public an()
  {
    this.CMD = 24;
  }
  
  public final byte[] an(int paramInt, long paramLong)
  {
    AppMethodBeat.i(96504);
    byte[] arrayOfByte = new byte[this.CNY];
    util.O(arrayOfByte, 0, this.CNZ);
    util.P(arrayOfByte, 2, this.COa);
    util.P(arrayOfByte, 6, 522017402);
    util.P(arrayOfByte, 10, paramInt);
    util.P(arrayOfByte, 14, (int)paramLong);
    util.O(arrayOfByte, 18, 0);
    util.O(arrayOfByte, 20, 0);
    super.Wr(this.CMD);
    super.ab(arrayOfByte, this.CNY);
    super.ere();
    arrayOfByte = super.era();
    AppMethodBeat.o(96504);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.an
 * JD-Core Version:    0.7.0.1
 */