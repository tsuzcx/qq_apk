package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class b
  extends a
{
  int abGA;
  byte[] abGB;
  int abGx;
  int abGy;
  int abGz;
  
  public b()
  {
    AppMethodBeat.i(88137);
    this.abGx = 4;
    this.abGy = 14;
    this.abGz = 1;
    this.abGA = 20;
    this.abGB = new byte[2];
    this.abFM = 1;
    AppMethodBeat.o(88137);
  }
  
  public final byte[] g(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88138);
    byte[] arrayOfByte = new byte[this.abGA];
    util.ai(arrayOfByte, 0, this.abGz);
    util.aj(arrayOfByte, 2, util.iUQ());
    util.aj(arrayOfByte, 6, (int)paramLong);
    util.d(arrayOfByte, 10, util.iUS());
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 14, paramArrayOfByte.length);
    util.ai(arrayOfByte, paramArrayOfByte.length + 14, 0);
    super.aGe(this.abFM);
    super.am(arrayOfByte, this.abGA);
    super.iUJ();
    paramArrayOfByte = super.iUF();
    AppMethodBeat.o(88138);
    return paramArrayOfByte;
  }
  
  public final Boolean iUK()
  {
    if (this.abGw < 20) {
      return Boolean.FALSE;
    }
    return Boolean.TRUE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     oicq.wlogin_sdk.a.b
 * JD-Core Version:    0.7.0.1
 */