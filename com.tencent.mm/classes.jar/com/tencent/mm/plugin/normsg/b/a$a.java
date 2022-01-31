package com.tencent.mm.plugin.normsg.b;

import java.util.Collection;
import java.util.HashSet;

public final class a$a<T>
  extends HashSet<T>
{
  public final boolean add(T paramT)
  {
    if (contains(paramT)) {
      throw new UnsupportedOperationException();
    }
    return super.add(paramT);
  }
  
  public final boolean addAll(Collection paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean removeAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.a.a
 * JD-Core Version:    0.7.0.1
 */