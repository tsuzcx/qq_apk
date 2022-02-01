package com.tencent.xweb.xwalk.updater;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.ao;
import com.tencent.xweb.util.b;
import com.tencent.xweb.xwalk.b.a;
import com.tencent.xweb.xwalk.o;
import com.tencent.xweb.y.b;
import java.io.File;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkGrayValueUtil;

public final class j
  implements i, y.b
{
  private static boolean aJV(int paramInt)
  {
    AppMethodBeat.i(213020);
    File localFile = f.aJT(paramInt);
    if (localFile == null)
    {
      Log.e("XWalkRuntimeUpdater", "checkApkExist, no config file");
      AppMethodBeat.o(213020);
      return false;
    }
    boolean bool = a.a(paramInt, localFile);
    AppMethodBeat.o(213020);
    return bool;
  }
  
  public static int bK(Context paramContext, int paramInt)
  {
    int n = 1;
    AppMethodBeat.i(213014);
    if ((paramContext == null) || (paramContext.getApplicationInfo() == null) || (paramContext.getApplicationInfo().dataDir == null))
    {
      Log.i("XWalkRuntimeUpdater", "revertToApkVer failed, invalid context");
      AppMethodBeat.o(213014);
      return -1;
    }
    paramContext = new File(paramContext.getApplicationInfo().dataDir).listFiles();
    if (paramContext == null)
    {
      Log.i("XWalkRuntimeUpdater", "revertToApkVer failed, files is null");
      AppMethodBeat.o(213014);
      return -1;
    }
    int i2 = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
    int i3 = paramContext.length;
    int m = 0;
    int i = -1;
    int j = 0;
    int k;
    if (m < i3)
    {
      int i1 = f.al(paramContext[m]);
      k = j;
      if (i1 < 0) {
        break label388;
      }
      if (i1 == paramInt) {
        j = 1;
      }
      k = j;
      if (i1 > paramInt) {
        break label388;
      }
      k = j;
      if (i1 < 2000) {
        break label388;
      }
      k = j;
      if (i1 == i2) {
        break label388;
      }
      k = j;
      if (i1 <= i) {
        break label388;
      }
      i = i1;
    }
    for (;;)
    {
      m += 1;
      break;
      if (i > 0) {}
      for (k = n;; k = 0)
      {
        if (j != 0) {
          if (aJV(paramInt))
          {
            Log.i("XWalkRuntimeUpdater", "revertToApkVer checkApkExist targetApk exist");
            i = paramInt;
          }
        }
        label379:
        for (;;)
        {
          if (i == paramInt) {
            com.tencent.xweb.util.l.Br(89L);
          }
          for (;;)
          {
            Log.i("XWalkRuntimeUpdater", "revert from:" + XWalkEnvironment.getInstalledNewstVersionForCurAbi() + " to:" + i);
            XWalkEnvironment.setCoreVersionInfo(i, "revert from:" + XWalkEnvironment.getInstalledNewstVersionForCurAbi() + " to:" + i, b.khw());
            AppMethodBeat.o(213014);
            return i;
            if (aJV(i)) {
              break label379;
            }
            Log.i("XWalkRuntimeUpdater", "revertToApkVer nAvailableOldVer targetApk not exist");
            i = -1;
            break;
            Log.i("XWalkRuntimeUpdater", "revertToApkVer did not find target version:".concat(String.valueOf(paramInt)));
            if (aJV(i)) {
              break label379;
            }
            Log.i("XWalkRuntimeUpdater", "revertToApkVer nAvailableOldVer targetApk not exist");
            i = -1;
            break;
            if (i > 0) {
              com.tencent.xweb.util.l.Br(90L);
            } else if (k != 0) {
              com.tencent.xweb.util.l.Br(92L);
            } else {
              com.tencent.xweb.util.l.Br(91L);
            }
          }
        }
      }
      label388:
      j = k;
    }
  }
  
  public static void jM(String paramString, int paramInt)
  {
    AppMethodBeat.i(213003);
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.xweb.update");
    localIntent.putExtra("stage", paramString);
    localIntent.putExtra("extra_data", paramInt);
    XWalkEnvironment.getApplicationContext().sendBroadcast(localIntent);
    AppMethodBeat.o(213003);
  }
  
  private static void pi(Context paramContext)
  {
    AppMethodBeat.i(212996);
    new o(paramContext, null);
    o.kjl();
    AppMethodBeat.o(212996);
  }
  
  public final void a(int paramInt, c paramc)
  {
    AppMethodBeat.i(213052);
    Log.i("XWalkRuntimeUpdater", "onXWalkUpdateFailed, errorCode:".concat(String.valueOf(paramInt)));
    jM("finished", -1);
    l.kko();
    if (paramc != null) {
      paramc.aJR(paramInt);
    }
    paramc = ao.kgu();
    if (paramc != null) {
      paramc.cLJ();
    }
    AppMethodBeat.o(213052);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(213038);
    Log.i("XWalkRuntimeUpdater", "onXWalkUpdateStarted");
    if (n.kkq().kjo().equalsIgnoreCase(paramc.kjo())) {}
    for (int i = 0;; i = 1)
    {
      jM("start", i);
      l.kkn();
      ao.kgu();
      if (!XWalkGrayValueUtil.hasUin()) {
        com.tencent.xweb.util.l.y(1749L, 20L, 1L);
      }
      AppMethodBeat.o(213038);
      return;
    }
  }
  
  public final void aJU(int paramInt)
  {
    AppMethodBeat.i(213044);
    Log.d("XWalkRuntimeUpdater", "onXWalkUpdateProgress, progress:".concat(String.valueOf(paramInt)));
    jM("updating", paramInt);
    com.tencent.xweb.xwalk.c localc = ao.kgu();
    if (localc != null) {
      localc.Dn(paramInt);
    }
    AppMethodBeat.o(213044);
  }
  
  public final void b(Context paramContext, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(213024);
    if (paramContext == null) {}
    try
    {
      Log.w("XWalkRuntimeUpdater", "startCheck, invalid context");
      return;
    }
    finally
    {
      String str;
      AppMethodBeat.o(213024);
    }
    com.tencent.xweb.util.l.khH();
    str = null;
    if (paramHashMap != null) {
      str = (String)paramHashMap.get("UpdaterCheckType");
    }
    Log.i("XWalkRuntimeUpdater", "startCheck, check type:".concat(String.valueOf(str)));
    if ("5".equals(str))
    {
      Log.i("XWalkRuntimeUpdater", "startCheck, check config update only");
      new k(paramContext, this, paramHashMap).execute(new Void[0]);
      AppMethodBeat.o(213024);
      return;
    }
    if ("4".equals(str))
    {
      Log.i("XWalkRuntimeUpdater", "startCheck, check emebed install only");
      pi(paramContext);
      AppMethodBeat.o(213024);
      return;
    }
    pi(paramContext);
    new k(paramContext, this, paramHashMap).execute(new Void[0]);
    f.pe(paramContext);
    AppMethodBeat.o(213024);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(213056);
    Log.i("XWalkRuntimeUpdater", "onXWalkUpdateCompleted");
    jM("finished", 0);
    l.kko();
    if (paramc != null) {
      paramc.e(null);
    }
    paramc = ao.kgu();
    if (paramc != null) {
      paramc.cLK();
    }
    if (!XWalkGrayValueUtil.hasUin()) {
      com.tencent.xweb.util.l.y(1749L, 21L, 1L);
    }
    AppMethodBeat.o(213056);
  }
  
  public final boolean isBusy()
  {
    AppMethodBeat.i(213028);
    if ((Math.abs(System.currentTimeMillis() - l.kkl()) < 10000L) || (l.kkm()) || (f.isBusy()))
    {
      AppMethodBeat.o(213028);
      return true;
    }
    AppMethodBeat.o(213028);
    return false;
  }
  
  public final boolean kfC()
  {
    AppMethodBeat.i(213034);
    boolean bool = k.Ph(false);
    AppMethodBeat.o(213034);
    return bool;
  }
  
  public final void kkk()
  {
    AppMethodBeat.i(213050);
    Log.i("XWalkRuntimeUpdater", "onXWalkUpdateCancelled");
    jM("finished", -2);
    l.kko();
    com.tencent.xweb.xwalk.c localc = ao.kgu();
    if (localc != null) {
      localc.cLJ();
    }
    AppMethodBeat.o(213050);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.j
 * JD-Core Version:    0.7.0.1
 */