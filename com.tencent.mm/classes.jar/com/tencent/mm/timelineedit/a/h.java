package com.tencent.mm.timelineedit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.effect.y;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/timelineedit/model/TrackTransitionInfo;", "", "beforeTrack", "Lcom/tencent/mm/timelineedit/model/Track;", "afterTrack", "transitionEffect", "Lcom/tencent/mm/xeffect/effect/PagTransitionEffect;", "durationMs", "", "path", "", "(Lcom/tencent/mm/timelineedit/model/Track;Lcom/tencent/mm/timelineedit/model/Track;Lcom/tencent/mm/xeffect/effect/PagTransitionEffect;JLjava/lang/String;)V", "getAfterTrack", "()Lcom/tencent/mm/timelineedit/model/Track;", "setAfterTrack", "(Lcom/tencent/mm/timelineedit/model/Track;)V", "getBeforeTrack", "setBeforeTrack", "getDurationMs", "()J", "setDurationMs", "(J)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getTransitionEffect", "()Lcom/tencent/mm/xeffect/effect/PagTransitionEffect;", "setTransitionEffect", "(Lcom/tencent/mm/xeffect/effect/PagTransitionEffect;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "timelinelib_release"})
public final class h
{
  public g VLA;
  public g VLB;
  public y VLC;
  public long durationMs;
  public String path;
  
  public h(g paramg1, g paramg2, y paramy, long paramLong, String paramString)
  {
    AppMethodBeat.i(262122);
    this.VLA = paramg1;
    this.VLB = paramg2;
    this.VLC = paramy;
    this.durationMs = paramLong;
    this.path = paramString;
    AppMethodBeat.o(262122);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(262125);
    if (this != paramObject)
    {
      if (!(paramObject instanceof h)) {
        break label108;
      }
      paramObject = (h)paramObject;
      if ((!p.h(this.VLA, paramObject.VLA)) || (!p.h(this.VLB, paramObject.VLB)) || (!p.h(this.VLC, paramObject.VLC))) {
        break label108;
      }
      if (this.durationMs != paramObject.durationMs) {
        break label103;
      }
    }
    label103:
    for (int i = 1; (i != 0) && (p.h(this.path, paramObject.path)); i = 0)
    {
      AppMethodBeat.o(262125);
      return true;
    }
    label108:
    AppMethodBeat.o(262125);
    return false;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(262124);
    Object localObject = this.VLA;
    int i;
    int j;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.VLB;
      if (localObject == null) {
        break label128;
      }
      j = localObject.hashCode();
      label42:
      localObject = this.VLC;
      if (localObject == null) {
        break label133;
      }
    }
    label128:
    label133:
    for (int k = localObject.hashCode();; k = 0)
    {
      long l = this.durationMs;
      int n = (int)(l ^ l >>> 32);
      localObject = this.path;
      if (localObject != null) {
        m = localObject.hashCode();
      }
      AppMethodBeat.o(262124);
      return ((k + (j + i * 31) * 31) * 31 + n) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label42;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(262123);
    String str = "TrackTransitionInfo(beforeTrack=" + this.VLA + ", afterTrack=" + this.VLB + ", transitionEffect=" + this.VLC + ", durationMs=" + this.durationMs + ", path=" + this.path + ")";
    AppMethodBeat.o(262123);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.h
 * JD-Core Version:    0.7.0.1
 */