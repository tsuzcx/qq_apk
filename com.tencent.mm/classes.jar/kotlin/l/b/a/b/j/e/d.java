package kotlin.l.b.a.b.j.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.b.a.b.f.b;
import kotlin.l.b.a.b.f.c;

public final class d
{
  private c aiIl;
  private final String aiWW;
  
  private d(String paramString)
  {
    AppMethodBeat.i(60168);
    this.aiWW = paramString;
    AppMethodBeat.o(60168);
  }
  
  public static d bJp(String paramString)
  {
    AppMethodBeat.i(60165);
    if (paramString == null) {
      aKu(0);
    }
    paramString = new d(paramString);
    AppMethodBeat.o(60165);
    return paramString;
  }
  
  public static d g(b paramb)
  {
    AppMethodBeat.i(60166);
    if (paramb == null) {
      aKu(1);
    }
    c localc = paramb.kxL();
    paramb = paramb.kxM().PF().replace('.', '$');
    if (localc.isRoot())
    {
      paramb = new d(paramb);
      AppMethodBeat.o(60166);
      return paramb;
    }
    paramb = new d(localc.PF().replace('.', '/') + "/" + paramb);
    AppMethodBeat.o(60166);
    return paramb;
  }
  
  public static d t(c paramc)
  {
    AppMethodBeat.i(60167);
    if (paramc == null) {
      aKu(2);
    }
    d locald = new d(paramc.PF().replace('.', '/'));
    locald.aiIl = paramc;
    AppMethodBeat.o(60167);
    return locald;
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
    boolean bool = this.aiWW.equals(((d)paramObject).aiWW);
    AppMethodBeat.o(60172);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(60173);
    int i = this.aiWW.hashCode();
    AppMethodBeat.o(60173);
    return i;
  }
  
  public final c kxL()
  {
    AppMethodBeat.i(60170);
    int i = this.aiWW.lastIndexOf("/");
    if (i == -1)
    {
      localc = c.ajew;
      if (localc == null) {
        aKu(7);
      }
      AppMethodBeat.o(60170);
      return localc;
    }
    c localc = new c(this.aiWW.substring(0, i).replace('/', '.'));
    AppMethodBeat.o(60170);
    return localc;
  }
  
  public final c kzq()
  {
    AppMethodBeat.i(60169);
    c localc = new c(this.aiWW.replace('/', '.'));
    AppMethodBeat.o(60169);
    return localc;
  }
  
  public final String kzr()
  {
    AppMethodBeat.i(60171);
    String str = this.aiWW;
    if (str == null) {
      aKu(8);
    }
    AppMethodBeat.o(60171);
    return str;
  }
  
  public final String toString()
  {
    return this.aiWW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.e.d
 * JD-Core Version:    0.7.0.1
 */