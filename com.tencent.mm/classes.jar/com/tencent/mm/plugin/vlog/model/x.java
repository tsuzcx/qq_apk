package com.tencent.mm.plugin.vlog.model;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/PlayRange;", "", "start", "", "end", "(JJ)V", "getEnd", "()J", "setEnd", "(J)V", "getStart", "setStart", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class x
{
  long axI = 0L;
  long start = 0L;
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof x)) {
        return false;
      }
      paramObject = (x)paramObject;
      if (this.start != paramObject.start) {
        return false;
      }
    } while (this.axI == paramObject.axI);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(283537);
    int i = q.a..ExternalSyntheticBackport0.m(this.start);
    int j = q.a..ExternalSyntheticBackport0.m(this.axI);
    AppMethodBeat.o(283537);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(283529);
    String str = "PlayRange(start=" + this.start + ", end=" + this.axI + ')';
    AppMethodBeat.o(283529);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.x
 * JD-Core Version:    0.7.0.1
 */