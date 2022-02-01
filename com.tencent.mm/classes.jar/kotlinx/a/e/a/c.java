package kotlinx.a.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlinx.a.f.b;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/serialization/json/internal/JsonConf;", "", "encodeDefaults", "", "ignoreUnknownKeys", "isLenient", "allowStructuredMapKeys", "prettyPrint", "prettyPrintIndent", "", "coerceInputValues", "useArrayPolymorphism", "classDiscriminator", "allowSpecialFloatingPointValues", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "(ZZZZZLjava/lang/String;ZZLjava/lang/String;ZLkotlinx/serialization/modules/SerializersModule;)V", "getAllowSpecialFloatingPointValues", "()Z", "getAllowStructuredMapKeys", "getClassDiscriminator", "()Ljava/lang/String;", "getCoerceInputValues", "getEncodeDefaults", "getIgnoreUnknownKeys", "getPrettyPrint", "getPrettyPrintIndent", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "getUseArrayPolymorphism", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "kotlinx-serialization-runtime"}, k=1, mv={1, 4, 0})
public final class c
{
  public final b ajEA;
  final boolean ajEq;
  final boolean ajEr;
  final boolean ajEs;
  final boolean ajEt;
  final boolean ajEu;
  final String ajEv;
  final boolean ajEw;
  final boolean ajEx;
  final String ajEy;
  final boolean ajEz;
  
  private c(String paramString1, String paramString2, b paramb)
  {
    AppMethodBeat.i(188485);
    this.ajEq = true;
    this.ajEr = false;
    this.ajEs = false;
    this.ajEt = false;
    this.ajEu = false;
    this.ajEv = paramString1;
    this.ajEw = false;
    this.ajEx = false;
    this.ajEy = paramString2;
    this.ajEz = false;
    this.ajEA = paramb;
    AppMethodBeat.o(188485);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(188530);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((this.ajEq != paramObject.ajEq) || (this.ajEr != paramObject.ajEr) || (this.ajEs != paramObject.ajEs) || (this.ajEt != paramObject.ajEt) || (this.ajEu != paramObject.ajEu) || (!s.p(this.ajEv, paramObject.ajEv)) || (this.ajEw != paramObject.ajEw) || (this.ajEx != paramObject.ajEx) || (!s.p(this.ajEy, paramObject.ajEy)) || (this.ajEz != paramObject.ajEz) || (!s.p(this.ajEA, paramObject.ajEA))) {}
      }
    }
    else
    {
      AppMethodBeat.o(188530);
      return true;
    }
    AppMethodBeat.o(188530);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(188502);
    String str = "JsonConf(encodeDefaults=" + this.ajEq + ", ignoreUnknownKeys=" + this.ajEr + ", isLenient=" + this.ajEs + ", allowStructuredMapKeys=" + this.ajEt + ", prettyPrint=" + this.ajEu + ", prettyPrintIndent=" + this.ajEv + ", coerceInputValues=" + this.ajEw + ", useArrayPolymorphism=" + this.ajEx + ", classDiscriminator=" + this.ajEy + ", allowSpecialFloatingPointValues=" + this.ajEz + ", serializersModule=" + this.ajEA + ")";
    AppMethodBeat.o(188502);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlinx.a.e.a.c
 * JD-Core Version:    0.7.0.1
 */