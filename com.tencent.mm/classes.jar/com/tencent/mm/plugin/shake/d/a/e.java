package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.an.q;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.dyy;

public abstract class e
  extends q
  implements m
{
  long Jos = 0L;
  protected boolean fJQ = false;
  
  public e(long paramLong)
  {
    this.Jos = paramLong;
  }
  
  public static final e a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, long paramLong, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    if (paramInt1 == 367) {
      return new f(paramArrayOfByte, paramInt2, paramLong, paramInt3, paramBoolean, paramInt4);
    }
    if (paramInt1 == 408) {
      return new g(paramArrayOfByte, paramInt2, paramLong, paramInt3, paramBoolean, paramInt4);
    }
    return null;
  }
  
  public static int arZ()
  {
    return 0;
  }
  
  public final boolean fHP()
  {
    return this.fJQ;
  }
  
  public abstract dyy fHQ();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.e
 * JD-Core Version:    0.7.0.1
 */