package com.tencent.mm.ui.mvvm.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.statecenter.BaseStateAction;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/state/SearchFocusChangeAction;", "Lcom/tencent/mm/sdk/statecenter/BaseStateAction;", "focus", "", "searchContent", "", "(ZLjava/lang/String;)V", "getFocus", "()Z", "getSearchContent", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends BaseStateAction
{
  public final String Fyn;
  public final boolean afAT;
  
  public d(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(250460);
    this.afAT = paramBoolean;
    this.Fyn = paramString;
    AppMethodBeat.o(250460);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(250502);
    if (this == paramObject)
    {
      AppMethodBeat.o(250502);
      return true;
    }
    if (!(paramObject instanceof d))
    {
      AppMethodBeat.o(250502);
      return false;
    }
    paramObject = (d)paramObject;
    if (this.afAT != paramObject.afAT)
    {
      AppMethodBeat.o(250502);
      return false;
    }
    if (!s.p(this.Fyn, paramObject.Fyn))
    {
      AppMethodBeat.o(250502);
      return false;
    }
    AppMethodBeat.o(250502);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(250466);
    String str = "SearchFocusChangeAction(focus=" + this.afAT + ", searchContent=" + this.Fyn + ')';
    AppMethodBeat.o(250466);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.mvvm.a.d
 * JD-Core Version:    0.7.0.1
 */