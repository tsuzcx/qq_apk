package d.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.n.n;

public final class a
{
  public final boolean Dgz;
  private final b LbX;
  private final b Lzh;
  
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
    this.LbX = paramb1;
    if ((!$assertionsDisabled) && (paramb2.Lzj.Lzo.isEmpty()))
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
    this.Lzh = paramb2;
    this.Dgz = paramBoolean;
    AppMethodBeat.o(59263);
  }
  
  public a(b paramb, f paramf)
  {
    this(paramb, b.r(paramf), false);
    AppMethodBeat.i(59264);
    AppMethodBeat.o(59264);
  }
  
  public static a aWA(String paramString)
  {
    AppMethodBeat.i(59272);
    paramString = dp(paramString, false);
    AppMethodBeat.o(59272);
    return paramString;
  }
  
  public static a dp(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(59273);
    if (paramString == null) {
      agL(12);
    }
    String str = n.ng(paramString, "").replace('/', '.');
    paramString = n.b(paramString, '/', paramString);
    paramString = new a(new b(str), new b(paramString), paramBoolean);
    AppMethodBeat.o(59273);
    return paramString;
  }
  
  public static a p(b paramb)
  {
    AppMethodBeat.i(59262);
    if (paramb == null) {
      agL(0);
    }
    paramb = new a(paramb.fZH(), paramb.fZI());
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
    if ((this.LbX.equals(paramObject.LbX)) && (this.Lzh.equals(paramObject.Lzh)) && (this.Dgz == paramObject.Dgz))
    {
      AppMethodBeat.o(59275);
      return true;
    }
    AppMethodBeat.o(59275);
    return false;
  }
  
  public final b fZA()
  {
    AppMethodBeat.i(59265);
    b localb = this.LbX;
    if (localb == null) {
      agL(5);
    }
    AppMethodBeat.o(59265);
    return localb;
  }
  
  public final b fZB()
  {
    AppMethodBeat.i(59266);
    b localb = this.Lzh;
    if (localb == null) {
      agL(6);
    }
    AppMethodBeat.o(59266);
    return localb;
  }
  
  public final f fZC()
  {
    AppMethodBeat.i(59267);
    f localf = this.Lzh.fZI();
    if (localf == null) {
      agL(7);
    }
    AppMethodBeat.o(59267);
    return localf;
  }
  
  public final a fZD()
  {
    AppMethodBeat.i(59269);
    Object localObject = this.Lzh.fZH();
    if (((b)localObject).Lzj.Lzo.isEmpty())
    {
      AppMethodBeat.o(59269);
      return null;
    }
    localObject = new a(fZA(), (b)localObject, this.Dgz);
    AppMethodBeat.o(59269);
    return localObject;
  }
  
  public final boolean fZE()
  {
    AppMethodBeat.i(59270);
    if (!this.Lzh.fZH().Lzj.Lzo.isEmpty())
    {
      AppMethodBeat.o(59270);
      return true;
    }
    AppMethodBeat.o(59270);
    return false;
  }
  
  public final b fZF()
  {
    AppMethodBeat.i(59271);
    if (this.LbX.Lzj.Lzo.isEmpty())
    {
      localb = this.Lzh;
      if (localb == null) {
        agL(9);
      }
      AppMethodBeat.o(59271);
      return localb;
    }
    b localb = new b(this.LbX.rf() + "." + this.Lzh.rf());
    AppMethodBeat.o(59271);
    return localb;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59276);
    int i = this.LbX.hashCode();
    int j = this.Lzh.hashCode();
    int k = Boolean.valueOf(this.Dgz).hashCode();
    AppMethodBeat.o(59276);
    return (i * 31 + j) * 31 + k;
  }
  
  public final a o(f paramf)
  {
    AppMethodBeat.i(59268);
    if (paramf == null) {
      agL(8);
    }
    paramf = new a(fZA(), this.Lzh.p(paramf), this.Dgz);
    AppMethodBeat.o(59268);
    return paramf;
  }
  
  public final String rf()
  {
    AppMethodBeat.i(59274);
    if (this.LbX.Lzj.Lzo.isEmpty())
    {
      str = this.Lzh.rf();
      if (str == null) {
        agL(13);
      }
      AppMethodBeat.o(59274);
      return str;
    }
    String str = this.LbX.rf().replace('.', '/') + "/" + this.Lzh.rf();
    if (str == null) {
      agL(14);
    }
    AppMethodBeat.o(59274);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59277);
    if (this.LbX.Lzj.Lzo.isEmpty())
    {
      str = "/" + rf();
      AppMethodBeat.o(59277);
      return str;
    }
    String str = rf();
    AppMethodBeat.o(59277);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.f.a
 * JD-Core Version:    0.7.0.1
 */