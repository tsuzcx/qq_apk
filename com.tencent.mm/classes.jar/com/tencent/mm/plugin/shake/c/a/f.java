package com.tencent.mm.plugin.shake.c.a;

import com.tencent.mm.am.p;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.esc;

public abstract class f
  extends p
  implements m
{
  long PBq = 0L;
  protected boolean hPw = false;
  
  public f(long paramLong)
  {
    this.PBq = paramLong;
  }
  
  public static final f a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, long paramLong, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    if (paramInt1 == 367) {
      return new g(paramArrayOfByte, paramInt2, paramLong, paramInt3, paramBoolean, paramInt4);
    }
    if (paramInt1 == 408) {
      return new i(paramArrayOfByte, paramInt2, paramLong, paramInt3, paramBoolean, paramInt4);
    }
    return null;
  }
  
  public static int aLV()
  {
    return 0;
  }
  
  public final boolean gXE()
  {
    return this.hPw;
  }
  
  public abstract esc gXF();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.a.f
 * JD-Core Version:    0.7.0.1
 */