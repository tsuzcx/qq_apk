package d.g.b;

import d.l.a;
import d.l.k;

public abstract class v
  extends e
  implements k
{
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof v)) {
        break;
      }
      paramObject = (v)paramObject;
    } while ((HD().equals(paramObject.HD())) && (getName().equals(paramObject.getName())) && (HC().equals(paramObject.HC())) && (p.i(gkr(), paramObject.gkr())));
    return false;
    if ((paramObject instanceof k)) {
      return paramObject.equals(gks());
    }
    return false;
  }
  
  protected final k gkE()
  {
    return (k)super.gkt();
  }
  
  public int hashCode()
  {
    return (HD().hashCode() * 31 + getName().hashCode()) * 31 + HC().hashCode();
  }
  
  public String toString()
  {
    a locala = gks();
    if (locala != this) {
      return locala.toString();
    }
    return "property " + getName() + " (Kotlin reflection is not available)";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.g.b.v
 * JD-Core Version:    0.7.0.1
 */