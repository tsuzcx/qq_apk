package com.tencent.mm.vending.base;

import java.util.HashMap;

final class Vending$h<K, V>
  extends HashMap<K, V>
{
  Vending.f wtk = null;
  
  public final void clear()
  {
    super.clear();
    if (this.wtk != null) {
      this.wtk.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.vending.base.Vending.h
 * JD-Core Version:    0.7.0.1
 */