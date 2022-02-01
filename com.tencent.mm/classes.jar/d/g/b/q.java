package d.g.b;

import d.l.a;

public abstract class q
  extends c
  implements d.l.k
{
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof q)) {
        break;
      }
      paramObject = (q)paramObject;
    } while ((Go().equals(paramObject.Go())) && (getName().equals(paramObject.getName())) && (Gn().equals(paramObject.Gn())) && (k.g(fvL(), paramObject.fvL())));
    return false;
    if ((paramObject instanceof d.l.k)) {
      return paramObject.equals(fvM());
    }
    return false;
  }
  
  protected final d.l.k fvX()
  {
    return (d.l.k)super.fvN();
  }
  
  public int hashCode()
  {
    return (Go().hashCode() * 31 + getName().hashCode()) * 31 + Gn().hashCode();
  }
  
  public String toString()
  {
    a locala = fvM();
    if (locala != this) {
      return locala.toString();
    }
    return "property " + getName() + " (Kotlin reflection is not available)";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.g.b.q
 * JD-Core Version:    0.7.0.1
 */