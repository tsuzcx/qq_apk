package com.tencent.mm.plugin.recordvideo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fr;
import com.tencent.mm.g.b.a.gc;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/report/RecordMediaReporter;", "", "()V", "info", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "lastTrace", "", "getLastTrace", "()I", "setLastTrace", "(I)V", "storyDoPublishStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDoPublishStruct;", "storyFailTraceStruct", "Lcom/tencent/mm/plugin/recordvideo/report/BehaviorTraceData;", "storyQuitPublishStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryQuitPublishStruct;", "storyTraceStruct", "traceStruct", "addReportTrace", "", "aid", "addReportValue", "key", "", "step", "addStoryTrace", "appendReportValue", "value", "doBehaviorReport", "scene", "doCommonReport", "doFailBehaviorReport", "getBehaviorReporter", "getFailBehaviorReporter", "getRecordMediaReportInfo", "prepareNewReport", "reportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/VideoCaptureReportInfo;", "resetBehaviorReporter", "resetFailBehaviorReporter", "setReportValue", "plugin-recordvideo_release"})
public final class c
{
  private static RecordMediaReportInfo xWO;
  public static a xWP;
  private static fr xWQ;
  private static a xWR;
  private static int xWS;
  private static gc xWT;
  private static a xWU;
  public static final c xWV;
  
  static
  {
    AppMethodBeat.i(75839);
    xWV = new c();
    xWO = new RecordMediaReportInfo();
    xWP = new a();
    xWQ = new fr();
    xWR = new a();
    xWS = -1;
    xWT = new gc();
    xWU = new a();
    AppMethodBeat.o(75839);
  }
  
  public static void Os(int paramInt)
  {
    AppMethodBeat.i(75834);
    xWP.Or(paramInt);
    AppMethodBeat.o(75834);
  }
  
  public static void Ot(int paramInt)
  {
    AppMethodBeat.i(75836);
    if ((paramInt == 15) && ((xWS == 4) || (xWS == 10)))
    {
      xWS = paramInt;
      AppMethodBeat.o(75836);
      return;
    }
    xWS = paramInt;
    xWR.Or(paramInt);
    xWU.Or(paramInt);
    AppMethodBeat.o(75836);
  }
  
  public static void Ou(int paramInt)
  {
    AppMethodBeat.i(75837);
    if (paramInt == 3)
    {
      Object localObject1 = dKb();
      xWQ.oU(String.valueOf(((Number)((RecordMediaReportInfo)localObject1).v("KEY_MUSIC_ID_INT", Integer.valueOf(0))).intValue()));
      fr localfr = xWQ;
      Object localObject2 = ((RecordMediaReportInfo)localObject1).v("KEY_MUSIC_INDEX_INT", Long.valueOf(0L));
      p.g(localObject2, "commonRecordInfo.getRepo…e(KEY_MUSIC_INDEX_INT, 0)");
      localfr.kB(((Number)localObject2).longValue());
      localfr = xWQ;
      localObject2 = ((RecordMediaReportInfo)localObject1).v("KEY_MUSIC_REQ_ID_INT", Long.valueOf(0L));
      p.g(localObject2, "commonRecordInfo.getRepo…(KEY_MUSIC_REQ_ID_INT, 0)");
      localfr.kC(((Number)localObject2).longValue());
      localfr = xWQ;
      localObject1 = ((RecordMediaReportInfo)localObject1).v("KEY_SEARCH_MUSIC_INT", Long.valueOf(0L));
      p.g(localObject1, "commonRecordInfo.getRepo…(KEY_SEARCH_MUSIC_INT, 0)");
      localfr.kE(((Number)localObject1).longValue());
      xWQ.oY(xWR.dKa());
      xWQ.aLH();
      xWS = -1;
    }
    xWQ = new fr();
    xWR = new a();
    AppMethodBeat.o(75837);
  }
  
  public static void Ov(int paramInt)
  {
    AppMethodBeat.i(75838);
    if (paramInt == 3)
    {
      xWT.lC(System.currentTimeMillis());
      xWT.pn(xWU.dKa());
      xWT.aLH();
    }
    xWT = new gc();
    xWU = new a();
    AppMethodBeat.o(75838);
  }
  
  public static void a(VideoCaptureReportInfo paramVideoCaptureReportInfo)
  {
    AppMethodBeat.i(75831);
    xWO = new RecordMediaReportInfo();
    xWP = new a();
    if (paramVideoCaptureReportInfo != null) {}
    for (paramVideoCaptureReportInfo = Integer.valueOf(paramVideoCaptureReportInfo.roH);; paramVideoCaptureReportInfo = Integer.valueOf(-1))
    {
      u("KEY_FROM_SCENE_INT", paramVideoCaptureReportInfo);
      AppMethodBeat.o(75831);
      return;
    }
  }
  
  public static RecordMediaReportInfo dKb()
  {
    AppMethodBeat.i(75835);
    xWO.u("KEY_ACTION_TRACE_STRING", xWP.dKa());
    RecordMediaReportInfo localRecordMediaReportInfo = xWO;
    AppMethodBeat.o(75835);
    return localRecordMediaReportInfo;
  }
  
  public static fr dKc()
  {
    return xWQ;
  }
  
  public static gc dKd()
  {
    return xWT;
  }
  
  public static void eT(String paramString, int paramInt)
  {
    AppMethodBeat.i(206663);
    p.h(paramString, "key");
    ArrayList localArrayList = (ArrayList)xWO.v(paramString, new ArrayList());
    localArrayList.add(Integer.valueOf(paramInt));
    xWO.u(paramString, localArrayList);
    AppMethodBeat.o(206663);
  }
  
  public static void u(String paramString, Object paramObject)
  {
    AppMethodBeat.i(75832);
    p.h(paramString, "key");
    p.h(paramObject, "value");
    xWO.u(paramString, paramObject);
    AppMethodBeat.o(75832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.d.c
 * JD-Core Version:    0.7.0.1
 */