package com.tencent.mm.recoveryv2;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  private f acjT;
  public int acjW;
  public boolean acko;
  public boolean ackp;
  public boolean ackq;
  public int ackr;
  public boolean acks;
  public int ackt;
  public long acku;
  public int mFrom;
  
  private i(Context paramContext)
  {
    AppMethodBeat.i(237920);
    this.acjT = new f.b(paramContext, "recovery_statistic").iQK();
    this.acjW = this.acjT.getInt("crash_count", 0);
    this.acko = this.acjT.getBoolean("launch_recovery", false);
    this.ackp = this.acjT.getBoolean("launch_recovery_real", false);
    this.ackq = this.acjT.getBoolean("recover_from_crash", false);
    this.ackr = this.acjT.getInt("recovery_status", -1);
    this.mFrom = this.acjT.getInt("recovery_from", 0);
    this.ackt = this.acjT.getInt("recover_internal_status", 0);
    this.acku = this.acjT.getLong("recover_running_time", 0L);
    this.acks = this.acjT.getBoolean("recover_is_discard", false);
    AppMethodBeat.o(237920);
  }
  
  public static i lV(Context paramContext)
  {
    AppMethodBeat.i(237913);
    paramContext = new i(paramContext);
    AppMethodBeat.o(237913);
    return paramContext;
  }
  
  public final void iQP()
  {
    AppMethodBeat.i(237941);
    this.acjT.iC("crash_count", this.acjW).dZ("launch_recovery", this.acko).dZ("launch_recovery_real", this.ackp).dZ("recover_from_crash", this.ackq).iC("recovery_status", this.ackr).iC("recovery_from", this.mFrom).iC("recover_internal_status", this.ackt).cm("recover_running_time", this.acku).dZ("recover_is_discard", this.acks).iQH();
    AppMethodBeat.o(237941);
  }
  
  public final void sz()
  {
    AppMethodBeat.i(237933);
    this.acjT.iC("crash_count", this.acjW).dZ("launch_recovery", this.acko).dZ("launch_recovery_real", this.ackp).dZ("recover_from_crash", this.ackq).iC("recovery_status", this.ackr).iC("recovery_from", this.mFrom).iC("recover_internal_status", this.ackt).cm("recover_running_time", this.acku).dZ("recover_is_discard", this.acks).iQG();
    AppMethodBeat.o(237933);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(237928);
    String str = "RecoveryStatistic{mCrashCount=" + this.acjW + ", mNeedLaunchRecovery=" + this.acko + ", mHasReallyLaunchRecovery=" + this.ackp + ", mHasRecoverFromCrash=" + this.ackq + ", mRecoveryStatus=" + this.ackr + ", mIsDiscarded=" + this.acks + ", mFrom=" + this.mFrom + ", mInternalStatus=" + this.ackt + ", mRunningTime=" + this.acku + '}';
    AppMethodBeat.o(237928);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.i
 * JD-Core Version:    0.7.0.1
 */