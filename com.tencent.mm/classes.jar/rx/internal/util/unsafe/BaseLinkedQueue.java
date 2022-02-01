package rx.internal.util.unsafe;

import java.util.Iterator;
import rx.internal.util.a.b;

abstract class BaseLinkedQueue<E>
  extends BaseLinkedQueueConsumerNodeRef<E>
{
  long p00;
  long p01;
  long p02;
  long p03;
  long p04;
  long p05;
  long p06;
  long p07;
  long p30;
  long p31;
  long p32;
  long p33;
  long p34;
  long p35;
  long p36;
  long p37;
  
  public final boolean isEmpty()
  {
    return lvConsumerNode() == lvProducerNode();
  }
  
  public final Iterator<E> iterator()
  {
    throw new UnsupportedOperationException();
  }
  
  public final int size()
  {
    Object localObject = lvConsumerNode();
    b localb2 = lvProducerNode();
    int i = 0;
    while ((localObject != localb2) && (i < 2147483647))
    {
      b localb1;
      do
      {
        localb1 = (b)((b)localObject).get();
      } while (localb1 == null);
      i += 1;
      localObject = localb1;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     rx.internal.util.unsafe.BaseLinkedQueue
 * JD-Core Version:    0.7.0.1
 */