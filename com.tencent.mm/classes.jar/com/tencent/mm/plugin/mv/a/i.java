package com.tencent.mm.plugin.mv.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.csb;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/MusicMvRecommendListCache;", "", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListResp;", "timestamp", "", "(Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListResp;J)V", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListResp;", "getTimestamp", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-mv_release"})
public final class i
{
  public final csb Aqj;
  public final long timestamp;
  
  public i(csb paramcsb, long paramLong)
  {
    AppMethodBeat.i(256802);
    this.Aqj = paramcsb;
    this.timestamp = paramLong;
    AppMethodBeat.o(256802);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(256805);
    if (this != paramObject)
    {
      if ((paramObject instanceof i))
      {
        paramObject = (i)paramObject;
        if ((!p.j(this.Aqj, paramObject.Aqj)) || (this.timestamp != paramObject.timestamp)) {}
      }
    }
    else
    {
      AppMethodBeat.o(256805);
      return true;
    }
    AppMethodBeat.o(256805);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(256804);
    csb localcsb = this.Aqj;
    if (localcsb != null) {}
    for (int i = localcsb.hashCode();; i = 0)
    {
      long l = this.timestamp;
      int j = (int)(l ^ l >>> 32);
      AppMethodBeat.o(256804);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(256803);
    String str = "MusicMvRecommendListCache(response=" + this.Aqj + ", timestamp=" + this.timestamp + ")";
    AppMethodBeat.o(256803);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.i
 * JD-Core Version:    0.7.0.1
 */