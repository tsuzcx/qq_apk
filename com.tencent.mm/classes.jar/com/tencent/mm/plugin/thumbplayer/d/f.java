package com.tencent.mm.plugin.thumbplayer.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectVideoComposition;", "", "trackList", "", "Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectTrack;", "(Ljava/util/List;)V", "<set-?>", "", "duration", "getDuration", "()J", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getTrackList", "()Ljava/util/ArrayList;", "setTrackList", "(Ljava/util/ArrayList;)V", "computeTracksTime", "", "plugin-thumbplayer_release"})
public final class f
{
  public ArrayList<e> MQY;
  
  public f(List<e> paramList)
  {
    AppMethodBeat.i(189625);
    this.MQY = new ArrayList();
    this.MQY.addAll((Collection)paramList);
    goa();
    AppMethodBeat.o(189625);
  }
  
  private void goa()
  {
    AppMethodBeat.i(189623);
    if (this.MQY.isEmpty())
    {
      AppMethodBeat.o(189623);
      return;
    }
    Object localObject1 = (Iterable)this.MQY;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    long l1 = 0L;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.iBO();
      }
      localObject2 = (e)localObject2;
      long l2 = ((float)(((e)localObject2).MQW - ((e)localObject2).MQV) / ((e)localObject2).pvh);
      ((e)localObject2).startTimeMs = l1;
      ((e)localObject2).endTimeMs = (((e)localObject2).startTimeMs + l2);
      l1 = ((e)localObject2).endTimeMs;
      i += 1;
    }
    AppMethodBeat.o(189623);
  }
  
  public final long getDuration()
  {
    AppMethodBeat.i(189618);
    if (!((Collection)this.MQY).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      long l = ((e)j.lq((List)this.MQY)).endTimeMs;
      AppMethodBeat.o(189618);
      return l;
    }
    AppMethodBeat.o(189618);
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.d.f
 * JD-Core Version:    0.7.0.1
 */