package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TbsVideoUtils
{
  private static bj a = null;
  
  private static void a(Context paramContext)
  {
    Object localObject = null;
    AppMethodBeat.i(64628);
    try
    {
      if (a == null)
      {
        o.a(true).a(paramContext, false, false, null);
        bl localbl = o.a(true).a();
        paramContext = localObject;
        if (localbl != null) {
          paramContext = localbl.b();
        }
        if (paramContext != null) {
          a = new bj(paramContext);
        }
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(64628);
    }
  }
  
  public static void deleteVideoCache(Context paramContext, String paramString)
  {
    AppMethodBeat.i(64629);
    a(paramContext);
    if (a != null) {
      a.a(paramContext, paramString);
    }
    AppMethodBeat.o(64629);
  }
  
  public static String getCurWDPDecodeType(Context paramContext)
  {
    AppMethodBeat.i(64630);
    a(paramContext);
    if (a != null)
    {
      paramContext = a.a(paramContext);
      AppMethodBeat.o(64630);
      return paramContext;
    }
    AppMethodBeat.o(64630);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsVideoUtils
 * JD-Core Version:    0.7.0.1
 */