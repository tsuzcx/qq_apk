package com.tencent.xweb.xwalk.updater;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import com.tencent.xweb.ai;
import com.tencent.xweb.util.g;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkUpdater.UpdateConfig;

public class h
  extends c
{
  static
  {
    AppMethodBeat.i(195615);
    if (!h.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(195615);
      return;
    }
  }
  
  public static XWalkUpdater.UpdateConfig g(SchedulerConfig paramSchedulerConfig)
  {
    AppMethodBeat.i(195614);
    try
    {
      if (paramSchedulerConfig.MyT) {
        break label161;
      }
      if ((paramSchedulerConfig.Mys != null) && (!paramSchedulerConfig.Mys.isEmpty())) {
        break label128;
      }
      if (!$assertionsDisabled)
      {
        paramSchedulerConfig = new AssertionError("royle:no md5 info, maybe something wrong");
        AppMethodBeat.o(195614);
        throw paramSchedulerConfig;
      }
    }
    catch (Exception paramSchedulerConfig)
    {
      XWalkInitializer.addXWalkInitializeLog("create  UpdateConfig failed , args is not valid");
      c.gdu().e(null);
      AppMethodBeat.o(195614);
      return null;
    }
    XWalkUpdater.UpdateConfig localUpdateConfig = new XWalkUpdater.UpdateConfig(paramSchedulerConfig.Myl, false, paramSchedulerConfig.version, paramSchedulerConfig.strAbi, paramSchedulerConfig.nPatchTargetVersion);
    for (;;)
    {
      localUpdateConfig.versionDetail = paramSchedulerConfig.MyX;
      localUpdateConfig.bUseCdn = paramSchedulerConfig.bUseCdn;
      localUpdateConfig.bTryUseSharedCore = paramSchedulerConfig.bTryUseSharedCore;
      AppMethodBeat.o(195614);
      return localUpdateConfig;
      label128:
      localUpdateConfig = new XWalkUpdater.UpdateConfig(paramSchedulerConfig.Mys, false, null, paramSchedulerConfig.Myl, paramSchedulerConfig.version, paramSchedulerConfig.strAbi, paramSchedulerConfig.nPatchTargetVersion);
      continue;
      label161:
      if ((paramSchedulerConfig.Mys == null) || (paramSchedulerConfig.Mys.isEmpty()) || (paramSchedulerConfig.patchMd5 == null) || (paramSchedulerConfig.patchMd5.isEmpty()))
      {
        if (!$assertionsDisabled)
        {
          paramSchedulerConfig = new AssertionError("royle:no md5 info, maybe something wrong");
          AppMethodBeat.o(195614);
          throw paramSchedulerConfig;
        }
        localUpdateConfig = new XWalkUpdater.UpdateConfig(paramSchedulerConfig.Myl, true, paramSchedulerConfig.version, paramSchedulerConfig.strAbi, paramSchedulerConfig.nPatchTargetVersion);
      }
      else
      {
        localUpdateConfig = new XWalkUpdater.UpdateConfig(paramSchedulerConfig.patchMd5, true, paramSchedulerConfig.Mys, paramSchedulerConfig.Myl, paramSchedulerConfig.version, paramSchedulerConfig.strAbi, paramSchedulerConfig.nPatchTargetVersion);
      }
    }
  }
  
  public final SchedulerConfig a(a.b paramb)
  {
    AppMethodBeat.i(195613);
    if (paramb == null)
    {
      AppMethodBeat.o(195613);
      return null;
    }
    Log.i("Scheduler", "onConfigDownLoaded get config ,config version is " + paramb.Myx);
    if ((ai.gbp()) && (!XWalkEnvironment.isInTestMode()))
    {
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "it's gp version , dont down load any runtime version");
      AppMethodBeat.o(195613);
      return null;
    }
    SchedulerConfig localSchedulerConfig = gdH();
    if ((localSchedulerConfig != null) && (!TextUtils.isEmpty(paramb.Myx)) && (!paramb.Myx.equals(localSchedulerConfig.Myx)))
    {
      localSchedulerConfig = d.a(paramb, XWalkEnvironment.getRuntimeAbi());
      String str = a.mV("pre_down_abi", "tools");
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "predown load abi is ".concat(String.valueOf(str)));
      if ((TextUtils.isEmpty(str)) || (str.equalsIgnoreCase(XWalkEnvironment.getRuntimeAbi()))) {
        break label325;
      }
      paramb = d.a(paramb, str);
      if (paramb != null) {
        g.t(577L, 240L, 1L);
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
          g.t(577L, 236L, 1L);
        }
        for (;;)
        {
          AppMethodBeat.o(195613);
          return localSchedulerConfig;
          if (paramb == null) {
            break label320;
          }
          XWalkInitializer.addXWalkInitializeLog(this.TAG, "use pre down load abi schedule:" + paramb.version);
          i = 1;
          break;
          label288:
          if ("arm64-v8a".equalsIgnoreCase(paramb.strAbi)) {
            g.t(577L, 237L, 1L);
          }
        }
        AppMethodBeat.o(195613);
        return null;
        label320:
        paramb = null;
      }
      label325:
      paramb = null;
    }
  }
  
  public String gdd()
  {
    return "XWebCore";
  }
  
  public boolean gdy()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(195610);
        if (!super.gdy())
        {
          AppMethodBeat.o(195610);
          return bool;
        }
        if (gdH().version <= XWalkEnvironment.getInstalledNewstVersion(gdH().strAbi))
        {
          AppMethodBeat.o(195610);
          continue;
        }
        bool = true;
      }
      finally {}
      AppMethodBeat.o(195610);
    }
  }
  
  protected final boolean gdz()
  {
    AppMethodBeat.i(195611);
    if (!XWalkEnvironment.hasInstalledAvailableVersion())
    {
      if (!"true".equalsIgnoreCase(a.mV("dis_update_immediately_when_no_xweb", "tools")))
      {
        if (c.gdu().gdH().MyY > 0)
        {
          XWalkEnvironment.addXWalkInitializeLog(this.TAG, " failed update before , do not force update ");
          if (!"true".equalsIgnoreCase(a.mV("allow_failed_schedule_force_update", "tools")))
          {
            AppMethodBeat.o(195611);
            return false;
          }
        }
        XWalkEnvironment.addXWalkInitializeLog(this.TAG, "isTimeToUpdate no availableversion installed, do start download ");
        AppMethodBeat.o(195611);
        return true;
      }
      XWalkEnvironment.addXWalkInitializeLog(this.TAG, " no availableversion but dis_update_immediately_when_no_xweb == true");
    }
    AppMethodBeat.o(195611);
    return false;
  }
  
  protected final String zR(boolean paramBoolean)
  {
    AppMethodBeat.i(195612);
    if (!paramBoolean) {}
    for (String str = a.mV("UPDATE_SPEED_CONFIG", "tools");; str = a.mV("UPDATE_FORWARD_SPEED_CONFIG", "tools"))
    {
      AppMethodBeat.o(195612);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.h
 * JD-Core Version:    0.7.0.1
 */