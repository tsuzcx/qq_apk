package com.tencent.mm.plugin.vlog.ui.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.a.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/report/MultiVideoPerformance;", "", "()V", "MAX_INDEX", "", "seekTimeArray", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "updateCompositionTimeArray", "addSeekTime", "", "time", "addUpdateCompositionTime", "getSeekTimeStr", "", "getUpdateTimeStr", "plugin-vlog_release"})
public final class a
{
  public final int GOA;
  public ArrayList<Long> GOB;
  public ArrayList<Long> GOC;
  
  public a()
  {
    AppMethodBeat.i(192024);
    this.GOA = 50;
    this.GOB = new ArrayList();
    this.GOC = new ArrayList();
    AppMethodBeat.o(192024);
  }
  
  public final String agM()
  {
    AppMethodBeat.i(192022);
    String str = j.a((Iterable)this.GOB, (CharSequence)"#", null, null, 0, null, null, 62);
    AppMethodBeat.o(192022);
    return str;
  }
  
  public final String fEt()
  {
    AppMethodBeat.i(192023);
    String str = j.a((Iterable)this.GOC, (CharSequence)"#", null, null, 0, null, null, 62);
    AppMethodBeat.o(192023);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.report.a
 * JD-Core Version:    0.7.0.1
 */