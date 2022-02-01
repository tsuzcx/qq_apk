package d.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.d;
import d.l.m.a;

public final class u
  extends t
{
  private final d Jhr;
  private final String name;
  private final String signature;
  
  public u(d paramd, String paramString1, String paramString2)
  {
    this.Jhr = paramd;
    this.name = paramString1;
    this.signature = paramString2;
  }
  
  public final String Gn()
  {
    return this.signature;
  }
  
  public final d Go()
  {
    return this.Jhr;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(128971);
    paramObject = fvV().ac(new Object[] { paramObject });
    AppMethodBeat.o(128971);
    return paramObject;
  }
  
  public final String getName()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.g.b.u
 * JD-Core Version:    0.7.0.1
 */