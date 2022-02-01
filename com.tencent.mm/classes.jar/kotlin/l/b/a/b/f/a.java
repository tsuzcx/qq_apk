package kotlin.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.n.n;

public final class a
{
  public final boolean BPb;
  private final b TCO;
  private final b TfF;
  
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
    this.TfF = paramb1;
    if ((!$assertionsDisabled) && (paramb2.TCR.TCW.isEmpty()))
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
    this.TCO = paramb2;
    this.BPb = paramBoolean;
    AppMethodBeat.o(59263);
  }
  
  public a(b paramb, f paramf)
  {
    this(paramb, b.r(paramf), false);
    AppMethodBeat.i(59264);
    AppMethodBeat.o(59264);
  }
  
  public static a btX(String paramString)
  {
    AppMethodBeat.i(59272);
    paramString = dT(paramString, false);
    AppMethodBeat.o(59272);
    return paramString;
  }
  
  public static a dT(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(59273);
    if (paramString == null) {
      atM(12);
    }
    String str = n.oC(paramString, "").replace('/', '.');
    paramString = n.b(paramString, '/', paramString);
    paramString = new a(new b(str), new b(paramString), paramBoolean);
    AppMethodBeat.o(59273);
    return paramString;
  }
  
  public static a p(b paramb)
  {
    AppMethodBeat.i(59262);
    if (paramb == null) {
      atM(0);
    }
    paramb = new a(paramb.hJf(), paramb.hJg());
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
    if ((this.TfF.equals(paramObject.TfF)) && (this.TCO.equals(paramObject.TCO)) && (this.BPb == paramObject.BPb))
    {
      AppMethodBeat.o(59275);
      return true;
    }
    AppMethodBeat.o(59275);
    return false;
  }
  
  public final b hIY()
  {
    AppMethodBeat.i(59265);
    b localb = this.TfF;
    if (localb == null) {
      atM(5);
    }
    AppMethodBeat.o(59265);
    return localb;
  }
  
  public final b hIZ()
  {
    AppMethodBeat.i(59266);
    b localb = this.TCO;
    if (localb == null) {
      atM(6);
    }
    AppMethodBeat.o(59266);
    return localb;
  }
  
  public final f hJa()
  {
    AppMethodBeat.i(59267);
    f localf = this.TCO.hJg();
    if (localf == null) {
      atM(7);
    }
    AppMethodBeat.o(59267);
    return localf;
  }
  
  public final a hJb()
  {
    AppMethodBeat.i(59269);
    Object localObject = this.TCO.hJf();
    if (((b)localObject).TCR.TCW.isEmpty())
    {
      AppMethodBeat.o(59269);
      return null;
    }
    localObject = new a(hIY(), (b)localObject, this.BPb);
    AppMethodBeat.o(59269);
    return localObject;
  }
  
  public final boolean hJc()
  {
    AppMethodBeat.i(59270);
    if (!this.TCO.hJf().TCR.TCW.isEmpty())
    {
      AppMethodBeat.o(59270);
      return true;
    }
    AppMethodBeat.o(59270);
    return false;
  }
  
  public final b hJd()
  {
    AppMethodBeat.i(59271);
    if (this.TfF.TCR.TCW.isEmpty())
    {
      localb = this.TCO;
      if (localb == null) {
        atM(9);
      }
      AppMethodBeat.o(59271);
      return localb;
    }
    b localb = new b(this.TfF.sG() + "." + this.TCO.sG());
    AppMethodBeat.o(59271);
    return localb;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(59276);
    int i = this.TfF.hashCode();
    int j = this.TCO.hashCode();
    int k = Boolean.valueOf(this.BPb).hashCode();
    AppMethodBeat.o(59276);
    return (i * 31 + j) * 31 + k;
  }
  
  public final a o(f paramf)
  {
    AppMethodBeat.i(59268);
    if (paramf == null) {
      atM(8);
    }
    paramf = new a(hIY(), this.TCO.p(paramf), this.BPb);
    AppMethodBeat.o(59268);
    return paramf;
  }
  
  public final String sG()
  {
    AppMethodBeat.i(59274);
    if (this.TfF.TCR.TCW.isEmpty())
    {
      str = this.TCO.sG();
      if (str == null) {
        atM(13);
      }
      AppMethodBeat.o(59274);
      return str;
    }
    String str = this.TfF.sG().replace('.', '/') + "/" + this.TCO.sG();
    if (str == null) {
      atM(14);
    }
    AppMethodBeat.o(59274);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59277);
    if (this.TfF.TCR.TCW.isEmpty())
    {
      str = "/" + sG();
      AppMethodBeat.o(59277);
      return str;
    }
    String str = sG();
    AppMethodBeat.o(59277);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.f.a
 * JD-Core Version:    0.7.0.1
 */