package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/util/ScanRetryManager;", "", "()V", "canRetryReopenCamera", "", "canRetryUsingTexture", "enterTimestamp", "", "exitTimestamp", "isRetry", "isScanSuccess", "isUpdated", "mRetryType", "", "mTextureScaledFactor", "", "mTimeout", "mTimeoutFactor", "maxTimeout", "minTimeout", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "onPreviewFrameCalled", "stayTime", "canRetry", "retryType", "cancelRetryType", "", "checkAndResetTimeout", "enterScanUI", "exitScanUI", "getMMKVKey", "", "getRetryType", "getSavedTimeout", "getTextureScaleFactor", "getTimeout", "init", "initMMKV", "saveTimeout", "timeout", "setIsRetry", "setOnPreviewFrameCalled", "setScanSuccess", "updateTimeout", "time", "Companion", "plugin-scan_release"})
public final class g
{
  public static final g.a waK;
  private ax ctt;
  public long dsf;
  public boolean isRetry;
  public long mTimeout;
  public boolean vVc;
  public long waA;
  public float waB;
  public boolean waC;
  public int waD;
  public boolean waE;
  public boolean waF;
  public float waG;
  public long waH;
  public long waI;
  public boolean waJ;
  public long waz;
  
  static
  {
    AppMethodBeat.i(161061);
    waK = new g.a((byte)0);
    AppMethodBeat.o(161061);
  }
  
  public g()
  {
    AppMethodBeat.i(161060);
    this.waz = 5000L;
    this.waA = 1000L;
    this.waB = 2.0F;
    this.waG = 0.8F;
    Object localObject = new StringBuilder();
    k.g(com.tencent.mm.kernel.g.afz(), "MMKernel.account()");
    this.ctt = ax.aFD(a.aeo() + "_scan_code_retry");
    localObject = this.ctt;
    long l;
    int i;
    int j;
    if (localObject != null)
    {
      l = ((ax)localObject).getLong("scan_code_retry_timeout", 5000L);
      this.mTimeout = l;
      this.waD = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pss, 0);
      this.waz = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.psu, 5000L);
      this.waA = 1000L;
      i = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.psv, 200);
      this.waB = (i / 100.0F);
      this.mTimeout = Math.max(this.waA, this.mTimeout);
      this.mTimeout = Math.min(this.waz, this.mTimeout);
      j = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.psw, 80);
      if (j != 0)
      {
        this.waG = (j / 100.0F);
        this.waG = Math.min(1.0F, this.waG);
      }
      if (this.waD != 1) {
        break label396;
      }
      this.waE = true;
      this.waF = false;
    }
    for (;;)
    {
      ad.i("MicroMsg.ScanRetryManager", "alvinluo init retryType: %d, maxTimeout: %d, minTimeout: %d, timeout: %d, timeoutFactor config: %d, factor: %f, textureScaleFactor: %d, factor: %f, canRetry: %b, %b", new Object[] { Integer.valueOf(this.waD), Long.valueOf(this.waz), Long.valueOf(this.waA), Long.valueOf(this.mTimeout), Integer.valueOf(i), Float.valueOf(this.waB), Integer.valueOf(j), Float.valueOf(this.waG), Boolean.valueOf(this.waE), Boolean.valueOf(this.waF) });
      AppMethodBeat.o(161060);
      return;
      l = 5000L;
      break;
      label396:
      if (this.waD == 2)
      {
        this.waE = false;
        this.waF = true;
      }
    }
  }
  
  public final boolean Lt(int paramInt)
  {
    if (paramInt == 1) {
      return this.waE;
    }
    if (paramInt == 2) {
      return this.waF;
    }
    return false;
  }
  
  public final void sd(long paramLong)
  {
    AppMethodBeat.i(161059);
    ad.i("MicroMsg.ScanRetryManager", "alvinluo saveTimeout %d", new Object[] { Long.valueOf(paramLong) });
    ax localax = this.ctt;
    if (localax != null) {
      localax.putLong("scan_code_retry_timeout", paramLong);
    }
    localax = this.ctt;
    if (localax != null)
    {
      localax.apply();
      AppMethodBeat.o(161059);
      return;
    }
    AppMethodBeat.o(161059);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.g
 * JD-Core Version:    0.7.0.1
 */