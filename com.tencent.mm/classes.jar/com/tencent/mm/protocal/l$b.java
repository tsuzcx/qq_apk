package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.ho;
import com.tencent.mm.sdk.platformtools.y;

public final class l$b
  extends k.e
  implements k.c
{
  public ho spR = new ho();
  
  public final int A(byte[] paramArrayOfByte)
  {
    this.spR = ((ho)new ho().aH(paramArrayOfByte));
    y.d("MicroMsg.MMBgFg", "retcode:" + this.spR.iHq);
    return this.spR.iHq;
  }
  
  public final boolean cpe()
  {
    return true;
  }
  
  public final int getCmdId()
  {
    return 1000000312;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.l.b
 * JD-Core Version:    0.7.0.1
 */