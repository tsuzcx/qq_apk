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
    } while ((Ga().equals(paramObject.Ga())) && (getName().equals(paramObject.getName())) && (FZ().equals(paramObject.FZ())) && (k.g(fOp(), paramObject.fOp())));
    return false;
    if ((paramObject instanceof d.l.k)) {
      return paramObject.equals(fOq());
    }
    return false;
  }
  
  protected final d.l.k fOB()
  {
    return (d.l.k)super.fOr();
  }
  
  public int hashCode()
  {
    return (Ga().hashCode() * 31 + getName().hashCode()) * 31 + FZ().hashCode();
  }
  
  public String toString()
  {
    a locala = fOq();
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