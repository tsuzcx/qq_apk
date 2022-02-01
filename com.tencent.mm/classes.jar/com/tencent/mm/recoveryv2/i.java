package com.tencent.mm.recoveryv2;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  public boolean IoA;
  public int IoB;
  public long IoC;
  private g Iob;
  public int Ioe;
  public boolean Iow;
  public boolean Iox;
  public boolean Ioy;
  public int Ioz;
  public int mFrom;
  
  private i(Context paramContext)
  {
    AppMethodBeat.i(195346);
    this.Iob = new g.b(paramContext, "recovery_statistic").fkY();
    this.Ioe = this.Iob.getInt("crash_count", 0);
    this.Iow = this.Iob.getBoolean("launch_recovery", false);
    this.Iox = this.Iob.getBoolean("launch_recovery_real", false);
    this.Ioy = this.Iob.getBoolean("recover_from_crash", false);
    this.Ioz = this.Iob.getInt("recovery_status", -1);
    this.mFrom = this.Iob.getInt("recovery_from", 0);
    this.IoB = this.Iob.getInt("recover_internal_status", 0);
    this.IoC = this.Iob.getLong("recover_running_time", 0L);
    this.IoA = this.Iob.getBoolean("recover_is_discard", false);
    AppMethodBeat.o(195346);
  }
  
  public static i hX(Context paramContext)
  {
    AppMethodBeat.i(195345);
    paramContext = new i(paramContext);
    AppMethodBeat.o(195345);
    return paramContext;
  }
  
  public final void fld()
  {
    AppMethodBeat.i(195349);
    this.Iob.gn("crash_count", this.Ioe).cJ("launch_recovery", this.Iow).cJ("launch_recovery_real", this.Iox).cJ("recover_from_crash", this.Ioy).gn("recovery_status", this.Ioz).gn("recovery_from", this.mFrom).gn("recover_internal_status", this.IoB).bS("recover_running_time", this.IoC).cJ("recover_is_discard", this.IoA).fkV();
    AppMethodBeat.o(195349);
  }
  
  public final void save()
  {
    AppMethodBeat.i(195348);
    this.Iob.gn("crash_count", this.Ioe).cJ("launch_recovery", this.Iow).cJ("launch_recovery_real", this.Iox).cJ("recover_from_crash", this.Ioy).gn("recovery_status", this.Ioz).gn("recovery_from", this.mFrom).gn("recover_internal_status", this.IoB).bS("recover_running_time", this.IoC).cJ("recover_is_discard", this.IoA).fkU();
    AppMethodBeat.o(195348);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(195347);
    String str = "RecoveryStatistic{mCrashCount=" + this.Ioe + ", mNeedLaunchRecovery=" + this.Iow + ", mHasReallyLaunchRecovery=" + this.Iox + ", mHasRecoverFromCrash=" + this.Ioy + ", mRecoveryStatus=" + this.Ioz + ", mIsDiscarded=" + this.IoA + ", mFrom=" + this.mFrom + ", mInternalStatus=" + this.IoB + ", mRunningTime=" + this.IoC + '}';
    AppMethodBeat.o(195347);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.i
 * JD-Core Version:    0.7.0.1
 */