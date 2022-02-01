package rx.internal.util.a;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.Pow2;

abstract class a<E>
  extends AbstractQueue<E>
{
  protected final AtomicReferenceArray<E> TXf;
  protected final int mask;
  
  public a(int paramInt)
  {
    paramInt = Pow2.roundToPowerOfTwo(paramInt);
    this.mask = (paramInt - 1);
    this.TXf = new AtomicReferenceArray(paramInt);
  }
  
  protected final int Px(long paramLong)
  {
    return (int)paramLong & this.mask;
  }
  
  protected final E awp(int paramInt)
  {
    return this.TXf.get(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     rx.internal.util.a.a
 * JD-Core Version:    0.7.0.1
 */