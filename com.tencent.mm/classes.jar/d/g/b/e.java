package d.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b;
import d.l.a;
import d.l.d;
import d.l.j;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract class e
  implements a, Serializable
{
  public static final Object MLB = ;
  protected final Object MLA;
  private transient a MLz;
  
  public e()
  {
    this(MLB);
  }
  
  protected e(Object paramObject)
  {
    this.MLA = paramObject;
  }
  
  public String Hu()
  {
    throw new AbstractMethodError();
  }
  
  public d Hv()
  {
    throw new AbstractMethodError();
  }
  
  public final Object af(Object... paramVarArgs)
  {
    return gfR().af(paramVarArgs);
  }
  
  public final Object cf(Map paramMap)
  {
    return gfR().cf(paramMap);
  }
  
  public String getName()
  {
    throw new AbstractMethodError();
  }
  
  public final List<j> getParameters()
  {
    return gfR().getParameters();
  }
  
  protected abstract a gfO();
  
  public final Object gfP()
  {
    return this.MLA;
  }
  
  public final a gfQ()
  {
    a locala2 = this.MLz;
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = gfO();
      this.MLz = locala1;
    }
    return locala1;
  }
  
  protected a gfR()
  {
    a locala = gfQ();
    if (locala == this) {
      throw new b();
    }
    return locala;
  }
  
  static final class a
    implements Serializable
  {
    private static final a MLC;
    
    static
    {
      AppMethodBeat.i(128955);
      MLC = new a();
      AppMethodBeat.o(128955);
    }
    
    private Object readResolve()
    {
      return MLC;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.g.b.e
 * JD-Core Version:    0.7.0.1
 */