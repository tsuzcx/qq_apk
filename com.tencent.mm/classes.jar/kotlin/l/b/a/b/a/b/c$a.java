package kotlin.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.f.a;

public final class c$a
{
  public final a Tga;
  final a Tgb;
  final a Tgc;
  
  public c$a(a parama1, a parama2, a parama3)
  {
    AppMethodBeat.i(56749);
    this.Tga = parama1;
    this.Tgb = parama2;
    this.Tgc = parama3;
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
        if ((!p.j(this.Tga, paramObject.Tga)) || (!p.j(this.Tgb, paramObject.Tgb)) || (!p.j(this.Tgc, paramObject.Tgc))) {}
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
    a locala = this.Tga;
    int i;
    if (locala != null)
    {
      i = locala.hashCode();
      locala = this.Tgb;
      if (locala == null) {
        break label80;
      }
    }
    label80:
    for (int j = locala.hashCode();; j = 0)
    {
      locala = this.Tgc;
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
    String str = "PlatformMutabilityMapping(javaClass=" + this.Tga + ", kotlinReadOnly=" + this.Tgb + ", kotlinMutable=" + this.Tgc + ")";
    AppMethodBeat.o(56750);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlin.l.b.a.b.a.b.c.a
 * JD-Core Version:    0.7.0.1
 */