package d.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.d;
import d.l.h.a;
import d.l.m.a;

public final class u
  extends t
{
  private final d MLP;
  private final String name;
  private final String signature;
  
  public u(d paramd, String paramString1, String paramString2)
  {
    this.MLP = paramd;
    this.name = paramString1;
    this.signature = paramString2;
  }
  
  public final String Hu()
  {
    return this.signature;
  }
  
  public final d Hv()
  {
    return this.MLP;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(128952);
    paramObject = gga().af(new Object[] { paramObject });
    AppMethodBeat.o(128952);
    return paramObject;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(128953);
    ggb().af(new Object[] { paramObject1, paramObject2 });
    AppMethodBeat.o(128953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.g.b.u
 * JD-Core Version:    0.7.0.1
 */