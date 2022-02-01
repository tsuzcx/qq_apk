package com.tencent.mm.recoveryv2;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class l
{
  private static volatile l ackQ;
  public j ackR;
  public final Map<String, d> ackS;
  public Context mContext;
  
  private l()
  {
    AppMethodBeat.i(237944);
    this.ackS = new HashMap();
    AppMethodBeat.o(237944);
  }
  
  public static l iRc()
  {
    AppMethodBeat.i(237936);
    if (ackQ == null) {}
    try
    {
      if (ackQ == null) {
        ackQ = new l();
      }
      l locall = ackQ;
      AppMethodBeat.o(237936);
      return locall;
    }
    finally
    {
      AppMethodBeat.o(237936);
    }
  }
  
  public static String iRe()
  {
    return ":recovery";
  }
  
  public static boolean lZ(Context paramContext)
  {
    AppMethodBeat.i(369568);
    boolean bool = k.a.cQ(paramContext, "");
    AppMethodBeat.o(369568);
    return bool;
  }
  
  public static boolean ma(Context paramContext)
  {
    AppMethodBeat.i(237957);
    boolean bool = k.a.cQ(paramContext, ":recovery");
    AppMethodBeat.o(237957);
    return bool;
  }
  
  public static boolean mb(Context paramContext)
  {
    AppMethodBeat.i(237972);
    Object localObject1 = (ActivityManager)paramContext.getSystemService("activity");
    boolean bool1;
    if (localObject1 != null)
    {
      localObject1 = ((ActivityManager)localObject1).getRunningTasks(2147483647);
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject3 = (ActivityManager.RunningTaskInfo)((Iterator)localObject1).next();
          if (((ActivityManager.RunningTaskInfo)localObject3).numActivities > 0)
          {
            Object localObject2 = paramContext.getPackageName();
            localObject3 = ((ActivityManager.RunningTaskInfo)localObject3).topActivity;
            if ((localObject3 != null) && (((String)localObject2).equals(((ComponentName)localObject3).getPackageName())))
            {
              bool1 = true;
              localObject1 = (ActivityManager)paramContext.getSystemService("activity");
              if (localObject1 == null) {
                break label246;
              }
              localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses().iterator();
              do
              {
                do
                {
                  if (!((Iterator)localObject1).hasNext()) {
                    break;
                  }
                  localObject2 = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
                } while (!((ActivityManager.RunningAppProcessInfo)localObject2).processName.startsWith(paramContext.getPackageName()));
                k.b.a.log(5, "MicroMsg.recovery.utils", "app importance = " + ((ActivityManager.RunningAppProcessInfo)localObject2).importance);
              } while (((ActivityManager.RunningAppProcessInfo)localObject2).importance > 100);
            }
          }
        }
      }
    }
    label246:
    for (boolean bool2 = true;; bool2 = false)
    {
      k.b.a.log(5, "MicroMsg.recovery", "isTopActivity = " + bool1 + ", appImportanceForeground = " + bool2);
      if ((!bool1) || (!bool2)) {
        break label251;
      }
      AppMethodBeat.o(237972);
      return true;
      bool1 = false;
      break;
    }
    label251:
    AppMethodBeat.o(237972);
    return false;
  }
  
  public final void a(String paramString, d paramd)
  {
    AppMethodBeat.i(238011);
    try
    {
      if (this.ackS.containsKey(paramString))
      {
        paramString = new IllegalArgumentException(paramString + " has been registered! target = " + this.ackS.get(paramString));
        AppMethodBeat.o(238011);
        throw paramString;
      }
    }
    finally
    {
      k.b.w("MicroMsg.recovery", "register actions fail", paramString);
      AppMethodBeat.o(238011);
      return;
    }
    paramd.iQw();
    this.ackS.put(paramString, paramd);
    AppMethodBeat.o(238011);
  }
  
  public final void axS(int paramInt)
  {
    AppMethodBeat.i(237996);
    if (!k.a.cQ(getContext(), ""))
    {
      k.b.a.log(4, "MicroMsg.recovery", "not main proc, skip");
      AppMethodBeat.o(237996);
      return;
    }
    if ((this.ackR instanceof j.e))
    {
      ((j.e)this.ackR).axR(paramInt);
      AppMethodBeat.o(237996);
      return;
    }
    if ((this.ackR instanceof j.b))
    {
      ((j.b)this.ackR).axQ(paramInt);
      AppMethodBeat.o(237996);
      return;
    }
    new j.e(getContext()).axR(paramInt);
    AppMethodBeat.o(237996);
  }
  
  public final l b(int paramInt, c paramc)
  {
    AppMethodBeat.i(237984);
    if (this.ackR == null) {
      iRd();
    }
    this.ackR.a(paramInt, paramc);
    AppMethodBeat.o(237984);
    return this;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(237979);
    if (this.mContext == null)
    {
      this.mContext = k.a.cKQ().getApplicationContext();
      k.a.c(this.mContext, "Context should not be null");
    }
    Context localContext = this.mContext;
    AppMethodBeat.o(237979);
    return localContext;
  }
  
  public final void iRd()
  {
    AppMethodBeat.i(238002);
    this.ackR = new j.b(getContext());
    AppMethodBeat.o(238002);
  }
  
  public final void unregister()
  {
    AppMethodBeat.i(237990);
    if (this.ackR != null) {
      this.ackR.finish();
    }
    AppMethodBeat.o(237990);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.l
 * JD-Core Version:    0.7.0.1
 */