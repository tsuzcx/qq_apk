package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class b
  extends a
{
  int CNo;
  int CNp;
  int CNq;
  int CNr;
  byte[] CNs;
  
  public b()
  {
    AppMethodBeat.i(96498);
    this.CNo = 4;
    this.CNp = 14;
    this.CNq = 1;
    this.CNr = 20;
    this.CNs = new byte[2];
    this.CMD = 1;
    AppMethodBeat.o(96498);
  }
  
  public final Boolean erf()
  {
    if (this.CNn < 20) {
      return Boolean.FALSE;
    }
    return Boolean.TRUE;
  }
  
  public final byte[] g(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(96499);
    byte[] arrayOfByte = new byte[this.CNr];
    util.O(arrayOfByte, 0, this.CNq);
    util.P(arrayOfByte, 2, util.erl());
    util.P(arrayOfByte, 6, (int)paramLong);
    util.d(arrayOfByte, 10, util.ern());
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 14, paramArrayOfByte.length);
    util.O(arrayOfByte, paramArrayOfByte.length + 14, 0);
    super.Wr(this.CMD);
    super.ab(arrayOfByte, this.CNr);
    super.ere();
    paramArrayOfByte = super.era();
    AppMethodBeat.o(96499);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.b
 * JD-Core Version:    0.7.0.1
 */