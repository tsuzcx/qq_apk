package com.tencent.mm.videocomposition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.effect.af;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/videocomposition/TrackTransition;", "", "path", "", "effect", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "duration", "", "(Ljava/lang/String;Lcom/tencent/mm/xeffect/effect/VLogEffect;J)V", "changed", "", "getChanged", "()Z", "setChanged", "(Z)V", "getDuration", "()J", "setDuration", "(J)V", "getEffect", "()Lcom/tencent/mm/xeffect/effect/VLogEffect;", "setEffect", "(Lcom/tencent/mm/xeffect/effect/VLogEffect;)V", "endTime", "getEndTime", "setEndTime", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "value", "startTime", "getStartTime", "setStartTime", "isValid", "video_composition_release"})
public final class g
{
  public af NnT;
  public long duration;
  public String path;
  
  private g(String paramString)
  {
    AppMethodBeat.i(247975);
    this.path = paramString;
    this.NnT = null;
    this.duration = 1000L;
    AppMethodBeat.o(247975);
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(247972);
    if (((CharSequence)this.path).length() > 0)
    {
      AppMethodBeat.o(247972);
      return true;
    }
    AppMethodBeat.o(247972);
    return false;
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(247974);
    p.k(paramString, "<set-?>");
    this.path = paramString;
    AppMethodBeat.o(247974);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.videocomposition.g
 * JD-Core Version:    0.7.0.1
 */