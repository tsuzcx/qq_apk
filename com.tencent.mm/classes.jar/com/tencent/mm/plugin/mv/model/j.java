package com.tencent.mm.plugin.mv.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dba;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/MusicMvRecommendListCache;", "", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListResp;", "timestamp", "", "(Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListResp;J)V", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListResp;", "getTimestamp", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-mv_release"})
public final class j
{
  public final dba GbX;
  public final long timestamp;
  
  public j(dba paramdba, long paramLong)
  {
    AppMethodBeat.i(229893);
    this.GbX = paramdba;
    this.timestamp = paramLong;
    AppMethodBeat.o(229893);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(229901);
    if (this != paramObject)
    {
      if ((paramObject instanceof j))
      {
        paramObject = (j)paramObject;
        if ((!p.h(this.GbX, paramObject.GbX)) || (this.timestamp != paramObject.timestamp)) {}
      }
    }
    else
    {
      AppMethodBeat.o(229901);
      return true;
    }
    AppMethodBeat.o(229901);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(229899);
    dba localdba = this.GbX;
    if (localdba != null) {}
    for (int i = localdba.hashCode();; i = 0)
    {
      long l = this.timestamp;
      int j = (int)(l ^ l >>> 32);
      AppMethodBeat.o(229899);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(229897);
    String str = "MusicMvRecommendListCache(response=" + this.GbX + ", timestamp=" + this.timestamp + ")";
    AppMethodBeat.o(229897);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.j
 * JD-Core Version:    0.7.0.1
 */