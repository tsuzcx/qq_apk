package com.tencent.mm.a;

import com.tencent.mm.sdk.platformtools.h;

public final class e<K, O>
  extends h<K, O>
  implements a<K, O>
{
  private b<K, O> WM = null;
  private c<K, O> WN = null;
  
  public e(int paramInt)
  {
    super(paramInt);
  }
  
  public e(b<K, O> paramb)
  {
    super(10);
    this.WM = paramb;
  }
  
  public final O create(K paramK)
  {
    return super.create(paramK);
  }
  
  public final void entryRemoved(boolean paramBoolean, K paramK, O paramO1, O paramO2)
  {
    super.entryRemoved(paramBoolean, paramK, paramO1, paramO2);
    if (this.WM != null) {
      this.WM.L(paramO2);
    }
  }
  
  public final int sizeOf(K paramK, O paramO)
  {
    if (this.WN != null) {
      return this.WN.li();
    }
    return super.sizeOf(paramK, paramO);
  }
  
  public final void trimToSize(int paramInt)
  {
    super.trimToSize(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.a.e
 * JD-Core Version:    0.7.0.1
 */