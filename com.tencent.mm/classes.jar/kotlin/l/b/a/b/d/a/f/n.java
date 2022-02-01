package kotlin.l.b.a.b.d.a.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.m.ad;

final class n
{
  final ad aiAd;
  final kotlin.l.b.a.b.d.a.n aiVR;
  final ba aiVS;
  final boolean aiVT;
  
  public n(ad paramad, kotlin.l.b.a.b.d.a.n paramn, ba paramba, boolean paramBoolean)
  {
    AppMethodBeat.i(192074);
    this.aiAd = paramad;
    this.aiVR = paramn;
    this.aiVS = paramba;
    this.aiVT = paramBoolean;
    AppMethodBeat.o(192074);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(58125);
    if (this == paramObject)
    {
      AppMethodBeat.o(58125);
      return true;
    }
    if (!(paramObject instanceof n))
    {
      AppMethodBeat.o(58125);
      return false;
    }
    paramObject = (n)paramObject;
    if (!s.p(this.aiAd, paramObject.aiAd))
    {
      AppMethodBeat.o(58125);
      return false;
    }
    if (!s.p(this.aiVR, paramObject.aiVR))
    {
      AppMethodBeat.o(58125);
      return false;
    }
    if (!s.p(this.aiVS, paramObject.aiVS))
    {
      AppMethodBeat.o(58125);
      return false;
    }
    if (this.aiVT != paramObject.aiVT)
    {
      AppMethodBeat.o(58125);
      return false;
    }
    AppMethodBeat.o(58125);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(58123);
    String str = "TypeAndDefaultQualifiers(type=" + this.aiAd + ", defaultQualifiers=" + this.aiVR + ", typeParameterForArgument=" + this.aiVS + ", isFromStarProjection=" + this.aiVT + ')';
    AppMethodBeat.o(58123);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.f.n
 * JD-Core Version:    0.7.0.1
 */