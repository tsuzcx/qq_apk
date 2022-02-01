package com.tencent.mm.plugin.profile.ui.tab.list;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/tab/list/ImageRadiusInfo;", "", "radius", "", "topRound", "", "bottomRound", "(FZZ)V", "getBottomRound", "()Z", "getRadius", "()F", "getTopRound", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toCustomString", "", "toString", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  final boolean NfQ;
  final boolean NfR;
  final float radius;
  
  public c(float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.radius = paramFloat;
    this.NfQ = paramBoolean1;
    this.NfR = paramBoolean2;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(306165);
    if (this == paramObject)
    {
      AppMethodBeat.o(306165);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(306165);
      return false;
    }
    paramObject = (c)paramObject;
    if (!s.p(Float.valueOf(this.radius), Float.valueOf(paramObject.radius)))
    {
      AppMethodBeat.o(306165);
      return false;
    }
    if (this.NfQ != paramObject.NfQ)
    {
      AppMethodBeat.o(306165);
      return false;
    }
    if (this.NfR != paramObject.NfR)
    {
      AppMethodBeat.o(306165);
      return false;
    }
    AppMethodBeat.o(306165);
    return true;
  }
  
  public final String gDv()
  {
    AppMethodBeat.i(306150);
    String str = "radius:" + this.radius + "-topRound:" + this.NfQ + "-bottomRound:" + this.NfR;
    AppMethodBeat.o(306150);
    return str;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(306155);
    String str = "ImageRadiusInfo(radius=" + this.radius + ", topRound=" + this.NfQ + ", bottomRound=" + this.NfR + ')';
    AppMethodBeat.o(306155);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.list.c
 * JD-Core Version:    0.7.0.1
 */