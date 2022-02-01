package com.tencent.mm.recoveryv2;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public final class h
{
  public int NBK;
  public int NBL;
  public long NBM;
  public long NBN;
  public long NBO;
  public long NBP;
  public g NBQ;
  
  private h(Context paramContext)
  {
    AppMethodBeat.i(193832);
    this.NBQ = new g.b(paramContext, "recovery_setting");
    this.NBQ.guE();
    this.NBK = Math.max(this.NBQ.getInt("setting_threshold_1", 3), 2);
    this.NBL = Math.max(this.NBQ.getInt("setting_threshold_2", 5), 3);
    if (this.NBL < this.NBK) {
      this.NBL = this.NBK;
    }
    this.NBM = Math.max(this.NBQ.getLong("setting_crash_interval", 10000L), 5000L);
    this.NBN = Math.max(this.NBQ.getLong("setting_crash_interval_sub", 30000L), 5000L);
    this.NBO = Math.max(this.NBQ.getLong("setting_crash_minimal_interval", 1000L), 0L);
    this.NBP = Math.max(this.NBQ.getLong("setting_reset_delay", 5000L), 1000L);
    AppMethodBeat.o(193832);
  }
  
  public static h iM(Context paramContext)
  {
    AppMethodBeat.i(193831);
    paramContext = new h(paramContext);
    AppMethodBeat.o(193831);
    return paramContext;
  }
  
  public static final class a
  {
    public final g NBQ;
    public boolean mEnabled;
    
    private a(Context paramContext)
    {
      AppMethodBeat.i(193822);
      this.NBQ = new g.b(paramContext, "recovery_enable").guE();
      this.mEnabled = this.NBQ.getBoolean("enable", true);
      AppMethodBeat.o(193822);
    }
    
    public static a iN(Context paramContext)
    {
      AppMethodBeat.i(193821);
      paramContext = new a(paramContext);
      AppMethodBeat.o(193821);
      return paramContext;
    }
  }
  
  public static final class b
  {
    private static final long kVD;
    private final g NBQ;
    long NBR;
    long NBS;
    
    static
    {
      AppMethodBeat.i(193826);
      kVD = TimeUnit.DAYS.toMillis(1L) / 2L;
      AppMethodBeat.o(193826);
    }
    
    private b(Context paramContext)
    {
      AppMethodBeat.i(193824);
      this.NBQ = new g.b(paramContext, "recovery_internal").guE();
      this.NBR = this.NBQ.getLong("internal_last_ui_launched", 0L);
      this.NBS = this.NBQ.getLong("internal_ui_launch_interval", kVD);
      AppMethodBeat.o(193824);
    }
    
    public static b iO(Context paramContext)
    {
      AppMethodBeat.i(193823);
      paramContext = new b(paramContext);
      AppMethodBeat.o(193823);
      return paramContext;
    }
    
    public final void save()
    {
      AppMethodBeat.i(193825);
      this.NBQ.bT("internal_last_ui_launched", this.NBR).bT("internal_ui_launch_interval", this.NBS).guF();
      AppMethodBeat.o(193825);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.h
 * JD-Core Version:    0.7.0.1
 */