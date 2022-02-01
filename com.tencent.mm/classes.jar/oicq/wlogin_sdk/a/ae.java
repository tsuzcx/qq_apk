package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ae
  extends a
{
  int ajId = 0;
  int ajIe = 0;
  
  public ae()
  {
    this.ajGQ = 322;
  }
  
  public final byte[] dT(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88133);
    this.ajIe = (paramArrayOfByte.length + 4);
    byte[] arrayOfByte = new byte[this.ajIe];
    util.ag(arrayOfByte, 0, this.ajId);
    util.ag(arrayOfByte, 2, paramArrayOfByte.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    super.aMR(this.ajGQ);
    super.an(arrayOfByte, arrayOfByte.length);
    super.kGk();
    paramArrayOfByte = super.kGg();
    AppMethodBeat.o(88133);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ae
 * JD-Core Version:    0.7.0.1
 */