package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class b
  extends a
{
  int Ooj;
  int Ook;
  int Ool;
  int Oom;
  byte[] Oon;
  
  public b()
  {
    AppMethodBeat.i(88137);
    this.Ooj = 4;
    this.Ook = 14;
    this.Ool = 1;
    this.Oom = 20;
    this.Oon = new byte[2];
    this.Ony = 1;
    AppMethodBeat.o(88137);
  }
  
  public final Boolean gCy()
  {
    if (this.Ooi < 20) {
      return Boolean.FALSE;
    }
    return Boolean.TRUE;
  }
  
  public final byte[] h(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88138);
    byte[] arrayOfByte = new byte[this.Oom];
    util.X(arrayOfByte, 0, this.Ool);
    util.Y(arrayOfByte, 2, util.gCE());
    util.Y(arrayOfByte, 6, (int)paramLong);
    util.d(arrayOfByte, 10, util.gCG());
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 14, paramArrayOfByte.length);
    util.X(arrayOfByte, paramArrayOfByte.length + 14, 0);
    super.amG(this.Ony);
    super.aj(arrayOfByte, this.Oom);
    super.gCx();
    paramArrayOfByte = super.gCt();
    AppMethodBeat.o(88138);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.b
 * JD-Core Version:    0.7.0.1
 */