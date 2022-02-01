package com.tencent.mm.plugin.vlog.ui.timelineeditor.report;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.f.b.a.hz;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReport20741;", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReportBase;", "Lcom/tencent/mm/autogen/mmdata/rpt/MultiMediaEditResultStruct;", "pluginLayout", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;)V", "isFollowMusic", "", "getPluginLayout", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "setPluginLayout", "reportJson", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson;", "init", "", "prepareBackPress", "reportEdit20741Video", "action", "", "reportId", "", "reset", "setComposition", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setEditId", "editId", "setEditItem", "itemList", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "setFollowMusic", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-vlog_release"})
public final class c
  extends g<hz>
{
  public static final a NEF;
  public boolean AMb;
  BasePluginLayout NED;
  private com.tencent.mm.plugin.vlog.model.report.c NoV;
  
  static
  {
    AppMethodBeat.i(226688);
    NEF = new a((byte)0);
    AppMethodBeat.o(226688);
  }
  
  public c(BasePluginLayout paramBasePluginLayout)
  {
    AppMethodBeat.i(226687);
    this.NED = paramBasePluginLayout;
    this.NoV = new com.tencent.mm.plugin.vlog.model.report.c();
    AppMethodBeat.o(226687);
  }
  
  private final void Sx(final long paramLong)
  {
    AppMethodBeat.i(226684);
    d.b("MultiVideoPluginLayout_report", (kotlin.g.a.a)new b(this, paramLong));
    AppMethodBeat.o(226684);
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(226681);
    p.k(paramc, "status");
    switch (d.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(226681);
      return;
      Sx(1L);
    }
  }
  
  public final String gwC()
  {
    return "20741";
  }
  
  public final void gwD()
  {
    AppMethodBeat.i(226682);
    super.gwD();
    Sx(0L);
    AppMethodBeat.o(226682);
  }
  
  public final void init()
  {
    AppMethodBeat.i(226675);
    this.NEK = ((com.tencent.mm.plugin.report.a)new hz());
    this.NoV = new com.tencent.mm.plugin.vlog.model.report.c();
    AppMethodBeat.o(226675);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(226677);
    this.NEK = null;
    init();
    AppMethodBeat.o(226677);
  }
  
  public final void setEditId(String paramString)
  {
    AppMethodBeat.i(226680);
    p.k(paramString, "editId");
    hz localhz = (hz)this.NEK;
    if (localhz != null)
    {
      localhz.xz(paramString);
      AppMethodBeat.o(226680);
      return;
    }
    AppMethodBeat.o(226680);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReport20741$Companion;", "", "()V", "ReportID", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(c paramc, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.report.c
 * JD-Core Version:    0.7.0.1
 */