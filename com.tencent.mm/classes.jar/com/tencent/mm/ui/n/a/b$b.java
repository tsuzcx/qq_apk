package com.tencent.mm.ui.n.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.magicemoji.bean.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/magicemoji/core/MEChattingMgr$MagicEggSendItem;", "", "sendTime", "", "clickable", "", "ext", "Lcom/tencent/mm/plugin/emoji/magicemoji/bean/MagicEmojiEggExtData;", "(JZLcom/tencent/mm/plugin/emoji/magicemoji/bean/MagicEmojiEggExtData;)V", "getClickable", "()Z", "getExt", "()Lcom/tencent/mm/plugin/emoji/magicemoji/bean/MagicEmojiEggExtData;", "getSendTime", "()J", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$b
{
  public final a afwO;
  private final long rdg;
  public final boolean sdN;
  
  public b$b(long paramLong, boolean paramBoolean, a parama)
  {
    AppMethodBeat.i(249865);
    this.rdg = paramLong;
    this.sdN = paramBoolean;
    this.afwO = parama;
    AppMethodBeat.o(249865);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(249879);
    if (this == paramObject)
    {
      AppMethodBeat.o(249879);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(249879);
      return false;
    }
    paramObject = (b)paramObject;
    if (this.rdg != paramObject.rdg)
    {
      AppMethodBeat.o(249879);
      return false;
    }
    if (this.sdN != paramObject.sdN)
    {
      AppMethodBeat.o(249879);
      return false;
    }
    if (!s.p(this.afwO, paramObject.afwO))
    {
      AppMethodBeat.o(249879);
      return false;
    }
    AppMethodBeat.o(249879);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(249873);
    String str = "MagicEggSendItem(sendTime=" + this.rdg + ", clickable=" + this.sdN + ", ext=" + this.afwO + ')';
    AppMethodBeat.o(249873);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.n.a.b.b
 * JD-Core Version:    0.7.0.1
 */