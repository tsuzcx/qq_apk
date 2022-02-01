package com.tencent.xweb.xwalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import com.tencent.xweb.ak;
import com.tencent.xweb.util.h;
import com.tencent.xweb.xwalk.XWalkUpdater.UpdateConfig;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

public class k
  extends c
{
  static k aalr;
  
  static
  {
    AppMethodBeat.i(205028);
    if (!k.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(205028);
      return;
    }
  }
  
  public static k izV()
  {
    AppMethodBeat.i(205017);
    if (aalr == null) {
      aalr = new k();
    }
    k localk = aalr;
    AppMethodBeat.o(205017);
    return localk;
  }
  
  protected final String IX(boolean paramBoolean)
  {
    AppMethodBeat.i(205023);
    if (!paramBoolean) {}
    for (String str = a.oO("UPDATE_SPEED_CONFIG", "tools");; str = a.oO("UPDATE_FORWARD_SPEED_CONFIG", "tools"))
    {
      AppMethodBeat.o(205023);
      return str;
    }
  }
  
  public d a(a.b paramb)
  {
    AppMethodBeat.i(205025);
    if (paramb == null)
    {
      AppMethodBeat.o(205025);
      return null;
    }
    Log.i("Scheduler", "onConfigDownLoaded get config ,config version is " + paramb.aakB);
    h.ea(paramb.aakB, true);
    if ((ak.iwQ()) && (!XWalkEnvironment.isInTestMode()))
    {
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "it's gp version , dont down load any runtime version");
      AppMethodBeat.o(205025);
      return null;
    }
    izG();
    paramb = d(e.a(paramb, XWalkEnvironment.getRuntimeAbi()));
    AppMethodBeat.o(205025);
    return paramb;
  }
  
  public final XWalkUpdater.UpdateConfig f(d paramd)
  {
    AppMethodBeat.i(205026);
    try
    {
      if (paramd.aakU) {
        break label159;
      }
      if ((paramd.aakv != null) && (!paramd.aakv.isEmpty())) {
        break label126;
      }
      if (!$assertionsDisabled)
      {
        paramd = new AssertionError("royle:no md5 info, maybe something wrong");
        AppMethodBeat.o(205026);
        throw paramd;
      }
    }
    catch (Exception paramd)
    {
      XWalkInitializer.addXWalkInitializeLog("create  UpdateConfig failed , args is not valid");
      AppMethodBeat.o(205026);
      return null;
    }
    XWalkUpdater.UpdateConfig localUpdateConfig = new XWalkUpdater.UpdateConfig(paramd.aako, false, paramd.version, paramd.strAbi, paramd.aajt);
    for (;;)
    {
      localUpdateConfig.aajw = paramd.aakY;
      localUpdateConfig.aajx = paramd.aajx;
      localUpdateConfig.aajy = paramd.aajy;
      localUpdateConfig.aajp = this;
      AppMethodBeat.o(205026);
      return localUpdateConfig;
      label126:
      localUpdateConfig = new XWalkUpdater.UpdateConfig(paramd.aakv, false, null, paramd.aako, paramd.version, paramd.strAbi, paramd.aajt);
      continue;
      label159:
      if ((paramd.aakv == null) || (paramd.aakv.isEmpty()) || (paramd.patchMd5 == null) || (paramd.patchMd5.isEmpty()))
      {
        if (!$assertionsDisabled)
        {
          paramd = new AssertionError("royle:no md5 info, maybe something wrong");
          AppMethodBeat.o(205026);
          throw paramd;
        }
        localUpdateConfig = new XWalkUpdater.UpdateConfig(paramd.aako, true, paramd.version, paramd.strAbi, paramd.aajt);
      }
      else
      {
        localUpdateConfig = new XWalkUpdater.UpdateConfig(paramd.patchMd5, true, paramd.aakv, paramd.aako, paramd.version, paramd.strAbi, paramd.aajt);
      }
    }
  }
  
  public String iyV()
  {
    return "XWebCore";
  }
  
  public boolean izw()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(205019);
        if (!super.izw())
        {
          AppMethodBeat.o(205019);
          return bool;
        }
        if (izG().version <= XWalkEnvironment.getInstalledNewstVersion(izG().strAbi))
        {
          AppMethodBeat.o(205019);
          continue;
        }
        bool = true;
      }
      finally {}
      AppMethodBeat.o(205019);
    }
  }
  
  protected boolean izx()
  {
    AppMethodBeat.i(205021);
    if (!XWalkEnvironment.hasInstalledAvailableVersion())
    {
      if (!"true".equalsIgnoreCase(a.oO("dis_update_immediately_when_no_xweb", "tools")))
      {
        if (izG().aakZ > 0)
        {
          XWalkEnvironment.addXWalkInitializeLog(this.TAG, " failed update before , do not force update ");
          if (!"true".equalsIgnoreCase(a.oO("allow_failed_schedule_force_update", "tools")))
          {
            AppMethodBeat.o(205021);
            return false;
          }
        }
        XWalkEnvironment.addXWalkInitializeLog(this.TAG, "isTimeToUpdate no availableversion installed, do start download ");
        AppMethodBeat.o(205021);
        return true;
      }
      XWalkEnvironment.addXWalkInitializeLog(this.TAG, " no availableversion but dis_update_immediately_when_no_xweb == true");
    }
    AppMethodBeat.o(205021);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.b.k
 * JD-Core Version:    0.7.0.1
 */