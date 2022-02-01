package com.tencent.mm.recoveryv2;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  public int NBC;
  public boolean NBU;
  public boolean NBV;
  public boolean NBW;
  public int NBX;
  public boolean NBY;
  public int NBZ;
  private g NBz;
  public long NCa;
  public int mFrom;
  
  private i(Context paramContext)
  {
    AppMethodBeat.i(193834);
    this.NBz = new g.b(paramContext, "recovery_statistic").guJ();
    this.NBC = this.NBz.getInt("crash_count", 0);
    this.NBU = this.NBz.getBoolean("launch_recovery", false);
    this.NBV = this.NBz.getBoolean("launch_recovery_real", false);
    this.NBW = this.NBz.getBoolean("recover_from_crash", false);
    this.NBX = this.NBz.getInt("recovery_status", -1);
    this.mFrom = this.NBz.getInt("recovery_from", 0);
    this.NBZ = this.NBz.getInt("recover_internal_status", 0);
    this.NCa = this.NBz.getLong("recover_running_time", 0L);
    this.NBY = this.NBz.getBoolean("recover_is_discard", false);
    AppMethodBeat.o(193834);
  }
  
  public static i iQ(Context paramContext)
  {
    AppMethodBeat.i(193833);
    paramContext = new i(paramContext);
    AppMethodBeat.o(193833);
    return paramContext;
  }
  
  public final void guO()
  {
    AppMethodBeat.i(193837);
    this.NBz.gL("crash_count", this.NBC).de("launch_recovery", this.NBU).de("launch_recovery_real", this.NBV).de("recover_from_crash", this.NBW).gL("recovery_status", this.NBX).gL("recovery_from", this.mFrom).gL("recover_internal_status", this.NBZ).bT("recover_running_time", this.NCa).de("recover_is_discard", this.NBY).guG();
    AppMethodBeat.o(193837);
  }
  
  public final void save()
  {
    AppMethodBeat.i(193836);
    this.NBz.gL("crash_count", this.NBC).de("launch_recovery", this.NBU).de("launch_recovery_real", this.NBV).de("recover_from_crash", this.NBW).gL("recovery_status", this.NBX).gL("recovery_from", this.mFrom).gL("recover_internal_status", this.NBZ).bT("recover_running_time", this.NCa).de("recover_is_discard", this.NBY).guF();
    AppMethodBeat.o(193836);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(193835);
    String str = "RecoveryStatistic{mCrashCount=" + this.NBC + ", mNeedLaunchRecovery=" + this.NBU + ", mHasReallyLaunchRecovery=" + this.NBV + ", mHasRecoverFromCrash=" + this.NBW + ", mRecoveryStatus=" + this.NBX + ", mIsDiscarded=" + this.NBY + ", mFrom=" + this.mFrom + ", mInternalStatus=" + this.NBZ + ", mRunningTime=" + this.NCa + '}';
    AppMethodBeat.o(193835);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.i
 * JD-Core Version:    0.7.0.1
 */