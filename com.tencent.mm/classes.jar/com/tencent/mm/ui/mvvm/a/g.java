package com.tencent.mm.ui.mvvm.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.statecenter.IStateActionResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/state/SearchQueryActionResult;", "Lcom/tencent/mm/sdk/statecenter/IStateActionResult;", "searchId", "", "originQuery", "subQueryList", "", "multiSearch", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Z)V", "getMultiSearch", "()Z", "getOriginQuery", "()Ljava/lang/String;", "getSearchId", "getSubQueryList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements IStateActionResult
{
  public final String Hte;
  public final List<String> Hti;
  public final boolean afAD;
  public final String mpa;
  
  public g(String paramString1, String paramString2, List<String> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(250480);
    this.mpa = paramString1;
    this.Hte = paramString2;
    this.Hti = paramList;
    this.afAD = paramBoolean;
    AppMethodBeat.o(250480);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(250508);
    if (this == paramObject)
    {
      AppMethodBeat.o(250508);
      return true;
    }
    if (!(paramObject instanceof g))
    {
      AppMethodBeat.o(250508);
      return false;
    }
    paramObject = (g)paramObject;
    if (!s.p(this.mpa, paramObject.mpa))
    {
      AppMethodBeat.o(250508);
      return false;
    }
    if (!s.p(this.Hte, paramObject.Hte))
    {
      AppMethodBeat.o(250508);
      return false;
    }
    if (!s.p(this.Hti, paramObject.Hti))
    {
      AppMethodBeat.o(250508);
      return false;
    }
    if (this.afAD != paramObject.afAD)
    {
      AppMethodBeat.o(250508);
      return false;
    }
    AppMethodBeat.o(250508);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(250491);
    String str = "SearchQueryActionResult(searchId=" + this.mpa + ", originQuery=" + this.Hte + ", subQueryList=" + this.Hti + ", multiSearch=" + this.afAD + ')';
    AppMethodBeat.o(250491);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.mvvm.a.g
 * JD-Core Version:    0.7.0.1
 */