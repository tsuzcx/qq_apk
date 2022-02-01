package com.tencent.mm.plugin.mv.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.att;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/FinderFeedDetailCache;", "", "response", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "timestamp", "", "(Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;J)V", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "getTimestamp", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-mv_release"})
public final class c
{
  final att GaS;
  final long timestamp;
  
  public c(att paramatt, long paramLong)
  {
    AppMethodBeat.i(242727);
    this.GaS = paramatt;
    this.timestamp = paramLong;
    AppMethodBeat.o(242727);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(242735);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((!p.h(this.GaS, paramObject.GaS)) || (this.timestamp != paramObject.timestamp)) {}
      }
    }
    else
    {
      AppMethodBeat.o(242735);
      return true;
    }
    AppMethodBeat.o(242735);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(242732);
    att localatt = this.GaS;
    if (localatt != null) {}
    for (int i = localatt.hashCode();; i = 0)
    {
      long l = this.timestamp;
      int j = (int)(l ^ l >>> 32);
      AppMethodBeat.o(242732);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(242728);
    String str = "FinderFeedDetailCache(response=" + this.GaS + ", timestamp=" + this.timestamp + ")";
    AppMethodBeat.o(242728);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.c
 * JD-Core Version:    0.7.0.1
 */