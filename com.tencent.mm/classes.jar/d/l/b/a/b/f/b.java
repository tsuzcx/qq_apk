package d.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static final b Lzi;
  public final c Lzj;
  private transient b Lzk;
  
  static
  {
    AppMethodBeat.i(59295);
    Lzi = new b("");
    AppMethodBeat.o(59295);
  }
  
  public b(c paramc)
  {
    AppMethodBeat.i(59281);
    this.Lzj = paramc;
    AppMethodBeat.o(59281);
  }
  
  private b(c paramc, b paramb)
  {
    AppMethodBeat.i(59282);
    this.Lzj = paramc;
    this.Lzk = paramb;
    AppMethodBeat.o(59282);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(59280);
    this.Lzj = new c(paramString, this);
    AppMethodBeat.o(59280);
  }
  
  public static b r(f paramf)
  {
    AppMethodBeat.i(59291);
    if (paramf == null) {
      agL(13);
    }
    paramf = new b(c.t(paramf));
    AppMethodBeat.o(59291);
    return paramf;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(59293);
    if (this == paramObject)
    {
      AppMethodBeat.o(59293);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(59293);
      return false;
    }
    paramObject = (b)paramObject;
    if (!this.Lzj.equals(paramObject.Lzj))
    {
      AppMethodBeat.o(59293);
      return false;
    }
    AppMethodBeat.o(59293);
    return true;
  }
  
  public final c fZG()
  {
    AppMethodBeat.i(59284);
    c localc = this.Lzj;
    if (localc == null) {
      agL(5);
    }
    AppMethodBeat.o(59284);
    return localc;
  }
  
  public final b fZH()
  {
    AppMethodBeat.i(59286);
    if (this.Lzk != null)
    {
      localObject = this.Lzk;
      if (localObject == null) {
        agL(6);
      }
      AppMethodBeat.o(59286);
      return localObject;
    }
    if (isRoot())
    {
      localObject = new IllegalStateException("root");
      AppMethodBeat.o(59286);
      throw ((Throwable)localObject);
    }
    this.Lzk = new b(this.Lzj.fZM());
    Object localObject = this.Lzk;
    if (localObject == null) {
      agL(7);
    }
    AppMethodBeat.o(59286);
    return localObject;
  }
  
  public final f fZI()
  {
    AppMethodBeat.i(59288);
    f localf = this.Lzj.fZI();
    if (localf == null) {
      agL(9);
    }
    AppMethodBeat.o(59288);
    return localf;
  }
  
  public final f fZJ()
  {
    AppMethodBeat.i(59289);
    f localf = this.Lzj.fZJ();
    if (localf == null) {
      agL(10);
    }
    AppMethodBeat.o(59289);
    return localf;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59294);
    int i = this.Lzj.hashCode();
    AppMethodBeat.o(59294);
    return i;
  }
  
  public final boolean isRoot()
  {
    AppMethodBeat.i(210237);
    boolean bool = this.Lzj.Lzo.isEmpty();
    AppMethodBeat.o(210237);
    return bool;
  }
  
  public final b p(f paramf)
  {
    AppMethodBeat.i(59287);
    if (paramf == null) {
      agL(8);
    }
    paramf = new b(this.Lzj.s(paramf), this);
    AppMethodBeat.o(59287);
    return paramf;
  }
  
  public final boolean q(f paramf)
  {
    AppMethodBeat.i(59290);
    if (paramf == null) {
      agL(12);
    }
    boolean bool = this.Lzj.q(paramf);
    AppMethodBeat.o(59290);
    return bool;
  }
  
  public final String rf()
  {
    AppMethodBeat.i(59283);
    String str = this.Lzj.rf();
    if (str == null) {
      agL(4);
    }
    AppMethodBeat.o(59283);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59292);
    String str = this.Lzj.toString();
    AppMethodBeat.o(59292);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.f.b
 * JD-Core Version:    0.7.0.1
 */