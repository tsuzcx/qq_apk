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
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class b
{
  public static void K(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(106256);
    if ((paramIntent == null) || (paramContext == null) || (!(paramContext instanceof Activity)))
    {
      AppMethodBeat.o(106256);
      return;
    }
    if (paramIntent.getBooleanExtra("animation_pop_in", false)) {
      ((Activity)paramContext).overridePendingTransition(2131034217, 2131034130);
    }
    AppMethodBeat.o(106256);
  }
  
  @TargetApi(16)
  public static void a(Activity paramActivity, a parama)
  {
    AppMethodBeat.i(106253);
    if (d.fw(16))
    {
      ab.w("MicroMsg.ActivityUtil", "convertActivityToTranslucent::Android Version Error %d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(106253);
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
        ((b)localObject2).zhi = new WeakReference(parama);
        parama = Proxy.newProxyInstance(((Class)localObject1).getClassLoader(), new Class[] { localObject1 }, (InvocationHandler)localObject2);
        if (d.fw(21))
        {
          localObject1 = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[] { localObject1 });
          ((Method)localObject1).setAccessible(true);
          ((Method)localObject1).invoke(paramActivity, new Object[] { parama });
          AppMethodBeat.o(106253);
          return;
        }
      }
      catch (Throwable paramActivity)
      {
        ab.printErrStackTrace("MicroMsg.ActivityUtil", paramActivity, "call convertActivityToTranslucent Fail: %s", new Object[] { paramActivity.getMessage() });
        AppMethodBeat.o(106253);
        return;
      }
      Object localObject1 = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[] { localObject1, ActivityOptions.class });
      ((Method)localObject1).setAccessible(true);
      ((Method)localObject1).invoke(paramActivity, new Object[] { parama, null });
      AppMethodBeat.o(106253);
      return;
      label266:
      parama = null;
      continue;
      label271:
      i += 1;
    }
  }
  
  public static void aD(Activity paramActivity)
  {
    AppMethodBeat.i(106252);
    try
    {
      Method localMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(paramActivity, new Object[0]);
      AppMethodBeat.o(106252);
      return;
    }
    catch (Throwable paramActivity)
    {
      ab.printErrStackTrace("MicroMsg.ActivityUtil", paramActivity, "call convertActivityFromTranslucent Fail: %s", new Object[] { paramActivity.getMessage() });
      AppMethodBeat.o(106252);
    }
  }
  
  public static int atu(String paramString)
  {
    AppMethodBeat.i(106245);
    paramString = atv(paramString);
    if (paramString != null)
    {
      int i = au(paramString);
      AppMethodBeat.o(106245);
      return i;
    }
    AppMethodBeat.o(106245);
    return 0;
  }
  
  private static Class<?> atv(String paramString)
  {
    AppMethodBeat.i(106248);
    try
    {
      Class localClass = Class.forName(paramString);
      AppMethodBeat.o(106248);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      ab.printErrStackTrace("MicroMsg.ActivityUtil", localClassNotFoundException, "", new Object[0]);
      ab.e("MicroMsg.ActivityUtil", "Class %s not found in dex", new Object[] { paramString });
      AppMethodBeat.o(106248);
    }
    return null;
  }
  
  public static boolean atw(String paramString)
  {
    AppMethodBeat.i(106251);
    if ((atu(paramString) & 0x4) != 0)
    {
      AppMethodBeat.o(106251);
      return true;
    }
    AppMethodBeat.o(106251);
    return false;
  }
  
  public static int au(Class<?> paramClass)
  {
    AppMethodBeat.i(106246);
    a locala = (a)paramClass.getAnnotation(a.class);
    if (locala != null)
    {
      i = locala.value();
      AppMethodBeat.o(106246);
      return i;
    }
    int i = av(paramClass);
    AppMethodBeat.o(106246);
    return i;
  }
  
  private static int av(Class<?> paramClass)
  {
    AppMethodBeat.i(106247);
    paramClass = paramClass.getSuperclass();
    if (paramClass != null)
    {
      int i = au(paramClass);
      AppMethodBeat.o(106247);
      return i;
    }
    AppMethodBeat.o(106247);
    return 0;
  }
  
  public static boolean aw(Class<?> paramClass)
  {
    AppMethodBeat.i(106249);
    if ((au(paramClass) & 0x1) == 0)
    {
      AppMethodBeat.o(106249);
      return true;
    }
    AppMethodBeat.o(106249);
    return false;
  }
  
  public static boolean ax(Class<?> paramClass)
  {
    AppMethodBeat.i(106250);
    if ((au(paramClass) & 0x2) == 0)
    {
      AppMethodBeat.o(106250);
      return true;
    }
    AppMethodBeat.o(106250);
    return false;
  }
  
  public static String e(ComponentName paramComponentName)
  {
    AppMethodBeat.i(106244);
    if (paramComponentName.getClassName().startsWith(paramComponentName.getPackageName()))
    {
      paramComponentName = paramComponentName.getClassName();
      AppMethodBeat.o(106244);
      return paramComponentName;
    }
    paramComponentName = paramComponentName.getPackageName() + paramComponentName.getClassName();
    AppMethodBeat.o(106244);
    return paramComponentName;
  }
  
  public static void ie(Context paramContext)
  {
    AppMethodBeat.i(106254);
    if ((paramContext == null) || (!(paramContext instanceof Activity)))
    {
      AppMethodBeat.o(106254);
      return;
    }
    ((Activity)paramContext).overridePendingTransition(2131034217, 2131034130);
    AppMethodBeat.o(106254);
  }
  
  public static void jdMethod_if(Context paramContext)
  {
    AppMethodBeat.i(106255);
    if ((paramContext == null) || (!(paramContext instanceof Activity)))
    {
      AppMethodBeat.o(106255);
      return;
    }
    ((Activity)paramContext).overridePendingTransition(2131034217, 2131034222);
    AppMethodBeat.o(106255);
  }
  
  public static void ig(Context paramContext)
  {
    AppMethodBeat.i(106257);
    if ((paramContext == null) || (!(paramContext instanceof Activity)))
    {
      AppMethodBeat.o(106257);
      return;
    }
    ((Activity)paramContext).overridePendingTransition(2131034130, 2131034222);
    AppMethodBeat.o(106257);
  }
  
  public static void ih(Context paramContext)
  {
    AppMethodBeat.i(106258);
    if ((paramContext == null) || (!(paramContext instanceof Activity)))
    {
      AppMethodBeat.o(106258);
      return;
    }
    ((Activity)paramContext).overridePendingTransition(2131034130, 2131034130);
    AppMethodBeat.o(106258);
  }
  
  public static abstract interface a
  {
    public abstract void iX(boolean paramBoolean);
  }
  
  static final class b
    implements InvocationHandler
  {
    WeakReference<b.a> zhi;
    
    public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      boolean bool2 = false;
      AppMethodBeat.i(106243);
      if (this.zhi == null)
      {
        ab.i("MicroMsg.ActivityUtil", "swipe invoke fail, callbackRef NULL!");
        AppMethodBeat.o(106243);
        return null;
      }
      paramObject = (b.a)this.zhi.get();
      if (paramObject == null)
      {
        ab.i("MicroMsg.ActivityUtil", "swipe invoke fail, callback NULL!");
        AppMethodBeat.o(106243);
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
      paramObject.iX(bool1);
      AppMethodBeat.o(106243);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.b
 * JD-Core Version:    0.7.0.1
 */