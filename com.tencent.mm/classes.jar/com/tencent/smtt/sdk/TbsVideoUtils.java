package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TbsVideoUtils
{
  private static s a = null;
  
  private static void a(Context paramContext)
  {
    Object localObject = null;
    AppMethodBeat.i(54987);
    try
    {
      if (a == null)
      {
        e.a(true).a(paramContext, false, false, null);
        TbsWizard localTbsWizard = e.a(true).a();
        paramContext = localObject;
        if (localTbsWizard != null) {
          paramContext = localTbsWizard.dexLoader();
        }
        if (paramContext != null) {
          a = new s(paramContext);
        }
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(54987);
    }
  }
  
  public static void deleteVideoCache(Context paramContext, String paramString)
  {
    AppMethodBeat.i(54988);
    a(paramContext);
    if (a != null) {
      a.a(paramContext, paramString);
    }
    AppMethodBeat.o(54988);
  }
  
  public static String getCurWDPDecodeType(Context paramContext)
  {
    AppMethodBeat.i(54989);
    a(paramContext);
    if (a != null)
    {
      paramContext = a.a(paramContext);
      AppMethodBeat.o(54989);
      return paramContext;
    }
    AppMethodBeat.o(54989);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsVideoUtils
 * JD-Core Version:    0.7.0.1
 */