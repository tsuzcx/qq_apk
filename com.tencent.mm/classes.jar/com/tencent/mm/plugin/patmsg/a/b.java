package com.tencent.mm.plugin.patmsg.a;

import android.content.Context;
import android.util.Pair;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.protobuf.ebd;
import com.tencent.mm.protocal.protobuf.ebe;
import com.tencent.mm.storage.cc;
import java.util.List;

public abstract interface b
  extends a
{
  public abstract Pair<Long, Long> Q(int paramInt, String paramString1, String paramString2);
  
  public abstract ebe a(ebd paramebd, long paramLong);
  
  public abstract CharSequence a(String paramString1, String paramString2, float paramFloat);
  
  public abstract String a(ebd paramebd);
  
  public abstract void a(Pair<Long, Long> paramPair, int paramInt);
  
  public abstract ebd aRl(String paramString);
  
  public abstract boolean aW(long paramLong1, long paramLong2);
  
  public abstract int b(ebd paramebd, long paramLong);
  
  public abstract long b(String paramString, Pair<Long, Long> paramPair);
  
  public abstract CharSequence b(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2);
  
  public abstract void bo(String paramString, long paramLong);
  
  public abstract String d(Pair<Long, Long> paramPair);
  
  public abstract boolean e(Pair<Long, Long> paramPair);
  
  public abstract boolean kM(String paramString1, String paramString2);
  
  public abstract a kO(String paramString1, String paramString2);
  
  public abstract boolean ta(long paramLong);
  
  public abstract List<cc> tb(long paramLong);
  
  public static final class a
  {
    public String MHm;
    public String MHn;
    public String MHo;
    public String MHp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.a.b
 * JD-Core Version:    0.7.0.1
 */