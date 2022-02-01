package com.tencent.mm.plugin.voip.d;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/report/VoipFloatCardReportManager$FloatCardReportData;", "", "dismissCalled", "", "viewRemoved", "showCallType", "permissionStatus", "duration", "", "(IIIIJ)V", "getDismissCalled", "()I", "setDismissCalled", "(I)V", "getDuration", "()J", "setDuration", "(J)V", "getPermissionStatus", "setPermissionStatus", "getShowCallType", "setShowCallType", "getViewRemoved", "setViewRemoved", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$a
{
  int UGQ = 0;
  int UGR = 0;
  int UGS = 0;
  int UGT = 0;
  long duration = 0L;
  
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
      if (this.UGQ != paramObject.UGQ) {
        return false;
      }
      if (this.UGR != paramObject.UGR) {
        return false;
      }
      if (this.UGS != paramObject.UGS) {
        return false;
      }
      if (this.UGT != paramObject.UGT) {
        return false;
      }
    } while (this.duration == paramObject.duration);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(292819);
    int i = this.UGQ;
    int j = this.UGR;
    int k = this.UGS;
    int m = this.UGT;
    int n = q.a..ExternalSyntheticBackport0.m(this.duration);
    AppMethodBeat.o(292819);
    return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + n;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(292814);
    String str = "FloatCardReportData(dismissCalled=" + this.UGQ + ", viewRemoved=" + this.UGR + ", showCallType=" + this.UGS + ", permissionStatus=" + this.UGT + ", duration=" + this.duration + ')';
    AppMethodBeat.o(292814);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.d.d.a
 * JD-Core Version:    0.7.0.1
 */