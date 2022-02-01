package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/util/ScanRetryManager;", "", "()V", "canRetryReopenCamera", "", "canRetryUsingTexture", "enterTimestamp", "", "exitTimestamp", "isRetry", "isScanSuccess", "isUpdated", "mRetryType", "", "mTextureScaledFactor", "", "mTimeout", "mTimeoutFactor", "maxTimeout", "minTimeout", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "onPreviewFrameCalled", "stayTime", "canRetry", "retryType", "cancelRetryType", "", "checkAndResetTimeout", "enterScanUI", "exitScanUI", "getMMKVKey", "", "getRetryType", "getSavedTimeout", "getTextureScaleFactor", "getTimeout", "init", "initMMKV", "saveTimeout", "timeout", "setIsRetry", "setOnPreviewFrameCalled", "setScanSuccess", "updateTimeout", "time", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final j.a PiU;
  public long AxK;
  public boolean PbY;
  public long PiV;
  public long PiW;
  public float PiX;
  public boolean PiY;
  public int PiZ;
  public boolean Pja;
  public boolean Pjb;
  public float Pjc;
  public long Pjd;
  public boolean Pje;
  private MultiProcessMMKV eMf;
  public long hTS;
  public long mTimeout;
  public boolean vBn;
  
  static
  {
    AppMethodBeat.i(161061);
    PiU = new j.a((byte)0);
    AppMethodBeat.o(161061);
  }
  
  public j()
  {
    AppMethodBeat.i(161060);
    this.PiV = 3000L;
    this.PiW = 1000L;
    this.PiX = 2.0F;
    this.Pjc = 0.8F;
    h.baC();
    this.eMf = MultiProcessMMKV.getSingleMMKV(s.X(b.aZs(), "_scan_code_retry"));
    MultiProcessMMKV localMultiProcessMMKV = this.eMf;
    long l;
    if (localMultiProcessMMKV == null)
    {
      l = 3000L;
      this.mTimeout = l;
      this.PiZ = 1;
      this.PiV = 3000L;
      this.PiW = 1000L;
      this.PiX = 2.0F;
      this.mTimeout = Math.max(this.PiW, this.mTimeout);
      this.mTimeout = Math.min(this.PiV, this.mTimeout);
      this.Pjc = 0.8F;
      this.Pjc = Math.min(1.0F, this.Pjc);
      if (this.PiZ != 1) {
        break label293;
      }
      this.Pja = true;
      this.Pjb = false;
    }
    for (;;)
    {
      Log.i("MicroMsg.ScanRetryManager", "alvinluo init retryType: %d, maxTimeout: %d, minTimeout: %d, timeout: %d, timeoutFactor config: %d, factor: %f, textureScaleFactor: %d, factor: %f, canRetry: %b, %b", new Object[] { Integer.valueOf(this.PiZ), Long.valueOf(this.PiV), Long.valueOf(this.PiW), Long.valueOf(this.mTimeout), Integer.valueOf(200), Float.valueOf(this.PiX), Integer.valueOf(80), Float.valueOf(this.Pjc), Boolean.valueOf(this.Pja), Boolean.valueOf(this.Pjb) });
      AppMethodBeat.o(161060);
      return;
      l = localMultiProcessMMKV.getLong("scan_code_retry_timeout", 3000L);
      break;
      label293:
      if (this.PiZ == 2)
      {
        this.Pja = false;
        this.Pjb = true;
      }
    }
  }
  
  public final boolean aiF(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      return this.Pja;
    }
    return this.Pjb;
  }
  
  public final void uc(long paramLong)
  {
    AppMethodBeat.i(161059);
    Log.i("MicroMsg.ScanRetryManager", "alvinluo saveTimeout %d", new Object[] { Long.valueOf(paramLong) });
    MultiProcessMMKV localMultiProcessMMKV = this.eMf;
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.putLong("scan_code_retry_timeout", paramLong);
    }
    localMultiProcessMMKV = this.eMf;
    if (localMultiProcessMMKV != null) {
      localMultiProcessMMKV.apply();
    }
    AppMethodBeat.o(161059);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.j
 * JD-Core Version:    0.7.0.1
 */