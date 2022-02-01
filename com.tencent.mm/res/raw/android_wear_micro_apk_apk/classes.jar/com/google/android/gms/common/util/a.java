package com.google.android.gms.common.util;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class a<E>
  extends AbstractSet<E>
{
  private final android.support.v4.b.a<E, E> MS = new android.support.v4.b.a();
  
  public final boolean add(E paramE)
  {
    if (this.MS.containsKey(paramE)) {
      return false;
    }
    this.MS.put(paramE, paramE);
    return true;
  }
  
  public final boolean addAll(Collection<? extends E> paramCollection)
  {
    if ((paramCollection instanceof a))
    {
      paramCollection = (a)paramCollection;
      int i = size();
      this.MS.a(paramCollection.MS);
      return size() > i;
    }
    return super.addAll(paramCollection);
  }
  
  public final void clear()
  {
    this.MS.clear();
  }
  
  public final boolean contains(Object paramObject)
  {
    return this.MS.containsKey(paramObject);
  }
  
  public final Iterator<E> iterator()
  {
    return this.MS.keySet().iterator();
  }
  
  public final boolean remove(Object paramObject)
  {
    if (!this.MS.containsKey(paramObject)) {
      return false;
    }
    this.MS.remove(paramObject);
    return true;
  }
  
  public final int size()
  {
    return this.MS.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.util.a
 * JD-Core Version:    0.7.0.1
 */