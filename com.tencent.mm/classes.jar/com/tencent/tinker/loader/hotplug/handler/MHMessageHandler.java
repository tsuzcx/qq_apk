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
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

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
    finally
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
  
  /* Error */
  private <T> void copyInstanceFields(T paramT1, T paramT2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_2
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: aload_1
    //   10: invokevirtual 63	java/lang/Object:getClass	()Ljava/lang/Class;
    //   13: astore 5
    //   15: aload 5
    //   17: ldc 4
    //   19: invokevirtual 67	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   22: ifne -14 -> 8
    //   25: aload 5
    //   27: invokevirtual 71	java/lang/Class:getDeclaredFields	()[Ljava/lang/reflect/Field;
    //   30: astore 6
    //   32: aload 6
    //   34: arraylength
    //   35: istore 4
    //   37: iconst_0
    //   38: istore_3
    //   39: iload_3
    //   40: iload 4
    //   42: if_icmpge +61 -> 103
    //   45: aload 6
    //   47: iload_3
    //   48: aaload
    //   49: astore 7
    //   51: aload 7
    //   53: invokevirtual 75	java/lang/reflect/Field:isSynthetic	()Z
    //   56: ifne +40 -> 96
    //   59: aload 7
    //   61: invokevirtual 79	java/lang/reflect/Field:getModifiers	()I
    //   64: invokestatic 85	java/lang/reflect/Modifier:isStatic	(I)Z
    //   67: ifne +29 -> 96
    //   70: aload 7
    //   72: invokevirtual 88	java/lang/reflect/Field:isAccessible	()Z
    //   75: ifne +9 -> 84
    //   78: aload 7
    //   80: iconst_1
    //   81: invokevirtual 92	java/lang/reflect/Field:setAccessible	(Z)V
    //   84: aload 7
    //   86: aload_2
    //   87: aload 7
    //   89: aload_1
    //   90: invokevirtual 96	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   93: invokevirtual 99	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   96: iload_3
    //   97: iconst_1
    //   98: iadd
    //   99: istore_3
    //   100: goto -61 -> 39
    //   103: aload 5
    //   105: invokevirtual 102	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   108: astore 5
    //   110: goto -95 -> 15
    //   113: astore 7
    //   115: goto -19 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	MHMessageHandler
    //   0	118	1	paramT1	T
    //   0	118	2	paramT2	T
    //   38	62	3	i	int
    //   35	8	4	j	int
    //   13	96	5	localClass	Class
    //   30	16	6	arrayOfField	Field[]
    //   49	39	7	localField	Field
    //   113	1	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   84	96	113	finally
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
    finally
    {
      ShareTinkerLog.e("Tinker.MHMsgHndlr", "Failed to fix screen orientation.", new Object[] { paramObject });
    }
  }
  
  private void fixStubActivityInfo(ActivityInfo paramActivityInfo1, ActivityInfo paramActivityInfo2)
  {
    copyInstanceFields(paramActivityInfo2, paramActivityInfo1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == LAUNCH_ACTIVITY)
    {
      Object localObject;
      try
      {
        localObject = paramMessage.obj;
        if (localObject == null)
        {
          ShareTinkerLog.w("Tinker.MHMsgHndlr", "msg: [" + paramMessage.what + "] has no 'obj' value.", new Object[0]);
          return false;
        }
        paramMessage = (Intent)ShareReflectUtil.findField(localObject, "intent").get(localObject);
        if (paramMessage == null)
        {
          ShareTinkerLog.w("Tinker.MHMsgHndlr", "cannot fetch intent from message received by mH.", new Object[0]);
          return false;
        }
      }
      finally
      {
        ShareTinkerLog.e("Tinker.MHMsgHndlr", "exception in handleMessage.", new Object[] { paramMessage });
        return false;
      }
      ShareIntentUtil.fixIntentClassLoader(paramMessage, this.mContext.getClassLoader());
      ComponentName localComponentName = (ComponentName)paramMessage.getParcelableExtra("tinker_iek_old_component");
      if (localComponentName == null)
      {
        ShareTinkerLog.w("Tinker.MHMsgHndlr", "oldComponent was null, start " + paramMessage.getComponent() + " next.", new Object[0]);
        return false;
      }
      ActivityInfo localActivityInfo1 = (ActivityInfo)ShareReflectUtil.findField(localObject, "activityInfo").get(localObject);
      if (localActivityInfo1 != null)
      {
        ActivityInfo localActivityInfo2 = IncrementComponentManager.queryActivityInfo(localComponentName.getClassName());
        if (localActivityInfo2 == null)
        {
          ShareTinkerLog.e("Tinker.MHMsgHndlr", "Failed to query target activity's info, perhaps the target is not hotpluged component. Target: " + localComponentName.getClassName(), new Object[0]);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.handler.MHMessageHandler
 * JD-Core Version:    0.7.0.1
 */