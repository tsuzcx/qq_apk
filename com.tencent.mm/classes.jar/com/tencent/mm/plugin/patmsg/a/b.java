package com.tencent.mm.plugin.patmsg.a;

import android.util.Pair;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.dit;
import com.tencent.mm.protocal.protobuf.diu;
import com.tencent.mm.storage.ca;
import java.util.List;

public abstract interface b
  extends a
{
  public abstract boolean M(int paramInt, String paramString1, String paramString2);
  
  public abstract Pair<Long, Long> N(int paramInt, String paramString1, String paramString2);
  
  public abstract boolean OX(long paramLong);
  
  public abstract List<ca> OY(long paramLong);
  
  public abstract diu a(dit paramdit, long paramLong);
  
  public abstract String a(dit paramdit);
  
  public abstract void a(Pair<Long, Long> paramPair, int paramInt);
  
  public abstract dit aUf(String paramString);
  
  public abstract String aUg(String paramString);
  
  public abstract boolean am(long paramLong1, long paramLong2);
  
  public abstract int b(dit paramdit, long paramLong);
  
  public abstract long b(String paramString, Pair<Long, Long> paramPair);
  
  public abstract void be(String paramString, long paramLong);
  
  public abstract String d(Pair<Long, Long> paramPair);
  
  public abstract boolean e(Pair<Long, Long> paramPair);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.a.b
 * JD-Core Version:    0.7.0.1
 */