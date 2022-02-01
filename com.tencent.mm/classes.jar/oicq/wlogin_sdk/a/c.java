package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class c
  extends a
{
  int NRi = 1;
  int NRj = util.NSo;
  int NRk = 22;
  
  public c()
  {
    this.NQs = 256;
  }
  
  public final byte[] alX(int paramInt)
  {
    AppMethodBeat.i(88114);
    byte[] arrayOfByte = new byte[this.NRk];
    util.W(arrayOfByte, 0, this.NRi);
    util.X(arrayOfByte, 2, this.NRj);
    util.X(arrayOfByte, 6, 522017402);
    util.X(arrayOfByte, 10, 1);
    util.X(arrayOfByte, 14, paramInt);
    util.X(arrayOfByte, 18, 8256);
    super.alW(this.NQs);
    super.af(arrayOfByte, this.NRk);
    super.gxV();
    arrayOfByte = super.gxR();
    AppMethodBeat.o(88114);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.c
 * JD-Core Version:    0.7.0.1
 */