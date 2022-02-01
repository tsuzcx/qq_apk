package com.tencent.mm.plugin.patmsg.a;

import android.util.Pair;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.czg;
import com.tencent.mm.protocal.protobuf.czh;
import com.tencent.mm.storage.ca;
import java.util.List;

public abstract interface b
  extends a
{
  public abstract boolean HD(long paramLong);
  
  public abstract List<ca> HE(long paramLong);
  
  public abstract boolean J(int paramInt, String paramString1, String paramString2);
  
  public abstract Pair<Long, Long> K(int paramInt, String paramString1, String paramString2);
  
  public abstract czh a(czg paramczg, long paramLong);
  
  public abstract String a(czg paramczg);
  
  public abstract void a(Pair<Long, Long> paramPair, int paramInt);
  
  public abstract czg aJJ(String paramString);
  
  public abstract String aJK(String paramString);
  
  public abstract boolean ae(long paramLong1, long paramLong2);
  
  public abstract int b(czg paramczg, long paramLong);
  
  public abstract long b(String paramString, Pair<Long, Long> paramPair);
  
  public abstract void bd(String paramString, long paramLong);
  
  public abstract String d(Pair<Long, Long> paramPair);
  
  public abstract boolean e(Pair<Long, Long> paramPair);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.a.b
 * JD-Core Version:    0.7.0.1
 */