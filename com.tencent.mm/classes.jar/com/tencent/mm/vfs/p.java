package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdcard_migrate.b;
import com.tencent.mm.sdk.platformtools.ax;

public final class p
{
  private static Boolean LlY = null;
  private static Boolean LlZ = null;
  private static Boolean Lma = null;
  private static Boolean Lmb = null;
  private static Boolean Lmc = null;
  
  public static void bxK()
  {
    AppMethodBeat.i(182929);
    ax localax = ax.aQz("VFSStrategy");
    long l1 = localax.getLong("VFSSwitchReportTime", 0L);
    long l2 = System.currentTimeMillis();
    if ((l1 <= 0L) || (l2 - l1 >= 259200000L))
    {
      localax.encode("VFSSwitchReportTime", l2);
      e.ygI.idkeyStat(1317L, 0L, 1L, true);
      if (fPq()) {
        e.ygI.idkeyStat(1317L, 1L, 1L, true);
      }
      e.ygI.idkeyStat(1317L, 3L, 1L, true);
      e.ygI.idkeyStat(1317L, 5L, 1L, true);
      if (fPr()) {
        e.ygI.idkeyStat(1317L, 7L, 1L, true);
      }
      if (fPt()) {
        e.ygI.idkeyStat(1317L, 9L, 1L, true);
      }
    }
    AppMethodBeat.o(182929);
  }
  
  public static boolean fPq()
  {
    try
    {
      AppMethodBeat.i(182930);
      if (Lmc == null) {
        Lmc = Boolean.valueOf(b.fjt());
      }
      boolean bool = Lmc.booleanValue();
      AppMethodBeat.o(182930);
      return bool;
    }
    finally {}
  }
  
  public static boolean fPr()
  {
    try
    {
      AppMethodBeat.i(189957);
      if (LlZ == null) {
        LlZ = Boolean.valueOf(b.fjC());
      }
      boolean bool = LlZ.booleanValue();
      AppMethodBeat.o(189957);
      return bool;
    }
    finally {}
  }
  
  public static boolean fPs()
  {
    try
    {
      AppMethodBeat.i(182933);
      AppMethodBeat.o(182933);
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean fPt()
  {
    try
    {
      AppMethodBeat.i(182934);
      if (Lmb == null) {
        Lmb = Boolean.TRUE;
      }
      boolean bool = Lmb.booleanValue();
      AppMethodBeat.o(182934);
      return bool;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.p
 * JD-Core Version:    0.7.0.1
 */