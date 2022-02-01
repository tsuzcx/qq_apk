package d.l.b.a.b.j.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.b.e;
import d.l.b.a.b.m.aj;

public final class c
  implements d, g
{
  private final c NVs;
  private final e NVt;
  private final e NrX;
  
  public c(e parame)
  {
    AppMethodBeat.i(60257);
    this.NrX = parame;
    this.NVs = this;
    this.NVt = this.NrX;
    AppMethodBeat.o(60257);
  }
  
  private aj gql()
  {
    AppMethodBeat.i(60252);
    aj localaj = this.NrX.gne();
    p.g(localaj, "classDescriptor.defaultType");
    AppMethodBeat.o(60252);
    return localaj;
  }
  
  public final boolean equals(Object paramObject)
  {
    Object localObject = null;
    AppMethodBeat.i(60254);
    e locale = this.NrX;
    if (!(paramObject instanceof c)) {
      paramObject = null;
    }
    for (;;)
    {
      c localc = (c)paramObject;
      paramObject = localObject;
      if (localc != null) {
        paramObject = localc.NrX;
      }
      boolean bool = p.i(locale, paramObject);
      AppMethodBeat.o(60254);
      return bool;
    }
  }
  
  public final e gnV()
  {
    return this.NrX;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(60255);
    int i = this.NrX.hashCode();
    AppMethodBeat.o(60255);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60256);
    String str = "Class{" + gql() + '}';
    AppMethodBeat.o(60256);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.j.f.a.c
 * JD-Core Version:    0.7.0.1
 */