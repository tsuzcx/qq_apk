package com.tencent.mm.plugin.scanner.model;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.graphics.Point;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.scanner.api.ScanImagePHashInfo;
import com.tencent.mm.plugin.scanner.d.b.b;
import com.tencent.mm.plugin.scanner.scan_goods_new.j;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import com.tencent.mm.protocal.protobuf.ns;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/model/ScanFastFocusEngineManager;", "", "()V", "APK_FFE_MODEL_DEFAULT_VERSION", "", "KEY_SCAN_CONFIG_DISABLE_SCAN_PRODUCT_IN_MERGE_MODE", "", "KEY_SCAN_CONFIG_FOCUS_ENGINE_CONFIG", "KEY_SCAN_CONFIG_GOODS_GUIDE_WORDING", "KEY_SCAN_CONFIG_LAST_UPDATE_TIME_SUFFIX", "KEY_SCAN_CONFIG_PHASH_CONFIG", "KEY_SCAN_CONFIG_REQUEST_TIME_INTERVAL", "KEY_SCAN_CONFIG_RETRIEVAL_TIMEOUT", "KEY_SCAN_CONFIG_SCAN_MERGE_ENGINE_CONFIG", "KEY_SCAN_CONFIG_SCAN_MERGE_WORDING", "KEY_SCAN_CONFIG_SERVER_DETECT_FRAME", "KEY_SCAN_CONFIG_UPLOAD_TIMEOUT", "SCAN_CONFIG_UPDATE_TIME_LIMIT", "", "SCAN_PRODUCT_CROP_IMAGE_SIZE_EXPAND_FACTOR", "", "SCAN_PRODUCT_REQUEST_INTERVAL_IN_MS", "TAG", "THREAD_LOOP_TAG", "currentScanSession", "enableDetectByServerWhenScanNoResult", "", "focusEngineNative", "Lcom/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative;", "height", "isAICrop", "isDetectingByServer", "isInit", "isUsingAI", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "performanceHelper", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/performance/ScanProductPerformanceHelper;", "performanceSession", "phashConfig", "pureColorThres", "scanNoResultFrameLimit", "scanNoResultFrameNum", "scanPointResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "serverState", "width", "checkAndUpdateScanEngineConfig", "", "checkInitMMKV", "checkNeedUpdateFocusEngineConfig", "checkNeedUpdatePHashConfig", "checkNeedUpdateScanGoodsGuideConfig", "checkNeedUpdateScanMergeConfig", "computeImagePHash", "Lcom/tencent/mm/plugin/scanner/api/ScanImagePHashInfo;", "imageData", "", "imageWidth", "imageHeight", "slidedImage", "disableScanProductInMergeMode", "getCropObject", "Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "getCropRGBAByTrackId", "trackId", "topLeftX", "topLeftY", "bottomRightX", "bottomRightY", "getCropYUVByTrackId", "getExpandCropSize", "Landroid/graphics/RectF;", "getFullImageSize", "Landroid/graphics/Point;", "getModelConfigIntValue", "config", "section", "key", "defaultValue", "getPHashConfig", "getPointObjects", "getReidBinFilePath", "getReidParamFilePath", "getReportString", "getScanClsModelFilePath", "getScanClsParamFilePath", "getScanFocusEngineConfig", "getScanGoodsGuideWording", "getScanMergeEngineConfig", "getScanMergeEngineConfigVersion", "getScanMergeGuideWording", "getScanProductInfoList", "Lcom/tencent/mm/plugin/scanner/scan_goods_new/ScanProductResult;", "pixelFormat", "cameraRotation", "performance", "Lcom/tencent/mm/plugin/scanner/decoder/ReIdAiScanImageDecodeQueue$Performance;", "Lcom/tencent/mm/plugin/scanner/decoder/ReIdAiScanImageDecodeQueue;", "getScanProductInfoListForFullImage", "localTrackId", "rect", "getScanProductRequestInterval", "getScanProductRetrievalTimeout", "getScanProductServerConfigByKey", "regex", "configKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Integer;", "getScanProductServerDetectFrameCount", "getScanProductUploadTimeout", "getUploadFullRGBAImage", "yuvData", "getUploadFullYUVImage", "incrementScanNoResultFrame", "init", "usingAI", "useReId", "initNetSpeed", "needDetectByServer", "needUpdateScanConfig", "type", "onUpdateScanConfigSuccess", "response", "Lcom/tencent/mm/protocal/protobuf/MMBizScanConfSyncResp;", "parseRemoteResult", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageResponse;", "source", "process", "recordScanProductPerformance", "release", "reset", "resetDetectByServerStatus", "resetNoBoxCount", "resetScanNoResultFrame", "runTask", "task", "Lcom/tencent/mm/plugin/scanner/model/ScanFocusEngineTask;", "tag", "saveUpdateScanConfigTime", "timestamp", "setConfig", "setDetectingByServer", "isDetecting", "setEngineConfig", "setLocalDebugEngineConfig", "setServerState", "shouldJump", "Lcom/tencent/mm/plugin/scanner/model/ScanFrameProcessResult;", "minX", "minY", "maxX", "maxY", "frameId", "forceJump", "updateScanConfig", "updateScanProductServerConfig", "updateServerDetectFrameCount", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
{
  public static final ac OSi;
  private static boolean OSj;
  private static int OSk;
  private static int OSl;
  private static transient boolean OSm;
  private static float OSn;
  private static ScanFastFocusEngineNative OSo;
  private static int OSp;
  private static String OSq;
  private static boolean OSr;
  private static boolean OSs;
  private static aj OSt;
  private static long OSu;
  private static com.tencent.mm.plugin.scanner.scan_goods_new.a.a OSv;
  private static long OSw;
  private static MultiProcessMMKV eMf;
  private static int height;
  private static boolean isInit;
  private static int width;
  
  static
  {
    AppMethodBeat.i(52213);
    OSi = new ac();
    OSj = true;
    OSl = 20;
    OSn = 30.0F;
    OSo = new ScanFastFocusEngineNative();
    OSp = -1;
    OSt = new aj();
    OSw = -1L;
    gQW();
    AppMethodBeat.o(52213);
  }
  
  public static final ScanImagePHashInfo M(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(314330);
    kotlin.g.b.s.u(paramArrayOfByte, "imageData");
    if (!ScanFastFocusEngineNative.isSoLoaded())
    {
      AppMethodBeat.o(314330);
      return null;
    }
    ScanFastFocusEngineNative localScanFastFocusEngineNative = OSo;
    Object localObject;
    if (OSq == null)
    {
      localObject = eMf;
      if (localObject != null) {
        break label95;
      }
      localObject = "";
    }
    for (;;)
    {
      OSq = (String)localObject;
      gRb();
      String str = OSq;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localScanFastFocusEngineNative.setPHashConfig((String)localObject);
      paramArrayOfByte = OSo.computeImagePHash(paramArrayOfByte, paramInt1, paramInt2, false);
      AppMethodBeat.o(314330);
      return paramArrayOfByte;
      label95:
      str = ((MultiProcessMMKV)localObject).getString("scan_config_phash_config", "");
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
  }
  
  public static final ae a(ns paramns, int paramInt)
  {
    AppMethodBeat.i(52205);
    kotlin.g.b.s.u(paramns, "response");
    ae localae = new ae();
    if (paramns != null)
    {
      localae.hAT = paramns.hMy;
      localae.jumpType = paramns.YPT;
      localae.OSz = paramns.YPU;
      localae.OSA = paramns.YPV;
      localae.ADt = paramns.DUR;
      localae.OSB = paramns.YPW;
      localae.sessionId = paramns.YPK;
      localae.OSC = paramns.YPJ;
      localae.OSD = paramns.YPY;
    }
    if (paramns.YPW != null) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      localae.centerX = Math.max(0.0F, localae.centerX);
      localae.centerX = Math.min(1.0F, localae.centerX);
      localae.centerY = Math.max(0.0F, localae.centerY);
      localae.centerY = Math.min(1.0F, localae.centerY);
      Log.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo parseRemoteResult centerX: %f, centerY: %f", new Object[] { Float.valueOf(localae.centerX), Float.valueOf(localae.centerY) });
      AppMethodBeat.o(52205);
      return localae;
      float f1 = paramns.YPW.relative_minx;
      float f2 = paramns.YPW.relative_miny;
      float f3 = paramns.YPW.relative_maxx;
      float f4 = paramns.YPW.relative_maxy;
      paramInt = paramns.YPJ;
      boolean bool = paramns.YPX;
      if (isInit) {
        Log.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo shouldJump minX: %f, minY: %f, maxX: %f, maxY: %f, frameId: %d, forceJump: %b", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      }
      for (paramns = OSo.shouldJump(f1, f2, f3, f4, paramInt, bool); paramns != null; paramns = null)
      {
        localae.OSy = paramns.shouldJump;
        localae.centerX = ((paramns.minX + paramns.maxX) / 2.0F);
        f1 = paramns.minY;
        localae.centerY = ((paramns.maxY + f1) / 2.0F);
        break;
      }
      localae.OSy = true;
      localae.centerX = ((paramns.YPW.relative_minx + paramns.YPW.relative_maxx) / 2.0F);
      localae.centerY = ((paramns.YPW.relative_miny + paramns.YPW.relative_maxy) / 2.0F);
    }
  }
  
  public static final com.tencent.mm.plugin.scanner.scan_goods_new.k a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, b.b paramb)
  {
    AppMethodBeat.i(314267);
    kotlin.g.b.s.u(paramArrayOfByte, "imageData");
    if (isInit)
    {
      long l1 = System.currentTimeMillis();
      OSo.resetStatus();
      ScanProductInfo[] arrayOfScanProductInfo = OSo.getScanProductInfoList(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
      long l2 = System.currentTimeMillis();
      Log.d("MicroMsg.ScanFastFocusEngineManager", "getScanProductInfoList result: %d, result: %s, cost: %d, width: %d, height: %d, detectType: %d, scanNoResultFrameNum: %s", new Object[] { Integer.valueOf(OSo.trackInfoCount), arrayOfScanProductInfo, Long.valueOf(l2 - l1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), Integer.valueOf(OSo.detectType), Integer.valueOf(OSk) });
      if ((OSw != -1L) && (OSv != null))
      {
        AppMethodBeat.o(314267);
        throw null;
      }
      OSw = System.currentTimeMillis();
      if (OSv != null)
      {
        AppMethodBeat.o(314267);
        throw null;
      }
      if ((OSo.trackInfoCount > 0) && (arrayOfScanProductInfo != null))
      {
        OSk = 0;
        paramArrayOfByte = new com.tencent.mm.plugin.scanner.scan_goods_new.k();
        paramArrayOfByte.OVD = 1;
        paramArrayOfByte.OWB = OSo.trackInfoCount;
        paramInt3 = 0;
        int i = OSo.trackInfoCount;
        if (i <= 0) {
          break label563;
        }
        paramInt1 = 0;
        paramInt4 = paramInt3 + 1;
        Object localObject2 = (ScanProductInfo)kotlin.a.k.m(arrayOfScanProductInfo, paramInt3);
        paramInt2 = paramInt1;
        if (localObject2 != null)
        {
          if (((ScanProductInfo)localObject2).getShouldShow()) {
            paramInt1 = 1;
          }
          ArrayList localArrayList = paramArrayOfByte.OWA;
          Object localObject1 = new ScanProductInfo();
          ((ScanProductInfo)localObject1).copy((ScanProductInfo)localObject2);
          localObject2 = ah.aiuX;
          localObject1 = new j((ScanProductInfo)localObject1);
          ((j)localObject1).OWk.OWr = (l2 - l1);
          ((j)localObject1).OWi = false;
          localObject2 = ah.aiuX;
          localArrayList.add(localObject1);
          paramInt2 = paramInt1;
        }
        if (paramInt4 < i) {
          break label555;
        }
      }
    }
    for (;;)
    {
      if (paramb != null)
      {
        if (paramInt2 == 0) {
          break label370;
        }
        paramb.OPE += 1;
      }
      for (;;)
      {
        AppMethodBeat.o(314267);
        return paramArrayOfByte;
        label370:
        paramb.OPD += 1;
      }
      if (OSo.detectType == 2)
      {
        if (paramb != null) {
          paramb.OPD += 1;
        }
        Log.d("MicroMsg.ScanFastFocusEngineManager", "getScanProductInfoList detect by server, scanNoResultFrameNum: " + OSk + ", isDetectingByServer: " + OSm);
        paramb = new com.tencent.mm.plugin.scanner.scan_goods_new.k();
        if ((OSj) && (!OSm)) {}
        for (boolean bool = true;; bool = false)
        {
          paramb.OWC = bool;
          if (paramb.OWC)
          {
            paramb.OWD = paramArrayOfByte;
            OSm = true;
            OSk = 0;
          }
          AppMethodBeat.o(314267);
          return paramb;
        }
      }
      OSk += 1;
      Log.e("MicroMsg.ScanFastFocusEngineManager", "getScanProductInfoList result null isInit: %s", new Object[] { Boolean.valueOf(isInit) });
      AppMethodBeat.o(314267);
      return null;
      label555:
      paramInt3 = paramInt4;
      paramInt1 = paramInt2;
      break;
      label563:
      paramInt2 = 0;
    }
  }
  
  public static final void a(ad paramad)
  {
    AppMethodBeat.i(52212);
    kotlin.g.b.s.u(paramad, "task");
    com.tencent.threadpool.h.ahAA.g((Runnable)paramad, "AiScanImageDecodeQueue_decode_task");
    AppMethodBeat.o(52212);
  }
  
  public static final void a(ad paramad, String paramString)
  {
    AppMethodBeat.i(161055);
    kotlin.g.b.s.u(paramad, "task");
    kotlin.g.b.s.u(paramString, "tag");
    com.tencent.threadpool.h.ahAA.g((Runnable)paramad, paramString);
    AppMethodBeat.o(161055);
  }
  
  private static Integer aQ(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(314362);
    paramString1 = Pattern.compile(paramString2).matcher((CharSequence)paramString1);
    label312:
    label318:
    label321:
    while (paramString1.find())
    {
      int i = paramString1.groupCount();
      Log.d("MicroMsg.ScanFastFocusEngineManager", kotlin.g.b.s.X("getScanProductServerConfigByKey groupCount: ", Integer.valueOf(i)));
      if (i > 0)
      {
        paramString2 = paramString1.group();
        kotlin.g.b.s.s(paramString2, "matcher.group()");
        paramString2 = n.a((CharSequence)paramString2, new String[] { "=" });
        if (paramString2.size() >= 2)
        {
          Object localObject = (String)p.ae(paramString2, 0);
          paramString2 = (String)p.ae(paramString2, 1);
          CharSequence localCharSequence;
          boolean bool;
          if (localObject != null)
          {
            localObject = (CharSequence)localObject;
            localCharSequence = (CharSequence)paramString3;
            if ((localObject instanceof String))
            {
              bool = ((String)localObject).contentEquals(localCharSequence);
              if (bool != true) {
                break label318;
              }
            }
          }
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label321;
            }
            Log.i("MicroMsg.ScanFastFocusEngineManager", "getScanProductServerConfigByKey key: " + paramString3 + ", value: " + paramString2);
            i = Util.safeParseInt(paramString2);
            AppMethodBeat.o(314362);
            return Integer.valueOf(i);
            if ((localObject instanceof String))
            {
              bool = kotlin.g.b.s.p(localObject, localCharSequence);
              break;
            }
            if (localObject != localCharSequence)
            {
              if ((localObject == null) || (((CharSequence)localObject).length() != localCharSequence.length()))
              {
                bool = false;
                break;
              }
              int j = ((CharSequence)localObject).length();
              i = 0;
              for (;;)
              {
                if (i >= j) {
                  break label312;
                }
                if (((CharSequence)localObject).charAt(i) != localCharSequence.charAt(i))
                {
                  bool = false;
                  break;
                }
                i += 1;
              }
            }
            bool = true;
            break;
          }
        }
      }
    }
    AppMethodBeat.o(314362);
    return null;
  }
  
  private static final int aUG(String paramString)
  {
    AppMethodBeat.i(314350);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (n.bp(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(314350);
      return 0;
    }
    try
    {
      kotlin.g.b.s.u(paramString, "config");
      kotlin.g.b.s.u("NanoDetector", "section");
      kotlin.g.b.s.u("version", "key");
      i = OSo.getModelConfigIntValue(paramString, "NanoDetector", "version", 0);
      Log.i("MicroMsg.ScanFastFocusEngineManager", kotlin.g.b.s.X("getScanMergeEngineConfigVersion  version:", Integer.valueOf(i)));
      AppMethodBeat.o(314350);
      return i;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.ScanFastFocusEngineManager", (Throwable)paramString, "getScanMergeEngineConfigVersion", new Object[0]);
        i = 0;
      }
    }
  }
  
  private static final void aUH(String paramString)
  {
    AppMethodBeat.i(314421);
    kotlin.g.b.s.u(paramString, "$config");
    if (isInit) {
      OSo.setConfig(paramString);
    }
    AppMethodBeat.o(314421);
  }
  
  private static final void aUI(String paramString)
  {
    AppMethodBeat.i(314425);
    kotlin.g.b.s.u(paramString, "$config");
    int i;
    Integer localInteger;
    Object localObject1;
    boolean bool;
    label65:
    Object localObject2;
    label153:
    Object localObject3;
    label218:
    Object localObject4;
    if (((CharSequence)paramString).length() > 0)
    {
      i = 1;
      if (i != 0)
      {
        localInteger = aQ(paramString, "(.*close=[0-9]+)", "close");
        localObject1 = eMf;
        if (localObject1 != null)
        {
          if ((localInteger == null) || (localInteger.intValue() <= 0)) {
            break label382;
          }
          bool = true;
          localObject1 = ((MultiProcessMMKV)localObject1).putBoolean("scan_config_disable_scan_product", bool);
          if (localObject1 != null) {
            ((SharedPreferences.Editor)localObject1).apply();
          }
        }
        localObject1 = aQ(paramString, "(time_interval=[0-9]+)", "time_interval");
        if ((localObject1 == null) || (((Integer)localObject1).intValue() < 1000)) {
          break label387;
        }
        localObject2 = eMf;
        if (localObject2 != null)
        {
          localObject2 = ((MultiProcessMMKV)localObject2).putInt("scan_config_request_time_interval", ((Integer)localObject1).intValue());
          if (localObject2 != null) {
            ((SharedPreferences.Editor)localObject2).apply();
          }
        }
        localObject2 = aQ(paramString, "(upload_timeout=[0-9]+)", "upload_timeout");
        if ((localObject2 == null) || (((Integer)localObject2).intValue() < 5000)) {
          break label422;
        }
        localObject3 = eMf;
        if (localObject3 != null)
        {
          localObject3 = ((MultiProcessMMKV)localObject3).putInt("scan_config_upload_timeout", ((Integer)localObject2).intValue());
          if (localObject3 != null) {
            ((SharedPreferences.Editor)localObject3).apply();
          }
        }
        localObject3 = aQ(paramString, "(retrieval_timeout=[0-9]+)", "retrieval_timeout");
        if ((localObject3 == null) || (((Integer)localObject3).intValue() < 5000)) {
          break label444;
        }
        localObject4 = eMf;
        if (localObject4 != null)
        {
          localObject4 = ((MultiProcessMMKV)localObject4).putInt("scan_config_retrieval_timeout", ((Integer)localObject3).intValue());
          if (localObject4 != null) {
            ((SharedPreferences.Editor)localObject4).apply();
          }
        }
        label283:
        paramString = aQ(paramString, "(wait_max_frame=[0-9]+)", "wait_max_frame");
        if (paramString == null) {
          break label466;
        }
        localObject4 = eMf;
        if (localObject4 != null)
        {
          localObject4 = ((MultiProcessMMKV)localObject4).putInt("scan_config_server_detect_frame_count", paramString.intValue());
          if (localObject4 != null) {
            ((SharedPreferences.Editor)localObject4).apply();
          }
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.ScanFastFocusEngineManager", "updateScanProductServerConfig closeScanProduct: %s, requestInterval: %s, uploadTimeout: %s, retrievalTimeout: %s, serverDetectFrame: %s", new Object[] { localInteger, localObject1, localObject2, localObject3, paramString });
      AppMethodBeat.o(314425);
      return;
      i = 0;
      break;
      label382:
      bool = false;
      break label65;
      label387:
      localObject2 = eMf;
      if (localObject2 == null) {
        break label153;
      }
      localObject2 = ((MultiProcessMMKV)localObject2).remove("scan_config_request_time_interval");
      if (localObject2 == null) {
        break label153;
      }
      ((SharedPreferences.Editor)localObject2).apply();
      break label153;
      label422:
      localObject3 = eMf;
      if (localObject3 == null) {
        break label218;
      }
      ((MultiProcessMMKV)localObject3).remove("scan_config_upload_timeout");
      break label218;
      label444:
      localObject4 = eMf;
      if (localObject4 == null) {
        break label283;
      }
      ((MultiProcessMMKV)localObject4).remove("scan_config_retrieval_timeout");
      break label283;
      label466:
      localObject4 = eMf;
      if (localObject4 != null) {
        ((MultiProcessMMKV)localObject4).remove("scan_config_server_detect_frame_count");
      }
    }
  }
  
  private static void aX(int paramInt, long paramLong)
  {
    AppMethodBeat.i(314342);
    Log.i("MicroMsg.ScanFastFocusEngineManager", "saveUpdateScanConfigTime type: %d, timestamp: %d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(paramLong) });
    Object localObject = eMf;
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).putLong(kotlin.g.b.s.X("scan_config_last_update_", Integer.valueOf(paramInt)), paramLong);
      if (localObject != null) {
        ((SharedPreferences.Editor)localObject).apply();
      }
    }
    AppMethodBeat.o(314342);
  }
  
  public static final byte[] ab(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(314393);
    kotlin.g.b.s.u(paramArrayOfByte, "yuvData");
    if (isInit)
    {
      OSo.fullImageData = null;
      paramArrayOfByte = OSo.getUploadFullYUVImage(paramArrayOfByte, paramInt, false, OSn);
      if (paramArrayOfByte == null)
      {
        AppMethodBeat.o(314393);
        return null;
      }
      paramArrayOfByte = paramArrayOfByte.fullImageData;
      AppMethodBeat.o(314393);
      return paramArrayOfByte;
    }
    AppMethodBeat.o(314393);
    return null;
  }
  
  public static final byte[] ac(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(314398);
    kotlin.g.b.s.u(paramArrayOfByte, "yuvData");
    if (isInit)
    {
      OSo.fullImageData = null;
      paramArrayOfByte = OSo.getUploadFullRGBAImage(paramArrayOfByte, paramInt, false, OSn);
      Log.v("MicroMsg.ScanFastFocusEngineManager", "getUploadFullRGBAImage %s", new Object[] { OSo.fullImageData });
      if (paramArrayOfByte == null)
      {
        AppMethodBeat.o(314398);
        return null;
      }
      paramArrayOfByte = paramArrayOfByte.fullImageData;
      AppMethodBeat.o(314398);
      return paramArrayOfByte;
    }
    AppMethodBeat.o(314398);
    return null;
  }
  
  private static boolean ahO(int paramInt)
  {
    AppMethodBeat.i(314339);
    MultiProcessMMKV localMultiProcessMMKV = eMf;
    if (localMultiProcessMMKV == null) {}
    for (long l = 0L; (l == 0L) || ((l > 0L) && (System.currentTimeMillis() - l >= 86400000L)); l = localMultiProcessMMKV.getLong(kotlin.g.b.s.X("scan_config_last_update_", Integer.valueOf(paramInt)), 0L))
    {
      AppMethodBeat.o(314339);
      return true;
    }
    AppMethodBeat.o(314339);
    return false;
  }
  
  private static void ahP(int paramInt)
  {
    AppMethodBeat.i(314345);
    Log.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo updateScanConfig type: %d", new Object[] { Integer.valueOf(paramInt) });
    aX(paramInt, System.currentTimeMillis());
    ab.a(paramInt, (ab.a)new ac.a(paramInt));
    AppMethodBeat.o(314345);
  }
  
  private static final void ahQ(int paramInt)
  {
    AppMethodBeat.i(314416);
    Log.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo setServerState: %d", new Object[] { Integer.valueOf(paramInt) });
    OSp = paramInt;
    if (isInit) {
      OSo.setServerState(paramInt);
    }
    AppMethodBeat.o(314416);
  }
  
  public static final int b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(314247);
    Log.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine isInit: %b, width: %d, height: %d, pixelFormat: %s, cameraRotation: %d, useAI: %b", new Object[] { Boolean.valueOf(isInit), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Boolean.valueOf(paramBoolean1) });
    if (isInit)
    {
      Log.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine has inited and ignore");
      AppMethodBeat.o(314247);
      return 0;
    }
    if (!ScanFastFocusEngineNative.tryLoadLibrary())
    {
      AppMethodBeat.o(314247);
      return -1;
    }
    long l1 = System.currentTimeMillis();
    isInit = true;
    int i = paramInt4 % 360;
    Object localObject1;
    String str1;
    String str2;
    Object localObject2;
    label236:
    label255:
    Object localObject3;
    label289:
    label308:
    Object localObject4;
    label342:
    label361:
    Object localObject6;
    if (i + (((i ^ 0x168) & (-i | i)) >> 31 & 0x168) != 0)
    {
      width = paramInt2;
      height = paramInt1;
      localObject1 = aa.OSf;
      localObject1 = MMApplicationContext.getContext();
      kotlin.g.b.s.s(localObject1, "getContext()");
      str1 = aa.jv((Context)localObject1);
      localObject1 = aa.OSf;
      localObject1 = MMApplicationContext.getContext();
      kotlin.g.b.s.s(localObject1, "getContext()");
      str2 = aa.jw((Context)localObject1);
      localObject1 = com.tencent.mm.plugin.scanner.scan_goods_new.res.a.OWG.aUS("detector_model_path");
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (!n.bp((CharSequence)localObject2))) {
        break label648;
      }
      i = 1;
      if (i != 0) {
        break label654;
      }
      Log.i("MicroMsg.ScanFastFocusEngineManager", kotlin.g.b.s.X("getReidBinFilePath use download file: ", localObject1));
      localObject2 = com.tencent.mm.plugin.scanner.scan_goods_new.res.a.OWG.aUS("detector_param_path");
      localObject3 = (CharSequence)localObject2;
      if ((localObject3 != null) && (!n.bp((CharSequence)localObject3))) {
        break label682;
      }
      i = 1;
      if (i != 0) {
        break label688;
      }
      Log.i("MicroMsg.ScanFastFocusEngineManager", kotlin.g.b.s.X("getReidParamFilePath use download file: ", localObject2));
      localObject3 = com.tencent.mm.plugin.scanner.scan_goods_new.res.a.OWG.aUS("scancls_model_path");
      localObject4 = (CharSequence)localObject3;
      if ((localObject4 != null) && (!n.bp((CharSequence)localObject4))) {
        break label716;
      }
      i = 1;
      if (i != 0) {
        break label722;
      }
      Log.i("MicroMsg.ScanFastFocusEngineManager", kotlin.g.b.s.X("getScanClsModelFilePath use download file: ", localObject3));
      localObject4 = com.tencent.mm.plugin.scanner.scan_goods_new.res.a.OWG.aUS("scancls_param_path");
      localObject5 = (CharSequence)localObject4;
      if ((localObject5 != null) && (!n.bp((CharSequence)localObject5))) {
        break label750;
      }
      i = 1;
      label395:
      if (i != 0) {
        break label756;
      }
      Log.i("MicroMsg.ScanFastFocusEngineManager", kotlin.g.b.s.X("getScanClsParamFilePath use download file: ", localObject4));
      label414:
      if (!paramBoolean2) {
        break label1494;
      }
      localObject6 = localObject2;
    }
    for (Object localObject5 = localObject1;; localObject5 = str1)
    {
      paramInt3 = OSo.nativeInit(paramInt1, paramInt2, 0, paramInt3, paramInt4, (String)localObject5, (String)localObject6, (String)localObject4, (String)localObject3, paramBoolean1, paramBoolean2);
      if (!y.ZC(str1)) {
        Log.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine centerBin not exist");
      }
      if (!y.ZC(str2)) {
        Log.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine centerParam not exist");
      }
      if (!y.ZC((String)localObject1)) {
        Log.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine reidBinPath not exist");
      }
      if (!y.ZC((String)localObject2)) {
        Log.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine reidParamPath not exist");
      }
      if (!y.ZC((String)localObject3)) {
        Log.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine opBinPath not exist");
      }
      if (!y.ZC((String)localObject4)) {
        Log.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine opParamPath not exist");
      }
      OSr = OSo.isUsingAI();
      OSs = OSo.isAICrop();
      long l2 = System.currentTimeMillis();
      Log.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine result: %d, usingAI: %b, aiCrop: %b, init cost: %d", new Object[] { Integer.valueOf(paramInt3), Boolean.valueOf(OSr), Boolean.valueOf(OSs), Long.valueOf(l2 - l1) });
      if (paramInt3 != 0)
      {
        AppMethodBeat.o(314247);
        return paramInt3;
        width = paramInt1;
        height = paramInt2;
        break;
        label648:
        i = 0;
        break label236;
        label654:
        localObject1 = aa.OSf;
        localObject1 = MMApplicationContext.getContext();
        kotlin.g.b.s.s(localObject1, "getContext()");
        localObject1 = aa.jx((Context)localObject1);
        break label255;
        label682:
        i = 0;
        break label289;
        label688:
        localObject2 = aa.OSf;
        localObject2 = MMApplicationContext.getContext();
        kotlin.g.b.s.s(localObject2, "getContext()");
        localObject2 = aa.jy((Context)localObject2);
        break label308;
        label716:
        i = 0;
        break label342;
        label722:
        localObject3 = aa.OSf;
        localObject3 = MMApplicationContext.getContext();
        kotlin.g.b.s.s(localObject3, "getContext()");
        localObject3 = aa.jz((Context)localObject3);
        break label361;
        label750:
        i = 0;
        break label395;
        label756:
        localObject4 = aa.OSf;
        localObject4 = MMApplicationContext.getContext();
        kotlin.g.b.s.s(localObject4, "getContext()");
        localObject4 = aa.jA((Context)localObject4);
        break label414;
      }
      if ((com.tencent.mm.kernel.h.aZW().bFQ() == 6) || (com.tencent.mm.kernel.h.aZW().bFQ() == 4)) {
        if (NetStatusUtil.getNetType(MMApplicationContext.getContext()) == 0)
        {
          paramInt1 = 0;
          Log.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo initNetSpeed: %d", new Object[] { Integer.valueOf(paramInt1) });
          if (isInit) {
            OSo.setNetSpeed(paramInt1);
          }
          if (!paramBoolean2) {
            break label1427;
          }
          localObject1 = eMf;
          if (localObject1 != null) {
            break label1201;
          }
          localObject1 = "";
          label869:
          paramBoolean2 = com.tencent.mm.plugin.scanner.scan_goods_new.res.a.OWG.gRZ();
          if (com.tencent.mm.plugin.scanner.scan_goods_new.res.a.OWG.gRZ()) {
            break label1231;
          }
          Log.e("MicroMsg.ScanProductModelResLogic", "getReadyModelConfigVersion res is not ready");
          paramInt1 = 0;
          label897:
          if (!n.bp((CharSequence)localObject1)) {
            break label1256;
          }
          paramInt2 = 1;
          label910:
          if (paramInt2 != 0) {
            break label1297;
          }
          paramInt4 = aUG((String)localObject1);
          if (!paramBoolean2) {
            break label1272;
          }
          if (paramInt4 != paramInt1) {
            break label1261;
          }
          label930:
          localObject2 = com.tencent.mm.plugin.scanner.scan_goods_new.res.a.OWG;
          localObject2 = new StringBuilder("使用模型config  下发版本：").append(paramInt1).append(" , 后台版本：").append(paramInt4).append(" , 新数据：");
          localObject3 = (CharSequence)localObject1;
          if ((localObject3 != null) && (!n.bp((CharSequence)localObject3))) {
            break label1286;
          }
          paramInt2 = 1;
          label989:
          if (paramInt2 != 0) {
            break label1291;
          }
        }
      }
      label1158:
      label1291:
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        com.tencent.mm.plugin.scanner.scan_goods_new.res.a.showToast(paramBoolean1);
        Log.i("MicroMsg.ScanFastFocusEngineManager", "getScanMergeEngineConfig  has serverConfig data, serverConfigVersion:" + paramInt4 + " , readyConfigVersion:" + paramInt1 + " , isDownloadModelResReady:" + paramBoolean2);
        Log.i("MicroMsg.ScanFastFocusEngineManager", kotlin.g.b.s.X("getScanMergeEngineConfig  configStr:", localObject1));
        label1067:
        if (((CharSequence)localObject1).length() <= 0) {
          break label1475;
        }
        paramInt1 = 1;
        label1082:
        if (paramInt1 != 0)
        {
          Log.i("MicroMsg.ScanFastFocusEngineManager", "setEngineConfig %s", new Object[] { localObject1 });
          a(new ac..ExternalSyntheticLambda1((String)localObject1));
        }
        if (isInit)
        {
          paramInt1 = com.tencent.mm.plugin.scanner.util.i.gUc();
          Log.i("MicroMsg.ScanFastFocusEngineManager", kotlin.g.b.s.X("updateServerDetectFrameCount: ", Integer.valueOf(paramInt1)));
          OSo.setServerDetectFrameCount(paramInt1);
        }
        if (com.tencent.mm.plugin.scanner.c.a.gQr()) {
          break label1480;
        }
        paramBoolean1 = true;
        OSj = paramBoolean1;
        OSl = gRi();
        OSk = 0;
        OSm = false;
        OSu = System.currentTimeMillis();
        AppMethodBeat.o(314247);
        return paramInt3;
        paramInt1 = 1;
        break;
        paramInt1 = 1;
        break;
        label1201:
        localObject2 = ((MultiProcessMMKV)localObject1).getString("scan_config_scan_merge_engine_config", "");
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label869;
        }
        localObject1 = "";
        break label869;
        label1231:
        Log.i("MicroMsg.ScanProductModelResLogic", kotlin.g.b.s.X("getReadyModelConfigVersion:", Integer.valueOf(com.tencent.mm.plugin.scanner.scan_goods_new.res.a.OWJ)));
        paramInt1 = com.tencent.mm.plugin.scanner.scan_goods_new.res.a.OWJ;
        break label897;
        label1256:
        paramInt2 = 0;
        break label910;
        label1261:
        localObject1 = com.tencent.mm.plugin.scanner.scan_goods_new.res.a.OWG.gSa();
        break label930;
        label1272:
        if (paramInt4 == 7) {
          break label930;
        }
        localObject1 = "";
        break label930;
        paramInt2 = 0;
        break label989;
      }
      label1286:
      label1297:
      if (paramBoolean2) {}
      for (localObject1 = com.tencent.mm.plugin.scanner.scan_goods_new.res.a.OWG.gSa();; localObject1 = "")
      {
        localObject2 = com.tencent.mm.plugin.scanner.scan_goods_new.res.a.OWG;
        localObject2 = new StringBuilder("使用模型config  下发版本：").append(paramInt1).append(" , 新数据：");
        localObject3 = (CharSequence)localObject1;
        if ((localObject3 == null) || (n.bp((CharSequence)localObject3)))
        {
          paramInt2 = 1;
          label1359:
          if (paramInt2 != 0) {
            break label1421;
          }
        }
        label1421:
        for (paramBoolean1 = true;; paramBoolean1 = false)
        {
          com.tencent.mm.plugin.scanner.scan_goods_new.res.a.showToast(paramBoolean1);
          Log.i("MicroMsg.ScanFastFocusEngineManager", "getScanMergeEngineConfig  no serverConfig data, readyConfigVersion:" + paramInt1 + " , isDownloadModelResReady:" + paramBoolean2);
          break;
          paramInt2 = 0;
          break label1359;
        }
        label1427:
        localObject1 = eMf;
        if (localObject1 == null)
        {
          localObject1 = "";
          break label1067;
        }
        localObject2 = ((MultiProcessMMKV)localObject1).getString("scan_config_focus_engine_config", "");
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label1067;
        }
        localObject1 = "";
        break label1067;
        label1475:
        paramInt1 = 0;
        break label1082;
        label1480:
        paramBoolean1 = false;
        break label1158;
      }
      label1494:
      localObject6 = str2;
    }
  }
  
  public static final com.tencent.mm.plugin.scanner.scan_goods_new.k b(int paramInt, RectF paramRectF)
  {
    AppMethodBeat.i(314276);
    kotlin.g.b.s.u(paramRectF, "rect");
    long l1;
    long l2;
    com.tencent.mm.plugin.scanner.scan_goods_new.k localk;
    int j;
    if (isInit)
    {
      l1 = System.currentTimeMillis();
      OSo.resetStatus();
      paramRectF = OSo.getScanProductInfoListForFullImage(paramInt, paramRectF.left, paramRectF.top, paramRectF.width(), paramRectF.height());
      l2 = System.currentTimeMillis();
      Log.d("MicroMsg.ScanFastFocusEngineManager", "getScanProductInfoListForFullImage localTrackId: %s, result: %d, cost: %d, width: %d, height: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(OSo.trackInfoCount), Long.valueOf(l2 - l1), Integer.valueOf(width), Integer.valueOf(height) });
      if ((OSo.trackInfoCount > 0) && (paramRectF != null))
      {
        localk = new com.tencent.mm.plugin.scanner.scan_goods_new.k();
        localk.OVD = 2;
        localk.OWB = OSo.trackInfoCount;
        paramInt = 0;
        j = OSo.trackInfoCount;
        if (j <= 0) {}
      }
    }
    for (;;)
    {
      int i = paramInt + 1;
      Object localObject2 = (ScanProductInfo)kotlin.a.k.m(paramRectF, paramInt);
      if (localObject2 != null)
      {
        ArrayList localArrayList = localk.OWA;
        Object localObject1 = new ScanProductInfo();
        ((ScanProductInfo)localObject1).copy((ScanProductInfo)localObject2);
        localObject2 = ah.aiuX;
        localObject1 = new j((ScanProductInfo)localObject1);
        ((j)localObject1).OWk.OWr = (l2 - l1);
        ((j)localObject1).OWi = true;
        localObject2 = ah.aiuX;
        localArrayList.add(localObject1);
      }
      if (i >= j)
      {
        AppMethodBeat.o(314276);
        return localk;
        Log.e("MicroMsg.ScanFastFocusEngineManager", "getScanProductInfoListForFullImage result null isInit: %s", new Object[] { Boolean.valueOf(isInit) });
        AppMethodBeat.o(314276);
        return null;
      }
      paramInt = i;
    }
  }
  
  private static void gQW()
  {
    AppMethodBeat.i(314252);
    try
    {
      boolean bool = com.tencent.mm.kernel.h.baz();
      Log.i("MicroMsg.ScanFastFocusEngineManager", "initMMKV %s, mmkv: %s", new Object[] { Boolean.valueOf(bool), eMf });
      if ((bool) && (eMf == null))
      {
        eMf = MultiProcessMMKV.getMMKV(kotlin.g.b.s.X(z.bAM(), "_scan_config_mmkv"));
        AppMethodBeat.o(314252);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.ScanFastFocusEngineManager", (Throwable)localException, "alvinluo checkInitMMKV exception", new Object[0]);
      AppMethodBeat.o(314252);
    }
  }
  
  public static final aj gQX()
  {
    Object localObject = null;
    AppMethodBeat.i(52204);
    if (isInit)
    {
      OSt.points = OSo.getPointObjects();
      OSt.pointCount = OSo.pointCount;
      int i = OSt.pointCount;
      int j = OSt.hashCode();
      ScanPoint[] arrayOfScanPoint = OSt.points;
      if (arrayOfScanPoint == null) {}
      for (;;)
      {
        Log.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo getPointObjects pointCount: %d, hashCode: %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject });
        localObject = OSt;
        AppMethodBeat.o(52204);
        return localObject;
        localObject = Integer.valueOf(arrayOfScanPoint.hashCode());
      }
    }
    AppMethodBeat.o(52204);
    return null;
  }
  
  public static final GoodsObject gQY()
  {
    AppMethodBeat.i(52206);
    if (isInit)
    {
      Log.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo getCropObject %f, %f, %f, %f", new Object[] { Float.valueOf(OSo.cropObject.relative_minx), Float.valueOf(OSo.cropObject.relative_maxx), Float.valueOf(OSo.cropObject.relative_miny), Float.valueOf(OSo.cropObject.relative_maxy) });
      GoodsObject localGoodsObject = OSo.cropObject;
      AppMethodBeat.o(52206);
      return localGoodsObject;
    }
    AppMethodBeat.o(52206);
    return null;
  }
  
  public static final void gQZ()
  {
    AppMethodBeat.i(52209);
    if (OSp != 0) {
      a(new ac..ExternalSyntheticLambda0(0));
    }
    AppMethodBeat.o(52209);
  }
  
  public static final void gRa()
  {
    AppMethodBeat.i(314332);
    Log.i("MicroMsg.ScanFastFocusEngineManager", "checkAndUpdateScanEngineConfig");
    gQW();
    if (ahO(2)) {
      ahP(2);
    }
    if (ahO(3)) {
      ahP(3);
    }
    gRb();
    ahP(6);
    AppMethodBeat.o(314332);
  }
  
  private static void gRb()
  {
    AppMethodBeat.i(314335);
    if (ahO(4)) {
      ahP(4);
    }
    AppMethodBeat.o(314335);
  }
  
  public static final String gRc()
  {
    AppMethodBeat.i(314354);
    Object localObject = eMf;
    if (localObject == null) {
      localObject = "";
    }
    try
    {
      String str;
      for (;;)
      {
        str = LocaleUtil.getApplicationLanguage();
        localObject = new JSONObject((String)localObject);
        Log.i("MicroMsg.ScanFastFocusEngineManager", "getScanGoodsGuideWording currentLanguage: %s", new Object[] { str });
        if (!kotlin.g.b.s.p(str, "zh_CN")) {
          break;
        }
        localObject = ((JSONObject)localObject).optString("desc_chinese");
        AppMethodBeat.o(314354);
        return localObject;
        str = ((MultiProcessMMKV)localObject).getString("scan_config_guide_wording", "");
        localObject = str;
        if (str == null) {
          localObject = "";
        }
      }
      if (kotlin.g.b.s.p(str, "en"))
      {
        localObject = ((JSONObject)localObject).optString("desc_english");
        AppMethodBeat.o(314354);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.ScanFastFocusEngineManager", (Throwable)localException, "getScanGoodsGuideWording exception", new Object[0]);
      AppMethodBeat.o(314354);
      return null;
    }
    AppMethodBeat.o(314354);
    return null;
  }
  
  public static final String gRd()
  {
    AppMethodBeat.i(314359);
    Object localObject = eMf;
    if (localObject == null)
    {
      AppMethodBeat.o(314359);
      return "";
    }
    localObject = ((MultiProcessMMKV)localObject).getString("scan_config_scan_merge_wording", "");
    if (localObject == null)
    {
      AppMethodBeat.o(314359);
      return "";
    }
    AppMethodBeat.o(314359);
    return localObject;
  }
  
  public static final boolean gRe()
  {
    boolean bool = false;
    AppMethodBeat.i(314366);
    MultiProcessMMKV localMultiProcessMMKV = eMf;
    if (localMultiProcessMMKV == null) {}
    for (;;)
    {
      Log.i("MicroMsg.ScanFastFocusEngineManager", kotlin.g.b.s.X("disableScanProductInMergeMode: ", Boolean.valueOf(bool)));
      AppMethodBeat.o(314366);
      return bool;
      bool = localMultiProcessMMKV.getBoolean("scan_config_disable_scan_product", false);
    }
  }
  
  public static final int gRf()
  {
    AppMethodBeat.i(314369);
    Object localObject = eMf;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = Integer.valueOf(((MultiProcessMMKV)localObject).getInt("scan_config_request_time_interval", 1000)))
    {
      AppMethodBeat.o(314369);
      return 1000;
    }
    int i = ((Integer)localObject).intValue();
    AppMethodBeat.o(314369);
    return i;
  }
  
  public static final int gRg()
  {
    AppMethodBeat.i(314373);
    MultiProcessMMKV localMultiProcessMMKV = eMf;
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(314373);
      return 5000;
    }
    int i = localMultiProcessMMKV.getInt("scan_config_upload_timeout", 5000);
    AppMethodBeat.o(314373);
    return i;
  }
  
  public static final int gRh()
  {
    AppMethodBeat.i(314376);
    MultiProcessMMKV localMultiProcessMMKV = eMf;
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(314376);
      return 5000;
    }
    int i = localMultiProcessMMKV.getInt("scan_config_retrieval_timeout", 5000);
    AppMethodBeat.o(314376);
    return i;
  }
  
  public static final int gRi()
  {
    AppMethodBeat.i(314381);
    int i = com.tencent.mm.plugin.scanner.c.a.gQs();
    MultiProcessMMKV localMultiProcessMMKV = eMf;
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(314381);
      return i;
    }
    i = localMultiProcessMMKV.getInt("scan_config_server_detect_frame_count", i);
    AppMethodBeat.o(314381);
    return i;
  }
  
  public static final void gRj()
  {
    OSm = false;
  }
  
  public static final Point gRk()
  {
    AppMethodBeat.i(314402);
    Point localPoint = new Point(width, height);
    AppMethodBeat.o(314402);
    return localPoint;
  }
  
  public static final ScanFastFocusEngineNative getCropRGBAByTrackId(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(314279);
    if (isInit)
    {
      long l1 = System.currentTimeMillis();
      OSo.resetStatus();
      Object localObject = x(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      Log.v("MicroMsg.ScanFastFocusEngineManager", "getCropRGBAByTrackId expandCropSize: %s", new Object[] { localObject });
      ScanFastFocusEngineNative localScanFastFocusEngineNative = OSo.getCropRGBAByTrackId(paramInt, ((RectF)localObject).left, ((RectF)localObject).top, ((RectF)localObject).right, ((RectF)localObject).bottom);
      long l2 = System.currentTimeMillis();
      byte[] arrayOfByte = localScanFastFocusEngineNative.bestImageData;
      localObject = localScanFastFocusEngineNative.bestImageData;
      if (localObject == null) {}
      for (localObject = null;; localObject = Integer.valueOf(localObject.length))
      {
        Log.i("MicroMsg.ScanFastFocusEngineManager", "getCropRGBAByTrackId trackId: %s, result image: %s, yuv size: %d, cost: %d, width: %d, height: %d", new Object[] { Integer.valueOf(paramInt), arrayOfByte, localObject, Long.valueOf(l2 - l1), Integer.valueOf(OSo.width), Integer.valueOf(OSo.height) });
        AppMethodBeat.o(314279);
        return localScanFastFocusEngineNative;
      }
    }
    AppMethodBeat.o(314279);
    return null;
  }
  
  public static final ScanFastFocusEngineNative getCropYUVByTrackId(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(314277);
    if (isInit)
    {
      long l1 = System.currentTimeMillis();
      OSo.resetStatus();
      Object localObject = x(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      Log.v("MicroMsg.ScanFastFocusEngineManager", "getCropYUVByTrackId expandCropSize: %s", new Object[] { localObject });
      ScanFastFocusEngineNative localScanFastFocusEngineNative = OSo.getCropYUVByTrackId(paramInt, ((RectF)localObject).left, ((RectF)localObject).top, ((RectF)localObject).right, ((RectF)localObject).bottom);
      long l2 = System.currentTimeMillis();
      byte[] arrayOfByte = localScanFastFocusEngineNative.bestImageData;
      localObject = localScanFastFocusEngineNative.bestImageData;
      if (localObject == null) {}
      for (localObject = null;; localObject = Integer.valueOf(localObject.length))
      {
        Log.i("MicroMsg.ScanFastFocusEngineManager", "getCropYUVByTrackId trackId: %s, result image: %s, yuv size: %d, cost: %d, width: %d, height: %d", new Object[] { Integer.valueOf(paramInt), arrayOfByte, localObject, Long.valueOf(l2 - l1), Integer.valueOf(OSo.width), Integer.valueOf(OSo.height) });
        AppMethodBeat.o(314277);
        return localScanFastFocusEngineNative;
      }
    }
    AppMethodBeat.o(314277);
    return null;
  }
  
  public static final String getReportString()
  {
    AppMethodBeat.i(52211);
    if (isInit)
    {
      String str = OSo.getReportString();
      AppMethodBeat.o(52211);
      return str;
    }
    Log.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo getReportString is not init");
    AppMethodBeat.o(52211);
    return null;
  }
  
  public static final boolean isAICrop()
  {
    return OSs;
  }
  
  public static final boolean isUsingAI()
  {
    return OSr;
  }
  
  public static final ScanFastFocusEngineNative process(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Integer localInteger3 = null;
    AppMethodBeat.i(52203);
    kotlin.g.b.s.u(paramArrayOfByte, "imageData");
    if (isInit)
    {
      long l1 = System.currentTimeMillis();
      OSo.resetStatus();
      ScanFastFocusEngineNative localScanFastFocusEngineNative = OSo.process(paramArrayOfByte, paramInt1, paramInt2);
      long l2 = System.currentTimeMillis();
      Integer localInteger1;
      label62:
      Integer localInteger2;
      if (localScanFastFocusEngineNative == null)
      {
        paramArrayOfByte = null;
        if (localScanFastFocusEngineNative != null) {
          break label138;
        }
        localInteger1 = null;
        if (localScanFastFocusEngineNative != null) {
          break label151;
        }
        localInteger2 = null;
        label70:
        if (localScanFastFocusEngineNative != null) {
          break label164;
        }
      }
      for (;;)
      {
        Log.d("MicroMsg.ScanFastFocusEngineManager", "alvinluo process result: %s, cost: %d, width: %d, height: %d, bestImageData: %s", new Object[] { paramArrayOfByte, Long.valueOf(l2 - l1), localInteger1, localInteger2, localInteger3 });
        AppMethodBeat.o(52203);
        return localScanFastFocusEngineNative;
        paramArrayOfByte = Integer.valueOf(localScanFastFocusEngineNative.result);
        break;
        label138:
        localInteger1 = Integer.valueOf(localScanFastFocusEngineNative.width);
        break label62;
        label151:
        localInteger2 = Integer.valueOf(localScanFastFocusEngineNative.height);
        break label70;
        label164:
        byte[] arrayOfByte = localScanFastFocusEngineNative.bestImageData;
        if (arrayOfByte != null) {
          localInteger3 = Integer.valueOf(arrayOfByte.length);
        }
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
      OSo.resetStatus();
      OSo.nativeRelease();
      isInit = false;
      OSk = 0;
      OSm = false;
      if (OSv != null)
      {
        AppMethodBeat.o(52208);
        throw null;
      }
      if (OSv != null)
      {
        AppMethodBeat.o(52208);
        throw null;
      }
      OSu = 0L;
    }
    AppMethodBeat.o(52208);
  }
  
  public static final void reset()
  {
    AppMethodBeat.i(52207);
    if (isInit)
    {
      Log.d("MicroMsg.ScanFastFocusEngineManager", "alvinluo focusEngineNative reset");
      OSo.reset();
    }
    AppMethodBeat.o(52207);
  }
  
  public static final void resetNoBoxCount()
  {
    AppMethodBeat.i(314412);
    if (isInit)
    {
      Log.e("MicroMsg.ScanFastFocusEngineManager", "resetNoBoxCount");
      OSo.resetNoBoxCount();
    }
    AppMethodBeat.o(314412);
  }
  
  private static final RectF x(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(314286);
    float f1 = paramFloat3 - paramFloat1;
    float f2 = paramFloat4 - paramFloat2;
    RectF localRectF = new RectF(Math.max(0.0F, paramFloat1 - f1 * 0.1F), Math.max(0.0F, paramFloat2 - f2 * 0.1F), Math.min(1.0F, f1 * 0.1F + paramFloat3), Math.min(1.0F, f2 * 0.1F + paramFloat4));
    AppMethodBeat.o(314286);
    return localRectF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.ac
 * JD-Core Version:    0.7.0.1
 */