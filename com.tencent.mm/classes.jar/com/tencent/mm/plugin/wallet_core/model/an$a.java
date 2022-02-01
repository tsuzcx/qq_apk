package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet_core/model/WcPayBindQueryDataFetcher$Request;", "", "scene", "", "useCache", "", "alwaysDoScene", "callback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/wallet_core/model/WcPayBindQueryDataFetcher$Result;", "Lkotlin/ParameterName;", "name", "result", "", "(IZZLkotlin/jvm/functions/Function1;)V", "getAlwaysDoScene", "()Z", "getCallback", "()Lkotlin/jvm/functions/Function1;", "getScene", "()I", "getUseCache", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class an$a
{
  public final boolean VKu;
  public final b<an.b, ah> callback;
  public final boolean igs;
  public final int scene;
  
  public an$a(b<? super an.b, ah> paramb)
  {
    AppMethodBeat.i(301142);
    this.scene = 26;
    this.igs = false;
    this.VKu = true;
    this.callback = paramb;
    AppMethodBeat.o(301142);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(301149);
    if (this == paramObject)
    {
      AppMethodBeat.o(301149);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(301149);
      return false;
    }
    paramObject = (a)paramObject;
    if (this.scene != paramObject.scene)
    {
      AppMethodBeat.o(301149);
      return false;
    }
    if (this.igs != paramObject.igs)
    {
      AppMethodBeat.o(301149);
      return false;
    }
    if (this.VKu != paramObject.VKu)
    {
      AppMethodBeat.o(301149);
      return false;
    }
    if (!s.p(this.callback, paramObject.callback))
    {
      AppMethodBeat.o(301149);
      return false;
    }
    AppMethodBeat.o(301149);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(301143);
    String str = "Request(scene=" + this.scene + ", useCache=" + this.igs + ", alwaysDoScene=" + this.VKu + ", callback=" + this.callback + ')';
    AppMethodBeat.o(301143);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.an.a
 * JD-Core Version:    0.7.0.1
 */