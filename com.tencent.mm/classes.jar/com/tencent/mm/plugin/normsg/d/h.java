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
  public static boolean MvH;
  
  static
  {
    AppMethodBeat.i(149094);
    MvH = false;
    l = System.nanoTime();
    try
    {
      MvH = false;
      if (Build.VERSION.SDK_INT < 21) {}
      for (MvH = false;; MvH = false)
      {
        Log.i("MicroMsg.NormalMsgSource.QSDTH", "QSDT, result: %b, time: %d ns", new Object[] { Boolean.valueOf(MvH), Long.valueOf(System.nanoTime() - l) });
        AppMethodBeat.o(149094);
        return;
        Field localField = ActivityManager.RecentTaskInfo.class.getDeclaredField("instanceId");
        localField.setAccessible(true);
        localList = ((ActivityManager)MMApplicationContext.getContext().getApplicationContext().getSystemService("activity")).getRecentTasks(1, 2);
        if ((localList != null) && (localList.size() != 0)) {
          break;
        }
      }
    }
    finally
    {
      for (;;)
      {
        try
        {
          MvH = false;
          return;
        }
        finally
        {
          List localList;
          Log.i("MicroMsg.NormalMsgSource.QSDTH", "QSDT, result: %b, time: %d ns", new Object[] { Boolean.valueOf(MvH), Long.valueOf(System.nanoTime() - l) });
          AppMethodBeat.o(149094);
        }
        if (localObject1.getInt((ActivityManager.RecentTaskInfo)localList.get(0)) > 0) {
          MvH = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.d.h
 * JD-Core Version:    0.7.0.1
 */