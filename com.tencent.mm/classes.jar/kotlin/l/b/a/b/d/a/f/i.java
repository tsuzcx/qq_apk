package kotlin.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;

public final class i
{
  public final h aiVa;
  final boolean aiVb;
  
  public i(h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(58040);
    this.aiVa = paramh;
    this.aiVb = paramBoolean;
    AppMethodBeat.o(58040);
  }
  
  private static i a(h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(58041);
    s.u(paramh, "qualifier");
    paramh = new i(paramh, paramBoolean);
    AppMethodBeat.o(58041);
    return paramh;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(58045);
    if (this == paramObject)
    {
      AppMethodBeat.o(58045);
      return true;
    }
    if (!(paramObject instanceof i))
    {
      AppMethodBeat.o(58045);
      return false;
    }
    paramObject = (i)paramObject;
    if (this.aiVa != paramObject.aiVa)
    {
      AppMethodBeat.o(58045);
      return false;
    }
    if (this.aiVb != paramObject.aiVb)
    {
      AppMethodBeat.o(58045);
      return false;
    }
    AppMethodBeat.o(58045);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58043);
    String str = "NullabilityQualifierWithMigrationStatus(qualifier=" + this.aiVa + ", isForWarningOnly=" + this.aiVb + ')';
    AppMethodBeat.o(58043);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.f.i
 * JD-Core Version:    0.7.0.1
 */