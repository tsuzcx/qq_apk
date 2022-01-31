package com.tencent.mm.plugin.normsg.b;

import android.util.SparseArray;

final class b$i$a<T>
  extends SparseArray<T>
{
  private b$i$a(b.i parami) {}
  
  public final void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public final void put(int paramInt, T paramT)
  {
    if (get(paramInt) != null) {
      throw new UnsupportedOperationException();
    }
    super.put(paramInt, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.b.i.a
 * JD-Core Version:    0.7.0.1
 */