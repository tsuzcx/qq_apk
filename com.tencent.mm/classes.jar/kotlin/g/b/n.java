package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.a;

public class n
  extends e
  implements m, kotlin.l.e
{
  private final int arity;
  
  public n(int paramInt)
  {
    this.arity = paramInt;
  }
  
  public n(int paramInt, Object paramObject)
  {
    super(paramObject);
    this.arity = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(128938);
    if (paramObject == this)
    {
      AppMethodBeat.o(128938);
      return true;
    }
    if ((paramObject instanceof n))
    {
      paramObject = (n)paramObject;
      if (Vc() == null)
      {
        if (paramObject.Vc() != null) {}
      }
      else {
        while (Vc().equals(paramObject.Vc()))
        {
          if ((!getName().equals(paramObject.getName())) || (!getSignature().equals(paramObject.getSignature())) || (!p.h(iBY(), paramObject.iBY()))) {
            break;
          }
          AppMethodBeat.o(128938);
          return true;
        }
      }
      AppMethodBeat.o(128938);
      return false;
    }
    if ((paramObject instanceof kotlin.l.e))
    {
      boolean bool = paramObject.equals(iBZ());
      AppMethodBeat.o(128938);
      return bool;
    }
    AppMethodBeat.o(128938);
    return false;
  }
  
  public int getArity()
  {
    return this.arity;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(128939);
    if (Vc() == null) {}
    for (int i = 0;; i = Vc().hashCode() * 31)
    {
      int j = getName().hashCode();
      int k = getSignature().hashCode();
      AppMethodBeat.o(128939);
      return (i + j) * 31 + k;
    }
  }
  
  protected final a iBX()
  {
    AppMethodBeat.i(128937);
    kotlin.l.e locale = ab.a(this);
    AppMethodBeat.o(128937);
    return locale;
  }
  
  public String toString()
  {
    AppMethodBeat.i(128940);
    Object localObject = iBZ();
    if (localObject != this)
    {
      localObject = localObject.toString();
      AppMethodBeat.o(128940);
      return localObject;
    }
    if ("<init>".equals(getName()))
    {
      AppMethodBeat.o(128940);
      return "constructor (Kotlin reflection is not available)";
    }
    localObject = "function " + getName() + " (Kotlin reflection is not available)";
    AppMethodBeat.o(128940);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.g.b.n
 * JD-Core Version:    0.7.0.1
 */