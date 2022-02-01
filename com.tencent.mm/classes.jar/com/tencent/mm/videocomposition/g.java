package com.tencent.mm.videocomposition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.effect.af;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/videocomposition/TrackTransition;", "", "path", "", "effect", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "duration", "", "(Ljava/lang/String;Lcom/tencent/mm/xeffect/effect/VLogEffect;J)V", "changed", "", "getChanged", "()Z", "setChanged", "(Z)V", "getDuration", "()J", "setDuration", "(J)V", "getEffect", "()Lcom/tencent/mm/xeffect/effect/VLogEffect;", "setEffect", "(Lcom/tencent/mm/xeffect/effect/VLogEffect;)V", "endTime", "getEndTime", "setEndTime", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "value", "startTime", "getStartTime", "setStartTime", "isValid", "video_composition_release"}, k=1, mv={1, 1, 15})
public final class g
{
  public af Uby;
  public long duration;
  public String path;
  
  private g(String paramString)
  {
    AppMethodBeat.i(233484);
    this.path = paramString;
    this.Uby = null;
    this.duration = 1000L;
    AppMethodBeat.o(233484);
  }
  
  public final long getDuration()
  {
    return this.duration;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(233501);
    if (((CharSequence)this.path).length() > 0)
    {
      AppMethodBeat.o(233501);
      return true;
    }
    AppMethodBeat.o(233501);
    return false;
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(233511);
    s.t(paramString, "<set-?>");
    this.path = paramString;
    AppMethodBeat.o(233511);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.videocomposition.g
 * JD-Core Version:    0.7.0.1
 */