package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ProcessCache
{
  private static final String TAG = "ProcessCache";
  public static String processNameCache = "";
  
  public static String getProcessNameByPidFromCache(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(244145);
    Log.i("ProcessCache", "getProcessNameByPidFromCache");
    if (!processNameCache.isEmpty())
    {
      paramContext = processNameCache;
      AppMethodBeat.o(244145);
      return paramContext;
    }
    paramContext = Util.getProcessNameByPidOriginal(paramContext, paramInt);
    AppMethodBeat.o(244145);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ProcessCache
 * JD-Core Version:    0.7.0.1
 */