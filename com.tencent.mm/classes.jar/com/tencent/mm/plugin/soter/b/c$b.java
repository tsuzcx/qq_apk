package com.tencent.mm.plugin.soter.b;

import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.caf;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;

public final class c$b
  extends k.e
  implements k.c
{
  public caf prJ = new caf();
  
  public final int A(byte[] paramArrayOfByte)
  {
    this.prJ = ((caf)new caf().aH(paramArrayOfByte));
    k.a(this, this.prJ.tFx);
    return this.prJ.tFx.sze;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.b.c.b
 * JD-Core Version:    0.7.0.1
 */