package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class c
  extends a
{
  int Ooo = 1;
  int Oop = util.Opu;
  int Ooq = 22;
  
  public c()
  {
    this.Ony = 256;
  }
  
  public final byte[] amH(int paramInt)
  {
    AppMethodBeat.i(88114);
    byte[] arrayOfByte = new byte[this.Ooq];
    util.X(arrayOfByte, 0, this.Ooo);
    util.Y(arrayOfByte, 2, this.Oop);
    util.Y(arrayOfByte, 6, 522017402);
    util.Y(arrayOfByte, 10, 1);
    util.Y(arrayOfByte, 14, paramInt);
    util.Y(arrayOfByte, 18, 8256);
    super.amG(this.Ony);
    super.aj(arrayOfByte, this.Ooq);
    super.gCx();
    arrayOfByte = super.gCt();
    AppMethodBeat.o(88114);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.c
 * JD-Core Version:    0.7.0.1
 */