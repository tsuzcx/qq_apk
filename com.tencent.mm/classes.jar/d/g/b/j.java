package d.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.a;
import d.l.e;

public class j
  extends c
  implements i, e
{
  private final int arity;
  
  public j(int paramInt)
  {
    this.arity = paramInt;
  }
  
  public j(int paramInt, Object paramObject)
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
    if ((paramObject instanceof j))
    {
      paramObject = (j)paramObject;
      if (Ga() == null)
      {
        if (paramObject.Ga() != null) {}
      }
      else {
        while (Ga().equals(paramObject.Ga()))
        {
          if ((!getName().equals(paramObject.getName())) || (!FZ().equals(paramObject.FZ())) || (!k.g(fOp(), paramObject.fOp()))) {
            break;
          }
          AppMethodBeat.o(128938);
          return true;
        }
      }
      AppMethodBeat.o(128938);
      return false;
    }
    if ((paramObject instanceof e))
    {
      boolean bool = paramObject.equals(fOq());
      AppMethodBeat.o(128938);
      return bool;
    }
    AppMethodBeat.o(128938);
    return false;
  }
  
  protected final a fOo()
  {
    AppMethodBeat.i(128937);
    e locale = w.a(this);
    AppMethodBeat.o(128937);
    return locale;
  }
  
  public int getArity()
  {
    return this.arity;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(128939);
    if (Ga() == null) {}
    for (int i = 0;; i = Ga().hashCode() * 31)
    {
      int j = getName().hashCode();
      int k = FZ().hashCode();
      AppMethodBeat.o(128939);
      return (i + j) * 31 + k;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(128940);
    Object localObject = fOq();
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
 * Qualified Name:     d.g.b.j
 * JD-Core Version:    0.7.0.1
 */