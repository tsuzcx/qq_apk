package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class an
  extends a
{
  int NRO = 22;
  int NRP = 1;
  int NRQ = 1536;
  
  public an()
  {
    this.NQs = 24;
  }
  
  public final byte[] aZ(int paramInt, long paramLong)
  {
    AppMethodBeat.i(88143);
    byte[] arrayOfByte = new byte[this.NRO];
    util.W(arrayOfByte, 0, this.NRP);
    util.X(arrayOfByte, 2, this.NRQ);
    util.X(arrayOfByte, 6, 522017402);
    util.X(arrayOfByte, 10, paramInt);
    util.X(arrayOfByte, 14, (int)paramLong);
    util.W(arrayOfByte, 18, 0);
    util.W(arrayOfByte, 20, 0);
    super.alW(this.NQs);
    super.af(arrayOfByte, this.NRO);
    super.gxV();
    arrayOfByte = super.gxR();
    AppMethodBeat.o(88143);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.an
 * JD-Core Version:    0.7.0.1
 */