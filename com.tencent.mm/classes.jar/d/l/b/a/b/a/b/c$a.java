package d.l.b.a.b.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.f.a;

public final class c$a
{
  public final a JoZ;
  final a Jpa;
  final a Jpb;
  
  public c$a(a parama1, a parama2, a parama3)
  {
    AppMethodBeat.i(56749);
    this.JoZ = parama1;
    this.Jpa = parama2;
    this.Jpb = parama3;
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
        if ((!k.g(this.JoZ, paramObject.JoZ)) || (!k.g(this.Jpa, paramObject.Jpa)) || (!k.g(this.Jpb, paramObject.Jpb))) {}
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
    a locala = this.JoZ;
    int i;
    if (locala != null)
    {
      i = locala.hashCode();
      locala = this.Jpa;
      if (locala == null) {
        break label80;
      }
    }
    label80:
    for (int j = locala.hashCode();; j = 0)
    {
      locala = this.Jpb;
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
    String str = "PlatformMutabilityMapping(javaClass=" + this.JoZ + ", kotlinReadOnly=" + this.Jpa + ", kotlinMutable=" + this.Jpb + ")";
    AppMethodBeat.o(56750);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     d.l.b.a.b.a.b.c.a
 * JD-Core Version:    0.7.0.1
 */