package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class r
  extends a
{
  int Kjo = 0;
  int Kjp = 0;
  
  public r()
  {
    this.Kik = 278;
  }
  
  public final byte[] kZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(88140);
    this.Kjo = 10;
    byte[] arrayOfByte = new byte[this.Kjo];
    util.V(arrayOfByte, 0, this.Kjp);
    util.X(arrayOfByte, 1, paramInt1);
    util.X(arrayOfByte, 5, paramInt2);
    util.V(arrayOfByte, 9, 0);
    super.agp(this.Kik);
    super.af(arrayOfByte, this.Kjo);
    super.fMH();
    arrayOfByte = super.fMD();
    AppMethodBeat.o(88140);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.r
 * JD-Core Version:    0.7.0.1
 */