package com.tencent.mm.plugin.secdata;

import com.tencent.mm.bx.a;
import com.tencent.mm.kernel.b.d;

public abstract interface g
  extends d
{
  public abstract <T extends a> T getOnlyMemory(int paramInt, String paramString);
  
  public abstract <T extends a> void getWithClear(int paramInt, String paramString, Class<T> paramClass, i<T> parami);
  
  public abstract <T extends a> void getWithoutClear(int paramInt, String paramString, Class<T> paramClass, i<T> parami);
  
  public abstract <T extends a> T getWithoutClearSync(int paramInt, String paramString, Class<T> paramClass);
  
  public abstract void removeFromMemory(int paramInt, String paramString);
  
  public abstract <T extends a> void removeFromStorage(int paramInt, String paramString, i<T> parami);
  
  public abstract boolean removeFromStorageSync(int paramInt, String paramString);
  
  public abstract <T extends a> void updateOnlyMemory(int paramInt, String paramString, T paramT);
  
  public abstract <T extends a> void updateWithSave(int paramInt, String paramString, T paramT, long paramLong, i<T> parami);
  
  public abstract <T extends a> void updateWithSave(int paramInt, String paramString, T paramT, i<T> parami);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.secdata.g
 * JD-Core Version:    0.7.0.1
 */