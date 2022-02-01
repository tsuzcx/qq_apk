package d.l.b.a.b.j.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.b.e;
import d.l.b.a.b.m.aj;

public final class c
  implements d, g
{
  private final c LHn;
  private final e LHo;
  private final e LdX;
  
  public c(e parame)
  {
    AppMethodBeat.i(60257);
    this.LdX = parame;
    this.LHn = this;
    this.LHo = this.LdX;
    AppMethodBeat.o(60257);
  }
  
  private aj fUk()
  {
    AppMethodBeat.i(60252);
    aj localaj = this.LdX.fRe();
    k.g(localaj, "classDescriptor.defaultType");
    AppMethodBeat.o(60252);
    return localaj;
  }
  
  public final boolean equals(Object paramObject)
  {
    Object localObject = null;
    AppMethodBeat.i(60254);
    e locale = this.LdX;
    if (!(paramObject instanceof c)) {
      paramObject = null;
    }
    for (;;)
    {
      c localc = (c)paramObject;
      paramObject = localObject;
      if (localc != null) {
        paramObject = localc.LdX;
      }
      boolean bool = k.g(locale, paramObject);
      AppMethodBeat.o(60254);
      return bool;
    }
  }
  
  public final e fRU()
  {
    return this.LdX;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(60255);
    int i = this.LdX.hashCode();
    AppMethodBeat.o(60255);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60256);
    String str = "Class{" + fUk() + '}';
    AppMethodBeat.o(60256);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.f.a.c
 * JD-Core Version:    0.7.0.1
 */