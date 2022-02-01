package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class b
{
  @TargetApi(16)
  public static void a(Activity paramActivity, b.b paramb)
  {
    AppMethodBeat.i(141614);
    if (d.qW(16))
    {
      Log.w("MicroMsg.ActivityUtil", "convertActivityToTranslucent::Android Version Error %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(141614);
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        Class[] arrayOfClass = Activity.class.getDeclaredClasses();
        int j = arrayOfClass.length;
        i = 0;
        Object localObject1 = null;
        Object localObject2;
        if (i < j)
        {
          localObject2 = arrayOfClass[i];
          if (!((Class)localObject2).getSimpleName().contains("TranslucentConversionListener")) {
            break label284;
          }
          localObject1 = localObject2;
          break label284;
        }
        if (paramb != null)
        {
          localObject2 = new b.c((byte)0);
          ((b.c)localObject2).jRb = new WeakReference(paramb);
          paramb = Proxy.newProxyInstance(((Class)localObject1).getClassLoader(), new Class[] { localObject1 }, (InvocationHandler)localObject2);
          if (d.qW(21))
          {
            localObject1 = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[] { localObject1 });
            ((Method)localObject1).setAccessible(true);
            ((Method)localObject1).invoke(paramActivity, new Object[] { paramb });
            if ((paramActivity instanceof a)) {
              ((a)paramActivity).ckh();
            }
            AppMethodBeat.o(141614);
            return;
          }
          localObject1 = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[] { localObject1, ActivityOptions.class });
          ((Method)localObject1).setAccessible(true);
          ((Method)localObject1).invoke(paramActivity, new Object[] { paramb, null });
          continue;
        }
        paramb = null;
      }
      catch (Throwable paramActivity)
      {
        Log.printErrStackTrace("MicroMsg.ActivityUtil", paramActivity, "call convertActivityToTranslucent Fail: %s", new Object[] { paramActivity.getMessage() });
        AppMethodBeat.o(141614);
        return;
      }
      continue;
      label284:
      i += 1;
    }
  }
  
  public static void aI(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(141617);
    if ((paramIntent == null) || (paramContext == null) || (!(paramContext instanceof Activity)))
    {
      AppMethodBeat.o(141617);
      return;
    }
    if (paramIntent.getBooleanExtra("animation_pop_in", false)) {
      ((Activity)paramContext).overridePendingTransition(a.a.pop_in, a.a.anim_not_change);
    }
    if (paramIntent.getBooleanExtra("animation_push_up_in", false)) {
      ((Activity)paramContext).overridePendingTransition(a.a.push_up_in, a.a.anim_not_change);
    }
    AppMethodBeat.o(141617);
  }
  
  public static boolean bA(Class<?> paramClass)
  {
    AppMethodBeat.i(141610);
    if ((by(paramClass) & 0x1) == 0)
    {
      AppMethodBeat.o(141610);
      return true;
    }
    AppMethodBeat.o(141610);
    return false;
  }
  
  public static boolean bB(Class<?> paramClass)
  {
    AppMethodBeat.i(141611);
    if ((by(paramClass) & 0x2) == 0)
    {
      AppMethodBeat.o(141611);
      return true;
    }
    AppMethodBeat.o(141611);
    return false;
  }
  
  public static void bv(Activity paramActivity)
  {
    AppMethodBeat.i(141613);
    try
    {
      Method localMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(paramActivity, new Object[0]);
      if ((paramActivity instanceof a)) {
        ((a)paramActivity).cki();
      }
      AppMethodBeat.o(141613);
      return;
    }
    catch (Throwable paramActivity)
    {
      Log.printErrStackTrace("MicroMsg.ActivityUtil", paramActivity, "call convertActivityFromTranslucent Fail: %s", new Object[] { paramActivity.getMessage() });
      AppMethodBeat.o(141613);
    }
  }
  
  public static int by(Class<?> paramClass)
  {
    AppMethodBeat.i(141607);
    a locala = (a)paramClass.getAnnotation(a.class);
    if (locala != null)
    {
      i = locala.value();
      AppMethodBeat.o(141607);
      return i;
    }
    int i = bz(paramClass);
    AppMethodBeat.o(141607);
    return i;
  }
  
  public static boolean byA(String paramString)
  {
    AppMethodBeat.i(141612);
    if ((byy(paramString) & 0x4) != 0)
    {
      AppMethodBeat.o(141612);
      return true;
    }
    AppMethodBeat.o(141612);
    return false;
  }
  
  public static int byy(String paramString)
  {
    AppMethodBeat.i(141606);
    paramString = byz(paramString);
    if (paramString != null)
    {
      int i = by(paramString);
      AppMethodBeat.o(141606);
      return i;
    }
    AppMethodBeat.o(141606);
    return 0;
  }
  
  private static Class<?> byz(String paramString)
  {
    AppMethodBeat.i(141609);
    try
    {
      Class localClass = Class.forName(paramString);
      AppMethodBeat.o(141609);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Log.printErrStackTrace("MicroMsg.ActivityUtil", localClassNotFoundException, "", new Object[0]);
      Log.e("MicroMsg.ActivityUtil", "Class %s not found in dex", new Object[] { paramString });
      AppMethodBeat.o(141609);
    }
    return null;
  }
  
  private static int bz(Class<?> paramClass)
  {
    AppMethodBeat.i(141608);
    paramClass = paramClass.getSuperclass();
    if (paramClass != null)
    {
      int i = by(paramClass);
      AppMethodBeat.o(141608);
      return i;
    }
    AppMethodBeat.o(141608);
    return 0;
  }
  
  public static String f(ComponentName paramComponentName)
  {
    AppMethodBeat.i(141605);
    if (paramComponentName.getClassName().startsWith(paramComponentName.getPackageName()))
    {
      paramComponentName = paramComponentName.getClassName();
      AppMethodBeat.o(141605);
      return paramComponentName;
    }
    paramComponentName = paramComponentName.getClassName();
    AppMethodBeat.o(141605);
    return paramComponentName;
  }
  
  public static void kZ(Context paramContext)
  {
    AppMethodBeat.i(141615);
    if ((paramContext == null) || (!(paramContext instanceof Activity)))
    {
      AppMethodBeat.o(141615);
      return;
    }
    ((Activity)paramContext).overridePendingTransition(a.a.pop_in, a.a.anim_not_change);
    AppMethodBeat.o(141615);
  }
  
  public static void la(Context paramContext)
  {
    AppMethodBeat.i(141616);
    if ((paramContext == null) || (!(paramContext instanceof Activity)))
    {
      AppMethodBeat.o(141616);
      return;
    }
    ((Activity)paramContext).overridePendingTransition(a.a.pop_in, a.a.pop_out);
    AppMethodBeat.o(141616);
  }
  
  public static void lb(Context paramContext)
  {
    AppMethodBeat.i(141618);
    if ((paramContext == null) || (!(paramContext instanceof Activity)))
    {
      AppMethodBeat.o(141618);
      return;
    }
    ((Activity)paramContext).overridePendingTransition(a.a.anim_not_change, a.a.pop_out);
    AppMethodBeat.o(141618);
  }
  
  public static void lc(Context paramContext)
  {
    AppMethodBeat.i(141619);
    if ((paramContext == null) || (!(paramContext instanceof Activity)))
    {
      AppMethodBeat.o(141619);
      return;
    }
    paramContext = (Activity)paramContext;
    int i = a.a.anim_not_change;
    paramContext.overridePendingTransition(i, i);
    AppMethodBeat.o(141619);
  }
  
  public static abstract interface a
  {
    public abstract void ckh();
    
    public abstract void cki();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.base.b
 * JD-Core Version:    0.7.0.1
 */