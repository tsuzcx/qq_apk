package com.tencent.mm.plugin.mv.model;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ayl;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/FinderFeedDetailCache;", "", "response", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "timestamp", "", "(Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;J)V", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "getTimestamp", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  final ayl LWS;
  final long timestamp;
  
  public c(ayl paramayl, long paramLong)
  {
    AppMethodBeat.i(286085);
    this.LWS = paramayl;
    this.timestamp = paramLong;
    AppMethodBeat.o(286085);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(286110);
    if (this == paramObject)
    {
      AppMethodBeat.o(286110);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(286110);
      return false;
    }
    paramObject = (c)paramObject;
    if (!s.p(this.LWS, paramObject.LWS))
    {
      AppMethodBeat.o(286110);
      return false;
    }
    if (this.timestamp != paramObject.timestamp)
    {
      AppMethodBeat.o(286110);
      return false;
    }
    AppMethodBeat.o(286110);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(286104);
    int i = this.LWS.hashCode();
    int j = q.a..ExternalSyntheticBackport0.m(this.timestamp);
    AppMethodBeat.o(286104);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(286094);
    String str = "FinderFeedDetailCache(response=" + this.LWS + ", timestamp=" + this.timestamp + ')';
    AppMethodBeat.o(286094);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.c
 * JD-Core Version:    0.7.0.1
 */