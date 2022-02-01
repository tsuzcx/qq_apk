package com.tencent.mm.timelineedit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/timelineedit/model/TimeRange;", "", "startTimeMs", "", "endTimeMs", "(JJ)V", "durationMs", "getDurationMs", "()J", "getEndTimeMs", "getStartTimeMs", "toString", "", "timelinelib_release"}, k=1, mv={1, 1, 15})
public final class f
{
  public final long endTimeMs;
  public final long startTimeMs;
  
  public f(long paramLong1, long paramLong2)
  {
    this.startTimeMs = paramLong1;
    this.endTimeMs = paramLong2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(232069);
    String str = "TimeRange(startTimeMs=" + this.startTimeMs + ", endTimeMs=" + this.endTimeMs + " durationMS:" + (this.endTimeMs - this.startTimeMs) + ')';
    AppMethodBeat.o(232069);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.f
 * JD-Core Version:    0.7.0.1
 */