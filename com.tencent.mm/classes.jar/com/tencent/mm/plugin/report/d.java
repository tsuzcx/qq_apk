package com.tencent.mm.plugin.report;

import com.tencent.mars.smc.IDKey;
import java.util.ArrayList;
import java.util.Map;

public abstract interface d
{
  public abstract void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean);
  
  public abstract void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, Object... paramVarArgs);
  
  public abstract void b(ArrayList<IDKey> paramArrayList, boolean paramBoolean);
  
  public abstract void d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean);
  
  public abstract void e(int paramInt, Object... paramVarArgs);
  
  public abstract void g(String paramString1, String paramString2, Map<String, Object> paramMap);
  
  public abstract void idkeyStat(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean);
  
  public abstract void kvStat(int paramInt, String paramString);
  
  public abstract void setUin(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.d
 * JD-Core Version:    0.7.0.1
 */