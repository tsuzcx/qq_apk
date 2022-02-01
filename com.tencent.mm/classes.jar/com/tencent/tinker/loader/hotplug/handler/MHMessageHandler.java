package com.tencent.tinker.loader.hotplug.handler;

import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Message;
import com.tencent.tinker.loader.hotplug.IncrementComponentManager;
import com.tencent.tinker.loader.hotplug.interceptor.HandlerMessageInterceptor.MessageHandler;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MHMessageHandler
  implements HandlerMessageInterceptor.MessageHandler
{
  private static final int LAUNCH_ACTIVITY;
  private static final String TAG = "Tinker.MHMsgHndlr";
  private final Context mContext;
  
  static
  {
    int j = 100;
    int i = j;
    if (Build.VERSION.SDK_INT < 27) {}
    try
    {
      i = ShareReflectUtil.findField(Class.forName("android.app.ActivityThread$H"), "LAUNCH_ACTIVITY").getInt(null);
      LAUNCH_ACTIVITY = i;
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
  
  public MHMessageHandler(Context paramContext)
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
  
  private <T> void copyInstanceFields(T paramT1, T paramT2)
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
      label39:
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
        label96:
        i += 1;
        break label39;
        localClass = localClass.getSuperclass();
      }
      catch (Throwable localThrowable)
      {
        break label96;
      }
    }
  }
  
  private void fixActivityScreenOrientation(Object paramObject, int paramInt)
  {
    int i = paramInt;
    if (paramInt == -1) {
      i = 2;
    }
    try
    {
      paramObject = ShareReflectUtil.findField(paramObject, "token").get(paramObject);
      Object localObject = ShareReflectUtil.findMethod(Class.forName("android.app.ActivityManagerNative"), "getDefault", new Class[0]).invoke(null, new Object[0]);
      ShareReflectUtil.findMethod(localObject, "setRequestedOrientation", new Class[] { IBinder.class, Integer.TYPE }).invoke(localObject, new Object[] { paramObject, Integer.valueOf(i) });
      return;
    }
    catch (Throwable paramObject) {}
  }
  
  private void fixStubActivityInfo(ActivityInfo paramActivityInfo1, ActivityInfo paramActivityInfo2)
  {
    copyInstanceFields(paramActivityInfo2, paramActivityInfo1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == LAUNCH_ACTIVITY) {}
    try
    {
      Object localObject = paramMessage.obj;
      if (localObject == null)
      {
        new StringBuilder("msg: [").append(paramMessage.what).append("] has no 'obj' value.");
        return false;
      }
      paramMessage = (Intent)ShareReflectUtil.findField(localObject, "intent").get(localObject);
      if (paramMessage != null)
      {
        ShareIntentUtil.fixIntentClassLoader(paramMessage, this.mContext.getClassLoader());
        ComponentName localComponentName = (ComponentName)paramMessage.getParcelableExtra("tinker_iek_old_component");
        if (localComponentName == null)
        {
          new StringBuilder("oldComponent was null, start ").append(paramMessage.getComponent()).append(" next.");
          return false;
        }
        ActivityInfo localActivityInfo1 = (ActivityInfo)ShareReflectUtil.findField(localObject, "activityInfo").get(localObject);
        if (localActivityInfo1 != null)
        {
          ActivityInfo localActivityInfo2 = IncrementComponentManager.queryActivityInfo(localComponentName.getClassName());
          if (localActivityInfo2 == null)
          {
            new StringBuilder("Failed to query target activity's info, perhaps the target is not hotpluged component. Target: ").append(localComponentName.getClassName());
            return false;
          }
          fixActivityScreenOrientation(localObject, localActivityInfo2.screenOrientation);
          fixStubActivityInfo(localActivityInfo1, localActivityInfo2);
          paramMessage.setComponent(localComponentName);
          paramMessage.removeExtra("tinker_iek_old_component");
        }
      }
      return false;
    }
    catch (Throwable paramMessage) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.handler.MHMessageHandler
 * JD-Core Version:    0.7.0.1
 */