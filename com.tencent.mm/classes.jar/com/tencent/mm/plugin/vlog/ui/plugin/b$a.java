package com.tencent.mm.plugin.vlog.ui.plugin;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/CompositionStateRestorer$TrackState;", "", "transOrder", "", "trackStartTimeMs", "", "trackEndTimeMs", "(IJJ)V", "getTrackEndTimeMs", "()J", "getTrackStartTimeMs", "getTransOrder", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$a
{
  final long TDw;
  final long TDx;
  final int UhG;
  
  public b$a(int paramInt, long paramLong1, long paramLong2)
  {
    this.UhG = paramInt;
    this.TDw = paramLong1;
    this.TDx = paramLong2;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof a)) {
        return false;
      }
      paramObject = (a)paramObject;
      if (this.UhG != paramObject.UhG) {
        return false;
      }
      if (this.TDw != paramObject.TDw) {
        return false;
      }
    } while (this.TDx == paramObject.TDx);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(282374);
    int i = this.UhG;
    int j = q.a..ExternalSyntheticBackport0.m(this.TDw);
    int k = q.a..ExternalSyntheticBackport0.m(this.TDx);
    AppMethodBeat.o(282374);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(282366);
    String str = "TrackState(transOrder=" + this.UhG + ", trackStartTimeMs=" + this.TDw + ", trackEndTimeMs=" + this.TDx + ')';
    AppMethodBeat.o(282366);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.b.a
 * JD-Core Version:    0.7.0.1
 */