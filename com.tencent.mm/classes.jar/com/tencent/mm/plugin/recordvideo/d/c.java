package com.tencent.mm.plugin.recordvideo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ij;
import com.tencent.mm.g.b.a.ik;
import com.tencent.mm.g.b.a.jf;
import com.tencent.mm.g.b.a.jq;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/report/RecordMediaReporter;", "", "()V", "finderSheetReportSessionId", "", "info", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "lastTrace", "", "getLastTrace", "()I", "setLastTrace", "(I)V", "snsClipPageEntranceSessionId", "storyDoPublishStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDoPublishStruct;", "storyFailTraceStruct", "Lcom/tencent/mm/plugin/recordvideo/report/BehaviorTraceData;", "storyQuitPublishStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryQuitPublishStruct;", "storyTraceStruct", "traceStruct", "addReportTrace", "", "aid", "addReportValue", "key", "step", "addStoryTrace", "appendReportValue", "value", "doBehaviorReport", "scene", "doCommonReport", "doFailBehaviorReport", "doReportFinderSheetClick", "clickType", "", "doReportFinderSheetExpose", "doReportSnsClipPageEntranceExpose", "exposeType", "getBehaviorReporter", "getFailBehaviorReporter", "getRecordMediaReportInfo", "prepareNewReport", "reportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/VideoCaptureReportInfo;", "resetBehaviorReporter", "resetFailBehaviorReporter", "setFinderSheetSessionId", "sessionId", "setReportValue", "setSnsClipPageEntranceSessionId", "plugin-recordvideo_release"})
public final class c
{
  public static a BXA;
  private static jf BXB;
  private static a BXC;
  private static int BXD;
  private static jq BXE;
  private static a BXF;
  private static String BXG;
  private static String BXH;
  public static final c BXI;
  private static RecordMediaReportInfo BXz;
  
  static
  {
    AppMethodBeat.i(75839);
    BXI = new c();
    BXz = new RecordMediaReportInfo();
    BXA = new a();
    BXB = new jf();
    BXC = new a();
    BXD = -1;
    BXE = new jq();
    BXF = new a();
    BXG = "";
    BXH = "";
    AppMethodBeat.o(75839);
  }
  
  public static void HY(long paramLong)
  {
    AppMethodBeat.i(237442);
    ik localik = new ik();
    localik.rq(paramLong);
    localik.wi(BXG);
    localik.bfK();
    AppMethodBeat.o(237442);
  }
  
  public static void HZ(long paramLong)
  {
    AppMethodBeat.i(237445);
    ij localij = new ij();
    localij.ro(2L);
    localij.rp(paramLong);
    localij.wh(BXH);
    localij.bfK();
    AppMethodBeat.o(237445);
  }
  
  public static void VH(int paramInt)
  {
    AppMethodBeat.i(75834);
    BXA.VG(paramInt);
    AppMethodBeat.o(75834);
  }
  
  public static void VI(int paramInt)
  {
    AppMethodBeat.i(75836);
    if ((paramInt == 15) && ((BXD == 4) || (BXD == 10)))
    {
      BXD = paramInt;
      AppMethodBeat.o(75836);
      return;
    }
    BXD = paramInt;
    BXC.VG(paramInt);
    BXF.VG(paramInt);
    AppMethodBeat.o(75836);
  }
  
  public static void VJ(int paramInt)
  {
    AppMethodBeat.i(75837);
    if (paramInt == 3)
    {
      Object localObject1 = eKW();
      BXB.wD(String.valueOf(((Number)((RecordMediaReportInfo)localObject1).y("KEY_MUSIC_ID_INT", Integer.valueOf(0))).intValue()));
      jf localjf = BXB;
      Object localObject2 = ((RecordMediaReportInfo)localObject1).y("KEY_MUSIC_INDEX_INT", Long.valueOf(0L));
      p.g(localObject2, "commonRecordInfo.getRepo…e(KEY_MUSIC_INDEX_INT, 0)");
      localjf.rD(((Number)localObject2).longValue());
      localjf = BXB;
      localObject2 = ((RecordMediaReportInfo)localObject1).y("KEY_MUSIC_REQ_ID_INT", Long.valueOf(0L));
      p.g(localObject2, "commonRecordInfo.getRepo…(KEY_MUSIC_REQ_ID_INT, 0)");
      localjf.rE(((Number)localObject2).longValue());
      localjf = BXB;
      localObject1 = ((RecordMediaReportInfo)localObject1).y("KEY_SEARCH_MUSIC_INT", Long.valueOf(0L));
      p.g(localObject1, "commonRecordInfo.getRepo…(KEY_SEARCH_MUSIC_INT, 0)");
      localjf.rG(((Number)localObject1).longValue());
      BXB.wH(BXC.eKV());
      BXB.bfK();
      BXD = -1;
    }
    BXB = new jf();
    BXC = new a();
    AppMethodBeat.o(75837);
  }
  
  public static void VK(int paramInt)
  {
    AppMethodBeat.i(75838);
    if (paramInt == 3)
    {
      BXE.sE(System.currentTimeMillis());
      BXE.wW(BXF.eKV());
      BXE.bfK();
    }
    BXE = new jq();
    BXF = new a();
    AppMethodBeat.o(75838);
  }
  
  public static void a(VideoCaptureReportInfo paramVideoCaptureReportInfo)
  {
    AppMethodBeat.i(75831);
    BXz = new RecordMediaReportInfo();
    BXA = new a();
    if (paramVideoCaptureReportInfo != null) {}
    for (paramVideoCaptureReportInfo = Integer.valueOf(paramVideoCaptureReportInfo.sQn);; paramVideoCaptureReportInfo = Integer.valueOf(-1))
    {
      x("KEY_FROM_SCENE_INT", paramVideoCaptureReportInfo);
      AppMethodBeat.o(75831);
      return;
    }
  }
  
  public static void aLv(String paramString)
  {
    AppMethodBeat.i(237441);
    p.h(paramString, "sessionId");
    BXG = paramString;
    AppMethodBeat.o(237441);
  }
  
  public static void aLw(String paramString)
  {
    AppMethodBeat.i(237443);
    p.h(paramString, "sessionId");
    BXH = paramString;
    AppMethodBeat.o(237443);
  }
  
  public static RecordMediaReportInfo eKW()
  {
    AppMethodBeat.i(75835);
    BXz.x("KEY_ACTION_TRACE_STRING", BXA.eKV());
    RecordMediaReportInfo localRecordMediaReportInfo = BXz;
    AppMethodBeat.o(75835);
    return localRecordMediaReportInfo;
  }
  
  public static jf eKX()
  {
    return BXB;
  }
  
  public static jq eKY()
  {
    return BXE;
  }
  
  public static void eKZ()
  {
    AppMethodBeat.i(237444);
    ij localij = new ij();
    localij.ro(1L);
    localij.wh(BXH);
    localij.bfK();
    AppMethodBeat.o(237444);
  }
  
  public static void fl(String paramString, int paramInt)
  {
    AppMethodBeat.i(237440);
    p.h(paramString, "key");
    ArrayList localArrayList = (ArrayList)BXz.y(paramString, new ArrayList());
    localArrayList.add(Integer.valueOf(paramInt));
    BXz.x(paramString, localArrayList);
    AppMethodBeat.o(237440);
  }
  
  public static void x(String paramString, Object paramObject)
  {
    AppMethodBeat.i(75832);
    p.h(paramString, "key");
    p.h(paramObject, "value");
    BXz.x(paramString, paramObject);
    AppMethodBeat.o(75832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.d.c
 * JD-Core Version:    0.7.0.1
 */