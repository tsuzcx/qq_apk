package com.tencent.mm.plugin.vlog.ui.timelineeditor.report;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReportPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "status", "intent", "Landroid/content/Intent;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Landroid/content/Intent;)V", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "reportMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReportBase;", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "Lkotlin/collections/HashMap;", "addReportInfo", "", "info", "getReportInfo", "T", "reportId", "(Ljava/lang/String;)Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReportBase;", "onPause", "onResume", "prepareBackPress", "release", "statusChange", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements com.tencent.mm.plugin.recordvideo.plugin.parent.a
{
  private Intent intent;
  private final HashMap<String, e<? extends com.tencent.mm.plugin.report.a>> xLE;
  
  public f(com.tencent.mm.plugin.recordvideo.plugin.parent.a parama, Intent paramIntent)
  {
    super(parama);
    AppMethodBeat.i(282087);
    this.intent = paramIntent;
    this.xLE = new HashMap();
    AppMethodBeat.o(282087);
  }
  
  public final void a(a.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(282107);
    s.u(paramc, "status");
    Iterator localIterator = ((Map)this.xLE).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((e)((Map.Entry)localIterator.next()).getValue()).a(paramc, paramBundle);
    }
    AppMethodBeat.o(282107);
  }
  
  public final void a(v paramv)
  {
    AppMethodBeat.i(282141);
    a.b.a(this, paramv);
    AppMethodBeat.o(282141);
  }
  
  public final void a(e<? extends com.tencent.mm.plugin.report.a> parame)
  {
    AppMethodBeat.i(282094);
    s.u(parame, "info");
    ((Map)this.xLE).put(parame.hUA(), parame);
    parame.ak(this.intent);
    AppMethodBeat.o(282094);
  }
  
  public final <T extends e<? extends com.tencent.mm.plugin.report.a>> T bfz(String paramString)
  {
    AppMethodBeat.i(282101);
    s.u(paramString, "reportId");
    if (this.xLE.get(paramString) == null)
    {
      AppMethodBeat.o(282101);
      return null;
    }
    paramString = this.xLE.get(paramString);
    if (paramString == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type T of com.tencent.mm.plugin.vlog.ui.timelineeditor.report.TimelineEditorReportPlugin.getReportInfo");
      AppMethodBeat.o(282101);
      throw paramString;
    }
    paramString = (e)paramString;
    AppMethodBeat.o(282101);
    return paramString;
  }
  
  public final void hUB()
  {
    AppMethodBeat.i(282112);
    Iterator localIterator = ((Map)this.xLE).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((e)((Map.Entry)localIterator.next()).getValue()).hUB();
    }
    AppMethodBeat.o(282112);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(282125);
    super.onPause();
    Iterator localIterator = ((Map)this.xLE).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((e)((Map.Entry)localIterator.next()).getValue()).onPause();
    }
    AppMethodBeat.o(282125);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(282119);
    super.onResume();
    Iterator localIterator = ((Map)this.xLE).entrySet().iterator();
    while (localIterator.hasNext()) {
      ((e)((Map.Entry)localIterator.next()).getValue()).onResume();
    }
    AppMethodBeat.o(282119);
  }
  
  public final void release()
  {
    AppMethodBeat.i(282134);
    super.release();
    this.xLE.clear();
    AppMethodBeat.o(282134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.report.f
 * JD-Core Version:    0.7.0.1
 */