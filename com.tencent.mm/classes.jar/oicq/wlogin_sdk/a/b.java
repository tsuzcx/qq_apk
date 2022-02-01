package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class b
  extends a
{
  int KiV;
  int KiW;
  int KiX;
  int KiY;
  byte[] KiZ;
  
  public b()
  {
    AppMethodBeat.i(88137);
    this.KiV = 4;
    this.KiW = 14;
    this.KiX = 1;
    this.KiY = 20;
    this.KiZ = new byte[2];
    this.Kik = 1;
    AppMethodBeat.o(88137);
  }
  
  public final Boolean fMI()
  {
    if (this.KiU < 20) {
      return Boolean.FALSE;
    }
    return Boolean.TRUE;
  }
  
  public final byte[] g(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88138);
    byte[] arrayOfByte = new byte[this.KiY];
    util.W(arrayOfByte, 0, this.KiX);
    util.X(arrayOfByte, 2, util.fMO());
    util.X(arrayOfByte, 6, (int)paramLong);
    util.d(arrayOfByte, 10, util.fMQ());
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 14, paramArrayOfByte.length);
    util.W(arrayOfByte, paramArrayOfByte.length + 14, 0);
    super.agp(this.Kik);
    super.af(arrayOfByte, this.KiY);
    super.fMH();
    paramArrayOfByte = super.fMD();
    AppMethodBeat.o(88138);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.b
 * JD-Core Version:    0.7.0.1
 */