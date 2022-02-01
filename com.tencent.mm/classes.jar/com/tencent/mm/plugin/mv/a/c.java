package com.tencent.mm.plugin.mv.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/FinderFeedDetailCacheKey;", "", "feedId", "", "nonceId", "", "(JLjava/lang/String;)V", "getFeedId", "()J", "getNonceId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-mv_release"})
public final class c
{
  private final long feedId;
  private final String hwg;
  
  public c(long paramLong, String paramString)
  {
    AppMethodBeat.i(256751);
    this.feedId = paramLong;
    this.hwg = paramString;
    AppMethodBeat.o(256751);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(256754);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((this.feedId != paramObject.feedId) || (!p.j(this.hwg, paramObject.hwg))) {}
      }
    }
    else
    {
      AppMethodBeat.o(256754);
      return true;
    }
    AppMethodBeat.o(256754);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(256753);
    long l = this.feedId;
    int j = (int)(l ^ l >>> 32);
    String str = this.hwg;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      AppMethodBeat.o(256753);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(256752);
    String str = "FinderFeedDetailCacheKey(feedId=" + this.feedId + ", nonceId=" + this.hwg + ")";
    AppMethodBeat.o(256752);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.c
 * JD-Core Version:    0.7.0.1
 */