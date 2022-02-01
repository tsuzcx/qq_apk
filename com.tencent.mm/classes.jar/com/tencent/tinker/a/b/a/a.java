package com.tencent.tinker.a.b.a;

import com.tencent.tinker.a.c.b;

public abstract class a
{
  final b Kon = new b();
  public int anh = 0;
  
  public final int fHe()
  {
    int i = this.Kon.indexOfKey(this.anh);
    if (i < 0) {
      return this.anh;
    }
    return this.Kon.Koy[i];
  }
  
  protected final void fHf()
  {
    this.anh += 1;
  }
  
  public final void kL(int paramInt1, int paramInt2)
  {
    this.Kon.put(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */