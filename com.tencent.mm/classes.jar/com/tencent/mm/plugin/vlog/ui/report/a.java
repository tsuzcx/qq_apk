package com.tencent.mm.plugin.vlog.ui.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/report/MultiVideoPerformance;", "", "()V", "MAX_INDEX", "", "seekTimeArray", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "updateCompositionTimeArray", "addSeekTime", "", "time", "addUpdateCompositionTime", "getSeekTimeStr", "", "getUpdateTimeStr", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public final int UoM;
  public ArrayList<Long> UoN;
  public ArrayList<Long> UoO;
  
  public a()
  {
    AppMethodBeat.i(281481);
    this.UoM = 50;
    this.UoN = new ArrayList();
    this.UoO = new ArrayList();
    AppMethodBeat.o(281481);
  }
  
  public final String hUm()
  {
    AppMethodBeat.i(281486);
    String str = p.a((Iterable)this.UoN, (CharSequence)"#", null, null, 0, null, null, 62);
    AppMethodBeat.o(281486);
    return str;
  }
  
  public final String hUn()
  {
    AppMethodBeat.i(281494);
    String str = p.a((Iterable)this.UoO, (CharSequence)"#", null, null, 0, null, null, 62);
    AppMethodBeat.o(281494);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.report.a
 * JD-Core Version:    0.7.0.1
 */