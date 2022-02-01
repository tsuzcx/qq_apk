package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ae
  extends a
{
  int abGZ = 0;
  int abHa = 0;
  
  public ae()
  {
    this.abFM = 322;
  }
  
  public final byte[] dQ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88133);
    this.abHa = (paramArrayOfByte.length + 4);
    byte[] arrayOfByte = new byte[this.abHa];
    util.ai(arrayOfByte, 0, this.abGZ);
    util.ai(arrayOfByte, 2, paramArrayOfByte.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    super.aGe(this.abFM);
    super.am(arrayOfByte, arrayOfByte.length);
    super.iUJ();
    paramArrayOfByte = super.iUF();
    AppMethodBeat.o(88133);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ae
 * JD-Core Version:    0.7.0.1
 */