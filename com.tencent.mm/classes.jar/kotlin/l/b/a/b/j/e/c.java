package kotlin.l.b.a.b.j.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.f.a;
import kotlin.l.b.a.b.f.b;

public final class c
{
  private b TiI;
  public final String TvL;
  
  private c(String paramString)
  {
    AppMethodBeat.i(60168);
    this.TvL = paramString;
    AppMethodBeat.o(60168);
  }
  
  public static c buj(String paramString)
  {
    AppMethodBeat.i(60165);
    if (paramString == null) {
      atM(0);
    }
    paramString = new c(paramString);
    AppMethodBeat.o(60165);
    return paramString;
  }
  
  public static c e(a parama)
  {
    AppMethodBeat.i(60166);
    if (parama == null) {
      atM(1);
    }
    b localb = parama.hIY();
    parama = parama.hIZ().sG().replace('.', '$');
    if (localb.isRoot())
    {
      parama = new c(parama);
      AppMethodBeat.o(60166);
      return parama;
    }
    parama = new c(localb.sG().replace('.', '/') + "/" + parama);
    AppMethodBeat.o(60166);
    return parama;
  }
  
  public static c q(b paramb)
  {
    AppMethodBeat.i(60167);
    if (paramb == null) {
      atM(2);
    }
    c localc = new c(paramb.sG().replace('.', '/'));
    localc.TiI = paramb;
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
    boolean bool = this.TvL.equals(((c)paramObject).TvL);
    AppMethodBeat.o(60172);
    return bool;
  }
  
  public final b hIY()
  {
    AppMethodBeat.i(60170);
    int i = this.TvL.lastIndexOf("/");
    if (i == -1)
    {
      localb = b.TCQ;
      if (localb == null) {
        atM(7);
      }
      AppMethodBeat.o(60170);
      return localb;
    }
    b localb = new b(this.TvL.substring(0, i).replace('/', '.'));
    AppMethodBeat.o(60170);
    return localb;
  }
  
  public final String hKI()
  {
    AppMethodBeat.i(60171);
    String str = this.TvL;
    if (str == null) {
      atM(8);
    }
    AppMethodBeat.o(60171);
    return str;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(60173);
    int i = this.TvL.hashCode();
    AppMethodBeat.o(60173);
    return i;
  }
  
  public final String toString()
  {
    return this.TvL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.j.e.c
 * JD-Core Version:    0.7.0.1
 */