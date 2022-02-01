package com.tencent.mm.plugin.scanner.ui.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.scan_goods_new.h;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanCodeProductMergeMaskView$ScanMergeSuccessDataWrapper;", "", "data", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRecognizeItem;", "needSuccessMarkAnimation", "", "(Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRecognizeItem;Z)V", "getData", "()Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductRecognizeItem;", "getNeedSuccessMarkAnimation", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ScanCodeProductMergeMaskView$b
{
  final h PfN;
  final boolean PfO;
  
  public ScanCodeProductMergeMaskView$b(h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(314855);
    this.PfN = paramh;
    this.PfO = paramBoolean;
    AppMethodBeat.o(314855);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(314870);
    if (this == paramObject)
    {
      AppMethodBeat.o(314870);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(314870);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(this.PfN, paramObject.PfN))
    {
      AppMethodBeat.o(314870);
      return false;
    }
    if (this.PfO != paramObject.PfO)
    {
      AppMethodBeat.o(314870);
      return false;
    }
    AppMethodBeat.o(314870);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(314860);
    String str = "ScanMergeSuccessDataWrapper(data=" + this.PfN + ", needSuccessMarkAnimation=" + this.PfO + ')';
    AppMethodBeat.o(314860);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanCodeProductMergeMaskView.b
 * JD-Core Version:    0.7.0.1
 */