package kotlin.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static final b abfD;
  public final c abfE;
  private transient b abfF;
  
  static
  {
    AppMethodBeat.i(59295);
    abfD = new b("");
    AppMethodBeat.o(59295);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(59280);
    this.abfE = new c(paramString, this);
    AppMethodBeat.o(59280);
  }
  
  public b(c paramc)
  {
    AppMethodBeat.i(59281);
    this.abfE = paramc;
    AppMethodBeat.o(59281);
  }
  
  private b(c paramc, b paramb)
  {
    AppMethodBeat.i(59282);
    this.abfE = paramc;
    this.abfF = paramb;
    AppMethodBeat.o(59282);
  }
  
  public static b r(f paramf)
  {
    AppMethodBeat.i(59291);
    if (paramf == null) {
      aDG(13);
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
    if (!this.abfE.equals(paramObject.abfE))
    {
      AppMethodBeat.o(59293);
      return false;
    }
    AppMethodBeat.o(59293);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59294);
    int i = this.abfE.hashCode();
    AppMethodBeat.o(59294);
    return i;
  }
  
  public final f iNA()
  {
    AppMethodBeat.i(59288);
    f localf = this.abfE.iNA();
    if (localf == null) {
      aDG(9);
    }
    AppMethodBeat.o(59288);
    return localf;
  }
  
  public final f iNB()
  {
    AppMethodBeat.i(59289);
    f localf = this.abfE.iNB();
    if (localf == null) {
      aDG(10);
    }
    AppMethodBeat.o(59289);
    return localf;
  }
  
  public final c iNy()
  {
    AppMethodBeat.i(59284);
    c localc = this.abfE;
    if (localc == null) {
      aDG(5);
    }
    AppMethodBeat.o(59284);
    return localc;
  }
  
  public final b iNz()
  {
    AppMethodBeat.i(59286);
    if (this.abfF != null)
    {
      localObject = this.abfF;
      if (localObject == null) {
        aDG(6);
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
    this.abfF = new b(this.abfE.iNE());
    Object localObject = this.abfF;
    if (localObject == null) {
      aDG(7);
    }
    AppMethodBeat.o(59286);
    return localObject;
  }
  
  public final boolean isRoot()
  {
    AppMethodBeat.i(293022);
    boolean bool = this.abfE.abfJ.isEmpty();
    AppMethodBeat.o(293022);
    return bool;
  }
  
  public final b p(f paramf)
  {
    AppMethodBeat.i(59287);
    if (paramf == null) {
      aDG(8);
    }
    paramf = new b(this.abfE.s(paramf), this);
    AppMethodBeat.o(59287);
    return paramf;
  }
  
  public final boolean q(f paramf)
  {
    AppMethodBeat.i(59290);
    if (paramf == null) {
      aDG(12);
    }
    boolean bool = this.abfE.q(paramf);
    AppMethodBeat.o(59290);
    return bool;
  }
  
  public final String qu()
  {
    AppMethodBeat.i(59283);
    String str = this.abfE.qu();
    if (str == null) {
      aDG(4);
    }
    AppMethodBeat.o(59283);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59292);
    String str = this.abfE.toString();
    AppMethodBeat.o(59292);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.f.b
 * JD-Core Version:    0.7.0.1
 */