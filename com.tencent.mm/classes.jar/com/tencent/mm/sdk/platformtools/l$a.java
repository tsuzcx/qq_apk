package com.tencent.mm.sdk.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build.VERSION;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

final class l$a
  implements l.b
{
  Field uet = null;
  
  l$a()
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      if (this.uet == null)
      {
        Field localField = ActivityManager.RunningAppProcessInfo.class.getDeclaredField("processState");
        localField.setAccessible(true);
        this.uet = localField;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      y.printErrStackTrace("MicroMsg.GreenManUtil", localThrowable, "", new Object[0]);
    }
  }
  
  public final boolean fu(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.processName.startsWith("com.tencent.mm"))
      {
        if ((Build.VERSION.SDK_INT >= 21) && (this.uet != null)) {}
        for (;;)
        {
          try
          {
            i = this.uet.getInt(localRunningAppProcessInfo);
            y.i("MicroMsg.GreenManUtil", "isAppForeground processState %s", new Object[] { Integer.valueOf(i) });
            if (i <= 2) {
              return true;
            }
            i = 0;
            if ((i == 0) || (localRunningAppProcessInfo.importance != 100)) {
              break;
            }
            return true;
          }
          catch (Throwable localThrowable)
          {
            y.printErrStackTrace("MicroMsg.GreenManUtil", localThrowable, "", new Object[0]);
          }
          int i = 1;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.l.a
 * JD-Core Version:    0.7.0.1
 */