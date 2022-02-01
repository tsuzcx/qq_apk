package com.tencent.mm.plugin.recordvideo.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.nk;
import com.tencent.mm.autogen.mmdata.rpt.nm;
import com.tencent.mm.autogen.mmdata.rpt.oo;
import com.tencent.mm.autogen.mmdata.rpt.oz;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/report/RecordMediaReporter;", "", "()V", "AT_CAMERA_CHANGE", "", "AT_CLICK_BACK", "AT_CLICK_BACK_BTN", "AT_CLICK_EMOJI_BTN", "AT_CLICK_IMAGE_CROP", "AT_CLICK_MASANKE", "AT_CLICK_MUSIC_BTN", "AT_CLICK_NEXT", "AT_CLICK_PAINT_BTN", "AT_CLICK_PAINT_MASANKE", "AT_CLICK_TEXT_BTN", "AT_CLICK_VIDEO_CROP", "AT_RECORD", "finderSheetReportSessionId", "", "info", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "lastTrace", "getLastTrace", "()I", "setLastTrace", "(I)V", "snsClipPageEntranceSessionId", "storyDoPublishStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDoPublishStruct;", "storyFailTraceStruct", "Lcom/tencent/mm/plugin/recordvideo/report/BehaviorTraceData;", "storyQuitPublishStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryQuitPublishStruct;", "storyTraceStruct", "traceStruct", "getTraceStruct", "()Lcom/tencent/mm/plugin/recordvideo/report/BehaviorTraceData;", "setTraceStruct", "(Lcom/tencent/mm/plugin/recordvideo/report/BehaviorTraceData;)V", "addReportLongValue", "", "key", "step", "", "addReportTrace", "aid", "addReportValue", "addStoryTrace", "appendReportString", "value", "appendReportValue", "doBehaviorReport", "scene", "doCommonReport", "doFailBehaviorReport", "doReportFinderSheetClick", "clickType", "doReportFinderSheetExpose", "doReportSnsClipPageEntranceExpose", "exposeType", "getBehaviorReporter", "getFailBehaviorReporter", "getRecordMediaReportInfo", "prepareNewReport", "reportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/VideoCaptureReportInfo;", "resetBehaviorReporter", "resetFailBehaviorReporter", "setFinderSheetSessionId", "sessionId", "setReportValue", "setSnsClipPageEntranceSessionId", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c NRf;
  private static RecordMediaReportInfo NRg;
  public static a NRh;
  private static oo NRi;
  private static a NRj;
  private static int NRk;
  private static oz NRl;
  private static a NRm;
  private static String NRn;
  private static String NRo;
  
  static
  {
    AppMethodBeat.i(75839);
    NRf = new c();
    NRg = new RecordMediaReportInfo();
    NRh = new a();
    NRi = new oo();
    NRj = new a();
    NRk = -1;
    NRl = new oz();
    NRm = new a();
    NRn = "";
    NRo = "";
    AppMethodBeat.o(75839);
  }
  
  public static void I(String paramString, Object paramObject)
  {
    AppMethodBeat.i(75832);
    s.u(paramString, "key");
    s.u(paramObject, "value");
    NRg.I(paramString, paramObject);
    AppMethodBeat.o(75832);
  }
  
  public static void a(VideoCaptureReportInfo paramVideoCaptureReportInfo)
  {
    AppMethodBeat.i(75831);
    NRg = new RecordMediaReportInfo();
    NRh = new a();
    if (paramVideoCaptureReportInfo == null) {}
    for (int i = -1;; i = paramVideoCaptureReportInfo.ybL)
    {
      I("KEY_FROM_SCENE_INT", Integer.valueOf(i));
      AppMethodBeat.o(75831);
      return;
    }
  }
  
  public static void aTh(String paramString)
  {
    AppMethodBeat.i(279451);
    s.u(paramString, "sessionId");
    NRn = paramString;
    AppMethodBeat.o(279451);
  }
  
  public static void aTi(String paramString)
  {
    AppMethodBeat.i(279456);
    s.u(paramString, "sessionId");
    NRo = paramString;
    AppMethodBeat.o(279456);
  }
  
  public static void agG(int paramInt)
  {
    AppMethodBeat.i(75834);
    NRh.agF(paramInt);
    AppMethodBeat.o(75834);
  }
  
  public static void agH(int paramInt)
  {
    AppMethodBeat.i(75836);
    if ((paramInt == 15) && ((NRk == 4) || (NRk == 10)))
    {
      NRk = paramInt;
      AppMethodBeat.o(75836);
      return;
    }
    NRk = paramInt;
    NRj.agF(paramInt);
    NRm.agF(paramInt);
    AppMethodBeat.o(75836);
  }
  
  public static void agI(int paramInt)
  {
    AppMethodBeat.i(75837);
    if (paramInt == 3)
    {
      Object localObject1 = gJe();
      NRi.wn(String.valueOf(((RecordMediaReportInfo)localObject1).J("KEY_MUSIC_ID_INT", Integer.valueOf(0))));
      oo localoo = NRi;
      Object localObject2 = ((RecordMediaReportInfo)localObject1).J("KEY_MUSIC_INDEX_INT", Long.valueOf(0L));
      s.s(localObject2, "commonRecordInfo.getRepo…e(KEY_MUSIC_INDEX_INT, 0)");
      localoo.jjA = ((Number)localObject2).longValue();
      localoo = NRi;
      localObject2 = ((RecordMediaReportInfo)localObject1).J("KEY_MUSIC_REQ_ID_INT", Long.valueOf(0L));
      s.s(localObject2, "commonRecordInfo.getRepo…(KEY_MUSIC_REQ_ID_INT, 0)");
      localoo.itJ = ((Number)localObject2).longValue();
      localoo = NRi;
      localObject1 = ((RecordMediaReportInfo)localObject1).J("KEY_SEARCH_MUSIC_INT", Long.valueOf(0L));
      s.s(localObject1, "commonRecordInfo.getRepo…(KEY_SEARCH_MUSIC_INT, 0)");
      localoo.itK = ((Number)localObject1).longValue();
      localObject1 = NRi;
      ((oo)localObject1).itP = ((oo)localObject1).F("ActionTrace", NRj.gJd(), true);
      NRi.bMH();
      NRk = -1;
    }
    NRi = new oo();
    NRj = new a();
    AppMethodBeat.o(75837);
  }
  
  public static void agJ(int paramInt)
  {
    AppMethodBeat.i(75838);
    if (paramInt == 3)
    {
      NRl.jkU = System.currentTimeMillis();
      oz localoz = NRl;
      localoz.jla = localoz.F("NewActionTrace", NRm.gJd(), true);
      NRl.bMH();
    }
    NRl = new oz();
    NRm = new a();
    AppMethodBeat.o(75838);
  }
  
  public static void bu(String paramString, long paramLong)
  {
    AppMethodBeat.i(279430);
    s.u(paramString, "key");
    Long localLong = (Long)NRg.J(paramString, Long.valueOf(0L));
    NRg.I(paramString, Long.valueOf(localLong.longValue() + paramLong));
    AppMethodBeat.o(279430);
  }
  
  public static void gF(String paramString, int paramInt)
  {
    AppMethodBeat.i(279421);
    s.u(paramString, "key");
    ArrayList localArrayList = (ArrayList)NRg.J(paramString, new ArrayList());
    localArrayList.add(Integer.valueOf(paramInt));
    NRg.I(paramString, localArrayList);
    AppMethodBeat.o(279421);
  }
  
  public static RecordMediaReportInfo gJe()
  {
    AppMethodBeat.i(75835);
    NRg.I("KEY_ACTION_TRACE_STRING", NRh.gJd());
    RecordMediaReportInfo localRecordMediaReportInfo = NRg;
    AppMethodBeat.o(75835);
    return localRecordMediaReportInfo;
  }
  
  public static oo gJf()
  {
    return NRi;
  }
  
  public static oz gJg()
  {
    return NRl;
  }
  
  public static void gJh()
  {
    AppMethodBeat.i(279459);
    nk localnk = new nk();
    localnk.iGF = 1L;
    localnk.vI(NRo);
    localnk.bMH();
    AppMethodBeat.o(279459);
  }
  
  public static void lm(String paramString1, String paramString2)
  {
    AppMethodBeat.i(279424);
    s.u(paramString1, "key");
    s.u(paramString2, "value");
    String str2 = (String)NRg.J(paramString1, "");
    String str1 = paramString2;
    if (!TextUtils.isEmpty((CharSequence)str2)) {
      str1 = str2 + '#' + paramString2;
    }
    NRg.I(paramString1, str1);
    AppMethodBeat.o(279424);
  }
  
  public static void ts(long paramLong)
  {
    AppMethodBeat.i(279455);
    nm localnm = new nm();
    localnm.jfm = paramLong;
    localnm.inx = localnm.F("sessionid", NRn, true);
    localnm.bMH();
    AppMethodBeat.o(279455);
  }
  
  public static void tt(long paramLong)
  {
    AppMethodBeat.i(279464);
    nk localnk = new nk();
    localnk.iGF = 2L;
    localnk.iCB = paramLong;
    localnk.vI(NRo);
    localnk.bMH();
    AppMethodBeat.o(279464);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.f.c
 * JD-Core Version:    0.7.0.1
 */