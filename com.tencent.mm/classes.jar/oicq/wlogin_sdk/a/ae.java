package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ae
  extends a
{
  int NRF = 0;
  int NRG = 0;
  
  public ae()
  {
    this.NQs = 322;
  }
  
  public final byte[] dm(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88133);
    this.NRG = (paramArrayOfByte.length + 4);
    byte[] arrayOfByte = new byte[this.NRG];
    util.W(arrayOfByte, 0, this.NRF);
    util.W(arrayOfByte, 2, paramArrayOfByte.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    super.alW(this.NQs);
    super.af(arrayOfByte, arrayOfByte.length);
    super.gxV();
    paramArrayOfByte = super.gxR();
    AppMethodBeat.o(88133);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ae
 * JD-Core Version:    0.7.0.1
 */