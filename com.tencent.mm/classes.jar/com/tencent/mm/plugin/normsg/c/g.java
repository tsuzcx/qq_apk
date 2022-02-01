package com.tencent.mm.plugin.normsg.c;

import android.app.ActivityManager;
import android.app.ActivityManager.RecentTaskInfo;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.lang.reflect.Field;
import java.util.List;

public final class g
{
  public static boolean vpM;
  
  static
  {
    AppMethodBeat.i(149094);
    vpM = false;
    long l = System.nanoTime();
    try
    {
      vpM = false;
      if (Build.VERSION.SDK_INT < 21) {}
      for (vpM = false;; vpM = false)
      {
        return;
        Field localField = ActivityManager.RecentTaskInfo.class.getDeclaredField("instanceId");
        localField.setAccessible(true);
        localList = ((ActivityManager)ai.getContext().getApplicationContext().getSystemService("activity")).getRecentTasks(1, 2);
        if ((localList != null) && (localList.size() != 0)) {
          break;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        List localList;
        vpM = false;
        return;
        if (localThrowable.getInt((ActivityManager.RecentTaskInfo)localList.get(0)) > 0) {
          vpM = true;
        }
      }
    }
    finally
    {
      ac.i("MicroMsg.NormalMsgSource.QSDTH", "QSDT, result: %b, time: %d ns", new Object[] { Boolean.valueOf(vpM), Long.valueOf(System.nanoTime() - l) });
      AppMethodBeat.o(149094);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.g
 * JD-Core Version:    0.7.0.1
 */