package com.tencent.xweb.xwalk.updater;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.XWebCoreContentProvider;
import com.tencent.xweb.ao;
import com.tencent.xweb.internal.b.c;
import com.tencent.xweb.xwalk.o;
import com.tencent.xweb.xwalk.o.a;
import java.util.Arrays;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkGrayValueUtil;
import org.xwalk.core.XWebDownloader;

public final class k
  extends AsyncTask<Void, Integer, Integer>
{
  private final o aiqU;
  private String aiqg;
  
  public k(Context paramContext, i parami, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(213002);
    this.aiqg = "0";
    this.aiqU = new o(paramContext, parami);
    if (paramHashMap != null)
    {
      this.aiqg = ((String)paramHashMap.get("UpdaterCheckType"));
      if ((this.aiqg == null) || (!this.aiqg.equals("1"))) {
        break label105;
      }
      n.kkq().kjU();
    }
    for (;;)
    {
      Log.i("XWalkUpdateChecker", "create XWalkUpdateChecker, notifyType:" + this.aiqg + " [0:timer/1:notify/2:force/4:embed/5:config]");
      AppMethodBeat.o(213002);
      return;
      label105:
      if ((this.aiqg != null) && (this.aiqg.equals("2")))
      {
        n.kkq().kjU();
        com.tencent.xweb.util.l.Br(93L);
      }
      else if ((this.aiqg != null) && (this.aiqg.equals("3")))
      {
        n.kkq().kjY().aiiK = true;
        com.tencent.xweb.util.l.Br(94L);
      }
      else if ((this.aiqg == null) || (!this.aiqg.equals("5")))
      {
        this.aiqg = "0";
      }
    }
  }
  
  public static boolean Ph(boolean paramBoolean)
  {
    AppMethodBeat.i(213010);
    if ((!XWalkEnvironment.hasInstalledAvailableVersion()) && (!n.kkq().kjQ()))
    {
      Log.i("XWalkUpdateChecker", "checkNeedFetchConfig, true because no scheduler and no availableVersion");
      AppMethodBeat.o(213010);
      return true;
    }
    if ((n.kkq().kjX()) && (!l.kkm()))
    {
      Log.i("XWalkUpdateChecker", "checkNeedFetchConfig, true because not in updating process and need fetch config");
      AppMethodBeat.o(213010);
      return true;
    }
    boolean bool1 = n.kkq().Pe(false);
    boolean bool2 = m.kkp().Pe(false);
    if ((bool1) || (bool2))
    {
      Log.i("XWalkUpdateChecker", "checkNeedFetchConfig, true because needUpdateRuntime:" + bool1 + ", needUpdatePredownRuntime:" + bool2);
      if (paramBoolean) {
        com.tencent.xweb.util.l.y(903L, 159L, 1L);
      }
      AppMethodBeat.o(213010);
      return true;
    }
    AppMethodBeat.o(213010);
    return false;
  }
  
  private void b(n paramn)
  {
    AppMethodBeat.i(213017);
    if (l.kkm())
    {
      Log.i("XWalkUpdateChecker", "startUpdateRuntime, already in updating process");
      AppMethodBeat.o(213017);
      return;
    }
    Log.i("XWalkUpdateChecker", "startUpdateRuntime, scheduler config:" + paramn.toString());
    com.tencent.xweb.util.l.bO(903L, 160L);
    com.tencent.xweb.xwalk.c localc = ao.kgu();
    if (localc != null) {
      localc.cLH();
    }
    c(paramn);
    AppMethodBeat.o(213017);
  }
  
  private boolean c(n paramn)
  {
    AppMethodBeat.i(213031);
    if (l.kkm())
    {
      Log.w("XWalkUpdateChecker", "doStartUpdateRuntime, already in updating process");
      paramn = ao.kgu();
      if (paramn != null) {
        paramn.cLI();
      }
      AppMethodBeat.o(213031);
      return false;
    }
    Object localObject1;
    if (!XWebCoreContentProvider.kga())
    {
      Log.i("XWalkUpdateChecker", "doStartUpdateRuntime, not self provider");
      l.kkn();
      localObject1 = this.aiqU.a(paramn);
      try
      {
        Object localObject3 = XWalkEnvironment.getPackageName();
        String str = ((o.a)localObject1).errorCode + "," + (String)localObject3 + "," + ((o.a)localObject1).aipq + "," + ((o.a)localObject1).aipr + "," + ((o.a)localObject1).aips + "," + ((o.a)localObject1).aipt + "," + ((o.a)localObject1).aipu + "," + ((o.a)localObject1).aipv + "," + ((o.a)localObject1).aipw + "," + ((o.a)localObject1).aipx;
        ContentResolver localContentResolver = XWalkEnvironment.getContentResolver();
        if (localContentResolver != null)
        {
          localObject3 = XWebCoreContentProvider.c("com.tencent.mm", (String)localObject3, 3, 0, "");
          ContentValues localContentValues = new ContentValues();
          localContentValues.put("15626", str);
          localContentResolver.insert((Uri)localObject3, localContentValues);
        }
      }
      finally
      {
        for (;;)
        {
          Log.i("XWalkUpdateChecker", "doStartUpdateRuntime, report error:".concat(String.valueOf(localObject2)));
        }
        if (((o.a)localObject1).errorCode != -10) {
          break label335;
        }
        i = ((o.a)localObject1).errorCode;
        l.kko();
        if (paramn == null) {
          break label328;
        }
        paramn.aJR(i);
        AppMethodBeat.o(213031);
        return false;
        l.kko();
      }
      if (((o.a)localObject1).errorCode == 0)
      {
        j.jM("finished", 0);
        l.kko();
        if (paramn != null) {
          paramn.e(null);
        }
        AppMethodBeat.o(213031);
        return true;
      }
    }
    int i;
    label328:
    label335:
    Log.i("XWalkUpdateChecker", "doStartUpdateRuntime, continue");
    if (!NetworkUtil.isNetworkAvailable())
    {
      Log.i("XWalkUpdateChecker", "doStartUpdateRuntime, no network");
      paramn = ao.kgu();
      if (paramn != null) {
        paramn.cLI();
      }
      AppMethodBeat.o(213031);
      return false;
    }
    d locald = paramn.kjY();
    if ((!locald.aiiK) && (!NetworkUtil.isWifiAvailable()))
    {
      Log.i("XWalkUpdateChecker", "doStartUpdateRuntime, not wifi and scheduler not support mobile data");
      paramn = ao.kgu();
      if (paramn != null) {
        paramn.cLI();
      }
      AppMethodBeat.o(213031);
      return false;
    }
    if (l.kkn())
    {
      localObject1 = this.aiqU;
      paramn = paramn.f(locald);
      if (XWebDownloader.isDownloading())
      {
        XWalkEnvironment.addXWalkInitializeLog("XWalkUpdater", "updateRuntime, in downloading process");
        i = 0;
      }
      while (i != 0)
      {
        AppMethodBeat.o(213031);
        return true;
        if (((o)localObject1).aipp != null)
        {
          if ((paramn == null) || (!paramn.checkValid()))
          {
            XWalkEnvironment.addXWalkInitializeLog("XWalkUpdater", "updateRuntime, updateConfig is invalid");
            com.tencent.xweb.util.l.kip();
            i = 0;
          }
          else
          {
            XWalkEnvironment.addXWalkInitializeLog("XWalkUpdater", "updateRuntime, start download runtime");
            XWebDownloader.startDownload(new h(paramn, (o)localObject1), ((o)localObject1).mContext, paramn);
            i = 1;
          }
        }
        else
        {
          XWalkEnvironment.addXWalkInitializeLog("XWalkUpdater", "updateRuntime, update listener is null");
          i = 0;
        }
      }
      Log.i("XWalkUpdateChecker", "doStartUpdateRuntime, update failed");
      l.kko();
    }
    AppMethodBeat.o(213031);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.k
 * JD-Core Version:    0.7.0.1
 */