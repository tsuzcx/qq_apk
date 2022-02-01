package rx.internal.util.a;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.Pow2;

abstract class a<E>
  extends AbstractQueue<E>
{
  protected final AtomicReferenceArray<E> Kgy;
  protected final int mask;
  
  public a(int paramInt)
  {
    paramInt = Pow2.roundToPowerOfTwo(paramInt);
    this.mask = (paramInt - 1);
    this.Kgy = new AtomicReferenceArray(paramInt);
  }
  
  protected final E agt(int paramInt)
  {
    return this.Kgy.get(paramInt);
  }
  
  public void clear()
  {
    while ((poll() != null) || (!isEmpty())) {}
  }
  
  public Iterator<E> iterator()
  {
    throw new UnsupportedOperationException();
  }
  
  protected final int xV(long paramLong)
  {
    return (int)paramLong & this.mask;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     rx.internal.util.a.a
 * JD-Core Version:    0.7.0.1
 */