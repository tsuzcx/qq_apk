package d.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.f;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import java.util.Map;

public final class e
{
  public static final e NFO;
  public static final e NFP;
  public static final e NFQ;
  public static final a NFR;
  private final f NFJ;
  public final g NFK;
  public final g NFL;
  public final Map<String, g> NFM;
  public final boolean NFN;
  
  static
  {
    AppMethodBeat.i(61364);
    NFR = new a((byte)0);
    NFO = new e(g.NFV, null, ae.emptyMap(), (byte)0);
    g localg = g.NFU;
    NFP = new e(localg, localg, ae.emptyMap(), (byte)0);
    localg = g.NFW;
    NFQ = new e(localg, localg, ae.emptyMap(), (byte)0);
    AppMethodBeat.o(61364);
  }
  
  private e(g paramg1, g paramg2, Map<String, ? extends g> paramMap)
  {
    AppMethodBeat.i(61365);
    this.NFK = paramg1;
    this.NFL = paramg2;
    this.NFM = paramMap;
    this.NFN = true;
    this.NFJ = d.g.O((a)new b(this));
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
        if ((!p.i(this.NFK, paramObject.NFK)) || (!p.i(this.NFL, paramObject.NFL)) || (!p.i(this.NFM, paramObject.NFM)) || (this.NFN != paramObject.NFN)) {}
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
  
  public final boolean guo()
  {
    return (e)this == NFP;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(61366);
    String str = "Jsr305State(global=" + this.NFK + ", migration=" + this.NFL + ", user=" + this.NFM + ", enableCompatqualCheckerFrameworkAnnotations=" + this.NFN + ")";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.o.e
 * JD-Core Version:    0.7.0.1
 */