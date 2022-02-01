package d.l.b.a.b.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.l;
import d.l.b.a.b.b.t;
import d.l.b.a.b.f.f;
import d.n.k;
import java.util.Arrays;
import java.util.Collection;

public final class d
{
  public final k JZS;
  public final Collection<f> JZT;
  public final d.g.a.b<t, String> JZU;
  public final b[] JZV;
  public final f JsQ;
  
  private d(f paramf, k paramk, Collection<f> paramCollection, d.g.a.b<? super t, String> paramb, b... paramVarArgs)
  {
    this.JsQ = paramf;
    this.JZS = paramk;
    this.JZT = paramCollection;
    this.JZU = paramb;
    this.JZV = paramVarArgs;
  }
  
  public d(f paramf, b[] paramArrayOfb, d.g.a.b<? super t, String> paramb)
  {
    this(paramf, null, null, paramb, (b[])Arrays.copyOf(paramArrayOfb, paramArrayOfb.length));
    AppMethodBeat.i(61288);
    AppMethodBeat.o(61288);
  }
  
  private d(k paramk, b[] paramArrayOfb, d.g.a.b<? super t, String> paramb)
  {
    this(null, paramk, null, paramb, (b[])Arrays.copyOf(paramArrayOfb, paramArrayOfb.length));
    AppMethodBeat.i(61290);
    AppMethodBeat.o(61290);
  }
  
  public d(Collection<f> paramCollection, b[] paramArrayOfb, d.g.a.b<? super t, String> paramb)
  {
    this(null, null, paramCollection, paramb, (b[])Arrays.copyOf(paramArrayOfb, paramArrayOfb.length));
    AppMethodBeat.i(61292);
    AppMethodBeat.o(61292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     d.l.b.a.b.n.d
 * JD-Core Version:    0.7.0.1
 */