package com.tencent.mm.vfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdcard_migrate.b;
import com.tencent.mm.sdk.platformtools.ay;

public final class v
{
  private static Boolean LIH = null;
  private static Boolean LII = null;
  private static Boolean LIJ = null;
  private static Boolean LIK = null;
  private static Boolean LIL = null;
  
  public static void byD()
  {
    AppMethodBeat.i(182929);
    ay localay = ay.aRW("VFSStrategy");
    long l1 = localay.getLong("VFSSwitchReportTime", 0L);
    long l2 = System.currentTimeMillis();
    if ((l1 <= 0L) || (l2 - l1 >= 259200000L))
    {
      localay.encode("VFSSwitchReportTime", l2);
      e.ywz.idkeyStat(1317L, 0L, 1L, true);
      if (fTN()) {
        e.ywz.idkeyStat(1317L, 1L, 1L, true);
      }
      e.ywz.idkeyStat(1317L, 3L, 1L, true);
      e.ywz.idkeyStat(1317L, 5L, 1L, true);
      if (fTO()) {
        e.ywz.idkeyStat(1317L, 7L, 1L, true);
      }
      if (fTQ()) {
        e.ywz.idkeyStat(1317L, 9L, 1L, true);
      }
    }
    AppMethodBeat.o(182929);
  }
  
  public static boolean fTN()
  {
    try
    {
      AppMethodBeat.i(182930);
      if (LIL == null) {
        LIL = Boolean.valueOf(b.fnl());
      }
      boolean bool = LIL.booleanValue();
      AppMethodBeat.o(182930);
      return bool;
    }
    finally {}
  }
  
  public static boolean fTO()
  {
    try
    {
      AppMethodBeat.i(193661);
      if (LII == null) {
        LII = Boolean.valueOf(b.fnu());
      }
      boolean bool = LII.booleanValue();
      AppMethodBeat.o(193661);
      return bool;
    }
    finally {}
  }
  
  public static boolean fTP()
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
  
  public static boolean fTQ()
  {
    try
    {
      AppMethodBeat.i(182934);
      if (LIK == null) {
        LIK = Boolean.TRUE;
      }
      boolean bool = LIK.booleanValue();
      AppMethodBeat.o(182934);
      return bool;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vfs.v
 * JD-Core Version:    0.7.0.1
 */