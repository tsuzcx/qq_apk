package kotlin.l.b.a.b.j.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.m.al;

public final class c
  implements d, g
{
  private final e aiHo;
  private final e ajlA;
  private final c ajlz;
  
  public c(e parame)
  {
    AppMethodBeat.i(60257);
    this.aiHo = parame;
    this.ajlz = this;
    this.ajlA = this.aiHo;
    AppMethodBeat.o(60257);
  }
  
  private al kso()
  {
    AppMethodBeat.i(60252);
    al localal = this.aiHo.koj();
    s.s(localal, "classDescriptor.defaultType");
    AppMethodBeat.o(60252);
    return localal;
  }
  
  public final boolean equals(Object paramObject)
  {
    Object localObject = null;
    AppMethodBeat.i(60254);
    e locale = this.aiHo;
    if ((paramObject instanceof c))
    {
      paramObject = (c)paramObject;
      if (paramObject != null) {
        break label50;
      }
    }
    label50:
    for (paramObject = localObject;; paramObject = paramObject.aiHo)
    {
      boolean bool = s.p(locale, paramObject);
      AppMethodBeat.o(60254);
      return bool;
      paramObject = null;
      break;
    }
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(60255);
    int i = this.aiHo.hashCode();
    AppMethodBeat.o(60255);
    return i;
  }
  
  public final e kpn()
  {
    return this.aiHo;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60256);
    String str = "Class{" + kso() + '}';
    AppMethodBeat.o(60256);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.g.a.c
 * JD-Core Version:    0.7.0.1
 */