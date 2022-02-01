package kotlin.g.b;

import kotlin.l.a;
import kotlin.l.n;

public abstract class w
  extends e
  implements n
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
    } while ((Vc().equals(paramObject.Vc())) && (getName().equals(paramObject.getName())) && (getSignature().equals(paramObject.getSignature())) && (p.h(iBY(), paramObject.iBY())));
    return false;
    if ((paramObject instanceof n)) {
      return paramObject.equals(iBZ());
    }
    return false;
  }
  
  public int hashCode()
  {
    return (Vc().hashCode() * 31 + getName().hashCode()) * 31 + getSignature().hashCode();
  }
  
  protected final n iCr()
  {
    return (n)super.iCa();
  }
  
  public String toString()
  {
    a locala = iBZ();
    if (locala != this) {
      return locala.toString();
    }
    return "property " + getName() + " (Kotlin reflection is not available)";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.g.b.w
 * JD-Core Version:    0.7.0.1
 */