package com.tencent.mm.sdk.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

final class o$a
  implements o.b
{
  Field ymU;
  
  o$a()
  {
    AppMethodBeat.i(51992);
    this.ymU = null;
    if (Build.VERSION.SDK_INT >= 21) {
      try
      {
        if (this.ymU == null)
        {
          Field localField = ActivityManager.RunningAppProcessInfo.class.getDeclaredField("processState");
          localField.setAccessible(true);
          this.ymU = localField;
        }
        AppMethodBeat.o(51992);
        return;
      }
      catch (Throwable localThrowable)
      {
        ab.printErrStackTrace("MicroMsg.GreenManUtil", localThrowable, "", new Object[0]);
      }
    }
    AppMethodBeat.o(51992);
  }
  
  public final boolean gH(Context paramContext)
  {
    AppMethodBeat.i(51993);
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null)
    {
      AppMethodBeat.o(51993);
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.processName.startsWith("com.tencent.mm"))
      {
        if ((Build.VERSION.SDK_INT >= 21) && (this.ymU != null)) {}
        for (;;)
        {
          try
          {
            i = this.ymU.getInt(localRunningAppProcessInfo);
            ab.i("MicroMsg.GreenManUtil", "isAppForeground processState %s", new Object[] { Integer.valueOf(i) });
            if (i <= 2)
            {
              AppMethodBeat.o(51993);
              return true;
            }
            i = 0;
            if ((i == 0) || (localRunningAppProcessInfo.importance != 100)) {
              break;
            }
            AppMethodBeat.o(51993);
            return true;
          }
          catch (Throwable localThrowable)
          {
            ab.printErrStackTrace("MicroMsg.GreenManUtil", localThrowable, "", new Object[0]);
          }
          int i = 1;
        }
      }
    }
    AppMethodBeat.o(51993);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.o.a
 * JD-Core Version:    0.7.0.1
 */