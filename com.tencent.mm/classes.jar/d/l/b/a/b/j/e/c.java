package d.l.b.a.b.j.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l.b.a.b.f.a;
import d.l.b.a.b.f.b;

public final class c
{
  private final String JEJ;
  private b JrG;
  
  private c(String paramString)
  {
    AppMethodBeat.i(60168);
    this.JEJ = paramString;
    AppMethodBeat.o(60168);
  }
  
  public static c aQO(String paramString)
  {
    AppMethodBeat.i(60165);
    if (paramString == null) {
      adP(0);
    }
    paramString = new c(paramString);
    AppMethodBeat.o(60165);
    return paramString;
  }
  
  public static c e(a parama)
  {
    AppMethodBeat.i(60166);
    if (parama == null) {
      adP(1);
    }
    b localb = parama.fGW();
    parama = parama.fGX().qV().replace('.', '$');
    if (localb.isRoot())
    {
      parama = new c(parama);
      AppMethodBeat.o(60166);
      return parama;
    }
    parama = new c(localb.qV().replace('.', '/') + "/" + parama);
    AppMethodBeat.o(60166);
    return parama;
  }
  
  public static c q(b paramb)
  {
    AppMethodBeat.i(60167);
    if (paramb == null) {
      adP(2);
    }
    c localc = new c(paramb.qV().replace('.', '/'));
    localc.JrG = paramb;
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
    boolean bool = this.JEJ.equals(((c)paramObject).JEJ);
    AppMethodBeat.o(60172);
    return bool;
  }
  
  public final b fGW()
  {
    AppMethodBeat.i(60170);
    int i = this.JEJ.lastIndexOf("/");
    if (i == -1)
    {
      localb = b.JLP;
      if (localb == null) {
        adP(7);
      }
      AppMethodBeat.o(60170);
      return localb;
    }
    b localb = new b(this.JEJ.substring(0, i).replace('/', '.'));
    AppMethodBeat.o(60170);
    return localb;
  }
  
  public final b fJa()
  {
    AppMethodBeat.i(60169);
    b localb = new b(this.JEJ.replace('/', '.'));
    AppMethodBeat.o(60169);
    return localb;
  }
  
  public final String fJb()
  {
    AppMethodBeat.i(60171);
    String str = this.JEJ;
    if (str == null) {
      adP(8);
    }
    AppMethodBeat.o(60171);
    return str;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(60173);
    int i = this.JEJ.hashCode();
    AppMethodBeat.o(60173);
    return i;
  }
  
  public final String toString()
  {
    return this.JEJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.j.e.c
 * JD-Core Version:    0.7.0.1
 */