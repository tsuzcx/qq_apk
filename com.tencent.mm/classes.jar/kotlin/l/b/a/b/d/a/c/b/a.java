package kotlin.l.b.a.b.d.a.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.d.a.a.k;
import kotlin.l.b.a.b.m.al;

public final class a
{
  final k aiTX;
  final b aiTY;
  final boolean aiTZ;
  final Set<ba> aiUa;
  final al aiUb;
  
  private a(k paramk, b paramb, boolean paramBoolean, Set<? extends ba> paramSet, al paramal)
  {
    AppMethodBeat.i(192136);
    this.aiTX = paramk;
    this.aiTY = paramb;
    this.aiTZ = paramBoolean;
    this.aiUa = paramSet;
    this.aiUb = paramal;
    AppMethodBeat.o(192136);
  }
  
  private static a a(k paramk, b paramb, boolean paramBoolean, Set<? extends ba> paramSet, al paramal)
  {
    AppMethodBeat.i(192145);
    s.u(paramk, "howThisTypeIsUsed");
    s.u(paramb, "flexibility");
    paramk = new a(paramk, paramb, paramBoolean, paramSet, paramal);
    AppMethodBeat.o(192145);
    return paramk;
  }
  
  public final a a(b paramb)
  {
    AppMethodBeat.i(57948);
    s.u(paramb, "flexibility");
    paramb = a(this, null, paramb, false, null, null, 29);
    AppMethodBeat.o(57948);
    return paramb;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(57953);
    if (this == paramObject)
    {
      AppMethodBeat.o(57953);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(57953);
      return false;
    }
    paramObject = (a)paramObject;
    if (this.aiTX != paramObject.aiTX)
    {
      AppMethodBeat.o(57953);
      return false;
    }
    if (this.aiTY != paramObject.aiTY)
    {
      AppMethodBeat.o(57953);
      return false;
    }
    if (this.aiTZ != paramObject.aiTZ)
    {
      AppMethodBeat.o(57953);
      return false;
    }
    if (!s.p(this.aiUa, paramObject.aiUa))
    {
      AppMethodBeat.o(57953);
      return false;
    }
    if (!s.p(this.aiUb, paramObject.aiUb))
    {
      AppMethodBeat.o(57953);
      return false;
    }
    AppMethodBeat.o(57953);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57951);
    String str = "JavaTypeAttributes(howThisTypeIsUsed=" + this.aiTX + ", flexibility=" + this.aiTY + ", isForAnnotationParameter=" + this.aiTZ + ", visitedTypeParameters=" + this.aiUa + ", defaultType=" + this.aiUb + ')';
    AppMethodBeat.o(57951);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.b.a
 * JD-Core Version:    0.7.0.1
 */