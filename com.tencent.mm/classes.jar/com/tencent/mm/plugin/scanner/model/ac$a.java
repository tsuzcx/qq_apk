package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qbar.WxQBarResult;
import d.g.b.p;
import d.l;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/model/ScanReporter$ScanMultiCodeReportInfo;", "", "codeResultList", "", "Lcom/tencent/qbar/WxQBarResult;", "scanCost", "", "(Ljava/util/List;J)V", "chooseIndex", "", "getChooseIndex", "()I", "setChooseIndex", "(I)V", "getCodeResultList", "()Ljava/util/List;", "isReported", "", "()Z", "setReported", "(Z)V", "getScanCost", "()J", "scanSession", "getScanSession", "setScanSession", "(J)V", "tabSession", "getTabSession", "setTabSession", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "plugin-scan_release"})
final class ac$a
{
  boolean fJh;
  long yoc;
  long yod;
  int yoe;
  final List<WxQBarResult> yof;
  final long yog;
  
  public ac$a(List<? extends WxQBarResult> paramList, long paramLong)
  {
    AppMethodBeat.i(186318);
    this.yof = paramList;
    this.yog = paramLong;
    this.yoe = -1;
    AppMethodBeat.o(186318);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(186321);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!p.i(this.yof, paramObject.yof)) || (this.yog != paramObject.yog)) {}
      }
    }
    else
    {
      AppMethodBeat.o(186321);
      return true;
    }
    AppMethodBeat.o(186321);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(186320);
    List localList = this.yof;
    if (localList != null) {}
    for (int i = localList.hashCode();; i = 0)
    {
      long l = this.yog;
      int j = (int)(l ^ l >>> 32);
      AppMethodBeat.o(186320);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(186319);
    String str = "ScanMultiCodeReportInfo(codeResultList=" + this.yof + ", scanCost=" + this.yog + ")";
    AppMethodBeat.o(186319);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ac.a
 * JD-Core Version:    0.7.0.1
 */