package kotlin.g.b;

import kotlin.l.a;
import kotlin.l.k;

public abstract class w
  extends e
  implements k
{
  public w() {}
  
  public w(Object paramObject)
  {
    super(paramObject);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof w)) {
        break;
      }
      paramObject = (w)paramObject;
    } while ((Rs().equals(paramObject.Rs())) && (getName().equals(paramObject.getName())) && (getSignature().equals(paramObject.getSignature())) && (p.j(hxQ(), paramObject.hxQ())));
    return false;
    if ((paramObject instanceof k)) {
      return paramObject.equals(hxR());
    }
    return false;
  }
  
  public int hashCode()
  {
    return (Rs().hashCode() * 31 + getName().hashCode()) * 31 + getSignature().hashCode();
  }
  
  protected final k hyg()
  {
    return (k)super.hxS();
  }
  
  public String toString()
  {
    a locala = hxR();
    if (locala != this) {
      return locala.toString();
    }
    return "property " + getName() + " (Kotlin reflection is not available)";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.g.b.w
 * JD-Core Version:    0.7.0.1
 */