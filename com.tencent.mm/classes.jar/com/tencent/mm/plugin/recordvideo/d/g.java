package com.tencent.mm.plugin.recordvideo.d;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.g.b.a.if;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/report/VideoWidgetReporter;", "", "()V", "TAG", "", "TYPE_FFMPEG4", "TYPE_MEDIACODEC", "TYPE_MP4V2", "TYPE_X264", "initRouterTimeStamp", "", "routeLogList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "videoLogStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/SightVideoLogStruct;", "doReport", "", "getRouteLog", "setABAPramsUseDaemon", "type", "", "setCameraDataJSON", "jsonObject", "Lcom/tencent/mm/json/JSONObject;", "setConfigProvider", "provider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "setCropVideoEndTime", "end", "setCropVideoStartTime", "start", "setEditElementList", "editMaterials", "", "setEnterScene", "setExitTypeAndSendType", "exitType", "sendType", "setFinishRecordTimeStamp", "timeStamp", "setInitRouterTimeStamp", "setJumpToThirdApp", "setMixVideoInfo", "videoPath", "setMuxEndTimeStamp", "setMuxResult", "setMuxStartTimeStamp", "setNetType", "setPhotoAlbumVideoInfo", "setRecordCameraRet", "", "setRecordCpuCrop", "setRecordDaemon", "setRecordHighBitrateVideo", "filePath", "setRecordLowBitrateVideo", "setRemuxMuxerType", "isUseFFmpeg", "setRouterLog", "time", "clazzName", "setRouterMap", "routeMap", "Landroid/util/SparseArray;", "Ljava/lang/Class;", "setSNSDoubleCheck", "setStartRecordTimeStamp", "setUseDaemon", "setUseSoftEncode", "isUse", "plugin-recordvideo_release"})
public final class g
{
  public static if BXV;
  public static long BXW;
  public static final ArrayList<String> BXX;
  public static final g BXY;
  
  static
  {
    AppMethodBeat.i(237475);
    BXY = new g();
    BXV = new if();
    BXX = new ArrayList();
    AppMethodBeat.o(237475);
  }
  
  public static void F(long paramLong, String paramString)
  {
    AppMethodBeat.i(237454);
    p.h(paramString, "clazzName");
    i locali = new i();
    locali.v("time", paramLong - BXW);
    locali.h("clazz", paramString);
    BXX.add(locali.toString());
    AppMethodBeat.o(237454);
  }
  
  public static void Ia(long paramLong)
  {
    AppMethodBeat.i(237467);
    BXV.rc(paramLong);
    AppMethodBeat.o(237467);
  }
  
  public static void Ib(long paramLong)
  {
    AppMethodBeat.i(237468);
    BXV.rd(paramLong);
    AppMethodBeat.o(237468);
  }
  
  public static void Ic(long paramLong)
  {
    AppMethodBeat.i(237469);
    BXV.re(paramLong);
    AppMethodBeat.o(237469);
  }
  
  public static void Id(long paramLong)
  {
    AppMethodBeat.i(237470);
    BXV.rf(paramLong);
    AppMethodBeat.o(237470);
  }
  
  public static void Ie(long paramLong)
  {
    AppMethodBeat.i(237471);
    BXV.rg(paramLong);
    AppMethodBeat.o(237471);
  }
  
  public static void If(long paramLong)
  {
    AppMethodBeat.i(237472);
    BXV.rh(paramLong);
    AppMethodBeat.o(237472);
  }
  
  public static void J(int... paramVarArgs)
  {
    AppMethodBeat.i(237455);
    p.h(paramVarArgs, "editMaterials");
    i locali = new i();
    locali.U("emoji", paramVarArgs[0]);
    locali.U("text", paramVarArgs[1]);
    locali.U("music", paramVarArgs[2]);
    paramVarArgs = locali.toString();
    p.g(paramVarArgs, "jsonObject.toString()");
    BXV.vS(n.j(paramVarArgs, ",", ";", false));
    AppMethodBeat.o(237455);
  }
  
  public static void VL(int paramInt)
  {
    AppMethodBeat.i(237446);
    BXV.lq(paramInt);
    AppMethodBeat.o(237446);
  }
  
  public static void VM(int paramInt)
  {
    AppMethodBeat.i(237447);
    BXV.lr(paramInt);
    AppMethodBeat.o(237447);
  }
  
  public static void VN(int paramInt)
  {
    AppMethodBeat.i(237456);
    BXV.lw(paramInt);
    AppMethodBeat.o(237456);
  }
  
  public static void VO(int paramInt)
  {
    AppMethodBeat.i(237457);
    BXV.lx(paramInt);
    AppMethodBeat.o(237457);
  }
  
  public static void VP(int paramInt)
  {
    AppMethodBeat.i(237458);
    BXV.lz(paramInt);
    ax(1, 1L);
    AppMethodBeat.o(237458);
  }
  
  public static void VQ(int paramInt)
  {
    AppMethodBeat.i(237460);
    BXV.lA(paramInt);
    AppMethodBeat.o(237460);
  }
  
  public static void aLA(String paramString)
  {
    AppMethodBeat.i(237466);
    p.h(paramString, "videoPath");
    paramString = e.aNx(paramString);
    if localif = BXV;
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
    localif.vY(paramString);
    AppMethodBeat.o(237466);
  }
  
  public static void aLx(String paramString)
  {
    AppMethodBeat.i(237452);
    paramString = e.aNx(paramString);
    if localif = BXV;
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
    localif.vO(paramString);
    AppMethodBeat.o(237452);
  }
  
  public static void aLy(String paramString)
  {
    AppMethodBeat.i(237453);
    paramString = e.aNx(paramString);
    if localif = BXV;
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
    localif.vP(paramString);
    AppMethodBeat.o(237453);
  }
  
  public static void aLz(String paramString)
  {
    AppMethodBeat.i(237465);
    p.h(paramString, "videoPath");
    paramString = e.aNx(paramString);
    if localif = BXV;
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
    localif.vX(paramString);
    AppMethodBeat.o(237465);
  }
  
  public static void ax(int paramInt, long paramLong)
  {
    AppMethodBeat.i(237473);
    BXV.lB(paramInt);
    BXV.qX(paramLong);
    AppMethodBeat.o(237473);
  }
  
  public static void b(i parami)
  {
    AppMethodBeat.i(237464);
    if (parami == null)
    {
      AppMethodBeat.o(237464);
      return;
    }
    Object localObject = BXV;
    int i;
    if (parami.optBoolean("isUseCamera2"))
    {
      i = 2;
      ((if)localObject).lu(i);
      BXV.lC(parami.optInt("CameraOpenCost"));
      BXV.lD(parami.optInt("CameraFirstFrameCost"));
      BXV.lE(parami.optInt("HighRecordStopWaitTime"));
      BXV.lF(parami.optInt("LowRecordStopWaitTime"));
      if localif = BXV;
      if (!parami.optBoolean("RecordMuxerType")) {
        break label224;
      }
      localObject = "ffmpeg";
      label117:
      localif.vT((String)localObject);
      localObject = BXV;
      if (((if)localObject).ahd() == 0L) {
        break label232;
      }
      l = BXV.ahd();
      label147:
      ((if)localObject).qZ(l);
      localObject = BXV;
      if (((if)localObject).ahe() == 0L) {
        break label243;
      }
      l = BXV.ahe();
      label176:
      ((if)localObject).ra(l);
      localObject = BXV;
      if (((if)localObject).ahf() == 0L) {
        break label254;
      }
    }
    label224:
    label232:
    label243:
    label254:
    for (long l = BXV.ahf();; l = parami.optLong("PreviewSuccessTImeStamp"))
    {
      ((if)localObject).rb(l);
      AppMethodBeat.o(237464);
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
  
  public static void eLf()
  {
    AppMethodBeat.i(237459);
    BXV.ahb();
    AppMethodBeat.o(237459);
  }
  
  public static String eLg()
  {
    AppMethodBeat.i(237474);
    Object localObject = new StringBuilder();
    Iterator localIterator = ((Iterable)BXX).iterator();
    while (localIterator.hasNext()) {
      ((StringBuilder)localObject).append((String)localIterator.next()).append("#");
    }
    localObject = ((StringBuilder)localObject).toString();
    p.g(localObject, "routeLog.toString()");
    localObject = n.j((String)localObject, ",", ";", false);
    AppMethodBeat.o(237474);
    return localObject;
  }
  
  public static void g(SparseArray<Class<?>> paramSparseArray)
  {
    AppMethodBeat.i(237448);
    p.h(paramSparseArray, "routeMap");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    int j = paramSparseArray.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramSparseArray.valueAt(i);
      p.g(localObject, "routeMap.valueAt(index)");
      localObject = ((Class)localObject).getSimpleName();
      p.g(localObject, "routeMap.valueAt(index).simpleName");
      localStringBuilder.append((String)localObject).append("#");
      i += 1;
    }
    localStringBuilder.append("}");
    BXV.vN(localStringBuilder.toString());
    AppMethodBeat.o(237448);
  }
  
  public static void setConfigProvider(RecordConfigProvider paramRecordConfigProvider)
  {
    Object localObject2 = null;
    AppMethodBeat.i(237461);
    if localif = BXV;
    Object localObject1;
    if (paramRecordConfigProvider != null)
    {
      localObject3 = paramRecordConfigProvider.BOz;
      localObject1 = localObject3;
      if (localObject3 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    localif.vR((String)localObject1);
    Object localObject3 = BXV;
    if (paramRecordConfigProvider != null)
    {
      localObject1 = paramRecordConfigProvider.BOt;
      if (!p.j(localObject1, Boolean.TRUE)) {
        break label125;
      }
    }
    label125:
    for (int i = 0;; i = 1)
    {
      ((if)localObject3).ly(i);
      localObject3 = BXV;
      localObject1 = localObject2;
      if (paramRecordConfigProvider != null) {
        localObject1 = paramRecordConfigProvider.BOm;
      }
      localObject1 = String.valueOf(localObject1);
      paramRecordConfigProvider = (RecordConfigProvider)localObject1;
      if (localObject1 == null) {
        paramRecordConfigProvider = "";
      }
      ((if)localObject3).vW(paramRecordConfigProvider);
      AppMethodBeat.o(237461);
      return;
      localObject1 = null;
      break;
    }
  }
  
  public static void tp(boolean paramBoolean)
  {
    AppMethodBeat.i(237449);
    if localif = BXV;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localif.ls(i);
      AppMethodBeat.o(237449);
      return;
    }
  }
  
  public static void tq(boolean paramBoolean)
  {
    AppMethodBeat.i(237450);
    if localif = BXV;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localif.lt(i);
      AppMethodBeat.o(237450);
      return;
    }
  }
  
  public static void tr(boolean paramBoolean)
  {
    AppMethodBeat.i(237451);
    if localif = BXV;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localif.lv(i);
      AppMethodBeat.o(237451);
      return;
    }
  }
  
  public static void ts(boolean paramBoolean)
  {
    AppMethodBeat.i(237462);
    if localif = BXV;
    if (paramBoolean) {}
    for (String str = "x264";; str = "mediacodec")
    {
      localif.vV(str);
      AppMethodBeat.o(237462);
      return;
    }
  }
  
  public static void tt(boolean paramBoolean)
  {
    AppMethodBeat.i(237463);
    if localif = BXV;
    if (paramBoolean) {}
    for (String str = "ffmpeg";; str = "mp4v2")
    {
      localif.vU(str);
      AppMethodBeat.o(237463);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.d.g
 * JD-Core Version:    0.7.0.1
 */