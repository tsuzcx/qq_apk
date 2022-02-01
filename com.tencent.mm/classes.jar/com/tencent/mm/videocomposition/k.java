package com.tencent.mm.videocomposition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.effect.ad;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 15}, hxE={""}, hxF={"Lcom/tencent/mm/videocomposition/TrackTransition;", "", "path", "", "effect", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "duration", "", "(Ljava/lang/String;Lcom/tencent/mm/xeffect/effect/VLogEffect;J)V", "changed", "", "getChanged", "()Z", "setChanged", "(Z)V", "getDuration", "()J", "setDuration", "(J)V", "getEffect", "()Lcom/tencent/mm/xeffect/effect/VLogEffect;", "setEffect", "(Lcom/tencent/mm/xeffect/effect/VLogEffect;)V", "endTime", "getEndTime", "setEndTime", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "value", "startTime", "getStartTime", "setStartTime", "isValid", "video_composition_release"})
public final class k
{
  public ad GAn;
  public boolean bGB;
  public long duration;
  public long endTime;
  public String path;
  public long startTime;
  
  public k(String paramString, ad paramad, long paramLong)
  {
    AppMethodBeat.i(216761);
    this.path = paramString;
    this.GAn = paramad;
    this.duration = paramLong;
    AppMethodBeat.o(216761);
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(216759);
    if (((CharSequence)this.path).length() > 0)
    {
      AppMethodBeat.o(216759);
      return true;
    }
    AppMethodBeat.o(216759);
    return false;
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(216760);
    p.h(paramString, "<set-?>");
    this.path = paramString;
    AppMethodBeat.o(216760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.videocomposition.k
 * JD-Core Version:    0.7.0.1
 */