package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class b
  extends a
{
  int NRd;
  int NRe;
  int NRf;
  int NRg;
  byte[] NRh;
  
  public b()
  {
    AppMethodBeat.i(88137);
    this.NRd = 4;
    this.NRe = 14;
    this.NRf = 1;
    this.NRg = 20;
    this.NRh = new byte[2];
    this.NQs = 1;
    AppMethodBeat.o(88137);
  }
  
  public final Boolean gxW()
  {
    if (this.NRc < 20) {
      return Boolean.FALSE;
    }
    return Boolean.TRUE;
  }
  
  public final byte[] h(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88138);
    byte[] arrayOfByte = new byte[this.NRg];
    util.W(arrayOfByte, 0, this.NRf);
    util.X(arrayOfByte, 2, util.gyc());
    util.X(arrayOfByte, 6, (int)paramLong);
    util.d(arrayOfByte, 10, util.gye());
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 14, paramArrayOfByte.length);
    util.W(arrayOfByte, paramArrayOfByte.length + 14, 0);
    super.alW(this.NQs);
    super.af(arrayOfByte, this.NRg);
    super.gxV();
    paramArrayOfByte = super.gxR();
    AppMethodBeat.o(88138);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.b
 * JD-Core Version:    0.7.0.1
 */