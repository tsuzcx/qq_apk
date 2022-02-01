package com.tencent.mm.plugin.recordvideo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fp;
import com.tencent.mm.g.b.a.ga;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/report/RecordMediaReporter;", "", "()V", "info", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "lastTrace", "", "getLastTrace", "()I", "setLastTrace", "(I)V", "storyDoPublishStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDoPublishStruct;", "storyFailTraceStruct", "Lcom/tencent/mm/plugin/recordvideo/report/BehaviorTraceData;", "storyQuitPublishStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryQuitPublishStruct;", "storyTraceStruct", "traceStruct", "addReportTrace", "", "aid", "addReportValue", "key", "", "step", "addStoryTrace", "appendReportValue", "value", "doBehaviorReport", "scene", "doCommonReport", "doFailBehaviorReport", "getBehaviorReporter", "getFailBehaviorReporter", "getRecordMediaReportInfo", "prepareNewReport", "reportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/VideoCaptureReportInfo;", "resetBehaviorReporter", "resetFailBehaviorReporter", "setReportValue", "plugin-recordvideo_release"})
public final class c
{
  private static RecordMediaReportInfo xGT;
  public static a xGU;
  private static fp xGV;
  private static a xGW;
  private static int xGX;
  private static ga xGY;
  private static a xGZ;
  public static final c xHa;
  
  static
  {
    AppMethodBeat.i(75839);
    xHa = new c();
    xGT = new RecordMediaReportInfo();
    xGU = new a();
    xGV = new fp();
    xGW = new a();
    xGX = -1;
    xGY = new ga();
    xGZ = new a();
    AppMethodBeat.o(75839);
  }
  
  public static void NM(int paramInt)
  {
    AppMethodBeat.i(75834);
    xGU.NL(paramInt);
    AppMethodBeat.o(75834);
  }
  
  public static void NN(int paramInt)
  {
    AppMethodBeat.i(75836);
    if ((paramInt == 15) && ((xGX == 4) || (xGX == 10)))
    {
      xGX = paramInt;
      AppMethodBeat.o(75836);
      return;
    }
    xGX = paramInt;
    xGW.NL(paramInt);
    xGZ.NL(paramInt);
    AppMethodBeat.o(75836);
  }
  
  public static void NO(int paramInt)
  {
    AppMethodBeat.i(75837);
    if (paramInt == 3)
    {
      Object localObject1 = dGK();
      xGV.oz(String.valueOf(((Number)((RecordMediaReportInfo)localObject1).v("KEY_MUSIC_ID_INT", Integer.valueOf(0))).intValue()));
      fp localfp = xGV;
      Object localObject2 = ((RecordMediaReportInfo)localObject1).v("KEY_MUSIC_INDEX_INT", Long.valueOf(0L));
      p.g(localObject2, "commonRecordInfo.getRepo…e(KEY_MUSIC_INDEX_INT, 0)");
      localfp.kq(((Number)localObject2).longValue());
      localfp = xGV;
      localObject2 = ((RecordMediaReportInfo)localObject1).v("KEY_MUSIC_REQ_ID_INT", Long.valueOf(0L));
      p.g(localObject2, "commonRecordInfo.getRepo…(KEY_MUSIC_REQ_ID_INT, 0)");
      localfp.kr(((Number)localObject2).longValue());
      localfp = xGV;
      localObject1 = ((RecordMediaReportInfo)localObject1).v("KEY_SEARCH_MUSIC_INT", Long.valueOf(0L));
      p.g(localObject1, "commonRecordInfo.getRepo…(KEY_SEARCH_MUSIC_INT, 0)");
      localfp.kt(((Number)localObject1).longValue());
      xGV.oD(xGW.dGJ());
      xGV.aLk();
      xGX = -1;
    }
    xGV = new fp();
    xGW = new a();
    AppMethodBeat.o(75837);
  }
  
  public static void NP(int paramInt)
  {
    AppMethodBeat.i(75838);
    if (paramInt == 3)
    {
      xGY.lr(System.currentTimeMillis());
      xGY.oS(xGZ.dGJ());
      xGY.aLk();
    }
    xGY = new ga();
    xGZ = new a();
    AppMethodBeat.o(75838);
  }
  
  public static void a(VideoCaptureReportInfo paramVideoCaptureReportInfo)
  {
    AppMethodBeat.i(75831);
    xGT = new RecordMediaReportInfo();
    xGU = new a();
    if (paramVideoCaptureReportInfo != null) {}
    for (paramVideoCaptureReportInfo = Integer.valueOf(paramVideoCaptureReportInfo.rgD);; paramVideoCaptureReportInfo = Integer.valueOf(-1))
    {
      u("KEY_FROM_SCENE_INT", paramVideoCaptureReportInfo);
      AppMethodBeat.o(75831);
      return;
    }
  }
  
  public static RecordMediaReportInfo dGK()
  {
    AppMethodBeat.i(75835);
    xGT.u("KEY_ACTION_TRACE_STRING", xGU.dGJ());
    RecordMediaReportInfo localRecordMediaReportInfo = xGT;
    AppMethodBeat.o(75835);
    return localRecordMediaReportInfo;
  }
  
  public static fp dGL()
  {
    return xGV;
  }
  
  public static ga dGM()
  {
    return xGY;
  }
  
  public static void eL(String paramString, int paramInt)
  {
    AppMethodBeat.i(200402);
    p.h(paramString, "key");
    ArrayList localArrayList = (ArrayList)xGT.v(paramString, new ArrayList());
    localArrayList.add(Integer.valueOf(paramInt));
    xGT.u(paramString, localArrayList);
    AppMethodBeat.o(200402);
  }
  
  public static void u(String paramString, Object paramObject)
  {
    AppMethodBeat.i(75832);
    p.h(paramString, "key");
    p.h(paramObject, "value");
    xGT.u(paramString, paramObject);
    AppMethodBeat.o(75832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.d.c
 * JD-Core Version:    0.7.0.1
 */