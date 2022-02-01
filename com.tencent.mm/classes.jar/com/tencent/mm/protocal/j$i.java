package com.tencent.mm.protocal;

import com.tencent.mm.protocal.protobuf.evr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class j$i
  extends l.e
  implements l.c
{
  public evr RBm = new evr();
  public byte[] RBq;
  private byte[] RBr;
  public String fGe;
  public int jWd = 0;
  private byte[] mtS;
  private byte[] mtT;
  
  public final byte[] arm(int paramInt)
  {
    byte[] arrayOfByte = new byte[0];
    switch (paramInt)
    {
    default: 
      if (arrayOfByte != null) {
        break;
      }
    }
    for (int i = -1;; i = arrayOfByte.length)
    {
      Log.i("MicroMsg.MMAuth", "summerauths getSession seesionKeyType[%s] [%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
      return arrayOfByte;
      arrayOfByte = this.RBr;
      break;
      arrayOfByte = this.mtS;
      break;
      arrayOfByte = this.mtT;
      break;
    }
  }
  
  public final void b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    this.RBr = paramArrayOfByte1;
    this.mtS = paramArrayOfByte2;
    this.mtT = paramArrayOfByte3;
    Log.i("MicroMsg.MMAuth", "summerauths setSession [%s] [%s], [%s]", new Object[] { Util.secPrint(Util.dumpHex(this.RBr)), Util.secPrint(Util.dumpHex(this.mtS)), Util.secPrint(Util.dumpHex(this.mtT)) });
  }
  
  public byte[] getAuthResponse()
  {
    try
    {
      byte[] arrayOfByte = this.RBm.toByteArray();
      return arrayOfByte;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.j.i
 * JD-Core Version:    0.7.0.1
 */