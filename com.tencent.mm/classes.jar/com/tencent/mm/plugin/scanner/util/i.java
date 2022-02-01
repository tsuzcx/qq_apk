package com.tencent.mm.plugin.scanner.util;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.scanner.model.ac;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.qbar.b.a.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/util/ScanProductSkipFrameManager;", "", "()V", "KEY_SCAN_PRODUCT_ENGINE_DETECT_SKIP_FRAME_COUNT", "", "KEY_SCAN_PRODUCT_SERVER_DETECT_FRAME_COUNT", "MMKV_KEY_SUFFIX", "SCAN_PRODUCT_ENGINE_DETECT_MAX_SKIP_FRAME", "", "SCAN_PRODUCT_ENGINE_DETECT_MIN_FRAME_IN_ONE_SECOND", "SCAN_PRODUCT_ENGINE_DETECT_MIN_SKIP_FRAME", "SCAN_PRODUCT_SERVER_DETECT_DEFAULT_TIMEOUT_MS", "SCAN_PRODUCT_SERVER_DETECT_MAX_FRAME", "SCAN_PRODUCT_SERVER_DETECT_MIN_FRAME", "TAG", "enableAdjustEngineDetectFrame", "", "enableAdjustServerDetectFrame", "engineDetectMaxSkipFrame", "engineDetectMinSkipFrame", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "serverDetectMaxFrame", "serverDetectMinFrame", "serverDetectTimeoutMs", "computeEngineSkipFrame", "frameCost", "computeServerFrame", "skipFrame", "enterScanUI", "", "getEngineDetectSkipFrameCount", "getServerDetectFrameCount", "safeParseKey", "key", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "defaultValue", "(Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;I)Ljava/lang/Integer;", "updateSkipFrame", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i PiM;
  private static boolean PiN;
  private static boolean PiO;
  private static int PiP;
  private static int PiQ;
  private static int PiR;
  private static int PiS;
  private static int PiT;
  private static MultiProcessMMKV eMf;
  
  static
  {
    boolean bool2 = false;
    AppMethodBeat.i(314128);
    PiM = new i();
    PiP = 4;
    PiQ = 1;
    PiR = 20;
    PiS = 15;
    PiT = 5000;
    try
    {
      bool1 = com.tencent.mm.kernel.h.baz();
      if ((bool1) && (eMf == null)) {
        eMf = MultiProcessMMKV.getMMKV(s.X(z.bAM(), "_scan_product_skip_frame"));
      }
      Log.i("MicroMsg.ScanProductSkipFrameManager", "initMMKV %s, mmkv: %s", new Object[] { Boolean.valueOf(bool1), eMf });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Integer localInteger;
        Log.printErrStackTrace("MicroMsg.ScanProductSkipFrameManager", (Throwable)localException, "checkInitMMKV exception", new Object[0]);
        continue;
        boolean bool1 = false;
      }
    }
    if ((((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zgn, 0) == 1) || (BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()))
    {
      bool1 = true;
      PiO = bool1;
      if ((((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.zgo, 0) != 1) && (!BuildInfo.DEBUG))
      {
        bool1 = bool2;
        if (!WeChatEnvironment.hasDebugger()) {}
      }
      else
      {
        bool1 = true;
      }
      PiN = bool1;
      localInteger = b(c.a.zgp, 4);
      if (localInteger != null) {
        PiP = ((Number)localInteger).intValue();
      }
      localInteger = b(c.a.zgq, 1);
      if (localInteger != null) {
        PiQ = ((Number)localInteger).intValue();
      }
      localInteger = b(c.a.zgr, 20);
      if (localInteger != null) {
        PiR = ((Number)localInteger).intValue();
      }
      localInteger = b(c.a.zgs, 15);
      if (localInteger != null) {
        PiS = ((Number)localInteger).intValue();
      }
      localInteger = b(c.a.zgt, 5000);
      if (localInteger != null) {
        PiT = ((Number)localInteger).intValue();
      }
      Log.i("MicroMsg.ScanProductSkipFrameManager", "initSkipFrameManager enableAdjustEngineDetectFrame: " + PiO + ", enableAdjustServerDetectFrame: " + PiN + ", engineDetectMaxFrame: " + PiP + ",engineDetectMinFrame: " + PiQ + ", serverDetectMaxFrame: " + PiR + ", serverDetectMinFrame: " + PiS + ", serverDetecTimeout: " + PiT);
      AppMethodBeat.o(314128);
      return;
    }
  }
  
  private static Integer b(c.a parama, int paramInt)
  {
    AppMethodBeat.i(314109);
    paramInt = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(parama, paramInt);
    if (paramInt > 0)
    {
      AppMethodBeat.o(314109);
      return Integer.valueOf(paramInt);
    }
    AppMethodBeat.o(314109);
    return null;
  }
  
  public static final void gUa()
  {
    AppMethodBeat.i(314115);
    if ((!PiO) && (!PiN))
    {
      Log.w("MicroMsg.ScanProductSkipFrameManager", "not enable adjust skip frame");
      AppMethodBeat.o(314115);
      return;
    }
    Object localObject = com.tencent.qbar.b.a.ahrN;
    int n = a.a.jWZ();
    int j;
    int k;
    if (n > 0)
    {
      if (n >= 250)
      {
        i = PiQ;
        Log.i("MicroMsg.ScanProductSkipFrameManager", s.X("computeEngineSkipFrame use minSkipFrame frameCost: ", Integer.valueOf(n)));
        j = Math.max(Math.min((int)(float)Math.ceil(1.0F * PiT / ((i + 1) * n)), PiR), PiS);
        k = ac.gRi();
        j = (int)(float)Math.floor(j * 1.0F * k / 20.0F);
        localObject = eMf;
        if (localObject != null)
        {
          localObject = ((MultiProcessMMKV)localObject).putInt("scan_product_engine_detect_skip_frame_count", i);
          if (localObject != null)
          {
            localObject = ((SharedPreferences.Editor)localObject).putInt("scan_product_server_detect_frame_count", j);
            if (localObject != null) {
              ((SharedPreferences.Editor)localObject).apply();
            }
          }
        }
        Log.i("MicroMsg.ScanProductSkipFrameManager", "updateSkipFrame engineDetectSkipFrame: " + i + ", serverDetectFrame: " + j);
      }
    }
    else
    {
      localObject = com.tencent.qbar.b.a.ahrN;
      j = a.a.jWZ();
      k = gUb();
      localObject = com.tencent.qbar.b.a.ahrN;
      localObject = com.tencent.qbar.b.a.iTS();
      if (localObject != null) {
        break label560;
      }
    }
    label560:
    for (int i = 0;; i = ((MultiProcessMMKV)localObject).getInt("scan_code_decode_cost", 0))
    {
      if ((j > 0) && (i > 0)) {
        com.tencent.mm.plugin.report.service.h.OAn.b(24741, new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
      }
      AppMethodBeat.o(314115);
      return;
      i = (int)Math.floor(1000.0D / n);
      j = i / 2;
      double d1 = 1000.0D / (n * 2) - 1.0D;
      double d2 = 1000.0D / (j * n) - 1.0D;
      int m = Math.max(Math.min((int)Math.floor((Math.floor(d2) + Math.ceil(d1)) * 1.0D / 2.0D), PiP), PiQ);
      Log.i("MicroMsg.ScanProductSkipFrameManager", "computeEngineSkipFrame frameCost: " + n + ", scanCodeFrameCount: " + i + ", maxScanProductFrameCount: " + j + ", maxSkipFrame: " + d1 + ", minSkipFrame: " + d2 + ", skipFrame: " + m);
      localObject = eMf;
      if (localObject == null)
      {
        j = 0;
        k = 0;
      }
      for (;;)
      {
        i = m;
        if (j == 0) {
          break;
        }
        i = m;
        if (Math.abs(m - k) < 2) {
          break;
        }
        Log.i("MicroMsg.ScanProductSkipFrameManager", "computeEngineSkipFrame current: %d, last: %d", new Object[] { Integer.valueOf(m), Integer.valueOf(k) });
        i = (m + k) / 2;
        break;
        k = ((MultiProcessMMKV)localObject).getInt("scan_product_engine_detect_skip_frame_count", 0);
        j = k;
      }
    }
  }
  
  public static final int gUb()
  {
    AppMethodBeat.i(314117);
    int i = com.tencent.mm.plugin.scanner.c.a.gQq();
    if (!PiO)
    {
      AppMethodBeat.o(314117);
      return i;
    }
    MultiProcessMMKV localMultiProcessMMKV = eMf;
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(314117);
      return i;
    }
    i = localMultiProcessMMKV.getInt("scan_product_engine_detect_skip_frame_count", i);
    AppMethodBeat.o(314117);
    return i;
  }
  
  public static final int gUc()
  {
    AppMethodBeat.i(314120);
    int i = ac.gRi();
    if (!PiN)
    {
      AppMethodBeat.o(314120);
      return i;
    }
    MultiProcessMMKV localMultiProcessMMKV = eMf;
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(314120);
      return i;
    }
    i = localMultiProcessMMKV.getInt("scan_product_server_detect_frame_count", i);
    AppMethodBeat.o(314120);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.i
 * JD-Core Version:    0.7.0.1
 */