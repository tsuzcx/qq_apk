package com.tencent.xweb.xwalk;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.k;
import com.tencent.xweb.l;
import com.tencent.xweb.m;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.xwalk.core.Log;
import org.xwalk.core.ReflectMethod;
import org.xwalk.core.XWalkCoreWrapper;

public final class s
  implements m
{
  public ConcurrentMap<String, k> SHM;
  public l SHN;
  private ReflectMethod SHO;
  private ReflectMethod SHP;
  
  private s()
  {
    AppMethodBeat.i(183747);
    this.SHM = new ConcurrentHashMap();
    AppMethodBeat.o(183747);
  }
  
  private static boolean U(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(183746);
    paramString = XWalkCoreWrapper.invokeRuntimeChannel(80013, new Object[] { Boolean.valueOf(paramBoolean), paramString });
    if (((paramString instanceof Boolean)) && (((Boolean)paramString).booleanValue()))
    {
      AppMethodBeat.o(183746);
      return true;
    }
    AppMethodBeat.o(183746);
    return false;
  }
  
  public static void bb(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207327);
    Bundle localBundle = new Bundle();
    localBundle.putString("enabledTraceCategory", paramString);
    localBundle.putInt("traceSampleRatio", paramInt1);
    localBundle.putInt("enableWindowPerformanceSampleRatio", paramInt2);
    if (XWalkCoreWrapper.getInstance().hasFeature(4))
    {
      Log.d("XWebProfilerController", "setProfileConfig via INTERNAL_XPROFILE_NG");
      XWalkCoreWrapper.invokeRuntimeChannel(80012, new Object[] { localBundle });
      AppMethodBeat.o(207327);
      return;
    }
    if (XWalkCoreWrapper.getInstance().hasFeature(0)) {
      try
      {
        paramString = XWalkCoreWrapper.getInstance().getClass("com.tencent.xweb.xprofile.XProfileManager");
        if (paramString == null)
        {
          AppMethodBeat.o(207327);
          return;
        }
        new ReflectMethod(paramString, "setProfileConfig", new Class[] { Bundle.class }).invoke(new Object[] { localBundle });
        AppMethodBeat.o(207327);
        return;
      }
      catch (Exception paramString)
      {
        Log.e("XWebProfilerController", "setProfileConfig reflect failed");
      }
    }
    AppMethodBeat.o(207327);
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(154503);
    if (XWalkCoreWrapper.getInstance().hasFeature(1030)) {
      try
      {
        if (this.SHP == null)
        {
          Class localClass = XWalkCoreWrapper.getInstance().getClass("com.tencent.xweb.xprofile.XProfileManager");
          if (localClass == null)
          {
            AppMethodBeat.o(154503);
            return;
          }
          this.SHP = new ReflectMethod(localClass, "manualStopProfile", new Class[] { Integer.TYPE });
        }
        this.SHN = paraml;
        this.SHP.invoke(new Object[] { Integer.valueOf(0) });
        AppMethodBeat.o(154503);
        return;
      }
      catch (Exception paraml)
      {
        Log.e("XWebProfilerController", "manualStartOrStopTracingProfileUsingConfig reflect failed");
      }
    }
    AppMethodBeat.o(154503);
  }
  
  public final void bsg(String paramString)
  {
    AppMethodBeat.i(154502);
    if (XWalkCoreWrapper.getInstance().hasFeature(1030)) {
      try
      {
        if (this.SHO == null)
        {
          localObject = XWalkCoreWrapper.getInstance().getClass("com.tencent.xweb.xprofile.XProfileManager");
          if (localObject == null)
          {
            AppMethodBeat.o(154502);
            return;
          }
          this.SHO = new ReflectMethod((Class)localObject, "manualStartProfile", new Class[] { Integer.TYPE, Bundle.class });
        }
        Object localObject = new Bundle();
        ((Bundle)localObject).putString("enabledTraceCategory", paramString);
        ((Bundle)localObject).putInt("traceSampleRatio", 10000);
        this.SHO.invoke(new Object[] { Integer.valueOf(0), localObject });
        AppMethodBeat.o(154502);
        return;
      }
      catch (Exception paramString)
      {
        Log.e("XWebProfilerController", "manualStartOrStopTracingProfileUsingConfig reflect failed");
      }
    }
    AppMethodBeat.o(154502);
  }
  
  public final void forceEnableFrameCostProfile()
  {
    AppMethodBeat.i(207328);
    bb("xprofile.frameCost", 10000, 0);
    AppMethodBeat.o(207328);
  }
  
  public final boolean setProfileResultCallback(String paramString, k paramk)
  {
    AppMethodBeat.i(183745);
    if (paramk == null)
    {
      if (this.SHM.containsKey(paramString))
      {
        this.SHM.remove(paramString);
        U(false, paramString);
        AppMethodBeat.o(183745);
        return true;
      }
      AppMethodBeat.o(183745);
      return false;
    }
    if ((!this.SHM.containsKey(paramString)) && (!U(true, paramString)))
    {
      AppMethodBeat.o(183745);
      return false;
    }
    this.SHM.put(paramString, paramk);
    AppMethodBeat.o(183745);
    return true;
  }
  
  public static final class a
  {
    private static final s SHQ;
    
    static
    {
      AppMethodBeat.i(154500);
      SHQ = new s((byte)0);
      AppMethodBeat.o(154500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.s
 * JD-Core Version:    0.7.0.1
 */