package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class u$a
  extends l.d
  implements l.b
{
  public byte[] cuW = null;
  public long fJQ = -1L;
  
  public final int getCmdId()
  {
    return 1000000190;
  }
  
  public final int getFuncId()
  {
    return 268369922;
  }
  
  public final boolean getShortSupport()
  {
    return false;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(58860);
    byte[] arrayOfByte = new byte[this.cuW.length + 8];
    int i = (int)(bo.aoy() - this.fJQ);
    arrayOfByte[0] = ((byte)(i >> 24 & 0xFF));
    arrayOfByte[1] = ((byte)(i >> 16 & 0xFF));
    arrayOfByte[2] = ((byte)(i >> 8 & 0xFF));
    arrayOfByte[3] = ((byte)(i & 0xFF));
    arrayOfByte[4] = ((byte)(this.cuW.length >> 24 & 0xFF));
    arrayOfByte[5] = ((byte)(this.cuW.length >> 16 & 0xFF));
    arrayOfByte[6] = ((byte)(this.cuW.length >> 8 & 0xFF));
    arrayOfByte[7] = ((byte)(this.cuW.length & 0xFF));
    System.arraycopy(this.cuW, 0, arrayOfByte, 8, this.cuW.length);
    bo.cd(arrayOfByte);
    AppMethodBeat.o(58860);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.u.a
 * JD-Core Version:    0.7.0.1
 */