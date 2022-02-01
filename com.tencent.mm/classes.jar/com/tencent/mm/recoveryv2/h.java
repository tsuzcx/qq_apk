package com.tencent.mm.recoveryv2;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;

public final class h
{
  public int Iom;
  public int Ion;
  public long Ioo;
  public long Iop;
  public long Ioq;
  public long Ior;
  public g Ios;
  
  private h(Context paramContext)
  {
    AppMethodBeat.i(195344);
    this.Ios = new g.b(paramContext, "recovery_setting");
    this.Ios.fkT();
    this.Iom = Math.max(this.Ios.getInt("setting_threshold_1", 3), 2);
    this.Ion = Math.max(this.Ios.getInt("setting_threshold_2", 5), 3);
    if (this.Ion < this.Iom) {
      this.Ion = this.Iom;
    }
    this.Ioo = Math.max(this.Ios.getLong("setting_crash_interval", 10000L), 5000L);
    this.Iop = Math.max(this.Ios.getLong("setting_crash_interval_sub", 30000L), 5000L);
    this.Ioq = Math.max(this.Ios.getLong("setting_crash_minimal_interval", 1000L), 0L);
    this.Ior = Math.max(this.Ios.getLong("setting_reset_delay", 5000L), 1000L);
    AppMethodBeat.o(195344);
  }
  
  public static h hT(Context paramContext)
  {
    AppMethodBeat.i(195343);
    paramContext = new h(paramContext);
    AppMethodBeat.o(195343);
    return paramContext;
  }
  
  public static final class a
  {
    public final g Ios;
    public boolean mEnabled;
    
    private a(Context paramContext)
    {
      AppMethodBeat.i(195334);
      this.Ios = new g.b(paramContext, "recovery_enable").fkT();
      this.mEnabled = this.Ios.getBoolean("enable", true);
      AppMethodBeat.o(195334);
    }
    
    public static a hU(Context paramContext)
    {
      AppMethodBeat.i(195333);
      paramContext = new a(paramContext);
      AppMethodBeat.o(195333);
      return paramContext;
    }
  }
  
  public static final class b
  {
    private static final long jSV;
    private final g Ios;
    long Iot;
    long Iou;
    
    static
    {
      AppMethodBeat.i(195338);
      jSV = TimeUnit.DAYS.toMillis(1L) / 2L;
      AppMethodBeat.o(195338);
    }
    
    private b(Context paramContext)
    {
      AppMethodBeat.i(195336);
      this.Ios = new g.b(paramContext, "recovery_internal").fkT();
      this.Iot = this.Ios.getLong("internal_last_ui_launched", 0L);
      this.Iou = this.Ios.getLong("internal_ui_launch_interval", jSV);
      AppMethodBeat.o(195336);
    }
    
    public static b hV(Context paramContext)
    {
      AppMethodBeat.i(195335);
      paramContext = new b(paramContext);
      AppMethodBeat.o(195335);
      return paramContext;
    }
    
    public final void save()
    {
      AppMethodBeat.i(195337);
      this.Ios.bS("internal_last_ui_launched", this.Iot).bS("internal_ui_launch_interval", this.Iou).fkU();
      AppMethodBeat.o(195337);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.h
 * JD-Core Version:    0.7.0.1
 */