package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdcard_migrate.b;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class z
{
  private static Boolean ReJ = null;
  private static Boolean ReK = null;
  private static Boolean ReL = null;
  private static Boolean ReM = null;
  private static Boolean ReN = null;
  
  public static void bUV()
  {
    AppMethodBeat.i(182929);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("VFSStrategy");
    long l1 = localMultiProcessMMKV.getLong("VFSSwitchReportTime", 0L);
    long l2 = System.currentTimeMillis();
    if ((l1 <= 0L) || (l2 - l1 >= 259200000L))
    {
      localMultiProcessMMKV.encode("VFSSwitchReportTime", l2);
      e.Cxv.idkeyStat(1317L, 0L, 1L, true);
      if (heY()) {
        e.Cxv.idkeyStat(1317L, 1L, 1L, true);
      }
      e.Cxv.idkeyStat(1317L, 3L, 1L, true);
      e.Cxv.idkeyStat(1317L, 5L, 1L, true);
      e.Cxv.idkeyStat(1317L, 7L, 1L, true);
      e.Cxv.idkeyStat(1317L, 9L, 1L, true);
    }
    AppMethodBeat.o(182929);
  }
  
  public static boolean heY()
  {
    try
    {
      AppMethodBeat.i(182930);
      if (ReN == null) {
        ReN = Boolean.valueOf(b.gwY());
      }
      boolean bool = ReN.booleanValue();
      AppMethodBeat.o(182930);
      return bool;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.z
 * JD-Core Version:    0.7.0.1
 */