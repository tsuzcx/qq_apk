package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ae
  extends a
{
  int UdK = 0;
  int UdL = 0;
  
  public ae()
  {
    this.Ucx = 322;
  }
  
  public final byte[] dr(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88133);
    this.UdL = (paramArrayOfByte.length + 4);
    byte[] arrayOfByte = new byte[this.UdL];
    util.ah(arrayOfByte, 0, this.UdK);
    util.ah(arrayOfByte, 2, paramArrayOfByte.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    super.awj(this.Ucx);
    super.ak(arrayOfByte, arrayOfByte.length);
    super.hPB();
    paramArrayOfByte = super.hPx();
    AppMethodBeat.o(88133);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ae
 * JD-Core Version:    0.7.0.1
 */