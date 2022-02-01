package com.tencent.mm.plugin.scanner.model;

import android.content.Context;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import com.tencent.mm.protocal.protobuf.clg;
import com.tencent.mm.protocal.protobuf.mw;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/ScanFastFocusEngineManager;", "", "()V", "KEY_SCAN_CONFIG_GUIDE_WORDING", "", "KEY_SCAN_CONFIG_LAST_UPDATE_TIME_SUFFIX", "TAG", "THREAD_LOOP_TAG", "count", "", "focusEngineNative", "Lcom/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative;", "isAICrop", "", "isInit", "isUsingAI", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "scanPointResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "serverState", "checkAndUpdateScanConfig", "", "computeImagePHash", "Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "imageData", "", "imageWidth", "imageHeight", "slidedImage", "getCropObject", "Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "getPointObjects", "getReportString", "getScanConfigGuideWording", "init", "width", "height", "cameraRotation", "usingAI", "initMMKV", "initNetSpeed", "needUpdateScanConfig", "type", "onUpdateScanConfigSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "parseRemoteResult", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageResponse;", "source", "process", "pixelFormat", "release", "reset", "runTask", "task", "Lcom/tencent/mm/plugin/scanner/model/ScanFocusEngineTask;", "tag", "saveUpdateScanConfigTime", "timestamp", "", "setConfig", "config", "setServerState", "shouldJump", "Lcom/tencent/mm/plugin/scanner/model/ScanFrameProcessResult;", "minX", "", "minY", "maxX", "maxY", "frameId", "forceJump", "updateScanConfig", "plugin-scan_release"})
public final class x
{
  private static ScanFastFocusEngineNative CGb;
  private static int CGc;
  private static boolean CGd;
  private static boolean CGe;
  private static ae CGf;
  public static final x CGg;
  private static MultiProcessMMKV cQe;
  private static int count;
  private static boolean isInit;
  
  static
  {
    AppMethodBeat.i(52213);
    CGg = new x();
    CGb = new ScanFastFocusEngineNative();
    CGc = -1;
    CGf = new ae();
    String str = com.tencent.mm.model.z.aTY() + "_scan_config_mmkv";
    cQe = MultiProcessMMKV.getMMKV(str);
    Log.v("MicroMsg.ScanFastFocusEngineManager", "initMMKV key: %s", new Object[] { str });
    AppMethodBeat.o(52213);
  }
  
  public static final ScanImagePHashInfo M(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(240423);
    p.h(paramArrayOfByte, "imageData");
    paramArrayOfByte = CGb.computeImagePHash(paramArrayOfByte, paramInt1, paramInt2, false);
    AppMethodBeat.o(240423);
    return paramArrayOfByte;
  }
  
  private static void Ww(int paramInt)
  {
    AppMethodBeat.i(240424);
    Log.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo updateScanConfig type: %d", new Object[] { Integer.valueOf(paramInt) });
    w.a(paramInt, (w.a)new c(paramInt));
    AppMethodBeat.o(240424);
  }
  
  public static final z a(mw parammw, int paramInt)
  {
    AppMethodBeat.i(52205);
    p.h(parammw, "response");
    z localz = new z();
    if (parammw != null)
    {
      localz.dDL = parammw.dNQ;
      localz.jumpType = parammw.KRs;
      localz.CGk = parammw.KRt;
      localz.CGl = parammw.KRu;
      localz.twt = parammw.KRv;
      localz.CGm = parammw.KRw;
      localz.sessionId = parammw.KRi;
      localz.CGn = parammw.KRh;
      localz.CGo = parammw.KRy;
    }
    if (parammw.KRw != null)
    {
      if (paramInt != 1) {
        break label392;
      }
      float f1 = parammw.KRw.relative_minx;
      float f2 = parammw.KRw.relative_miny;
      float f3 = parammw.KRw.relative_maxx;
      float f4 = parammw.KRw.relative_maxy;
      paramInt = parammw.KRh;
      boolean bool = parammw.KRx;
      if (!isInit) {
        break label387;
      }
      Log.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo shouldJump minX: %f, minY: %f, maxX: %f, maxY: %f, frameId: %d, forceJump: %b", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      parammw = CGb.shouldJump(f1, f2, f3, f4, paramInt, bool);
      if (parammw != null)
      {
        localz.CGj = parammw.shouldJump;
        localz.centerX = ((parammw.minX + parammw.maxX) / 2.0F);
        f1 = parammw.minY;
        localz.centerY = ((parammw.maxY + f1) / 2.0F);
      }
    }
    for (;;)
    {
      localz.centerX = Math.max(0.0F, localz.centerX);
      localz.centerX = Math.min(1.0F, localz.centerX);
      localz.centerY = Math.max(0.0F, localz.centerY);
      localz.centerY = Math.min(1.0F, localz.centerY);
      Log.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo parseRemoteResult centerX: %f, centerY: %f", new Object[] { Float.valueOf(localz.centerX), Float.valueOf(localz.centerY) });
      AppMethodBeat.o(52205);
      return localz;
      label387:
      parammw = null;
      break;
      label392:
      if (paramInt == 2)
      {
        localz.CGj = true;
        localz.centerX = ((parammw.KRw.relative_minx + parammw.KRw.relative_maxx) / 2.0F);
        localz.centerY = ((parammw.KRw.relative_miny + parammw.KRw.relative_maxy) / 2.0F);
      }
    }
  }
  
  public static final void a(y paramy)
  {
    AppMethodBeat.i(52212);
    p.h(paramy, "task");
    count += 1;
    Log.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo runTask %d", new Object[] { Integer.valueOf(count) });
    h.RTc.b((Runnable)paramy, "AiScanImageDecodeQueue_decode_task");
    AppMethodBeat.o(52212);
  }
  
  public static final void a(y paramy, String paramString)
  {
    AppMethodBeat.i(161055);
    p.h(paramy, "task");
    p.h(paramString, "tag");
    h.RTc.b((Runnable)paramy, paramString);
    AppMethodBeat.o(161055);
  }
  
  public static final int d(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(240422);
    Log.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine isInit: %b, width: %d, height: %d, cameraRotation: %d, useAI: %b", new Object[] { Boolean.valueOf(isInit), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean) });
    if (isInit)
    {
      Log.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine has inited and ignore");
      AppMethodBeat.o(240422);
      return 0;
    }
    long l1 = System.currentTimeMillis();
    isInit = true;
    Object localObject1 = v.CFW;
    localObject1 = MMApplicationContext.getContext();
    p.g(localObject1, "MMApplicationContext.getContext()");
    p.h(localObject1, "context");
    localObject1 = v.cF((Context)localObject1) + "center_det.bin";
    Object localObject2 = v.CFW;
    localObject2 = MMApplicationContext.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    p.h(localObject2, "context");
    localObject2 = v.cF((Context)localObject2) + "center_det.param";
    paramInt2 = CGb.nativeInit(paramInt1, paramInt2, 0, 0, paramInt3, (String)localObject1, (String)localObject2, paramBoolean);
    if (!s.YS((String)localObject1)) {
      Log.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine centerBin not exist");
    }
    if (!s.YS((String)localObject2)) {
      Log.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine centerParam not exist");
    }
    CGd = CGb.isUsingAI();
    CGe = CGb.isAICrop();
    long l2 = System.currentTimeMillis();
    Log.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine result: %d, usingAI: %b, aiCrop: %b, init cost: %d", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(CGd), Boolean.valueOf(CGe), Long.valueOf(l2 - l1) });
    if (paramInt2 != 0)
    {
      AppMethodBeat.o(240422);
      return paramInt2;
    }
    localObject1 = g.azz();
    p.g(localObject1, "MMKernel.getNetSceneQueue()");
    if (((t)localObject1).aYS() != 6)
    {
      localObject1 = g.azz();
      p.g(localObject1, "MMKernel.getNetSceneQueue()");
      if (((t)localObject1).aYS() != 4) {}
    }
    else if (NetStatusUtil.getNetType(MMApplicationContext.getContext()) == 0)
    {
      paramInt1 = 0;
      Log.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo initNetSpeed: %d", new Object[] { Integer.valueOf(paramInt1) });
      CGb.setNetSpeed(paramInt1);
      Ww(2);
      localObject1 = cQe;
      if (localObject1 == null) {
        break label484;
      }
      l1 = ((MultiProcessMMKV)localObject1).getLong("scan_config_last_update_3", 0L);
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
        Ww(3);
      }
      AppMethodBeat.o(240422);
      return paramInt2;
      paramInt1 = 1;
      break;
      paramInt1 = 1;
      break;
      l1 = 0L;
      break label429;
    }
  }
  
  public static final ae ePX()
  {
    Object localObject = null;
    AppMethodBeat.i(52204);
    if (isInit)
    {
      CGf.points = CGb.getPointObjects();
      CGf.pointCount = CGb.pointCount;
      int i = CGf.pointCount;
      int j = CGf.hashCode();
      ScanPoint[] arrayOfScanPoint = CGf.points;
      if (arrayOfScanPoint != null) {
        localObject = Integer.valueOf(arrayOfScanPoint.hashCode());
      }
      Log.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo getPointObjects pointCount: %d, hashCode: %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject });
      localObject = CGf;
      AppMethodBeat.o(52204);
      return localObject;
    }
    AppMethodBeat.o(52204);
    return null;
  }
  
  public static final GoodsObject ePY()
  {
    AppMethodBeat.i(52206);
    if (isInit)
    {
      Log.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo getCropObject %f, %f, %f, %f", new Object[] { Float.valueOf(CGb.cropObject.relative_minx), Float.valueOf(CGb.cropObject.relative_maxx), Float.valueOf(CGb.cropObject.relative_miny), Float.valueOf(CGb.cropObject.relative_maxy) });
      GoodsObject localGoodsObject = CGb.cropObject;
      AppMethodBeat.o(52206);
      return localGoodsObject;
    }
    AppMethodBeat.o(52206);
    return null;
  }
  
  public static final void ePZ()
  {
    AppMethodBeat.i(52209);
    if (CGc != 0) {
      a((y)new b());
    }
    AppMethodBeat.o(52209);
  }
  
  public static final String eQa()
  {
    AppMethodBeat.i(240425);
    Object localObject = cQe;
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
    p.g(localObject, "mmkv?.getString(KEY_SCAN…_GUIDE_WORDING, \"\") ?: \"\"");
    for (;;)
    {
      try
      {
        str2 = LocaleUtil.getApplicationLanguage();
        localObject = new JSONObject((String)localObject);
        Log.i("MicroMsg.ScanFastFocusEngineManager", "getScanConfigGuideWording currentLanguage: %s", new Object[] { str2 });
        if (str2 == null)
        {
          AppMethodBeat.o(240425);
          return null;
        }
        switch (str2.hashCode())
        {
        case 3241: 
          if (!str2.equals("en")) {
            continue;
          }
          localObject = ((JSONObject)localObject).optString("desc_english");
          AppMethodBeat.o(240425);
          return localObject;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.ScanFastFocusEngineManager", (Throwable)localException, "getScanConfigGuideWording exception", new Object[0]);
        AppMethodBeat.o(240425);
        return null;
      }
      if (str2.equals("zh_CN"))
      {
        String str1 = localException.optString("desc_chinese");
        AppMethodBeat.o(240425);
        return str1;
      }
    }
  }
  
  public static final String getReportString()
  {
    AppMethodBeat.i(52211);
    if (isInit)
    {
      String str = CGb.getReportString();
      AppMethodBeat.o(52211);
      return str;
    }
    Log.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo getReportString is not init");
    AppMethodBeat.o(52211);
    return null;
  }
  
  public static final boolean isAICrop()
  {
    return CGe;
  }
  
  public static final boolean isUsingAI()
  {
    return CGd;
  }
  
  public static final ScanFastFocusEngineNative process(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(52203);
    p.h(paramArrayOfByte, "imageData");
    if (isInit)
    {
      long l1 = System.currentTimeMillis();
      CGb.resetStatus();
      ScanFastFocusEngineNative localScanFastFocusEngineNative = CGb.process(paramArrayOfByte, paramInt1, paramInt2);
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
      CGb.nativeRelease();
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
      CGb.reset();
    }
    AppMethodBeat.o(52207);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements y
  {
    a(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(52198);
      x localx = x.CGg;
      if (x.eQc())
      {
        localx = x.CGg;
        x.eQb().setConfig(this.CGh);
      }
      AppMethodBeat.o(52198);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements y
  {
    public final void run()
    {
      AppMethodBeat.i(52199);
      Log.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo setServerState: %d", new Object[] { Integer.valueOf(this.CGi) });
      x localx = x.CGg;
      x.Wx(this.CGi);
      localx = x.CGg;
      x.eQb().setServerState(this.CGi);
      AppMethodBeat.o(52199);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/model/ScanFastFocusEngineManager$updateScanConfig$1", "Lcom/tencent/mm/plugin/scanner/model/ScanConfigManager$ScanConfigSyncCallback;", "onFailed", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "plugin-scan_release"})
  public static final class c
    implements w.a
  {
    c(int paramInt) {}
    
    public final void a(clg paramclg)
    {
      AppMethodBeat.i(52200);
      if (paramclg == null)
      {
        AppMethodBeat.o(52200);
        return;
      }
      Log.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo updateScanConfig onSuccess type: %d, version: %s, config: %s", new Object[] { Integer.valueOf(paramclg.type), paramclg.version, paramclg.MqB });
      x localx = x.CGg;
      x.a(this.$type, paramclg);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.x
 * JD-Core Version:    0.7.0.1
 */