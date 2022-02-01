package com.tencent.mm.plugin.recordvideo.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.dc;
import com.tencent.mm.g.b.a.dn;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.recordvideo.jumper.VideoCaptureReportInfo;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/report/RecordMediaReporter;", "", "()V", "info", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordMediaReportInfo;", "lastTrace", "", "getLastTrace", "()I", "setLastTrace", "(I)V", "storyDoPublishStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryDoPublishStruct;", "storyFailTraceStruct", "Lcom/tencent/mm/plugin/recordvideo/report/BehaviorTraceData;", "storyQuitPublishStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/StoryQuitPublishStruct;", "storyTraceStruct", "traceStruct", "addReportTrace", "", "aid", "addReportValue", "key", "", "step", "addStoryTrace", "doBehaviorReport", "scene", "doCommonReport", "doFailBehaviorReport", "getBehaviorReporter", "getFailBehaviorReporter", "getRecordMediaReportInfo", "prepareNewReport", "reportInfo", "Lcom/tencent/mm/plugin/recordvideo/jumper/VideoCaptureReportInfo;", "resetBehaviorReporter", "resetFailBehaviorReporter", "setReportValue", "value", "plugin-recordvideo_release"})
public final class b
{
  private static RecordMediaReportInfo vpi;
  public static a vpj;
  private static dc vpk;
  private static a vpl;
  private static int vpm;
  private static dn vpn;
  private static a vpo;
  public static final b vpp;
  
  static
  {
    AppMethodBeat.i(75839);
    vpp = new b();
    vpi = new RecordMediaReportInfo();
    vpj = new a();
    vpk = new dc();
    vpl = new a();
    vpm = -1;
    vpn = new dn();
    vpo = new a();
    AppMethodBeat.o(75839);
  }
  
  public static void Ko(int paramInt)
  {
    AppMethodBeat.i(75834);
    vpj.Kn(paramInt);
    AppMethodBeat.o(75834);
  }
  
  public static void Kp(int paramInt)
  {
    AppMethodBeat.i(75836);
    if ((paramInt == 15) && ((vpm == 4) || (vpm == 10)))
    {
      vpm = paramInt;
      AppMethodBeat.o(75836);
      return;
    }
    vpm = paramInt;
    vpl.Kn(paramInt);
    vpo.Kn(paramInt);
    AppMethodBeat.o(75836);
  }
  
  public static void Kq(int paramInt)
  {
    AppMethodBeat.i(75837);
    if (paramInt == 3)
    {
      Object localObject1 = dix();
      vpk.jw(String.valueOf(((Number)((RecordMediaReportInfo)localObject1).w("KEY_MUSIC_ID_INT", Integer.valueOf(0))).intValue()));
      dc localdc = vpk;
      Object localObject2 = ((RecordMediaReportInfo)localObject1).w("KEY_MUSIC_INDEX_INT", Long.valueOf(0L));
      k.g(localObject2, "commonRecordInfo.getRepo…e(KEY_MUSIC_INDEX_INT, 0)");
      localdc.fr(((Number)localObject2).longValue());
      localdc = vpk;
      localObject2 = ((RecordMediaReportInfo)localObject1).w("KEY_MUSIC_REQ_ID_INT", Long.valueOf(0L));
      k.g(localObject2, "commonRecordInfo.getRepo…(KEY_MUSIC_REQ_ID_INT, 0)");
      localdc.fs(((Number)localObject2).longValue());
      localdc = vpk;
      localObject1 = ((RecordMediaReportInfo)localObject1).w("KEY_SEARCH_MUSIC_INT", Long.valueOf(0L));
      k.g(localObject1, "commonRecordInfo.getRepo…(KEY_SEARCH_MUSIC_INT, 0)");
      localdc.fu(((Number)localObject1).longValue());
      vpk.jA(vpl.diw());
      vpk.aBj();
      vpm = -1;
    }
    vpk = new dc();
    vpl = new a();
    AppMethodBeat.o(75837);
  }
  
  public static void Kr(int paramInt)
  {
    AppMethodBeat.i(75838);
    if (paramInt == 3)
    {
      vpn.gs(System.currentTimeMillis());
      vpn.jP(vpo.diw());
      vpn.aBj();
    }
    vpn = new dn();
    vpo = new a();
    AppMethodBeat.o(75838);
  }
  
  public static void a(VideoCaptureReportInfo paramVideoCaptureReportInfo)
  {
    AppMethodBeat.i(75831);
    vpi = new RecordMediaReportInfo();
    vpj = new a();
    if (paramVideoCaptureReportInfo != null) {}
    for (paramVideoCaptureReportInfo = Integer.valueOf(paramVideoCaptureReportInfo.pOf);; paramVideoCaptureReportInfo = Integer.valueOf(-1))
    {
      v("KEY_FROM_SCENE_INT", paramVideoCaptureReportInfo);
      AppMethodBeat.o(75831);
      return;
    }
  }
  
  public static RecordMediaReportInfo dix()
  {
    AppMethodBeat.i(75835);
    vpi.v("KEY_ACTION_TRACE_STRING", vpj.diw());
    RecordMediaReportInfo localRecordMediaReportInfo = vpi;
    AppMethodBeat.o(75835);
    return localRecordMediaReportInfo;
  }
  
  public static dc diy()
  {
    return vpk;
  }
  
  public static dn diz()
  {
    return vpn;
  }
  
  public static void v(String paramString, Object paramObject)
  {
    AppMethodBeat.i(75832);
    k.h(paramString, "key");
    k.h(paramObject, "value");
    vpi.v(paramString, paramObject);
    AppMethodBeat.o(75832);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.d.b
 * JD-Core Version:    0.7.0.1
 */