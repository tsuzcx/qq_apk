package com.tencent.mm.videocomposition;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 15}, gka={""}, gkb={"Lcom/tencent/mm/videocomposition/TrackTransition;", "", "path", "", "effectId", "", "duration", "(Ljava/lang/String;JJ)V", "changed", "", "getChanged", "()Z", "setChanged", "(Z)V", "getDuration", "()J", "setDuration", "(J)V", "getEffectId", "setEffectId", "endTime", "getEndTime", "setEndTime", "getPath", "()Ljava/lang/String;", "setPath", "(Ljava/lang/String;)V", "value", "startTime", "getStartTime", "setStartTime", "isValid", "video_composition_release"})
public final class g
{
  public long duration;
  public String path;
  public long yeZ;
  
  private g(String paramString)
  {
    AppMethodBeat.i(194968);
    this.path = paramString;
    this.yeZ = 0L;
    this.duration = 1000L;
    AppMethodBeat.o(194968);
  }
  
  public final long getDuration()
  {
    return this.duration;
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(194966);
    if (((CharSequence)this.path).length() > 0)
    {
      AppMethodBeat.o(194966);
      return true;
    }
    AppMethodBeat.o(194966);
    return false;
  }
  
  public final void setPath(String paramString)
  {
    AppMethodBeat.i(194967);
    p.h(paramString, "<set-?>");
    this.path = paramString;
    AppMethodBeat.o(194967);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.videocomposition.g
 * JD-Core Version:    0.7.0.1
 */