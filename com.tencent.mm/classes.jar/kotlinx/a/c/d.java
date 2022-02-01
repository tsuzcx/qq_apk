package kotlinx.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlinx.a.z;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/serialization/json/JsonConfiguration;", "", "encodeDefaults", "", "ignoreUnknownKeys", "isLenient", "serializeSpecialFloatingPointValues", "allowStructuredMapKeys", "prettyPrint", "unquotedPrint", "indent", "", "useArrayPolymorphism", "classDiscriminator", "updateMode", "Lkotlinx/serialization/UpdateMode;", "(ZZZZZZZLjava/lang/String;ZLjava/lang/String;Lkotlinx/serialization/UpdateMode;)V", "getAllowStructuredMapKeys$kotlinx_serialization_runtime", "()Z", "getClassDiscriminator$kotlinx_serialization_runtime", "()Ljava/lang/String;", "getEncodeDefaults$kotlinx_serialization_runtime", "getIgnoreUnknownKeys$kotlinx_serialization_runtime", "getIndent$kotlinx_serialization_runtime", "isLenient$kotlinx_serialization_runtime", "getPrettyPrint$kotlinx_serialization_runtime", "getSerializeSpecialFloatingPointValues$kotlinx_serialization_runtime", "getUnquotedPrint$kotlinx_serialization_runtime", "updateMode$annotations", "()V", "getUpdateMode$kotlinx_serialization_runtime", "()Lkotlinx/serialization/UpdateMode;", "getUseArrayPolymorphism$kotlinx_serialization_runtime", "component1", "component1$kotlinx_serialization_runtime", "component10", "component10$kotlinx_serialization_runtime", "component11", "component11$kotlinx_serialization_runtime", "component2", "component2$kotlinx_serialization_runtime", "component3", "component3$kotlinx_serialization_runtime", "component4", "component4$kotlinx_serialization_runtime", "component5", "component5$kotlinx_serialization_runtime", "component6", "component6$kotlinx_serialization_runtime", "component7", "component7$kotlinx_serialization_runtime", "component8", "component8$kotlinx_serialization_runtime", "component9", "component9$kotlinx_serialization_runtime", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "kotlinx-serialization-runtime"})
public final class d
{
  private static final String TZA;
  private static final String TZB;
  private static final d TZC;
  private static final d TZD;
  public static final d.a TZE;
  public final z TYe;
  public final boolean TZq;
  public final boolean TZr;
  public final boolean TZs;
  public final boolean TZt;
  public final boolean TZu;
  public final boolean TZv;
  public final boolean TZw;
  public final String TZx;
  public final boolean TZy;
  public final String TZz;
  
  static
  {
    AppMethodBeat.i(225641);
    TZE = new d.a((byte)0);
    TZA = "    ";
    TZB = "type";
    TZC = new d(false, false, false, false, false, false, false, null, false, null, null, 2047);
    TZD = new d(true, false, false, false, true, false, false, TZA, false, TZB, null, 1024);
    AppMethodBeat.o(225641);
  }
  
  public d()
  {
    this(false, false, false, false, false, false, false, null, false, null, null, 2047);
  }
  
  private d(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, String paramString1, boolean paramBoolean8, String paramString2, z paramz)
  {
    AppMethodBeat.i(225639);
    this.TZq = paramBoolean1;
    this.TZr = paramBoolean2;
    this.TZs = paramBoolean3;
    this.TZt = paramBoolean4;
    this.TZu = paramBoolean5;
    this.TZv = paramBoolean6;
    this.TZw = paramBoolean7;
    this.TZx = paramString1;
    this.TZy = paramBoolean8;
    this.TZz = paramString2;
    this.TYe = paramz;
    if ((this.TZy) && (!p.j(this.TZz, TZB)))
    {
      paramString1 = (Throwable)new IllegalArgumentException("Class discriminator should not be specified when array polymorphism is specified".toString());
      AppMethodBeat.o(225639);
      throw paramString1;
    }
    if ((!this.TZv) && (!p.j(this.TZx, TZA)))
    {
      paramString1 = (Throwable)new IllegalArgumentException("Indent should not be specified when default printing mode is used".toString());
      AppMethodBeat.o(225639);
      throw paramString1;
    }
    AppMethodBeat.o(225639);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(225644);
    if (this != paramObject)
    {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if ((this.TZq != paramObject.TZq) || (this.TZr != paramObject.TZr) || (this.TZs != paramObject.TZs) || (this.TZt != paramObject.TZt) || (this.TZu != paramObject.TZu) || (this.TZv != paramObject.TZv) || (this.TZw != paramObject.TZw) || (!p.j(this.TZx, paramObject.TZx)) || (this.TZy != paramObject.TZy) || (!p.j(this.TZz, paramObject.TZz)) || (!p.j(this.TYe, paramObject.TYe))) {}
      }
    }
    else
    {
      AppMethodBeat.o(225644);
      return true;
    }
    AppMethodBeat.o(225644);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(225642);
    String str = "JsonConfiguration(encodeDefaults=" + this.TZq + ", ignoreUnknownKeys=" + this.TZr + ", isLenient=" + this.TZs + ", serializeSpecialFloatingPointValues=" + this.TZt + ", allowStructuredMapKeys=" + this.TZu + ", prettyPrint=" + this.TZv + ", unquotedPrint=" + this.TZw + ", indent=" + this.TZx + ", useArrayPolymorphism=" + this.TZy + ", classDiscriminator=" + this.TZz + ", updateMode=" + this.TYe + ")";
    AppMethodBeat.o(225642);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.a.c.d
 * JD-Core Version:    0.7.0.1
 */