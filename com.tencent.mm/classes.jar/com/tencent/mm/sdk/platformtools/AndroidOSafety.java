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
    //   0: ldc 86
    //   2: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 43	com/tencent/mm/sdk/platformtools/AndroidOSafety:sPrepared	Z
    //   8: ifeq +10 -> 18
    //   11: ldc 86
    //   13: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: iconst_1
    //   17: ireturn
    //   18: ldc 2
    //   20: monitorenter
    //   21: getstatic 43	com/tencent/mm/sdk/platformtools/AndroidOSafety:sPrepared	Z
    //   24: ifeq +13 -> 37
    //   27: ldc 2
    //   29: monitorexit
    //   30: ldc 86
    //   32: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: iconst_1
    //   36: ireturn
    //   37: ldc 97
    //   39: invokestatic 103	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   42: astore_0
    //   43: aload_0
    //   44: ldc 105
    //   46: invokevirtual 109	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   49: astore_1
    //   50: aload_1
    //   51: iconst_1
    //   52: invokevirtual 115	java/lang/reflect/Field:setAccessible	(Z)V
    //   55: aload_1
    //   56: aload_0
    //   57: invokevirtual 119	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   60: checkcast 120	[I
    //   63: putstatic 65	com/tencent/mm/sdk/platformtools/AndroidOSafety:sStyleableWindow	[I
    //   66: aload_0
    //   67: ldc 122
    //   69: invokevirtual 109	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   72: astore_1
    //   73: aload_1
    //   74: iconst_1
    //   75: invokevirtual 115	java/lang/reflect/Field:setAccessible	(Z)V
    //   78: aload_1
    //   79: aload_0
    //   80: invokevirtual 119	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   83: checkcast 124	java/lang/Integer
    //   86: invokevirtual 127	java/lang/Integer:intValue	()I
    //   89: putstatic 71	com/tencent/mm/sdk/platformtools/AndroidOSafety:sStyleableWindowIsTranslucent	I
    //   92: aload_0
    //   93: ldc 129
    //   95: invokevirtual 109	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   98: astore_1
    //   99: aload_1
    //   100: iconst_1
    //   101: invokevirtual 115	java/lang/reflect/Field:setAccessible	(Z)V
    //   104: aload_1
    //   105: aload_0
    //   106: invokevirtual 119	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   109: checkcast 124	java/lang/Integer
    //   112: invokevirtual 127	java/lang/Integer:intValue	()I
    //   115: putstatic 74	com/tencent/mm/sdk/platformtools/AndroidOSafety:sStyleableWindowSwipeToDismiss	I
    //   118: aload_0
    //   119: ldc 131
    //   121: invokevirtual 109	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   124: astore_1
    //   125: aload_1
    //   126: iconst_1
    //   127: invokevirtual 115	java/lang/reflect/Field:setAccessible	(Z)V
    //   130: aload_1
    //   131: aload_0
    //   132: invokevirtual 119	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   135: checkcast 124	java/lang/Integer
    //   138: invokevirtual 127	java/lang/Integer:intValue	()I
    //   141: putstatic 68	com/tencent/mm/sdk/platformtools/AndroidOSafety:sStyleableWindowIsFloating	I
    //   144: iconst_1
    //   145: putstatic 43	com/tencent/mm/sdk/platformtools/AndroidOSafety:sPrepared	Z
    //   148: ldc 2
    //   150: monitorexit
    //   151: ldc 86
    //   153: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: iconst_1
    //   157: ireturn
    //   158: astore_0
    //   159: ldc 27
    //   161: aload_0
    //   162: ldc 133
    //   164: iconst_0
    //   165: anewarray 4	java/lang/Object
    //   168: invokestatic 139	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: ldc 2
    //   173: monitorexit
    //   174: ldc 86
    //   176: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   179: iconst_0
    //   180: ireturn
    //   181: astore_0
    //   182: ldc 27
    //   184: aload_0
    //   185: ldc 133
    //   187: iconst_0
    //   188: anewarray 4	java/lang/Object
    //   191: invokestatic 139	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   194: ldc 2
    //   196: monitorexit
    //   197: ldc 86
    //   199: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: iconst_0
    //   203: ireturn
    //   204: astore_0
    //   205: ldc 27
    //   207: aload_0
    //   208: ldc 133
    //   210: iconst_0
    //   211: anewarray 4	java/lang/Object
    //   214: invokestatic 139	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   217: ldc 2
    //   219: monitorexit
    //   220: ldc 86
    //   222: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   225: iconst_0
    //   226: ireturn
    //   227: astore_0
    //   228: ldc 27
    //   230: aload_0
    //   231: ldc 133
    //   233: iconst_0
    //   234: anewarray 4	java/lang/Object
    //   237: invokestatic 139	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   240: ldc 2
    //   242: monitorexit
    //   243: ldc 86
    //   245: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   248: iconst_0
    //   249: ireturn
    //   250: astore_0
    //   251: ldc 2
    //   253: monitorexit
    //   254: ldc 86
    //   256: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: aload_0
    //   260: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   42	90	0	localClass	java.lang.Class
    //   158	4	0	localClassNotFoundException	java.lang.ClassNotFoundException
    //   181	4	0	localNoSuchFieldException	java.lang.NoSuchFieldException
    //   204	4	0	localIllegalAccessException	java.lang.IllegalAccessException
    //   227	4	0	localThrowable	java.lang.Throwable
    //   250	10	0	localObject	Object
    //   49	82	1	localField	java.lang.reflect.Field
    // Exception table:
    //   from	to	target	type
    //   37	144	158	java/lang/ClassNotFoundException
    //   37	144	181	java/lang/NoSuchFieldException
    //   37	144	204	java/lang/IllegalAccessException
    //   37	144	227	finally
    //   21	30	250	finally
    //   144	151	250	finally
    //   159	174	250	finally
    //   182	197	250	finally
    //   205	220	250	finally
    //   228	243	250	finally
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
    AppMethodBeat.i(243630);
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
        AppMethodBeat.o(243630);
        return 1;
      }
      if (bool3)
      {
        AppMethodBeat.o(243630);
        return 2;
      }
      if (bool1)
      {
        AppMethodBeat.o(243630);
        return 3;
      }
      AppMethodBeat.o(243630);
      return 0;
    }
    Log.e("MicroMsg.AndroidOSafety", "prepare Failed %s", new Object[] { paramActivity });
    AppMethodBeat.o(243630);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.AndroidOSafety
 * JD-Core Version:    0.7.0.1
 */