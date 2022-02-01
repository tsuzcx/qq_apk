package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/util/ScanRetryManager;", "", "()V", "canRetryReopenCamera", "", "canRetryUsingTexture", "enterTimestamp", "", "exitTimestamp", "isRetry", "isScanSuccess", "isUpdated", "mRetryType", "", "mTextureScaledFactor", "", "mTimeout", "mTimeoutFactor", "maxTimeout", "minTimeout", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "onPreviewFrameCalled", "stayTime", "canRetry", "retryType", "cancelRetryType", "", "checkAndResetTimeout", "enterScanUI", "exitScanUI", "getMMKVKey", "", "getRetryType", "getSavedTimeout", "getTextureScaleFactor", "getTimeout", "init", "initMMKV", "saveTimeout", "timeout", "setIsRetry", "setOnPreviewFrameCalled", "setScanSuccess", "updateTimeout", "time", "Companion", "plugin-scan_release"})
public final class h
{
  public static final h.a CTS;
  public boolean CNE;
  public long CTI;
  public long CTJ;
  public float CTK;
  public boolean CTL;
  public int CTM;
  public boolean CTN;
  public boolean CTO;
  public float CTP;
  public long CTQ;
  public boolean CTR;
  private MultiProcessMMKV cQe;
  public long dUy;
  public boolean isRetry;
  public long mTimeout;
  public long viC;
  
  static
  {
    AppMethodBeat.i(161061);
    CTS = new h.a((byte)0);
    AppMethodBeat.o(161061);
  }
  
  public h()
  {
    AppMethodBeat.i(161060);
    this.CTI = 5000L;
    this.CTJ = 1000L;
    this.CTK = 2.0F;
    this.CTP = 0.8F;
    Object localObject = new StringBuilder();
    p.g(g.aAf(), "MMKernel.account()");
    this.cQe = MultiProcessMMKV.getSingleMMKV(a.ayV() + "_scan_code_retry");
    localObject = this.cQe;
    long l;
    int i;
    int j;
    if (localObject != null)
    {
      l = ((MultiProcessMMKV)localObject).getLong("scan_code_retry_timeout", 5000L);
      this.mTimeout = l;
      this.CTM = ((b)g.af(b.class)).a(b.a.sep, 0);
      this.CTI = ((b)g.af(b.class)).a(b.a.ses, 5000L);
      this.CTJ = 1000L;
      i = ((b)g.af(b.class)).a(b.a.set, 200);
      this.CTK = (i / 100.0F);
      this.mTimeout = Math.max(this.CTJ, this.mTimeout);
      this.mTimeout = Math.min(this.CTI, this.mTimeout);
      j = ((b)g.af(b.class)).a(b.a.seu, 80);
      if (j != 0)
      {
        this.CTP = (j / 100.0F);
        this.CTP = Math.min(1.0F, this.CTP);
      }
      if (this.CTM != 1) {
        break label396;
      }
      this.CTN = true;
      this.CTO = false;
    }
    for (;;)
    {
      Log.i("MicroMsg.ScanRetryManager", "alvinluo init retryType: %d, maxTimeout: %d, minTimeout: %d, timeout: %d, timeoutFactor config: %d, factor: %f, textureScaleFactor: %d, factor: %f, canRetry: %b, %b", new Object[] { Integer.valueOf(this.CTM), Long.valueOf(this.CTI), Long.valueOf(this.CTJ), Long.valueOf(this.mTimeout), Integer.valueOf(i), Float.valueOf(this.CTK), Integer.valueOf(j), Float.valueOf(this.CTP), Boolean.valueOf(this.CTN), Boolean.valueOf(this.CTO) });
      AppMethodBeat.o(161060);
      return;
      l = 5000L;
      break;
      label396:
      if (this.CTM == 2)
      {
        this.CTN = false;
        this.CTO = true;
      }
    }
  }
  
  public final void IE(long paramLong)
  {
    AppMethodBeat.i(161059);
    Log.i("MicroMsg.ScanRetryManager", "alvinluo saveTimeout %d", new Object[] { Long.valueOf(paramLong) });
    MultiProcessMMKV localMultiProcessMMKV = this.cQe;
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.putLong("scan_code_retry_timeout", paramLong);
    }
    localMultiProcessMMKV = this.cQe;
    if (localMultiProcessMMKV != null)
    {
      localMultiProcessMMKV.apply();
      AppMethodBeat.o(161059);
      return;
    }
    AppMethodBeat.o(161059);
  }
  
  public final boolean Xc(int paramInt)
  {
    if (paramInt == 1) {
      return this.CTN;
    }
    if (paramInt == 2) {
      return this.CTO;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.h
 * JD-Core Version:    0.7.0.1
 */