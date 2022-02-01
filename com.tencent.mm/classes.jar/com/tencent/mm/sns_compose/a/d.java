package com.tencent.mm.sns_compose.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sns_compose/api/PageDataWrapper;", "T", "", "data", "", "hasMore", "", "minFeedId", "", "maxFeedId", "(Ljava/util/List;ZJJ)V", "getData", "()Ljava/util/List;", "getHasMore", "()Z", "getMaxFeedId", "()J", "getMinFeedId", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "sns-compose.api_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d<T>
{
  public final long aczg;
  private final long aczh;
  public final List<T> bMf;
  public final boolean hasMore;
  
  public d(List<? extends T> paramList, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(235483);
    this.bMf = paramList;
    this.hasMore = paramBoolean;
    this.aczg = paramLong1;
    this.aczh = paramLong2;
    AppMethodBeat.o(235483);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(235502);
    if (this == paramObject)
    {
      AppMethodBeat.o(235502);
      return true;
    }
    if (!(paramObject instanceof d))
    {
      AppMethodBeat.o(235502);
      return false;
    }
    paramObject = (d)paramObject;
    if (!s.p(this.bMf, paramObject.bMf))
    {
      AppMethodBeat.o(235502);
      return false;
    }
    if (this.hasMore != paramObject.hasMore)
    {
      AppMethodBeat.o(235502);
      return false;
    }
    if (this.aczg != paramObject.aczg)
    {
      AppMethodBeat.o(235502);
      return false;
    }
    if (this.aczh != paramObject.aczh)
    {
      AppMethodBeat.o(235502);
      return false;
    }
    AppMethodBeat.o(235502);
    return true;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(235489);
    String str = "PageDataWrapper(data=" + this.bMf + ", hasMore=" + this.hasMore + ", minFeedId=" + this.aczg + ", maxFeedId=" + this.aczh + ')';
    AppMethodBeat.o(235489);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sns_compose.a.d
 * JD-Core Version:    0.7.0.1
 */