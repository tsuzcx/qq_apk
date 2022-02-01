package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ao
  extends a
{
  int ajIp = 0;
  int ajIq = 0;
  
  public ao()
  {
    this.ajGQ = 2;
  }
  
  public final byte[] v(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(88109);
    this.ajIp = (paramArrayOfByte1.length + 6 + paramArrayOfByte2.length);
    byte[] arrayOfByte = new byte[this.ajIp];
    util.ag(arrayOfByte, 0, this.ajIq);
    util.ag(arrayOfByte, 2, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 4, paramArrayOfByte1.length);
    int i = paramArrayOfByte1.length + 4;
    util.ag(arrayOfByte, i, paramArrayOfByte2.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, i + 2, paramArrayOfByte2.length);
    super.aMR(this.ajGQ);
    super.an(arrayOfByte, this.ajIp);
    super.kGk();
    paramArrayOfByte1 = super.kGg();
    AppMethodBeat.o(88109);
    return paramArrayOfByte1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ao
 * JD-Core Version:    0.7.0.1
 */