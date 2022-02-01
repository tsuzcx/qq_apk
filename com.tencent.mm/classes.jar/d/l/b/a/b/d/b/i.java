package d.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.n.n;

public final class i<T>
{
  private int NiQ;
  private T NiR;
  private final l<T> NiS;
  
  public final void fk(T paramT)
  {
    AppMethodBeat.i(58197);
    p.h(paramT, "objectType");
    fl(paramT);
    AppMethodBeat.o(58197);
  }
  
  final void fl(T paramT)
  {
    AppMethodBeat.i(58198);
    p.h(paramT, "type");
    if (this.NiR == null)
    {
      Object localObject = paramT;
      if (this.NiQ > 0) {
        localObject = this.NiS.bcs(n.r((CharSequence)"[", this.NiQ) + this.NiS.toString(paramT));
      }
      this.NiR = localObject;
    }
    AppMethodBeat.o(58198);
  }
  
  public final void gmg()
  {
    if (this.NiR == null) {
      this.NiQ += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.b.i
 * JD-Core Version:    0.7.0.1
 */