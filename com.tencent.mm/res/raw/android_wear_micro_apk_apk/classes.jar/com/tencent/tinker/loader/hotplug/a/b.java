package com.tencent.tinker.loader.hotplug.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import com.tencent.tinker.loader.a.e;
import com.tencent.tinker.loader.a.h;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public final class b
  implements com.tencent.tinker.loader.hotplug.b.c
{
  private static final int aoY;
  private final Context mContext;
  
  static
  {
    int j = 100;
    int i = j;
    if (Build.VERSION.SDK_INT < 27) {}
    try
    {
      i = h.a(Class.forName("android.app.ActivityThread$H"), "LAUNCH_ACTIVITY").getInt(null);
      aoY = i;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  public b(Context paramContext)
  {
    while ((paramContext instanceof ContextWrapper))
    {
      Context localContext = ((ContextWrapper)paramContext).getBaseContext();
      if (localContext == null) {
        break;
      }
      paramContext = localContext;
    }
    this.mContext = paramContext;
  }
  
  private static <T> void h(T paramT1, T paramT2)
  {
    if ((paramT1 == null) || (paramT2 == null)) {
      return;
    }
    Class localClass = paramT1.getClass();
    while (!localClass.equals(Object.class))
    {
      Field[] arrayOfField = localClass.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      label38:
      Field localField;
      if (i < j)
      {
        localField = arrayOfField[i];
        if ((!localField.isSynthetic()) && (!Modifier.isStatic(localField.getModifiers()))) {
          if (!localField.isAccessible()) {
            localField.setAccessible(true);
          }
        }
      }
      try
      {
        localField.set(paramT2, localField.get(paramT1));
        label94:
        i += 1;
        break label38;
        localClass = localClass.getSuperclass();
      }
      catch (Throwable localThrowable)
      {
        break label94;
      }
    }
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    int i = 2;
    if (paramMessage.what == aoY)
    {
      Object localObject1;
      try
      {
        localObject1 = paramMessage.obj;
        if (localObject1 == null)
        {
          Log.w("Tinker.MHMsgHndlr", "msg: [" + paramMessage.what + "] has no 'obj' value.");
          return false;
        }
        paramMessage = (Intent)h.d(localObject1, "intent").get(localObject1);
        if (paramMessage == null)
        {
          Log.w("Tinker.MHMsgHndlr", "cannot fetch intent from message received by mH.");
          return false;
        }
      }
      catch (Throwable paramMessage)
      {
        Log.e("Tinker.MHMsgHndlr", "exception in handleMessage.", paramMessage);
        return false;
      }
      e.a(paramMessage, this.mContext.getClassLoader());
      ComponentName localComponentName = (ComponentName)paramMessage.getParcelableExtra("tinker_iek_old_component");
      if (localComponentName == null)
      {
        Log.w("Tinker.MHMsgHndlr", "oldComponent was null, start " + paramMessage.getComponent() + " next.");
        return false;
      }
      ActivityInfo localActivityInfo1 = (ActivityInfo)h.d(localObject1, "activityInfo").get(localObject1);
      if (localActivityInfo1 != null)
      {
        ActivityInfo localActivityInfo2 = com.tencent.tinker.loader.hotplug.c.af(localComponentName.getClassName());
        if (localActivityInfo2 == null)
        {
          Log.e("Tinker.MHMsgHndlr", "Failed to query target activity's info, perhaps the target is not hotpluged component. Target: " + localComponentName.getClassName());
          return false;
        }
        int j = localActivityInfo2.screenOrientation;
        if (j == -1) {}
        for (;;)
        {
          try
          {
            localObject1 = h.d(localObject1, "token").get(localObject1);
            Object localObject2 = h.a(Class.forName("android.app.ActivityManagerNative"), "getDefault", new Class[0]).invoke(null, new Object[0]);
            h.a(localObject2, "setRequestedOrientation", new Class[] { IBinder.class, Integer.TYPE }).invoke(localObject2, new Object[] { localObject1, Integer.valueOf(i) });
            h(localActivityInfo2, localActivityInfo1);
            paramMessage.setComponent(localComponentName);
            paramMessage.removeExtra("tinker_iek_old_component");
            return false;
          }
          catch (Throwable localThrowable)
          {
            Log.e("Tinker.MHMsgHndlr", "Failed to fix screen orientation.", localThrowable);
            continue;
          }
          i = j;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.a.b
 * JD-Core Version:    0.7.0.1
 */