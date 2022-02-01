package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/sport/model/PushStepChangeTask;", "Ljava/lang/Runnable;", "tickTime", "", "sensorStep", "sensorNanoTime", "process", "", "(JJJLjava/lang/String;)V", "getProcess", "()Ljava/lang/String;", "getSensorNanoTime", "()J", "getSensorStep", "getTickTime", "run", "", "Companion", "plugin-sport_release"})
public final class i
  implements Runnable
{
  private static volatile long Lye;
  public static final a Lyf;
  private final long Lyb;
  private final long Lyc;
  private final long Lyd;
  private final String jZi;
  
  static
  {
    AppMethodBeat.i(221678);
    Lyf = new a((byte)0);
    AppMethodBeat.o(221678);
  }
  
  public i(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    AppMethodBeat.i(221677);
    this.Lyb = paramLong1;
    this.Lyc = paramLong2;
    this.Lyd = paramLong3;
    this.jZi = paramString;
    AppMethodBeat.o(221677);
  }
  
  public final void run()
  {
    AppMethodBeat.i(221675);
    if (Lye >= this.Lyb)
    {
      Log.i("MicroMsg.Sport.PushSportTask", "PushStepChangeTask execute sync smaller nano time %s %s %s %s %s", new Object[] { Long.valueOf(this.Lyc), Long.valueOf(this.Lyd), Long.valueOf(Lye), Long.valueOf(this.Lyb), this.jZi });
      AppMethodBeat.o(221675);
      return;
    }
    Log.i("MicroMsg.Sport.PushSportTask", "PushStepChangeTask execute sync time sensorStep:" + this.Lyc + " sensorNanoTime:" + this.Lyd + " lastTickTime:" + this.Lyb + " process:" + this.jZi);
    Lye = this.Lyb;
    if (com.tencent.mm.kernel.h.ag(PluginSport.class) != null)
    {
      a locala = com.tencent.mm.kernel.h.ag(PluginSport.class);
      p.j(locala, "MMKernel.plugin(PluginSport::class.java)");
      ((PluginSport)locala).getPushSportStepDetector().b(this.Lyc, this.Lyd, this.jZi);
    }
    AppMethodBeat.o(221675);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/sport/model/PushStepChangeTask$Companion;", "", "()V", "lastSyncTickTime", "", "plugin-sport_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.i
 * JD-Core Version:    0.7.0.1
 */