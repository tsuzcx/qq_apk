package rx.internal.util.a;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.Pow2;

abstract class a<E>
  extends AbstractQueue<E>
{
  protected final AtomicReferenceArray<E> NLd;
  protected final int mask;
  
  public a(int paramInt)
  {
    paramInt = Pow2.roundToPowerOfTwo(paramInt);
    this.mask = (paramInt - 1);
    this.NLd = new AtomicReferenceArray(paramInt);
  }
  
  protected final int FP(long paramLong)
  {
    return (int)paramLong & this.mask;
  }
  
  protected final E ama(int paramInt)
  {
    return this.NLd.get(paramInt);
  }
  
  public void clear()
  {
    while ((poll() != null) || (!isEmpty())) {}
  }
  
  public Iterator<E> iterator()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     rx.internal.util.a.a
 * JD-Core Version:    0.7.0.1
 */