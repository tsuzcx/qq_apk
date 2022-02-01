package com.tencent.xweb.xwalk.b;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.XWebCoreContentProvider;
import com.tencent.xweb.aj;
import com.tencent.xweb.xwalk.XWalkUpdater;
import com.tencent.xweb.xwalk.XWalkUpdater.UpdateConfig;
import com.tencent.xweb.xwalk.XWalkUpdater.a;
import com.tencent.xweb.xwalk.XWalkUpdater.b;
import com.tencent.xweb.xwalk.p;
import java.util.HashMap;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkLibraryLoader;

public final class h
  extends AsyncTask<String, Integer, Integer>
{
  static XWalkUpdater aajB;
  private static String aalj = "0";
  private HashMap<String, String> aali;
  
  public h(XWalkUpdater paramXWalkUpdater, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(204882);
    aajB = paramXWalkUpdater;
    this.aali = paramHashMap;
    if (paramHashMap != null)
    {
      paramXWalkUpdater = (String)paramHashMap.get("UpdaterCheckType");
      aalj = paramXWalkUpdater;
      if ((paramXWalkUpdater == null) || (!aalj.equals("1"))) {
        break label81;
      }
      c.izB();
    }
    for (;;)
    {
      XWalkInitializer.addXWalkInitializeLog("XWalkUpdateChecker notify received !! mNotifyType = " + aalj);
      AppMethodBeat.o(204882);
      return;
      label81:
      if ((aalj != null) && (aalj.equals("2")))
      {
        c.izB();
        com.tencent.xweb.util.h.Xg(93L);
      }
      else if ((aalj != null) && (aalj.equals("3")))
      {
        k.izV().izG().aakw = true;
        com.tencent.xweb.util.h.Xg(94L);
      }
      else
      {
        aalj = "0";
      }
    }
  }
  
  public static void b(int paramInt, c paramc)
  {
    AppMethodBeat.i(204888);
    izQ();
    if (paramc != null) {
      paramc.aDf(paramInt);
    }
    AppMethodBeat.o(204888);
  }
  
  public static void b(c paramc)
  {
    AppMethodBeat.i(204887);
    XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
    izQ();
    if (paramc != null) {
      paramc.e(null);
    }
    AppMethodBeat.o(204887);
  }
  
  private static boolean b(k paramk)
  {
    AppMethodBeat.i(204885);
    d locald = paramk.izG();
    if (izO())
    {
      AppMethodBeat.o(204885);
      return false;
    }
    Object localObject1;
    if (!XWalkEnvironment.isSelfProvider())
    {
      izP();
      localObject1 = aajB.a(paramk);
      try
      {
        Object localObject2 = XWalkEnvironment.getPackageName();
        String str = ((XWalkUpdater.b)localObject1).errorCode + "," + (String)localObject2 + "," + ((XWalkUpdater.b)localObject1).aajd + "," + ((XWalkUpdater.b)localObject1).aaje + "," + ((XWalkUpdater.b)localObject1).aajf + "," + ((XWalkUpdater.b)localObject1).aajg + "," + ((XWalkUpdater.b)localObject1).aajh + "," + ((XWalkUpdater.b)localObject1).aaji + "," + ((XWalkUpdater.b)localObject1).aajj + "," + ((XWalkUpdater.b)localObject1).aajk;
        ContentResolver localContentResolver = XWalkEnvironment.getContentResolver();
        if (localContentResolver != null)
        {
          localObject2 = XWebCoreContentProvider.c("com.tencent.mm", (String)localObject2, 3, 0, "");
          ContentValues localContentValues = new ContentValues();
          localContentValues.put("15626", str);
          localContentResolver.insert((Uri)localObject2, localContentValues);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          XWalkInitializer.addXWalkInitializeLog("_doStartUpdate report error");
        }
        if (((XWalkUpdater.b)localObject1).errorCode != -10) {
          break label280;
        }
        b(((XWalkUpdater.b)localObject1).errorCode, paramk);
        AppMethodBeat.o(204885);
        return false;
        izQ();
      }
      if (((XWalkUpdater.b)localObject1).errorCode == 0)
      {
        p.iz("finished", 0);
        b(paramk);
        AppMethodBeat.o(204885);
        return true;
      }
    }
    label280:
    XWalkInitializer.addXWalkInitializeLog("_doStartUpdate go on");
    if (!NetworkUtil.isNetworkAvailable())
    {
      paramk = aj.iwM();
      if (paramk != null) {
        paramk.cku();
      }
      AppMethodBeat.o(204885);
      return false;
    }
    if ((!locald.aakw) && (!NetworkUtil.isWifiAvailable()))
    {
      XWalkInitializer.addXWalkInitializeLog("current network is not wifi , this scheduler not support mobile data");
      paramk = aj.iwM();
      if (paramk != null) {
        paramk.cku();
      }
      AppMethodBeat.o(204885);
      return false;
    }
    if (izP())
    {
      localObject1 = aajB;
      paramk = paramk.f(locald);
      int i;
      if (XWalkLibraryLoader.isDownloading())
      {
        XWalkInitializer.addXWalkInitializeLog("XWalkLib", "Other initialization or download is proceeding");
        i = 0;
      }
      while (i != 0)
      {
        AppMethodBeat.o(204885);
        return true;
        if (((XWalkUpdater)localObject1).aaiY != null)
        {
          if ((paramk == null) || (!paramk.checkValid()))
          {
            XWalkInitializer.addXWalkInitializeLog("XWalkLib", "royle:XWalkUpdater updateXWalkRuntime updateConfig is not valid");
            com.tencent.xweb.util.h.iyb();
            i = 0;
          }
          else
          {
            XWalkInitializer.addXWalkInitializeLog("XWalkLib", "start download apk");
            XWalkLibraryLoader.startHttpDownload(new XWalkUpdater.a((XWalkUpdater)localObject1, paramk), ((XWalkUpdater)localObject1).mContext, paramk);
            i = 1;
          }
        }
        else
        {
          XWalkInitializer.addXWalkInitializeLog("XWalkLib", "Update listener is null");
          i = 0;
        }
      }
      XWalkInitializer.addXWalkInitializeLog("start update failed");
      izQ();
    }
    AppMethodBeat.o(204885);
    return false;
  }
  
  private static void c(k paramk)
  {
    AppMethodBeat.i(204896);
    XWalkEnvironment.addXWalkInitializeLog("try update after config " + paramk.toString());
    if (izO())
    {
      AppMethodBeat.o(204896);
      return;
    }
    com.tencent.xweb.util.h.bb(903L, 160L);
    com.tencent.xweb.xwalk.c localc = aj.iwM();
    if (localc != null) {
      localc.ckt();
    }
    b(paramk);
    AppMethodBeat.o(204896);
  }
  
  public static boolean izO()
  {
    try
    {
      AppMethodBeat.i(154575);
      boolean bool = i.izO();
      AppMethodBeat.o(154575);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean izP()
  {
    try
    {
      AppMethodBeat.i(204886);
      boolean bool = i.izP();
      AppMethodBeat.o(204886);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void izQ()
  {
    try
    {
      AppMethodBeat.i(154577);
      i.izQ();
      AppMethodBeat.o(154577);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean izR()
  {
    AppMethodBeat.i(204891);
    if ((!XWalkEnvironment.hasInstalledAvailableVersion()) && (!k.izV().izw()))
    {
      XWalkEnvironment.addXWalkInitializeLog("isNeedFecthConfig: true because no scheduler and no availableVersion ");
      AppMethodBeat.o(204891);
      return true;
    }
    if ((c.IY(false).izF()) && (!izO()))
    {
      AppMethodBeat.o(204891);
      return true;
    }
    AppMethodBeat.o(204891);
    return false;
  }
  
  static void izS()
  {
    AppMethodBeat.i(204893);
    if (k.izV().IZ(true))
    {
      c(k.izV());
      AppMethodBeat.o(204893);
      return;
    }
    if (j.izU().IZ(true))
    {
      c(j.izU());
      AppMethodBeat.o(204893);
      return;
    }
    p.iz("finished", -5);
    AppMethodBeat.o(204893);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.b.h
 * JD-Core Version:    0.7.0.1
 */