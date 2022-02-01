package com.tencent.mm.plugin.mv.model;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dsr;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/MusicMvRecommendListCache;", "", "response", "Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListResp;", "timestamp", "", "(Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListResp;J)V", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/MusicLiveGetRelatedListResp;", "getTimestamp", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  final dsr LXH;
  final long timestamp;
  
  public j(dsr paramdsr, long paramLong)
  {
    AppMethodBeat.i(286038);
    this.LXH = paramdsr;
    this.timestamp = paramLong;
    AppMethodBeat.o(286038);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(286054);
    if (this == paramObject)
    {
      AppMethodBeat.o(286054);
      return true;
    }
    if (!(paramObject instanceof j))
    {
      AppMethodBeat.o(286054);
      return false;
    }
    paramObject = (j)paramObject;
    if (!s.p(this.LXH, paramObject.LXH))
    {
      AppMethodBeat.o(286054);
      return false;
    }
    if (this.timestamp != paramObject.timestamp)
    {
      AppMethodBeat.o(286054);
      return false;
    }
    AppMethodBeat.o(286054);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(286048);
    int i = this.LXH.hashCode();
    int j = q.a..ExternalSyntheticBackport0.m(this.timestamp);
    AppMethodBeat.o(286048);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(286045);
    String str = "MusicMvRecommendListCache(response=" + this.LXH + ", timestamp=" + this.timestamp + ')';
    AppMethodBeat.o(286045);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.j
 * JD-Core Version:    0.7.0.1
 */