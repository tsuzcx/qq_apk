package rx.internal.util.a;

import java.util.concurrent.atomic.AtomicReference;

public final class b<E>
  extends AtomicReference<b<E>>
{
  public E value;
  
  public b() {}
  
  public b(E paramE)
  {
    this.value = paramE;
  }
  
  public final E gDL()
  {
    Object localObject = this.value;
    this.value = null;
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     rx.internal.util.a.b
 * JD-Core Version:    0.7.0.1
 */