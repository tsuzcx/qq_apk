package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.n.n;

public final class i<T>
{
  private int LrT;
  private T LrU;
  private final l<T> LrV;
  
  public final void fUH()
  {
    if (this.LrU == null) {
      this.LrT += 1;
    }
  }
  
  public final void fi(T paramT)
  {
    AppMethodBeat.i(58197);
    k.h(paramT, "objectType");
    fj(paramT);
    AppMethodBeat.o(58197);
  }
  
  final void fj(T paramT)
  {
    AppMethodBeat.i(58198);
    k.h(paramT, "type");
    if (this.LrU == null)
    {
      Object localObject = paramT;
      if (this.LrT > 0) {
        localObject = this.LrV.aWp(n.r((CharSequence)"[", this.LrT) + this.LrV.toString(paramT));
      }
      this.LrU = localObject;
    }
    AppMethodBeat.o(58198);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.b.i
 * JD-Core Version:    0.7.0.1
 */