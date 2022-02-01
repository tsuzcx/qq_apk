package kotlin.l.b.a.b.j.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.m.aj;

public final class c
  implements d, g
{
  private final e aaKz;
  private final c abmQ;
  private final e abmR;
  
  public c(e parame)
  {
    AppMethodBeat.i(60257);
    this.aaKz = parame;
    this.abmQ = this;
    this.abmR = this.aaKz;
    AppMethodBeat.o(60257);
  }
  
  private aj iIg()
  {
    AppMethodBeat.i(60252);
    aj localaj = this.aaKz.iET();
    p.j(localaj, "classDescriptor.defaultType");
    AppMethodBeat.o(60252);
    return localaj;
  }
  
  public final boolean equals(Object paramObject)
  {
    Object localObject = null;
    AppMethodBeat.i(60254);
    e locale = this.aaKz;
    if (!(paramObject instanceof c)) {
      paramObject = null;
    }
    for (;;)
    {
      c localc = (c)paramObject;
      paramObject = localObject;
      if (localc != null) {
        paramObject = localc.aaKz;
      }
      boolean bool = p.h(locale, paramObject);
      AppMethodBeat.o(60254);
      return bool;
    }
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(60255);
    int i = this.aaKz.hashCode();
    AppMethodBeat.o(60255);
    return i;
  }
  
  public final e iFM()
  {
    return this.aaKz;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60256);
    String str = "Class{" + iIg() + '}';
    AppMethodBeat.o(60256);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.j.f.a.c
 * JD-Core Version:    0.7.0.1
 */