package com.tencent.mm.protocal;

import com.tencent.mm.protocal.protobuf.frg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public abstract class j$i
  extends l.e
  implements l.c
{
  public frg YxP = new frg();
  public byte[] YxT;
  private byte[] YxU;
  public String hLv;
  public int mvX = 0;
  private byte[] pnm;
  private byte[] pnn;
  
  public final byte[] axu(int paramInt)
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
      arrayOfByte = this.YxU;
      break;
      arrayOfByte = this.pnm;
      break;
      arrayOfByte = this.pnn;
      break;
    }
  }
  
  public final void b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    this.YxU = paramArrayOfByte1;
    this.pnm = paramArrayOfByte2;
    this.pnn = paramArrayOfByte3;
    Log.i("MicroMsg.MMAuth", "summerauths setSession [%s] [%s], [%s]", new Object[] { Util.secPrint(Util.dumpHex(this.YxU)), Util.secPrint(Util.dumpHex(this.pnm)), Util.secPrint(Util.dumpHex(this.pnn)) });
  }
  
  public byte[] getAuthResponse()
  {
    try
    {
      byte[] arrayOfByte = this.YxP.toByteArray();
      return arrayOfByte;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.j.i
 * JD-Core Version:    0.7.0.1
 */