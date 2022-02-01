package kotlin.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.n.n;

public final class a
{
  public final boolean HLG;
  private final b aaIz;
  private final b abfC;
  
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
    this.aaIz = paramb1;
    if ((!$assertionsDisabled) && (paramb2.abfE.abfJ.isEmpty()))
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
    this.abfC = paramb2;
    this.HLG = paramBoolean;
    AppMethodBeat.o(59263);
  }
  
  public a(b paramb, f paramf)
  {
    this(paramb, b.r(paramf), false);
    AppMethodBeat.i(59264);
    AppMethodBeat.o(59264);
  }
  
  public static a bHa(String paramString)
  {
    AppMethodBeat.i(59272);
    paramString = eg(paramString, false);
    AppMethodBeat.o(59272);
    return paramString;
  }
  
  public static a eg(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(59273);
    if (paramString == null) {
      aDG(12);
    }
    String str = n.py(paramString, "").replace('/', '.');
    paramString = n.b(paramString, '/', paramString);
    paramString = new a(new b(str), new b(paramString), paramBoolean);
    AppMethodBeat.o(59273);
    return paramString;
  }
  
  public static a p(b paramb)
  {
    AppMethodBeat.i(59262);
    if (paramb == null) {
      aDG(0);
    }
    paramb = new a(paramb.iNz(), paramb.iNA());
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
    if ((this.aaIz.equals(paramObject.aaIz)) && (this.abfC.equals(paramObject.abfC)) && (this.HLG == paramObject.HLG))
    {
      AppMethodBeat.o(59275);
      return true;
    }
    AppMethodBeat.o(59275);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59276);
    int i = this.aaIz.hashCode();
    int j = this.abfC.hashCode();
    int k = Boolean.valueOf(this.HLG).hashCode();
    AppMethodBeat.o(59276);
    return (i * 31 + j) * 31 + k;
  }
  
  public final b iNs()
  {
    AppMethodBeat.i(59265);
    b localb = this.aaIz;
    if (localb == null) {
      aDG(5);
    }
    AppMethodBeat.o(59265);
    return localb;
  }
  
  public final b iNt()
  {
    AppMethodBeat.i(59266);
    b localb = this.abfC;
    if (localb == null) {
      aDG(6);
    }
    AppMethodBeat.o(59266);
    return localb;
  }
  
  public final f iNu()
  {
    AppMethodBeat.i(59267);
    f localf = this.abfC.iNA();
    if (localf == null) {
      aDG(7);
    }
    AppMethodBeat.o(59267);
    return localf;
  }
  
  public final a iNv()
  {
    AppMethodBeat.i(59269);
    Object localObject = this.abfC.iNz();
    if (((b)localObject).abfE.abfJ.isEmpty())
    {
      AppMethodBeat.o(59269);
      return null;
    }
    localObject = new a(iNs(), (b)localObject, this.HLG);
    AppMethodBeat.o(59269);
    return localObject;
  }
  
  public final boolean iNw()
  {
    AppMethodBeat.i(59270);
    if (!this.abfC.iNz().abfE.abfJ.isEmpty())
    {
      AppMethodBeat.o(59270);
      return true;
    }
    AppMethodBeat.o(59270);
    return false;
  }
  
  public final b iNx()
  {
    AppMethodBeat.i(59271);
    if (this.aaIz.abfE.abfJ.isEmpty())
    {
      localb = this.abfC;
      if (localb == null) {
        aDG(9);
      }
      AppMethodBeat.o(59271);
      return localb;
    }
    b localb = new b(this.aaIz.qu() + "." + this.abfC.qu());
    AppMethodBeat.o(59271);
    return localb;
  }
  
  public final a o(f paramf)
  {
    AppMethodBeat.i(59268);
    if (paramf == null) {
      aDG(8);
    }
    paramf = new a(iNs(), this.abfC.p(paramf), this.HLG);
    AppMethodBeat.o(59268);
    return paramf;
  }
  
  public final String qu()
  {
    AppMethodBeat.i(59274);
    if (this.aaIz.abfE.abfJ.isEmpty())
    {
      str = this.abfC.qu();
      if (str == null) {
        aDG(13);
      }
      AppMethodBeat.o(59274);
      return str;
    }
    String str = this.aaIz.qu().replace('.', '/') + "/" + this.abfC.qu();
    if (str == null) {
      aDG(14);
    }
    AppMethodBeat.o(59274);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59277);
    if (this.aaIz.abfE.abfJ.isEmpty())
    {
      str = "/" + qu();
      AppMethodBeat.o(59277);
      return str;
    }
    String str = qu();
    AppMethodBeat.o(59277);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.f.a
 * JD-Core Version:    0.7.0.1
 */