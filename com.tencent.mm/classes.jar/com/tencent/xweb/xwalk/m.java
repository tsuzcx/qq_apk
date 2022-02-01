package com.tencent.xweb.xwalk;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.a;
import com.tencent.xweb.internal.f;
import com.tencent.xweb.l;
import org.xwalk.core.Log;
import org.xwalk.core.ReflectMethod;
import org.xwalk.core.XWalkCoreWrapper;

public final class m
  implements f
{
  private boolean IUt;
  
  public final l frL()
  {
    AppMethodBeat.i(183742);
    r localr = r.a.ftc();
    AppMethodBeat.o(183742);
    return localr;
  }
  
  public final void frM()
  {
    AppMethodBeat.i(183743);
    Object localObject1;
    int j;
    Object localObject2;
    if (!this.IUt)
    {
      localObject1 = a.aOL(WebView.getCurStrModule());
      j = a.aOK(WebView.getCurStrModule());
      localObject2 = a.lW("enableWindowPerformanceSampleRatio", WebView.getCurStrModule());
    }
    try
    {
      i = Integer.parseInt((String)localObject2);
      r.a.ftc();
      Log.d("XWalkExtensionInternal", "setProfileConfig with enabledTraceCategory: " + (String)localObject1 + " traceSampleRatio: " + j + " enableWindowPerformanceSampleRatio: " + i);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("enabledTraceCategory", (String)localObject1);
      ((Bundle)localObject2).putInt("traceSampleRatio", j);
      ((Bundle)localObject2).putInt("enableWindowPerformanceSampleRatio", i);
      if (XWalkCoreWrapper.getInstance().hasFeature(4))
      {
        Log.d("XWebProfilerController", "setProfileConfig via INTERNAL_XPROFILE_NG");
        XWalkCoreWrapper.invokeRuntimeChannel(80012, new Object[] { localObject2 });
        this.IUt = true;
        AppMethodBeat.o(183743);
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        int i = 0;
        continue;
        if (XWalkCoreWrapper.getInstance().hasFeature(0)) {
          try
          {
            localObject1 = XWalkCoreWrapper.getInstance().getClass("com.tencent.xweb.xprofile.XProfileManager");
            if (localObject1 != null) {
              new ReflectMethod((Class)localObject1, "setProfileConfig", new Class[] { Bundle.class }).invoke(new Object[] { localNumberFormatException });
            }
          }
          catch (Exception localException)
          {
            Log.e("XWebProfilerController", "setProfileConfig reflect failed");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.m
 * JD-Core Version:    0.7.0.1
 */