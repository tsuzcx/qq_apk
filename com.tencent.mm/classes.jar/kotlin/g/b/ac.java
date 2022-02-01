package kotlin.g.b;

import kotlin.l.b;
import kotlin.l.o;

public abstract class ac
  extends f
  implements o
{
  public ac() {}
  
  public ac(Object paramObject, Class paramClass, String paramString1, String paramString2, int paramInt) {}
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof ac)) {
        break;
      }
      paramObject = (ac)paramObject;
    } while ((avF().equals(paramObject.avF())) && (getName().equals(paramObject.getName())) && (getSignature().equals(paramObject.getSignature())) && (s.p(kln(), paramObject.kln())));
    return false;
    if ((paramObject instanceof o)) {
      return paramObject.equals(klo());
    }
    return false;
  }
  
  public int hashCode()
  {
    return (avF().hashCode() * 31 + getName().hashCode()) * 31 + getSignature().hashCode();
  }
  
  protected final o klE()
  {
    return (o)super.klp();
  }
  
  public String toString()
  {
    b localb = klo();
    if (localb != this) {
      return localb.toString();
    }
    return "property " + getName() + " (Kotlin reflection is not available)";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.g.b.ac
 * JD-Core Version:    0.7.0.1
 */