package com.tencent.mm.timelineedit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.effect.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/timelineedit/model/TrackTransitionInfo;", "", "beforeTrack", "Lcom/tencent/mm/timelineedit/model/Track;", "afterTrack", "transitionEffect", "Lcom/tencent/mm/xeffect/effect/PagTransitionEffect;", "durationMs", "", "path", "", "(Lcom/tencent/mm/timelineedit/model/Track;Lcom/tencent/mm/timelineedit/model/Track;Lcom/tencent/mm/xeffect/effect/PagTransitionEffect;JLjava/lang/String;)V", "getAfterTrack", "()Lcom/tencent/mm/timelineedit/model/Track;", "setAfterTrack", "(Lcom/tencent/mm/timelineedit/model/Track;)V", "getBeforeTrack", "setBeforeTrack", "getDurationMs", "()J", "setDurationMs", "(J)V", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "getTransitionEffect", "()Lcom/tencent/mm/xeffect/effect/PagTransitionEffect;", "setTransitionEffect", "(Lcom/tencent/mm/xeffect/effect/PagTransitionEffect;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "timelinelib_release"}, k=1, mv={1, 1, 15})
public final class h
{
  public g adpF;
  public g adpG;
  public y adpH;
  public long durationMs;
  public String path;
  
  public h(g paramg1, g paramg2, y paramy, long paramLong, String paramString)
  {
    AppMethodBeat.i(232067);
    this.adpF = paramg1;
    this.adpG = paramg2;
    this.adpH = paramy;
    this.durationMs = paramLong;
    this.path = paramString;
    AppMethodBeat.o(232067);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(232088);
    if (this != paramObject)
    {
      if (!(paramObject instanceof h)) {
        break label108;
      }
      paramObject = (h)paramObject;
      if ((!s.p(this.adpF, paramObject.adpF)) || (!s.p(this.adpG, paramObject.adpG)) || (!s.p(this.adpH, paramObject.adpH))) {
        break label108;
      }
      if (this.durationMs != paramObject.durationMs) {
        break label103;
      }
    }
    label103:
    for (int i = 1; (i != 0) && (s.p(this.path, paramObject.path)); i = 0)
    {
      AppMethodBeat.o(232088);
      return true;
    }
    label108:
    AppMethodBeat.o(232088);
    return false;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(232078);
    Object localObject = this.adpF;
    int i;
    int j;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.adpG;
      if (localObject == null) {
        break label128;
      }
      j = localObject.hashCode();
      label42:
      localObject = this.adpH;
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
      AppMethodBeat.o(232078);
      return ((k + (j + i * 31) * 31) * 31 + n) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label42;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(232072);
    String str = "TrackTransitionInfo(beforeTrack=" + this.adpF + ", afterTrack=" + this.adpG + ", transitionEffect=" + this.adpH + ", durationMs=" + this.durationMs + ", path=" + this.path + ")";
    AppMethodBeat.o(232072);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.h
 * JD-Core Version:    0.7.0.1
 */