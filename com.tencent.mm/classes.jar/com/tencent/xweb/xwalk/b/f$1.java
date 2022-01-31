package com.tencent.xweb.xwalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.ab;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

final class f$1
  implements b
{
  public final void a(g.c paramc)
  {
    int j = 0;
    AppMethodBeat.i(85479);
    Object localObject = a.ayr(paramc.mFilePath);
    if (localObject == null)
    {
      com.tencent.xweb.util.f.pf(35L);
      com.tencent.xweb.util.f.dZu();
      com.tencent.xweb.util.f.bW(15123, "0,190503," + paramc.BLt + "," + paramc.mNetWorkType + "," + paramc.mRetryTimes + "," + paramc.BLu + "," + paramc.mTotalSize);
      XWalkEnvironment.addXWalkInitializeLog("ConfigParser failed ");
      paramc = ab.dYE();
      if (paramc != null) {
        paramc.aMy();
      }
      AppMethodBeat.o(85479);
      return;
    }
    try
    {
      com.tencent.xweb.a.a(((a.a)localObject).BKM, ((a.a)localObject).BKK);
      XWalkEnvironment.addXWalkInitializeLog("doFetchUpdateConfigNew onTaskSucceed!!");
      com.tencent.xweb.util.f.pk(paramc.BLu);
      com.tencent.xweb.util.f.bW(15123, ((a.a)localObject).BKK + ",190503," + paramc.BLt + "," + paramc.mNetWorkType + "," + paramc.mRetryTimes + "," + paramc.BLu + "," + paramc.mTotalSize + "," + f.access$000());
      c.eav();
      if (localObject != null)
      {
        Log.i("Scheduler", "onConfigDownLoaded get config ,config version is " + ((a.a)localObject).BKK);
        if ((XWalkEnvironment.isForbidDownloadCode()) && (!XWalkEnvironment.isInTestMode())) {
          XWalkInitializer.addXWalkInitializeLog("it's gp version , dont down load any runtime version");
        }
      }
      else
      {
        paramc = null;
        f.c(paramc);
        AppMethodBeat.o(85479);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        XWalkEnvironment.addXWalkInitializeLog("apply cmds failed , " + localException.getMessage());
        continue;
        c.a locala = c.eaD();
        if ((locala != null) && (locala.BKK != ((a.a)localObject).BKK))
        {
          paramc = new c.a();
          a.e locale = d.a((a.a)localObject);
          label527:
          int i;
          if ((locale != null) && (locale.BKV > XWalkEnvironment.getInstalledNewstVersion()))
          {
            XWalkInitializer.addXWalkInitializeLog("got matched version");
            paramc.BKK = ((a.a)localObject).BKK;
            paramc.BKJ = locale.BKJ;
            paramc.BKV = locale.BKV;
            paramc.BLe = locale.BKW.BKX;
            paramc.BKP = locale.BKP;
            paramc.bUseCdn = locale.bUseCdn;
            paramc.bTryUseSharedCore = locale.bTryUseSharedCore;
            localObject = d.a(locale);
            paramc.BLc = locale.BKO;
            if (localObject != null)
            {
              paramc.BLb = true;
              paramc.BKO = ((a.b)localObject).BKO;
              paramc.bWN = ((a.b)localObject).BKJ;
              paramc.BKP = ((a.b)localObject).BKP;
              paramc.bUseCdn = ((a.b)localObject).bUseCdn;
              double d = Math.random();
              i = (int)(locale.BKT * d);
              paramc.BLd = (i * 60 * 1000 + System.currentTimeMillis());
              XWalkInitializer.addXWalkInitializeLog("schedul after " + i + " minute to update");
              label587:
              if (paramc == null) {
                continue;
              }
              i = j;
              if (paramc.BKV == locala.BKV)
              {
                i = j;
                if (paramc.BKP == locala.BKP)
                {
                  i = j;
                  if (paramc.bUseCdn == locala.bUseCdn)
                  {
                    i = j;
                    if (paramc.BLb == locala.BLb)
                    {
                      i = j;
                      if (c.jh(paramc.BKJ, locala.BKJ))
                      {
                        if (c.jh(paramc.BLc, locala.BLc)) {
                          break label729;
                        }
                        i = j;
                      }
                    }
                  }
                }
              }
            }
          }
          for (;;)
          {
            if (i == 0) {
              break label761;
            }
            XWalkInitializer.addXWalkInitializeLog("got same version to scheduler, abandon it ");
            break;
            paramc.BLb = false;
            paramc.BKO = locale.BKO;
            break label527;
            paramc = null;
            break label587;
            label729:
            if (paramc.BLb)
            {
              i = j;
              if (!c.jh(paramc.bWN, locala.bWN)) {}
            }
            else
            {
              i = 1;
            }
          }
          label761:
          if (c.eax()) {
            XWalkInitializer.addXWalkInitializeLog("got new scheduler replace current , version is " + paramc.BKV);
          }
          c.a(paramc);
        }
      }
    }
  }
  
  public final void b(g.c paramc)
  {
    AppMethodBeat.i(85480);
    com.tencent.xweb.xwalk.b localb = ab.dYE();
    if (localb != null) {
      localb.aMy();
    }
    com.tencent.xweb.util.f.pf(35L);
    com.tencent.xweb.util.f.dZu();
    com.tencent.xweb.util.f.bW(15123, "0,190503," + paramc.BLt + "," + paramc.mNetWorkType + "," + paramc.mRetryTimes + "," + paramc.BLu + "," + paramc.mTotalSize + "," + f.access$000());
    XWalkEnvironment.addXWalkInitializeLog("get config onTaskFailed ");
    AppMethodBeat.o(85480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.b.f.1
 * JD-Core Version:    0.7.0.1
 */