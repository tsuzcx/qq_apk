package com.tencent.xweb.xwalk.updater;

import java.nio.channels.FileLock;

public final class h
{
  static boolean SJv = false;
  static FileLock SJw = null;
  
  /* Error */
  public static boolean hvR()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 18
    //   5: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 12	com/tencent/xweb/xwalk/updater/h:SJv	Z
    //   11: ifeq +20 -> 31
    //   14: ldc 26
    //   16: invokestatic 32	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   19: ldc 18
    //   21: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: iconst_1
    //   25: istore_2
    //   26: ldc 2
    //   28: monitorexit
    //   29: iload_2
    //   30: ireturn
    //   31: ldc 37
    //   33: invokestatic 43	org/xwalk/core/XWalkEnvironment:getMMKVSharedPreferences	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   36: astore_3
    //   37: aload_3
    //   38: ldc 45
    //   40: iconst_m1
    //   41: invokeinterface 51 3 0
    //   46: istore_0
    //   47: iload_0
    //   48: invokestatic 57	android/os/Process:myPid	()I
    //   51: if_icmpne +18 -> 69
    //   54: ldc 59
    //   56: invokestatic 32	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   59: ldc 18
    //   61: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: iconst_1
    //   65: istore_2
    //   66: goto -40 -> 26
    //   69: iload_0
    //   70: ifge +13 -> 83
    //   73: ldc 18
    //   75: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: iconst_0
    //   79: istore_2
    //   80: goto -54 -> 26
    //   83: invokestatic 63	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   86: ldc 65
    //   88: invokevirtual 71	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   91: checkcast 73	android/app/ActivityManager
    //   94: astore 4
    //   96: aload 4
    //   98: ifnull +11 -> 109
    //   101: aload 4
    //   103: invokevirtual 77	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   106: ifnonnull +13 -> 119
    //   109: ldc 18
    //   111: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: iconst_0
    //   115: istore_2
    //   116: goto -90 -> 26
    //   119: invokestatic 57	android/os/Process:myPid	()I
    //   122: pop
    //   123: invokestatic 80	android/os/Process:myUid	()I
    //   126: istore_1
    //   127: aload 4
    //   129: invokevirtual 77	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   132: invokeinterface 86 1 0
    //   137: astore 4
    //   139: aload 4
    //   141: invokeinterface 91 1 0
    //   146: ifeq +48 -> 194
    //   149: aload 4
    //   151: invokeinterface 95 1 0
    //   156: checkcast 97	android/app/ActivityManager$RunningAppProcessInfo
    //   159: astore 5
    //   161: aload 5
    //   163: getfield 101	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   166: iload_0
    //   167: if_icmpne -28 -> 139
    //   170: aload 5
    //   172: getfield 104	android/app/ActivityManager$RunningAppProcessInfo:uid	I
    //   175: iload_1
    //   176: if_icmpne +18 -> 194
    //   179: ldc 106
    //   181: invokestatic 32	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   184: ldc 18
    //   186: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: iconst_1
    //   190: istore_2
    //   191: goto -165 -> 26
    //   194: invokestatic 57	android/os/Process:myPid	()I
    //   197: pop
    //   198: aload_3
    //   199: invokeinterface 110 1 0
    //   204: astore_3
    //   205: aload_3
    //   206: ldc 45
    //   208: invokeinterface 116 2 0
    //   213: pop
    //   214: aload_3
    //   215: invokeinterface 119 1 0
    //   220: pop
    //   221: ldc 18
    //   223: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: iconst_0
    //   227: istore_2
    //   228: goto -202 -> 26
    //   231: astore_3
    //   232: ldc 2
    //   234: monitorexit
    //   235: aload_3
    //   236: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   46	122	0	i	int
    //   126	51	1	j	int
    //   25	203	2	bool	boolean
    //   36	179	3	localObject1	Object
    //   231	5	3	localObject2	Object
    //   94	56	4	localObject3	Object
    //   159	12	5	localRunningAppProcessInfo	android.app.ActivityManager.RunningAppProcessInfo
    // Exception table:
    //   from	to	target	type
    //   3	24	231	finally
    //   31	64	231	finally
    //   73	78	231	finally
    //   83	96	231	finally
    //   101	109	231	finally
    //   109	114	231	finally
    //   119	139	231	finally
    //   139	189	231	finally
    //   194	226	231	finally
  }
  
  /* Error */
  public static boolean hvS()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 121
    //   7: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: invokestatic 123	com/tencent/xweb/xwalk/updater/h:hvR	()Z
    //   13: ifeq +20 -> 33
    //   16: ldc 125
    //   18: invokestatic 126	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   21: iconst_0
    //   22: istore_1
    //   23: ldc 121
    //   25: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: iload_1
    //   32: ireturn
    //   33: iconst_1
    //   34: putstatic 12	com/tencent/xweb/xwalk/updater/h:SJv	Z
    //   37: invokestatic 57	android/os/Process:myPid	()I
    //   40: istore_0
    //   41: ldc 37
    //   43: invokestatic 43	org/xwalk/core/XWalkEnvironment:getMMKVSharedPreferences	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   46: invokeinterface 110 1 0
    //   51: astore_2
    //   52: aload_2
    //   53: ldc 45
    //   55: iload_0
    //   56: invokeinterface 130 3 0
    //   61: pop
    //   62: aload_2
    //   63: ldc 132
    //   65: invokestatic 138	java/lang/System:currentTimeMillis	()J
    //   68: invokeinterface 142 4 0
    //   73: pop
    //   74: aload_2
    //   75: invokeinterface 119 1 0
    //   80: pop
    //   81: ldc 144
    //   83: invokestatic 32	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   86: ldc 121
    //   88: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: goto -63 -> 28
    //   94: astore_2
    //   95: ldc 2
    //   97: monitorexit
    //   98: aload_2
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   40	16	0	i	int
    //   1	31	1	bool	boolean
    //   51	24	2	localEditor	android.content.SharedPreferences.Editor
    //   94	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	21	94	finally
    //   23	28	94	finally
    //   33	91	94	finally
  }
  
  /* Error */
  public static void hvT()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 146
    //   5: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 12	com/tencent/xweb/xwalk/updater/h:SJv	Z
    //   11: ifne +12 -> 23
    //   14: ldc 146
    //   16: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: iconst_0
    //   24: putstatic 12	com/tencent/xweb/xwalk/updater/h:SJv	Z
    //   27: invokestatic 57	android/os/Process:myPid	()I
    //   30: pop
    //   31: ldc 37
    //   33: invokestatic 43	org/xwalk/core/XWalkEnvironment:getMMKVSharedPreferences	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   36: invokeinterface 110 1 0
    //   41: astore_0
    //   42: aload_0
    //   43: ldc 45
    //   45: invokeinterface 116 2 0
    //   50: pop
    //   51: aload_0
    //   52: invokeinterface 119 1 0
    //   57: pop
    //   58: ldc 148
    //   60: invokestatic 32	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   63: ldc 146
    //   65: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: goto -49 -> 19
    //   71: astore_0
    //   72: ldc 2
    //   74: monitorexit
    //   75: aload_0
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   41	11	0	localEditor	android.content.SharedPreferences.Editor
    //   71	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	19	71	finally
    //   23	68	71	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.h
 * JD-Core Version:    0.7.0.1
 */