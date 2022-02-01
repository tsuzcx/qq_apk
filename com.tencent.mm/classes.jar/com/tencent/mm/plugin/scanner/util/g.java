package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.expt.a.b;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.aw;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/util/ScanRetryManager;", "", "()V", "canRetryReopenCamera", "", "canRetryUsingTexture", "enterTimestamp", "", "exitTimestamp", "isRetry", "isScanSuccess", "isUpdated", "mRetryType", "", "mTextureScaledFactor", "", "mTimeout", "mTimeoutFactor", "maxTimeout", "minTimeout", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "onPreviewFrameCalled", "stayTime", "canRetry", "retryType", "cancelRetryType", "", "checkAndResetTimeout", "enterScanUI", "exitScanUI", "getMMKVKey", "", "getRetryType", "getSavedTimeout", "getTextureScaleFactor", "getTimeout", "init", "initMMKV", "saveTimeout", "timeout", "setIsRetry", "setOnPreviewFrameCalled", "setScanSuccess", "updateTimeout", "time", "Companion", "plugin-scan_release"})
public final class g
{
  public static final g.a xlQ;
  private aw cqB;
  public long dpQ;
  public boolean isRetry;
  public long mTimeout;
  public boolean xfN;
  public long xlF;
  public long xlG;
  public float xlH;
  public boolean xlI;
  public int xlJ;
  public boolean xlK;
  public boolean xlL;
  public float xlM;
  public long xlN;
  public long xlO;
  public boolean xlP;
  
  static
  {
    AppMethodBeat.i(161061);
    xlQ = new g.a((byte)0);
    AppMethodBeat.o(161061);
  }
  
  public g()
  {
    AppMethodBeat.i(161060);
    this.xlF = 5000L;
    this.xlG = 1000L;
    this.xlH = 2.0F;
    this.xlM = 0.8F;
    Object localObject = new StringBuilder();
    k.g(com.tencent.mm.kernel.g.agP(), "MMKernel.account()");
    this.cqB = aw.aKU(a.afE() + "_scan_code_retry");
    localObject = this.cqB;
    long l;
    int i;
    int j;
    if (localObject != null)
    {
      l = ((aw)localObject).getLong("scan_code_retry_timeout", 5000L);
      this.mTimeout = l;
      this.xlJ = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pWB, 0);
      this.xlF = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pWD, 5000L);
      this.xlG = 1000L;
      i = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pWE, 200);
      this.xlH = (i / 100.0F);
      this.mTimeout = Math.max(this.xlG, this.mTimeout);
      this.mTimeout = Math.min(this.xlF, this.mTimeout);
      j = ((b)com.tencent.mm.kernel.g.ab(b.class)).a(b.a.pWF, 80);
      if (j != 0)
      {
        this.xlM = (j / 100.0F);
        this.xlM = Math.min(1.0F, this.xlM);
      }
      if (this.xlJ != 1) {
        break label396;
      }
      this.xlK = true;
      this.xlL = false;
    }
    for (;;)
    {
      ac.i("MicroMsg.ScanRetryManager", "alvinluo init retryType: %d, maxTimeout: %d, minTimeout: %d, timeout: %d, timeoutFactor config: %d, factor: %f, textureScaleFactor: %d, factor: %f, canRetry: %b, %b", new Object[] { Integer.valueOf(this.xlJ), Long.valueOf(this.xlF), Long.valueOf(this.xlG), Long.valueOf(this.mTimeout), Integer.valueOf(i), Float.valueOf(this.xlH), Integer.valueOf(j), Float.valueOf(this.xlM), Boolean.valueOf(this.xlK), Boolean.valueOf(this.xlL) });
      AppMethodBeat.o(161060);
      return;
      l = 5000L;
      break;
      label396:
      if (this.xlJ == 2)
      {
        this.xlK = false;
        this.xlL = true;
      }
    }
  }
  
  public final boolean Nt(int paramInt)
  {
    if (paramInt == 1) {
      return this.xlK;
    }
    if (paramInt == 2) {
      return this.xlL;
    }
    return false;
  }
  
  public final void wG(long paramLong)
  {
    AppMethodBeat.i(161059);
    ac.i("MicroMsg.ScanRetryManager", "alvinluo saveTimeout %d", new Object[] { Long.valueOf(paramLong) });
    aw localaw = this.cqB;
    if (localaw != null) {
      localaw.putLong("scan_code_retry_timeout", paramLong);
    }
    localaw = this.cqB;
    if (localaw != null)
    {
      localaw.apply();
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