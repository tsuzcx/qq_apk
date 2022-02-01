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
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class b
{
  @TargetApi(16)
  public static void a(Activity paramActivity, a parama)
  {
    AppMethodBeat.i(141614);
    if (d.lz(16))
    {
      ad.w("MicroMsg.ActivityUtil", "convertActivityToTranslucent::Android Version Error %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
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
        localObject1 = null;
        if (i < j)
        {
          localObject2 = arrayOfClass[i];
          if (!((Class)localObject2).getSimpleName().contains("TranslucentConversionListener")) {
            break label271;
          }
          localObject1 = localObject2;
          break label271;
        }
        if (parama == null) {
          break label266;
        }
        Object localObject2 = new b((byte)0);
        ((b)localObject2).qcJ = new WeakReference(parama);
        parama = Proxy.newProxyInstance(((Class)localObject1).getClassLoader(), new Class[] { localObject1 }, (InvocationHandler)localObject2);
        if (d.lz(21))
        {
          localObject1 = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[] { localObject1 });
          ((Method)localObject1).setAccessible(true);
          ((Method)localObject1).invoke(paramActivity, new Object[] { parama });
          AppMethodBeat.o(141614);
          return;
        }
      }
      catch (Throwable paramActivity)
      {
        ad.printErrStackTrace("MicroMsg.ActivityUtil", paramActivity, "call convertActivityToTranslucent Fail: %s", new Object[] { paramActivity.getMessage() });
        AppMethodBeat.o(141614);
        return;
      }
      Object localObject1 = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[] { localObject1, ActivityOptions.class });
      ((Method)localObject1).setAccessible(true);
      ((Method)localObject1).invoke(paramActivity, new Object[] { parama, null });
      AppMethodBeat.o(141614);
      return;
      label266:
      parama = null;
      continue;
      label271:
      i += 1;
    }
  }
  
  public static boolean aVA(String paramString)
  {
    AppMethodBeat.i(141612);
    if ((aVy(paramString) & 0x4) != 0)
    {
      AppMethodBeat.o(141612);
      return true;
    }
    AppMethodBeat.o(141612);
    return false;
  }
  
  public static int aVy(String paramString)
  {
    AppMethodBeat.i(141606);
    paramString = aVz(paramString);
    if (paramString != null)
    {
      int i = bd(paramString);
      AppMethodBeat.o(141606);
      return i;
    }
    AppMethodBeat.o(141606);
    return 0;
  }
  
  private static Class<?> aVz(String paramString)
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
      ad.printErrStackTrace("MicroMsg.ActivityUtil", localClassNotFoundException, "", new Object[0]);
      ad.e("MicroMsg.ActivityUtil", "Class %s not found in dex", new Object[] { paramString });
      AppMethodBeat.o(141609);
    }
    return null;
  }
  
  public static void am(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(141617);
    if ((paramIntent == null) || (paramContext == null) || (!(paramContext instanceof Activity)))
    {
      AppMethodBeat.o(141617);
      return;
    }
    if (paramIntent.getBooleanExtra("animation_pop_in", false)) {
      ((Activity)paramContext).overridePendingTransition(2130772095, 2130771986);
    }
    if (paramIntent.getBooleanExtra("animation_push_up_in", false)) {
      ((Activity)paramContext).overridePendingTransition(2130772108, 2130771986);
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
  
  public static void bi(Activity paramActivity)
  {
    AppMethodBeat.i(141613);
    try
    {
      Method localMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(paramActivity, new Object[0]);
      AppMethodBeat.o(141613);
      return;
    }
    catch (Throwable paramActivity)
    {
      ad.printErrStackTrace("MicroMsg.ActivityUtil", paramActivity, "call convertActivityFromTranslucent Fail: %s", new Object[] { paramActivity.getMessage() });
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
    paramComponentName = paramComponentName.getPackageName() + paramComponentName.getClassName();
    AppMethodBeat.o(141605);
    return paramComponentName;
  }
  
  public static void kc(Context paramContext)
  {
    AppMethodBeat.i(141615);
    if ((paramContext == null) || (!(paramContext instanceof Activity)))
    {
      AppMethodBeat.o(141615);
      return;
    }
    ((Activity)paramContext).overridePendingTransition(2130772095, 2130771986);
    AppMethodBeat.o(141615);
  }
  
  public static void kd(Context paramContext)
  {
    AppMethodBeat.i(141616);
    if ((paramContext == null) || (!(paramContext instanceof Activity)))
    {
      AppMethodBeat.o(141616);
      return;
    }
    ((Activity)paramContext).overridePendingTransition(2130772095, 2130772100);
    AppMethodBeat.o(141616);
  }
  
  public static void ke(Context paramContext)
  {
    AppMethodBeat.i(141618);
    if ((paramContext == null) || (!(paramContext instanceof Activity)))
    {
      AppMethodBeat.o(141618);
      return;
    }
    ((Activity)paramContext).overridePendingTransition(2130771986, 2130772100);
    AppMethodBeat.o(141618);
  }
  
  public static void kf(Context paramContext)
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
    public abstract void iK(boolean paramBoolean);
  }
  
  static final class b
    implements InvocationHandler
  {
    WeakReference<b.a> qcJ;
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      boolean bool2 = false;
      AppMethodBeat.i(141604);
      if (this.qcJ == null)
      {
        ad.i("MicroMsg.ActivityUtil", "swipe invoke fail, callbackRef NULL!");
        AppMethodBeat.o(141604);
        return null;
      }
      paramObject = (b.a)this.qcJ.get();
      if (paramObject == null)
      {
        ad.i("MicroMsg.ActivityUtil", "swipe invoke fail, callback NULL!");
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
      paramObject.iK(bool1);
      AppMethodBeat.o(141604);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.b
 * JD-Core Version:    0.7.0.1
 */