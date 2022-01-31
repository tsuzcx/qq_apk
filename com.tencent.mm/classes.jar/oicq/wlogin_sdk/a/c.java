package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class c
  extends a
{
  int CNt = 1;
  int CNu = util.COy;
  int CNv = 22;
  
  public c()
  {
    this.CMD = 256;
  }
  
  public final byte[] Ws(int paramInt)
  {
    AppMethodBeat.i(96475);
    byte[] arrayOfByte = new byte[this.CNv];
    util.O(arrayOfByte, 0, this.CNt);
    util.P(arrayOfByte, 2, this.CNu);
    util.P(arrayOfByte, 6, 522017402);
    util.P(arrayOfByte, 10, 1);
    util.P(arrayOfByte, 14, paramInt);
    util.P(arrayOfByte, 18, 8256);
    super.Wr(this.CMD);
    super.ab(arrayOfByte, this.CNv);
    super.ere();
    arrayOfByte = super.era();
    AppMethodBeat.o(96475);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.c
 * JD-Core Version:    0.7.0.1
 */