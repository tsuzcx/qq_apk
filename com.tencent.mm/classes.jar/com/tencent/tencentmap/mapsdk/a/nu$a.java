package com.tencent.tencentmap.mapsdk.a;

import java.util.LinkedHashMap;

class nu$a<K, V>
{
  byte[] a = new byte[0];
  private LinkedHashMap<K, V> b;
  private int c;
  
  public nu$a(int paramInt)
  {
    this.c = paramInt;
    this.b = new nu.a.1(this, (int)Math.ceil(paramInt / 0.75F) + 1, 0.75F, true);
  }
  
  public V a(K paramK)
  {
    synchronized (this.a)
    {
      paramK = this.b.get(paramK);
      return paramK;
    }
  }
  
  public void a()
  {
    synchronized (this.a)
    {
      this.b.clear();
      return;
    }
  }
  
  public void a(K paramK, V paramV)
  {
    synchronized (this.a)
    {
      this.b.put(paramK, paramV);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.nu.a
 * JD-Core Version:    0.7.0.1
 */