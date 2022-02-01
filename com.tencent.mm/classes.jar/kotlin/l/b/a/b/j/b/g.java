package kotlin.l.b.a.b.j.b;

import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ae;
import kotlin.l.b.a.b.m.ad;

public abstract class g<T>
{
  private final T value;
  
  public g(T paramT)
  {
    this.value = paramT;
  }
  
  public abstract ad c(ae paramae);
  
  public boolean equals(Object paramObject)
  {
    Object localObject1 = null;
    Object localObject2;
    if (this != paramObject)
    {
      localObject2 = getValue();
      if (!(paramObject instanceof g)) {
        break label40;
      }
      paramObject = (g)paramObject;
      if (paramObject != null) {
        break label45;
      }
    }
    label40:
    label45:
    for (paramObject = localObject1;; paramObject = paramObject.getValue())
    {
      if (!s.p(localObject2, paramObject)) {
        break label53;
      }
      return true;
      paramObject = null;
      break;
    }
    label53:
    return false;
  }
  
  public T getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    Object localObject = getValue();
    if (localObject == null) {
      return 0;
    }
    return localObject.hashCode();
  }
  
  public String toString()
  {
    return String.valueOf(getValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.b.g
 * JD-Core Version:    0.7.0.1
 */