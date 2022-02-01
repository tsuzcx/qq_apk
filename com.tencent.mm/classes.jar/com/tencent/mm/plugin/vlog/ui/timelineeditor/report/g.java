package com.tencent.mm.plugin.vlog.ui.timelineeditor.report;

import com.tencent.d.f.h;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.u;
import com.tencent.mm.plugin.report.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReportBase;", "T", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "()V", "reportInfo", "getReportInfo", "()Lcom/tencent/mm/plugin/report/AbsReportStruct;", "setReportInfo", "(Lcom/tencent/mm/plugin/report/AbsReportStruct;)V", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "init", "", "prepareBackPress", "release", "report", "reportId", "", "reportOnce", "reset", "tag", "Companion", "plugin-vlog_release"})
public abstract class g<T extends a>
  implements d
{
  public static final a NEL = new a((byte)0);
  protected T NEK;
  
  public final void a(u paramu)
  {
    p.k(paramu, "plugin");
    p.k(paramu, "plugin");
  }
  
  public abstract String gwC();
  
  public void gwD() {}
  
  protected final String gwG()
  {
    return "MicroMsg.TimelineEditorReportBasePlugin" + gwC();
  }
  
  public final void gwH()
  {
    gwG();
    new StringBuilder("reportOnce:").append(gwC());
    h.ioq();
    a locala = this.NEK;
    if (locala != null) {
      locala.bpa();
    }
    this.NEK = null;
  }
  
  public abstract void init();
  
  public final void report()
  {
    gwG();
    new StringBuilder("report:").append(gwC());
    h.ioq();
    a locala = this.NEK;
    if (locala != null) {
      locala.bpa();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReportBase$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.report.g
 * JD-Core Version:    0.7.0.1
 */