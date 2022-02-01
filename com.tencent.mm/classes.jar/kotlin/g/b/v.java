package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.d;
import kotlin.l.h.a;
import kotlin.l.m.a;

public final class v
  extends u
{
  private final d SYA;
  private final String name;
  private final String signature;
  
  public v(d paramd, String paramString1, String paramString2)
  {
    this.SYA = paramd;
    this.name = paramString1;
    this.signature = paramString2;
  }
  
  public final d Rs()
  {
    return this.SYA;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(128952);
    paramObject = hye().ag(new Object[] { paramObject });
    AppMethodBeat.o(128952);
    return paramObject;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final String getSignature()
  {
    return this.signature;
  }
  
  public final void set(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(128953);
    hyf().ag(new Object[] { paramObject1, paramObject2 });
    AppMethodBeat.o(128953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.g.b.v
 * JD-Core Version:    0.7.0.1
 */