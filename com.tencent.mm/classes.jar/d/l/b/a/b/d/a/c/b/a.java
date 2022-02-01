package d.l.b.a.b.d.a.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.b.as;
import d.l.b.a.b.d.a.a.l;

public final class a
{
  final l JBZ;
  final b JCa;
  final boolean JCb;
  final as JCc;
  
  private a(l paraml, b paramb, boolean paramBoolean, as paramas)
  {
    AppMethodBeat.i(57949);
    this.JBZ = paraml;
    this.JCa = paramb;
    this.JCb = paramBoolean;
    this.JCc = paramas;
    AppMethodBeat.o(57949);
  }
  
  public final a a(b paramb)
  {
    AppMethodBeat.i(57948);
    k.h(paramb, "flexibility");
    l locall = this.JBZ;
    boolean bool = this.JCb;
    as localas = this.JCc;
    k.h(locall, "howThisTypeIsUsed");
    k.h(paramb, "flexibility");
    paramb = new a(locall, paramb, bool, localas);
    AppMethodBeat.o(57948);
    return paramb;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(57953);
    if (this != paramObject)
    {
      if (!(paramObject instanceof a)) {
        break label93;
      }
      paramObject = (a)paramObject;
      if ((!k.g(this.JBZ, paramObject.JBZ)) || (!k.g(this.JCa, paramObject.JCa))) {
        break label93;
      }
      if (this.JCb != paramObject.JCb) {
        break label88;
      }
    }
    label88:
    for (int i = 1; (i != 0) && (k.g(this.JCc, paramObject.JCc)); i = 0)
    {
      AppMethodBeat.o(57953);
      return true;
    }
    label93:
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
    String str = "JavaTypeAttributes(howThisTypeIsUsed=" + this.JBZ + ", flexibility=" + this.JCa + ", isForAnnotationParameter=" + this.JCb + ", upperBoundOfTypeParameter=" + this.JCc + ")";
    AppMethodBeat.o(57951);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.c.b.a
 * JD-Core Version:    0.7.0.1
 */