package com.tencent.mm.plugin.vlog.ui.plugin.transition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.local.a.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "", "effect", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "selected", "", "(Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;Z)V", "getEffect", "()Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "setEffect", "(Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;)V", "getSelected", "()Z", "setSelected", "(Z)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  boolean Bvd;
  a.a Uoo;
  
  public d(a.a parama)
  {
    this.Uoo = parama;
    this.Bvd = false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(282885);
    if (this == paramObject)
    {
      AppMethodBeat.o(282885);
      return true;
    }
    if (!(paramObject instanceof d))
    {
      AppMethodBeat.o(282885);
      return false;
    }
    paramObject = (d)paramObject;
    if (!s.p(this.Uoo, paramObject.Uoo))
    {
      AppMethodBeat.o(282885);
      return false;
    }
    if (this.Bvd != paramObject.Bvd)
    {
      AppMethodBeat.o(282885);
      return false;
    }
    AppMethodBeat.o(282885);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(282876);
    String str = "TransitionItem(effect=" + this.Uoo + ", selected=" + this.Bvd + ')';
    AppMethodBeat.o(282876);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.transition.d
 * JD-Core Version:    0.7.0.1
 */