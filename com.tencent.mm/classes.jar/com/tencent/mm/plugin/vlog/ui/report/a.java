package com.tencent.mm.plugin.vlog.ui.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.a.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/report/MultiVideoPerformance;", "", "()V", "MAX_INDEX", "", "seekTimeArray", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "updateCompositionTimeArray", "addSeekTime", "", "time", "addUpdateCompositionTime", "getSeekTimeStr", "", "getUpdateTimeStr", "plugin-vlog_release"})
public final class a
{
  public final int NCg;
  public ArrayList<Long> NCh;
  public ArrayList<Long> NCi;
  
  public a()
  {
    AppMethodBeat.i(225487);
    this.NCg = 50;
    this.NCh = new ArrayList();
    this.NCi = new ArrayList();
    AppMethodBeat.o(225487);
  }
  
  public final String alO()
  {
    AppMethodBeat.i(225483);
    String str = j.a((Iterable)this.NCh, (CharSequence)"#", null, null, 0, null, null, 62);
    AppMethodBeat.o(225483);
    return str;
  }
  
  public final String gwu()
  {
    AppMethodBeat.i(225486);
    String str = j.a((Iterable)this.NCi, (CharSequence)"#", null, null, 0, null, null, 62);
    AppMethodBeat.o(225486);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.report.a
 * JD-Core Version:    0.7.0.1
 */