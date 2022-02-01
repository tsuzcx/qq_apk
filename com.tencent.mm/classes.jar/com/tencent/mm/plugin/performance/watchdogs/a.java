package com.tencent.mm.plugin.performance.watchdogs;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class a
  implements Runnable
{
  private static a MMH;
  private static boolean MMI;
  public static int MMJ;
  private final ActivityManager zXp;
  
  static
  {
    AppMethodBeat.i(301036);
    MMH = new a();
    MMI = false;
    MMJ = 0;
    AppMethodBeat.o(301036);
  }
  
  public a()
  {
    AppMethodBeat.i(301015);
    this.zXp = ((ActivityManager)MMApplicationContext.getContext().getSystemService("activity"));
    AppMethodBeat.o(301015);
  }
  
  private static int[] a(d.b[] paramArrayOfb)
  {
    int[] arrayOfInt = new int[paramArrayOfb.length];
    int i = 0;
    while (i < paramArrayOfb.length)
    {
      arrayOfInt[i] = paramArrayOfb[i].pid;
      i += 1;
    }
    return arrayOfInt;
  }
  
  public static boolean gzn()
  {
    return MMI;
  }
  
  public static a gzo()
  {
    return MMH;
  }
  
  public final void run()
  {
    AppMethodBeat.i(301051);
    Object localObject3 = this.zXp.getRunningAppProcesses();
    Object localObject1 = new ArrayList();
    int i = 0;
    if (i < ((List)localObject3).size())
    {
      Object localObject4 = (ActivityManager.RunningAppProcessInfo)((List)localObject3).get(i);
      String str = WeChatBrands.AppInfo.current().getPackageName();
      Log.d("AppbrandMemoryMonitor", "pkg name is [%s]", new Object[] { str });
      if ((Process.myUid() != ((ActivityManager.RunningAppProcessInfo)localObject4).uid) || (TextUtils.isEmpty(((ActivityManager.RunningAppProcessInfo)localObject4).processName)) || (!((ActivityManager.RunningAppProcessInfo)localObject4).processName.startsWith(str))) {
        Log.e("AppbrandMemoryMonitor", "info with uid [%s] & process name [%s] is not current app [%s][%s]", new Object[] { Integer.valueOf(((ActivityManager.RunningAppProcessInfo)((List)localObject3).get(i)).uid), ((ActivityManager.RunningAppProcessInfo)((List)localObject3).get(i)).processName, Integer.valueOf(Process.myUid()), str });
      }
      for (;;)
      {
        i += 1;
        break;
        localObject4 = new d.b();
        ((d.b)localObject4).pid = ((ActivityManager.RunningAppProcessInfo)((List)localObject3).get(i)).pid;
        ((d.b)localObject4).processName = ((ActivityManager.RunningAppProcessInfo)((List)localObject3).get(i)).processName;
        ((List)localObject1).add(localObject4);
        Log.d("AppbrandMemoryMonitor", "pid = %s, process = %s", new Object[] { Integer.valueOf(((d.b)localObject4).pid), ((d.b)localObject4).processName });
      }
    }
    localObject3 = new d.b[((List)localObject1).size()];
    ((List)localObject1).toArray((Object[])localObject3);
    int j;
    try
    {
      localObject1 = this.zXp.getProcessMemoryInfo(a((d.b[])localObject3));
      if (localObject1 == null) {
        break label507;
      }
      Log.d("AppbrandMemoryMonitor", "pidMemInfoArray2 size = %s, memoryInfos size = %s", new Object[] { Integer.valueOf(localObject1.length), Integer.valueOf(localObject3.length) });
      if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (WeChatEnvironment.isCoolassistEnv())) {
        Assert.assertEquals(localObject3.length, localObject1.length);
      }
      i = 0;
      int k;
      for (j = 0; i < Math.min(localObject1.length, localObject3.length); j = k)
      {
        k = j;
        if (localObject1[i] != null)
        {
          Log.d("AppbrandMemoryMonitor", "total pss = %d", new Object[] { Integer.valueOf(localObject1[i].getTotalPss()) });
          localObject3[i].FrK = localObject1[i].getTotalPss();
          k = j + localObject3[i].FrK;
        }
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("AppbrandMemoryMonitor", localException, "", new Object[0]);
        Object localObject2 = null;
      }
    }
    if (j > MMJ) {
      MMI = true;
    }
    for (;;)
    {
      h.ahAA.a(this, 300000L, "AppbrandMemoryMonitor");
      AppMethodBeat.o(301051);
      return;
      MMI = false;
      continue;
      label507:
      Log.e("AppbrandMemoryMonitor", "pidMemInfoArray2 == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.watchdogs.a
 * JD-Core Version:    0.7.0.1
 */