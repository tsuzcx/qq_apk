package com.tencent.xweb.xwalk.updater;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.XWebCoreContentProvider;
import com.tencent.xweb.ah;
import com.tencent.xweb.xwalk.p;
import java.util.HashMap;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.ErrorInfo;

public final class f
  extends AsyncTask<String, Integer, Integer>
{
  static XWalkUpdater Mxy;
  private static String Mzh = "0";
  private HashMap<String, String> Mzg;
  
  public f(XWalkUpdater paramXWalkUpdater, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(154573);
    Mxy = paramXWalkUpdater;
    this.Mzg = paramHashMap;
    if (paramHashMap != null)
    {
      paramXWalkUpdater = (String)paramHashMap.get("UpdaterCheckType");
      Mzh = paramXWalkUpdater;
      if ((paramXWalkUpdater == null) || (!Mzh.equals("1"))) {
        break label84;
      }
      c.gdu().gdC();
    }
    for (;;)
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkUpdateChecker notify received !! mNotifyType = " + Mzh);
      AppMethodBeat.o(154573);
      return;
      label84:
      if ((Mzh != null) && (Mzh.equals("2")))
      {
        c.gdu().gdC();
        com.tencent.xweb.util.g.Fh(93L);
      }
      else if ((Mzh != null) && (Mzh.equals("3")))
      {
        c.gdu().gdH().Myt = true;
        com.tencent.xweb.util.g.Fh(94L);
      }
      else
      {
        Mzh = "0";
      }
    }
  }
  
  public static void aiR(int paramInt)
  {
    AppMethodBeat.i(186029);
    gdR();
    c.gdu().aiR(paramInt);
    AppMethodBeat.o(186029);
  }
  
  private static boolean f(SchedulerConfig paramSchedulerConfig)
  {
    AppMethodBeat.i(195603);
    if (gdP())
    {
      AppMethodBeat.o(195603);
      return false;
    }
    XWalkUpdater.ErrorInfo localErrorInfo;
    if (!XWalkEnvironment.isSelfProvider())
    {
      gdQ();
      localErrorInfo = Mxy.updateRuntimeFromProvider(paramSchedulerConfig);
      try
      {
        Object localObject = XWalkEnvironment.getPackageName();
        String str = localErrorInfo.errorCode + "," + (String)localObject + "," + localErrorInfo.targetVer + "," + localErrorInfo.readFileListFailedCount + "," + localErrorInfo.noMatchedVersionCount + "," + localErrorInfo.copyFailedCount + "," + localErrorInfo.md5FailedCount + "," + localErrorInfo.extractFailedCount + "," + localErrorInfo.setVersionFailedCount + "," + localErrorInfo.extractRetryFailedCount;
        ContentResolver localContentResolver = XWalkEnvironment.getContentResolver();
        if (localContentResolver != null)
        {
          localObject = XWebCoreContentProvider.d("com.tencent.mm", (String)localObject, 3, 0, "");
          ContentValues localContentValues = new ContentValues();
          localContentValues.put("15626", str);
          localContentResolver.insert((Uri)localObject, localContentValues);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          XWalkInitializer.addXWalkInitializeLog("_doStartUpdate report error");
        }
        if (localErrorInfo.errorCode != -10) {
          break label261;
        }
        aiR(localErrorInfo.errorCode);
        AppMethodBeat.o(195603);
        return false;
        gdR();
      }
      if (localErrorInfo.errorCode == 0)
      {
        gdS();
        AppMethodBeat.o(195603);
        return true;
      }
    }
    label261:
    XWalkInitializer.addXWalkInitializeLog("_doStartUpdate go on");
    if (!NetworkUtil.isNetworkAvailable())
    {
      paramSchedulerConfig = ah.gbk();
      if (paramSchedulerConfig != null) {
        paramSchedulerConfig.bzK();
      }
      AppMethodBeat.o(195603);
      return false;
    }
    if ((!paramSchedulerConfig.Myt) && (!NetworkUtil.isWifiAvailable()))
    {
      XWalkInitializer.addXWalkInitializeLog("current network is not wifi , this scheduler not support mobile data");
      paramSchedulerConfig = ah.gbk();
      if (paramSchedulerConfig != null) {
        paramSchedulerConfig.bzK();
      }
      AppMethodBeat.o(195603);
      return false;
    }
    if (gdQ())
    {
      if (Mxy.updateXWalkRuntime(h.g(paramSchedulerConfig)))
      {
        AppMethodBeat.o(195603);
        return true;
      }
      XWalkInitializer.addXWalkInitializeLog("start update failed");
      gdR();
    }
    AppMethodBeat.o(195603);
    return false;
  }
  
  public static boolean gdP()
  {
    try
    {
      AppMethodBeat.i(154575);
      boolean bool = g.gdP();
      AppMethodBeat.o(154575);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean gdQ()
  {
    try
    {
      AppMethodBeat.i(195604);
      boolean bool = g.gdQ();
      AppMethodBeat.o(195604);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void gdR()
  {
    try
    {
      AppMethodBeat.i(154577);
      g.gdR();
      AppMethodBeat.o(154577);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void gdS()
  {
    AppMethodBeat.i(154578);
    XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
    gdR();
    c.gdu().e(null);
    AppMethodBeat.o(154578);
  }
  
  static void gdT()
  {
    AppMethodBeat.i(195606);
    if (zU(true))
    {
      XWalkEnvironment.addXWalkInitializeLog("try update after config ");
      if (gdP())
      {
        AppMethodBeat.o(195606);
        return;
      }
      com.tencent.xweb.util.g.aE(903L, 160L);
      com.tencent.xweb.xwalk.c localc = ah.gbk();
      if (localc != null) {
        localc.bzJ();
      }
      f(c.gdu().gdH());
      AppMethodBeat.o(195606);
      return;
    }
    p.hl("finished", -5);
    AppMethodBeat.o(195606);
  }
  
  private static boolean zU(boolean paramBoolean)
  {
    AppMethodBeat.i(195605);
    if (c.gdu().zS(paramBoolean))
    {
      XWalkInitializer.addXWalkInitializeLog("time to update");
      AppMethodBeat.o(195605);
      return true;
    }
    AppMethodBeat.o(195605);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.f
 * JD-Core Version:    0.7.0.1
 */