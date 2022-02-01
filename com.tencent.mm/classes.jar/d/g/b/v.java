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
    } while ((Hv().equals(paramObject.Hv())) && (getName().equals(paramObject.getName())) && (Hu().equals(paramObject.Hu())) && (p.i(gfP(), paramObject.gfP())));
    return false;
    if ((paramObject instanceof k)) {
      return paramObject.equals(gfQ());
    }
    return false;
  }
  
  protected final k ggc()
  {
    return (k)super.gfR();
  }
  
  public int hashCode()
  {
    return (Hv().hashCode() * 31 + getName().hashCode()) * 31 + Hu().hashCode();
  }
  
  public String toString()
  {
    a locala = gfQ();
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