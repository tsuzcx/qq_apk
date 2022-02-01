package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.ak.n;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.cwj;

public abstract class e
  extends n
  implements k
{
  protected boolean dyL = false;
  long zdU = 0L;
  
  public e(long paramLong)
  {
    this.zdU = paramLong;
  }
  
  public final boolean dSN()
  {
    return this.dyL;
  }
  
  public abstract cwj dSO();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.e
 * JD-Core Version:    0.7.0.1
 */