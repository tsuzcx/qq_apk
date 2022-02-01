package d.l.b.a.b.j.b;

import d.g.b.p;
import d.l.b.a.b.b.y;
import d.l.b.a.b.m.ab;

public abstract class g<T>
{
  private final T value;
  
  public g(T paramT)
  {
    this.value = paramT;
  }
  
  public abstract ab b(y paramy);
  
  public boolean equals(Object paramObject)
  {
    Object localObject1 = null;
    Object localObject2;
    if ((g)this != paramObject)
    {
      localObject2 = getValue();
      if ((paramObject instanceof g)) {
        break label55;
      }
      paramObject = null;
    }
    label55:
    for (;;)
    {
      g localg = (g)paramObject;
      paramObject = localObject1;
      if (localg != null) {
        paramObject = localg.getValue();
      }
      return p.i(localObject2, paramObject);
    }
  }
  
  public T getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    Object localObject = getValue();
    if (localObject != null) {
      return localObject.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    return String.valueOf(getValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.b.g
 * JD-Core Version:    0.7.0.1
 */