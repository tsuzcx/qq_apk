package com.tencent.mm.plugin.patmsg.a;

import android.util.Pair;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.cif;
import com.tencent.mm.protocal.protobuf.cig;
import com.tencent.mm.storage.bu;
import java.util.List;

public abstract interface b
  extends a
{
  public abstract boolean G(int paramInt, String paramString1, String paramString2);
  
  public abstract Pair<Long, Long> H(int paramInt, String paramString1, String paramString2);
  
  public abstract cig a(cif paramcif, long paramLong);
  
  public abstract String a(cif paramcif);
  
  public abstract void a(Pair<Long, Long> paramPair, int paramInt);
  
  public abstract boolean ab(long paramLong1, long paramLong2);
  
  public abstract cif auh(String paramString);
  
  public abstract String aui(String paramString);
  
  public abstract int b(cif paramcif, long paramLong);
  
  public abstract long b(String paramString, Pair<Long, Long> paramPair);
  
  public abstract void ba(String paramString, long paramLong);
  
  public abstract String d(Pair<Long, Long> paramPair);
  
  public abstract boolean e(Pair<Long, Long> paramPair);
  
  public abstract boolean yr(long paramLong);
  
  public abstract List<bu> ys(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.a.b
 * JD-Core Version:    0.7.0.1
 */