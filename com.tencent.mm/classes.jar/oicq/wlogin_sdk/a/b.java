package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class b
  extends a
{
  int LWE;
  int LWF;
  int LWG;
  int LWH;
  byte[] LWI;
  
  public b()
  {
    AppMethodBeat.i(88137);
    this.LWE = 4;
    this.LWF = 14;
    this.LWG = 1;
    this.LWH = 20;
    this.LWI = new byte[2];
    this.LVT = 1;
    AppMethodBeat.o(88137);
  }
  
  public final byte[] g(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88138);
    byte[] arrayOfByte = new byte[this.LWH];
    util.V(arrayOfByte, 0, this.LWG);
    util.W(arrayOfByte, 2, util.gfE());
    util.W(arrayOfByte, 6, (int)paramLong);
    util.d(arrayOfByte, 10, util.gfG());
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 14, paramArrayOfByte.length);
    util.V(arrayOfByte, paramArrayOfByte.length + 14, 0);
    super.ajl(this.LVT);
    super.ae(arrayOfByte, this.LWH);
    super.gfx();
    paramArrayOfByte = super.gft();
    AppMethodBeat.o(88138);
    return paramArrayOfByte;
  }
  
  public final Boolean gfy()
  {
    if (this.LWD < 20) {
      return Boolean.FALSE;
    }
    return Boolean.TRUE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.b
 * JD-Core Version:    0.7.0.1
 */