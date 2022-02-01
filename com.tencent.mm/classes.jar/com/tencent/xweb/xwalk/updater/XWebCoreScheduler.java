package com.tencent.xweb.xwalk.updater;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import com.tencent.xweb.ai;
import com.tencent.xweb.util.g;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater.UpdateConfig;

public class XWebCoreScheduler
  extends Scheduler
{
  static XWebCoreScheduler MWq;
  
  static
  {
    AppMethodBeat.i(207643);
    if (!XWebCoreScheduler.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(207643);
      return;
    }
  }
  
  public static XWebCoreScheduler giw()
  {
    AppMethodBeat.i(207637);
    if (MWq == null) {
      MWq = new XWebCoreScheduler();
    }
    XWebCoreScheduler localXWebCoreScheduler = MWq;
    AppMethodBeat.o(207637);
    return localXWebCoreScheduler;
  }
  
  protected final String Ae(boolean paramBoolean)
  {
    AppMethodBeat.i(207640);
    if (!paramBoolean) {}
    for (String str = a.nb("UPDATE_SPEED_CONFIG", "tools");; str = a.nb("UPDATE_FORWARD_SPEED_CONFIG", "tools"))
    {
      AppMethodBeat.o(207640);
      return str;
    }
  }
  
  public c a(a.b paramb)
  {
    AppMethodBeat.i(207641);
    if (paramb == null)
    {
      AppMethodBeat.o(207641);
      return null;
    }
    Log.i("Scheduler", "onConfigDownLoaded get config ,config version is " + paramb.MVC);
    g.dA(paramb.MVC, true);
    if ((ai.gfR()) && (!XWalkEnvironment.isInTestMode()))
    {
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "it's gp version , dont down load any runtime version");
      AppMethodBeat.o(207641);
      return null;
    }
    gij();
    paramb = d(d.a(paramb, XWalkEnvironment.getRuntimeAbi()));
    AppMethodBeat.o(207641);
    return paramb;
  }
  
  public final XWalkUpdater.UpdateConfig f(c paramc)
  {
    AppMethodBeat.i(207642);
    try
    {
      if (paramc.MVY) {
        break label159;
      }
      if ((paramc.MVw != null) && (!paramc.MVw.isEmpty())) {
        break label126;
      }
      if (!$assertionsDisabled)
      {
        paramc = new AssertionError("royle:no md5 info, maybe something wrong");
        AppMethodBeat.o(207642);
        throw paramc;
      }
    }
    catch (Exception paramc)
    {
      XWalkInitializer.addXWalkInitializeLog("create  UpdateConfig failed , args is not valid");
      AppMethodBeat.o(207642);
      return null;
    }
    XWalkUpdater.UpdateConfig localUpdateConfig = new XWalkUpdater.UpdateConfig(paramc.MVp, false, paramc.version, paramc.strAbi, paramc.nPatchTargetVersion);
    for (;;)
    {
      localUpdateConfig.versionDetail = paramc.MWc;
      localUpdateConfig.bUseCdn = paramc.bUseCdn;
      localUpdateConfig.bTryUseSharedCore = paramc.bTryUseSharedCore;
      localUpdateConfig.scheduler = this;
      AppMethodBeat.o(207642);
      return localUpdateConfig;
      label126:
      localUpdateConfig = new XWalkUpdater.UpdateConfig(paramc.MVw, false, null, paramc.MVp, paramc.version, paramc.strAbi, paramc.nPatchTargetVersion);
      continue;
      label159:
      if ((paramc.MVw == null) || (paramc.MVw.isEmpty()) || (paramc.patchMd5 == null) || (paramc.patchMd5.isEmpty()))
      {
        if (!$assertionsDisabled)
        {
          paramc = new AssertionError("royle:no md5 info, maybe something wrong");
          AppMethodBeat.o(207642);
          throw paramc;
        }
        localUpdateConfig = new XWalkUpdater.UpdateConfig(paramc.MVp, true, paramc.version, paramc.strAbi, paramc.nPatchTargetVersion);
      }
      else
      {
        localUpdateConfig = new XWalkUpdater.UpdateConfig(paramc.patchMd5, true, paramc.MVw, paramc.MVp, paramc.version, paramc.strAbi, paramc.nPatchTargetVersion);
      }
    }
  }
  
  public String ghF()
  {
    return "XWebCore";
  }
  
  public boolean ghZ()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(207638);
        if (!super.ghZ())
        {
          AppMethodBeat.o(207638);
          return bool;
        }
        if (gij().version <= XWalkEnvironment.getInstalledNewstVersion(gij().strAbi))
        {
          AppMethodBeat.o(207638);
          continue;
        }
        bool = true;
      }
      finally {}
      AppMethodBeat.o(207638);
    }
  }
  
  protected boolean gia()
  {
    AppMethodBeat.i(207639);
    if (!XWalkEnvironment.hasInstalledAvailableVersion())
    {
      if (!"true".equalsIgnoreCase(a.nb("dis_update_immediately_when_no_xweb", "tools")))
      {
        if (gij().MWd > 0)
        {
          XWalkEnvironment.addXWalkInitializeLog(this.TAG, " failed update before , do not force update ");
          if (!"true".equalsIgnoreCase(a.nb("allow_failed_schedule_force_update", "tools")))
          {
            AppMethodBeat.o(207639);
            return false;
          }
        }
        XWalkEnvironment.addXWalkInitializeLog(this.TAG, "isTimeToUpdate no availableversion installed, do start download ");
        AppMethodBeat.o(207639);
        return true;
      }
      XWalkEnvironment.addXWalkInitializeLog(this.TAG, " no availableversion but dis_update_immediately_when_no_xweb == true");
    }
    AppMethodBeat.o(207639);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.XWebCoreScheduler
 * JD-Core Version:    0.7.0.1
 */