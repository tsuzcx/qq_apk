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
  public static final Object KUA = ;
  private transient a KUy;
  protected final Object KUz;
  
  public c()
  {
    this(KUA);
  }
  
  protected c(Object paramObject)
  {
    this.KUz = paramObject;
  }
  
  public String FZ()
  {
    throw new AbstractMethodError();
  }
  
  public d Ga()
  {
    throw new AbstractMethodError();
  }
  
  public final Object ae(Object... paramVarArgs)
  {
    return fOr().ae(paramVarArgs);
  }
  
  public final Object cc(Map paramMap)
  {
    return fOr().cc(paramMap);
  }
  
  protected abstract a fOo();
  
  public final Object fOp()
  {
    return this.KUz;
  }
  
  public final a fOq()
  {
    a locala2 = this.KUy;
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = fOo();
      this.KUy = locala1;
    }
    return locala1;
  }
  
  protected a fOr()
  {
    a locala = fOq();
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
    return fOr().getParameters();
  }
  
  static final class a
    implements Serializable
  {
    private static final a KUB;
    
    static
    {
      AppMethodBeat.i(128955);
      KUB = new a();
      AppMethodBeat.o(128955);
    }
    
    private Object readResolve()
    {
      return KUB;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.g.b.c
 * JD-Core Version:    0.7.0.1
 */