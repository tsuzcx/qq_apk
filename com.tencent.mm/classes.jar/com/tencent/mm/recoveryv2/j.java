package com.tencent.mm.recoveryv2;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  boolean UPA;
  int UPB;
  long UPC;
  private h UPc;
  int UPf;
  boolean UPw;
  private boolean UPx;
  private boolean UPy;
  private int UPz;
  int mFrom;
  
  private j(Context paramContext)
  {
    AppMethodBeat.i(190217);
    this.UPc = new h.b(paramContext, "recovery_statistic").hqk();
    this.UPf = this.UPc.getInt("crash_count", 0);
    this.UPw = this.UPc.getBoolean("launch_recovery", false);
    this.UPx = this.UPc.getBoolean("launch_recovery_real", false);
    this.UPy = this.UPc.getBoolean("recover_from_crash", false);
    this.UPz = this.UPc.getInt("recovery_status", -1);
    this.mFrom = this.UPc.getInt("recovery_from", 0);
    this.UPB = this.UPc.getInt("recover_internal_status", 0);
    this.UPC = this.UPc.getLong("recover_running_time", 0L);
    this.UPA = this.UPc.getBoolean("recover_is_discard", false);
    AppMethodBeat.o(190217);
  }
  
  public static j jT(Context paramContext)
  {
    AppMethodBeat.i(190209);
    paramContext = new j(paramContext);
    AppMethodBeat.o(190209);
    return paramContext;
  }
  
  public final j EA(boolean paramBoolean)
  {
    this.UPA = paramBoolean;
    return this;
  }
  
  public final j arJ(int paramInt)
  {
    this.UPz = paramInt;
    return this;
  }
  
  public final void arg()
  {
    AppMethodBeat.i(190244);
    this.UPc.hu("crash_count", this.UPf).dp("launch_recovery", this.UPw).dp("launch_recovery_real", this.UPx).dp("recover_from_crash", this.UPy).hu("recovery_status", this.UPz).hu("recovery_from", this.mFrom).hu("recover_internal_status", this.UPB).ca("recover_running_time", this.UPC).dp("recover_is_discard", this.UPA).hqg();
    AppMethodBeat.o(190244);
  }
  
  public final boolean hqA()
  {
    return this.UPy;
  }
  
  public final j hqB()
  {
    this.UPy = true;
    return this;
  }
  
  public final int hqC()
  {
    return this.UPz;
  }
  
  public final int hqD()
  {
    return this.mFrom;
  }
  
  public final int hqE()
  {
    return this.UPB;
  }
  
  public final long hqF()
  {
    return this.UPC;
  }
  
  public final boolean hqG()
  {
    return this.UPA;
  }
  
  public final j hqH()
  {
    this.UPf = 0;
    this.UPw = false;
    this.UPx = false;
    this.UPy = false;
    this.UPz = -1;
    this.mFrom = 0;
    this.UPB = 0;
    this.UPC = 0L;
    this.UPA = false;
    return this;
  }
  
  public final void hqI()
  {
    AppMethodBeat.i(190246);
    this.UPc.hu("crash_count", this.UPf).dp("launch_recovery", this.UPw).dp("launch_recovery_real", this.UPx).dp("recover_from_crash", this.UPy).hu("recovery_status", this.UPz).hu("recovery_from", this.mFrom).hu("recover_internal_status", this.UPB).ca("recover_running_time", this.UPC).dp("recover_is_discard", this.UPA).hqh();
    AppMethodBeat.o(190246);
  }
  
  public final int hqb()
  {
    return this.UPf;
  }
  
  public final boolean hqx()
  {
    return this.UPw;
  }
  
  public final boolean hqy()
  {
    return this.UPx;
  }
  
  public final j hqz()
  {
    this.UPx = true;
    return this;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(190225);
    String str = "RecoveryStatistic{mCrashCount=" + this.UPf + ", mNeedLaunchRecovery=" + this.UPw + ", mHasReallyLaunchRecovery=" + this.UPx + ", mHasRecoverFromCrash=" + this.UPy + ", mRecoveryStatus=" + this.UPz + ", mIsDiscarded=" + this.UPA + ", mFrom=" + this.mFrom + ", mInternalStatus=" + this.UPB + ", mRunningTime=" + this.UPC + '}';
    AppMethodBeat.o(190225);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.j
 * JD-Core Version:    0.7.0.1
 */