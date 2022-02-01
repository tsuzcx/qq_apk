package com.tencent.mm.plugin.normsg.d;

import android.app.ActivityManager;
import android.app.ActivityManager.RecentTaskInfo;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.reflect.Field;
import java.util.List;

public final class h
{
  public static boolean Gzz;
  
  static
  {
    AppMethodBeat.i(149094);
    Gzz = false;
    long l = System.nanoTime();
    try
    {
      Gzz = false;
      if (Build.VERSION.SDK_INT < 21) {}
      for (Gzz = false;; Gzz = false)
      {
        return;
        Field localField = ActivityManager.RecentTaskInfo.class.getDeclaredField("instanceId");
        localField.setAccessible(true);
        localList = ((ActivityManager)MMApplicationContext.getContext().getApplicationContext().getSystemService("activity")).getRecentTasks(1, 2);
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
        Gzz = false;
        return;
        if (localThrowable.getInt((ActivityManager.RecentTaskInfo)localList.get(0)) > 0) {
          Gzz = true;
        }
      }
    }
    finally
    {
      Log.i("MicroMsg.NormalMsgSource.QSDTH", "QSDT, result: %b, time: %d ns", new Object[] { Boolean.valueOf(Gzz), Long.valueOf(System.nanoTime() - l) });
      AppMethodBeat.o(149094);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.d.h
 * JD-Core Version:    0.7.0.1
 */