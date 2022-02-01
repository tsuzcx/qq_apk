package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class an
  extends a
{
  int KjG = 22;
  int KjH = 1;
  int KjI = 1536;
  
  public an()
  {
    this.Kik = 24;
  }
  
  public final byte[] aH(int paramInt, long paramLong)
  {
    AppMethodBeat.i(88143);
    byte[] arrayOfByte = new byte[this.KjG];
    util.W(arrayOfByte, 0, this.KjH);
    util.X(arrayOfByte, 2, this.KjI);
    util.X(arrayOfByte, 6, 522017402);
    util.X(arrayOfByte, 10, paramInt);
    util.X(arrayOfByte, 14, (int)paramLong);
    util.W(arrayOfByte, 18, 0);
    util.W(arrayOfByte, 20, 0);
    super.agp(this.Kik);
    super.af(arrayOfByte, this.KjG);
    super.fMH();
    arrayOfByte = super.fMD();
    AppMethodBeat.o(88143);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.an
 * JD-Core Version:    0.7.0.1
 */