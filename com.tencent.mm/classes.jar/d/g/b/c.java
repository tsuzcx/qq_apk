package d.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b;
import d.l.a;
import d.l.d;
import d.l.j;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract class c
  implements a, Serializable
{
  public static final Object Jhh = ;
  private transient a Jhf;
  protected final Object Jhg;
  
  public c()
  {
    this(Jhh);
  }
  
  protected c(Object paramObject)
  {
    this.Jhg = paramObject;
  }
  
  public String Gn()
  {
    throw new AbstractMethodError();
  }
  
  public d Go()
  {
    throw new AbstractMethodError();
  }
  
  public final Object ac(Object... paramVarArgs)
  {
    return fvN().ac(paramVarArgs);
  }
  
  public final Object bT(Map paramMap)
  {
    return fvN().bT(paramMap);
  }
  
  protected abstract a fvK();
  
  public final Object fvL()
  {
    return this.Jhg;
  }
  
  public final a fvM()
  {
    a locala2 = this.Jhf;
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = fvK();
      this.Jhf = locala1;
    }
    return locala1;
  }
  
  protected a fvN()
  {
    a locala = fvM();
    if (locala == this) {
      throw new b();
    }
    return locala;
  }
  
  public String getName()
  {
    throw new AbstractMethodError();
  }
  
  public final List<j> getParameters()
  {
    return fvN().getParameters();
  }
  
  static final class a
    implements Serializable
  {
    private static final a Jhi;
    
    static
    {
      AppMethodBeat.i(128955);
      Jhi = new a();
      AppMethodBeat.o(128955);
    }
    
    private Object readResolve()
    {
      return Jhi;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.g.b.c
 * JD-Core Version:    0.7.0.1
 */