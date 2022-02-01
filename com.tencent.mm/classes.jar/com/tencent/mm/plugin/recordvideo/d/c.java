package com.tencent.mm.plugin.recordvideo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.kq;
import com.tencent.mm.f.b.a.ks;
import com.tencent.mm.f.b.a.lo;
import com.tencent.mm.f.b.a.lz;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/report/RecordMediaReporter;", "", "()V", "finderSheetReportSessionId", "", "info", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "lastTrace", "", "getLastTrace", "()I", "setLastTrace", "(I)V", "snsClipPageEntranceSessionId", "storyDoPublishStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDoPublishStruct;", "storyFailTraceStruct", "Lcom/tencent/mm/plugin/recordvideo/report/BehaviorTraceData;", "storyQuitPublishStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryQuitPublishStruct;", "storyTraceStruct", "traceStruct", "addReportTrace", "", "aid", "addReportValue", "key", "step", "addStoryTrace", "appendReportValue", "value", "doBehaviorReport", "scene", "doCommonReport", "doFailBehaviorReport", "doReportFinderSheetClick", "clickType", "", "doReportFinderSheetExpose", "doReportSnsClipPageEntranceExpose", "exposeType", "getBehaviorReporter", "getFailBehaviorReporter", "getRecordMediaReportInfo", "prepareNewReport", "reportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/VideoCaptureReportInfo;", "resetBehaviorReporter", "resetFailBehaviorReporter", "setFinderSheetSessionId", "sessionId", "setReportValue", "setSnsClipPageEntranceSessionId", "plugin-recordvideo_release"})
public final class c
{
  private static RecordMediaReportInfo HUn;
  public static a HUo;
  private static lo HUp;
  private static a HUq;
  private static int HUr;
  private static lz HUs;
  private static a HUt;
  private static String HUu;
  private static String HUv;
  public static final c HUw;
  
  static
  {
    AppMethodBeat.i(75839);
    HUw = new c();
    HUn = new RecordMediaReportInfo();
    HUo = new a();
    HUp = new lo();
    HUq = new a();
    HUr = -1;
    HUs = new lz();
    HUt = new a();
    HUu = "";
    HUv = "";
    AppMethodBeat.o(75839);
  }
  
  public static void Ps(long paramLong)
  {
    AppMethodBeat.i(228198);
    ks localks = new ks();
    localks.vk(paramLong);
    localks.BH(HUu);
    localks.bpa();
    AppMethodBeat.o(228198);
  }
  
  public static void Pt(long paramLong)
  {
    AppMethodBeat.i(228202);
    kq localkq = new kq();
    localkq.vi(2L);
    localkq.vj(paramLong);
    localkq.BG(HUv);
    localkq.bpa();
    AppMethodBeat.o(228202);
  }
  
  public static void a(VideoCaptureReportInfo paramVideoCaptureReportInfo)
  {
    AppMethodBeat.i(75831);
    HUn = new RecordMediaReportInfo();
    HUo = new a();
    if (paramVideoCaptureReportInfo != null) {}
    for (paramVideoCaptureReportInfo = Integer.valueOf(paramVideoCaptureReportInfo.wwk);; paramVideoCaptureReportInfo = Integer.valueOf(-1))
    {
      w("KEY_FROM_SCENE_INT", paramVideoCaptureReportInfo);
      AppMethodBeat.o(75831);
      return;
    }
  }
  
  public static void aVZ(String paramString)
  {
    AppMethodBeat.i(228197);
    p.k(paramString, "sessionId");
    HUu = paramString;
    AppMethodBeat.o(228197);
  }
  
  public static void aWa(String paramString)
  {
    AppMethodBeat.i(228199);
    p.k(paramString, "sessionId");
    HUv = paramString;
    AppMethodBeat.o(228199);
  }
  
  public static void acq(int paramInt)
  {
    AppMethodBeat.i(75834);
    HUo.acp(paramInt);
    AppMethodBeat.o(75834);
  }
  
  public static void acr(int paramInt)
  {
    AppMethodBeat.i(75836);
    if ((paramInt == 15) && ((HUr == 4) || (HUr == 10)))
    {
      HUr = paramInt;
      AppMethodBeat.o(75836);
      return;
    }
    HUr = paramInt;
    HUq.acp(paramInt);
    HUt.acp(paramInt);
    AppMethodBeat.o(75836);
  }
  
  public static void acs(int paramInt)
  {
    AppMethodBeat.i(75837);
    if (paramInt == 3)
    {
      Object localObject1 = fxp();
      HUp.Ce(String.valueOf(((Number)((RecordMediaReportInfo)localObject1).x("KEY_MUSIC_ID_INT", Integer.valueOf(0))).intValue()));
      lo locallo = HUp;
      Object localObject2 = ((RecordMediaReportInfo)localObject1).x("KEY_MUSIC_INDEX_INT", Long.valueOf(0L));
      p.j(localObject2, "commonRecordInfo.getRepo…e(KEY_MUSIC_INDEX_INT, 0)");
      locallo.vF(((Number)localObject2).longValue());
      locallo = HUp;
      localObject2 = ((RecordMediaReportInfo)localObject1).x("KEY_MUSIC_REQ_ID_INT", Long.valueOf(0L));
      p.j(localObject2, "commonRecordInfo.getRepo…(KEY_MUSIC_REQ_ID_INT, 0)");
      locallo.vG(((Number)localObject2).longValue());
      locallo = HUp;
      localObject1 = ((RecordMediaReportInfo)localObject1).x("KEY_SEARCH_MUSIC_INT", Long.valueOf(0L));
      p.j(localObject1, "commonRecordInfo.getRepo…(KEY_SEARCH_MUSIC_INT, 0)");
      locallo.vI(((Number)localObject1).longValue());
      HUp.Ci(HUq.fxo());
      HUp.bpa();
      HUr = -1;
    }
    HUp = new lo();
    HUq = new a();
    AppMethodBeat.o(75837);
  }
  
  public static void act(int paramInt)
  {
    AppMethodBeat.i(75838);
    if (paramInt == 3)
    {
      HUs.wG(System.currentTimeMillis());
      HUs.Cx(HUt.fxo());
      HUs.bpa();
    }
    HUs = new lz();
    HUt = new a();
    AppMethodBeat.o(75838);
  }
  
  public static void fN(String paramString, int paramInt)
  {
    AppMethodBeat.i(228178);
    p.k(paramString, "key");
    ArrayList localArrayList = (ArrayList)HUn.x(paramString, new ArrayList());
    localArrayList.add(Integer.valueOf(paramInt));
    HUn.w(paramString, localArrayList);
    AppMethodBeat.o(228178);
  }
  
  public static RecordMediaReportInfo fxp()
  {
    AppMethodBeat.i(75835);
    HUn.w("KEY_ACTION_TRACE_STRING", HUo.fxo());
    RecordMediaReportInfo localRecordMediaReportInfo = HUn;
    AppMethodBeat.o(75835);
    return localRecordMediaReportInfo;
  }
  
  public static lo fxq()
  {
    return HUp;
  }
  
  public static lz fxr()
  {
    return HUs;
  }
  
  public static void fxs()
  {
    AppMethodBeat.i(228200);
    kq localkq = new kq();
    localkq.vi(1L);
    localkq.BG(HUv);
    localkq.bpa();
    AppMethodBeat.o(228200);
  }
  
  public static void w(String paramString, Object paramObject)
  {
    AppMethodBeat.i(75832);
    p.k(paramString, "key");
    p.k(paramObject, "value");
    HUn.w(paramString, paramObject);
    AppMethodBeat.o(75832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.d.c
 * JD-Core Version:    0.7.0.1
 */