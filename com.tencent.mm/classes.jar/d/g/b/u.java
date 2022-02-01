package d.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.d;
import d.l.m.a;

public final class u
  extends t
{
  private final d KUK;
  private final String name;
  private final String signature;
  
  public u(d paramd, String paramString1, String paramString2)
  {
    this.KUK = paramd;
    this.name = paramString1;
    this.signature = paramString2;
  }
  
  public final String FZ()
  {
    return this.signature;
  }
  
  public final d Ga()
  {
    return this.KUK;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(128971);
    paramObject = fOz().ae(new Object[] { paramObject });
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