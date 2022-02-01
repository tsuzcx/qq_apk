package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import kotlinx.a.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/json/JsonConfiguration;", "", "encodeDefaults", "", "ignoreUnknownKeys", "isLenient", "serializeSpecialFloatingPointValues", "allowStructuredMapKeys", "prettyPrint", "unquotedPrint", "indent", "", "useArrayPolymorphism", "classDiscriminator", "updateMode", "Lkotlinx/serialization/UpdateMode;", "(ZZZZZZZLjava/lang/String;ZLjava/lang/String;Lkotlinx/serialization/UpdateMode;)V", "getAllowStructuredMapKeys$kotlinx_serialization_runtime", "()Z", "getClassDiscriminator$kotlinx_serialization_runtime", "()Ljava/lang/String;", "getEncodeDefaults$kotlinx_serialization_runtime", "getIgnoreUnknownKeys$kotlinx_serialization_runtime", "getIndent$kotlinx_serialization_runtime", "isLenient$kotlinx_serialization_runtime", "getPrettyPrint$kotlinx_serialization_runtime", "getSerializeSpecialFloatingPointValues$kotlinx_serialization_runtime", "getUnquotedPrint$kotlinx_serialization_runtime", "updateMode$annotations", "()V", "getUpdateMode$kotlinx_serialization_runtime", "()Lkotlinx/serialization/UpdateMode;", "getUseArrayPolymorphism$kotlinx_serialization_runtime", "component1", "component1$kotlinx_serialization_runtime", "component10", "component10$kotlinx_serialization_runtime", "component11", "component11$kotlinx_serialization_runtime", "component2", "component2$kotlinx_serialization_runtime", "component3", "component3$kotlinx_serialization_runtime", "component4", "component4$kotlinx_serialization_runtime", "component5", "component5$kotlinx_serialization_runtime", "component6", "component6$kotlinx_serialization_runtime", "component7", "component7$kotlinx_serialization_runtime", "component8", "component8$kotlinx_serialization_runtime", "component9", "component9$kotlinx_serialization_runtime", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "kotlinx-serialization-runtime"})
public final class d
{
  private static final String OkD;
  private static final String OkE;
  private static final d OkF;
  private static final d OkG;
  public static final a OkH;
  public final z Oji;
  public final boolean OkA;
  public final boolean OkB;
  public final String OkC;
  public final boolean Okv;
  public final boolean Okw;
  public final boolean Okx;
  public final boolean Oky;
  public final boolean Okz;
  public final boolean bNj;
  public final String bQD;
  
  static
  {
    AppMethodBeat.i(199869);
    OkH = new a((byte)0);
    OkD = "    ";
    OkE = "type";
    OkF = new d(false, false, false, false, false, false, false, null, false, null, null, 2047);
    OkG = new d(true, false, false, false, true, false, false, OkD, false, OkE, null, 1024);
    AppMethodBeat.o(199869);
  }
  
  public d()
  {
    this(false, false, false, false, false, false, false, null, false, null, null, 2047);
  }
  
  private d(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, String paramString1, boolean paramBoolean8, String paramString2, z paramz)
  {
    AppMethodBeat.i(199867);
    this.Okv = paramBoolean1;
    this.Okw = paramBoolean2;
    this.Okx = paramBoolean3;
    this.bNj = paramBoolean4;
    this.Oky = paramBoolean5;
    this.Okz = paramBoolean6;
    this.OkA = paramBoolean7;
    this.bQD = paramString1;
    this.OkB = paramBoolean8;
    this.OkC = paramString2;
    this.Oji = paramz;
    if ((this.OkB) && (!p.i(this.OkC, OkE)))
    {
      paramString1 = (Throwable)new IllegalArgumentException("Class discriminator should not be specified when array polymorphism is specified".toString());
      AppMethodBeat.o(199867);
      throw paramString1;
    }
    if ((!this.Okz) && (!p.i(this.bQD, OkD)))
    {
      paramString1 = (Throwable)new IllegalArgumentException("Indent should not be specified when default printing mode is used".toString());
      AppMethodBeat.o(199867);
      throw paramString1;
    }
    AppMethodBeat.o(199867);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(199872);
    if (this != paramObject)
    {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if ((this.Okv != paramObject.Okv) || (this.Okw != paramObject.Okw) || (this.Okx != paramObject.Okx) || (this.bNj != paramObject.bNj) || (this.Oky != paramObject.Oky) || (this.Okz != paramObject.Okz) || (this.OkA != paramObject.OkA) || (!p.i(this.bQD, paramObject.bQD)) || (this.OkB != paramObject.OkB) || (!p.i(this.OkC, paramObject.OkC)) || (!p.i(this.Oji, paramObject.Oji))) {}
      }
    }
    else
    {
      AppMethodBeat.o(199872);
      return true;
    }
    AppMethodBeat.o(199872);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(199870);
    String str = "JsonConfiguration(encodeDefaults=" + this.Okv + ", ignoreUnknownKeys=" + this.Okw + ", isLenient=" + this.Okx + ", serializeSpecialFloatingPointValues=" + this.bNj + ", allowStructuredMapKeys=" + this.Oky + ", prettyPrint=" + this.Okz + ", unquotedPrint=" + this.OkA + ", indent=" + this.bQD + ", useArrayPolymorphism=" + this.OkB + ", classDiscriminator=" + this.OkC + ", updateMode=" + this.Oji + ")";
    AppMethodBeat.o(199870);
    return str;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/serialization/json/JsonConfiguration$Companion;", "", "()V", "Default", "Lkotlinx/serialization/json/JsonConfiguration;", "Default$annotations", "getDefault", "()Lkotlinx/serialization/json/JsonConfiguration;", "Stable", "Stable$annotations", "getStable", "defaultDiscriminator", "", "defaultDiscriminator$annotations", "defaultIndent", "defaultIndent$annotations", "kotlinx-serialization-runtime"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.d
 * JD-Core Version:    0.7.0.1
 */