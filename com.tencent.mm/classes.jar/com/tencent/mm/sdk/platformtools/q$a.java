package com.tencent.mm.sdk.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

final class q$a
  implements q.b
{
  Field GqT;
  
  q$a()
  {
    AppMethodBeat.i(157546);
    this.GqT = null;
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        if (this.GqT == null)
        {
          Field localField = ActivityManager.RunningAppProcessInfo.class.getDeclaredField("processState");
          localField.setAccessible(true);
          this.GqT = localField;
        }
        AppMethodBeat.o(157546);
        return;
      }
      catch (Throwable localThrowable)
      {
        ac.printErrStackTrace("MicroMsg.GreenManUtil", localThrowable, "", new Object[0]);
      }
    }
    AppMethodBeat.o(157546);
  }
  
  public final boolean iu(Context paramContext)
  {
    AppMethodBeat.i(157547);
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null)
    {
      AppMethodBeat.o(157547);
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.processName.startsWith("com.tencent.mm"))
      {
        if ((Build.VERSION.SDK_INT >= 21) && (this.GqT != null)) {}
        for (;;)
        {
          try
          {
            i = this.GqT.getInt(localRunningAppProcessInfo);
            ac.i("MicroMsg.GreenManUtil", "isAppForeground processState %s", new Object[] { Integer.valueOf(i) });
            if (i <= 2)
            {
              AppMethodBeat.o(157547);
              return true;
            }
            i = 0;
            if ((i == 0) || (localRunningAppProcessInfo.importance != 100)) {
              break;
            }
            AppMethodBeat.o(157547);
            return true;
          }
          catch (Throwable localThrowable)
          {
            ac.printErrStackTrace("MicroMsg.GreenManUtil", localThrowable, "", new Object[0]);
          }
          int i = 1;
        }
      }
    }
    AppMethodBeat.o(157547);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.q.a
 * JD-Core Version:    0.7.0.1
 */