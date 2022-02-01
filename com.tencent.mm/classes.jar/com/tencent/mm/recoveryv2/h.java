package com.tencent.mm.recoveryv2;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public final class h
{
  public int HUe;
  public int HUf;
  public long HUg;
  public long HUh;
  public long HUi;
  public long HUj;
  public g HUk;
  
  private h(Context paramContext)
  {
    AppMethodBeat.i(207036);
    this.HUk = new g.b(paramContext, "recovery_setting");
    this.HUk.fhb();
    this.HUe = Math.max(this.HUk.getInt("setting_threshold_1", 3), 2);
    this.HUf = Math.max(this.HUk.getInt("setting_threshold_2", 5), 3);
    if (this.HUf < this.HUe) {
      this.HUf = this.HUe;
    }
    this.HUg = Math.max(this.HUk.getLong("setting_crash_interval", 10000L), 5000L);
    this.HUh = Math.max(this.HUk.getLong("setting_crash_interval_sub", 30000L), 5000L);
    this.HUi = Math.max(this.HUk.getLong("setting_crash_minimal_interval", 1000L), 0L);
    this.HUj = Math.max(this.HUk.getLong("setting_reset_delay", 5000L), 1000L);
    AppMethodBeat.o(207036);
  }
  
  public static h hN(Context paramContext)
  {
    AppMethodBeat.i(207035);
    paramContext = new h(paramContext);
    AppMethodBeat.o(207035);
    return paramContext;
  }
  
  public static final class a
  {
    public final g HUk;
    public boolean mEnabled;
    
    private a(Context paramContext)
    {
      AppMethodBeat.i(207026);
      this.HUk = new g.b(paramContext, "recovery_enable").fhb();
      this.mEnabled = this.HUk.getBoolean("enable", true);
      AppMethodBeat.o(207026);
    }
    
    public static a hO(Context paramContext)
    {
      AppMethodBeat.i(207025);
      paramContext = new a(paramContext);
      AppMethodBeat.o(207025);
      return paramContext;
    }
  }
  
  public static final class b
  {
    private static final long jPD;
    private final g HUk;
    long HUl;
    long HUm;
    
    static
    {
      AppMethodBeat.i(207030);
      jPD = TimeUnit.DAYS.toMillis(1L) / 2L;
      AppMethodBeat.o(207030);
    }
    
    private b(Context paramContext)
    {
      AppMethodBeat.i(207028);
      this.HUk = new g.b(paramContext, "recovery_internal").fhb();
      this.HUl = this.HUk.getLong("internal_last_ui_launched", 0L);
      this.HUm = this.HUk.getLong("internal_ui_launch_interval", jPD);
      AppMethodBeat.o(207028);
    }
    
    public static b hP(Context paramContext)
    {
      AppMethodBeat.i(207027);
      paramContext = new b(paramContext);
      AppMethodBeat.o(207027);
      return paramContext;
    }
    
    public final void save()
    {
      AppMethodBeat.i(207029);
      this.HUk.bR("internal_last_ui_launched", this.HUl).bR("internal_ui_launch_interval", this.HUm).fhc();
      AppMethodBeat.o(207029);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.h
 * JD-Core Version:    0.7.0.1
 */