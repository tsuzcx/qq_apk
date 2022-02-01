package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ao
  extends a
{
  int NRR = 0;
  int NRS = 0;
  
  public ao()
  {
    this.NQs = 2;
  }
  
  public final byte[] r(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(88109);
    this.NRR = (paramArrayOfByte1.length + 6 + paramArrayOfByte2.length);
    byte[] arrayOfByte = new byte[this.NRR];
    util.W(arrayOfByte, 0, this.NRS);
    util.W(arrayOfByte, 2, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 4, paramArrayOfByte1.length);
    int i = paramArrayOfByte1.length + 4;
    util.W(arrayOfByte, i, paramArrayOfByte2.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, i + 2, paramArrayOfByte2.length);
    super.alW(this.NQs);
    super.af(arrayOfByte, this.NRR);
    super.gxV();
    paramArrayOfByte1 = super.gxR();
    AppMethodBeat.o(88109);
    return paramArrayOfByte1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.a.ao
 * JD-Core Version:    0.7.0.1
 */