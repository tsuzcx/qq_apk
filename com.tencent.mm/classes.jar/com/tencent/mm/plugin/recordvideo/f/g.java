package com.tencent.mm.plugin.recordvideo.f;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.autogen.mmdata.rpt.nf;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/report/VideoWidgetReporter;", "", "()V", "TAG", "", "TYPE_FFMPEG4", "TYPE_MEDIACODEC", "TYPE_MP4V2", "TYPE_X264", "initRouterTimeStamp", "", "routeLogList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "videoLogStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/SightVideoLogStruct;", "doReport", "", "getRouteLog", "setABAPramsUseDaemon", "type", "", "setCameraDataJSON", "jsonObject", "Lcom/tencent/mm/json/JSONObject;", "setCaptureHevcEncode", "hevc", "setConfigProvider", "provider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setCropVideoEndTime", "end", "setCropVideoStartTime", "start", "setEditElementList", "editMaterials", "", "setEnterScene", "setExitTypeAndSendType", "exitType", "sendType", "setFinishRecordTimeStamp", "timeStamp", "setInitRouterTimeStamp", "setJumpToThirdApp", "setMixVideoInfo", "videoPath", "setMuxEndTimeStamp", "setMuxResult", "setMuxStartTimeStamp", "setNetType", "setPhotoAlbumVideoInfo", "setRecordCameraRet", "", "setRecordCpuCrop", "setRecordDaemon", "setRecordHighBitrateVideo", "filePath", "setRecordLowBitrateVideo", "setRemuxHevcEncode", "setRemuxMuxerType", "isUseFFmpeg", "setRouterLog", "time", "clazzName", "setRouterMap", "routeMap", "Landroid/util/SparseArray;", "Ljava/lang/Class;", "setSNSDoubleCheck", "setStartRecordTimeStamp", "setUseDaemon", "setUseSoftEncode", "isUse", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g NRB;
  public static nf NRC;
  public static long NRD;
  public static final ArrayList<String> NRE;
  
  static
  {
    AppMethodBeat.i(279490);
    NRB = new g();
    NRC = new nf();
    NRE = new ArrayList();
    AppMethodBeat.o(279490);
  }
  
  public static void Bl(boolean paramBoolean)
  {
    nf localnf = NRC;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localnf.jdL = i;
      return;
    }
  }
  
  public static void Bm(boolean paramBoolean)
  {
    nf localnf = NRC;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localnf.jdM = i;
      return;
    }
  }
  
  public static void Bn(boolean paramBoolean)
  {
    nf localnf = NRC;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localnf.jdO = i;
      return;
    }
  }
  
  public static void Bo(boolean paramBoolean)
  {
    AppMethodBeat.i(279467);
    nf localnf = NRC;
    if (paramBoolean) {}
    for (String str = "x264";; str = "mediacodec")
    {
      localnf.jeh = localnf.F("RemuxType", str, true);
      AppMethodBeat.o(279467);
      return;
    }
  }
  
  public static void Bp(boolean paramBoolean)
  {
    AppMethodBeat.i(279469);
    nf localnf = NRC;
    if (paramBoolean) {}
    for (String str = "ffmpeg";; str = "mp4v2")
    {
      localnf.jeg = localnf.F("RemuxMuxerType", str, true);
      AppMethodBeat.o(279469);
      return;
    }
  }
  
  public static void M(int... paramVarArgs)
  {
    AppMethodBeat.i(279448);
    s.u(paramVarArgs, "editMaterials");
    Object localObject = new i();
    ((i)localObject).au("emoji", paramVarArgs[0]);
    ((i)localObject).au("text", paramVarArgs[1]);
    ((i)localObject).au("music", paramVarArgs[2]);
    paramVarArgs = ((i)localObject).toString();
    s.s(paramVarArgs, "jsonObject.toString()");
    localObject = NRC;
    ((nf)localObject).jdT = ((nf)localObject).F("EditElementList", n.m(paramVarArgs, ",", ";", false), true);
    AppMethodBeat.o(279448);
  }
  
  public static void aQ(int paramInt, long paramLong)
  {
    NRC.jea = paramInt;
    NRC.jei = paramLong;
  }
  
  public static void aTj(String paramString)
  {
    AppMethodBeat.i(279439);
    paramString = f.aVX(paramString);
    nf localnf = NRC;
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      localnf.jdP = localnf.F("RecordHighBitrateVideo", paramString, true);
      AppMethodBeat.o(279439);
      return;
      String str = paramString.toString();
      paramString = str;
      if (str == null) {
        paramString = "";
      }
    }
  }
  
  public static void aTk(String paramString)
  {
    AppMethodBeat.i(279442);
    paramString = f.aVX(paramString);
    nf localnf = NRC;
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      localnf.jdQ = localnf.F("RecordLowBitrateVideo", paramString, true);
      AppMethodBeat.o(279442);
      return;
      String str = paramString.toString();
      paramString = str;
      if (str == null) {
        paramString = "";
      }
    }
  }
  
  public static void aTl(String paramString)
  {
    AppMethodBeat.i(279479);
    s.u(paramString, "videoPath");
    paramString = f.aVX(paramString);
    nf localnf = NRC;
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      localnf.jek = localnf.F("PhotoAlbumVideoInfo", paramString, true);
      AppMethodBeat.o(279479);
      return;
      paramString = paramString.toString();
      if (paramString == null)
      {
        paramString = "";
      }
      else
      {
        String str = n.m(paramString, ",", ";", false);
        paramString = str;
        if (str == null) {
          paramString = "";
        }
      }
    }
  }
  
  public static void aTm(String paramString)
  {
    AppMethodBeat.i(279481);
    s.u(paramString, "videoPath");
    paramString = f.aVX(paramString);
    nf localnf = NRC;
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      localnf.jel = localnf.F("MixVideoInfo", paramString, true);
      AppMethodBeat.o(279481);
      return;
      paramString = paramString.toString();
      if (paramString == null)
      {
        paramString = "";
      }
      else
      {
        String str = n.m(paramString, ",", ";", false);
        paramString = str;
        if (str == null) {
          paramString = "";
        }
      }
    }
  }
  
  public static void ac(long paramLong, String paramString)
  {
    AppMethodBeat.i(279445);
    s.u(paramString, "clazzName");
    i locali = new i();
    locali.t("time", paramLong - NRD);
    locali.m("clazz", paramString);
    NRE.add(locali.toString());
    AppMethodBeat.o(279445);
  }
  
  public static void agK(int paramInt)
  {
    NRC.irp = paramInt;
  }
  
  public static void agL(int paramInt)
  {
    NRC.iHU = paramInt;
  }
  
  public static void agM(int paramInt)
  {
    NRC.jdU = paramInt;
  }
  
  public static void agN(int paramInt)
  {
    NRC.jdV = paramInt;
  }
  
  public static void agO(int paramInt)
  {
    AppMethodBeat.i(279454);
    NRC.jdX = paramInt;
    aQ(1, 1L);
    AppMethodBeat.o(279454);
  }
  
  public static void agP(int paramInt)
  {
    NRC.jdZ = paramInt;
  }
  
  public static void agQ(int paramInt)
  {
    AppMethodBeat.i(279486);
    Log.i("MicroMsg.VideoWidgetReporter", s.X("setCaptureHevcEncode:", Integer.valueOf(paramInt)));
    NRC.jew = paramInt;
    AppMethodBeat.o(279486);
  }
  
  public static void agR(int paramInt)
  {
    AppMethodBeat.i(279487);
    Log.i("MicroMsg.VideoWidgetReporter", s.X("setRemuxHevcEncode:", Integer.valueOf(paramInt)));
    NRC.jex = paramInt;
    AppMethodBeat.o(279487);
  }
  
  public static void c(i parami)
  {
    AppMethodBeat.i(279474);
    if (parami == null)
    {
      AppMethodBeat.o(279474);
      return;
    }
    Object localObject = NRC;
    int i;
    if (parami.optBoolean("isUseCamera2"))
    {
      i = 2;
      ((nf)localObject).jdN = i;
      NRC.jeb = parami.optInt("CameraOpenCost");
      NRC.jec = parami.optInt("CameraFirstFrameCost");
      NRC.jed = parami.optInt("HighRecordStopWaitTime");
      NRC.jee = parami.optInt("LowRecordStopWaitTime");
      nf localnf = NRC;
      if (!parami.optBoolean("RecordMuxerType")) {
        break label223;
      }
      localObject = "ffmpeg";
      label111:
      localnf.jef = localnf.F("RecordMuxerType", (String)localObject, true);
      localObject = NRC;
      if (((nf)localObject).jen == 0L) {
        break label230;
      }
      l = NRC.jen;
      label149:
      ((nf)localObject).jen = l;
      localObject = NRC;
      if (((nf)localObject).jeo == 0L) {
        break label241;
      }
      l = NRC.jeo;
      label177:
      ((nf)localObject).jeo = l;
      localObject = NRC;
      if (((nf)localObject).jep == 0L) {
        break label252;
      }
    }
    label223:
    label230:
    label241:
    label252:
    for (long l = NRC.jep;; l = parami.optLong("PreviewSuccessTImeStamp"))
    {
      ((nf)localObject).jep = l;
      AppMethodBeat.o(279474);
      return;
      i = 1;
      break;
      localObject = "mp4v2";
      break label111;
      l = parami.optLong("OpenCameraTimeStamp");
      break label149;
      l = parami.optLong("StartPreviewTimeStamp");
      break label177;
    }
  }
  
  public static void g(SparseArray<Class<?>> paramSparseArray)
  {
    AppMethodBeat.i(279428);
    s.u(paramSparseArray, "routeMap");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    int i = 0;
    int k = paramSparseArray.size();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      localStringBuilder.append(((Class)paramSparseArray.valueAt(i)).getSimpleName()).append("#");
      if (j >= k)
      {
        localStringBuilder.append("}");
        paramSparseArray = NRC;
        paramSparseArray.jdK = paramSparseArray.F("RouterMap", localStringBuilder.toString(), true);
        AppMethodBeat.o(279428);
        return;
      }
      i = j;
    }
  }
  
  public static void gJn()
  {
    NRC.jdY = 0;
  }
  
  public static String gJo()
  {
    AppMethodBeat.i(279488);
    Object localObject = new StringBuilder();
    Iterator localIterator = ((Iterable)NRE).iterator();
    while (localIterator.hasNext()) {
      ((StringBuilder)localObject).append((String)localIterator.next()).append("#");
    }
    localObject = ((StringBuilder)localObject).toString();
    s.s(localObject, "routeLog.toString()");
    localObject = n.bV((String)localObject, ",", ";");
    AppMethodBeat.o(279488);
    return localObject;
  }
  
  public static void setConfigProvider(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(279463);
    nf localnf = NRC;
    Object localObject1;
    boolean bool;
    label43:
    int i;
    label49:
    Object localObject2;
    if (paramRecordConfigProvider == null)
    {
      localObject1 = "";
      localnf.jdS = localnf.F("EditPathList", (String)localObject1, true);
      localObject1 = NRC;
      if (paramRecordConfigProvider != null) {
        break label121;
      }
      bool = false;
      if (!bool) {
        break label135;
      }
      i = 0;
      ((nf)localObject1).jdW = i;
      localObject2 = NRC;
      if (paramRecordConfigProvider != null) {
        break label140;
      }
    }
    label135:
    label140:
    for (paramRecordConfigProvider = null;; paramRecordConfigProvider = paramRecordConfigProvider.oXZ)
    {
      localObject1 = String.valueOf(paramRecordConfigProvider);
      paramRecordConfigProvider = (RecordConfigProvider)localObject1;
      if (localObject1 == null) {
        paramRecordConfigProvider = "";
      }
      ((nf)localObject2).jej = ((nf)localObject2).F("ConfigParam", paramRecordConfigProvider, true);
      AppMethodBeat.o(279463);
      return;
      localObject2 = paramRecordConfigProvider.NId;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      label121:
      bool = s.p(paramRecordConfigProvider.NHX, Boolean.TRUE);
      break label43;
      i = 1;
      break label49;
    }
  }
  
  public static void tu(long paramLong)
  {
    NRC.jeq = paramLong;
  }
  
  public static void tv(long paramLong)
  {
    NRC.jer = paramLong;
  }
  
  public static void tw(long paramLong)
  {
    NRC.jes = paramLong;
  }
  
  public static void tx(long paramLong)
  {
    NRC.jet = paramLong;
  }
  
  public static void ty(long paramLong)
  {
    NRC.jeu = paramLong;
  }
  
  public static void tz(long paramLong)
  {
    NRC.jev = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.f.g
 * JD-Core Version:    0.7.0.1
 */