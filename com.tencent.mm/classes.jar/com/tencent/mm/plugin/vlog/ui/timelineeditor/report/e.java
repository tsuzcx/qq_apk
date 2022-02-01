package com.tencent.mm.plugin.vlog.ui.timelineeditor.report;

import android.content.Intent;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReportBase;", "T", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "()V", "reportInfo", "getReportInfo", "()Lcom/tencent/mm/plugin/report/AbsReportStruct;", "setReportInfo", "(Lcom/tencent/mm/plugin/report/AbsReportStruct;)V", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "init", "", "intent", "Landroid/content/Intent;", "onPause", "onResume", "prepareBackPress", "release", "report", "reportId", "", "reportOnce", "reset", "tag", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class e<T extends com.tencent.mm.plugin.report.a>
  implements com.tencent.mm.plugin.recordvideo.plugin.parent.a
{
  public static final a UqY = new a((byte)0);
  protected T UqZ;
  
  public final void a(v paramv)
  {
    a.b.a(this, paramv);
  }
  
  public abstract void ak(Intent paramIntent);
  
  protected final String dgV()
  {
    return s.X("MicroMsg.TimelineEditorReportBasePlugin", hUA());
  }
  
  public abstract String hUA();
  
  public void hUB() {}
  
  public final void hUE()
  {
    Log.i(dgV(), s.X("reportOnce:", hUA()));
    com.tencent.mm.plugin.report.a locala = this.UqZ;
    if (locala != null) {
      locala.bMH();
    }
    this.UqZ = null;
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public final void report()
  {
    Log.i(dgV(), s.X("report:", hUA()));
    com.tencent.mm.plugin.report.a locala = this.UqZ;
    if (locala != null) {
      locala.bMH();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReportBase$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.report.e
 * JD-Core Version:    0.7.0.1
 */