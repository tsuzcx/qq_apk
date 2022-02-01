package com.tencent.mm.vfs;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdcard_migrate.b;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class ac
{
  private static Boolean YFB = null;
  private static Boolean YFC = null;
  private static Boolean YFD = null;
  private static Boolean YFE = null;
  private static Boolean YFF = null;
  
  public static void igq()
  {
    AppMethodBeat.i(200277);
    h.ZvG.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193856);
        MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("VFSStrategy");
        long l1 = localMultiProcessMMKV.getLong("VFSSwitchReportTime", 0L);
        long l2 = System.currentTimeMillis();
        if ((l1 <= 0L) || (l2 - l1 >= 259200000L))
        {
          localMultiProcessMMKV.encode("VFSSwitchReportTime", l2);
          f.Iyx.idkeyStat(1317L, 0L, 1L, true);
          if (ac.igr()) {
            f.Iyx.idkeyStat(1317L, 1L, 1L, true);
          }
          f.Iyx.idkeyStat(1317L, 3L, 1L, true);
          f.Iyx.idkeyStat(1317L, 5L, 1L, true);
          f.Iyx.idkeyStat(1317L, 7L, 1L, true);
          f.Iyx.idkeyStat(1317L, 9L, 1L, true);
        }
        AppMethodBeat.o(193856);
      }
    }, "VFSSwitch_Rpt");
    AppMethodBeat.o(200277);
  }
  
  public static boolean igr()
  {
    try
    {
      AppMethodBeat.i(182930);
      if (YFF == null) {
        YFF = Boolean.valueOf(b.hsX());
      }
      boolean bool = YFF.booleanValue();
      AppMethodBeat.o(182930);
      return bool;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.vfs.ac
 * JD-Core Version:    0.7.0.1
 */