package com.tencent.mm.plugin.vlog.ui.timelineeditor.report;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.autogen.mmdata.rpt.kd;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.vlog.model.report.c;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReport20741;", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReportBase;", "Lcom/tencent/mm/autogen/mmdata/rpt/MultiMediaEditResultStruct;", "pluginLayout", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;)V", "isFollowMusic", "", "getPluginLayout", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "setPluginLayout", "reportJson", "Lcom/tencent/mm/plugin/vlog/model/report/ReportJson;", "init", "", "intent", "Landroid/content/Intent;", "prepareBackPress", "reportEdit20741Video", "action", "", "reportId", "", "reset", "setComposition", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "setEditId", "editId", "setEditItem", "itemList", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "setFollowMusic", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends e<kd>
{
  public static final a UqQ;
  public boolean GoQ;
  private c Ucy;
  BasePluginLayout UqP;
  
  static
  {
    AppMethodBeat.i(282137);
    UqQ = new a((byte)0);
    AppMethodBeat.o(282137);
  }
  
  public b(BasePluginLayout paramBasePluginLayout)
  {
    AppMethodBeat.i(282089);
    this.UqP = paramBasePluginLayout;
    this.Ucy = new c();
    AppMethodBeat.o(282089);
  }
  
  private final void wL(final long paramLong)
  {
    AppMethodBeat.i(282096);
    d.d("MultiVideoPluginLayout_report", (kotlin.g.a.a)new c(this, paramLong));
    AppMethodBeat.o(282096);
  }
  
  public final void a(a.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(282171);
    s.u(paramc, "status");
    if (b.$EnumSwitchMapping$0[paramc.ordinal()] == 1) {
      wL(1L);
    }
    AppMethodBeat.o(282171);
  }
  
  public final void ak(Intent paramIntent)
  {
    AppMethodBeat.i(282152);
    s.u(paramIntent, "intent");
    this.UqZ = ((com.tencent.mm.plugin.report.a)new kd());
    this.Ucy = new c();
    AppMethodBeat.o(282152);
  }
  
  public final String hUA()
  {
    return "20741";
  }
  
  public final void hUB()
  {
    AppMethodBeat.i(282177);
    super.hUB();
    wL(0L);
    AppMethodBeat.o(282177);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(282159);
    this.UqZ = null;
    this.UqZ = ((com.tencent.mm.plugin.report.a)new kd());
    this.Ucy = new c();
    AppMethodBeat.o(282159);
  }
  
  public final void setEditId(String paramString)
  {
    AppMethodBeat.i(282166);
    s.u(paramString, "editId");
    kd localkd = (kd)this.UqZ;
    if (localkd != null) {
      localkd.sN(paramString);
    }
    AppMethodBeat.o(282166);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReport20741$Companion;", "", "()V", "ReportID", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(b paramb, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.report.b
 * JD-Core Version:    0.7.0.1
 */