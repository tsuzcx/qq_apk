package kotlin.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.a.ae;
import kotlin.f;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;

public final class e
{
  public static final e TRO;
  public static final e TRP;
  public static final e TRQ;
  public static final a TRR;
  private final f TRJ;
  public final g TRK;
  public final g TRL;
  public final Map<String, g> TRM;
  public final boolean TRN;
  
  static
  {
    AppMethodBeat.i(61364);
    TRR = new a((byte)0);
    TRO = new e(g.TRV, null, ae.emptyMap(), (byte)0);
    g localg = g.TRU;
    TRP = new e(localg, localg, ae.emptyMap(), (byte)0);
    localg = g.TRW;
    TRQ = new e(localg, localg, ae.emptyMap(), (byte)0);
    AppMethodBeat.o(61364);
  }
  
  private e(g paramg1, g paramg2, Map<String, ? extends g> paramMap)
  {
    AppMethodBeat.i(61365);
    this.TRK = paramg1;
    this.TRL = paramg2;
    this.TRM = paramMap;
    this.TRN = true;
    this.TRJ = kotlin.g.ah((a)new b(this));
    AppMethodBeat.o(61365);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(61368);
    if (this != paramObject)
    {
      if ((paramObject instanceof e))
      {
        paramObject = (e)paramObject;
        if ((!p.j(this.TRK, paramObject.TRK)) || (!p.j(this.TRL, paramObject.TRL)) || (!p.j(this.TRM, paramObject.TRM)) || (this.TRN != paramObject.TRN)) {}
      }
    }
    else
    {
      AppMethodBeat.o(61368);
      return true;
    }
    AppMethodBeat.o(61368);
    return false;
  }
  
  public final boolean hLT()
  {
    return (e)this == TRP;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(61366);
    String str = "Jsr305State(global=" + this.TRK + ", migration=" + this.TRL + ", user=" + this.TRM + ", enableCompatqualCheckerFrameworkAnnotations=" + this.TRN + ")";
    AppMethodBeat.o(61366);
    return str;
  }
  
  public static final class a {}
  
  static final class b
    extends q
    implements a<String[]>
  {
    b(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.o.e
 * JD-Core Version:    0.7.0.1
 */