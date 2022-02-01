package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.z;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/serialization/json/JsonConfiguration;", "", "encodeDefaults", "", "ignoreUnknownKeys", "isLenient", "serializeSpecialFloatingPointValues", "allowStructuredMapKeys", "prettyPrint", "unquotedPrint", "indent", "", "useArrayPolymorphism", "classDiscriminator", "updateMode", "Lkotlinx/serialization/UpdateMode;", "(ZZZZZZZLjava/lang/String;ZLjava/lang/String;Lkotlinx/serialization/UpdateMode;)V", "getAllowStructuredMapKeys$kotlinx_serialization_runtime", "()Z", "getClassDiscriminator$kotlinx_serialization_runtime", "()Ljava/lang/String;", "getEncodeDefaults$kotlinx_serialization_runtime", "getIgnoreUnknownKeys$kotlinx_serialization_runtime", "getIndent$kotlinx_serialization_runtime", "isLenient$kotlinx_serialization_runtime", "getPrettyPrint$kotlinx_serialization_runtime", "getSerializeSpecialFloatingPointValues$kotlinx_serialization_runtime", "getUnquotedPrint$kotlinx_serialization_runtime", "updateMode$annotations", "()V", "getUpdateMode$kotlinx_serialization_runtime", "()Lkotlinx/serialization/UpdateMode;", "getUseArrayPolymorphism$kotlinx_serialization_runtime", "component1", "component1$kotlinx_serialization_runtime", "component10", "component10$kotlinx_serialization_runtime", "component11", "component11$kotlinx_serialization_runtime", "component2", "component2$kotlinx_serialization_runtime", "component3", "component3$kotlinx_serialization_runtime", "component4", "component4$kotlinx_serialization_runtime", "component5", "component5$kotlinx_serialization_runtime", "component6", "component6$kotlinx_serialization_runtime", "component7", "component7$kotlinx_serialization_runtime", "component8", "component8$kotlinx_serialization_runtime", "component9", "component9$kotlinx_serialization_runtime", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "kotlinx-serialization-runtime"})
public final class d
{
  private static final String abCO;
  private static final String abCP;
  private static final d abCQ;
  private static final d abCR;
  public static final d.a abCS;
  public final z abBt;
  public final boolean abCG;
  public final boolean abCH;
  public final boolean abCI;
  public final boolean abCJ;
  public final boolean abCK;
  public final boolean abCL;
  public final boolean abCM;
  public final String abCN;
  public final boolean bLc;
  public final String bOW;
  
  static
  {
    AppMethodBeat.i(255631);
    abCS = new d.a((byte)0);
    abCO = "    ";
    abCP = "type";
    abCQ = new d(false, false, false, false, false, false, false, null, false, null, null, 2047);
    abCR = new d(true, false, false, false, true, false, false, abCO, false, abCP, null, 1024);
    AppMethodBeat.o(255631);
  }
  
  public d()
  {
    this(false, false, false, false, false, false, false, null, false, null, null, 2047);
  }
  
  private d(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, String paramString1, boolean paramBoolean8, String paramString2, z paramz)
  {
    AppMethodBeat.i(255621);
    this.abCG = paramBoolean1;
    this.abCH = paramBoolean2;
    this.abCI = paramBoolean3;
    this.bLc = paramBoolean4;
    this.abCJ = paramBoolean5;
    this.abCK = paramBoolean6;
    this.abCL = paramBoolean7;
    this.bOW = paramString1;
    this.abCM = paramBoolean8;
    this.abCN = paramString2;
    this.abBt = paramz;
    if ((this.abCM) && (!p.h(this.abCN, abCP)))
    {
      paramString1 = (Throwable)new IllegalArgumentException("Class discriminator should not be specified when array polymorphism is specified".toString());
      AppMethodBeat.o(255621);
      throw paramString1;
    }
    if ((!this.abCK) && (!p.h(this.bOW, abCO)))
    {
      paramString1 = (Throwable)new IllegalArgumentException("Indent should not be specified when default printing mode is used".toString());
      AppMethodBeat.o(255621);
      throw paramString1;
    }
    AppMethodBeat.o(255621);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(255646);
    if (this != paramObject)
    {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if ((this.abCG != paramObject.abCG) || (this.abCH != paramObject.abCH) || (this.abCI != paramObject.abCI) || (this.bLc != paramObject.bLc) || (this.abCJ != paramObject.abCJ) || (this.abCK != paramObject.abCK) || (this.abCL != paramObject.abCL) || (!p.h(this.bOW, paramObject.bOW)) || (this.abCM != paramObject.abCM) || (!p.h(this.abCN, paramObject.abCN)) || (!p.h(this.abBt, paramObject.abBt))) {}
      }
    }
    else
    {
      AppMethodBeat.o(255646);
      return true;
    }
    AppMethodBeat.o(255646);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(255639);
    String str = "JsonConfiguration(encodeDefaults=" + this.abCG + ", ignoreUnknownKeys=" + this.abCH + ", isLenient=" + this.abCI + ", serializeSpecialFloatingPointValues=" + this.bLc + ", allowStructuredMapKeys=" + this.abCJ + ", prettyPrint=" + this.abCK + ", unquotedPrint=" + this.abCL + ", indent=" + this.bOW + ", useArrayPolymorphism=" + this.abCM + ", classDiscriminator=" + this.abCN + ", updateMode=" + this.abBt + ")";
    AppMethodBeat.o(255639);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.a.c.d
 * JD-Core Version:    0.7.0.1
 */