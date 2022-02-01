package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class b
  extends a
{
  int ajHB;
  int ajHC;
  int ajHD;
  int ajHE;
  byte[] ajHF;
  
  public b()
  {
    AppMethodBeat.i(88137);
    this.ajHB = 4;
    this.ajHC = 14;
    this.ajHD = 1;
    this.ajHE = 20;
    this.ajHF = new byte[2];
    this.ajGQ = 1;
    AppMethodBeat.o(88137);
  }
  
  public final byte[] h(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88138);
    byte[] arrayOfByte = new byte[this.ajHE];
    util.ag(arrayOfByte, 0, this.ajHD);
    util.ah(arrayOfByte, 2, util.kGr());
    util.ah(arrayOfByte, 6, (int)paramLong);
    util.d(arrayOfByte, 10, util.kGt());
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 14, paramArrayOfByte.length);
    util.ag(arrayOfByte, paramArrayOfByte.length + 14, 0);
    super.aMR(this.ajGQ);
    super.an(arrayOfByte, this.ajHE);
    super.kGk();
    paramArrayOfByte = super.kGg();
    AppMethodBeat.o(88138);
    return paramArrayOfByte;
  }
  
  public final Boolean kGl()
  {
    if (this.ajHA < 20) {
      return Boolean.FALSE;
    }
    return Boolean.TRUE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     oicq.wlogin_sdk.a.b
 * JD-Core Version:    0.7.0.1
 */