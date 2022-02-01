package d.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.n.n;

public final class a
{
  public final boolean FdH;
  private final b NNk;
  private final b NpX;
  
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
    this.NpX = paramb1;
    if ((!$assertionsDisabled) && (paramb2.NNm.NNr.isEmpty()))
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
    this.NNk = paramb2;
    this.FdH = paramBoolean;
    AppMethodBeat.o(59263);
  }
  
  public a(b paramb, f paramf)
  {
    this(paramb, b.r(paramf), false);
    AppMethodBeat.i(59264);
    AppMethodBeat.o(59264);
  }
  
  public static a beh(String paramString)
  {
    AppMethodBeat.i(59272);
    paramString = dx(paramString, false);
    AppMethodBeat.o(59272);
    return paramString;
  }
  
  public static a dx(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(59273);
    if (paramString == null) {
      ajW(12);
    }
    String str = n.nK(paramString, "").replace('/', '.');
    paramString = n.b(paramString, '/', paramString);
    paramString = new a(new b(str), new b(paramString), paramBoolean);
    AppMethodBeat.o(59273);
    return paramString;
  }
  
  public static a p(b paramb)
  {
    AppMethodBeat.i(59262);
    if (paramb == null) {
      ajW(0);
    }
    paramb = new a(paramb.gvI(), paramb.gvJ());
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
    if ((this.NpX.equals(paramObject.NpX)) && (this.NNk.equals(paramObject.NNk)) && (this.FdH == paramObject.FdH))
    {
      AppMethodBeat.o(59275);
      return true;
    }
    AppMethodBeat.o(59275);
    return false;
  }
  
  public final b gvB()
  {
    AppMethodBeat.i(59265);
    b localb = this.NpX;
    if (localb == null) {
      ajW(5);
    }
    AppMethodBeat.o(59265);
    return localb;
  }
  
  public final b gvC()
  {
    AppMethodBeat.i(59266);
    b localb = this.NNk;
    if (localb == null) {
      ajW(6);
    }
    AppMethodBeat.o(59266);
    return localb;
  }
  
  public final f gvD()
  {
    AppMethodBeat.i(59267);
    f localf = this.NNk.gvJ();
    if (localf == null) {
      ajW(7);
    }
    AppMethodBeat.o(59267);
    return localf;
  }
  
  public final a gvE()
  {
    AppMethodBeat.i(59269);
    Object localObject = this.NNk.gvI();
    if (((b)localObject).NNm.NNr.isEmpty())
    {
      AppMethodBeat.o(59269);
      return null;
    }
    localObject = new a(gvB(), (b)localObject, this.FdH);
    AppMethodBeat.o(59269);
    return localObject;
  }
  
  public final boolean gvF()
  {
    AppMethodBeat.i(59270);
    if (!this.NNk.gvI().NNm.NNr.isEmpty())
    {
      AppMethodBeat.o(59270);
      return true;
    }
    AppMethodBeat.o(59270);
    return false;
  }
  
  public final b gvG()
  {
    AppMethodBeat.i(59271);
    if (this.NpX.NNm.NNr.isEmpty())
    {
      localb = this.NNk;
      if (localb == null) {
        ajW(9);
      }
      AppMethodBeat.o(59271);
      return localb;
    }
    b localb = new b(this.NpX.sD() + "." + this.NNk.sD());
    AppMethodBeat.o(59271);
    return localb;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59276);
    int i = this.NpX.hashCode();
    int j = this.NNk.hashCode();
    int k = Boolean.valueOf(this.FdH).hashCode();
    AppMethodBeat.o(59276);
    return (i * 31 + j) * 31 + k;
  }
  
  public final a o(f paramf)
  {
    AppMethodBeat.i(59268);
    if (paramf == null) {
      ajW(8);
    }
    paramf = new a(gvB(), this.NNk.p(paramf), this.FdH);
    AppMethodBeat.o(59268);
    return paramf;
  }
  
  public final String sD()
  {
    AppMethodBeat.i(59274);
    if (this.NpX.NNm.NNr.isEmpty())
    {
      str = this.NNk.sD();
      if (str == null) {
        ajW(13);
      }
      AppMethodBeat.o(59274);
      return str;
    }
    String str = this.NpX.sD().replace('.', '/') + "/" + this.NNk.sD();
    if (str == null) {
      ajW(14);
    }
    AppMethodBeat.o(59274);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59277);
    if (this.NpX.NNm.NNr.isEmpty())
    {
      str = "/" + sD();
      AppMethodBeat.o(59277);
      return str;
    }
    String str = sD();
    AppMethodBeat.o(59277);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.f.a
 * JD-Core Version:    0.7.0.1
 */