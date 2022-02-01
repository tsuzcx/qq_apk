package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qbar.WxQBarResult;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanMultiCodeReportInfo;", "", "codeResultList", "", "Lcom/tencent/qbar/WxQBarResult;", "scanCost", "", "(Ljava/util/List;J)V", "chooseIndex", "", "getChooseIndex", "()I", "setChooseIndex", "(I)V", "getCodeResultList", "()Ljava/util/List;", "isReported", "", "()Z", "setReported", "(Z)V", "getScanCost", "()J", "scanSession", "getScanSession", "setScanSession", "(J)V", "tabSession", "getTabSession", "setTabSession", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "plugin-scan_release"})
final class z$a
{
  boolean fra;
  long xad;
  long xae;
  int xaf;
  final List<WxQBarResult> xag;
  final long xah;
  
  public z$a(List<? extends WxQBarResult> paramList, long paramLong)
  {
    AppMethodBeat.i(199606);
    this.xag = paramList;
    this.xah = paramLong;
    this.xaf = -1;
    AppMethodBeat.o(199606);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(199609);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!k.g(this.xag, paramObject.xag)) || (this.xah != paramObject.xah)) {}
      }
    }
    else
    {
      AppMethodBeat.o(199609);
      return true;
    }
    AppMethodBeat.o(199609);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(199608);
    List localList = this.xag;
    if (localList != null) {}
    for (int i = localList.hashCode();; i = 0)
    {
      long l = this.xah;
      int j = (int)(l ^ l >>> 32);
      AppMethodBeat.o(199608);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(199607);
    String str = "ScanMultiCodeReportInfo(codeResultList=" + this.xag + ", scanCost=" + this.xah + ")";
    AppMethodBeat.o(199607);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.z.a
 * JD-Core Version:    0.7.0.1
 */