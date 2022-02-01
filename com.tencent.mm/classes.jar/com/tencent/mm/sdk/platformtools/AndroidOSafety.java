package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AndroidOSafety
{
  public static final int ID_ANDROID_O_SAFETY = 1221;
  public static final int KEY_SAFETY_IGNORE_BY_IS_FLOATING = 0;
  public static final int KEY_SAFETY_IGNORE_BY_IS_SWIPE_TO_DISMISS = 1;
  public static final int KEY_SAFETY_PREPARE_FAILED = 2;
  public static final int SAFETY_IGNORE_BY_IS_FLOATING = 2;
  public static final int SAFETY_IGNORE_BY_IS_SWIPE_TO_DISMISS = 3;
  public static final int SAFETY_NORMAL = 0;
  public static final int SAFETY_PREPARE_FAILED = 4;
  public static final int SAFETY_TO_OPAQUE = 1;
  private static final String TAG = "MicroMsg.AndroidOSafety";
  private static ISafetyCallback sISafetyCallback;
  private static boolean sPrepared = false;
  private static int sRealTargetVersion = 0;
  private static int[] sStyleableWindow;
  private static int sStyleableWindowIsFloating;
  private static int sStyleableWindowIsTranslucent;
  private static int sStyleableWindowSwipeToDismiss;
  
  public static boolean checkIfNeedAndroidOSafty(ApplicationInfo paramApplicationInfo)
  {
    if (Build.VERSION.SDK_INT != 26) {}
    do
    {
      return false;
      if (sRealTargetVersion > 26) {
        return true;
      }
    } while (paramApplicationInfo.targetSdkVersion <= 26);
    return true;
  }
  
  public static int getRealTargetVersion()
  {
    return sRealTargetVersion;
  }
  
  private static int[] getStyleableWindow()
  {
    return sStyleableWindow;
  }
  
  private static int getWindowIsFloating()
  {
    return sStyleableWindowIsFloating;
  }
  
  private static int getWindowIsTranslucent()
  {
    return sStyleableWindowIsTranslucent;
  }
  
  private static int getWindowSwipeToDismiss()
  {
    return sStyleableWindowSwipeToDismiss;
  }
  
  public static boolean isFixedOrientationLandscape(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 6) || (paramInt == 8) || (paramInt == 11);
  }
  
  public static boolean isFixedOrientationPortrait(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 7) || (paramInt == 9) || (paramInt == 12);
  }
  
  /* Error */
  private static boolean prepare()
  {
    // Byte code:
    //   0: ldc 88
    //   2: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 43	com/tencent/mm/sdk/platformtools/AndroidOSafety:sPrepared	Z
    //   8: ifeq +10 -> 18
    //   11: ldc 88
    //   13: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: iconst_1
    //   17: ireturn
    //   18: ldc 2
    //   20: monitorenter
    //   21: getstatic 43	com/tencent/mm/sdk/platformtools/AndroidOSafety:sPrepared	Z
    //   24: ifeq +13 -> 37
    //   27: ldc 2
    //   29: monitorexit
    //   30: ldc 88
    //   32: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: iconst_1
    //   36: ireturn
    //   37: ldc 99
    //   39: invokestatic 105	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   42: astore_0
    //   43: aload_0
    //   44: ldc 107
    //   46: invokevirtual 111	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   49: astore_1
    //   50: aload_1
    //   51: iconst_1
    //   52: invokevirtual 117	java/lang/reflect/Field:setAccessible	(Z)V
    //   55: aload_1
    //   56: aload_0
    //   57: invokevirtual 121	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   60: checkcast 122	[I
    //   63: checkcast 122	[I
    //   66: putstatic 65	com/tencent/mm/sdk/platformtools/AndroidOSafety:sStyleableWindow	[I
    //   69: aload_0
    //   70: ldc 124
    //   72: invokevirtual 111	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   75: astore_1
    //   76: aload_1
    //   77: iconst_1
    //   78: invokevirtual 117	java/lang/reflect/Field:setAccessible	(Z)V
    //   81: aload_1
    //   82: aload_0
    //   83: invokevirtual 121	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   86: checkcast 126	java/lang/Integer
    //   89: invokevirtual 129	java/lang/Integer:intValue	()I
    //   92: putstatic 71	com/tencent/mm/sdk/platformtools/AndroidOSafety:sStyleableWindowIsTranslucent	I
    //   95: aload_0
    //   96: ldc 131
    //   98: invokevirtual 111	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   101: astore_1
    //   102: aload_1
    //   103: iconst_1
    //   104: invokevirtual 117	java/lang/reflect/Field:setAccessible	(Z)V
    //   107: aload_1
    //   108: aload_0
    //   109: invokevirtual 121	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   112: checkcast 126	java/lang/Integer
    //   115: invokevirtual 129	java/lang/Integer:intValue	()I
    //   118: putstatic 74	com/tencent/mm/sdk/platformtools/AndroidOSafety:sStyleableWindowSwipeToDismiss	I
    //   121: aload_0
    //   122: ldc 133
    //   124: invokevirtual 111	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   127: astore_1
    //   128: aload_1
    //   129: iconst_1
    //   130: invokevirtual 117	java/lang/reflect/Field:setAccessible	(Z)V
    //   133: aload_1
    //   134: aload_0
    //   135: invokevirtual 121	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   138: checkcast 126	java/lang/Integer
    //   141: invokevirtual 129	java/lang/Integer:intValue	()I
    //   144: putstatic 68	com/tencent/mm/sdk/platformtools/AndroidOSafety:sStyleableWindowIsFloating	I
    //   147: iconst_1
    //   148: putstatic 43	com/tencent/mm/sdk/platformtools/AndroidOSafety:sPrepared	Z
    //   151: ldc 2
    //   153: monitorexit
    //   154: ldc 88
    //   156: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: iconst_1
    //   160: ireturn
    //   161: astore_0
    //   162: ldc 27
    //   164: aload_0
    //   165: ldc 135
    //   167: iconst_0
    //   168: anewarray 4	java/lang/Object
    //   171: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: ldc 2
    //   176: monitorexit
    //   177: ldc 88
    //   179: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: iconst_0
    //   183: ireturn
    //   184: astore_0
    //   185: ldc 27
    //   187: aload_0
    //   188: ldc 135
    //   190: iconst_0
    //   191: anewarray 4	java/lang/Object
    //   194: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: ldc 2
    //   199: monitorexit
    //   200: ldc 88
    //   202: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: iconst_0
    //   206: ireturn
    //   207: astore_0
    //   208: ldc 27
    //   210: aload_0
    //   211: ldc 135
    //   213: iconst_0
    //   214: anewarray 4	java/lang/Object
    //   217: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   220: ldc 2
    //   222: monitorexit
    //   223: ldc 88
    //   225: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: iconst_0
    //   229: ireturn
    //   230: astore_0
    //   231: ldc 27
    //   233: aload_0
    //   234: ldc 135
    //   236: iconst_0
    //   237: anewarray 4	java/lang/Object
    //   240: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   243: ldc 2
    //   245: monitorexit
    //   246: ldc 88
    //   248: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   251: iconst_0
    //   252: ireturn
    //   253: astore_0
    //   254: ldc 2
    //   256: monitorexit
    //   257: ldc 88
    //   259: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   262: aload_0
    //   263: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   42	93	0	localClass	java.lang.Class
    //   161	4	0	localClassNotFoundException	java.lang.ClassNotFoundException
    //   184	4	0	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   207	4	0	localIllegalAccessException	java.lang.IllegalAccessException
    //   230	4	0	localThrowable	java.lang.Throwable
    //   253	10	0	localObject	Object
    //   49	85	1	localField	java.lang.reflect.Field
    // Exception table:
    //   from	to	target	type
    //   37	147	161	java/lang/ClassNotFoundException
    //   37	147	184	java/lang/NoSuchFieldException
    //   37	147	207	java/lang/IllegalAccessException
    //   37	147	230	java/lang/Throwable
    //   21	30	253	finally
    //   37	147	253	finally
    //   147	154	253	finally
    //   162	177	253	finally
    //   185	200	253	finally
    //   208	223	253	finally
    //   231	246	253	finally
    //   254	257	253	finally
  }
  
  public static void replaceTargetVersion(ApplicationInfo paramApplicationInfo)
  {
    AppMethodBeat.i(156057);
    if ((Build.VERSION.SDK_INT == 26) && (paramApplicationInfo.targetSdkVersion > 26))
    {
      sRealTargetVersion = paramApplicationInfo.targetSdkVersion;
      paramApplicationInfo.targetSdkVersion = 26;
      Log.i("MicroMsg.AndroidOSafety", "replaceTargetVersion %s %s", new Object[] { Integer.valueOf(paramApplicationInfo.targetSdkVersion), Integer.valueOf(sRealTargetVersion) });
      AppMethodBeat.o(156057);
      return;
    }
    AppMethodBeat.o(156057);
  }
  
  public static boolean safety(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(156059);
    boolean bool1;
    boolean bool2;
    if (checkIfNeedAndroidOSafty(paramActivity.getApplicationInfo()))
    {
      if ((!isFixedOrientationLandscape(paramInt)) && (!isFixedOrientationPortrait(paramInt)))
      {
        AppMethodBeat.o(156059);
        return true;
      }
      paramInt = safetyImpl(paramActivity);
      if (paramInt == 1)
      {
        Log.i("MicroMsg.AndroidOSafety", "invokeToOpaque %s %s", new Object[] { paramActivity, Integer.valueOf(paramActivity.hashCode()) });
        if (sISafetyCallback == null) {
          break label289;
        }
        if (!sISafetyCallback.supportSwipe(paramActivity))
        {
          Log.i("MicroMsg.AndroidOSafety", "not support swipe %s %s", new Object[] { paramActivity, Integer.valueOf(paramActivity.hashCode()) });
          bool1 = false;
          bool2 = bool1;
          if (sISafetyCallback != null)
          {
            sISafetyCallback.reportState(paramInt, paramActivity);
            if (paramInt != 2) {
              break label247;
            }
            sISafetyCallback.reportState(0, paramActivity);
            bool2 = bool1;
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(156059);
      return bool2;
      sISafetyCallback.invokeToOpaque(paramActivity);
      bool1 = true;
      break;
      if ((paramInt == 2) || (paramInt == 3))
      {
        Log.e("MicroMsg.AndroidOSafety", "ignore by IS_FLOATING or IS_SWIPE_TO_DISMISS  %s %s", new Object[] { paramActivity, Integer.valueOf(paramActivity.hashCode()) });
        bool1 = false;
        break;
      }
      if (paramInt == 4)
      {
        Log.e("MicroMsg.AndroidOSafety", "prepare Failed  %s %s", new Object[] { paramActivity, Integer.valueOf(paramActivity.hashCode()) });
        bool1 = false;
        break;
        label247:
        if (paramInt == 3)
        {
          sISafetyCallback.reportState(1, paramActivity);
          bool2 = bool1;
          continue;
        }
        bool2 = bool1;
        if (paramInt != 4) {
          continue;
        }
        sISafetyCallback.reportState(2, paramActivity);
        bool2 = bool1;
        continue;
      }
      label289:
      bool1 = true;
      break;
      bool2 = true;
    }
  }
  
  private static int safetyImpl(Activity paramActivity)
  {
    AppMethodBeat.i(215282);
    if (prepare())
    {
      Object localObject = getStyleableWindow();
      int i = getWindowIsTranslucent();
      int j = getWindowSwipeToDismiss();
      int k = getWindowIsFloating();
      localObject = paramActivity.obtainStyledAttributes((int[])localObject);
      boolean bool2 = ((TypedArray)localObject).getBoolean(i, false);
      if ((!((TypedArray)localObject).hasValue(j)) && (((TypedArray)localObject).getBoolean(j, false))) {}
      boolean bool3;
      for (boolean bool1 = true;; bool1 = false)
      {
        bool3 = ((TypedArray)localObject).getBoolean(k, false);
        ((TypedArray)localObject).recycle();
        Log.i("MicroMsg.AndroidOSafety", "activity %s, isTranslucent %s, isFloating %s, isSwipeToDismiss %s", new Object[] { paramActivity, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        if (!bool2) {
          break;
        }
        AppMethodBeat.o(215282);
        return 1;
      }
      if (bool3)
      {
        AppMethodBeat.o(215282);
        return 2;
      }
      if (bool1)
      {
        AppMethodBeat.o(215282);
        return 3;
      }
      AppMethodBeat.o(215282);
      return 0;
    }
    Log.e("MicroMsg.AndroidOSafety", "prepare Failed %s", new Object[] { paramActivity });
    AppMethodBeat.o(215282);
    return 4;
  }
  
  public static void setISafetyCallback(ISafetyCallback paramISafetyCallback)
  {
    sISafetyCallback = paramISafetyCallback;
  }
  
  public static abstract interface ISafetyCallback
  {
    public abstract void invokeToOpaque(Activity paramActivity);
    
    public abstract void reportState(int paramInt, Activity paramActivity);
    
    public abstract boolean supportSwipe(Activity paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.AndroidOSafety
 * JD-Core Version:    0.7.0.1
 */