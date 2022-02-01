package com.tencent.mm.plugin.thumbplayer.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectVideoComposition;", "", "trackList", "", "Lcom/tencent/mm/plugin/thumbplayer/effect/MultiMediaEffectTrack;", "(Ljava/util/List;)V", "<set-?>", "", "duration", "getDuration", "()J", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getTrackList", "()Ljava/util/ArrayList;", "setTrackList", "(Ljava/util/ArrayList;)V", "computeTracksTime", "", "plugin-thumbplayer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public ArrayList<c> TDz;
  
  public d(List<c> paramList)
  {
    AppMethodBeat.i(272452);
    this.TDz = new ArrayList();
    this.TDz.addAll((Collection)paramList);
    hKO();
    AppMethodBeat.o(272452);
  }
  
  private void hKO()
  {
    AppMethodBeat.i(272460);
    if (this.TDz.isEmpty())
    {
      AppMethodBeat.o(272460);
      return;
    }
    Object localObject1 = (Iterable)this.TDz;
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    long l1 = 0L;
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        p.kkW();
      }
      localObject2 = (c)localObject2;
      long l2 = ((float)(((c)localObject2).TDx - ((c)localObject2).TDw) / ((c)localObject2).sAn);
      ((c)localObject2).startTimeMs = l1;
      ((c)localObject2).endTimeMs = (((c)localObject2).startTimeMs + l2);
      l1 = ((c)localObject2).endTimeMs;
      i += 1;
    }
    AppMethodBeat.o(272460);
  }
  
  public final long getDuration()
  {
    AppMethodBeat.i(272466);
    if (!((Collection)this.TDz).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      long l = ((c)p.oM((List)this.TDz)).endTimeMs;
      AppMethodBeat.o(272466);
      return l;
    }
    AppMethodBeat.o(272466);
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.thumbplayer.c.d
 * JD-Core Version:    0.7.0.1
 */