package com.tencent.mm.ui.chatting.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/LangItemData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "lanId", "", "lanStringRes", "isSelect", "", "(IIZ)V", "()Z", "setSelect", "(Z)V", "getLanId", "()I", "getLanStringRes", "component1", "component2", "component3", "copy", "equals", "other", "", "getItemId", "", "getItemType", "hashCode", "toString", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class an
  implements a
{
  final int aeuB;
  final int aeuC;
  private boolean wwJ;
  
  private an(int paramInt1, int paramInt2)
  {
    this.aeuB = paramInt1;
    this.aeuC = paramInt2;
    this.wwJ = false;
  }
  
  public final long bZA()
  {
    return this.aeuB;
  }
  
  public final int bZB()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof an)) {
        return false;
      }
      paramObject = (an)paramObject;
      if (this.aeuB != paramObject.aeuB) {
        return false;
      }
      if (this.aeuC != paramObject.aeuC) {
        return false;
      }
    } while (this.wwJ == paramObject.wwJ);
    return false;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(255801);
    String str = "LangItemData(lanId=" + this.aeuB + ", lanStringRes=" + this.aeuC + ", isSelect=" + this.wwJ + ')';
    AppMethodBeat.o(255801);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.an
 * JD-Core Version:    0.7.0.1
 */