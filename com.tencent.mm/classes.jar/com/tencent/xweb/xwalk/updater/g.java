package com.tencent.xweb.xwalk.updater;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import com.tencent.xweb.ai;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater.UpdateConfig;

public class g
  extends c
{
  static
  {
    AppMethodBeat.i(208972);
    if (!g.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(208972);
      return;
    }
  }
  
  public static XWalkUpdater.UpdateConfig g(SchedulerConfig paramSchedulerConfig)
  {
    AppMethodBeat.i(208971);
    try
    {
      if (paramSchedulerConfig.KIp) {
        break label161;
      }
      if ((paramSchedulerConfig.KHS != null) && (!paramSchedulerConfig.KHS.isEmpty())) {
        break label128;
      }
      if (!$assertionsDisabled)
      {
        paramSchedulerConfig = new AssertionError("royle:no md5 info, maybe something wrong");
        AppMethodBeat.o(208971);
        throw paramSchedulerConfig;
      }
    }
    catch (Exception paramSchedulerConfig)
    {
      XWalkInitializer.addXWalkInitializeLog("create  UpdateConfig failed , args is not valid");
      c.fLZ().e(null);
      AppMethodBeat.o(208971);
      return null;
    }
    XWalkUpdater.UpdateConfig localUpdateConfig = new XWalkUpdater.UpdateConfig(paramSchedulerConfig.KHL, false, paramSchedulerConfig.version, paramSchedulerConfig.strAbi, paramSchedulerConfig.nPatchTargetVersion);
    for (;;)
    {
      localUpdateConfig.versionDetail = paramSchedulerConfig.KIs;
      localUpdateConfig.bUseCdn = paramSchedulerConfig.bUseCdn;
      localUpdateConfig.bTryUseSharedCore = paramSchedulerConfig.bTryUseSharedCore;
      AppMethodBeat.o(208971);
      return localUpdateConfig;
      label128:
      localUpdateConfig = new XWalkUpdater.UpdateConfig(paramSchedulerConfig.KHS, false, null, paramSchedulerConfig.KHL, paramSchedulerConfig.version, paramSchedulerConfig.strAbi, paramSchedulerConfig.nPatchTargetVersion);
      continue;
      label161:
      if ((paramSchedulerConfig.KHS == null) || (paramSchedulerConfig.KHS.isEmpty()) || (paramSchedulerConfig.patchMd5 == null) || (paramSchedulerConfig.patchMd5.isEmpty()))
      {
        if (!$assertionsDisabled)
        {
          paramSchedulerConfig = new AssertionError("royle:no md5 info, maybe something wrong");
          AppMethodBeat.o(208971);
          throw paramSchedulerConfig;
        }
        localUpdateConfig = new XWalkUpdater.UpdateConfig(paramSchedulerConfig.KHL, true, paramSchedulerConfig.version, paramSchedulerConfig.strAbi, paramSchedulerConfig.nPatchTargetVersion);
      }
      else
      {
        localUpdateConfig = new XWalkUpdater.UpdateConfig(paramSchedulerConfig.patchMd5, true, paramSchedulerConfig.KHS, paramSchedulerConfig.KHL, paramSchedulerConfig.version, paramSchedulerConfig.strAbi, paramSchedulerConfig.nPatchTargetVersion);
      }
    }
  }
  
  public final SchedulerConfig a(a.b paramb)
  {
    AppMethodBeat.i(208970);
    if (paramb == null)
    {
      AppMethodBeat.o(208970);
      return null;
    }
    Log.i("Scheduler", "onConfigDownLoaded get config ,config version is " + paramb.KHU);
    if ((ai.fJV()) && (!XWalkEnvironment.isInTestMode()))
    {
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "it's gp version , dont down load any runtime version");
      AppMethodBeat.o(208970);
      return null;
    }
    SchedulerConfig localSchedulerConfig = fMm();
    if ((localSchedulerConfig != null) && (!TextUtils.isEmpty(paramb.KHU)) && (!paramb.KHU.equals(localSchedulerConfig.KHU)))
    {
      localSchedulerConfig = d.a(paramb, XWalkEnvironment.getRuntimeAbi());
      String str = a.mx("pre_down_abi", "tools");
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "predown load abi is ".concat(String.valueOf(str)));
      if ((TextUtils.isEmpty(str)) || (str.equalsIgnoreCase(XWalkEnvironment.getRuntimeAbi()))) {
        break label325;
      }
      paramb = d.a(paramb, str);
      if (paramb != null) {
        com.tencent.xweb.util.g.r(577L, 240L, 1L);
      }
    }
    for (;;)
    {
      int i = 0;
      if (localSchedulerConfig != null)
      {
        XWalkInitializer.addXWalkInitializeLog(this.TAG, "use cur abi schedule:" + localSchedulerConfig.version);
        paramb = localSchedulerConfig;
      }
      for (;;)
      {
        localSchedulerConfig = d(paramb);
        if ((i != 0) && (localSchedulerConfig == paramb))
        {
          if (!"armeabi-v7a".equalsIgnoreCase(paramb.strAbi)) {
            break label288;
          }
          com.tencent.xweb.util.g.r(577L, 236L, 1L);
        }
        for (;;)
        {
          AppMethodBeat.o(208970);
          return localSchedulerConfig;
          if (paramb == null) {
            break label320;
          }
          XWalkInitializer.addXWalkInitializeLog(this.TAG, "use pre down load abi schedule:" + paramb.version);
          i = 1;
          break;
          label288:
          if ("arm64-v8a".equalsIgnoreCase(paramb.strAbi)) {
            com.tencent.xweb.util.g.r(577L, 237L, 1L);
          }
        }
        AppMethodBeat.o(208970);
        return null;
        label320:
        paramb = null;
      }
      label325:
      paramb = null;
    }
  }
  
  public String fLH()
  {
    return "XWebCore";
  }
  
  public boolean fMd()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(208967);
        if (!super.fMd())
        {
          AppMethodBeat.o(208967);
          return bool;
        }
        if (fMm().version <= XWalkEnvironment.getInstalledNewstVersion(fMm().strAbi))
        {
          AppMethodBeat.o(208967);
          continue;
        }
        bool = true;
      }
      finally {}
      AppMethodBeat.o(208967);
    }
  }
  
  protected final boolean fMe()
  {
    AppMethodBeat.i(208968);
    if (!XWalkEnvironment.hasInstalledAvailableVersion())
    {
      if (!"true".equalsIgnoreCase(a.mx("dis_update_immediately_when_no_xweb", "tools")))
      {
        XWalkEnvironment.addXWalkInitializeLog(this.TAG, "isTimeToUpdate no availableversion installed, do start download ");
        AppMethodBeat.o(208968);
        return true;
      }
      XWalkEnvironment.addXWalkInitializeLog(this.TAG, " no availableversion but dis_update_immediately_when_no_xweb == true");
    }
    AppMethodBeat.o(208968);
    return false;
  }
  
  public String ze(boolean paramBoolean)
  {
    AppMethodBeat.i(208969);
    if (!paramBoolean) {}
    for (String str = a.mx("UPDATE_SPEED_CONFIG", "tools");; str = a.mx("UPDATE_FORWARD_SPEED_CONFIG", "tools"))
    {
      AppMethodBeat.o(208969);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.g
 * JD-Core Version:    0.7.0.1
 */