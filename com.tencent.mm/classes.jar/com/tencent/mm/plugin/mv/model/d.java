package com.tencent.mm.plugin.mv.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/FinderFeedDetailCacheKey;", "", "feedId", "", "nonceId", "", "(JLjava/lang/String;)V", "getFeedId", "()J", "getNonceId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-mv_release"})
public final class d
{
  private final long feedId;
  private final String nonceId;
  
  public d(long paramLong, String paramString)
  {
    AppMethodBeat.i(226523);
    this.feedId = paramLong;
    this.nonceId = paramString;
    AppMethodBeat.o(226523);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(226528);
    if (this != paramObject)
    {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if ((this.feedId != paramObject.feedId) || (!p.h(this.nonceId, paramObject.nonceId))) {}
      }
    }
    else
    {
      AppMethodBeat.o(226528);
      return true;
    }
    AppMethodBeat.o(226528);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(226526);
    long l = this.feedId;
    int j = (int)(l ^ l >>> 32);
    String str = this.nonceId;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      AppMethodBeat.o(226526);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(226525);
    String str = "FinderFeedDetailCacheKey(feedId=" + this.feedId + ", nonceId=" + this.nonceId + ")";
    AppMethodBeat.o(226525);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.d
 * JD-Core Version:    0.7.0.1
 */