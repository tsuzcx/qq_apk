package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdcard_migrate.b;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

public final class ag
{
  private static Boolean agBe = null;
  private static Boolean agBf = null;
  private static Boolean agBg = null;
  private static Boolean agBh = null;
  private static Boolean agBi = null;
  
  public static void jLD()
  {
    AppMethodBeat.i(238099);
    h.ahAA.g(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(238170);
        MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("VFSStrategy");
        long l1 = localMultiProcessMMKV.getLong("VFSSwitchReportTime", 0L);
        long l2 = System.currentTimeMillis();
        if ((l1 <= 0L) || (l2 - l1 >= 259200000L))
        {
          localMultiProcessMMKV.encode("VFSSwitchReportTime", l2);
          f.Ozc.idkeyStat(1317L, 0L, 1L, true);
          if (ag.jLE()) {
            f.Ozc.idkeyStat(1317L, 1L, 1L, true);
          }
          f.Ozc.idkeyStat(1317L, 3L, 1L, true);
          f.Ozc.idkeyStat(1317L, 5L, 1L, true);
          f.Ozc.idkeyStat(1317L, 7L, 1L, true);
          f.Ozc.idkeyStat(1317L, 9L, 1L, true);
        }
        AppMethodBeat.o(238170);
      }
    }, "VFSSwitch_Rpt");
    AppMethodBeat.o(238099);
  }
  
  public static boolean jLE()
  {
    try
    {
      AppMethodBeat.i(182930);
      if (agBi == null) {
        agBi = Boolean.valueOf(b.iTc());
      }
      boolean bool = agBi.booleanValue();
      AppMethodBeat.o(182930);
      return bool;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.ag
 * JD-Core Version:    0.7.0.1
 */