package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class c
  extends a
{
  int ajHG = 1;
  int ajHH = util.ajIM;
  int ajHI = 22;
  
  public c()
  {
    this.ajGQ = 256;
  }
  
  public final byte[] D(long paramLong, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186472);
    byte[] arrayOfByte = new byte[this.ajHI];
    util.ag(arrayOfByte, 0, this.ajHG);
    util.ah(arrayOfByte, 2, this.ajHH);
    util.ah(arrayOfByte, 6, 522017402);
    util.ah(arrayOfByte, 10, 1);
    util.ah(arrayOfByte, 14, paramInt1);
    util.ah(arrayOfByte, 18, 8256);
    super.aMR(this.ajGQ);
    super.an(arrayOfByte, this.ajHI);
    super.kGk();
    arrayOfByte = super.kGg();
    AppMethodBeat.o(186472);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     oicq.wlogin_sdk.a.c
 * JD-Core Version:    0.7.0.1
 */