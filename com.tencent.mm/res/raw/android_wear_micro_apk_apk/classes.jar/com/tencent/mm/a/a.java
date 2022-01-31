package com.tencent.mm.a;

import com.tencent.mm.sdk.platformtools.h;

public final class a<K, O>
  extends h<K, O>
{
  private b<K, O> UX = null;
  
  public a(int paramInt)
  {
    super(paramInt);
  }
  
  public a(b<K, O> paramb)
  {
    super(10);
    this.UX = paramb;
  }
  
  protected final O create(K paramK)
  {
    return super.create(paramK);
  }
  
  protected final void entryRemoved(boolean paramBoolean, K paramK, O paramO1, O paramO2)
  {
    super.entryRemoved(paramBoolean, paramK, paramO1, paramO2);
    if ((this.UX != null) && (paramO2 == null)) {
      this.UX.C(paramO1);
    }
  }
  
  protected final int sizeOf(K paramK, O paramO)
  {
    return super.sizeOf(paramK, paramO);
  }
  
  public final void trimToSize(int paramInt)
  {
    super.trimToSize(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.a.a
 * JD-Core Version:    0.7.0.1
 */