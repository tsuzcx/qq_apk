package com.tencent.mm.sensitive.business;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sensitive/business/PermissionBusinessConfig$BusinessConfigItem;", "", "descPrefix", "", "descSuffix", "needCheckSwitch", "", "noNeedDialogPageList", "", "", "(IIZLjava/util/List;)V", "getDescPrefix", "()I", "getDescSuffix", "getNeedCheckSwitch", "()Z", "getNoNeedDialogPageList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "sensitive_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
{
  public final int acuP;
  public final int acuQ;
  public final boolean acuR;
  public final List<String> acuS;
  
  private a$a(int paramInt1, int paramInt2, boolean paramBoolean, List<String> paramList)
  {
    this.acuP = paramInt1;
    this.acuQ = paramInt2;
    this.acuR = paramBoolean;
    this.acuS = paramList;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(241061);
    if (this == paramObject)
    {
      AppMethodBeat.o(241061);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(241061);
      return false;
    }
    paramObject = (a)paramObject;
    if (this.acuP != paramObject.acuP)
    {
      AppMethodBeat.o(241061);
      return false;
    }
    if (this.acuQ != paramObject.acuQ)
    {
      AppMethodBeat.o(241061);
      return false;
    }
    if (this.acuR != paramObject.acuR)
    {
      AppMethodBeat.o(241061);
      return false;
    }
    if (!s.p(this.acuS, paramObject.acuS))
    {
      AppMethodBeat.o(241061);
      return false;
    }
    AppMethodBeat.o(241061);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(241048);
    String str = "BusinessConfigItem(descPrefix=" + this.acuP + ", descSuffix=" + this.acuQ + ", needCheckSwitch=" + this.acuR + ", noNeedDialogPageList=" + this.acuS + ')';
    AppMethodBeat.o(241048);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sensitive.business.a.a
 * JD-Core Version:    0.7.0.1
 */