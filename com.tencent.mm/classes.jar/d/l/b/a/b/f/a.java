package d.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.n.n;

public final class a
{
  public final boolean BOl;
  private final b JLO;
  private final b JoE;
  
  static
  {
    AppMethodBeat.i(59278);
    if (!a.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(59278);
      return;
    }
  }
  
  public a(b paramb1, b paramb2, boolean paramBoolean)
  {
    AppMethodBeat.i(59263);
    this.JoE = paramb1;
    if ((!$assertionsDisabled) && (paramb2.JLQ.JLV.isEmpty()))
    {
      paramb2 = new StringBuilder("Class name must not be root: ").append(paramb1);
      if (paramBoolean) {}
      for (paramb1 = " (local)";; paramb1 = "")
      {
        paramb1 = new AssertionError(paramb1);
        AppMethodBeat.o(59263);
        throw paramb1;
      }
    }
    this.JLO = paramb2;
    this.BOl = paramBoolean;
    AppMethodBeat.o(59263);
  }
  
  public a(b paramb, f paramf)
  {
    this(paramb, b.r(paramf), false);
    AppMethodBeat.i(59264);
    AppMethodBeat.o(59264);
  }
  
  public static a aQB(String paramString)
  {
    AppMethodBeat.i(59272);
    paramString = dk(paramString, false);
    AppMethodBeat.o(59272);
    return paramString;
  }
  
  public static a dk(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(59273);
    if (paramString == null) {
      adP(12);
    }
    String str = n.mG(paramString, "").replace('/', '.');
    paramString = n.a(paramString, '/', paramString);
    paramString = new a(new b(str), new b(paramString), paramBoolean);
    AppMethodBeat.o(59273);
    return paramString;
  }
  
  public static a p(b paramb)
  {
    AppMethodBeat.i(59262);
    if (paramb == null) {
      adP(0);
    }
    paramb = new a(paramb.fHd(), paramb.fHe());
    AppMethodBeat.o(59262);
    return paramb;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(59275);
    if (this == paramObject)
    {
      AppMethodBeat.o(59275);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(59275);
      return false;
    }
    paramObject = (a)paramObject;
    if ((this.JoE.equals(paramObject.JoE)) && (this.JLO.equals(paramObject.JLO)) && (this.BOl == paramObject.BOl))
    {
      AppMethodBeat.o(59275);
      return true;
    }
    AppMethodBeat.o(59275);
    return false;
  }
  
  public final b fGW()
  {
    AppMethodBeat.i(59265);
    b localb = this.JoE;
    if (localb == null) {
      adP(5);
    }
    AppMethodBeat.o(59265);
    return localb;
  }
  
  public final b fGX()
  {
    AppMethodBeat.i(59266);
    b localb = this.JLO;
    if (localb == null) {
      adP(6);
    }
    AppMethodBeat.o(59266);
    return localb;
  }
  
  public final f fGY()
  {
    AppMethodBeat.i(59267);
    f localf = this.JLO.fHe();
    if (localf == null) {
      adP(7);
    }
    AppMethodBeat.o(59267);
    return localf;
  }
  
  public final a fGZ()
  {
    AppMethodBeat.i(59269);
    Object localObject = this.JLO.fHd();
    if (((b)localObject).JLQ.JLV.isEmpty())
    {
      AppMethodBeat.o(59269);
      return null;
    }
    localObject = new a(fGW(), (b)localObject, this.BOl);
    AppMethodBeat.o(59269);
    return localObject;
  }
  
  public final boolean fHa()
  {
    AppMethodBeat.i(59270);
    if (!this.JLO.fHd().JLQ.JLV.isEmpty())
    {
      AppMethodBeat.o(59270);
      return true;
    }
    AppMethodBeat.o(59270);
    return false;
  }
  
  public final b fHb()
  {
    AppMethodBeat.i(59271);
    if (this.JoE.JLQ.JLV.isEmpty())
    {
      localb = this.JLO;
      if (localb == null) {
        adP(9);
      }
      AppMethodBeat.o(59271);
      return localb;
    }
    b localb = new b(this.JoE.qV() + "." + this.JLO.qV());
    AppMethodBeat.o(59271);
    return localb;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59276);
    int i = this.JoE.hashCode();
    int j = this.JLO.hashCode();
    int k = Boolean.valueOf(this.BOl).hashCode();
    AppMethodBeat.o(59276);
    return (i * 31 + j) * 31 + k;
  }
  
  public final a o(f paramf)
  {
    AppMethodBeat.i(59268);
    if (paramf == null) {
      adP(8);
    }
    paramf = new a(fGW(), this.JLO.p(paramf), this.BOl);
    AppMethodBeat.o(59268);
    return paramf;
  }
  
  public final String qV()
  {
    AppMethodBeat.i(59274);
    if (this.JoE.JLQ.JLV.isEmpty())
    {
      str = this.JLO.qV();
      if (str == null) {
        adP(13);
      }
      AppMethodBeat.o(59274);
      return str;
    }
    String str = this.JoE.qV().replace('.', '/') + "/" + this.JLO.qV();
    if (str == null) {
      adP(14);
    }
    AppMethodBeat.o(59274);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59277);
    if (this.JoE.JLQ.JLV.isEmpty())
    {
      str = "/" + qV();
      AppMethodBeat.o(59277);
      return str;
    }
    String str = qV();
    AppMethodBeat.o(59277);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.f.a
 * JD-Core Version:    0.7.0.1
 */