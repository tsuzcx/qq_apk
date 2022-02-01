package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class b
{
  @TargetApi(16)
  public static void a(Activity paramActivity, b paramb)
  {
    AppMethodBeat.i(141614);
    if (d.oE(16))
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
          localObject2 = new c((byte)0);
          ((c)localObject2).hfj = new WeakReference(paramb);
          paramb = Proxy.newProxyInstance(((Class)localObject1).getClassLoader(), new Class[] { localObject1 }, (InvocationHandler)localObject2);
          if (d.oE(21))
          {
            localObject1 = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[] { localObject1 });
            ((Method)localObject1).setAccessible(true);
            ((Method)localObject1).invoke(paramActivity, new Object[] { paramb });
            if ((paramActivity instanceof a)) {
              ((a)paramActivity).bXA();
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
  
  public static void az(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(141617);
    if ((paramIntent == null) || (paramContext == null) || (!(paramContext instanceof Activity)))
    {
      AppMethodBeat.o(141617);
      return;
    }
    if (paramIntent.getBooleanExtra("animation_pop_in", false)) {
      ((Activity)paramContext).overridePendingTransition(2130772119, 2130771986);
    }
    if (paramIntent.getBooleanExtra("animation_push_up_in", false)) {
      ((Activity)paramContext).overridePendingTransition(2130772132, 2130771986);
    }
    AppMethodBeat.o(141617);
  }
  
  public static int bd(Class<?> paramClass)
  {
    AppMethodBeat.i(141607);
    a locala = (a)paramClass.getAnnotation(a.class);
    if (locala != null)
    {
      i = locala.value();
      AppMethodBeat.o(141607);
      return i;
    }
    int i = be(paramClass);
    AppMethodBeat.o(141607);
    return i;
  }
  
  private static int be(Class<?> paramClass)
  {
    AppMethodBeat.i(141608);
    paramClass = paramClass.getSuperclass();
    if (paramClass != null)
    {
      int i = bd(paramClass);
      AppMethodBeat.o(141608);
      return i;
    }
    AppMethodBeat.o(141608);
    return 0;
  }
  
  public static boolean bf(Class<?> paramClass)
  {
    AppMethodBeat.i(141610);
    if ((bd(paramClass) & 0x1) == 0)
    {
      AppMethodBeat.o(141610);
      return true;
    }
    AppMethodBeat.o(141610);
    return false;
  }
  
  public static boolean bg(Class<?> paramClass)
  {
    AppMethodBeat.i(141611);
    if ((bd(paramClass) & 0x2) == 0)
    {
      AppMethodBeat.o(141611);
      return true;
    }
    AppMethodBeat.o(141611);
    return false;
  }
  
  public static int blZ(String paramString)
  {
    AppMethodBeat.i(141606);
    paramString = bma(paramString);
    if (paramString != null)
    {
      int i = bd(paramString);
      AppMethodBeat.o(141606);
      return i;
    }
    AppMethodBeat.o(141606);
    return 0;
  }
  
  private static Class<?> bma(String paramString)
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
  
  public static boolean bmb(String paramString)
  {
    AppMethodBeat.i(141612);
    if ((blZ(paramString) & 0x4) != 0)
    {
      AppMethodBeat.o(141612);
      return true;
    }
    AppMethodBeat.o(141612);
    return false;
  }
  
  public static void bp(Activity paramActivity)
  {
    AppMethodBeat.i(141613);
    try
    {
      Method localMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(paramActivity, new Object[0]);
      if ((paramActivity instanceof a)) {
        ((a)paramActivity).bXB();
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
  
  public static String e(ComponentName paramComponentName)
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
  
  public static void kb(Context paramContext)
  {
    AppMethodBeat.i(141615);
    if ((paramContext == null) || (!(paramContext instanceof Activity)))
    {
      AppMethodBeat.o(141615);
      return;
    }
    ((Activity)paramContext).overridePendingTransition(2130772119, 2130771986);
    AppMethodBeat.o(141615);
  }
  
  public static void kc(Context paramContext)
  {
    AppMethodBeat.i(141616);
    if ((paramContext == null) || (!(paramContext instanceof Activity)))
    {
      AppMethodBeat.o(141616);
      return;
    }
    ((Activity)paramContext).overridePendingTransition(2130772119, 2130772124);
    AppMethodBeat.o(141616);
  }
  
  public static void kd(Context paramContext)
  {
    AppMethodBeat.i(141618);
    if ((paramContext == null) || (!(paramContext instanceof Activity)))
    {
      AppMethodBeat.o(141618);
      return;
    }
    ((Activity)paramContext).overridePendingTransition(2130771986, 2130772124);
    AppMethodBeat.o(141618);
  }
  
  public static void ke(Context paramContext)
  {
    AppMethodBeat.i(141619);
    if ((paramContext == null) || (!(paramContext instanceof Activity)))
    {
      AppMethodBeat.o(141619);
      return;
    }
    ((Activity)paramContext).overridePendingTransition(2130771986, 2130771986);
    AppMethodBeat.o(141619);
  }
  
  public static abstract interface a
  {
    public abstract void bXA();
    
    public abstract void bXB();
  }
  
  public static abstract interface b
  {
    public abstract void ei(boolean paramBoolean);
  }
  
  static final class c
    implements InvocationHandler
  {
    WeakReference<b.b> hfj;
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      boolean bool2 = false;
      AppMethodBeat.i(141604);
      if (this.hfj == null)
      {
        Log.i("MicroMsg.ActivityUtil", "swipe invoke fail, callbackRef NULL!");
        AppMethodBeat.o(141604);
        return null;
      }
      paramObject = (b.b)this.hfj.get();
      if (paramObject == null)
      {
        Log.i("MicroMsg.ActivityUtil", "swipe invoke fail, callback NULL!");
        AppMethodBeat.o(141604);
        return null;
      }
      boolean bool1 = bool2;
      if (paramArrayOfObject != null)
      {
        bool1 = bool2;
        if (paramArrayOfObject.length > 0)
        {
          bool1 = bool2;
          if ((paramArrayOfObject[0] instanceof Boolean)) {
            bool1 = ((Boolean)paramArrayOfObject[0]).booleanValue();
          }
        }
      }
      paramObject.ei(bool1);
      AppMethodBeat.o(141604);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.b
 * JD-Core Version:    0.7.0.1
 */