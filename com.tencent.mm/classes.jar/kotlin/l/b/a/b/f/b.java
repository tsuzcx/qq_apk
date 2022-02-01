package kotlin.l.b.a.b.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public final boolean NIH;
  private final c aiEI;
  private final c ajev;
  
  static
  {
    AppMethodBeat.i(59278);
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(59278);
      return;
    }
  }
  
  public b(c paramc1, c paramc2, boolean paramBoolean)
  {
    AppMethodBeat.i(59263);
    this.aiEI = paramc1;
    if ((!$assertionsDisabled) && (paramc2.ajex.ajeC.isEmpty()))
    {
      paramc2 = new StringBuilder("Class name must not be root: ").append(paramc1);
      if (paramBoolean) {}
      for (paramc1 = " (local)";; paramc1 = "")
      {
        paramc1 = new AssertionError(paramc1);
        AppMethodBeat.o(59263);
        throw paramc1;
      }
    }
    this.ajev = paramc2;
    this.NIH = paramBoolean;
    AppMethodBeat.o(59263);
  }
  
  public b(c paramc, f paramf)
  {
    this(paramc, c.s(paramf), false);
    AppMethodBeat.i(59264);
    AppMethodBeat.o(59264);
  }
  
  public static b bJd(String paramString)
  {
    AppMethodBeat.i(59272);
    paramString = eV(paramString, false);
    AppMethodBeat.o(59272);
    return paramString;
  }
  
  public static b eV(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(59273);
    if (paramString == null) {
      aKu(12);
    }
    int i = paramString.lastIndexOf("/");
    String str2;
    String str1;
    if (i == -1)
    {
      str2 = "";
      str1 = paramString;
      paramString = str2;
    }
    for (;;)
    {
      paramString = new b(new c(paramString), new c(str1), paramBoolean);
      AppMethodBeat.o(59273);
      return paramString;
      str1 = paramString.substring(0, i).replace('/', '.');
      str2 = paramString.substring(i + 1);
      paramString = str1;
      str1 = str2;
    }
  }
  
  public static b s(c paramc)
  {
    AppMethodBeat.i(59262);
    if (paramc == null) {
      aKu(0);
    }
    paramc = new b(paramc.kxS(), paramc.kxT());
    AppMethodBeat.o(59262);
    return paramc;
  }
  
  public final String PF()
  {
    AppMethodBeat.i(59274);
    if (this.aiEI.ajex.ajeC.isEmpty())
    {
      str = this.ajev.PF();
      if (str == null) {
        aKu(13);
      }
      AppMethodBeat.o(59274);
      return str;
    }
    String str = this.aiEI.PF().replace('.', '/') + "/" + this.ajev.PF();
    if (str == null) {
      aKu(14);
    }
    AppMethodBeat.o(59274);
    return str;
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
    paramObject = (b)paramObject;
    if ((this.aiEI.equals(paramObject.aiEI)) && (this.ajev.equals(paramObject.ajev)) && (this.NIH == paramObject.NIH))
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
    int i = this.aiEI.hashCode();
    int j = this.ajev.hashCode();
    int k = Boolean.valueOf(this.NIH).hashCode();
    AppMethodBeat.o(59276);
    return (i * 31 + j) * 31 + k;
  }
  
  public final c kxL()
  {
    AppMethodBeat.i(59265);
    c localc = this.aiEI;
    if (localc == null) {
      aKu(5);
    }
    AppMethodBeat.o(59265);
    return localc;
  }
  
  public final c kxM()
  {
    AppMethodBeat.i(59266);
    c localc = this.ajev;
    if (localc == null) {
      aKu(6);
    }
    AppMethodBeat.o(59266);
    return localc;
  }
  
  public final f kxN()
  {
    AppMethodBeat.i(59267);
    f localf = this.ajev.kxT();
    if (localf == null) {
      aKu(7);
    }
    AppMethodBeat.o(59267);
    return localf;
  }
  
  public final b kxO()
  {
    AppMethodBeat.i(59269);
    Object localObject = this.ajev.kxS();
    if (((c)localObject).ajex.ajeC.isEmpty())
    {
      AppMethodBeat.o(59269);
      return null;
    }
    localObject = new b(kxL(), (c)localObject, this.NIH);
    AppMethodBeat.o(59269);
    return localObject;
  }
  
  public final boolean kxP()
  {
    AppMethodBeat.i(59270);
    if (!this.ajev.kxS().ajex.ajeC.isEmpty())
    {
      AppMethodBeat.o(59270);
      return true;
    }
    AppMethodBeat.o(59270);
    return false;
  }
  
  public final c kxQ()
  {
    AppMethodBeat.i(59271);
    if (this.aiEI.ajex.ajeC.isEmpty())
    {
      localc = this.ajev;
      if (localc == null) {
        aKu(9);
      }
      AppMethodBeat.o(59271);
      return localc;
    }
    c localc = new c(this.aiEI.PF() + "." + this.ajev.PF());
    AppMethodBeat.o(59271);
    return localc;
  }
  
  public final b p(f paramf)
  {
    AppMethodBeat.i(59268);
    if (paramf == null) {
      aKu(8);
    }
    paramf = new b(kxL(), this.ajev.q(paramf), this.NIH);
    AppMethodBeat.o(59268);
    return paramf;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(59277);
    if (this.aiEI.ajex.ajeC.isEmpty())
    {
      str = "/" + PF();
      AppMethodBeat.o(59277);
      return str;
    }
    String str = PF();
    AppMethodBeat.o(59277);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.f.b
 * JD-Core Version:    0.7.0.1
 */