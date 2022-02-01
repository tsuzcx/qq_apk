package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class c
  extends a
{
  int Udn = 1;
  int Udo = util.Ues;
  int Udp = 22;
  
  public c()
  {
    this.Ucx = 256;
  }
  
  public final byte[] t(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209828);
    byte[] arrayOfByte = new byte[this.Udp];
    util.ah(arrayOfByte, 0, this.Udn);
    util.ai(arrayOfByte, 2, this.Udo);
    util.ai(arrayOfByte, 6, 522017402);
    util.ai(arrayOfByte, 10, 1);
    util.ai(arrayOfByte, 14, paramInt1);
    util.ai(arrayOfByte, 18, 8256);
    super.awj(this.Ucx);
    super.ak(arrayOfByte, this.Udp);
    super.hPB();
    arrayOfByte = super.hPx();
    AppMethodBeat.o(209828);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.c
 * JD-Core Version:    0.7.0.1
 */