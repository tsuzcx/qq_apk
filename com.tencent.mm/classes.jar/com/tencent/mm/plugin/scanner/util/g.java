package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/util/ScanRetryManager;", "", "()V", "canRetryReopenCamera", "", "canRetryUsingTexture", "enterTimestamp", "", "exitTimestamp", "isRetry", "isScanSuccess", "isUpdated", "mRetryType", "", "mTextureScaledFactor", "", "mTimeout", "mTimeoutFactor", "maxTimeout", "minTimeout", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "onPreviewFrameCalled", "stayTime", "canRetry", "retryType", "cancelRetryType", "", "checkAndResetTimeout", "enterScanUI", "exitScanUI", "getMMKVKey", "", "getRetryType", "getSavedTimeout", "getTextureScaleFactor", "getTimeout", "init", "initMMKV", "saveTimeout", "timeout", "setIsRetry", "setOnPreviewFrameCalled", "setScanSuccess", "updateTimeout", "time", "Companion", "plugin-scan_release"})
public final class g
{
  public static final g.a yPR;
  private ay cCf;
  public long dCI;
  public boolean isRetry;
  public long mTimeout;
  public long xgd;
  public boolean yJQ;
  public long yPH;
  public long yPI;
  public float yPJ;
  public boolean yPK;
  public int yPL;
  public boolean yPM;
  public boolean yPN;
  public float yPO;
  public long yPP;
  public boolean yPQ;
  
  static
  {
    AppMethodBeat.i(161061);
    yPR = new g.a((byte)0);
    AppMethodBeat.o(161061);
  }
  
  public g()
  {
    AppMethodBeat.i(161060);
    this.yPH = 5000L;
    this.yPI = 1000L;
    this.yPJ = 2.0F;
    this.yPO = 0.8F;
    Object localObject = new StringBuilder();
    p.g(com.tencent.mm.kernel.g.ajP(), "MMKernel.account()");
    this.cCf = ay.aRX(a.aiF() + "_scan_code_retry");
    localObject = this.cCf;
    long l;
    int i;
    int j;
    if (localObject != null)
    {
      l = ((ay)localObject).getLong("scan_code_retry_timeout", 5000L);
      this.mTimeout = l;
      this.yPL = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qIS, 0);
      this.yPH = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qIU, 5000L);
      this.yPI = 1000L;
      i = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qIV, 200);
      this.yPJ = (i / 100.0F);
      this.mTimeout = Math.max(this.yPI, this.mTimeout);
      this.mTimeout = Math.min(this.yPH, this.mTimeout);
      j = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qIW, 80);
      if (j != 0)
      {
        this.yPO = (j / 100.0F);
        this.yPO = Math.min(1.0F, this.yPO);
      }
      if (this.yPL != 1) {
        break label396;
      }
      this.yPM = true;
      this.yPN = false;
    }
    for (;;)
    {
      ae.i("MicroMsg.ScanRetryManager", "alvinluo init retryType: %d, maxTimeout: %d, minTimeout: %d, timeout: %d, timeoutFactor config: %d, factor: %f, textureScaleFactor: %d, factor: %f, canRetry: %b, %b", new Object[] { Integer.valueOf(this.yPL), Long.valueOf(this.yPH), Long.valueOf(this.yPI), Long.valueOf(this.mTimeout), Integer.valueOf(i), Float.valueOf(this.yPJ), Integer.valueOf(j), Float.valueOf(this.yPO), Boolean.valueOf(this.yPM), Boolean.valueOf(this.yPN) });
      AppMethodBeat.o(161060);
      return;
      l = 5000L;
      break;
      label396:
      if (this.yPL == 2)
      {
        this.yPM = false;
        this.yPN = true;
      }
    }
  }
  
  public final boolean PC(int paramInt)
  {
    if (paramInt == 1) {
      return this.yPM;
    }
    if (paramInt == 2) {
      return this.yPN;
    }
    return false;
  }
  
  public final void zA(long paramLong)
  {
    AppMethodBeat.i(161059);
    ae.i("MicroMsg.ScanRetryManager", "alvinluo saveTimeout %d", new Object[] { Long.valueOf(paramLong) });
    ay localay = this.cCf;
    if (localay != null) {
      localay.putLong("scan_code_retry_timeout", paramLong);
    }
    localay = this.cCf;
    if (localay != null)
    {
      localay.apply();
      AppMethodBeat.o(161059);
      return;
    }
    AppMethodBeat.o(161059);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.g
 * JD-Core Version:    0.7.0.1
 */