package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import kotlinx.a.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/json/JsonConfiguration;", "", "encodeDefaults", "", "ignoreUnknownKeys", "isLenient", "serializeSpecialFloatingPointValues", "allowStructuredMapKeys", "prettyPrint", "unquotedPrint", "indent", "", "useArrayPolymorphism", "classDiscriminator", "updateMode", "Lkotlinx/serialization/UpdateMode;", "(ZZZZZZZLjava/lang/String;ZLjava/lang/String;Lkotlinx/serialization/UpdateMode;)V", "getAllowStructuredMapKeys$kotlinx_serialization_runtime", "()Z", "getClassDiscriminator$kotlinx_serialization_runtime", "()Ljava/lang/String;", "getEncodeDefaults$kotlinx_serialization_runtime", "getIgnoreUnknownKeys$kotlinx_serialization_runtime", "getIndent$kotlinx_serialization_runtime", "isLenient$kotlinx_serialization_runtime", "getPrettyPrint$kotlinx_serialization_runtime", "getSerializeSpecialFloatingPointValues$kotlinx_serialization_runtime", "getUnquotedPrint$kotlinx_serialization_runtime", "updateMode$annotations", "()V", "getUpdateMode$kotlinx_serialization_runtime", "()Lkotlinx/serialization/UpdateMode;", "getUseArrayPolymorphism$kotlinx_serialization_runtime", "component1", "component1$kotlinx_serialization_runtime", "component10", "component10$kotlinx_serialization_runtime", "component11", "component11$kotlinx_serialization_runtime", "component2", "component2$kotlinx_serialization_runtime", "component3", "component3$kotlinx_serialization_runtime", "component4", "component4$kotlinx_serialization_runtime", "component5", "component5$kotlinx_serialization_runtime", "component6", "component6$kotlinx_serialization_runtime", "component7", "component7$kotlinx_serialization_runtime", "component8", "component8$kotlinx_serialization_runtime", "component9", "component9$kotlinx_serialization_runtime", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "kotlinx-serialization-runtime"})
public final class d
{
  private static final d NNA;
  public static final a NNB;
  private static final String NNx;
  private static final String NNy;
  private static final d NNz;
  public final z NMc;
  public final boolean NNp;
  public final boolean NNq;
  public final boolean NNr;
  public final boolean NNs;
  public final boolean NNt;
  public final boolean NNu;
  public final boolean NNv;
  public final String NNw;
  public final boolean bNj;
  public final String bQD;
  
  static
  {
    AppMethodBeat.i(191281);
    NNB = new a((byte)0);
    NNx = "    ";
    NNy = "type";
    NNz = new d(false, false, false, false, false, false, false, null, false, null, null, 2047);
    NNA = new d(true, false, false, false, true, false, false, NNx, false, NNy, null, 1024);
    AppMethodBeat.o(191281);
  }
  
  public d()
  {
    this(false, false, false, false, false, false, false, null, false, null, null, 2047);
  }
  
  private d(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, String paramString1, boolean paramBoolean8, String paramString2, z paramz)
  {
    AppMethodBeat.i(191279);
    this.NNp = paramBoolean1;
    this.NNq = paramBoolean2;
    this.NNr = paramBoolean3;
    this.bNj = paramBoolean4;
    this.NNs = paramBoolean5;
    this.NNt = paramBoolean6;
    this.NNu = paramBoolean7;
    this.bQD = paramString1;
    this.NNv = paramBoolean8;
    this.NNw = paramString2;
    this.NMc = paramz;
    if ((this.NNv) && (!p.i(this.NNw, NNy)))
    {
      paramString1 = (Throwable)new IllegalArgumentException("Class discriminator should not be specified when array polymorphism is specified".toString());
      AppMethodBeat.o(191279);
      throw paramString1;
    }
    if ((!this.NNt) && (!p.i(this.bQD, NNx)))
    {
      paramString1 = (Throwable)new IllegalArgumentException("Indent should not be specified when default printing mode is used".toString());
      AppMethodBeat.o(191279);
      throw paramString1;
    }
    AppMethodBeat.o(191279);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(191284);
    if (this != paramObject)
    {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if ((this.NNp != paramObject.NNp) || (this.NNq != paramObject.NNq) || (this.NNr != paramObject.NNr) || (this.bNj != paramObject.bNj) || (this.NNs != paramObject.NNs) || (this.NNt != paramObject.NNt) || (this.NNu != paramObject.NNu) || (!p.i(this.bQD, paramObject.bQD)) || (this.NNv != paramObject.NNv) || (!p.i(this.NNw, paramObject.NNw)) || (!p.i(this.NMc, paramObject.NMc))) {}
      }
    }
    else
    {
      AppMethodBeat.o(191284);
      return true;
    }
    AppMethodBeat.o(191284);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191282);
    String str = "JsonConfiguration(encodeDefaults=" + this.NNp + ", ignoreUnknownKeys=" + this.NNq + ", isLenient=" + this.NNr + ", serializeSpecialFloatingPointValues=" + this.bNj + ", allowStructuredMapKeys=" + this.NNs + ", prettyPrint=" + this.NNt + ", unquotedPrint=" + this.NNu + ", indent=" + this.bQD + ", useArrayPolymorphism=" + this.NNv + ", classDiscriminator=" + this.NNw + ", updateMode=" + this.NMc + ")";
    AppMethodBeat.o(191282);
    return str;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/serialization/json/JsonConfiguration$Companion;", "", "()V", "Default", "Lkotlinx/serialization/json/JsonConfiguration;", "Default$annotations", "getDefault", "()Lkotlinx/serialization/json/JsonConfiguration;", "Stable", "Stable$annotations", "getStable", "defaultDiscriminator", "", "defaultDiscriminator$annotations", "defaultIndent", "defaultIndent$annotations", "kotlinx-serialization-runtime"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.a.c.d
 * JD-Core Version:    0.7.0.1
 */