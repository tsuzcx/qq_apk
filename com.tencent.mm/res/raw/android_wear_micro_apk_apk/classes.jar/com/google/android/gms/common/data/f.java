package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.d;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class f<T>
  implements Iterator<T>
{
  protected final b<T> Is;
  protected int It;
  
  public f(b<T> paramb)
  {
    this.Is = ((b)d.u(paramb));
    this.It = -1;
  }
  
  public final boolean hasNext()
  {
    return this.It < this.Is.getCount() - 1;
  }
  
  public final T next()
  {
    if (!hasNext())
    {
      i = this.It;
      throw new NoSuchElementException(46 + "Cannot advance the iterator beyond " + i);
    }
    b localb = this.Is;
    int i = this.It + 1;
    this.It = i;
    return localb.get(i);
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.google.android.gms.common.data.f
 * JD-Core Version:    0.7.0.1
 */