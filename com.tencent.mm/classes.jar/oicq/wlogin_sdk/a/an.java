package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class an
  extends a
{
  int ajIm = 22;
  int ajIn = 1;
  int ajIo = 1536;
  
  public an()
  {
    this.ajGQ = 24;
  }
  
  public final byte[] a(long paramLong1, int paramInt, long paramLong2)
  {
    AppMethodBeat.i(186455);
    byte[] arrayOfByte = new byte[this.ajIm];
    util.ag(arrayOfByte, 0, this.ajIn);
    util.ah(arrayOfByte, 2, this.ajIo);
    util.ah(arrayOfByte, 6, 522017402);
    util.ah(arrayOfByte, 10, paramInt);
    util.ah(arrayOfByte, 14, (int)paramLong2);
    util.ag(arrayOfByte, 18, 0);
    util.ag(arrayOfByte, 20, 0);
    super.aMR(this.ajGQ);
    super.an(arrayOfByte, this.ajIm);
    super.kGk();
    arrayOfByte = super.kGg();
    AppMethodBeat.o(186455);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     oicq.wlogin_sdk.a.an
 * JD-Core Version:    0.7.0.1
 */