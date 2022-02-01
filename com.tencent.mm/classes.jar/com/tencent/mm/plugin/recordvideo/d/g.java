package com.tencent.mm.plugin.recordvideo.d;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.f.b.a.km;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/report/VideoWidgetReporter;", "", "()V", "TAG", "", "TYPE_FFMPEG4", "TYPE_MEDIACODEC", "TYPE_MP4V2", "TYPE_X264", "initRouterTimeStamp", "", "routeLogList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "videoLogStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/SightVideoLogStruct;", "doReport", "", "getRouteLog", "setABAPramsUseDaemon", "type", "", "setCameraDataJSON", "jsonObject", "Lcom/tencent/mm/json/JSONObject;", "setCaptureHevcEncode", "hevc", "setConfigProvider", "provider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setCropVideoEndTime", "end", "setCropVideoStartTime", "start", "setEditElementList", "editMaterials", "", "setEnterScene", "setExitTypeAndSendType", "exitType", "sendType", "setFinishRecordTimeStamp", "timeStamp", "setInitRouterTimeStamp", "setJumpToThirdApp", "setMixVideoInfo", "videoPath", "setMuxEndTimeStamp", "setMuxResult", "setMuxStartTimeStamp", "setNetType", "setPhotoAlbumVideoInfo", "setRecordCameraRet", "", "setRecordCpuCrop", "setRecordDaemon", "setRecordHighBitrateVideo", "filePath", "setRecordLowBitrateVideo", "setRemuxHevcEncode", "setRemuxMuxerType", "isUseFFmpeg", "setRouterLog", "time", "clazzName", "setRouterMap", "routeMap", "Landroid/util/SparseArray;", "Ljava/lang/Class;", "setSNSDoubleCheck", "setStartRecordTimeStamp", "setUseDaemon", "setUseSoftEncode", "isUse", "plugin-recordvideo_release"})
public final class g
{
  public static km HUJ;
  public static long HUK;
  public static final ArrayList<String> HUL;
  public static final g HUM;
  
  static
  {
    AppMethodBeat.i(221327);
    HUM = new g();
    HUJ = new km();
    HUL = new ArrayList();
    AppMethodBeat.o(221327);
  }
  
  public static void I(int... paramVarArgs)
  {
    AppMethodBeat.i(221265);
    p.k(paramVarArgs, "editMaterials");
    i locali = new i();
    locali.al("emoji", paramVarArgs[0]);
    locali.al("text", paramVarArgs[1]);
    locali.al("music", paramVarArgs[2]);
    paramVarArgs = locali.toString();
    p.j(paramVarArgs, "jsonObject.toString()");
    HUJ.Br(n.l(paramVarArgs, ",", ";", false));
    AppMethodBeat.o(221265);
  }
  
  public static void N(long paramLong, String paramString)
  {
    AppMethodBeat.i(221258);
    p.k(paramString, "clazzName");
    i locali = new i();
    locali.s("time", paramLong - HUK);
    locali.g("clazz", paramString);
    HUL.add(locali.toString());
    AppMethodBeat.o(221258);
  }
  
  public static void Pu(long paramLong)
  {
    AppMethodBeat.i(221306);
    HUJ.uU(paramLong);
    AppMethodBeat.o(221306);
  }
  
  public static void Pv(long paramLong)
  {
    AppMethodBeat.i(221307);
    HUJ.uV(paramLong);
    AppMethodBeat.o(221307);
  }
  
  public static void Pw(long paramLong)
  {
    AppMethodBeat.i(221308);
    HUJ.uW(paramLong);
    AppMethodBeat.o(221308);
  }
  
  public static void Px(long paramLong)
  {
    AppMethodBeat.i(221310);
    HUJ.uX(paramLong);
    AppMethodBeat.o(221310);
  }
  
  public static void Py(long paramLong)
  {
    AppMethodBeat.i(221312);
    HUJ.uY(paramLong);
    AppMethodBeat.o(221312);
  }
  
  public static void Pz(long paramLong)
  {
    AppMethodBeat.i(221313);
    HUJ.uZ(paramLong);
    AppMethodBeat.o(221313);
  }
  
  public static void aJ(int paramInt, long paramLong)
  {
    AppMethodBeat.i(221317);
    HUJ.ny(paramInt);
    HUJ.uP(paramLong);
    AppMethodBeat.o(221317);
  }
  
  public static void aWb(String paramString)
  {
    AppMethodBeat.i(221253);
    paramString = f.aYg(paramString);
    km localkm = HUJ;
    if (paramString != null)
    {
      String str = paramString.toString();
      paramString = str;
      if (str != null) {}
    }
    else
    {
      paramString = "";
    }
    localkm.Bn(paramString);
    AppMethodBeat.o(221253);
  }
  
  public static void aWc(String paramString)
  {
    AppMethodBeat.i(221254);
    paramString = f.aYg(paramString);
    km localkm = HUJ;
    if (paramString != null)
    {
      String str = paramString.toString();
      paramString = str;
      if (str != null) {}
    }
    else
    {
      paramString = "";
    }
    localkm.Bo(paramString);
    AppMethodBeat.o(221254);
  }
  
  public static void aWd(String paramString)
  {
    AppMethodBeat.i(221301);
    p.k(paramString, "videoPath");
    paramString = f.aYg(paramString);
    km localkm = HUJ;
    if (paramString != null)
    {
      String str = paramString.toString();
      paramString = str;
      if (str != null) {}
    }
    else
    {
      paramString = "";
    }
    localkm.Bw(paramString);
    AppMethodBeat.o(221301);
  }
  
  public static void aWe(String paramString)
  {
    AppMethodBeat.i(221303);
    p.k(paramString, "videoPath");
    paramString = f.aYg(paramString);
    km localkm = HUJ;
    if (paramString != null)
    {
      String str = paramString.toString();
      paramString = str;
      if (str != null) {}
    }
    else
    {
      paramString = "";
    }
    localkm.Bx(paramString);
    AppMethodBeat.o(221303);
  }
  
  public static void acA(int paramInt)
  {
    AppMethodBeat.i(221319);
    Log.i("MicroMsg.VideoWidgetReporter", "setCaptureHevcEncode:".concat(String.valueOf(paramInt)));
    HUJ.va(paramInt);
    AppMethodBeat.o(221319);
  }
  
  public static void acB(int paramInt)
  {
    AppMethodBeat.i(221320);
    Log.i("MicroMsg.VideoWidgetReporter", "setRemuxHevcEncode:".concat(String.valueOf(paramInt)));
    HUJ.vb(paramInt);
    AppMethodBeat.o(221320);
  }
  
  public static void acu(int paramInt)
  {
    AppMethodBeat.i(221231);
    HUJ.nn(paramInt);
    AppMethodBeat.o(221231);
  }
  
  public static void acv(int paramInt)
  {
    AppMethodBeat.i(221234);
    HUJ.no(paramInt);
    AppMethodBeat.o(221234);
  }
  
  public static void acw(int paramInt)
  {
    AppMethodBeat.i(221267);
    HUJ.nt(paramInt);
    AppMethodBeat.o(221267);
  }
  
  public static void acx(int paramInt)
  {
    AppMethodBeat.i(221269);
    HUJ.nu(paramInt);
    AppMethodBeat.o(221269);
  }
  
  public static void acy(int paramInt)
  {
    AppMethodBeat.i(221272);
    HUJ.nw(paramInt);
    aJ(1, 1L);
    AppMethodBeat.o(221272);
  }
  
  public static void acz(int paramInt)
  {
    AppMethodBeat.i(221276);
    HUJ.nx(paramInt);
    AppMethodBeat.o(221276);
  }
  
  public static void b(i parami)
  {
    AppMethodBeat.i(221299);
    if (parami == null)
    {
      AppMethodBeat.o(221299);
      return;
    }
    Object localObject = HUJ;
    int i;
    if (parami.optBoolean("isUseCamera2"))
    {
      i = 2;
      ((km)localObject).nr(i);
      HUJ.nz(parami.optInt("CameraOpenCost"));
      HUJ.nA(parami.optInt("CameraFirstFrameCost"));
      HUJ.nB(parami.optInt("HighRecordStopWaitTime"));
      HUJ.nC(parami.optInt("LowRecordStopWaitTime"));
      km localkm = HUJ;
      if (!parami.optBoolean("RecordMuxerType")) {
        break label224;
      }
      localObject = "ffmpeg";
      label117:
      localkm.Bs((String)localObject);
      localObject = HUJ;
      if (((km)localObject).amx() == 0L) {
        break label232;
      }
      l = HUJ.amx();
      label147:
      ((km)localObject).uR(l);
      localObject = HUJ;
      if (((km)localObject).amy() == 0L) {
        break label243;
      }
      l = HUJ.amy();
      label176:
      ((km)localObject).uS(l);
      localObject = HUJ;
      if (((km)localObject).amz() == 0L) {
        break label254;
      }
    }
    label224:
    label232:
    label243:
    label254:
    for (long l = HUJ.amz();; l = parami.optLong("PreviewSuccessTImeStamp"))
    {
      ((km)localObject).uT(l);
      AppMethodBeat.o(221299);
      return;
      i = 1;
      break;
      localObject = "mp4v2";
      break label117;
      l = parami.optLong("OpenCameraTimeStamp");
      break label147;
      l = parami.optLong("StartPreviewTimeStamp");
      break label176;
    }
  }
  
  public static void fxy()
  {
    AppMethodBeat.i(221274);
    HUJ.amv();
    AppMethodBeat.o(221274);
  }
  
  public static String fxz()
  {
    AppMethodBeat.i(221324);
    Object localObject = new StringBuilder();
    Iterator localIterator = ((Iterable)HUL).iterator();
    while (localIterator.hasNext()) {
      ((StringBuilder)localObject).append((String)localIterator.next()).append("#");
    }
    localObject = ((StringBuilder)localObject).toString();
    p.j(localObject, "routeLog.toString()");
    localObject = n.l((String)localObject, ",", ";", false);
    AppMethodBeat.o(221324);
    return localObject;
  }
  
  public static void g(SparseArray<Class<?>> paramSparseArray)
  {
    AppMethodBeat.i(221242);
    p.k(paramSparseArray, "routeMap");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    int j = paramSparseArray.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramSparseArray.valueAt(i);
      p.j(localObject, "routeMap.valueAt(index)");
      localObject = ((Class)localObject).getSimpleName();
      p.j(localObject, "routeMap.valueAt(index).simpleName");
      localStringBuilder.append((String)localObject).append("#");
      i += 1;
    }
    localStringBuilder.append("}");
    HUJ.Bm(localStringBuilder.toString());
    AppMethodBeat.o(221242);
  }
  
  public static void setConfigProvider(RecordConfigProvider paramRecordConfigProvider)
  {
    Object localObject2 = null;
    AppMethodBeat.i(221289);
    km localkm = HUJ;
    Object localObject1;
    if (paramRecordConfigProvider != null)
    {
      localObject3 = paramRecordConfigProvider.HLf;
      localObject1 = localObject3;
      if (localObject3 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localkm.Bq((String)localObject1);
    Object localObject3 = HUJ;
    if (paramRecordConfigProvider != null)
    {
      localObject1 = paramRecordConfigProvider.HKZ;
      if (!p.h(localObject1, Boolean.TRUE)) {
        break label123;
      }
    }
    label123:
    for (int i = 0;; i = 1)
    {
      ((km)localObject3).nv(i);
      localObject3 = HUJ;
      localObject1 = localObject2;
      if (paramRecordConfigProvider != null) {
        localObject1 = paramRecordConfigProvider.mfk;
      }
      localObject1 = String.valueOf(localObject1);
      paramRecordConfigProvider = (RecordConfigProvider)localObject1;
      if (localObject1 == null) {
        paramRecordConfigProvider = "";
      }
      ((km)localObject3).Bv(paramRecordConfigProvider);
      AppMethodBeat.o(221289);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public static void wL(boolean paramBoolean)
  {
    AppMethodBeat.i(221245);
    km localkm = HUJ;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localkm.np(i);
      AppMethodBeat.o(221245);
      return;
    }
  }
  
  public static void wM(boolean paramBoolean)
  {
    AppMethodBeat.i(221247);
    km localkm = HUJ;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localkm.nq(i);
      AppMethodBeat.o(221247);
      return;
    }
  }
  
  public static void wN(boolean paramBoolean)
  {
    AppMethodBeat.i(221249);
    km localkm = HUJ;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localkm.ns(i);
      AppMethodBeat.o(221249);
      return;
    }
  }
  
  public static void wO(boolean paramBoolean)
  {
    AppMethodBeat.i(221293);
    km localkm = HUJ;
    if (paramBoolean) {}
    for (String str = "x264";; str = "mediacodec")
    {
      localkm.Bu(str);
      AppMethodBeat.o(221293);
      return;
    }
  }
  
  public static void wP(boolean paramBoolean)
  {
    AppMethodBeat.i(221295);
    km localkm = HUJ;
    if (paramBoolean) {}
    for (String str = "ffmpeg";; str = "mp4v2")
    {
      localkm.Bt(str);
      AppMethodBeat.o(221295);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.d.g
 * JD-Core Version:    0.7.0.1
 */