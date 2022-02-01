package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.g.b;
import kotlin.l.a;
import kotlin.l.d;
import kotlin.l.j;

public abstract class e
  implements Serializable, a
{
  public static final Object SYm = ;
  private transient a SYk;
  protected final Object SYl;
  
  public e()
  {
    this(SYm);
  }
  
  protected e(Object paramObject)
  {
    this.SYl = paramObject;
  }
  
  public d Rs()
  {
    throw new AbstractMethodError();
  }
  
  public final Object ag(Object... paramVarArgs)
  {
    return hxS().ag(paramVarArgs);
  }
  
  public final Object cx(Map paramMap)
  {
    return hxS().cx(paramMap);
  }
  
  public String getName()
  {
    throw new AbstractMethodError();
  }
  
  public final List<j> getParameters()
  {
    return hxS().getParameters();
  }
  
  public String getSignature()
  {
    throw new AbstractMethodError();
  }
  
  protected abstract a hxP();
  
  public final Object hxQ()
  {
    return this.SYl;
  }
  
  public final a hxR()
  {
    a locala2 = this.SYk;
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = hxP();
      this.SYk = locala1;
    }
    return locala1;
  }
  
  protected a hxS()
  {
    a locala = hxR();
    if (locala == this) {
      throw new b();
    }
    return locala;
  }
  
  static final class a
    implements Serializable
  {
    private static final a SYn;
    
    static
    {
      AppMethodBeat.i(128955);
      SYn = new a();
      AppMethodBeat.o(128955);
    }
    
    private Object readResolve()
    {
      return SYn;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.g.b.e
 * JD-Core Version:    0.7.0.1
 */