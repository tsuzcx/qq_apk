package d.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static final b JLP;
  public final c JLQ;
  private transient b JLR;
  
  static
  {
    AppMethodBeat.i(59295);
    JLP = new b("");
    AppMethodBeat.o(59295);
  }
  
  public b(c paramc)
  {
    AppMethodBeat.i(59281);
    this.JLQ = paramc;
    AppMethodBeat.o(59281);
  }
  
  private b(c paramc, b paramb)
  {
    AppMethodBeat.i(59282);
    this.JLQ = paramc;
    this.JLR = paramb;
    AppMethodBeat.o(59282);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(59280);
    this.JLQ = new c(paramString, this);
    AppMethodBeat.o(59280);
  }
  
  public static b r(f paramf)
  {
    AppMethodBeat.i(59291);
    if (paramf == null) {
      adP(13);
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
    if (!this.JLQ.equals(paramObject.JLQ))
    {
      AppMethodBeat.o(59293);
      return false;
    }
    AppMethodBeat.o(59293);
    return true;
  }
  
  public final c fHc()
  {
    AppMethodBeat.i(59284);
    c localc = this.JLQ;
    if (localc == null) {
      adP(5);
    }
    AppMethodBeat.o(59284);
    return localc;
  }
  
  public final b fHd()
  {
    AppMethodBeat.i(59286);
    if (this.JLR != null)
    {
      localObject = this.JLR;
      if (localObject == null) {
        adP(6);
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
    this.JLR = new b(this.JLQ.fHi());
    Object localObject = this.JLR;
    if (localObject == null) {
      adP(7);
    }
    AppMethodBeat.o(59286);
    return localObject;
  }
  
  public final f fHe()
  {
    AppMethodBeat.i(59288);
    f localf = this.JLQ.fHe();
    if (localf == null) {
      adP(9);
    }
    AppMethodBeat.o(59288);
    return localf;
  }
  
  public final f fHf()
  {
    AppMethodBeat.i(59289);
    f localf = this.JLQ.fHf();
    if (localf == null) {
      adP(10);
    }
    AppMethodBeat.o(59289);
    return localf;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59294);
    int i = this.JLQ.hashCode();
    AppMethodBeat.o(59294);
    return i;
  }
  
  public final boolean isRoot()
  {
    AppMethodBeat.i(202321);
    boolean bool = this.JLQ.JLV.isEmpty();
    AppMethodBeat.o(202321);
    return bool;
  }
  
  public final b p(f paramf)
  {
    AppMethodBeat.i(59287);
    if (paramf == null) {
      adP(8);
    }
    paramf = new b(this.JLQ.s(paramf), this);
    AppMethodBeat.o(59287);
    return paramf;
  }
  
  public final boolean q(f paramf)
  {
    AppMethodBeat.i(59290);
    if (paramf == null) {
      adP(12);
    }
    boolean bool = this.JLQ.q(paramf);
    AppMethodBeat.o(59290);
    return bool;
  }
  
  public final String qV()
  {
    AppMethodBeat.i(59283);
    String str = this.JLQ.qV();
    if (str == null) {
      adP(4);
    }
    AppMethodBeat.o(59283);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59292);
    String str = this.JLQ.toString();
    AppMethodBeat.o(59292);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.f.b
 * JD-Core Version:    0.7.0.1
 */