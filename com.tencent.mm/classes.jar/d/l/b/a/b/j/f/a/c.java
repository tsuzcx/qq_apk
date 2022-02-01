package d.l.b.a.b.j.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.b.e;
import d.l.b.a.b.m.aj;

public final class c
  implements d, g
{
  private final c JTU;
  private final e JTV;
  private final e JqE;
  
  public c(e parame)
  {
    AppMethodBeat.i(60257);
    this.JqE = parame;
    this.JTU = this;
    this.JTV = this.JqE;
    AppMethodBeat.o(60257);
  }
  
  private aj fBG()
  {
    AppMethodBeat.i(60252);
    aj localaj = this.JqE.fyA();
    k.g(localaj, "classDescriptor.defaultType");
    AppMethodBeat.o(60252);
    return localaj;
  }
  
  public final boolean equals(Object paramObject)
  {
    Object localObject = null;
    AppMethodBeat.i(60254);
    e locale = this.JqE;
    if (!(paramObject instanceof c)) {
      paramObject = null;
    }
    for (;;)
    {
      c localc = (c)paramObject;
      paramObject = localObject;
      if (localc != null) {
        paramObject = localc.JqE;
      }
      boolean bool = k.g(locale, paramObject);
      AppMethodBeat.o(60254);
      return bool;
    }
  }
  
  public final e fzq()
  {
    return this.JqE;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(60255);
    int i = this.JqE.hashCode();
    AppMethodBeat.o(60255);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60256);
    String str = "Class{" + fBG() + '}';
    AppMethodBeat.o(60256);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.f.a.c
 * JD-Core Version:    0.7.0.1
 */