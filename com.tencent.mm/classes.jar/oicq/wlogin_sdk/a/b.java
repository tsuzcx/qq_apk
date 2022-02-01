package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class b
  extends a
{
  int Udi;
  int Udj;
  int Udk;
  int Udl;
  byte[] Udm;
  
  public b()
  {
    AppMethodBeat.i(88137);
    this.Udi = 4;
    this.Udj = 14;
    this.Udk = 1;
    this.Udl = 20;
    this.Udm = new byte[2];
    this.Ucx = 1;
    AppMethodBeat.o(88137);
  }
  
  public final byte[] g(long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88138);
    byte[] arrayOfByte = new byte[this.Udl];
    util.ah(arrayOfByte, 0, this.Udk);
    util.ai(arrayOfByte, 2, util.hPI());
    util.ai(arrayOfByte, 6, (int)paramLong);
    util.d(arrayOfByte, 10, util.hPK());
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 14, paramArrayOfByte.length);
    util.ah(arrayOfByte, paramArrayOfByte.length + 14, 0);
    super.awj(this.Ucx);
    super.ak(arrayOfByte, this.Udl);
    super.hPB();
    paramArrayOfByte = super.hPx();
    AppMethodBeat.o(88138);
    return paramArrayOfByte;
  }
  
  public final Boolean hPC()
  {
    if (this.Udh < 20) {
      return Boolean.FALSE;
    }
    return Boolean.TRUE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.b
 * JD-Core Version:    0.7.0.1
 */