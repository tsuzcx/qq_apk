package d.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static final b Nqf;
  public final c Nqg;
  private transient b Nqh;
  
  static
  {
    AppMethodBeat.i(59295);
    Nqf = new b("");
    AppMethodBeat.o(59295);
  }
  
  public b(c paramc)
  {
    AppMethodBeat.i(59281);
    this.Nqg = paramc;
    AppMethodBeat.o(59281);
  }
  
  private b(c paramc, b paramb)
  {
    AppMethodBeat.i(59282);
    this.Nqg = paramc;
    this.Nqh = paramb;
    AppMethodBeat.o(59282);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(59280);
    this.Nqg = new c(paramString, this);
    AppMethodBeat.o(59280);
  }
  
  public static b r(f paramf)
  {
    AppMethodBeat.i(59291);
    if (paramf == null) {
      ajm(13);
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
    if (!this.Nqg.equals(paramObject.Nqg))
    {
      AppMethodBeat.o(59293);
      return false;
    }
    AppMethodBeat.o(59293);
    return true;
  }
  
  public final c grf()
  {
    AppMethodBeat.i(59284);
    c localc = this.Nqg;
    if (localc == null) {
      ajm(5);
    }
    AppMethodBeat.o(59284);
    return localc;
  }
  
  public final b grg()
  {
    AppMethodBeat.i(59286);
    if (this.Nqh != null)
    {
      localObject = this.Nqh;
      if (localObject == null) {
        ajm(6);
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
    this.Nqh = new b(this.Nqg.grl());
    Object localObject = this.Nqh;
    if (localObject == null) {
      ajm(7);
    }
    AppMethodBeat.o(59286);
    return localObject;
  }
  
  public final f grh()
  {
    AppMethodBeat.i(59288);
    f localf = this.Nqg.grh();
    if (localf == null) {
      ajm(9);
    }
    AppMethodBeat.o(59288);
    return localf;
  }
  
  public final f gri()
  {
    AppMethodBeat.i(59289);
    f localf = this.Nqg.gri();
    if (localf == null) {
      ajm(10);
    }
    AppMethodBeat.o(59289);
    return localf;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59294);
    int i = this.Nqg.hashCode();
    AppMethodBeat.o(59294);
    return i;
  }
  
  public final boolean isRoot()
  {
    AppMethodBeat.i(221693);
    boolean bool = this.Nqg.Nql.isEmpty();
    AppMethodBeat.o(221693);
    return bool;
  }
  
  public final b p(f paramf)
  {
    AppMethodBeat.i(59287);
    if (paramf == null) {
      ajm(8);
    }
    paramf = new b(this.Nqg.s(paramf), this);
    AppMethodBeat.o(59287);
    return paramf;
  }
  
  public final boolean q(f paramf)
  {
    AppMethodBeat.i(59290);
    if (paramf == null) {
      ajm(12);
    }
    boolean bool = this.Nqg.q(paramf);
    AppMethodBeat.o(59290);
    return bool;
  }
  
  public final String sD()
  {
    AppMethodBeat.i(59283);
    String str = this.Nqg.sD();
    if (str == null) {
      ajm(4);
    }
    AppMethodBeat.o(59283);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59292);
    String str = this.Nqg.toString();
    AppMethodBeat.o(59292);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.f.b
 * JD-Core Version:    0.7.0.1
 */