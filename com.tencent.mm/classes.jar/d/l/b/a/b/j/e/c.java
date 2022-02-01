package d.l.b.a.b.j.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.f.a;
import d.l.b.a.b.f.b;

public final class c
{
  private b MVU;
  public final String NiZ;
  
  private c(String paramString)
  {
    AppMethodBeat.i(60168);
    this.NiZ = paramString;
    AppMethodBeat.o(60168);
  }
  
  public static c bcQ(String paramString)
  {
    AppMethodBeat.i(60165);
    if (paramString == null) {
      ajm(0);
    }
    paramString = new c(paramString);
    AppMethodBeat.o(60165);
    return paramString;
  }
  
  public static c e(a parama)
  {
    AppMethodBeat.i(60166);
    if (parama == null) {
      ajm(1);
    }
    b localb = parama.gqZ();
    parama = parama.gra().sD().replace('.', '$');
    if (localb.isRoot())
    {
      parama = new c(parama);
      AppMethodBeat.o(60166);
      return parama;
    }
    parama = new c(localb.sD().replace('.', '/') + "/" + parama);
    AppMethodBeat.o(60166);
    return parama;
  }
  
  public static c q(b paramb)
  {
    AppMethodBeat.i(60167);
    if (paramb == null) {
      ajm(2);
    }
    c localc = new c(paramb.sD().replace('.', '/'));
    localc.MVU = paramb;
    AppMethodBeat.o(60167);
    return localc;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(60172);
    if (this == paramObject)
    {
      AppMethodBeat.o(60172);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(60172);
      return false;
    }
    boolean bool = this.NiZ.equals(((c)paramObject).NiZ);
    AppMethodBeat.o(60172);
    return bool;
  }
  
  public final b gqZ()
  {
    AppMethodBeat.i(60170);
    int i = this.NiZ.lastIndexOf("/");
    if (i == -1)
    {
      localb = b.Nqf;
      if (localb == null) {
        ajm(7);
      }
      AppMethodBeat.o(60170);
      return localb;
    }
    b localb = new b(this.NiZ.substring(0, i).replace('/', '.'));
    AppMethodBeat.o(60170);
    return localb;
  }
  
  public final String gtd()
  {
    AppMethodBeat.i(60171);
    String str = this.NiZ;
    if (str == null) {
      ajm(8);
    }
    AppMethodBeat.o(60171);
    return str;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(60173);
    int i = this.NiZ.hashCode();
    AppMethodBeat.o(60173);
    return i;
  }
  
  public final String toString()
  {
    return this.NiZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.e.c
 * JD-Core Version:    0.7.0.1
 */