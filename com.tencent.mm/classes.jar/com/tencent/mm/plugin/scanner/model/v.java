package com.tencent.mm.plugin.scanner.model;

import android.content.Context;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import com.tencent.mm.protocal.protobuf.me;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/model/ScanFastFocusEngineManager;", "", "()V", "KEY_SCAN_CONFIG_GUIDE_WORDING", "", "KEY_SCAN_CONFIG_LAST_UPDATE_TIME_SUFFIX", "TAG", "THREAD_LOOP_TAG", "count", "", "focusEngineNative", "Lcom/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative;", "isAICrop", "", "isInit", "isUsingAI", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "scanPointResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "serverState", "checkAndUpdateScanConfig", "", "computeImagePHash", "Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "imageData", "", "imageWidth", "imageHeight", "slidedImage", "getCropObject", "Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "getPointObjects", "getReportString", "getScanConfigGuideWording", "init", "width", "height", "cameraRotation", "usingAI", "initMMKV", "initNetSpeed", "needUpdateScanConfig", "type", "onUpdateScanConfigSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "parseRemoteResult", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageResponse;", "source", "process", "pixelFormat", "release", "reset", "runTask", "task", "Lcom/tencent/mm/plugin/scanner/model/ScanFocusEngineTask;", "tag", "saveUpdateScanConfigTime", "timestamp", "", "setConfig", "config", "setServerState", "shouldJump", "Lcom/tencent/mm/plugin/scanner/model/ScanFrameProcessResult;", "minX", "", "minY", "maxX", "maxY", "frameId", "forceJump", "updateScanConfig", "plugin-scan_release"})
public final class v
{
  private static boolean cBE;
  private static ay cCf;
  private static int count;
  private static ScanFastFocusEngineNative yDm;
  private static int yDn;
  private static boolean yDo;
  private static boolean yDp;
  private static ac yDq;
  public static final v yDr;
  
  static
  {
    AppMethodBeat.i(52213);
    yDr = new v();
    yDm = new ScanFastFocusEngineNative();
    yDn = -1;
    yDq = new ac();
    String str = com.tencent.mm.model.v.aAC() + "_scan_config_mmkv";
    cCf = ay.aRW(str);
    ae.v("MicroMsg.ScanFastFocusEngineManager", "initMMKV key: %s", new Object[] { str });
    AppMethodBeat.o(52213);
  }
  
  public static final ScanImagePHashInfo C(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189580);
    p.h(paramArrayOfByte, "imageData");
    paramArrayOfByte = yDm.computeImagePHash(paramArrayOfByte, paramInt1, paramInt2, false);
    AppMethodBeat.o(189580);
    return paramArrayOfByte;
  }
  
  private static void OY(int paramInt)
  {
    AppMethodBeat.i(189581);
    ae.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo updateScanConfig type: %d", new Object[] { Integer.valueOf(paramInt) });
    u.a(paramInt, (u.a)new v.c(paramInt));
    AppMethodBeat.o(189581);
  }
  
  public static final x a(me paramme, int paramInt)
  {
    AppMethodBeat.i(52205);
    p.h(paramme, "response");
    x localx = new x();
    if (paramme != null)
    {
      localx.dmw = paramme.dwj;
      localx.jumpType = paramme.FXF;
      localx.yDv = paramme.FXG;
      localx.yDw = paramme.FXH;
      localx.rSl = paramme.FXI;
      localx.yDx = paramme.FXJ;
      localx.sessionId = paramme.FXv;
      localx.yDy = paramme.FXu;
      localx.yDz = paramme.FXL;
    }
    if (paramme.FXJ != null)
    {
      if (paramInt != 1) {
        break label392;
      }
      float f1 = paramme.FXJ.relative_minx;
      float f2 = paramme.FXJ.relative_miny;
      float f3 = paramme.FXJ.relative_maxx;
      float f4 = paramme.FXJ.relative_maxy;
      paramInt = paramme.FXu;
      boolean bool = paramme.FXK;
      if (!cBE) {
        break label387;
      }
      ae.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo shouldJump minX: %f, minY: %f, maxX: %f, maxY: %f, frameId: %d, forceJump: %b", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      paramme = yDm.shouldJump(f1, f2, f3, f4, paramInt, bool);
      if (paramme != null)
      {
        localx.yDu = paramme.shouldJump;
        localx.centerX = ((paramme.minX + paramme.maxX) / 2.0F);
        f1 = paramme.minY;
        localx.centerY = ((paramme.maxY + f1) / 2.0F);
      }
    }
    for (;;)
    {
      localx.centerX = Math.max(0.0F, localx.centerX);
      localx.centerX = Math.min(1.0F, localx.centerX);
      localx.centerY = Math.max(0.0F, localx.centerY);
      localx.centerY = Math.min(1.0F, localx.centerY);
      ae.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo parseRemoteResult centerX: %f, centerY: %f", new Object[] { Float.valueOf(localx.centerX), Float.valueOf(localx.centerY) });
      AppMethodBeat.o(52205);
      return localx;
      label387:
      paramme = null;
      break;
      label392:
      if (paramInt == 2)
      {
        localx.yDu = true;
        localx.centerX = ((paramme.FXJ.relative_minx + paramme.FXJ.relative_maxx) / 2.0F);
        localx.centerY = ((paramme.FXJ.relative_miny + paramme.FXJ.relative_maxy) / 2.0F);
      }
    }
  }
  
  public static final void a(w paramw)
  {
    AppMethodBeat.i(52212);
    p.h(paramw, "task");
    count += 1;
    ae.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo runTask %d", new Object[] { Integer.valueOf(count) });
    h.MqF.f((Runnable)paramw, "AiScanImageDecodeQueue_decode_task");
    AppMethodBeat.o(52212);
  }
  
  public static final void a(w paramw, String paramString)
  {
    AppMethodBeat.i(161055);
    p.h(paramw, "task");
    p.h(paramString, "tag");
    h.MqF.f((Runnable)paramw, paramString);
    AppMethodBeat.o(161055);
  }
  
  public static final int d(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(189579);
    ae.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine isInit: %b, width: %d, height: %d, cameraRotation: %d, useAI: %b", new Object[] { Boolean.valueOf(cBE), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean) });
    if (cBE)
    {
      ae.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine has inited and ignore");
      AppMethodBeat.o(189579);
      return 0;
    }
    long l1 = System.currentTimeMillis();
    cBE = true;
    Object localObject1 = t.yDh;
    localObject1 = ak.getContext();
    p.g(localObject1, "MMApplicationContext.getContext()");
    p.h(localObject1, "context");
    localObject1 = t.cl((Context)localObject1) + "center_det.bin";
    Object localObject2 = t.yDh;
    localObject2 = ak.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    p.h(localObject2, "context");
    localObject2 = t.cl((Context)localObject2) + "center_det.param";
    paramInt2 = yDm.nativeInit(paramInt1, paramInt2, 0, 0, paramInt3, (String)localObject1, (String)localObject2, paramBoolean);
    if (!o.fB((String)localObject1)) {
      ae.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine centerBin not exist");
    }
    if (!o.fB((String)localObject2)) {
      ae.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine centerParam not exist");
    }
    yDo = yDm.isUsingAI();
    yDp = yDm.isAICrop();
    long l2 = System.currentTimeMillis();
    ae.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine result: %d, usingAI: %b, aiCrop: %b, init cost: %d", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(yDo), Boolean.valueOf(yDp), Long.valueOf(l2 - l1) });
    if (paramInt2 != 0)
    {
      AppMethodBeat.o(189579);
      return paramInt2;
    }
    localObject1 = g.ajj();
    p.g(localObject1, "MMKernel.getNetSceneQueue()");
    if (((q)localObject1).aFd() != 6)
    {
      localObject1 = g.ajj();
      p.g(localObject1, "MMKernel.getNetSceneQueue()");
      if (((q)localObject1).aFd() != 4) {}
    }
    else if (az.getNetType(ak.getContext()) == 0)
    {
      paramInt1 = 0;
      ae.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo initNetSpeed: %d", new Object[] { Integer.valueOf(paramInt1) });
      yDm.setNetSpeed(paramInt1);
      OY(2);
      localObject1 = cCf;
      if (localObject1 == null) {
        break label484;
      }
      l1 = ((ay)localObject1).getLong("scan_config_last_update_3", 0L);
      label429:
      if ((l1 != 0L) && ((l1 <= 0L) || (System.currentTimeMillis() - l1 < 86400000L))) {
        break label490;
      }
    }
    label484:
    label490:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        OY(3);
      }
      AppMethodBeat.o(189579);
      return paramInt2;
      paramInt1 = 1;
      break;
      paramInt1 = 1;
      break;
      l1 = 0L;
      break label429;
    }
  }
  
  public static final ac dOr()
  {
    Object localObject = null;
    AppMethodBeat.i(52204);
    if (cBE)
    {
      yDq.points = yDm.getPointObjects();
      yDq.pointCount = yDm.pointCount;
      int i = yDq.pointCount;
      int j = yDq.hashCode();
      ScanPoint[] arrayOfScanPoint = yDq.points;
      if (arrayOfScanPoint != null) {
        localObject = Integer.valueOf(arrayOfScanPoint.hashCode());
      }
      ae.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo getPointObjects pointCount: %d, hashCode: %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject });
      localObject = yDq;
      AppMethodBeat.o(52204);
      return localObject;
    }
    AppMethodBeat.o(52204);
    return null;
  }
  
  public static final GoodsObject dOs()
  {
    AppMethodBeat.i(52206);
    if (cBE)
    {
      ae.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo getCropObject %f, %f, %f, %f", new Object[] { Float.valueOf(yDm.cropObject.relative_minx), Float.valueOf(yDm.cropObject.relative_maxx), Float.valueOf(yDm.cropObject.relative_miny), Float.valueOf(yDm.cropObject.relative_maxy) });
      GoodsObject localGoodsObject = yDm.cropObject;
      AppMethodBeat.o(52206);
      return localGoodsObject;
    }
    AppMethodBeat.o(52206);
    return null;
  }
  
  public static final void dOt()
  {
    AppMethodBeat.i(52209);
    if (yDn != 0) {
      a((w)new b());
    }
    AppMethodBeat.o(52209);
  }
  
  public static final String dOu()
  {
    AppMethodBeat.i(189582);
    Object localObject = cCf;
    String str2;
    if (localObject != null)
    {
      str2 = ((ay)localObject).getString("scan_config_guide_wording", "");
      localObject = str2;
      if (str2 != null) {}
    }
    else
    {
      localObject = "";
    }
    p.g(localObject, "mmkv?.getString(KEY_SCAN…_GUIDE_WORDING, \"\") ?: \"\"");
    for (;;)
    {
      try
      {
        str2 = ad.fom();
        localObject = new JSONObject((String)localObject);
        ae.i("MicroMsg.ScanFastFocusEngineManager", "getScanConfigGuideWording currentLanguage: %s", new Object[] { str2 });
        if (str2 == null)
        {
          AppMethodBeat.o(189582);
          return null;
        }
        switch (str2.hashCode())
        {
        case 3241: 
          if (!str2.equals("en")) {
            continue;
          }
          localObject = ((JSONObject)localObject).optString("desc_english");
          AppMethodBeat.o(189582);
          return localObject;
        }
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.ScanFastFocusEngineManager", (Throwable)localException, "getScanConfigGuideWording exception", new Object[0]);
        AppMethodBeat.o(189582);
        return null;
      }
      if (str2.equals("zh_CN"))
      {
        String str1 = localException.optString("desc_chinese");
        AppMethodBeat.o(189582);
        return str1;
      }
    }
  }
  
  public static final String getReportString()
  {
    AppMethodBeat.i(52211);
    if (cBE)
    {
      String str = yDm.getReportString();
      AppMethodBeat.o(52211);
      return str;
    }
    ae.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo getReportString is not init");
    AppMethodBeat.o(52211);
    return null;
  }
  
  public static final boolean isAICrop()
  {
    return yDp;
  }
  
  public static final boolean isUsingAI()
  {
    return yDo;
  }
  
  public static final ScanFastFocusEngineNative process(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(52203);
    p.h(paramArrayOfByte, "imageData");
    if (cBE)
    {
      long l1 = System.currentTimeMillis();
      yDm.resetStatus();
      ScanFastFocusEngineNative localScanFastFocusEngineNative = yDm.process(paramArrayOfByte, paramInt1, paramInt2);
      long l2 = System.currentTimeMillis();
      Integer localInteger1;
      if (localScanFastFocusEngineNative != null)
      {
        paramArrayOfByte = Integer.valueOf(localScanFastFocusEngineNative.result);
        if (localScanFastFocusEngineNative == null) {
          break label179;
        }
        localInteger1 = Integer.valueOf(localScanFastFocusEngineNative.width);
        label76:
        if (localScanFastFocusEngineNative == null) {
          break label185;
        }
      }
      label179:
      label185:
      for (Integer localInteger2 = Integer.valueOf(localScanFastFocusEngineNative.height);; localInteger2 = null)
      {
        Object localObject1 = localObject2;
        if (localScanFastFocusEngineNative != null)
        {
          byte[] arrayOfByte = localScanFastFocusEngineNative.bestImageData;
          localObject1 = localObject2;
          if (arrayOfByte != null) {
            localObject1 = Integer.valueOf(arrayOfByte.length);
          }
        }
        ae.d("MicroMsg.ScanFastFocusEngineManager", "alvinluo process result: %s, cost: %d, width: %d, height: %d, bestImageData: %s", new Object[] { paramArrayOfByte, Long.valueOf(l2 - l1), localInteger1, localInteger2, localObject1 });
        AppMethodBeat.o(52203);
        return localScanFastFocusEngineNative;
        paramArrayOfByte = null;
        break;
        localInteger1 = null;
        break label76;
      }
    }
    AppMethodBeat.o(52203);
    return null;
  }
  
  public static final void release()
  {
    AppMethodBeat.i(52208);
    if (cBE)
    {
      ae.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo release");
      yDm.nativeRelease();
      cBE = false;
    }
    AppMethodBeat.o(52208);
  }
  
  public static final void reset()
  {
    AppMethodBeat.i(52207);
    if (cBE)
    {
      ae.d("MicroMsg.ScanFastFocusEngineManager", "alvinluo focusEngineNative reset");
      yDm.reset();
    }
    AppMethodBeat.o(52207);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements w
  {
    a(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(52198);
      v localv = v.yDr;
      if (v.dOw())
      {
        localv = v.yDr;
        v.dOv().setConfig(this.yDs);
      }
      AppMethodBeat.o(52198);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements w
  {
    public final void run()
    {
      AppMethodBeat.i(52199);
      ae.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo setServerState: %d", new Object[] { Integer.valueOf(this.yDt) });
      v localv = v.yDr;
      v.OZ(this.yDt);
      localv = v.yDr;
      v.dOv().setServerState(this.yDt);
      AppMethodBeat.o(52199);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.v
 * JD-Core Version:    0.7.0.1
 */