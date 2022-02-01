package com.tencent.xweb.xwalk.updater;

import java.nio.channels.FileLock;

public final class g
{
  static boolean MWn = false;
  static FileLock MWo = null;
  
  /* Error */
  public static boolean gir()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 18
    //   5: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 12	com/tencent/xweb/xwalk/updater/g:MWn	Z
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
    //   96: invokestatic 57	android/os/Process:myPid	()I
    //   99: pop
    //   100: invokestatic 76	android/os/Process:myUid	()I
    //   103: istore_1
    //   104: aload 4
    //   106: invokevirtual 80	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   109: invokeinterface 86 1 0
    //   114: astore 4
    //   116: aload 4
    //   118: invokeinterface 91 1 0
    //   123: ifeq +48 -> 171
    //   126: aload 4
    //   128: invokeinterface 95 1 0
    //   133: checkcast 97	android/app/ActivityManager$RunningAppProcessInfo
    //   136: astore 5
    //   138: aload 5
    //   140: getfield 101	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   143: iload_0
    //   144: if_icmpne -28 -> 116
    //   147: aload 5
    //   149: getfield 104	android/app/ActivityManager$RunningAppProcessInfo:uid	I
    //   152: iload_1
    //   153: if_icmpne +18 -> 171
    //   156: ldc 106
    //   158: invokestatic 32	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   161: ldc 18
    //   163: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   166: iconst_1
    //   167: istore_2
    //   168: goto -142 -> 26
    //   171: invokestatic 57	android/os/Process:myPid	()I
    //   174: pop
    //   175: aload_3
    //   176: invokeinterface 110 1 0
    //   181: astore_3
    //   182: aload_3
    //   183: ldc 45
    //   185: invokeinterface 116 2 0
    //   190: pop
    //   191: aload_3
    //   192: invokeinterface 119 1 0
    //   197: pop
    //   198: ldc 18
    //   200: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: iconst_0
    //   204: istore_2
    //   205: goto -179 -> 26
    //   208: astore_3
    //   209: ldc 2
    //   211: monitorexit
    //   212: aload_3
    //   213: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   46	99	0	i	int
    //   103	51	1	j	int
    //   25	180	2	bool	boolean
    //   36	156	3	localObject1	Object
    //   208	5	3	localObject2	Object
    //   94	33	4	localObject3	Object
    //   136	12	5	localRunningAppProcessInfo	android.app.ActivityManager.RunningAppProcessInfo
    // Exception table:
    //   from	to	target	type
    //   3	24	208	finally
    //   31	64	208	finally
    //   73	78	208	finally
    //   83	116	208	finally
    //   116	166	208	finally
    //   171	203	208	finally
  }
  
  /* Error */
  public static boolean gis()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 121
    //   7: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: invokestatic 123	com/tencent/xweb/xwalk/updater/g:gir	()Z
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
    //   34: putstatic 12	com/tencent/xweb/xwalk/updater/g:MWn	Z
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
  public static void git()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 146
    //   5: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 12	com/tencent/xweb/xwalk/updater/g:MWn	Z
    //   11: ifne +12 -> 23
    //   14: ldc 146
    //   16: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: iconst_0
    //   24: putstatic 12	com/tencent/xweb/xwalk/updater/g:MWn	Z
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.g
 * JD-Core Version:    0.7.0.1
 */