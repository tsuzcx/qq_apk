package com.tencent.mm.plugin.priority.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Calendar;

public final class a
{
  public static String aB(String paramString1, String paramString2, String paramString3)
  {
    int i = 1;
    AppMethodBeat.i(40495);
    Object localObject = new o(paramString1);
    if (!((o)localObject).exists()) {
      ((o)localObject).mkdirs();
    }
    if (Util.isNullOrNil(paramString2))
    {
      localObject = paramString1 + "da_" + Util.nowMilliSecond();
      paramString2 = (String)localObject;
      if (!Util.isNullOrNil(paramString3)) {
        paramString2 = (String)localObject + "." + paramString3;
      }
    }
    for (;;)
    {
      localObject = paramString2;
      try
      {
        if (!aa.z(new o(paramString2).heq().her()).equalsIgnoreCase(aa.z(new o(paramString1).her())))
        {
          localObject = paramString1 + "da_" + Util.nowMilliSecond();
          Log.w("MicroMsg.Priority.PriorityUtil", "maybe DirTraversal attach. %s", new Object[] { localObject });
        }
        AppMethodBeat.o(40495);
        return localObject;
        localObject = paramString2;
        if (!Util.isNullOrNil(paramString3))
        {
          localObject = paramString2;
          if (!paramString2.endsWith(paramString3)) {
            localObject = paramString2 + "." + paramString3;
          }
        }
        String str = paramString1 + (String)localObject;
        paramString2 = str;
        if (!s.YS(str)) {
          continue;
        }
        for (;;)
        {
          paramString2 = str;
          if (i < 20)
          {
            if (!s.YS(paramString1 + i + "_" + (String)localObject)) {
              paramString2 = paramString1 + i + "_" + (String)localObject;
            }
          }
          else
          {
            if (i != 20) {
              break;
            }
            localObject = paramString1 + "da_" + Util.nowMilliSecond();
            paramString2 = (String)localObject;
            if (Util.isNullOrNil(paramString3)) {
              break;
            }
            paramString2 = (String)localObject + "." + paramString3;
            break;
          }
          i += 1;
        }
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Priority.PriorityUtil", paramString2, "", new Object[0]);
          paramString1 = paramString1 + "da_" + Util.nowMilliSecond();
          localObject = paramString1;
          if (!Util.isNullOrNil(paramString3)) {
            localObject = paramString1 + "." + paramString3;
          }
        }
      }
    }
  }
  
  public static long eCQ()
  {
    AppMethodBeat.i(40496);
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    long l = localCalendar.getTimeInMillis();
    AppMethodBeat.o(40496);
    return l;
  }
  
  public static final boolean hL(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.a.a.a
 * JD-Core Version:    0.7.0.1
 */