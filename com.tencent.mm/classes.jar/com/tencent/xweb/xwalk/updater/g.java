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

public final class g
  extends AsyncTask<String, Integer, Integer>
{
  static XWalkUpdater SHJ;
  private static String SJr = "0";
  private HashMap<String, String> SJq;
  
  public g(XWalkUpdater paramXWalkUpdater, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(154573);
    SHJ = paramXWalkUpdater;
    this.SJq = paramHashMap;
    if (paramHashMap != null)
    {
      paramXWalkUpdater = (String)paramHashMap.get("UpdaterCheckType");
      SJr = paramXWalkUpdater;
      if ((paramXWalkUpdater == null) || (!SJr.equals("1"))) {
        break label81;
      }
      Scheduler.hvE();
    }
    for (;;)
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkUpdateChecker notify received !! mNotifyType = " + SJr);
      AppMethodBeat.o(154573);
      return;
      label81:
      if ((SJr != null) && (SJr.equals("2")))
      {
        Scheduler.hvE();
        com.tencent.xweb.util.h.OQ(93L);
      }
      else if ((SJr != null) && (SJr.equals("3")))
      {
        XWebCoreScheduler.hvW().hvJ().SIE = true;
        com.tencent.xweb.util.h.OQ(94L);
      }
      else
      {
        SJr = "0";
      }
    }
  }
  
  public static void a(int paramInt, Scheduler paramScheduler)
  {
    AppMethodBeat.i(207367);
    hvT();
    if (paramScheduler != null) {
      paramScheduler.atj(paramInt);
    }
    AppMethodBeat.o(207367);
  }
  
  public static void a(Scheduler paramScheduler)
  {
    AppMethodBeat.i(207366);
    XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
    hvT();
    if (paramScheduler != null) {
      paramScheduler.e(null);
    }
    AppMethodBeat.o(207366);
  }
  
  private static boolean a(XWebCoreScheduler paramXWebCoreScheduler)
  {
    AppMethodBeat.i(207364);
    c localc = paramXWebCoreScheduler.hvJ();
    if (hvR())
    {
      AppMethodBeat.o(207364);
      return false;
    }
    XWalkUpdater.ErrorInfo localErrorInfo;
    if (!XWalkEnvironment.isSelfProvider())
    {
      hvS();
      localErrorInfo = SHJ.updateRuntimeFromProvider(paramXWebCoreScheduler);
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
          break label277;
        }
        a(localErrorInfo.errorCode, paramXWebCoreScheduler);
        AppMethodBeat.o(207364);
        return false;
        hvT();
      }
      if (localErrorInfo.errorCode == 0)
      {
        p.hQ("finished", 0);
        a(paramXWebCoreScheduler);
        AppMethodBeat.o(207364);
        return true;
      }
    }
    label277:
    XWalkInitializer.addXWalkInitializeLog("_doStartUpdate go on");
    if (!NetworkUtil.isNetworkAvailable())
    {
      paramXWebCoreScheduler = ah.hte();
      if (paramXWebCoreScheduler != null) {
        paramXWebCoreScheduler.bXK();
      }
      AppMethodBeat.o(207364);
      return false;
    }
    if ((!localc.SIE) && (!NetworkUtil.isWifiAvailable()))
    {
      XWalkInitializer.addXWalkInitializeLog("current network is not wifi , this scheduler not support mobile data");
      paramXWebCoreScheduler = ah.hte();
      if (paramXWebCoreScheduler != null) {
        paramXWebCoreScheduler.bXK();
      }
      AppMethodBeat.o(207364);
      return false;
    }
    if (hvS())
    {
      if (SHJ.updateXWalkRuntime(paramXWebCoreScheduler.f(localc)))
      {
        AppMethodBeat.o(207364);
        return true;
      }
      XWalkInitializer.addXWalkInitializeLog("start update failed");
      hvT();
    }
    AppMethodBeat.o(207364);
    return false;
  }
  
  private static void b(XWebCoreScheduler paramXWebCoreScheduler)
  {
    AppMethodBeat.i(207369);
    XWalkEnvironment.addXWalkInitializeLog("try update after config " + paramXWebCoreScheduler.toString());
    if (hvR())
    {
      AppMethodBeat.o(207369);
      return;
    }
    com.tencent.xweb.util.h.aJ(903L, 160L);
    com.tencent.xweb.xwalk.c localc = ah.hte();
    if (localc != null) {
      localc.bXJ();
    }
    a(paramXWebCoreScheduler);
    AppMethodBeat.o(207369);
  }
  
  public static boolean hvR()
  {
    try
    {
      AppMethodBeat.i(154575);
      boolean bool = h.hvR();
      AppMethodBeat.o(154575);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean hvS()
  {
    try
    {
      AppMethodBeat.i(207365);
      boolean bool = h.hvS();
      AppMethodBeat.o(207365);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void hvT()
  {
    try
    {
      AppMethodBeat.i(154577);
      h.hvT();
      AppMethodBeat.o(154577);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static void hvU()
  {
    AppMethodBeat.i(207368);
    if (XWebCoreScheduler.hvW().Ew(true))
    {
      b(XWebCoreScheduler.hvW());
      AppMethodBeat.o(207368);
      return;
    }
    if (i.hvV().Ew(true))
    {
      b(i.hvV());
      AppMethodBeat.o(207368);
      return;
    }
    p.hQ("finished", -5);
    AppMethodBeat.o(207368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.g
 * JD-Core Version:    0.7.0.1
 */