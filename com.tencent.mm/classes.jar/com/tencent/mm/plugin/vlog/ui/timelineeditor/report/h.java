package com.tencent.mm.plugin.vlog.ui.timelineeditor.report;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReportPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "status", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "reportMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReportBase;", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "Lkotlin/collections/HashMap;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "addReportInfo", "", "info", "getReportInfo", "T", "reportId", "(Ljava/lang/String;)Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReportBase;", "prepareBackPress", "release", "statusChange", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "plugin-vlog_release"})
public final class h
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements d
{
  private d APl;
  private final HashMap<String, g<? extends com.tencent.mm.plugin.report.a>> uDm;
  
  public h(d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(231700);
    this.APl = paramd;
    this.uDm = new HashMap();
    AppMethodBeat.o(231700);
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(231691);
    p.k(paramc, "status");
    Iterator localIterator = ((Map)this.uDm).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((g)((Map.Entry)localIterator.next()).getValue()).a(paramc, paramBundle);
    }
    AppMethodBeat.o(231691);
  }
  
  public final void a(u paramu)
  {
    AppMethodBeat.i(231701);
    p.k(paramu, "plugin");
    p.k(paramu, "plugin");
    AppMethodBeat.o(231701);
  }
  
  public final void a(g<? extends com.tencent.mm.plugin.report.a> paramg)
  {
    AppMethodBeat.i(231686);
    p.k(paramg, "info");
    ((Map)this.uDm).put(paramg.gwC(), paramg);
    paramg.init();
    AppMethodBeat.o(231686);
  }
  
  public final <T extends g<? extends com.tencent.mm.plugin.report.a>> T bfT(String paramString)
  {
    AppMethodBeat.i(231689);
    p.k(paramString, "reportId");
    if (this.uDm.get(paramString) == null)
    {
      AppMethodBeat.o(231689);
      return null;
    }
    paramString = this.uDm.get(paramString);
    if (paramString == null)
    {
      paramString = new t("null cannot be cast to non-null type T");
      AppMethodBeat.o(231689);
      throw paramString;
    }
    paramString = (g)paramString;
    AppMethodBeat.o(231689);
    return paramString;
  }
  
  public final void gwD()
  {
    AppMethodBeat.i(231694);
    Iterator localIterator = ((Map)this.uDm).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((g)((Map.Entry)localIterator.next()).getValue()).gwD();
    }
    AppMethodBeat.o(231694);
  }
  
  public final void release()
  {
    AppMethodBeat.i(231696);
    super.release();
    this.uDm.clear();
    AppMethodBeat.o(231696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.report.h
 * JD-Core Version:    0.7.0.1
 */