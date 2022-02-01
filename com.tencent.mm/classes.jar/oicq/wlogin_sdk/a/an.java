package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class an
  extends a
{
  int abHi = 22;
  int abHj = 1;
  int abHk = 1536;
  
  public an()
  {
    this.abFM = 24;
  }
  
  public final byte[] a(long paramLong1, int paramInt, long paramLong2)
  {
    AppMethodBeat.i(187863);
    byte[] arrayOfByte = new byte[this.abHi];
    util.ai(arrayOfByte, 0, this.abHj);
    util.aj(arrayOfByte, 2, this.abHk);
    util.aj(arrayOfByte, 6, 522017402);
    util.aj(arrayOfByte, 10, paramInt);
    util.aj(arrayOfByte, 14, (int)paramLong2);
    util.ai(arrayOfByte, 18, 0);
    util.ai(arrayOfByte, 20, 0);
    super.aGe(this.abFM);
    super.am(arrayOfByte, this.abHi);
    super.iUJ();
    arrayOfByte = super.iUF();
    AppMethodBeat.o(187863);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     oicq.wlogin_sdk.a.an
 * JD-Core Version:    0.7.0.1
 */