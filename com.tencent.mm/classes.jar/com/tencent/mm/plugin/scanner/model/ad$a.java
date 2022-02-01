package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qbar.WxQBarResult;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanMultiCodeReportInfo;", "", "codeResultList", "", "Lcom/tencent/qbar/WxQBarResult;", "scanCost", "", "(Ljava/util/List;J)V", "chooseIndex", "", "getChooseIndex", "()I", "setChooseIndex", "(I)V", "getCodeResultList", "()Ljava/util/List;", "isReported", "", "()Z", "setReported", "(Z)V", "getScanCost", "()J", "scanSession", "getScanSession", "setScanSession", "(J)V", "tabSession", "getTabSession", "setTabSession", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "plugin-scan_release"})
final class ad$a
{
  boolean fLk;
  long yEb;
  long yEc;
  int yEd;
  final List<WxQBarResult> yEe;
  final long yEf;
  
  public ad$a(List<? extends WxQBarResult> paramList, long paramLong)
  {
    AppMethodBeat.i(189608);
    this.yEe = paramList;
    this.yEf = paramLong;
    this.yEd = -1;
    AppMethodBeat.o(189608);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(189611);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.i(this.yEe, paramObject.yEe)) || (this.yEf != paramObject.yEf)) {}
      }
    }
    else
    {
      AppMethodBeat.o(189611);
      return true;
    }
    AppMethodBeat.o(189611);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(189610);
    List localList = this.yEe;
    if (localList != null) {}
    for (int i = localList.hashCode();; i = 0)
    {
      long l = this.yEf;
      int j = (int)(l ^ l >>> 32);
      AppMethodBeat.o(189610);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(189609);
    String str = "ScanMultiCodeReportInfo(codeResultList=" + this.yEe + ", scanCost=" + this.yEf + ")";
    AppMethodBeat.o(189609);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ad.a
 * JD-Core Version:    0.7.0.1
 */