package kotlin.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static final b TCQ;
  public final c TCR;
  private transient b TCS;
  
  static
  {
    AppMethodBeat.i(59295);
    TCQ = new b("");
    AppMethodBeat.o(59295);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(59280);
    this.TCR = new c(paramString, this);
    AppMethodBeat.o(59280);
  }
  
  public b(c paramc)
  {
    AppMethodBeat.i(59281);
    this.TCR = paramc;
    AppMethodBeat.o(59281);
  }
  
  private b(c paramc, b paramb)
  {
    AppMethodBeat.i(59282);
    this.TCR = paramc;
    this.TCS = paramb;
    AppMethodBeat.o(59282);
  }
  
  public static b r(f paramf)
  {
    AppMethodBeat.i(59291);
    if (paramf == null) {
      atM(13);
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
    if (!this.TCR.equals(paramObject.TCR))
    {
      AppMethodBeat.o(59293);
      return false;
    }
    AppMethodBeat.o(59293);
    return true;
  }
  
  public final c hJe()
  {
    AppMethodBeat.i(59284);
    c localc = this.TCR;
    if (localc == null) {
      atM(5);
    }
    AppMethodBeat.o(59284);
    return localc;
  }
  
  public final b hJf()
  {
    AppMethodBeat.i(59286);
    if (this.TCS != null)
    {
      localObject = this.TCS;
      if (localObject == null) {
        atM(6);
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
    this.TCS = new b(this.TCR.hJk());
    Object localObject = this.TCS;
    if (localObject == null) {
      atM(7);
    }
    AppMethodBeat.o(59286);
    return localObject;
  }
  
  public final f hJg()
  {
    AppMethodBeat.i(59288);
    f localf = this.TCR.hJg();
    if (localf == null) {
      atM(9);
    }
    AppMethodBeat.o(59288);
    return localf;
  }
  
  public final f hJh()
  {
    AppMethodBeat.i(59289);
    f localf = this.TCR.hJh();
    if (localf == null) {
      atM(10);
    }
    AppMethodBeat.o(59289);
    return localf;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59294);
    int i = this.TCR.hashCode();
    AppMethodBeat.o(59294);
    return i;
  }
  
  public final boolean isRoot()
  {
    AppMethodBeat.i(258515);
    boolean bool = this.TCR.TCW.isEmpty();
    AppMethodBeat.o(258515);
    return bool;
  }
  
  public final b p(f paramf)
  {
    AppMethodBeat.i(59287);
    if (paramf == null) {
      atM(8);
    }
    paramf = new b(this.TCR.s(paramf), this);
    AppMethodBeat.o(59287);
    return paramf;
  }
  
  public final boolean q(f paramf)
  {
    AppMethodBeat.i(59290);
    if (paramf == null) {
      atM(12);
    }
    boolean bool = this.TCR.q(paramf);
    AppMethodBeat.o(59290);
    return bool;
  }
  
  public final String sG()
  {
    AppMethodBeat.i(59283);
    String str = this.TCR.sG();
    if (str == null) {
      atM(4);
    }
    AppMethodBeat.o(59283);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59292);
    String str = this.TCR.toString();
    AppMethodBeat.o(59292);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.f.b
 * JD-Core Version:    0.7.0.1
 */