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
  public ConcurrentMap<String, k> KHb;
  public l KHc;
  private ReflectMethod KHd;
  private ReflectMethod KHe;
  
  private s()
  {
    AppMethodBeat.i(183747);
    this.KHb = new ConcurrentHashMap();
    AppMethodBeat.o(183747);
  }
  
  private static boolean J(boolean paramBoolean, String paramString)
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
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(154503);
    if (XWalkCoreWrapper.getInstance().hasFeature(1030)) {
      try
      {
        if (this.KHe == null)
        {
          Class localClass = XWalkCoreWrapper.getInstance().getClass("com.tencent.xweb.xprofile.XProfileManager");
          if (localClass == null)
          {
            AppMethodBeat.o(154503);
            return;
          }
          this.KHe = new ReflectMethod(localClass, "manualStopProfile", new Class[] { Integer.TYPE });
        }
        this.KHc = paraml;
        this.KHe.invoke(new Object[] { Integer.valueOf(0) });
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
  
  public final void aUR(String paramString)
  {
    AppMethodBeat.i(154502);
    if (XWalkCoreWrapper.getInstance().hasFeature(1030)) {
      try
      {
        if (this.KHd == null)
        {
          localObject = XWalkCoreWrapper.getInstance().getClass("com.tencent.xweb.xprofile.XProfileManager");
          if (localObject == null)
          {
            AppMethodBeat.o(154502);
            return;
          }
          this.KHd = new ReflectMethod((Class)localObject, "manualStartProfile", new Class[] { Integer.TYPE, Bundle.class });
        }
        Object localObject = new Bundle();
        ((Bundle)localObject).putString("enabledTraceCategory", paramString);
        ((Bundle)localObject).putInt("traceSampleRatio", 10000);
        this.KHd.invoke(new Object[] { Integer.valueOf(0), localObject });
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
  
  public final boolean setProfileResultCallback(String paramString, k paramk)
  {
    AppMethodBeat.i(183745);
    if (paramk == null)
    {
      if (this.KHb.containsKey(paramString))
      {
        this.KHb.remove(paramString);
        J(false, paramString);
        AppMethodBeat.o(183745);
        return true;
      }
      AppMethodBeat.o(183745);
      return false;
    }
    if ((!this.KHb.containsKey(paramString)) && (!J(true, paramString)))
    {
      AppMethodBeat.o(183745);
      return false;
    }
    this.KHb.put(paramString, paramk);
    AppMethodBeat.o(183745);
    return true;
  }
  
  public static final class a
  {
    private static final s KHf;
    
    static
    {
      AppMethodBeat.i(154500);
      KHf = new s((byte)0);
      AppMethodBeat.o(154500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.s
 * JD-Core Version:    0.7.0.1
 */