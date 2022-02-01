package com.tencent.mm.plugin.scanner.model;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import com.tencent.mm.protocal.protobuf.ctz;
import com.tencent.mm.protocal.protobuf.mn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/model/ScanFastFocusEngineManager;", "", "()V", "KEY_SCAN_CONFIG_GUIDE_WORDING", "", "KEY_SCAN_CONFIG_LAST_UPDATE_TIME_SUFFIX", "KEY_SCAN_CONFIG_PHASH_CONFIG", "SCAN_CONFIG_UPDATE_TIME_LIMIT", "", "TAG", "THREAD_LOOP_TAG", "count", "", "focusEngineNative", "Lcom/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative;", "isAICrop", "", "isInit", "isUsingAI", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "phashConfig", "scanPointResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "serverState", "checkAndUpdateScanConfig", "", "checkInitMMKV", "checkNeedUpdatePHashConfig", "checkNeedUpdateScanGuideConfig", "computeImagePHash", "Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "imageData", "", "imageWidth", "imageHeight", "slidedImage", "getCropObject", "Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "getPHashConfig", "getPointObjects", "getReportString", "getScanConfigGuideWording", "init", "width", "height", "cameraRotation", "usingAI", "initNetSpeed", "needUpdateScanConfig", "type", "onUpdateScanConfigSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "parseRemoteResult", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageResponse;", "source", "process", "pixelFormat", "release", "reset", "runTask", "task", "Lcom/tencent/mm/plugin/scanner/model/ScanFocusEngineTask;", "tag", "saveUpdateScanConfigTime", "timestamp", "setConfig", "config", "setServerState", "shouldJump", "Lcom/tencent/mm/plugin/scanner/model/ScanFrameProcessResult;", "minX", "", "minY", "maxX", "maxY", "frameId", "forceJump", "updateScanConfig", "plugin-scan_release"})
public final class v
{
  private static ScanFastFocusEngineNative ILm;
  private static int ILn;
  private static String ILo;
  private static boolean ILp;
  private static boolean ILq;
  private static ac ILr;
  public static final v ILs;
  private static MultiProcessMMKV cQO;
  private static int count;
  private static boolean isInit;
  
  static
  {
    AppMethodBeat.i(52213);
    ILs = new v();
    ILm = new ScanFastFocusEngineNative();
    ILn = -1;
    ILr = new ac();
    fCR();
    AppMethodBeat.o(52213);
  }
  
  public static final ScanImagePHashInfo O(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(219484);
    p.k(paramArrayOfByte, "imageData");
    ScanFastFocusEngineNative localScanFastFocusEngineNative = ILm;
    if (ILo == null)
    {
      localObject = cQO;
      if (localObject != null)
      {
        str = ((MultiProcessMMKV)localObject).getString("scan_config_phash_config", "");
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      ILo = (String)localObject;
    }
    fCV();
    String str = ILo;
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    localScanFastFocusEngineNative.setPHashConfig((String)localObject);
    paramArrayOfByte = ILm.computeImagePHash(paramArrayOfByte, paramInt1, paramInt2, false);
    AppMethodBeat.o(219484);
    return paramArrayOfByte;
  }
  
  public static final x a(mn parammn, int paramInt)
  {
    AppMethodBeat.i(52205);
    p.k(parammn, "response");
    x localx = new x();
    if (parammn != null)
    {
      localx.fwv = parammn.fHb;
      localx.jumpType = parammn.RSt;
      localx.ILw = parammn.RSu;
      localx.ILx = parammn.RSv;
      localx.xei = parammn.zaK;
      localx.ILy = parammn.RSw;
      localx.sessionId = parammn.RSk;
      localx.ILz = parammn.RSj;
      localx.ILA = parammn.RSy;
    }
    if (parammn.RSw != null)
    {
      if (paramInt != 1) {
        break label394;
      }
      float f1 = parammn.RSw.relative_minx;
      float f2 = parammn.RSw.relative_miny;
      float f3 = parammn.RSw.relative_maxx;
      float f4 = parammn.RSw.relative_maxy;
      paramInt = parammn.RSj;
      boolean bool = parammn.RSx;
      if (!isInit) {
        break label389;
      }
      Log.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo shouldJump minX: %f, minY: %f, maxX: %f, maxY: %f, frameId: %d, forceJump: %b", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      parammn = ILm.shouldJump(f1, f2, f3, f4, paramInt, bool);
      if (parammn != null)
      {
        localx.ILv = parammn.shouldJump;
        localx.aGt = ((parammn.minX + parammn.maxX) / 2.0F);
        f1 = parammn.minY;
        localx.aGu = ((parammn.maxY + f1) / 2.0F);
      }
    }
    for (;;)
    {
      localx.aGt = Math.max(0.0F, localx.aGt);
      localx.aGt = Math.min(1.0F, localx.aGt);
      localx.aGu = Math.max(0.0F, localx.aGu);
      localx.aGu = Math.min(1.0F, localx.aGu);
      Log.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo parseRemoteResult centerX: %f, centerY: %f", new Object[] { Float.valueOf(localx.aGt), Float.valueOf(localx.aGu) });
      AppMethodBeat.o(52205);
      return localx;
      label389:
      parammn = null;
      break;
      label394:
      if (paramInt == 2)
      {
        localx.ILv = true;
        localx.aGt = ((parammn.RSw.relative_minx + parammn.RSw.relative_maxx) / 2.0F);
        localx.aGu = ((parammn.RSw.relative_miny + parammn.RSw.relative_maxy) / 2.0F);
      }
    }
  }
  
  public static final void a(w paramw)
  {
    AppMethodBeat.i(52212);
    p.k(paramw, "task");
    count += 1;
    Log.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo runTask %d", new Object[] { Integer.valueOf(count) });
    com.tencent.e.h.ZvG.d((Runnable)paramw, "AiScanImageDecodeQueue_decode_task");
    AppMethodBeat.o(52212);
  }
  
  public static final void a(w paramw, String paramString)
  {
    AppMethodBeat.i(161055);
    p.k(paramw, "task");
    p.k(paramString, "tag");
    com.tencent.e.h.ZvG.d((Runnable)paramw, paramString);
    AppMethodBeat.o(161055);
  }
  
  private static void aQ(int paramInt, long paramLong)
  {
    AppMethodBeat.i(219495);
    Log.i("MicroMsg.ScanFastFocusEngineManager", "saveUpdateScanConfigTime type: %d, timestamp: %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    Object localObject = cQO;
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).putLong("scan_config_last_update_".concat(String.valueOf(paramInt)), paramLong);
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).apply();
        AppMethodBeat.o(219495);
        return;
      }
    }
    AppMethodBeat.o(219495);
  }
  
  private static boolean adr(int paramInt)
  {
    AppMethodBeat.i(219492);
    MultiProcessMMKV localMultiProcessMMKV = cQO;
    if (localMultiProcessMMKV != null) {}
    for (long l = localMultiProcessMMKV.getLong("scan_config_last_update_".concat(String.valueOf(paramInt)), 0L); (l == 0L) || ((l > 0L) && (System.currentTimeMillis() - l >= 86400000L)); l = 0L)
    {
      AppMethodBeat.o(219492);
      return true;
    }
    AppMethodBeat.o(219492);
    return false;
  }
  
  private static void ads(int paramInt)
  {
    AppMethodBeat.i(219498);
    Log.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo updateScanConfig type: %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 3) || (paramInt == 4)) {
      aQ(paramInt, System.currentTimeMillis());
    }
    u.a(paramInt, (u.a)new c(paramInt));
    AppMethodBeat.o(219498);
  }
  
  public static final int e(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(219427);
    Log.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine isInit: %b, width: %d, height: %d, cameraRotation: %d, useAI: %b", new Object[] { Boolean.valueOf(isInit), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean) });
    if (isInit)
    {
      Log.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine has inited and ignore");
      AppMethodBeat.o(219427);
      return 0;
    }
    long l1 = System.currentTimeMillis();
    isInit = true;
    Object localObject1 = t.ILi;
    localObject1 = MMApplicationContext.getContext();
    p.j(localObject1, "MMApplicationContext.getContext()");
    p.k(localObject1, "context");
    localObject1 = t.cC((Context)localObject1) + "center_det.bin";
    Object localObject2 = t.ILi;
    localObject2 = MMApplicationContext.getContext();
    p.j(localObject2, "MMApplicationContext.getContext()");
    p.k(localObject2, "context");
    localObject2 = t.cC((Context)localObject2) + "center_det.param";
    paramInt2 = ILm.nativeInit(paramInt1, paramInt2, 0, 0, paramInt3, (String)localObject1, (String)localObject2, paramBoolean);
    if (!com.tencent.mm.vfs.u.agG((String)localObject1)) {
      Log.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine centerBin not exist");
    }
    if (!com.tencent.mm.vfs.u.agG((String)localObject2)) {
      Log.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine centerParam not exist");
    }
    ILp = ILm.isUsingAI();
    ILq = ILm.isAICrop();
    long l2 = System.currentTimeMillis();
    Log.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine result: %d, usingAI: %b, aiCrop: %b, init cost: %d", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(ILp), Boolean.valueOf(ILq), Long.valueOf(l2 - l1) });
    if (paramInt2 != 0)
    {
      AppMethodBeat.o(219427);
      return paramInt2;
    }
    localObject1 = com.tencent.mm.kernel.h.aGY();
    p.j(localObject1, "MMKernel.getNetSceneQueue()");
    if (((com.tencent.mm.an.t)localObject1).bih() != 6)
    {
      localObject1 = com.tencent.mm.kernel.h.aGY();
      p.j(localObject1, "MMKernel.getNetSceneQueue()");
      if (((com.tencent.mm.an.t)localObject1).bih() != 4) {}
    }
    else if (NetStatusUtil.getNetType(MMApplicationContext.getContext()) == 0)
    {
      paramInt1 = 0;
    }
    for (;;)
    {
      Log.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo initNetSpeed: %d", new Object[] { Integer.valueOf(paramInt1) });
      ILm.setNetSpeed(paramInt1);
      fCR();
      ads(2);
      if (adr(3)) {
        ads(3);
      }
      fCV();
      AppMethodBeat.o(219427);
      return paramInt2;
      paramInt1 = 1;
      continue;
      paramInt1 = 1;
    }
  }
  
  private static void fCR()
  {
    AppMethodBeat.i(219433);
    try
    {
      boolean bool = com.tencent.mm.kernel.h.aHB();
      Log.i("MicroMsg.ScanFastFocusEngineManager", "initMMKV %s, mmkv: %s", new Object[] { Boolean.valueOf(bool), cQO });
      if ((bool) && (cQO == null))
      {
        cQO = MultiProcessMMKV.getMMKV(z.bcZ() + "_scan_config_mmkv");
        AppMethodBeat.o(219433);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.ScanFastFocusEngineManager", (Throwable)localException, "alvinluo checkInitMMKV exception", new Object[0]);
      AppMethodBeat.o(219433);
    }
  }
  
  public static final ac fCS()
  {
    Object localObject = null;
    AppMethodBeat.i(52204);
    if (isInit)
    {
      ILr.points = ILm.getPointObjects();
      ILr.pointCount = ILm.pointCount;
      int i = ILr.pointCount;
      int j = ILr.hashCode();
      ScanPoint[] arrayOfScanPoint = ILr.points;
      if (arrayOfScanPoint != null) {
        localObject = Integer.valueOf(arrayOfScanPoint.hashCode());
      }
      Log.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo getPointObjects pointCount: %d, hashCode: %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject });
      localObject = ILr;
      AppMethodBeat.o(52204);
      return localObject;
    }
    AppMethodBeat.o(52204);
    return null;
  }
  
  public static final GoodsObject fCT()
  {
    AppMethodBeat.i(52206);
    if (isInit)
    {
      Log.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo getCropObject %f, %f, %f, %f", new Object[] { Float.valueOf(ILm.cropObject.relative_minx), Float.valueOf(ILm.cropObject.relative_maxx), Float.valueOf(ILm.cropObject.relative_miny), Float.valueOf(ILm.cropObject.relative_maxy) });
      GoodsObject localGoodsObject = ILm.cropObject;
      AppMethodBeat.o(52206);
      return localGoodsObject;
    }
    AppMethodBeat.o(52206);
    return null;
  }
  
  public static final void fCU()
  {
    AppMethodBeat.i(52209);
    if (ILn != 0) {
      a((w)new b());
    }
    AppMethodBeat.o(52209);
  }
  
  private static void fCV()
  {
    AppMethodBeat.i(219486);
    if (adr(4)) {
      ads(4);
    }
    AppMethodBeat.o(219486);
  }
  
  public static final String fCW()
  {
    AppMethodBeat.i(219510);
    Object localObject = cQO;
    String str2;
    if (localObject != null)
    {
      str2 = ((MultiProcessMMKV)localObject).getString("scan_config_guide_wording", "");
      localObject = str2;
      if (str2 != null) {}
    }
    else
    {
      localObject = "";
    }
    p.j(localObject, "mmkv?.getString(KEY_SCAN…_GUIDE_WORDING, \"\") ?: \"\"");
    for (;;)
    {
      try
      {
        str2 = LocaleUtil.getApplicationLanguage();
        localObject = new JSONObject((String)localObject);
        Log.i("MicroMsg.ScanFastFocusEngineManager", "getScanConfigGuideWording currentLanguage: %s", new Object[] { str2 });
        if (str2 == null)
        {
          AppMethodBeat.o(219510);
          return null;
        }
        switch (str2.hashCode())
        {
        case 3241: 
          if (!str2.equals("en")) {
            continue;
          }
          localObject = ((JSONObject)localObject).optString("desc_english");
          AppMethodBeat.o(219510);
          return localObject;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.ScanFastFocusEngineManager", (Throwable)localException, "getScanConfigGuideWording exception", new Object[0]);
        AppMethodBeat.o(219510);
        return null;
      }
      if (str2.equals("zh_CN"))
      {
        String str1 = localException.optString("desc_chinese");
        AppMethodBeat.o(219510);
        return str1;
      }
    }
  }
  
  public static final String getReportString()
  {
    AppMethodBeat.i(52211);
    if (isInit)
    {
      String str = ILm.getReportString();
      AppMethodBeat.o(52211);
      return str;
    }
    Log.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo getReportString is not init");
    AppMethodBeat.o(52211);
    return null;
  }
  
  public static final boolean isAICrop()
  {
    return ILq;
  }
  
  public static final boolean isUsingAI()
  {
    return ILp;
  }
  
  public static final ScanFastFocusEngineNative process(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(52203);
    p.k(paramArrayOfByte, "imageData");
    if (isInit)
    {
      long l1 = System.currentTimeMillis();
      ILm.resetStatus();
      ScanFastFocusEngineNative localScanFastFocusEngineNative = ILm.process(paramArrayOfByte, paramInt1, paramInt2);
      long l2 = System.currentTimeMillis();
      Integer localInteger1;
      if (localScanFastFocusEngineNative != null)
      {
        paramArrayOfByte = Integer.valueOf(localScanFastFocusEngineNative.result);
        if (localScanFastFocusEngineNative == null) {
          break label180;
        }
        localInteger1 = Integer.valueOf(localScanFastFocusEngineNative.width);
        label76:
        if (localScanFastFocusEngineNative == null) {
          break label186;
        }
      }
      label180:
      label186:
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
        Log.d("MicroMsg.ScanFastFocusEngineManager", "alvinluo process result: %s, cost: %d, width: %d, height: %d, bestImageData: %s", new Object[] { paramArrayOfByte, Long.valueOf(l2 - l1), localInteger1, localInteger2, localObject1 });
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
    if (isInit)
    {
      Log.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo release");
      ILm.nativeRelease();
      isInit = false;
    }
    AppMethodBeat.o(52208);
  }
  
  public static final void reset()
  {
    AppMethodBeat.i(52207);
    if (isInit)
    {
      Log.d("MicroMsg.ScanFastFocusEngineManager", "alvinluo focusEngineNative reset");
      ILm.reset();
    }
    AppMethodBeat.o(52207);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements w
  {
    a(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(52198);
      v localv = v.ILs;
      if (v.fCY())
      {
        localv = v.ILs;
        v.fCX().setConfig(this.ILt);
      }
      AppMethodBeat.o(52198);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements w
  {
    public final void run()
    {
      AppMethodBeat.i(52199);
      Log.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo setServerState: %d", new Object[] { Integer.valueOf(this.ILu) });
      v localv = v.ILs;
      v.adt(this.ILu);
      localv = v.ILs;
      v.fCX().setServerState(this.ILu);
      AppMethodBeat.o(52199);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineManager$updateScanConfig$1", "Lcom/tencent/mm/plugin/scanner/model/ScanConfigManager$ScanConfigSyncCallback;", "onFailed", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "plugin-scan_release"})
  public static final class c
    implements u.a
  {
    c(int paramInt) {}
    
    public final void a(ctz paramctz)
    {
      AppMethodBeat.i(52200);
      if (paramctz == null)
      {
        AppMethodBeat.o(52200);
        return;
      }
      Log.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo updateScanConfig onSuccess type: %d, version: %s, config: %s", new Object[] { Integer.valueOf(paramctz.type), paramctz.version, paramctz.TBE });
      v localv = v.ILs;
      v.a(this.cPi, paramctz);
      AppMethodBeat.o(52200);
    }
    
    public final void p(int paramInt1, int paramInt2, String paramString)
    {
      AppMethodBeat.i(52201);
      Log.e("MicroMsg.ScanFastFocusEngineManager", "alvinluo updateScanConfig onFailed errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(52201);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.v
 * JD-Core Version:    0.7.0.1
 */