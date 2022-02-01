package kotlin.l.b.a.b.j.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.m.aj;

public final class c
  implements d, g
{
  private final c TKo;
  private final e TKp;
  private final e ThF;
  
  public c(e parame)
  {
    AppMethodBeat.i(60257);
    this.ThF = parame;
    this.TKo = this;
    this.TKp = this.ThF;
    AppMethodBeat.o(60257);
  }
  
  private aj hDN()
  {
    AppMethodBeat.i(60252);
    aj localaj = this.ThF.hAG();
    p.g(localaj, "classDescriptor.defaultType");
    AppMethodBeat.o(60252);
    return localaj;
  }
  
  public final boolean equals(Object paramObject)
  {
    Object localObject = null;
    AppMethodBeat.i(60254);
    e locale = this.ThF;
    if (!(paramObject instanceof c)) {
      paramObject = null;
    }
    for (;;)
    {
      c localc = (c)paramObject;
      paramObject = localObject;
      if (localc != null) {
        paramObject = localc.ThF;
      }
      boolean bool = p.j(locale, paramObject);
      AppMethodBeat.o(60254);
      return bool;
    }
  }
  
  public final e hBx()
  {
    return this.ThF;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(60255);
    int i = this.ThF.hashCode();
    AppMethodBeat.o(60255);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60256);
    String str = "Class{" + hDN() + '}';
    AppMethodBeat.o(60256);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.j.f.a.c
 * JD-Core Version:    0.7.0.1
 */