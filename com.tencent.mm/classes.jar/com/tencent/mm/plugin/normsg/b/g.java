package com.tencent.mm.plugin.normsg.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RecentTaskInfo;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.reflect.Field;
import java.util.List;

public final class g
{
  public static boolean pil;
  
  static
  {
    AppMethodBeat.i(10441);
    pil = false;
    long l = System.nanoTime();
    try
    {
      pil = false;
      if (Build.VERSION.SDK_INT < 21) {}
      for (pil = false;; pil = false)
      {
        return;
        Field localField = ActivityManager.RecentTaskInfo.class.getDeclaredField("instanceId");
        localField.setAccessible(true);
        localList = ((ActivityManager)ah.getContext().getApplicationContext().getSystemService("activity")).getRecentTasks(1, 2);
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
        pil = false;
        return;
        if (localThrowable.getInt((ActivityManager.RecentTaskInfo)localList.get(0)) > 0) {
          pil = true;
        }
      }
    }
    finally
    {
      ab.i("MicroMsg.NormalMsgSource.QSDTH", "QSDT, result: %b, time: %d ns", new Object[] { Boolean.valueOf(pil), Long.valueOf(System.nanoTime() - l) });
      AppMethodBeat.o(10441);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.g
 * JD-Core Version:    0.7.0.1
 */