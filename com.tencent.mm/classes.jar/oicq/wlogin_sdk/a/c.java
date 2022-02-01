package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class c
  extends a
{
  int Kja = 1;
  int Kjb = util.Kkg;
  int Kjc = 22;
  
  public c()
  {
    this.Kik = 256;
  }
  
  public final byte[] agq(int paramInt)
  {
    AppMethodBeat.i(88114);
    byte[] arrayOfByte = new byte[this.Kjc];
    util.W(arrayOfByte, 0, this.Kja);
    util.X(arrayOfByte, 2, this.Kjb);
    util.X(arrayOfByte, 6, 522017402);
    util.X(arrayOfByte, 10, 1);
    util.X(arrayOfByte, 14, paramInt);
    util.X(arrayOfByte, 18, 8256);
    super.agp(this.Kik);
    super.af(arrayOfByte, this.Kjc);
    super.fMH();
    arrayOfByte = super.fMD();
    AppMethodBeat.o(88114);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.c
 * JD-Core Version:    0.7.0.1
 */