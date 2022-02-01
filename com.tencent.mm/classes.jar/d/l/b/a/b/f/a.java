package d.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.n.n;

public final class a
{
  public final boolean ELj;
  private final b MSS;
  private final b Nqe;
  
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
    this.MSS = paramb1;
    if ((!$assertionsDisabled) && (paramb2.Nqg.Nql.isEmpty()))
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
    this.Nqe = paramb2;
    this.ELj = paramBoolean;
    AppMethodBeat.o(59263);
  }
  
  public a(b paramb, f paramf)
  {
    this(paramb, b.r(paramf), false);
    AppMethodBeat.i(59264);
    AppMethodBeat.o(59264);
  }
  
  public static a bcD(String paramString)
  {
    AppMethodBeat.i(59272);
    paramString = du(paramString, false);
    AppMethodBeat.o(59272);
    return paramString;
  }
  
  public static a du(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(59273);
    if (paramString == null) {
      ajm(12);
    }
    String str = n.nE(paramString, "").replace('/', '.');
    paramString = n.b(paramString, '/', paramString);
    paramString = new a(new b(str), new b(paramString), paramBoolean);
    AppMethodBeat.o(59273);
    return paramString;
  }
  
  public static a p(b paramb)
  {
    AppMethodBeat.i(59262);
    if (paramb == null) {
      ajm(0);
    }
    paramb = new a(paramb.grg(), paramb.grh());
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
    if ((this.MSS.equals(paramObject.MSS)) && (this.Nqe.equals(paramObject.Nqe)) && (this.ELj == paramObject.ELj))
    {
      AppMethodBeat.o(59275);
      return true;
    }
    AppMethodBeat.o(59275);
    return false;
  }
  
  public final b gqZ()
  {
    AppMethodBeat.i(59265);
    b localb = this.MSS;
    if (localb == null) {
      ajm(5);
    }
    AppMethodBeat.o(59265);
    return localb;
  }
  
  public final b gra()
  {
    AppMethodBeat.i(59266);
    b localb = this.Nqe;
    if (localb == null) {
      ajm(6);
    }
    AppMethodBeat.o(59266);
    return localb;
  }
  
  public final f grb()
  {
    AppMethodBeat.i(59267);
    f localf = this.Nqe.grh();
    if (localf == null) {
      ajm(7);
    }
    AppMethodBeat.o(59267);
    return localf;
  }
  
  public final a grc()
  {
    AppMethodBeat.i(59269);
    Object localObject = this.Nqe.grg();
    if (((b)localObject).Nqg.Nql.isEmpty())
    {
      AppMethodBeat.o(59269);
      return null;
    }
    localObject = new a(gqZ(), (b)localObject, this.ELj);
    AppMethodBeat.o(59269);
    return localObject;
  }
  
  public final boolean grd()
  {
    AppMethodBeat.i(59270);
    if (!this.Nqe.grg().Nqg.Nql.isEmpty())
    {
      AppMethodBeat.o(59270);
      return true;
    }
    AppMethodBeat.o(59270);
    return false;
  }
  
  public final b gre()
  {
    AppMethodBeat.i(59271);
    if (this.MSS.Nqg.Nql.isEmpty())
    {
      localb = this.Nqe;
      if (localb == null) {
        ajm(9);
      }
      AppMethodBeat.o(59271);
      return localb;
    }
    b localb = new b(this.MSS.sD() + "." + this.Nqe.sD());
    AppMethodBeat.o(59271);
    return localb;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59276);
    int i = this.MSS.hashCode();
    int j = this.Nqe.hashCode();
    int k = Boolean.valueOf(this.ELj).hashCode();
    AppMethodBeat.o(59276);
    return (i * 31 + j) * 31 + k;
  }
  
  public final a o(f paramf)
  {
    AppMethodBeat.i(59268);
    if (paramf == null) {
      ajm(8);
    }
    paramf = new a(gqZ(), this.Nqe.p(paramf), this.ELj);
    AppMethodBeat.o(59268);
    return paramf;
  }
  
  public final String sD()
  {
    AppMethodBeat.i(59274);
    if (this.MSS.Nqg.Nql.isEmpty())
    {
      str = this.Nqe.sD();
      if (str == null) {
        ajm(13);
      }
      AppMethodBeat.o(59274);
      return str;
    }
    String str = this.MSS.sD().replace('.', '/') + "/" + this.Nqe.sD();
    if (str == null) {
      ajm(14);
    }
    AppMethodBeat.o(59274);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59277);
    if (this.MSS.Nqg.Nql.isEmpty())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.f.a
 * JD-Core Version:    0.7.0.1
 */