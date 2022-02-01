package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b
{
  private static a Iwj;
  private static int Iwk = 0;
  private static boolean Iwl = false;
  private static int[] Iwm;
  private static int Iwn;
  private static int Iwo;
  private static int Iwp;
  
  public static void a(ApplicationInfo paramApplicationInfo)
  {
    AppMethodBeat.i(156057);
    if ((Build.VERSION.SDK_INT == 26) && (paramApplicationInfo.targetSdkVersion > 26))
    {
      Iwk = paramApplicationInfo.targetSdkVersion;
      paramApplicationInfo.targetSdkVersion = 26;
      ae.i("MicroMsg.AndroidOSafety", "replaceTargetVersion %s %s", new Object[] { Integer.valueOf(paramApplicationInfo.targetSdkVersion), Integer.valueOf(Iwk) });
      AppMethodBeat.o(156057);
      return;
    }
    AppMethodBeat.o(156057);
  }
  
  public static void a(a parama)
  {
    Iwj = parama;
  }
  
  /* Error */
  private static boolean cSW()
  {
    // Byte code:
    //   0: ldc 78
    //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 24	com/tencent/mm/sdk/platformtools/b:Iwl	Z
    //   8: ifeq +10 -> 18
    //   11: ldc 78
    //   13: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: iconst_1
    //   17: ireturn
    //   18: ldc 2
    //   20: monitorenter
    //   21: getstatic 24	com/tencent/mm/sdk/platformtools/b:Iwl	Z
    //   24: ifeq +13 -> 37
    //   27: ldc 2
    //   29: monitorexit
    //   30: ldc 78
    //   32: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: iconst_1
    //   36: ireturn
    //   37: ldc 80
    //   39: invokestatic 86	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   42: astore_0
    //   43: aload_0
    //   44: ldc 88
    //   46: invokevirtual 92	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   49: astore_1
    //   50: aload_1
    //   51: iconst_1
    //   52: invokevirtual 98	java/lang/reflect/Field:setAccessible	(Z)V
    //   55: aload_1
    //   56: aload_0
    //   57: invokevirtual 102	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   60: checkcast 103	[I
    //   63: checkcast 103	[I
    //   66: putstatic 105	com/tencent/mm/sdk/platformtools/b:Iwm	[I
    //   69: aload_0
    //   70: ldc 107
    //   72: invokevirtual 92	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   75: astore_1
    //   76: aload_1
    //   77: iconst_1
    //   78: invokevirtual 98	java/lang/reflect/Field:setAccessible	(Z)V
    //   81: aload_1
    //   82: aload_0
    //   83: invokevirtual 102	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   86: checkcast 52	java/lang/Integer
    //   89: invokevirtual 111	java/lang/Integer:intValue	()I
    //   92: putstatic 113	com/tencent/mm/sdk/platformtools/b:Iwn	I
    //   95: aload_0
    //   96: ldc 115
    //   98: invokevirtual 92	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   101: astore_1
    //   102: aload_1
    //   103: iconst_1
    //   104: invokevirtual 98	java/lang/reflect/Field:setAccessible	(Z)V
    //   107: aload_1
    //   108: aload_0
    //   109: invokevirtual 102	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   112: checkcast 52	java/lang/Integer
    //   115: invokevirtual 111	java/lang/Integer:intValue	()I
    //   118: putstatic 117	com/tencent/mm/sdk/platformtools/b:Iwo	I
    //   121: aload_0
    //   122: ldc 119
    //   124: invokevirtual 92	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   127: astore_1
    //   128: aload_1
    //   129: iconst_1
    //   130: invokevirtual 98	java/lang/reflect/Field:setAccessible	(Z)V
    //   133: aload_1
    //   134: aload_0
    //   135: invokevirtual 102	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   138: checkcast 52	java/lang/Integer
    //   141: invokevirtual 111	java/lang/Integer:intValue	()I
    //   144: putstatic 121	com/tencent/mm/sdk/platformtools/b:Iwp	I
    //   147: iconst_1
    //   148: putstatic 24	com/tencent/mm/sdk/platformtools/b:Iwl	Z
    //   151: ldc 2
    //   153: monitorexit
    //   154: ldc 78
    //   156: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: iconst_1
    //   160: ireturn
    //   161: astore_0
    //   162: ldc 48
    //   164: aload_0
    //   165: ldc 123
    //   167: iconst_0
    //   168: anewarray 4	java/lang/Object
    //   171: invokestatic 127	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: ldc 2
    //   176: monitorexit
    //   177: ldc 78
    //   179: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: iconst_0
    //   183: ireturn
    //   184: astore_0
    //   185: ldc 48
    //   187: aload_0
    //   188: ldc 123
    //   190: iconst_0
    //   191: anewarray 4	java/lang/Object
    //   194: invokestatic 127	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: ldc 2
    //   199: monitorexit
    //   200: ldc 78
    //   202: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: iconst_0
    //   206: ireturn
    //   207: astore_0
    //   208: ldc 48
    //   210: aload_0
    //   211: ldc 123
    //   213: iconst_0
    //   214: anewarray 4	java/lang/Object
    //   217: invokestatic 127	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   220: ldc 2
    //   222: monitorexit
    //   223: ldc 78
    //   225: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   228: iconst_0
    //   229: ireturn
    //   230: astore_0
    //   231: ldc 48
    //   233: aload_0
    //   234: ldc 123
    //   236: iconst_0
    //   237: anewarray 4	java/lang/Object
    //   240: invokestatic 127	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   243: ldc 2
    //   245: monitorexit
    //   246: ldc 78
    //   248: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   251: iconst_0
    //   252: ireturn
    //   253: astore_0
    //   254: ldc 2
    //   256: monitorexit
    //   257: ldc 78
    //   259: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static boolean p(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(156059);
    Object localObject = paramActivity.getApplicationInfo();
    int i;
    if (Build.VERSION.SDK_INT == 26) {
      if (Iwk > 26)
      {
        i = 1;
        if (i == 0) {
          break label565;
        }
        if ((paramInt != 0) && (paramInt != 6) && (paramInt != 8) && (paramInt != 11)) {
          break label117;
        }
        i = 1;
        label57:
        if (i != 0) {
          break label127;
        }
        if ((paramInt != 1) && (paramInt != 7) && (paramInt != 9) && (paramInt != 12)) {
          break label122;
        }
      }
    }
    label117:
    label122:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        break label127;
      }
      AppMethodBeat.o(156059);
      return true;
      if (((ApplicationInfo)localObject).targetSdkVersion > 26)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      i = 0;
      break label57;
    }
    label127:
    boolean bool2;
    boolean bool1;
    boolean bool3;
    if (cSW())
    {
      localObject = Iwm;
      paramInt = Iwn;
      i = Iwo;
      int j = Iwp;
      localObject = paramActivity.obtainStyledAttributes((int[])localObject);
      bool2 = ((TypedArray)localObject).getBoolean(paramInt, false);
      if ((!((TypedArray)localObject).hasValue(i)) && (((TypedArray)localObject).getBoolean(i, false)))
      {
        bool1 = true;
        bool3 = ((TypedArray)localObject).getBoolean(j, false);
        ((TypedArray)localObject).recycle();
        ae.i("MicroMsg.AndroidOSafety", "activity %s, isTranslucent %s, isFloating %s, isSwipeToDismiss %s", new Object[] { paramActivity, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
        if (!bool2) {
          break label376;
        }
        paramInt = 1;
        label249:
        if (paramInt != 1) {
          break label436;
        }
        ae.i("MicroMsg.AndroidOSafety", "invokeToOpaque %s %s", new Object[] { paramActivity, Integer.valueOf(paramActivity.hashCode()) });
        if (Iwj == null) {
          break label559;
        }
        if (Iwj.N(paramActivity)) {
          break label421;
        }
        ae.i("MicroMsg.AndroidOSafety", "not support swipe %s %s", new Object[] { paramActivity, Integer.valueOf(paramActivity.hashCode()) });
        bool1 = false;
        label325:
        bool2 = bool1;
        if (Iwj != null)
        {
          Iwj.zc(paramInt);
          if (paramInt != 2) {
            break label513;
          }
          Iwj.zc(0);
          bool2 = bool1;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(156059);
      return bool2;
      bool1 = false;
      break;
      label376:
      if (bool3)
      {
        paramInt = 2;
        break label249;
      }
      if (bool1)
      {
        paramInt = 3;
        break label249;
      }
      paramInt = 0;
      break label249;
      ae.e("MicroMsg.AndroidOSafety", "prepare Failed %s", new Object[] { paramActivity });
      paramInt = 4;
      break label249;
      label421:
      Iwj.M(paramActivity);
      bool1 = true;
      break label325;
      label436:
      if ((paramInt == 2) || (paramInt == 3))
      {
        ae.e("MicroMsg.AndroidOSafety", "ignore by IS_FLOATING or IS_SWIPE_TO_DISMISS  %s %s", new Object[] { paramActivity, Integer.valueOf(paramActivity.hashCode()) });
        bool1 = false;
        break label325;
      }
      if (paramInt == 4)
      {
        ae.e("MicroMsg.AndroidOSafety", "prepare Failed  %s %s", new Object[] { paramActivity, Integer.valueOf(paramActivity.hashCode()) });
        bool1 = false;
        break label325;
        label513:
        if (paramInt == 3)
        {
          Iwj.zc(1);
          bool2 = bool1;
          continue;
        }
        bool2 = bool1;
        if (paramInt != 4) {
          continue;
        }
        Iwj.zc(2);
        bool2 = bool1;
        continue;
      }
      label559:
      bool1 = true;
      break label325;
      label565:
      bool2 = true;
    }
  }
  
  public static abstract interface a
  {
    public abstract void M(Activity paramActivity);
    
    public abstract boolean N(Activity paramActivity);
    
    public abstract void zc(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.b
 * JD-Core Version:    0.7.0.1
 */