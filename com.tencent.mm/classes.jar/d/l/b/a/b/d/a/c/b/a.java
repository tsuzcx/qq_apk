package d.l.b.a.b.d.a.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.b.as;
import d.l.b.a.b.d.a.a.l;

public final class a
{
  final l NDu;
  final b NDv;
  final boolean NDw;
  final as NDx;
  
  private a(l paraml, b paramb, boolean paramBoolean, as paramas)
  {
    AppMethodBeat.i(57949);
    this.NDu = paraml;
    this.NDv = paramb;
    this.NDw = paramBoolean;
    this.NDx = paramas;
    AppMethodBeat.o(57949);
  }
  
  public final a a(b paramb)
  {
    AppMethodBeat.i(57948);
    p.h(paramb, "flexibility");
    l locall = this.NDu;
    boolean bool = this.NDw;
    as localas = this.NDx;
    p.h(locall, "howThisTypeIsUsed");
    p.h(paramb, "flexibility");
    paramb = new a(locall, paramb, bool, localas);
    AppMethodBeat.o(57948);
    return paramb;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(57953);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.i(this.NDu, paramObject.NDu)) || (!p.i(this.NDv, paramObject.NDv)) || (this.NDw != paramObject.NDw) || (!p.i(this.NDx, paramObject.NDx))) {}
      }
    }
    else
    {
      AppMethodBeat.o(57953);
      return true;
    }
    AppMethodBeat.o(57953);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57951);
    String str = "JavaTypeAttributes(howThisTypeIsUsed=" + this.NDu + ", flexibility=" + this.NDv + ", isForAnnotationParameter=" + this.NDw + ", upperBoundOfTypeParameter=" + this.NDx + ")";
    AppMethodBeat.o(57951);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.b.a
 * JD-Core Version:    0.7.0.1
 */