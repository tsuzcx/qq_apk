package com.tencent.xweb.xwalk.updater;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.a.c;
import com.tencent.xweb.util.e;
import com.tencent.xweb.util.e.a;
import com.tencent.xweb.util.g;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWebCoreInfo;

public final class c
{
  private static long a(a.e parame)
  {
    AppMethodBeat.i(194719);
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if (TextUtils.isEmpty(parame.IVD))
    {
      localObject1 = null;
      localObject3 = new SimpleDateFormat("yyyyMMdd");
      localObject2 = new Date();
    }
    try
    {
      if (TextUtils.isEmpty(parame.IVE)) {
        break label460;
      }
      localObject3 = ((SimpleDateFormat)localObject3).parse(parame.IVE);
      localObject2 = localObject3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        XWalkEnvironment.addXWalkInitializeLog("VersionMatcher", " parse version release date failed " + localException.getMessage());
        g.r(903L, 158L, 1L);
      }
      if ((parame.IPM.IPY <= 0) || (parame.IPM.IPY > 10000)) {
        break label579;
      }
      j = parame.IPM.IPY;
      if ((parame.IPM.IPZ <= 0) || (parame.IPM.IPZ > 10000)) {
        break label585;
      }
      for (k = parame.IPM.IPZ;; k = 10000)
      {
        d1 = (XWalkEnvironment.getGrayValue() - j) * 10000.0D / (k - j + 1);
        j = 0;
        while ((j < localObject1.length) && (d1 > localObject1[j])) {
          j += 1;
        }
        j = 0;
        break;
      }
      Calendar.getInstance();
      d1 = e.fsa();
      d2 = Scheduler.I(parame.IVB);
      d3 = Scheduler.s(parame.IVB, parame.IVC);
      j -= i;
      int i = j;
      if (j > 0) {
        break label651;
      }
      if (d1 < d3) {
        break label689;
      }
      i = 1;
      l = (Scheduler.a(0.0D, d2, d3) * 3600000.0D + 86400000L * (i - 1) + e.frZ());
      AppMethodBeat.o(194719);
      return l;
    }
    double d1 = (new Date().getTime() - ((Date)localObject2).getTime()) / 86400000.0D;
    i = (int)d1;
    if ((d1 < 1.0D) || (d1 > 365.0D)) {
      i = 0;
    }
    for (;;)
    {
      int j;
      int k;
      if ((localObject1 == null) || (localObject1.length == 0))
      {
        AppMethodBeat.o(194719);
        return 0L;
        localObject2 = new ArrayList();
        localObject1 = parame.IVD.split(":");
        j = localObject1.length;
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            localObject3 = localObject1[i];
            if (!TextUtils.isEmpty((CharSequence)localObject3))
            {
              localObject3 = e.aPt((String)localObject3);
              if (!((e.a)localObject3).IRB) {
                break label268;
              }
              k = ((e.a)localObject3).intValue();
              if ((k >= 0) && (k <= 10000)) {
                ((List)localObject2).add(localObject3);
              }
            }
            else
            {
              i += 1;
              continue;
            }
            Log.e("ConfigParser", " get invalid schedule value = " + k + ", schedule str is " + parame.IVD);
            localObject1 = null;
            break;
            label268:
            Log.e("ConfigParser", " parse schedule failed , schedule str is " + parame.IVD);
            localObject1 = null;
            break;
          }
        }
        if (((List)localObject2).size() == 0)
        {
          localObject1 = null;
          break;
        }
        localObject1 = new int[((List)localObject2).size()];
        i = 0;
        for (;;)
        {
          if (i >= ((List)localObject2).size()) {
            break label420;
          }
          j = ((e.a)((List)localObject2).get(i)).intValue();
          if ((i > 0) && (j < localObject1[(i - 1)]))
          {
            Log.e("ConfigParser", " get invalid schedule this value smaller than previous one , schedule str is " + parame.IVD);
            localObject1 = null;
            break;
          }
          localObject1[i] = j;
          i += 1;
        }
        label420:
        break;
      }
      label460:
      double d2;
      label579:
      label585:
      double d3;
      label651:
      label689:
      long l = ((Scheduler.a(d1, d2, d3) - d1) * 3600000.0D);
      AppMethodBeat.o(194719);
      return l;
    }
  }
  
  public static Scheduler.SchedulerConfig a(a.a parama, String paramString)
  {
    AppMethodBeat.i(154562);
    Scheduler.SchedulerConfig localSchedulerConfig = new Scheduler.SchedulerConfig();
    a.c.aPm(paramString);
    Object localObject1;
    label256:
    long l;
    if ((parama == null) || (parama.IVo == null) || (parama.IVo.length == 0))
    {
      localObject1 = null;
      a.c.aPm(null);
      if ((localObject1 == null) || (((a.e)localObject1).IVy <= XWebCoreInfo.getBackupCoreInfo(paramString).ver)) {
        break label838;
      }
      XWalkInitializer.addXWalkInitializeLog("got matched version");
      localSchedulerConfig.IVn = parama.IVn;
      localSchedulerConfig.IVm = ((a.e)localObject1).IVm;
      localSchedulerConfig.IVy = ((a.e)localObject1).IVy;
      localSchedulerConfig.IVO = ((a.e)localObject1).IVz.IVG;
      localSchedulerConfig.IVs = ((a.e)localObject1).IVs;
      localSchedulerConfig.bUseCdn = ((a.e)localObject1).bUseCdn;
      localSchedulerConfig.bTryUseSharedCore = ((a.e)localObject1).bTryUseSharedCore;
      parama = a((a.e)localObject1, paramString);
      localSchedulerConfig.IVM = ((a.e)localObject1).IVr;
      localSchedulerConfig.strAbi = ((a.e)localObject1).IPM.IQm;
      localSchedulerConfig.IVA = ((a.e)localObject1).IVA;
      localSchedulerConfig.IVR = ((a.e)localObject1).IVB;
      localSchedulerConfig.IVS = ((a.e)localObject1).IVC;
      if (parama == null) {
        break label568;
      }
      localSchedulerConfig.IVL = true;
      localSchedulerConfig.nPatchTargetVersion = parama.IVq;
      localSchedulerConfig.IVr = parama.IVr;
      localSchedulerConfig.patchMd5 = parama.IVm;
      localSchedulerConfig.IVs = parama.IVs;
      localSchedulerConfig.bUseCdn = parama.bUseCdn;
      if (TextUtils.isEmpty(((a.e)localObject1).IVD)) {
        break label587;
      }
      l = a((a.e)localObject1);
      localSchedulerConfig.IVN = (System.currentTimeMillis() + l);
      XWalkInitializer.addXWalkInitializeLog("schedul after " + l / 60L / 1000L + " minute to update");
    }
    label568:
    label704:
    for (;;)
    {
      AppMethodBeat.o(154562);
      return localSchedulerConfig;
      int i = Build.VERSION.SDK_INT;
      localObject1 = parama.IVo;
      int j = localObject1.length;
      i = 0;
      int k;
      if (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2 == null) {
          XWalkInitializer.addXWalkInitializeLog("no matched version  version == null");
        }
        for (;;)
        {
          i += 1;
          break;
          Log.i("VersionMatcher", "try match version = " + localObject2.IVy + " version runtime abi is " + localObject2.IPM.IQm);
          if (localObject2.IVy < 49)
          {
            Log.i("VersionMatcher", " apk is not support, below 49");
          }
          else
          {
            k = XWalkEnvironment.getInstalledNewstVersion(localObject2.IPM.IQm);
            if (localObject2.IVy <= k)
            {
              Log.i("VersionMatcher", " apk is too old, now installed version ".concat(String.valueOf(k)));
            }
            else
            {
              if (localObject2.IPM.frG()) {
                break label509;
              }
              Log.i("VersionMatcher", " apk filter out ");
            }
          }
        }
        label509:
        String str = localObject2.IPM.IQm;
        XWalkUpdater.getLastTryInstallVer(str);
        localObject1 = localObject2;
        if ("arm64-v8a".equalsIgnoreCase(str)) {
          break;
        }
        "armeabi-v7a".equalsIgnoreCase(str);
        localObject1 = localObject2;
        break;
      }
      XWalkInitializer.addXWalkInitializeLog("no matched version");
      localObject1 = null;
      break;
      localSchedulerConfig.IVL = false;
      localSchedulerConfig.IVr = ((a.e)localObject1).IVr;
      break label256;
      label587:
      if (((a.e)localObject1).IVw > 0)
      {
        l = ((a.e)localObject1).IVw * 60 * 1000;
        if (0L == l)
        {
          l = 0L;
          localSchedulerConfig.IVN = (System.currentTimeMillis() + l);
          XWalkInitializer.addXWalkInitializeLog("schedul after " + l / 60L / 1000L + " minute to update");
        }
        else
        {
          if ((((a.e)localObject1).IPM.IPY > 0) && (((a.e)localObject1).IPM.IPY <= 10000))
          {
            i = ((a.e)localObject1).IPM.IPY;
            if ((((a.e)localObject1).IPM.IPZ <= 0) || (((a.e)localObject1).IPM.IPZ > 10000)) {
              break label813;
            }
          }
          for (j = ((a.e)localObject1).IPM.IPZ;; j = 10000)
          {
            k = j - i + 1;
            j = k;
            if (k <= 0) {
              j = 1;
            }
            double d = (XWalkEnvironment.getGrayValue() - i) * l / j;
            l = ((l * (XWalkEnvironment.getGrayValue() + 1 - i) / j - d) * Math.random() + d);
            break;
            i = 0;
            break label704;
          }
        }
      }
      else
      {
        localSchedulerConfig.IVN = 100L;
        XWalkInitializer.addXWalkInitializeLog("no schedule time");
      }
    }
    label813:
    label838:
    AppMethodBeat.o(154562);
    return null;
  }
  
  private static a.b a(a.e parame, String paramString)
  {
    AppMethodBeat.i(194720);
    if (parame.IVx != null)
    {
      parame = parame.IVx;
      int j = parame.length;
      int i = 0;
      while (i < j)
      {
        a.b localb = parame[i];
        if (localb.IVq == XWalkEnvironment.getInstalledNewstVersion(paramString))
        {
          XWalkInitializer.addXWalkInitializeLog("got matched patch to upgrade " + localb.IVq);
          AppMethodBeat.o(194720);
          return localb;
        }
        i += 1;
      }
    }
    XWalkInitializer.addXWalkInitializeLog("no matched patch");
    AppMethodBeat.o(194720);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.c
 * JD-Core Version:    0.7.0.1
 */