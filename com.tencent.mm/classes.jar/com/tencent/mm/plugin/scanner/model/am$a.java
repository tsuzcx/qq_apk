package com.tencent.mm.plugin.scanner.model;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qbar.WxQBarResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanMultiCodeReportInfo;", "", "codeResultList", "", "Lcom/tencent/qbar/WxQBarResult;", "scanCost", "", "(Ljava/util/List;J)V", "chooseIndex", "", "getChooseIndex", "()I", "setChooseIndex", "(I)V", "getCodeResultList", "()Ljava/util/List;", "isReported", "", "()Z", "setReported", "(Z)V", "getScanCost", "()J", "scanSession", "getScanSession", "setScanSession", "(J)V", "showInfoViewTimestamp", "getShowInfoViewTimestamp", "setShowInfoViewTimestamp", "showTimestamp", "getShowTimestamp", "setShowTimestamp", "tabSession", "getTabSession", "setTabSession", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
final class am$a
{
  final List<WxQBarResult> OTq;
  final long OTr;
  long OTs;
  long OTt;
  int OTu;
  long OTv;
  long OTw;
  boolean lwK;
  
  public am$a(List<? extends WxQBarResult> paramList, long paramLong)
  {
    AppMethodBeat.i(314313);
    this.OTq = paramList;
    this.OTr = paramLong;
    this.OTu = -1;
    AppMethodBeat.o(314313);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(314324);
    if (this == paramObject)
    {
      AppMethodBeat.o(314324);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(314324);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.OTq, paramObject.OTq))
    {
      AppMethodBeat.o(314324);
      return false;
    }
    if (this.OTr != paramObject.OTr)
    {
      AppMethodBeat.o(314324);
      return false;
    }
    AppMethodBeat.o(314324);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(314319);
    int i = this.OTq.hashCode();
    int j = q.a..ExternalSyntheticBackport0.m(this.OTr);
    AppMethodBeat.o(314319);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(314317);
    String str = "ScanMultiCodeReportInfo(codeResultList=" + this.OTq + ", scanCost=" + this.OTr + ')';
    AppMethodBeat.o(314317);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.am.a
 * JD-Core Version:    0.7.0.1
 */