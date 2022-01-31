package com.tencent.xweb.xwalk.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.XWebCoreContentProvider;
import com.tencent.xweb.ab;
import com.tencent.xweb.xwalk.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.ErrorInfo;

public final class f
  extends AsyncTask<String, Integer, Integer>
{
  static XWalkUpdater BKl;
  private static String BLl = "0";
  private HashMap<String, String> BLk;
  
  public f(XWalkUpdater paramXWalkUpdater, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(85481);
    BKl = paramXWalkUpdater;
    this.BLk = paramHashMap;
    if (paramHashMap != null)
    {
      paramXWalkUpdater = (String)paramHashMap.get("UpdaterCheckType");
      BLl = paramXWalkUpdater;
      if ((paramXWalkUpdater == null) || (!BLl.equals("1"))) {
        break label84;
      }
      c.eav().eaz();
    }
    for (;;)
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkUpdateChecker notify received !! mNotifyType = " + BLl);
      AppMethodBeat.o(85481);
      return;
      label84:
      if ((BLl != null) && (BLl.equals("2")))
      {
        c.eav().eaz();
        com.tencent.xweb.util.f.pf(93L);
      }
      else if ((BLl != null) && (BLl.equals("3")))
      {
        c.eaD().BKP = true;
        com.tencent.xweb.util.f.pf(94L);
      }
      else
      {
        BLl = "0";
      }
    }
  }
  
  public static void TN(int paramInt)
  {
    AppMethodBeat.i(156744);
    eaH();
    c.TN(paramInt);
    AppMethodBeat.o(156744);
  }
  
  private static boolean b(c.a parama)
  {
    AppMethodBeat.i(85482);
    if (eaF())
    {
      AppMethodBeat.o(85482);
      return false;
    }
    XWalkUpdater.ErrorInfo localErrorInfo;
    if (!XWalkEnvironment.isSelfProvider())
    {
      eaG();
      localErrorInfo = BKl.updateRuntimeFromProvider(parama);
      try
      {
        Object localObject = XWalkEnvironment.getPackageName();
        String str = localErrorInfo.errorCode + "," + (String)localObject + "," + localErrorInfo.targetVer + "," + localErrorInfo.readFileListFailedCount + "," + localErrorInfo.noMatchedVersionCount + "," + localErrorInfo.copyFailedCount + "," + localErrorInfo.md5FailedCount + "," + localErrorInfo.extractFailedCount + "," + localErrorInfo.setVersionFailedCount + "," + localErrorInfo.extractRetryFailedCount;
        ContentResolver localContentResolver = XWalkEnvironment.getContentResolver();
        if (localContentResolver != null)
        {
          localObject = XWebCoreContentProvider.b("com.tencent.mm", (String)localObject, 3, 0, "");
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
          break label268;
        }
        int i = localErrorInfo.errorCode;
        eaH();
        c.TN(i);
        AppMethodBeat.o(85482);
        return false;
        eaH();
      }
      if (localErrorInfo.errorCode == 0)
      {
        eaI();
        AppMethodBeat.o(85482);
        return true;
      }
    }
    label268:
    XWalkInitializer.addXWalkInitializeLog("_doStartUpdate go on");
    if (!NetworkUtil.isNetworkAvailable())
    {
      parama = ab.dYE();
      if (parama != null) {
        parama.aMx();
      }
      AppMethodBeat.o(85482);
      return false;
    }
    if ((!parama.BKP) && (!NetworkUtil.isWifiAvailable()))
    {
      XWalkInitializer.addXWalkInitializeLog("current network is not wifi , this scheduler not support mobile data");
      parama = ab.dYE();
      if (parama != null) {
        parama.aMx();
      }
      AppMethodBeat.o(85482);
      return false;
    }
    if (BKl.updateXWalkRuntime(parama.eaE()))
    {
      eaG();
      AppMethodBeat.o(85482);
      return true;
    }
    AppMethodBeat.o(85482);
    return false;
  }
  
  static void c(c.a parama)
  {
    AppMethodBeat.i(85488);
    if (parama != null)
    {
      if (!XWalkEnvironment.hasAvailableVersion())
      {
        XWalkInitializer.addXWalkInitializeLog("no availableversion installed, do start download ");
        b(parama);
      }
      for (;;)
      {
        parama = ab.dYE();
        if (parama != null) {
          parama.aMw();
        }
        AppMethodBeat.o(85488);
        return;
        if (parama.BLd <= System.currentTimeMillis()) {
          b(parama);
        }
      }
    }
    AppMethodBeat.o(85488);
  }
  
  public static boolean eaF()
  {
    AppMethodBeat.i(85483);
    int i = XWalkEnvironment.getSharedPreferencesForUpdateConfig().getInt("UpdatingProcessId", -1);
    if (i == Process.myPid())
    {
      XWalkInitializer.addXWalkInitializeLog("current process is in updating progress");
      AppMethodBeat.o(85483);
      return true;
    }
    if (i < 0)
    {
      AppMethodBeat.o(85483);
      return false;
    }
    Object localObject = (ActivityManager)XWalkEnvironment.getApplicationContext().getSystemService("activity");
    Process.myPid();
    int j = Process.myUid();
    localObject = ((ActivityManager)localObject).getRunningAppProcesses().iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if (localRunningAppProcessInfo.pid == i) {
        if (localRunningAppProcessInfo.uid == j)
        {
          XWalkInitializer.addXWalkInitializeLog("some process is in updating progress");
          AppMethodBeat.o(85483);
          return true;
        }
      }
    }
    eaH();
    AppMethodBeat.o(85483);
    return false;
  }
  
  public static void eaG()
  {
    AppMethodBeat.i(85484);
    int i = Process.myPid();
    SharedPreferences.Editor localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
    localEditor.putInt("UpdatingProcessId", i);
    localEditor.commit();
    XWalkInitializer.addXWalkInitializeLog("start updating progress");
    AppMethodBeat.o(85484);
  }
  
  public static void eaH()
  {
    AppMethodBeat.i(85485);
    Process.myPid();
    SharedPreferences.Editor localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
    localEditor.remove("UpdatingProcessId");
    localEditor.commit();
    XWalkInitializer.addXWalkInitializeLog("finish updating progress");
    AppMethodBeat.o(85485);
  }
  
  public static void eaI()
  {
    AppMethodBeat.i(85486);
    XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
    eaH();
    c.a(null);
    AppMethodBeat.o(85486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.b.f
 * JD-Core Version:    0.7.0.1
 */