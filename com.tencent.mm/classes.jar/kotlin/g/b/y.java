package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.d;
import kotlin.l.m.a;

public final class y
  extends x
{
  private final d SYA;
  private final String name;
  private final String signature;
  
  public y(d paramd, String paramString1, String paramString2)
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
    AppMethodBeat.i(128971);
    paramObject = hye().ag(new Object[] { paramObject });
    AppMethodBeat.o(128971);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlin.g.b.y
 * JD-Core Version:    0.7.0.1
 */