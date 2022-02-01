package com.tencent.xweb.xwalk.updater;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import com.tencent.xweb.ak;
import com.tencent.xweb.internal.b.c;
import com.tencent.xweb.util.b;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class n
  extends c
{
  private static n aird;
  
  static
  {
    AppMethodBeat.i(213005);
    if (!n.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      AppMethodBeat.o(213005);
      return;
    }
  }
  
  public static n kkq()
  {
    AppMethodBeat.i(212995);
    if (aird == null) {
      aird = new n();
    }
    n localn = aird;
    AppMethodBeat.o(212995);
    return localn;
  }
  
  protected final String Pd(boolean paramBoolean)
  {
    AppMethodBeat.i(213022);
    if (!paramBoolean) {}
    for (String str = a.keX().qM("UPDATE_SPEED_CONFIG", "tools");; str = a.keX().qM("UPDATE_FORWARD_SPEED_CONFIG", "tools"))
    {
      AppMethodBeat.o(213022);
      return str;
    }
  }
  
  public d a(b.c paramc)
  {
    AppMethodBeat.i(213026);
    if (paramc == null)
    {
      AppMethodBeat.o(213026);
      return null;
    }
    XWalkEnvironment.addXWalkInitializeLog(this.TAG, "onConfigDownLoaded, config version:" + paramc.aiiU + ", runtime abi:" + b.khw());
    if ((ak.kgd()) && (!XWalkEnvironment.isInTestMode()))
    {
      XWalkEnvironment.addXWalkInitializeLog(this.TAG, "onConfigDownLoaded, forbid download code");
      AppMethodBeat.o(213026);
      return null;
    }
    paramc = d(new e().a(paramc, b.khw(), this));
    if (paramc != null) {
      XWalkEnvironment.addXWalkInitializeLog(this.TAG, "onConfigDownLoaded, download version:" + paramc.version);
    }
    AppMethodBeat.o(213026);
    return paramc;
  }
  
  public final UpdateConfig f(d paramd)
  {
    AppMethodBeat.i(213032);
    try
    {
      if (paramd.aiqx) {
        break label170;
      }
      if ((paramd.aiiJ != null) && (!paramd.aiiJ.isEmpty())) {
        break label137;
      }
      if (!$assertionsDisabled)
      {
        paramd = new AssertionError("royle:no md5 info, maybe something wrong");
        AppMethodBeat.o(213032);
        throw paramd;
      }
    }
    finally
    {
      XWalkEnvironment.addXWalkInitializeLog(this.TAG, "getUpdateConfig error:".concat(String.valueOf(paramd)));
      AppMethodBeat.o(213032);
      return null;
    }
    UpdateConfig localUpdateConfig = new UpdateConfig(paramd.aiiC, false, paramd.version, paramd.strAbi, paramd.aiqy);
    for (;;)
    {
      localUpdateConfig.aiqO = paramd.aiqC;
      localUpdateConfig.aiiL = paramd.aiiL;
      localUpdateConfig.aijL = paramd.aijL;
      localUpdateConfig.aiqI = this;
      AppMethodBeat.o(213032);
      return localUpdateConfig;
      label137:
      localUpdateConfig = new UpdateConfig(paramd.aiiJ, false, null, paramd.aiiC, paramd.version, paramd.strAbi, paramd.aiqy);
      continue;
      label170:
      if ((paramd.aiiJ == null) || (paramd.aiiJ.isEmpty()) || (paramd.patchMd5 == null) || (paramd.patchMd5.isEmpty()))
      {
        if (!$assertionsDisabled)
        {
          paramd = new AssertionError("royle:no md5 info, maybe something wrong");
          AppMethodBeat.o(213032);
          throw paramd;
        }
        localUpdateConfig = new UpdateConfig(paramd.aiiC, true, paramd.version, paramd.strAbi, paramd.aiqy);
      }
      else
      {
        localUpdateConfig = new UpdateConfig(paramd.patchMd5, true, paramd.aiiJ, paramd.aiiC, paramd.version, paramd.strAbi, paramd.aiqy);
      }
    }
  }
  
  public boolean kjQ()
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(213012);
        if (!super.kjQ())
        {
          AppMethodBeat.o(213012);
          return bool;
        }
        if (kjY().version <= XWalkEnvironment.getInstalledNewstVersion(kjY().strAbi))
        {
          Log.w(this.TAG, "hasScheduler, scheduler config version lower than current version");
          AppMethodBeat.o(213012);
          continue;
        }
        bool = true;
      }
      finally {}
      AppMethodBeat.o(213012);
    }
  }
  
  public String kjo()
  {
    return "XWebCore";
  }
  
  protected boolean kkb()
  {
    AppMethodBeat.i(213018);
    if (!XWalkEnvironment.hasInstalledAvailableVersion())
    {
      if (!"true".equalsIgnoreCase(a.keX().qM("dis_update_immediately_when_no_xweb", "tools")))
      {
        if (kjY().aiqD > 0)
        {
          XWalkEnvironment.addXWalkInitializeLog(this.TAG, "needForceUpdate, update failed before, do not force update");
          if (!"true".equalsIgnoreCase(a.keX().qM("allow_failed_schedule_force_update", "tools")))
          {
            AppMethodBeat.o(213018);
            return false;
          }
        }
        XWalkEnvironment.addXWalkInitializeLog(this.TAG, "needForceUpdate, no availableVersion installed, do start download");
        AppMethodBeat.o(213018);
        return true;
      }
      XWalkEnvironment.addXWalkInitializeLog(this.TAG, "needForceUpdate, no availableVersion but dis_update_immediately_when_no_xweb is true");
    }
    AppMethodBeat.o(213018);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.n
 * JD-Core Version:    0.7.0.1
 */