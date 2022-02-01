package com.tencent.xweb.xwalk.updater;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import com.tencent.xweb.util.h;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

public final class i
  extends XWebCoreScheduler
{
  static i SJx;
  
  public static XWebCoreScheduler hvV()
  {
    AppMethodBeat.i(207373);
    if (SJx == null) {
      SJx = new i();
    }
    i locali = SJx;
    AppMethodBeat.o(207373);
    return locali;
  }
  
  public final c a(a.b paramb)
  {
    AppMethodBeat.i(207374);
    Object localObject;
    if (paramb != null)
    {
      localObject = a.nS("pre_down_abi", "tools");
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "predown load abi is ".concat(String.valueOf(localObject)));
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).equalsIgnoreCase(XWalkEnvironment.getRuntimeAbi()))) {
        break label180;
      }
      paramb = d.a(paramb, (String)localObject);
      if (paramb != null) {
        h.s(577L, 240L, 1L);
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
        h.s(577L, 236L, 1L);
      }
      for (;;)
      {
        AppMethodBeat.o(207374);
        return localObject;
        label148:
        if ("arm64-v8a".equalsIgnoreCase(paramb.strAbi)) {
          h.s(577L, 237L, 1L);
        }
      }
      AppMethodBeat.o(207374);
      return null;
      label180:
      paramb = null;
    }
  }
  
  protected final boolean hvA()
  {
    return false;
  }
  
  public final String hvc()
  {
    return "XWebCorePredown";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.i
 * JD-Core Version:    0.7.0.1
 */