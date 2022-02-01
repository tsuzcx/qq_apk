package com.tencent.mm.plugin.recordvideo.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/util/RemuxCheckThirdPartyVideo$Result;", "", "exist", "", "extData", "", "(ZLjava/lang/String;)V", "getExist", "()Z", "getExtData", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j$a
{
  public final String extData;
  public final boolean ieB;
  
  public j$a(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(279507);
    this.ieB = paramBoolean;
    this.extData = paramString;
    AppMethodBeat.o(279507);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(279522);
    if (this == paramObject)
    {
      AppMethodBeat.o(279522);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(279522);
      return false;
    }
    paramObject = (a)paramObject;
    if (this.ieB != paramObject.ieB)
    {
      AppMethodBeat.o(279522);
      return false;
    }
    if (!s.p(this.extData, paramObject.extData))
    {
      AppMethodBeat.o(279522);
      return false;
    }
    AppMethodBeat.o(279522);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(279510);
    String str = "Result(exist=" + this.ieB + ", extData=" + this.extData + ')';
    AppMethodBeat.o(279510);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.util.j.a
 * JD-Core Version:    0.7.0.1
 */