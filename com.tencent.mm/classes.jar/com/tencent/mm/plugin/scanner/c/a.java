package com.tencent.mm.plugin.scanner.c;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/config/ScanClientConfigManager;", "", "()V", "KEY_LOCAL_ENABLE_SCAN_MERGE", "", "SCAN_MERGE_NO_RESULT_FRAME_COUNT_DEFAULT", "", "SCAN_MERGE_SKIP_FRAME_COUNT_DEFAULT", "SCAN_PRODUCT_ORIGIN_IMAGE_TYPE_DEFAULT", "SCAN_PRODUCT_UPLOAD_ENCODE_IMAGE_TYPE_DEFAULT", "TAG", "disableImageDetectByServer", "", "enableImageOCR", "enableScanCodeAndProductCombine", "enableScanProductSkipFrameBySensor", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "scanNoResultFrameCountLimit", "scanProductEncodeImageType", "scanProductOriginImageType", "scanProductSkipFrameCount", "checkInitMMKV", "", "forceUpdate", "enableSkipFrameBySensor", "getLocalEnableScanCodeAndProductCombine", "getScanNoResultFrameCountLimit", "getScanProductEncodeImageType", "getScanProductOriginImageType", "getScanProductSkipFrameCount", "init", "saveEnableScanCodeAndProductCombine", "enable", "updateEnableScanCodeAndProductCombine", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a OOH;
  private static boolean OOI;
  private static boolean OOJ;
  private static int OOK;
  private static boolean OOL;
  private static int OOM;
  private static int OON;
  private static int OOO;
  private static boolean OOP;
  private static MultiProcessMMKV eMf;
  
  static
  {
    AppMethodBeat.i(313442);
    OOH = new a();
    OOI = true;
    OOJ = true;
    OOK = 4;
    OOM = 20;
    OON = 1;
    OOO = 1;
    OOP = true;
    int i = ((c)h.ax(c.class)).a(c.a.zgA, 0);
    if (i == 1) {
      OOI = false;
    }
    int j = ((c)h.ax(c.class)).a(c.a.zgh, 4);
    if (j > 0) {
      OOK = j;
    }
    j = ((c)h.ax(c.class)).a(c.a.zgj, 1);
    int k;
    label180:
    int m;
    int n;
    switch (j)
    {
    default: 
      k = ((c)h.ax(c.class)).a(c.a.zgi, 1);
      switch (j)
      {
      default: 
        if ((OON == 2) && (OOO == 1))
        {
          Log.w("MicroMsg.ScanClientConfigManager", "force set encodeImageType: wxam");
          OOO = 2;
        }
        m = ((c)h.ax(c.class)).a(c.a.zgk, 0);
        n = ((c)h.ax(c.class)).a(c.a.zgl, 20);
        if (m == 1) {
          OOL = true;
        }
        if (n > 0) {
          OOM = n;
        }
        if (((c)h.ax(c.class)).a(c.a.zgm, 1) != 1) {}
        break;
      }
      break;
    }
    for (boolean bool = true;; bool = false)
    {
      OOP = bool;
      gQl();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ScanClientConfigManager init disableImageOCR config: ").append(i).append(", enableImageOCR: ").append(OOI).append(", configEncodeImageType: ").append(j).append(", scanProductEncodeImageType: ").append(OOO).append(", configOriginImageType: ").append(k).append(", scanProductOriginImageType: ").append(OON).append(", skipFrameCount: ").append(OOK).append(", configDisableServerDetect: ").append(m).append(", disableImageDetectByServer: ").append(OOL).append(", configScanNoResultFrame: ").append(n).append(", scanNoResultFrameCountLimit: ").append(OOM).append(", enableScanProductSkipFrameBySensor:");
      localStringBuilder.append(OOP);
      Log.i("MicroMsg.ScanClientConfigManager", localStringBuilder.toString());
      try
      {
        bool = h.baz();
        Log.i("MicroMsg.ScanClientConfigManager", "initMMKV %s, mmkv: %s", new Object[] { Boolean.valueOf(bool), eMf });
        if ((!bool) || (eMf != null)) {
          break label541;
        }
        eMf = MultiProcessMMKV.getMMKV(s.X(z.bAM(), "_scan_client_config_mmkv"));
        AppMethodBeat.o(313442);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.ScanClientConfigManager", (Throwable)localException, "checkInitMMKV exception", new Object[0]);
        AppMethodBeat.o(313442);
      }
      OOO = j;
      break;
      OON = k;
      break label180;
    }
    label541:
  }
  
  private static void BW(boolean paramBoolean)
  {
    AppMethodBeat.i(313417);
    if (paramBoolean)
    {
      Log.i("MicroMsg.ScanClientConfigManager", "saveEnableScanCodeAndProductCombine %s", new Object[] { Boolean.valueOf(paramBoolean) });
      Object localObject = eMf;
      if (localObject != null)
      {
        localObject = ((MultiProcessMMKV)localObject).putBoolean("key_local_enable_scan_merge", paramBoolean);
        if (localObject != null) {
          ((SharedPreferences.Editor)localObject).apply();
        }
      }
    }
    AppMethodBeat.o(313417);
  }
  
  public static final boolean gQk()
  {
    AppMethodBeat.i(313404);
    gQl();
    boolean bool = OOJ;
    AppMethodBeat.o(313404);
    return bool;
  }
  
  private static void gQl()
  {
    AppMethodBeat.i(313412);
    int i = ((c)h.ax(c.class)).a(c.a.zgf, 0);
    if (i != 0)
    {
      switch (i)
      {
      }
      for (;;)
      {
        Log.i("MicroMsg.ScanClientConfigManager", "updateEnableScanCodeAndProductCombine update by expt, enable: " + OOJ + ", config: " + i);
        AppMethodBeat.o(313412);
        return;
        OOJ = true;
        continue;
        OOJ = false;
      }
    }
    i = ((c)h.ax(c.class)).a(c.a.zgg, 0);
    switch (i)
    {
    }
    for (;;)
    {
      BW(OOJ);
      Log.i("MicroMsg.ScanClientConfigManager", "updateEnableScanCodeAndProductCombine config: %d, enable: %b", new Object[] { Integer.valueOf(i), Boolean.valueOf(OOJ) });
      AppMethodBeat.o(313412);
      return;
      boolean bool2 = gQn();
      if ((bool2) || (BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        OOJ = bool1;
        Log.i("MicroMsg.ScanClientConfigManager", "updateEnableScanCodeAndProductCombine localEnable: %s", new Object[] { Boolean.valueOf(bool2) });
        break;
      }
      OOJ = true;
      continue;
      OOJ = false;
    }
  }
  
  public static final boolean gQm()
  {
    return OOI;
  }
  
  private static boolean gQn()
  {
    AppMethodBeat.i(313419);
    MultiProcessMMKV localMultiProcessMMKV = eMf;
    if (localMultiProcessMMKV == null)
    {
      AppMethodBeat.o(313419);
      return false;
    }
    boolean bool = localMultiProcessMMKV.getBoolean("key_local_enable_scan_merge", false);
    AppMethodBeat.o(313419);
    return bool;
  }
  
  public static final int gQo()
  {
    return OOO;
  }
  
  public static final int gQp()
  {
    return OON;
  }
  
  public static final int gQq()
  {
    return OOK;
  }
  
  public static final boolean gQr()
  {
    return OOL;
  }
  
  public static final int gQs()
  {
    return OOM;
  }
  
  public static final boolean gQt()
  {
    return OOP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.c.a
 * JD-Core Version:    0.7.0.1
 */