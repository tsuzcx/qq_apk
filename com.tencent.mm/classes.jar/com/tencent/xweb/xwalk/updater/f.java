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
  static XWalkUpdater MUC;
  private static String MWm = "0";
  private HashMap<String, String> MWl;
  
  public f(XWalkUpdater paramXWalkUpdater, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(154573);
    MUC = paramXWalkUpdater;
    this.MWl = paramHashMap;
    if (paramHashMap != null)
    {
      paramXWalkUpdater = (String)paramHashMap.get("UpdaterCheckType");
      MWm = paramXWalkUpdater;
      if ((paramXWalkUpdater == null) || (!MWm.equals("1"))) {
        break label81;
      }
      Scheduler.gie();
    }
    for (;;)
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkUpdateChecker notify received !! mNotifyType = " + MWm);
      AppMethodBeat.o(154573);
      return;
      label81:
      if ((MWm != null) && (MWm.equals("2")))
      {
        Scheduler.gie();
        com.tencent.xweb.util.g.FJ(93L);
      }
      else if ((MWm != null) && (MWm.equals("3")))
      {
        XWebCoreScheduler.giw().gij().MVx = true;
        com.tencent.xweb.util.g.FJ(94L);
      }
      else
      {
        MWm = "0";
      }
    }
  }
  
  public static void a(int paramInt, Scheduler paramScheduler)
  {
    AppMethodBeat.i(207629);
    git();
    if (paramScheduler != null) {
      paramScheduler.ajB(paramInt);
    }
    AppMethodBeat.o(207629);
  }
  
  public static void a(Scheduler paramScheduler)
  {
    AppMethodBeat.i(207628);
    XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
    git();
    if (paramScheduler != null) {
      paramScheduler.e(null);
    }
    AppMethodBeat.o(207628);
  }
  
  private static boolean a(XWebCoreScheduler paramXWebCoreScheduler)
  {
    AppMethodBeat.i(207626);
    c localc = paramXWebCoreScheduler.gij();
    if (gir())
    {
      AppMethodBeat.o(207626);
      return false;
    }
    XWalkUpdater.ErrorInfo localErrorInfo;
    if (!XWalkEnvironment.isSelfProvider())
    {
      gis();
      localErrorInfo = MUC.updateRuntimeFromProvider(paramXWebCoreScheduler);
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
          break label271;
        }
        a(localErrorInfo.errorCode, paramXWebCoreScheduler);
        AppMethodBeat.o(207626);
        return false;
        git();
      }
      if (localErrorInfo.errorCode == 0)
      {
        a(paramXWebCoreScheduler);
        AppMethodBeat.o(207626);
        return true;
      }
    }
    label271:
    XWalkInitializer.addXWalkInitializeLog("_doStartUpdate go on");
    if (!NetworkUtil.isNetworkAvailable())
    {
      paramXWebCoreScheduler = ah.gfM();
      if (paramXWebCoreScheduler != null) {
        paramXWebCoreScheduler.bAF();
      }
      AppMethodBeat.o(207626);
      return false;
    }
    if ((!localc.MVx) && (!NetworkUtil.isWifiAvailable()))
    {
      XWalkInitializer.addXWalkInitializeLog("current network is not wifi , this scheduler not support mobile data");
      paramXWebCoreScheduler = ah.gfM();
      if (paramXWebCoreScheduler != null) {
        paramXWebCoreScheduler.bAF();
      }
      AppMethodBeat.o(207626);
      return false;
    }
    if (gis())
    {
      if (MUC.updateXWalkRuntime(paramXWebCoreScheduler.f(localc)))
      {
        AppMethodBeat.o(207626);
        return true;
      }
      XWalkInitializer.addXWalkInitializeLog("start update failed");
      git();
    }
    AppMethodBeat.o(207626);
    return false;
  }
  
  private static void b(XWebCoreScheduler paramXWebCoreScheduler)
  {
    AppMethodBeat.i(207631);
    XWalkEnvironment.addXWalkInitializeLog("try update after config " + paramXWebCoreScheduler.toString());
    if (gir())
    {
      AppMethodBeat.o(207631);
      return;
    }
    com.tencent.xweb.util.g.aD(903L, 160L);
    com.tencent.xweb.xwalk.c localc = ah.gfM();
    if (localc != null) {
      localc.bAE();
    }
    a(paramXWebCoreScheduler);
    AppMethodBeat.o(207631);
  }
  
  public static boolean gir()
  {
    try
    {
      AppMethodBeat.i(154575);
      boolean bool = g.gir();
      AppMethodBeat.o(154575);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean gis()
  {
    try
    {
      AppMethodBeat.i(207627);
      boolean bool = g.gis();
      AppMethodBeat.o(207627);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void git()
  {
    try
    {
      AppMethodBeat.i(154577);
      g.git();
      AppMethodBeat.o(154577);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static void giu()
  {
    AppMethodBeat.i(207630);
    if (XWebCoreScheduler.giw().Ag(true))
    {
      b(XWebCoreScheduler.giw());
      AppMethodBeat.o(207630);
      return;
    }
    if (h.giv().Ag(true))
    {
      b(h.giv());
      AppMethodBeat.o(207630);
      return;
    }
    p.hu("finished", -5);
    AppMethodBeat.o(207630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.f
 * JD-Core Version:    0.7.0.1
 */