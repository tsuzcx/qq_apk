package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class c
  extends a
{
  int abGC = 1;
  int abGD = util.abHH;
  int abGE = 22;
  
  public c()
  {
    this.abFM = 256;
  }
  
  public final byte[] u(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187797);
    byte[] arrayOfByte = new byte[this.abGE];
    util.ai(arrayOfByte, 0, this.abGC);
    util.aj(arrayOfByte, 2, this.abGD);
    util.aj(arrayOfByte, 6, 522017402);
    util.aj(arrayOfByte, 10, 1);
    util.aj(arrayOfByte, 14, paramInt1);
    util.aj(arrayOfByte, 18, 8256);
    super.aGe(this.abFM);
    super.am(arrayOfByte, this.abGE);
    super.iUJ();
    arrayOfByte = super.iUF();
    AppMethodBeat.o(187797);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     oicq.wlogin_sdk.a.c
 * JD-Core Version:    0.7.0.1
 */