package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.d;
import kotlin.l.r.a;

public final class z
  extends y
{
  private final d aaBw;
  private final String name;
  private final String signature;
  
  public z(d paramd, String paramString1, String paramString2)
  {
    this.aaBw = paramd;
    this.name = paramString1;
    this.signature = paramString2;
  }
  
  public final d Vc()
  {
    return this.aaBw;
  }
  
  public final Object get(Object paramObject)
  {
    AppMethodBeat.i(128971);
    paramObject = iCp().ak(new Object[] { paramObject });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.g.b.z
 * JD-Core Version:    0.7.0.1
 */