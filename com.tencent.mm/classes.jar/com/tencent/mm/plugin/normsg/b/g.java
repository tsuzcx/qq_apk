package com.tencent.mm.plugin.normsg.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RecentTaskInfo;
import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.util.List;

public final class g
{
  public static boolean mIf = false;
  
  static
  {
    long l = System.nanoTime();
    try
    {
      mIf = false;
      if (Build.VERSION.SDK_INT < 21) {}
      for (mIf = false;; mIf = false)
      {
        return;
        Field localField = ActivityManager.RecentTaskInfo.class.getDeclaredField("instanceId");
        localField.setAccessible(true);
        localList = ((ActivityManager)ae.getContext().getApplicationContext().getSystemService("activity")).getRecentTasks(1, 2);
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
        mIf = false;
        return;
        if (localThrowable.getInt((ActivityManager.RecentTaskInfo)localList.get(0)) > 0) {
          mIf = true;
        }
      }
    }
    finally
    {
      y.i("MicroMsg.NormalMsgSource.QSDTH", "QSDT, result: %b, time: %d ns", new Object[] { Boolean.valueOf(mIf), Long.valueOf(System.nanoTime() - l) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.b.g
 * JD-Core Version:    0.7.0.1
 */