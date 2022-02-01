package com.tencent.mm.plugin.mv.ui.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.ui.thumb.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/thumb/ThumbCachedLoader$Key;", "", "track", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "time", "", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;J)V", "getTime", "()J", "getTrack", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-mv_release"})
public final class g$c
{
  final a Gic;
  final long time;
  
  public g$c(a parama, long paramLong)
  {
    AppMethodBeat.i(230816);
    this.Gic = parama;
    this.time = paramLong;
    AppMethodBeat.o(230816);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(230823);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((!p.h(this.Gic, paramObject.Gic)) || (this.time != paramObject.time)) {}
      }
    }
    else
    {
      AppMethodBeat.o(230823);
      return true;
    }
    AppMethodBeat.o(230823);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(230822);
    a locala = this.Gic;
    if (locala != null) {}
    for (int i = locala.hashCode();; i = 0)
    {
      long l = this.time;
      int j = (int)(l ^ l >>> 32);
      AppMethodBeat.o(230822);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(230819);
    String str = "Key(track=" + this.Gic + ", time=" + this.time + ")";
    AppMethodBeat.o(230819);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.c.g.c
 * JD-Core Version:    0.7.0.1
 */