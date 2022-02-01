package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qbar.WxQBarResult;
import d.g.b.k;
import d.l;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanMultiCodeReportInfo;", "", "codeResultList", "", "Lcom/tencent/qbar/WxQBarResult;", "scanCost", "", "(Ljava/util/List;J)V", "chooseIndex", "", "getChooseIndex", "()I", "setChooseIndex", "(I)V", "getCodeResultList", "()Ljava/util/List;", "isReported", "", "()Z", "setReported", "(Z)V", "getScanCost", "()J", "scanSession", "getScanSession", "setScanSession", "(J)V", "tabSession", "getTabSession", "setTabSession", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "plugin-scan_release"})
final class x$a
{
  boolean fnG;
  final long vPA;
  long vPw;
  long vPx;
  int vPy;
  final List<WxQBarResult> vPz;
  
  public x$a(List<? extends WxQBarResult> paramList, long paramLong)
  {
    AppMethodBeat.i(195443);
    this.vPz = paramList;
    this.vPA = paramLong;
    this.vPy = -1;
    AppMethodBeat.o(195443);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(195446);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!k.g(this.vPz, paramObject.vPz)) || (this.vPA != paramObject.vPA)) {}
      }
    }
    else
    {
      AppMethodBeat.o(195446);
      return true;
    }
    AppMethodBeat.o(195446);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(195445);
    List localList = this.vPz;
    if (localList != null) {}
    for (int i = localList.hashCode();; i = 0)
    {
      long l = this.vPA;
      int j = (int)(l ^ l >>> 32);
      AppMethodBeat.o(195445);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(195444);
    String str = "ScanMultiCodeReportInfo(codeResultList=" + this.vPz + ", scanCost=" + this.vPA + ")";
    AppMethodBeat.o(195444);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.x.a
 * JD-Core Version:    0.7.0.1
 */