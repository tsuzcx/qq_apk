package com.tencent.mm.recoveryv2;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  private g HTT;
  public int HTW;
  public boolean HUo;
  public boolean HUp;
  public boolean HUq;
  public int HUr;
  public boolean HUs;
  public int HUt;
  public long HUu;
  public int mFrom;
  
  private i(Context paramContext)
  {
    AppMethodBeat.i(207038);
    this.HTT = new g.b(paramContext, "recovery_statistic").fhg();
    this.HTW = this.HTT.getInt("crash_count", 0);
    this.HUo = this.HTT.getBoolean("launch_recovery", false);
    this.HUp = this.HTT.getBoolean("launch_recovery_real", false);
    this.HUq = this.HTT.getBoolean("recover_from_crash", false);
    this.HUr = this.HTT.getInt("recovery_status", -1);
    this.mFrom = this.HTT.getInt("recovery_from", 0);
    this.HUt = this.HTT.getInt("recover_internal_status", 0);
    this.HUu = this.HTT.getLong("recover_running_time", 0L);
    this.HUs = this.HTT.getBoolean("recover_is_discard", false);
    AppMethodBeat.o(207038);
  }
  
  public static i hR(Context paramContext)
  {
    AppMethodBeat.i(207037);
    paramContext = new i(paramContext);
    AppMethodBeat.o(207037);
    return paramContext;
  }
  
  public final void fhl()
  {
    AppMethodBeat.i(207041);
    this.HTT.ge("crash_count", this.HTW).cF("launch_recovery", this.HUo).cF("launch_recovery_real", this.HUp).cF("recover_from_crash", this.HUq).ge("recovery_status", this.HUr).ge("recovery_from", this.mFrom).ge("recover_internal_status", this.HUt).bR("recover_running_time", this.HUu).cF("recover_is_discard", this.HUs).fhd();
    AppMethodBeat.o(207041);
  }
  
  public final void save()
  {
    AppMethodBeat.i(207040);
    this.HTT.ge("crash_count", this.HTW).cF("launch_recovery", this.HUo).cF("launch_recovery_real", this.HUp).cF("recover_from_crash", this.HUq).ge("recovery_status", this.HUr).ge("recovery_from", this.mFrom).ge("recover_internal_status", this.HUt).bR("recover_running_time", this.HUu).cF("recover_is_discard", this.HUs).fhc();
    AppMethodBeat.o(207040);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(207039);
    String str = "RecoveryStatistic{mCrashCount=" + this.HTW + ", mNeedLaunchRecovery=" + this.HUo + ", mHasReallyLaunchRecovery=" + this.HUp + ", mHasRecoverFromCrash=" + this.HUq + ", mRecoveryStatus=" + this.HUr + ", mIsDiscarded=" + this.HUs + ", mFrom=" + this.mFrom + ", mInternalStatus=" + this.HUt + ", mRunningTime=" + this.HUu + '}';
    AppMethodBeat.o(207039);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.i
 * JD-Core Version:    0.7.0.1
 */