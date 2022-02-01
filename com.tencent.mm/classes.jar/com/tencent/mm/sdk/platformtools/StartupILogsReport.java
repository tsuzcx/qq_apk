package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.aa;

public final class StartupILogsReport
{
  private static final int KVSTAT_ID = 21381;
  public static final int MARK_GC_SEMISPACE_TRIM_ENABLED = 1;
  public static final int MARK_GC_SEMISPACE_TRIM_FAILURE = 3;
  public static final int MARK_GC_SEMISPACE_TRIM_SUCCESS = 2;
  public static final int MARK_PATRONS_ENABLED = 1;
  public static final int MARK_PATRONS_FAILURE = 3;
  public static final int MARK_PATRONS_SUCCESS = 2;
  public static final int MARK_WV_RESERVED_SPACE_SHRINKER_ENABLED = 1;
  public static final int MARK_WV_RESERVED_SPACE_SHRINKER_FAILURE = 3;
  public static final int MARK_WV_RESERVED_SPACE_SHRINKER_SUCCESS = 2;
  private static final String TAG = "MicroMsg.StartupILogsReport";
  public static final int TYPEID_FIRST_UI_SHOWN_COLD = 65541;
  public static final int TYPEID_FIRST_UI_SHOWN_WARM = 65542;
  public static final int TYPEID_GC_SEMISPACE_TRIM_STATUS = -536739836;
  public static final int TYPEID_PATRONS_STATUS = -536739837;
  public static final int TYPEID_WV_RESERVED_SPACE_SHRINKER_STATUS = -536739839;
  
  private static String getCurrentProcessName(Context paramContext)
  {
    AppMethodBeat.i(243721);
    paramContext = Util.nullAsNil(Util.getProcessNameByPid(paramContext, Process.myPid()));
    AppMethodBeat.o(243721);
    return paramContext;
  }
  
  public static void reportNumericValue(Context paramContext, int paramInt, Number paramNumber)
  {
    AppMethodBeat.i(243725);
    aa.a("MicroMsg.StartupILogsReport", "reportNumericValue: typeId:%s, value:%s", new Object[] { Integer.valueOf(paramInt), paramNumber });
    aa.b(21381, new Object[] { Integer.valueOf(paramInt), getCurrentProcessName(paramContext), paramNumber });
    AppMethodBeat.o(243725);
  }
  
  public static void reportStringValue(Context paramContext, int paramInt, String paramString)
  {
    AppMethodBeat.i(243732);
    aa.a("MicroMsg.StartupILogsReport", "reportStringValue: typeId:%s, value:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    aa.b(21381, new Object[] { Integer.valueOf(paramInt), getCurrentProcessName(paramContext), Integer.valueOf(0), paramString });
    AppMethodBeat.o(243732);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.StartupILogsReport
 * JD-Core Version:    0.7.0.1
 */