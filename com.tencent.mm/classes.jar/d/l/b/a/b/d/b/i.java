package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.n.n;

public final class i<T>
{
  private int JEA;
  private T JEB;
  private final l<T> JEC;
  
  public final void fCd()
  {
    if (this.JEB == null) {
      this.JEA += 1;
    }
  }
  
  public final void ff(T paramT)
  {
    AppMethodBeat.i(58197);
    k.h(paramT, "objectType");
    fg(paramT);
    AppMethodBeat.o(58197);
  }
  
  final void fg(T paramT)
  {
    AppMethodBeat.i(58198);
    k.h(paramT, "type");
    if (this.JEB == null)
    {
      Object localObject = paramT;
      if (this.JEA > 0) {
        localObject = this.JEC.aQq(n.s((CharSequence)"[", this.JEA) + this.JEC.toString(paramT));
      }
      this.JEB = localObject;
    }
    AppMethodBeat.o(58198);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.b.i
 * JD-Core Version:    0.7.0.1
 */