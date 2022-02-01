package com.tencent.xweb.xwalk.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import com.tencent.xweb.util.h;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

public final class j
  extends k
{
  static j aalq;
  
  public static k izU()
  {
    AppMethodBeat.i(208180);
    if (aalq == null) {
      aalq = new j();
    }
    j localj = aalq;
    AppMethodBeat.o(208180);
    return localj;
  }
  
  public final d a(a.b paramb)
  {
    AppMethodBeat.i(208184);
    Object localObject;
    if (paramb != null)
    {
      localObject = a.oO("pre_down_abi", "tools");
      XWalkInitializer.addXWalkInitializeLog(this.TAG, "predown load abi is ".concat(String.valueOf(localObject)));
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).equalsIgnoreCase(XWalkEnvironment.getRuntimeAbi()))) {
        break label180;
      }
      paramb = e.a(paramb, (String)localObject);
      if (paramb != null) {
        h.u(577L, 240L, 1L);
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
        h.u(577L, 236L, 1L);
      }
      for (;;)
      {
        AppMethodBeat.o(208184);
        return localObject;
        label148:
        if ("arm64-v8a".equalsIgnoreCase(paramb.strAbi)) {
          h.u(577L, 237L, 1L);
        }
      }
      AppMethodBeat.o(208184);
      return null;
      label180:
      paramb = null;
    }
  }
  
  public final String iyV()
  {
    return "XWebCorePredown";
  }
  
  protected final boolean izx()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.b.j
 * JD-Core Version:    0.7.0.1
 */