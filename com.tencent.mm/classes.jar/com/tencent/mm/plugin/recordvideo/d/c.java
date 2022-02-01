package com.tencent.mm.plugin.recordvideo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.eq;
import com.tencent.mm.g.b.a.fb;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/report/RecordMediaReporter;", "", "()V", "info", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "lastTrace", "", "getLastTrace", "()I", "setLastTrace", "(I)V", "storyDoPublishStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDoPublishStruct;", "storyFailTraceStruct", "Lcom/tencent/mm/plugin/recordvideo/report/BehaviorTraceData;", "storyQuitPublishStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryQuitPublishStruct;", "storyTraceStruct", "traceStruct", "addReportTrace", "", "aid", "addReportValue", "key", "", "step", "addStoryTrace", "doBehaviorReport", "scene", "doCommonReport", "doFailBehaviorReport", "getBehaviorReporter", "getFailBehaviorReporter", "getRecordMediaReportInfo", "prepareNewReport", "reportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/VideoCaptureReportInfo;", "resetBehaviorReporter", "resetFailBehaviorReporter", "setReportValue", "value", "plugin-recordvideo_release"})
public final class c
{
  private static RecordMediaReportInfo wxZ;
  public static a wya;
  private static eq wyb;
  private static a wyc;
  private static int wyd;
  private static fb wye;
  private static a wyf;
  public static final c wyg;
  
  static
  {
    AppMethodBeat.i(75839);
    wyg = new c();
    wxZ = new RecordMediaReportInfo();
    wya = new a();
    wyb = new eq();
    wyc = new a();
    wyd = -1;
    wye = new fb();
    wyf = new a();
    AppMethodBeat.o(75839);
  }
  
  public static void Mn(int paramInt)
  {
    AppMethodBeat.i(75834);
    wya.Mm(paramInt);
    AppMethodBeat.o(75834);
  }
  
  public static void Mo(int paramInt)
  {
    AppMethodBeat.i(75836);
    if ((paramInt == 15) && ((wyd == 4) || (wyd == 10)))
    {
      wyd = paramInt;
      AppMethodBeat.o(75836);
      return;
    }
    wyd = paramInt;
    wyc.Mm(paramInt);
    wyf.Mm(paramInt);
    AppMethodBeat.o(75836);
  }
  
  public static void Mp(int paramInt)
  {
    AppMethodBeat.i(75837);
    if (paramInt == 3)
    {
      Object localObject1 = dwq();
      wyb.mm(String.valueOf(((Number)((RecordMediaReportInfo)localObject1).x("KEY_MUSIC_ID_INT", Integer.valueOf(0))).intValue()));
      eq localeq = wyb;
      Object localObject2 = ((RecordMediaReportInfo)localObject1).x("KEY_MUSIC_INDEX_INT", Long.valueOf(0L));
      k.g(localObject2, "commonRecordInfo.getRepo…e(KEY_MUSIC_INDEX_INT, 0)");
      localeq.iE(((Number)localObject2).longValue());
      localeq = wyb;
      localObject2 = ((RecordMediaReportInfo)localObject1).x("KEY_MUSIC_REQ_ID_INT", Long.valueOf(0L));
      k.g(localObject2, "commonRecordInfo.getRepo…(KEY_MUSIC_REQ_ID_INT, 0)");
      localeq.iF(((Number)localObject2).longValue());
      localeq = wyb;
      localObject1 = ((RecordMediaReportInfo)localObject1).x("KEY_SEARCH_MUSIC_INT", Long.valueOf(0L));
      k.g(localObject1, "commonRecordInfo.getRepo…(KEY_SEARCH_MUSIC_INT, 0)");
      localeq.iH(((Number)localObject1).longValue());
      wyb.mq(wyc.dwp());
      wyb.aHZ();
      wyd = -1;
    }
    wyb = new eq();
    wyc = new a();
    AppMethodBeat.o(75837);
  }
  
  public static void Mq(int paramInt)
  {
    AppMethodBeat.i(75838);
    if (paramInt == 3)
    {
      wye.jF(System.currentTimeMillis());
      wye.mF(wyf.dwp());
      wye.aHZ();
    }
    wye = new fb();
    wyf = new a();
    AppMethodBeat.o(75838);
  }
  
  public static void a(VideoCaptureReportInfo paramVideoCaptureReportInfo)
  {
    AppMethodBeat.i(75831);
    wxZ = new RecordMediaReportInfo();
    wya = new a();
    if (paramVideoCaptureReportInfo != null) {}
    for (paramVideoCaptureReportInfo = Integer.valueOf(paramVideoCaptureReportInfo.qwN);; paramVideoCaptureReportInfo = Integer.valueOf(-1))
    {
      w("KEY_FROM_SCENE_INT", paramVideoCaptureReportInfo);
      AppMethodBeat.o(75831);
      return;
    }
  }
  
  public static RecordMediaReportInfo dwq()
  {
    AppMethodBeat.i(75835);
    wxZ.w("KEY_ACTION_TRACE_STRING", wya.dwp());
    RecordMediaReportInfo localRecordMediaReportInfo = wxZ;
    AppMethodBeat.o(75835);
    return localRecordMediaReportInfo;
  }
  
  public static eq dwr()
  {
    return wyb;
  }
  
  public static fb dws()
  {
    return wye;
  }
  
  public static void w(String paramString, Object paramObject)
  {
    AppMethodBeat.i(75832);
    k.h(paramString, "key");
    k.h(paramObject, "value");
    wxZ.w(paramString, paramObject);
    AppMethodBeat.o(75832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.d.c
 * JD-Core Version:    0.7.0.1
 */