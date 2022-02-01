package com.tencent.mm.plugin.mv.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ars;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/FinderFeedDetailCache;", "", "response", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "timestamp", "", "(Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;J)V", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "getTimestamp", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-mv_release"})
public final class b
{
  final ars Apk;
  final long timestamp;
  
  public b(ars paramars, long paramLong)
  {
    AppMethodBeat.i(256747);
    this.Apk = paramars;
    this.timestamp = paramLong;
    AppMethodBeat.o(256747);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(256750);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!p.j(this.Apk, paramObject.Apk)) || (this.timestamp != paramObject.timestamp)) {}
      }
    }
    else
    {
      AppMethodBeat.o(256750);
      return true;
    }
    AppMethodBeat.o(256750);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(256749);
    ars localars = this.Apk;
    if (localars != null) {}
    for (int i = localars.hashCode();; i = 0)
    {
      long l = this.timestamp;
      int j = (int)(l ^ l >>> 32);
      AppMethodBeat.o(256749);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(256748);
    String str = "FinderFeedDetailCache(response=" + this.Apk + ", timestamp=" + this.timestamp + ")";
    AppMethodBeat.o(256748);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.b
 * JD-Core Version:    0.7.0.1
 */