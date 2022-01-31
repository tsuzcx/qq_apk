package com.tencent.util;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.b;
import java.util.HashMap;

public final class i
{
  public static boolean Bzn;
  private static HashMap<String, Long> Bzo;
  private static h Bzp;
  
  static
  {
    AppMethodBeat.i(86621);
    Bzn = false;
    Bzo = new HashMap();
    Bzp = null;
    AppMethodBeat.o(86621);
  }
  
  public static int a(Object paramObject, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(86620);
    if (b.ENABLE_DEBUG)
    {
      paramObject = cZ(paramObject);
      if (Bzp != null)
      {
        AppMethodBeat.o(86620);
        return 0;
      }
      if (b.ENABLE_DEBUG)
      {
        int i = Log.e(paramObject, paramString, paramThrowable);
        AppMethodBeat.o(86620);
        return i;
      }
    }
    AppMethodBeat.o(86620);
    return 0;
  }
  
  private static String cZ(Object paramObject)
  {
    AppMethodBeat.i(86615);
    if (paramObject == null)
    {
      AppMethodBeat.o(86615);
      return "filter process";
    }
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      AppMethodBeat.o(86615);
      return paramObject;
    }
    paramObject = paramObject.getClass().getSimpleName();
    AppMethodBeat.o(86615);
    return paramObject;
  }
  
  public static int k(Object paramObject, String paramString)
  {
    AppMethodBeat.i(86616);
    if (b.ENABLE_DEBUG)
    {
      paramObject = cZ(paramObject);
      if (Bzp != null)
      {
        AppMethodBeat.o(86616);
        return 0;
      }
      if (b.ENABLE_DEBUG)
      {
        int i = Log.i(paramObject, paramString);
        AppMethodBeat.o(86616);
        return i;
      }
    }
    AppMethodBeat.o(86616);
    return 0;
  }
  
  public static int l(Object paramObject, String paramString)
  {
    AppMethodBeat.i(86617);
    if (b.ENABLE_DEBUG)
    {
      paramObject = cZ(paramObject);
      if (Bzp != null)
      {
        AppMethodBeat.o(86617);
        return 0;
      }
      if (b.ENABLE_DEBUG)
      {
        int i = Log.d(paramObject, paramString);
        AppMethodBeat.o(86617);
        return i;
      }
    }
    AppMethodBeat.o(86617);
    return 0;
  }
  
  public static int m(Object paramObject, String paramString)
  {
    AppMethodBeat.i(86618);
    if (b.BzN)
    {
      paramObject = cZ(paramObject);
      if (Bzp != null)
      {
        AppMethodBeat.o(86618);
        return 0;
      }
      if (b.ENABLE_DEBUG)
      {
        int i = Log.d(paramObject, paramString);
        AppMethodBeat.o(86618);
        return i;
      }
    }
    AppMethodBeat.o(86618);
    return 0;
  }
  
  public static int n(Object paramObject, String paramString)
  {
    AppMethodBeat.i(86619);
    if (b.ENABLE_DEBUG)
    {
      paramObject = cZ(paramObject);
      if (Bzp != null)
      {
        AppMethodBeat.o(86619);
        return 0;
      }
      if (b.ENABLE_DEBUG)
      {
        int i = Log.e(paramObject, paramString);
        AppMethodBeat.o(86619);
        return i;
      }
    }
    AppMethodBeat.o(86619);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.util.i
 * JD-Core Version:    0.7.0.1
 */