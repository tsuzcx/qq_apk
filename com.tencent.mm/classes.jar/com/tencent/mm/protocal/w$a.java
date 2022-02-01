package com.tencent.mm.protocal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;

public final class w$a
  extends l.d
  implements l.b
{
  public byte[] dtX = null;
  public long hZo = -1L;
  
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
    AppMethodBeat.i(133119);
    byte[] arrayOfByte = new byte[this.dtX.length + 8];
    int i = (int)(bu.fpO() - this.hZo);
    arrayOfByte[0] = ((byte)(i >> 24 & 0xFF));
    arrayOfByte[1] = ((byte)(i >> 16 & 0xFF));
    arrayOfByte[2] = ((byte)(i >> 8 & 0xFF));
    arrayOfByte[3] = ((byte)(i & 0xFF));
    arrayOfByte[4] = ((byte)(this.dtX.length >> 24 & 0xFF));
    arrayOfByte[5] = ((byte)(this.dtX.length >> 16 & 0xFF));
    arrayOfByte[6] = ((byte)(this.dtX.length >> 8 & 0xFF));
    arrayOfByte[7] = ((byte)(this.dtX.length & 0xFF));
    System.arraycopy(this.dtX, 0, arrayOfByte, 8, this.dtX.length);
    bu.cE(arrayOfByte);
    AppMethodBeat.o(133119);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.w.a
 * JD-Core Version:    0.7.0.1
 */