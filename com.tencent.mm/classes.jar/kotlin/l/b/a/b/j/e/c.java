package kotlin.l.b.a.b.j.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.f.a;
import kotlin.l.b.a.b.f.b;

public final class c
{
  private b aaLC;
  public final String aaYB;
  
  private c(String paramString)
  {
    AppMethodBeat.i(60168);
    this.aaYB = paramString;
    AppMethodBeat.o(60168);
  }
  
  public static c bHl(String paramString)
  {
    AppMethodBeat.i(60165);
    if (paramString == null) {
      aDG(0);
    }
    paramString = new c(paramString);
    AppMethodBeat.o(60165);
    return paramString;
  }
  
  public static c e(a parama)
  {
    AppMethodBeat.i(60166);
    if (parama == null) {
      aDG(1);
    }
    b localb = parama.iNs();
    parama = parama.iNt().qu().replace('.', '$');
    if (localb.isRoot())
    {
      parama = new c(parama);
      AppMethodBeat.o(60166);
      return parama;
    }
    parama = new c(localb.qu().replace('.', '/') + "/" + parama);
    AppMethodBeat.o(60166);
    return parama;
  }
  
  public static c q(b paramb)
  {
    AppMethodBeat.i(60167);
    if (paramb == null) {
      aDG(2);
    }
    c localc = new c(paramb.qu().replace('.', '/'));
    localc.aaLC = paramb;
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
    boolean bool = this.aaYB.equals(((c)paramObject).aaYB);
    AppMethodBeat.o(60172);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(60173);
    int i = this.aaYB.hashCode();
    AppMethodBeat.o(60173);
    return i;
  }
  
  public final b iNs()
  {
    AppMethodBeat.i(60170);
    int i = this.aaYB.lastIndexOf("/");
    if (i == -1)
    {
      localb = b.abfD;
      if (localb == null) {
        aDG(7);
      }
      AppMethodBeat.o(60170);
      return localb;
    }
    b localb = new b(this.aaYB.substring(0, i).replace('/', '.'));
    AppMethodBeat.o(60170);
    return localb;
  }
  
  public final String iOY()
  {
    AppMethodBeat.i(60171);
    String str = this.aaYB;
    if (str == null) {
      aDG(8);
    }
    AppMethodBeat.o(60171);
    return str;
  }
  
  public final String toString()
  {
    return this.aaYB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.j.e.c
 * JD-Core Version:    0.7.0.1
 */