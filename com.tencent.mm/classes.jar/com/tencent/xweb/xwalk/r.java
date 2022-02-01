package com.tencent.xweb.xwalk;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.j;
import com.tencent.xweb.k;
import com.tencent.xweb.l;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.xwalk.core.Log;
import org.xwalk.core.ReflectMethod;
import org.xwalk.core.XWalkCoreWrapper;

public final class r
  implements l
{
  public k IUA;
  private ReflectMethod IUB;
  private ReflectMethod IUC;
  public ConcurrentMap<String, j> IUz;
  
  private r()
  {
    AppMethodBeat.i(183747);
    this.IUz = new ConcurrentHashMap();
    AppMethodBeat.o(183747);
  }
  
  private static boolean I(boolean paramBoolean, String paramString)
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
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(154503);
    if (XWalkCoreWrapper.getInstance().hasFeature(1030)) {
      try
      {
        if (this.IUC == null)
        {
          Class localClass = XWalkCoreWrapper.getInstance().getClass("com.tencent.xweb.xprofile.XProfileManager");
          if (localClass == null)
          {
            AppMethodBeat.o(154503);
            return;
          }
          this.IUC = new ReflectMethod(localClass, "manualStopProfile", new Class[] { Integer.TYPE });
        }
        this.IUA = paramk;
        this.IUC.invoke(new Object[] { Integer.valueOf(0) });
        AppMethodBeat.o(154503);
        return;
      }
      catch (Exception paramk)
      {
        Log.e("XWebProfilerController", "manualStartOrStopTracingProfileUsingConfig reflect failed");
      }
    }
    AppMethodBeat.o(154503);
  }
  
  public final void aOY(String paramString)
  {
    AppMethodBeat.i(154502);
    if (XWalkCoreWrapper.getInstance().hasFeature(1030)) {
      try
      {
        if (this.IUB == null)
        {
          localObject = XWalkCoreWrapper.getInstance().getClass("com.tencent.xweb.xprofile.XProfileManager");
          if (localObject == null)
          {
            AppMethodBeat.o(154502);
            return;
          }
          this.IUB = new ReflectMethod((Class)localObject, "manualStartProfile", new Class[] { Integer.TYPE, Bundle.class });
        }
        Object localObject = new Bundle();
        ((Bundle)localObject).putString("enabledTraceCategory", paramString);
        ((Bundle)localObject).putInt("traceSampleRatio", 10000);
        this.IUB.invoke(new Object[] { Integer.valueOf(0), localObject });
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
  
  public final boolean setProfileResultCallback(String paramString, j paramj)
  {
    AppMethodBeat.i(183745);
    if (paramj == null)
    {
      if (this.IUz.containsKey(paramString))
      {
        this.IUz.remove(paramString);
        I(false, paramString);
        AppMethodBeat.o(183745);
        return true;
      }
      AppMethodBeat.o(183745);
      return false;
    }
    if ((!this.IUz.containsKey(paramString)) && (!I(true, paramString)))
    {
      AppMethodBeat.o(183745);
      return false;
    }
    this.IUz.put(paramString, paramj);
    AppMethodBeat.o(183745);
    return true;
  }
  
  public static final class a
  {
    private static final r IUD;
    
    static
    {
      AppMethodBeat.i(154500);
      IUD = new r((byte)0);
      AppMethodBeat.o(154500);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.r
 * JD-Core Version:    0.7.0.1
 */