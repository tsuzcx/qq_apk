package d.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.d;
import d.l.l.a;

public final class s
  extends r
{
  private final d KUK;
  private final String name;
  private final String signature;
  
  public s(d paramd, String paramString1, String paramString2)
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
  
  public final Object get()
  {
    AppMethodBeat.i(128936);
    Object localObject = fOC().ae(new Object[0]);
    AppMethodBeat.o(128936);
    return localObject;
  }
  
  public final String getName()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.g.b.s
 * JD-Core Version:    0.7.0.1
 */