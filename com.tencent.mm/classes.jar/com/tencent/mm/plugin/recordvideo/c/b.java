package com.tencent.mm.plugin.recordvideo.c;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import org.json.JSONArray;
import org.json.JSONObject;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/recordvideo/report/RecordMediaReporter;", "", "()V", "info", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "traceStruct", "Lcom/tencent/mm/plugin/recordvideo/report/BehaviorTraceData;", "addReportTrace", "", "aid", "", "addReportValue", "key", "", "step", "doCommonReport", "getRecordMediaReportInfo", "prepareNewReport", "reportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/VideoCaptureReportInfo;", "setReportValue", "value", "plugin-recordvideo_release"})
public final class b
{
  private static RecordMediaReportInfo qfs;
  public static a qft;
  public static final b qfu;
  
  static
  {
    AppMethodBeat.i(154651);
    qfu = new b();
    qfs = new RecordMediaReportInfo();
    qft = new a();
    AppMethodBeat.o(154651);
  }
  
  public static void Cs(int paramInt)
  {
    AppMethodBeat.i(154649);
    a locala = qft;
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("aid", paramInt);
    localJSONObject.put("td", locala.qfr.length() + 1);
    if (locala.qfr.toString().length() + localJSONObject.toString().length() > 1000) {
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt != 0) {}
      synchronized (locala.lock)
      {
        locala.qfr.put(localJSONObject);
        AppMethodBeat.o(154649);
        return;
        paramInt = 1;
      }
    }
  }
  
  public static void a(VideoCaptureReportInfo paramVideoCaptureReportInfo)
  {
    AppMethodBeat.i(155837);
    qfs = new RecordMediaReportInfo();
    qft = new a();
    if (paramVideoCaptureReportInfo != null) {}
    for (paramVideoCaptureReportInfo = Integer.valueOf(paramVideoCaptureReportInfo.mhr);; paramVideoCaptureReportInfo = Integer.valueOf(-1))
    {
      p("KEY_FROM_SCENE_INT", paramVideoCaptureReportInfo);
      AppMethodBeat.o(155837);
      return;
    }
  }
  
  public static RecordMediaReportInfo cgB()
  {
    AppMethodBeat.i(155838);
    qfs.p("KEY_ACTION_TRACE_STRING", qft.cgA());
    RecordMediaReportInfo localRecordMediaReportInfo = qfs;
    AppMethodBeat.o(155838);
    return localRecordMediaReportInfo;
  }
  
  public static void p(String paramString, Object paramObject)
  {
    AppMethodBeat.i(154647);
    j.q(paramString, "key");
    j.q(paramObject, "value");
    qfs.p(paramString, paramObject);
    AppMethodBeat.o(154647);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.c.b
 * JD-Core Version:    0.7.0.1
 */