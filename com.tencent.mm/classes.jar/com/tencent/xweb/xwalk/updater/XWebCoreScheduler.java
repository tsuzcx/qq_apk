package com.tencent.xweb.xwalk.updater;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import com.tencent.xweb.ai;
import com.tencent.xweb.util.h;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater.UpdateConfig;

public class XWebCoreScheduler
  extends Scheduler
{
  static XWebCoreScheduler SJy;
  
  static
  {
    AppMethodBeat.i(207381);
    if (!XWebCoreScheduler.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(207381);
      return;
    }
  }
  
  public static XWebCoreScheduler hvW()
  {
    AppMethodBeat.i(207375);
    if (SJy == null) {
      SJy = new XWebCoreScheduler();
    }
    XWebCoreScheduler localXWebCoreScheduler = SJy;
    AppMethodBeat.o(207375);
    return localXWebCoreScheduler;
  }
  
  protected final String Eu(boolean paramBoolean)
  {
    AppMethodBeat.i(207378);
    if (!paramBoolean) {}
    for (String str = a.nS("UPDATE_SPEED_CONFIG", "tools");; str = a.nS("UPDATE_FORWARD_SPEED_CONFIG", "tools"))
    {
      AppMethodBeat.o(207378);
      return str;
    }
  }
  
  public c a(a.b paramb)
  {
    AppMethodBeat.i(207379);
    if (paramb == null)
    {
      AppMethodBeat.o(207379);
      return null;
    }
    Log.i("Scheduler", "onConfigDownLoaded get config ,config version is " + paramb.SIJ);
    h.dO(paramb.SIJ, true);
    if ((ai.htj()) && (!XWalkEnvironment.isInTestMode()))
    {
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "it's gp version , dont down load any runtime version");
      AppMethodBeat.o(207379);
      return null;
    }
    hvJ();
    paramb = d(d.a(paramb, XWalkEnvironment.getRuntimeAbi()));
    AppMethodBeat.o(207379);
    return paramb;
  }
  
  public final XWalkUpdater.UpdateConfig f(c paramc)
  {
    AppMethodBeat.i(207380);
    try
    {
      if (paramc.SJc) {
        break label159;
      }
      if ((paramc.SID != null) && (!paramc.SID.isEmpty())) {
        break label126;
      }
      if (!$assertionsDisabled)
      {
        paramc = new AssertionError("royle:no md5 info, maybe something wrong");
        AppMethodBeat.o(207380);
        throw paramc;
      }
    }
    catch (Exception paramc)
    {
      XWalkInitializer.addXWalkInitializeLog("create  UpdateConfig failed , args is not valid");
      AppMethodBeat.o(207380);
      return null;
    }
    XWalkUpdater.UpdateConfig localUpdateConfig = new XWalkUpdater.UpdateConfig(paramc.SIw, false, paramc.version, paramc.strAbi, paramc.nPatchTargetVersion);
    for (;;)
    {
      localUpdateConfig.versionDetail = paramc.SJg;
      localUpdateConfig.bUseCdn = paramc.bUseCdn;
      localUpdateConfig.bTryUseSharedCore = paramc.bTryUseSharedCore;
      localUpdateConfig.scheduler = this;
      AppMethodBeat.o(207380);
      return localUpdateConfig;
      label126:
      localUpdateConfig = new XWalkUpdater.UpdateConfig(paramc.SID, false, null, paramc.SIw, paramc.version, paramc.strAbi, paramc.nPatchTargetVersion);
      continue;
      label159:
      if ((paramc.SID == null) || (paramc.SID.isEmpty()) || (paramc.patchMd5 == null) || (paramc.patchMd5.isEmpty()))
      {
        if (!$assertionsDisabled)
        {
          paramc = new AssertionError("royle:no md5 info, maybe something wrong");
          AppMethodBeat.o(207380);
          throw paramc;
        }
        localUpdateConfig = new XWalkUpdater.UpdateConfig(paramc.SIw, true, paramc.version, paramc.strAbi, paramc.nPatchTargetVersion);
      }
      else
      {
        localUpdateConfig = new XWalkUpdater.UpdateConfig(paramc.patchMd5, true, paramc.SID, paramc.SIw, paramc.version, paramc.strAbi, paramc.nPatchTargetVersion);
      }
    }
  }
  
  protected boolean hvA()
  {
    AppMethodBeat.i(207377);
    if (!XWalkEnvironment.hasInstalledAvailableVersion())
    {
      if (!"true".equalsIgnoreCase(a.nS("dis_update_immediately_when_no_xweb", "tools")))
      {
        if (hvJ().SJh > 0)
        {
          XWalkEnvironment.addXWalkInitializeLog(this.TAG, " failed update before , do not force update ");
          if (!"true".equalsIgnoreCase(a.nS("allow_failed_schedule_force_update", "tools")))
          {
            AppMethodBeat.o(207377);
            return false;
          }
        }
        XWalkEnvironment.addXWalkInitializeLog(this.TAG, "isTimeToUpdate no availableversion installed, do start download ");
        AppMethodBeat.o(207377);
        return true;
      }
      XWalkEnvironment.addXWalkInitializeLog(this.TAG, " no availableversion but dis_update_immediately_when_no_xweb == true");
    }
    AppMethodBeat.o(207377);
    return false;
  }
  
  public String hvc()
  {
    return "XWebCore";
  }
  
  public boolean hvz()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(207376);
        if (!super.hvz())
        {
          AppMethodBeat.o(207376);
          return bool;
        }
        if (hvJ().version <= XWalkEnvironment.getInstalledNewstVersion(hvJ().strAbi))
        {
          AppMethodBeat.o(207376);
          continue;
        }
        bool = true;
      }
      finally {}
      AppMethodBeat.o(207376);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.XWebCoreScheduler
 * JD-Core Version:    0.7.0.1
 */