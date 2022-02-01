package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/util/ScanRetryManager;", "", "()V", "canRetryReopenCamera", "", "canRetryUsingTexture", "enterTimestamp", "", "exitTimestamp", "isRetry", "isScanSuccess", "isUpdated", "mRetryType", "", "mTextureScaledFactor", "", "mTimeout", "mTimeoutFactor", "maxTimeout", "minTimeout", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "onPreviewFrameCalled", "stayTime", "canRetry", "retryType", "cancelRetryType", "", "checkAndResetTimeout", "enterScanUI", "exitScanUI", "getMMKVKey", "", "getRetryType", "getSavedTimeout", "getTextureScaleFactor", "getTimeout", "init", "initMMKV", "saveTimeout", "timeout", "setIsRetry", "setOnPreviewFrameCalled", "setScanSuccess", "updateTimeout", "time", "Companion", "plugin-scan_release"})
public final class h
{
  public static final h.a IZk;
  public boolean ITg;
  public long IZa;
  public long IZb;
  public float IZc;
  public boolean IZd;
  public int IZe;
  public boolean IZf;
  public boolean IZg;
  public float IZh;
  public long IZi;
  public boolean IZj;
  private MultiProcessMMKV cQO;
  public long fOa;
  public boolean isRetry;
  public long mTimeout;
  public long zUF;
  
  static
  {
    AppMethodBeat.i(161061);
    IZk = new h.a((byte)0);
    AppMethodBeat.o(161061);
  }
  
  public h()
  {
    AppMethodBeat.i(161060);
    this.IZa = 5000L;
    this.IZb = 1000L;
    this.IZc = 2.0F;
    this.IZh = 0.8F;
    Object localObject = new StringBuilder();
    p.j(com.tencent.mm.kernel.h.aHE(), "MMKernel.account()");
    this.cQO = MultiProcessMMKV.getSingleMMKV(com.tencent.mm.kernel.b.aGq() + "_scan_code_retry");
    localObject = this.cQO;
    long l;
    int i;
    int j;
    if (localObject != null)
    {
      l = ((MultiProcessMMKV)localObject).getLong("scan_code_retry_timeout", 5000L);
      this.mTimeout = l;
      this.IZe = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vNU, 0);
      this.IZa = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vNW, 5000L);
      this.IZb = 1000L;
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vNX, 200);
      this.IZc = (i / 100.0F);
      this.mTimeout = Math.max(this.IZb, this.mTimeout);
      this.mTimeout = Math.min(this.IZa, this.mTimeout);
      j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vNY, 80);
      if (j != 0)
      {
        this.IZh = (j / 100.0F);
        this.IZh = Math.min(1.0F, this.IZh);
      }
      if (this.IZe != 1) {
        break label396;
      }
      this.IZf = true;
      this.IZg = false;
    }
    for (;;)
    {
      Log.i("MicroMsg.ScanRetryManager", "alvinluo init retryType: %d, maxTimeout: %d, minTimeout: %d, timeout: %d, timeoutFactor config: %d, factor: %f, textureScaleFactor: %d, factor: %f, canRetry: %b, %b", new Object[] { Integer.valueOf(this.IZe), Long.valueOf(this.IZa), Long.valueOf(this.IZb), Long.valueOf(this.mTimeout), Integer.valueOf(i), Float.valueOf(this.IZc), Integer.valueOf(j), Float.valueOf(this.IZh), Boolean.valueOf(this.IZf), Boolean.valueOf(this.IZg) });
      AppMethodBeat.o(161060);
      return;
      l = 5000L;
      break;
      label396:
      if (this.IZe == 2)
      {
        this.IZf = false;
        this.IZg = true;
      }
    }
  }
  
  public final void PY(long paramLong)
  {
    AppMethodBeat.i(161059);
    Log.i("MicroMsg.ScanRetryManager", "alvinluo saveTimeout %d", new Object[] { Long.valueOf(paramLong) });
    MultiProcessMMKV localMultiProcessMMKV = this.cQO;
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.putLong("scan_code_retry_timeout", paramLong);
    }
    localMultiProcessMMKV = this.cQO;
    if (localMultiProcessMMKV != null)
    {
      localMultiProcessMMKV.apply();
      AppMethodBeat.o(161059);
      return;
    }
    AppMethodBeat.o(161059);
  }
  
  public final boolean aea(int paramInt)
  {
    if (paramInt == 1) {
      return this.IZf;
    }
    if (paramInt == 2) {
      return this.IZg;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.h
 * JD-Core Version:    0.7.0.1
 */