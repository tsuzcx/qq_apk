package com.tencent.mm.plugin.patmsg.a;

import android.util.Pair;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.ciz;
import com.tencent.mm.protocal.protobuf.cja;
import com.tencent.mm.storage.bv;
import java.util.List;

public abstract interface b
  extends a
{
  public abstract boolean G(int paramInt, String paramString1, String paramString2);
  
  public abstract Pair<Long, Long> H(int paramInt, String paramString1, String paramString2);
  
  public abstract cja a(ciz paramciz, long paramLong);
  
  public abstract String a(ciz paramciz);
  
  public abstract void a(Pair<Long, Long> paramPair, int paramInt);
  
  public abstract boolean aa(long paramLong1, long paramLong2);
  
  public abstract ciz avw(String paramString);
  
  public abstract String avx(String paramString);
  
  public abstract int b(ciz paramciz, long paramLong);
  
  public abstract long b(String paramString, Pair<Long, Long> paramPair);
  
  public abstract void bb(String paramString, long paramLong);
  
  public abstract String d(Pair<Long, Long> paramPair);
  
  public abstract boolean e(Pair<Long, Long> paramPair);
  
  public abstract boolean yL(long paramLong);
  
  public abstract List<bv> yM(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.a.b
 * JD-Core Version:    0.7.0.1
 */