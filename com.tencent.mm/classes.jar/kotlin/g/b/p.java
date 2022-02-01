package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b;

public class p
  extends f
  implements o, kotlin.l.f
{
  private final int arity;
  private final int flags;
  
  public p(int paramInt)
  {
    this(paramInt, aiwK, null, null, null, 0);
  }
  
  public p(int paramInt, Object paramObject)
  {
    this(paramInt, paramObject, null, null, null, 0);
  }
  
  public p(int paramInt1, Object paramObject, Class paramClass, String paramString1, String paramString2, int paramInt2) {}
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(128938);
    if (paramObject == this)
    {
      AppMethodBeat.o(128938);
      return true;
    }
    if ((paramObject instanceof p))
    {
      paramObject = (p)paramObject;
      if ((s.p(avF(), paramObject.avF())) && (getName().equals(paramObject.getName())) && (getSignature().equals(paramObject.getSignature())) && (this.flags == paramObject.flags) && (this.arity == paramObject.arity) && (s.p(kln(), paramObject.kln())))
      {
        AppMethodBeat.o(128938);
        return true;
      }
      AppMethodBeat.o(128938);
      return false;
    }
    if ((paramObject instanceof kotlin.l.f))
    {
      boolean bool = paramObject.equals(klo());
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
    if (avF() == null) {}
    for (int i = 0;; i = avF().hashCode() * 31)
    {
      int j = getName().hashCode();
      int k = getSignature().hashCode();
      AppMethodBeat.o(128939);
      return (i + j) * 31 + k;
    }
  }
  
  protected final b klm()
  {
    AppMethodBeat.i(128937);
    kotlin.l.f localf = ai.a(this);
    AppMethodBeat.o(128937);
    return localf;
  }
  
  public String toString()
  {
    AppMethodBeat.i(128940);
    Object localObject = klo();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.g.b.p
 * JD-Core Version:    0.7.0.1
 */