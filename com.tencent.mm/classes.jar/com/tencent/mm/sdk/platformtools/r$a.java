package com.tencent.mm.sdk.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

final class r$a
  implements r.b
{
  Field IcH;
  
  r$a()
  {
    AppMethodBeat.i(157546);
    this.IcH = null;
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        if (this.IcH == null)
        {
          Field localField = ActivityManager.RunningAppProcessInfo.class.getDeclaredField("processState");
          localField.setAccessible(true);
          this.IcH = localField;
        }
        AppMethodBeat.o(157546);
        return;
      }
      catch (Throwable localThrowable)
      {
        ad.printErrStackTrace("MicroMsg.GreenManUtil", localThrowable, "", new Object[0]);
      }
    }
    AppMethodBeat.o(157546);
  }
  
  public final boolean iE(Context paramContext)
  {
    AppMethodBeat.i(157547);
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (localObject == null)
    {
      AppMethodBeat.o(157547);
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if (localRunningAppProcessInfo.processName.startsWith(paramContext.getPackageName()))
      {
        if ((Build.VERSION.SDK_INT >= 21) && (this.IcH != null)) {}
        for (;;)
        {
          try
          {
            i = this.IcH.getInt(localRunningAppProcessInfo);
            ad.i("MicroMsg.GreenManUtil", "isAppForeground processState %s", new Object[] { Integer.valueOf(i) });
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
            ad.printErrStackTrace("MicroMsg.GreenManUtil", localThrowable, "", new Object[0]);
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
 * Qualified Name:     com.tencent.mm.sdk.platformtools.r.a
 * JD-Core Version:    0.7.0.1
 */