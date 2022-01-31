package com.tencent.mm.protocal;

import com.tencent.mm.sdk.platformtools.bk;

public final class t$a
  extends k.d
  implements k.b
{
  public byte[] bNE = null;
  public long eud = -1L;
  
  public final byte[] HG()
  {
    byte[] arrayOfByte = new byte[this.bNE.length + 8];
    int i = (int)(bk.UY() - this.eud);
    arrayOfByte[0] = ((byte)(i >> 24 & 0xFF));
    arrayOfByte[1] = ((byte)(i >> 16 & 0xFF));
    arrayOfByte[2] = ((byte)(i >> 8 & 0xFF));
    arrayOfByte[3] = ((byte)(i & 0xFF));
    arrayOfByte[4] = ((byte)(this.bNE.length >> 24 & 0xFF));
    arrayOfByte[5] = ((byte)(this.bNE.length >> 16 & 0xFF));
    arrayOfByte[6] = ((byte)(this.bNE.length >> 8 & 0xFF));
    arrayOfByte[7] = ((byte)(this.bNE.length & 0xFF));
    System.arraycopy(this.bNE, 0, arrayOfByte, 8, this.bNE.length);
    bk.bD(arrayOfByte);
    return arrayOfByte;
  }
  
  public final int HH()
  {
    return 268369922;
  }
  
  public final boolean Lb()
  {
    return false;
  }
  
  public final int getCmdId()
  {
    return 1000000190;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.t.a
 * JD-Core Version:    0.7.0.1
 */