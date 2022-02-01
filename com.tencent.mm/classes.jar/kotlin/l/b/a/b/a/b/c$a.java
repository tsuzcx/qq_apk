package kotlin.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.f.a;

public final class c$a
{
  public final a aaIU;
  final a aaIV;
  final a aaIW;
  
  public c$a(a parama1, a parama2, a parama3)
  {
    AppMethodBeat.i(56749);
    this.aaIU = parama1;
    this.aaIV = parama2;
    this.aaIW = parama3;
    AppMethodBeat.o(56749);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56752);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.h(this.aaIU, paramObject.aaIU)) || (!p.h(this.aaIV, paramObject.aaIV)) || (!p.h(this.aaIW, paramObject.aaIW))) {}
      }
    }
    else
    {
      AppMethodBeat.o(56752);
      return true;
    }
    AppMethodBeat.o(56752);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(56751);
    a locala = this.aaIU;
    int i;
    if (locala != null)
    {
      i = locala.hashCode();
      locala = this.aaIV;
      if (locala == null) {
        break label80;
      }
    }
    label80:
    for (int j = locala.hashCode();; j = 0)
    {
      locala = this.aaIW;
      if (locala != null) {
        k = locala.hashCode();
      }
      AppMethodBeat.o(56751);
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56750);
    String str = "PlatformMutabilityMapping(javaClass=" + this.aaIU + ", kotlinReadOnly=" + this.aaIV + ", kotlinMutable=" + this.aaIW + ")";
    AppMethodBeat.o(56750);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     kotlin.l.b.a.b.a.b.c.a
 * JD-Core Version:    0.7.0.1
 */