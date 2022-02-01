package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/util/ScanRetryManager;", "", "()V", "canRetryReopenCamera", "", "canRetryUsingTexture", "enterTimestamp", "", "exitTimestamp", "isRetry", "isScanSuccess", "isUpdated", "mRetryType", "", "mTextureScaledFactor", "", "mTimeout", "mTimeoutFactor", "maxTimeout", "minTimeout", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "onPreviewFrameCalled", "stayTime", "canRetry", "retryType", "cancelRetryType", "", "checkAndResetTimeout", "enterScanUI", "exitScanUI", "getMMKVKey", "", "getRetryType", "getSavedTimeout", "getTextureScaleFactor", "getTimeout", "init", "initMMKV", "saveTimeout", "timeout", "setIsRetry", "setOnPreviewFrameCalled", "setScanSuccess", "updateTimeout", "time", "Companion", "plugin-scan_release"})
public final class g
{
  public static final g.a yzR;
  private ax cBy;
  public long dBD;
  public boolean isRetry;
  public long mTimeout;
  public long wQm;
  public boolean ytP;
  public long yzH;
  public long yzI;
  public float yzJ;
  public boolean yzK;
  public int yzL;
  public boolean yzM;
  public boolean yzN;
  public float yzO;
  public long yzP;
  public boolean yzQ;
  
  static
  {
    AppMethodBeat.i(161061);
    yzR = new g.a((byte)0);
    AppMethodBeat.o(161061);
  }
  
  public g()
  {
    AppMethodBeat.i(161060);
    this.yzH = 5000L;
    this.yzI = 1000L;
    this.yzJ = 2.0F;
    this.yzO = 0.8F;
    Object localObject = new StringBuilder();
    p.g(com.tencent.mm.kernel.g.ajA(), "MMKernel.account()");
    this.cBy = ax.aQA(a.aiq() + "_scan_code_retry");
    localObject = this.cBy;
    long l;
    int i;
    int j;
    if (localObject != null)
    {
      l = ((ax)localObject).getLong("scan_code_retry_timeout", 5000L);
      this.mTimeout = l;
      this.yzL = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qBz, 0);
      this.yzH = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qBB, 5000L);
      this.yzI = 1000L;
      i = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qBC, 200);
      this.yzJ = (i / 100.0F);
      this.mTimeout = Math.max(this.yzI, this.mTimeout);
      this.mTimeout = Math.min(this.yzH, this.mTimeout);
      j = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.qBD, 80);
      if (j != 0)
      {
        this.yzO = (j / 100.0F);
        this.yzO = Math.min(1.0F, this.yzO);
      }
      if (this.yzL != 1) {
        break label396;
      }
      this.yzM = true;
      this.yzN = false;
    }
    for (;;)
    {
      ad.i("MicroMsg.ScanRetryManager", "alvinluo init retryType: %d, maxTimeout: %d, minTimeout: %d, timeout: %d, timeoutFactor config: %d, factor: %f, textureScaleFactor: %d, factor: %f, canRetry: %b, %b", new Object[] { Integer.valueOf(this.yzL), Long.valueOf(this.yzH), Long.valueOf(this.yzI), Long.valueOf(this.mTimeout), Integer.valueOf(i), Float.valueOf(this.yzJ), Integer.valueOf(j), Float.valueOf(this.yzO), Boolean.valueOf(this.yzM), Boolean.valueOf(this.yzN) });
      AppMethodBeat.o(161060);
      return;
      l = 5000L;
      break;
      label396:
      if (this.yzL == 2)
      {
        this.yzM = false;
        this.yzN = true;
      }
    }
  }
  
  public final boolean OV(int paramInt)
  {
    if (paramInt == 1) {
      return this.yzM;
    }
    if (paramInt == 2) {
      return this.yzN;
    }
    return false;
  }
  
  public final void zd(long paramLong)
  {
    AppMethodBeat.i(161059);
    ad.i("MicroMsg.ScanRetryManager", "alvinluo saveTimeout %d", new Object[] { Long.valueOf(paramLong) });
    ax localax = this.cBy;
    if (localax != null) {
      localax.putLong("scan_code_retry_timeout", paramLong);
    }
    localax = this.cBy;
    if (localax != null)
    {
      localax.apply();
      AppMethodBeat.o(161059);
      return;
    }
    AppMethodBeat.o(161059);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.g
 * JD-Core Version:    0.7.0.1
 */