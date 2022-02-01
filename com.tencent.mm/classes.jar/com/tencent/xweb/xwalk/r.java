package com.tencent.xweb.xwalk;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.m;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import com.tencent.xweb.pinus.sdk.PSCoreWrapper;
import com.tencent.xweb.util.l;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.xwalk.core.Log;
import org.xwalk.core.ReflectMethod;
import org.xwalk.core.XWalkCoreWrapper;

public final class r
  implements o
{
  public ConcurrentMap<String, m> aipA;
  public n aipB;
  private ReflectMethod aipC;
  private ReflectMethod aipD;
  
  private r()
  {
    AppMethodBeat.i(183747);
    this.aipA = new ConcurrentHashMap();
    AppMethodBeat.o(183747);
  }
  
  private static boolean aV(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(183746);
    if (XWalkCoreWrapper.getInstance() != null)
    {
      paramString = XWalkCoreWrapper.invokeRuntimeChannel(80013, new Object[] { Boolean.valueOf(paramBoolean), paramString });
      if (((paramString instanceof Boolean)) && (((Boolean)paramString).booleanValue()))
      {
        AppMethodBeat.o(183746);
        return true;
      }
      AppMethodBeat.o(183746);
      return false;
    }
    if (PSCoreWrapper.getInstance() != null)
    {
      paramString = PSCoreWrapper.invokeRuntimeChannel(80013, new Object[] { Boolean.valueOf(paramBoolean), paramString });
      if (((paramString instanceof Boolean)) && (((Boolean)paramString).booleanValue()))
      {
        AppMethodBeat.o(183746);
        return true;
      }
      AppMethodBeat.o(183746);
      return false;
    }
    AppMethodBeat.o(183746);
    return false;
  }
  
  public static void e(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(212813);
    Bundle localBundle = new Bundle();
    localBundle.putString("enabledTraceCategory", paramString);
    localBundle.putInt("traceSampleRatio", paramInt1);
    localBundle.putInt("enableWindowPerformanceSampleRatio", paramInt2);
    localBundle.putBoolean("forceUpdateEnabledCategory", paramBoolean);
    if (XWalkCoreWrapper.getInstance() != null)
    {
      if (!XWalkCoreWrapper.getInstance().hasFeature(4)) {
        break label128;
      }
      Log.d("XWebProfilerController", "setProfileConfig via INTERNAL_XPROFILE_NG");
      XWalkCoreWrapper.invokeRuntimeChannel(80012, new Object[] { localBundle });
    }
    for (;;)
    {
      if (PSCoreWrapper.getInstance() != null) {
        if (PSCoreWrapper.getInstance().hasFeature(4))
        {
          Log.d("XWebProfilerController", "setProfileConfig via INTERNAL_XPROFILE_NG");
          PSCoreWrapper.invokeRuntimeChannel(80012, new Object[] { localBundle });
          AppMethodBeat.o(212813);
          return;
          label128:
          if (XWalkCoreWrapper.getInstance().hasFeature(0)) {
            try
            {
              paramString = XWalkCoreWrapper.getInstance().getClass("com.tencent.xweb.xprofile.XProfileManager");
              if (paramString == null)
              {
                AppMethodBeat.o(212813);
                return;
              }
              new ReflectMethod(paramString, "setProfileConfig", new Class[] { Bundle.class }).invoke(new Object[] { localBundle });
              continue;
            }
            finally
            {
              Log.e("XWebProfilerController", "setProfileConfig reflect failed, error:".concat(String.valueOf(paramString)));
            }
          }
        }
        else if (PSCoreWrapper.getInstance().hasFeature(0))
        {
          try
          {
            paramString = PSCoreWrapper.getInstance().getClass("com.tencent.xweb.xprofile.XProfileManager");
            if (paramString == null)
            {
              AppMethodBeat.o(212813);
              return;
            }
            new ReflectMethod(paramString, "setProfileConfig", new Class[] { Bundle.class }).invoke(new Object[] { localBundle });
            AppMethodBeat.o(212813);
            return;
          }
          finally
          {
            Log.e("XWebProfilerController", "setProfileConfig reflect failed, error:".concat(String.valueOf(paramString)));
          }
        }
      }
    }
    AppMethodBeat.o(212813);
  }
  
  public final void a(n paramn)
  {
    AppMethodBeat.i(154503);
    if (XWalkCoreWrapper.getInstance().hasFeature(1030)) {
      try
      {
        if (this.aipD == null)
        {
          Class localClass = XWalkCoreWrapper.getInstance().getClass("com.tencent.xweb.xprofile.XProfileManager");
          if (localClass == null)
          {
            AppMethodBeat.o(154503);
            return;
          }
          this.aipD = new ReflectMethod(localClass, "manualStopProfile", new Class[] { Integer.TYPE });
        }
        this.aipB = paramn;
        this.aipD.invoke(new Object[] { Integer.valueOf(0) });
        AppMethodBeat.o(154503);
        return;
      }
      finally
      {
        Log.e("XWebProfilerController", "manualStopTracingProfileUsingConfig reflect failed, error:".concat(String.valueOf(paramn)));
      }
    }
    AppMethodBeat.o(154503);
  }
  
  public final void bHB(String paramString)
  {
    AppMethodBeat.i(154502);
    if (XWalkCoreWrapper.getInstance().hasFeature(1030)) {
      try
      {
        if (this.aipC == null)
        {
          localObject = XWalkCoreWrapper.getInstance().getClass("com.tencent.xweb.xprofile.XProfileManager");
          if (localObject == null)
          {
            AppMethodBeat.o(154502);
            return;
          }
          this.aipC = new ReflectMethod((Class)localObject, "manualStartProfile", new Class[] { Integer.TYPE, Bundle.class });
        }
        Object localObject = new Bundle();
        ((Bundle)localObject).putString("enabledTraceCategory", paramString);
        ((Bundle)localObject).putInt("traceSampleRatio", 10000);
        this.aipC.invoke(new Object[] { Integer.valueOf(0), localObject });
        AppMethodBeat.o(154502);
        return;
      }
      finally
      {
        Log.e("XWebProfilerController", "manualStartTracingProfileUsingConfig reflect failed, error:".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(154502);
  }
  
  public final void forceEnableFrameCostProfile(boolean paramBoolean)
  {
    AppMethodBeat.i(212835);
    if (paramBoolean)
    {
      l.khO();
      e("xprofile.frameCost", 10000, 0, true);
      AppMethodBeat.o(212835);
      return;
    }
    l.khP();
    e("xprofile.frameCost_Disable_FromClient", 10000, 0, true);
    AppMethodBeat.o(212835);
  }
  
  public final void forceFlushCategory(String paramString)
  {
    AppMethodBeat.i(212838);
    if (XWalkCoreWrapper.getInstance() != null) {
      XWalkCoreWrapper.invokeRuntimeChannel(80016, new Object[] { paramString });
    }
    if (PSCoreWrapper.getInstance() != null) {
      PSCoreWrapper.invokeRuntimeChannel(80016, new Object[] { paramString });
    }
    AppMethodBeat.o(212838);
  }
  
  public final void setAllKindsFpsProfileEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(212843);
    if (paramBoolean) {
      l.khQ();
    }
    for (;;)
    {
      if (XWalkCoreWrapper.getInstance() != null) {
        XWalkCoreWrapper.invokeRuntimeChannel(80017, new Object[] { Boolean.valueOf(paramBoolean) });
      }
      if (PSCoreWrapper.getInstance() != null) {
        PSCoreWrapper.invokeRuntimeChannel(80017, new Object[] { Boolean.valueOf(paramBoolean) });
      }
      AppMethodBeat.o(212843);
      return;
      l.khR();
    }
  }
  
  public final boolean setProfileResultCallback(String paramString, m paramm)
  {
    AppMethodBeat.i(183745);
    if (paramm == null)
    {
      if (this.aipA.containsKey(paramString))
      {
        this.aipA.remove(paramString);
        aV(false, paramString);
        AppMethodBeat.o(183745);
        return true;
      }
      AppMethodBeat.o(183745);
      return false;
    }
    if ((!this.aipA.containsKey(paramString)) && (!aV(true, paramString)))
    {
      AppMethodBeat.o(183745);
      return false;
    }
    this.aipA.put(paramString, paramm);
    AppMethodBeat.o(183745);
    return true;
  }
  
  public static final class a
  {
    private static final r aipE;
    
    static
    {
      AppMethodBeat.i(154500);
      aipE = new r((byte)0);
      AppMethodBeat.o(154500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.r
 * JD-Core Version:    0.7.0.1
 */