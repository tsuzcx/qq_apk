package com.tencent.mm.plugin.mv.model;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/FinderFeedDetailCacheKey;", "", "feedId", "", "nonceId", "", "(JLjava/lang/String;)V", "getFeedId", "()J", "getNonceId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private final long feedId;
  private final String nonceId;
  
  public d(long paramLong, String paramString)
  {
    AppMethodBeat.i(286075);
    this.feedId = paramLong;
    this.nonceId = paramString;
    AppMethodBeat.o(286075);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(286102);
    if (this == paramObject)
    {
      AppMethodBeat.o(286102);
      return true;
    }
    if (!(paramObject instanceof d))
    {
      AppMethodBeat.o(286102);
      return false;
    }
    paramObject = (d)paramObject;
    if (this.feedId != paramObject.feedId)
    {
      AppMethodBeat.o(286102);
      return false;
    }
    if (!s.p(this.nonceId, paramObject.nonceId))
    {
      AppMethodBeat.o(286102);
      return false;
    }
    AppMethodBeat.o(286102);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(286091);
    int i = q.a..ExternalSyntheticBackport0.m(this.feedId);
    int j = this.nonceId.hashCode();
    AppMethodBeat.o(286091);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(286083);
    String str = "FinderFeedDetailCacheKey(feedId=" + this.feedId + ", nonceId=" + this.nonceId + ')';
    AppMethodBeat.o(286083);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.d
 * JD-Core Version:    0.7.0.1
 */