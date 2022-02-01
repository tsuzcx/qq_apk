package d.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static final b NNl;
  public final c NNm;
  private transient b NNn;
  
  static
  {
    AppMethodBeat.i(59295);
    NNl = new b("");
    AppMethodBeat.o(59295);
  }
  
  public b(c paramc)
  {
    AppMethodBeat.i(59281);
    this.NNm = paramc;
    AppMethodBeat.o(59281);
  }
  
  private b(c paramc, b paramb)
  {
    AppMethodBeat.i(59282);
    this.NNm = paramc;
    this.NNn = paramb;
    AppMethodBeat.o(59282);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(59280);
    this.NNm = new c(paramString, this);
    AppMethodBeat.o(59280);
  }
  
  public static b r(f paramf)
  {
    AppMethodBeat.i(59291);
    if (paramf == null) {
      ajW(13);
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
    if (!this.NNm.equals(paramObject.NNm))
    {
      AppMethodBeat.o(59293);
      return false;
    }
    AppMethodBeat.o(59293);
    return true;
  }
  
  public final c gvH()
  {
    AppMethodBeat.i(59284);
    c localc = this.NNm;
    if (localc == null) {
      ajW(5);
    }
    AppMethodBeat.o(59284);
    return localc;
  }
  
  public final b gvI()
  {
    AppMethodBeat.i(59286);
    if (this.NNn != null)
    {
      localObject = this.NNn;
      if (localObject == null) {
        ajW(6);
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
    this.NNn = new b(this.NNm.gvN());
    Object localObject = this.NNn;
    if (localObject == null) {
      ajW(7);
    }
    AppMethodBeat.o(59286);
    return localObject;
  }
  
  public final f gvJ()
  {
    AppMethodBeat.i(59288);
    f localf = this.NNm.gvJ();
    if (localf == null) {
      ajW(9);
    }
    AppMethodBeat.o(59288);
    return localf;
  }
  
  public final f gvK()
  {
    AppMethodBeat.i(59289);
    f localf = this.NNm.gvK();
    if (localf == null) {
      ajW(10);
    }
    AppMethodBeat.o(59289);
    return localf;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59294);
    int i = this.NNm.hashCode();
    AppMethodBeat.o(59294);
    return i;
  }
  
  public final boolean isRoot()
  {
    AppMethodBeat.i(224206);
    boolean bool = this.NNm.NNr.isEmpty();
    AppMethodBeat.o(224206);
    return bool;
  }
  
  public final b p(f paramf)
  {
    AppMethodBeat.i(59287);
    if (paramf == null) {
      ajW(8);
    }
    paramf = new b(this.NNm.s(paramf), this);
    AppMethodBeat.o(59287);
    return paramf;
  }
  
  public final boolean q(f paramf)
  {
    AppMethodBeat.i(59290);
    if (paramf == null) {
      ajW(12);
    }
    boolean bool = this.NNm.q(paramf);
    AppMethodBeat.o(59290);
    return bool;
  }
  
  public final String sD()
  {
    AppMethodBeat.i(59283);
    String str = this.NNm.sD();
    if (str == null) {
      ajW(4);
    }
    AppMethodBeat.o(59283);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59292);
    String str = this.NNm.toString();
    AppMethodBeat.o(59292);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.f.b
 * JD-Core Version:    0.7.0.1
 */