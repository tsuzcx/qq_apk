package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class an
  extends a
{
  int UdT = 22;
  int UdU = 1;
  int UdV = 1536;
  
  public an()
  {
    this.Ucx = 24;
  }
  
  public final byte[] a(long paramLong1, int paramInt, long paramLong2)
  {
    AppMethodBeat.i(209831);
    byte[] arrayOfByte = new byte[this.UdT];
    util.ah(arrayOfByte, 0, this.UdU);
    util.ai(arrayOfByte, 2, this.UdV);
    util.ai(arrayOfByte, 6, 522017402);
    util.ai(arrayOfByte, 10, paramInt);
    util.ai(arrayOfByte, 14, (int)paramLong2);
    util.ah(arrayOfByte, 18, 0);
    util.ah(arrayOfByte, 20, 0);
    super.awj(this.Ucx);
    super.ak(arrayOfByte, this.UdT);
    super.hPB();
    arrayOfByte = super.hPx();
    AppMethodBeat.o(209831);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.an
 * JD-Core Version:    0.7.0.1
 */