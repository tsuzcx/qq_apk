package d.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.d;
import d.l.m.a;

public final class x
  extends w
{
  private final d NiS;
  private final String name;
  private final String signature;
  
  public x(d paramd, String paramString1, String paramString2)
  {
    this.NiS = paramd;
    this.name = paramString1;
    this.signature = paramString2;
  }
  
  public final String HC()
  {
    return this.signature;
  }
  
  public final d HD()
  {
    return this.NiS;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(128971);
    paramObject = gkC().ae(new Object[] { paramObject });
    AppMethodBeat.o(128971);
    return paramObject;
  }
  
  public final String getName()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.g.b.x
 * JD-Core Version:    0.7.0.1
 */