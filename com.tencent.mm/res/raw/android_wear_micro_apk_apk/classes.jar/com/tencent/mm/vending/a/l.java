package com.tencent.mm.vending.a;

import java.util.HashMap;

final class l<K, V>
  extends HashMap<K, V>
{
  private j acZ = null;
  
  public final void a(j paramj)
  {
    this.acZ = paramj;
  }
  
  public final void clear()
  {
    super.clear();
    if (this.acZ != null) {
      this.acZ.me();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.a.l
 * JD-Core Version:    0.7.0.1
 */