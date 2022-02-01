package d.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.a;

public class n
  extends e
  implements m, d.l.e
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
      if (HD() == null)
      {
        if (paramObject.HD() != null) {}
      }
      else {
        while (HD().equals(paramObject.HD()))
        {
          if ((!getName().equals(paramObject.getName())) || (!HC().equals(paramObject.HC())) || (!p.i(gkr(), paramObject.gkr()))) {
            break;
          }
          AppMethodBeat.o(128938);
          return true;
        }
      }
      AppMethodBeat.o(128938);
      return false;
    }
    if ((paramObject instanceof d.l.e))
    {
      boolean bool = paramObject.equals(gks());
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
  
  protected final a gkq()
  {
    AppMethodBeat.i(128937);
    d.l.e locale = z.a(this);
    AppMethodBeat.o(128937);
    return locale;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(128939);
    if (HD() == null) {}
    for (int i = 0;; i = HD().hashCode() * 31)
    {
      int j = getName().hashCode();
      int k = HC().hashCode();
      AppMethodBeat.o(128939);
      return (i + j) * 31 + k;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(128940);
    Object localObject = gks();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.g.b.n
 * JD-Core Version:    0.7.0.1
 */