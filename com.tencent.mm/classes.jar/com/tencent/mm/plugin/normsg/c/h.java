package com.tencent.mm.plugin.normsg.c;

import android.app.ActivityManager;
import android.app.ActivityManager.RecentTaskInfo;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.reflect.Field;
import java.util.List;

public final class h
{
  public static boolean wKP;
  
  static
  {
    AppMethodBeat.i(149094);
    wKP = false;
    long l = System.nanoTime();
    try
    {
      wKP = false;
      if (Build.VERSION.SDK_INT < 21) {}
      for (wKP = false;; wKP = false)
      {
        return;
        Field localField = ActivityManager.RecentTaskInfo.class.getDeclaredField("instanceId");
        localField.setAccessible(true);
        localList = ((ActivityManager)ak.getContext().getApplicationContext().getSystemService("activity")).getRecentTasks(1, 2);
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
        wKP = false;
        return;
        if (localThrowable.getInt((ActivityManager.RecentTaskInfo)localList.get(0)) > 0) {
          wKP = true;
        }
      }
    }
    finally
    {
      ae.i("MicroMsg.NormalMsgSource.QSDTH", "QSDT, result: %b, time: %d ns", new Object[] { Boolean.valueOf(wKP), Long.valueOf(System.nanoTime() - l) });
      AppMethodBeat.o(149094);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.c.h
 * JD-Core Version:    0.7.0.1
 */