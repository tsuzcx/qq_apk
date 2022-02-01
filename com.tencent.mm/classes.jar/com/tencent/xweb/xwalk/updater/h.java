package com.tencent.xweb.xwalk.updater;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import com.tencent.xweb.util.g;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

public final class h
  extends XWebCoreScheduler
{
  static h MWp;
  
  public static XWebCoreScheduler giv()
  {
    AppMethodBeat.i(207635);
    if (MWp == null) {
      MWp = new h();
    }
    h localh = MWp;
    AppMethodBeat.o(207635);
    return localh;
  }
  
  public final c a(a.b paramb)
  {
    AppMethodBeat.i(207636);
    Object localObject;
    if (paramb != null)
    {
      localObject = a.nb("pre_down_abi", "tools");
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "predown load abi is ".concat(String.valueOf(localObject)));
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).equalsIgnoreCase(XWalkEnvironment.getRuntimeAbi()))) {
        break label180;
      }
      paramb = d.a(paramb, (String)localObject);
      if (paramb != null) {
        g.t(577L, 240L, 1L);
      }
    }
    for (;;)
    {
      int i = 0;
      if (paramb != null)
      {
        XWalkInitializer.addXWalkInitializeLog(this.TAG, "use pre down load abi schedule:" + paramb.version);
        i = 1;
      }
      localObject = d(paramb);
      if ((i != 0) && (localObject == paramb))
      {
        if (!"armeabi-v7a".equalsIgnoreCase(paramb.strAbi)) {
          break label148;
        }
        g.t(577L, 236L, 1L);
      }
      for (;;)
      {
        AppMethodBeat.o(207636);
        return localObject;
        label148:
        if ("arm64-v8a".equalsIgnoreCase(paramb.strAbi)) {
          g.t(577L, 237L, 1L);
        }
      }
      AppMethodBeat.o(207636);
      return null;
      label180:
      paramb = null;
    }
  }
  
  public final String ghF()
  {
    return "XWebCorePredown";
  }
  
  protected final boolean gia()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.h
 * JD-Core Version:    0.7.0.1
 */