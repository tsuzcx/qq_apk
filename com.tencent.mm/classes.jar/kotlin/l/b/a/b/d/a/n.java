package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import kotlin.g.b.s;
import kotlin.l.b.a.b.d.a.f.i;

public final class n
{
  public final i aiOM;
  public final Collection<a> aiON;
  public final boolean aiOO;
  public final boolean aiOP;
  
  public n(i parami, Collection<? extends a> paramCollection, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(192006);
    this.aiOM = parami;
    this.aiON = paramCollection;
    this.aiOO = paramBoolean1;
    this.aiOP = paramBoolean2;
    AppMethodBeat.o(192006);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(192034);
    if (this == paramObject)
    {
      AppMethodBeat.o(192034);
      return true;
    }
    if (!(paramObject instanceof n))
    {
      AppMethodBeat.o(192034);
      return false;
    }
    paramObject = (n)paramObject;
    if (!s.p(this.aiOM, paramObject.aiOM))
    {
      AppMethodBeat.o(192034);
      return false;
    }
    if (!s.p(this.aiON, paramObject.aiON))
    {
      AppMethodBeat.o(192034);
      return false;
    }
    if (this.aiOO != paramObject.aiOO)
    {
      AppMethodBeat.o(192034);
      return false;
    }
    if (this.aiOP != paramObject.aiOP)
    {
      AppMethodBeat.o(192034);
      return false;
    }
    AppMethodBeat.o(192034);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(192022);
    String str = "JavaDefaultQualifiers(nullabilityQualifier=" + this.aiOM + ", qualifierApplicabilityTypes=" + this.aiON + ", affectsTypeParameterBasedTypes=" + this.aiOO + ", affectsStarProjection=" + this.aiOP + ')';
    AppMethodBeat.o(192022);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.n
 * JD-Core Version:    0.7.0.1
 */