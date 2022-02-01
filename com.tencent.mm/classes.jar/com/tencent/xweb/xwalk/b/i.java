package com.tencent.xweb.xwalk.b;

import java.nio.channels.FileLock;

public final class i
{
  static long aaln = 0L;
  static boolean aalo = false;
  static FileLock aalp = null;
  
  /* Error */
  public static boolean izO()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 22
    //   5: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 16	com/tencent/xweb/xwalk/b/i:aalo	Z
    //   11: ifeq +20 -> 31
    //   14: ldc 30
    //   16: invokestatic 36	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   19: ldc 22
    //   21: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: iconst_1
    //   25: istore_2
    //   26: ldc 2
    //   28: monitorexit
    //   29: iload_2
    //   30: ireturn
    //   31: ldc 41
    //   33: invokestatic 47	org/xwalk/core/XWalkEnvironment:getMMKVSharedPreferences	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   36: astore_3
    //   37: aload_3
    //   38: ldc 49
    //   40: iconst_m1
    //   41: invokeinterface 55 3 0
    //   46: istore_0
    //   47: iload_0
    //   48: invokestatic 61	android/os/Process:myPid	()I
    //   51: if_icmpne +18 -> 69
    //   54: ldc 63
    //   56: invokestatic 36	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   59: ldc 22
    //   61: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: iconst_1
    //   65: istore_2
    //   66: goto -40 -> 26
    //   69: iload_0
    //   70: ifge +13 -> 83
    //   73: ldc 22
    //   75: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: iconst_0
    //   79: istore_2
    //   80: goto -54 -> 26
    //   83: invokestatic 67	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   86: ldc 69
    //   88: invokevirtual 75	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   91: checkcast 77	android/app/ActivityManager
    //   94: astore 4
    //   96: aload 4
    //   98: ifnull +11 -> 109
    //   101: aload 4
    //   103: invokevirtual 81	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   106: ifnonnull +13 -> 119
    //   109: ldc 22
    //   111: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: iconst_0
    //   115: istore_2
    //   116: goto -90 -> 26
    //   119: invokestatic 61	android/os/Process:myPid	()I
    //   122: pop
    //   123: invokestatic 84	android/os/Process:myUid	()I
    //   126: istore_1
    //   127: aload 4
    //   129: invokevirtual 81	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   132: invokeinterface 90 1 0
    //   137: astore 4
    //   139: aload 4
    //   141: invokeinterface 95 1 0
    //   146: ifeq +48 -> 194
    //   149: aload 4
    //   151: invokeinterface 99 1 0
    //   156: checkcast 101	android/app/ActivityManager$RunningAppProcessInfo
    //   159: astore 5
    //   161: aload 5
    //   163: getfield 105	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   166: iload_0
    //   167: if_icmpne -28 -> 139
    //   170: aload 5
    //   172: getfield 108	android/app/ActivityManager$RunningAppProcessInfo:uid	I
    //   175: iload_1
    //   176: if_icmpne +18 -> 194
    //   179: ldc 110
    //   181: invokestatic 36	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   184: ldc 22
    //   186: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: iconst_1
    //   190: istore_2
    //   191: goto -165 -> 26
    //   194: invokestatic 61	android/os/Process:myPid	()I
    //   197: pop
    //   198: aload_3
    //   199: invokeinterface 114 1 0
    //   204: astore_3
    //   205: aload_3
    //   206: ldc 49
    //   208: invokeinterface 120 2 0
    //   213: pop
    //   214: aload_3
    //   215: invokeinterface 123 1 0
    //   220: pop
    //   221: ldc 22
    //   223: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  public static boolean izP()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 125
    //   7: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: invokestatic 127	com/tencent/xweb/xwalk/b/i:izO	()Z
    //   13: ifeq +20 -> 33
    //   16: ldc 129
    //   18: invokestatic 130	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   21: iconst_0
    //   22: istore_1
    //   23: ldc 125
    //   25: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: ldc 2
    //   30: monitorexit
    //   31: iload_1
    //   32: ireturn
    //   33: iconst_1
    //   34: putstatic 16	com/tencent/xweb/xwalk/b/i:aalo	Z
    //   37: invokestatic 61	android/os/Process:myPid	()I
    //   40: istore_0
    //   41: ldc 41
    //   43: invokestatic 47	org/xwalk/core/XWalkEnvironment:getMMKVSharedPreferences	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   46: invokeinterface 114 1 0
    //   51: astore_2
    //   52: aload_2
    //   53: ldc 49
    //   55: iload_0
    //   56: invokeinterface 134 3 0
    //   61: pop
    //   62: aload_2
    //   63: ldc 136
    //   65: invokestatic 142	java/lang/System:currentTimeMillis	()J
    //   68: invokeinterface 146 4 0
    //   73: pop
    //   74: aload_2
    //   75: invokeinterface 123 1 0
    //   80: pop
    //   81: ldc 148
    //   83: invokestatic 36	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   86: ldc 125
    //   88: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  public static void izQ()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 150
    //   5: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 16	com/tencent/xweb/xwalk/b/i:aalo	Z
    //   11: ifne +12 -> 23
    //   14: ldc 150
    //   16: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: invokestatic 142	java/lang/System:currentTimeMillis	()J
    //   26: putstatic 14	com/tencent/xweb/xwalk/b/i:aaln	J
    //   29: iconst_0
    //   30: putstatic 16	com/tencent/xweb/xwalk/b/i:aalo	Z
    //   33: invokestatic 61	android/os/Process:myPid	()I
    //   36: pop
    //   37: ldc 41
    //   39: invokestatic 47	org/xwalk/core/XWalkEnvironment:getMMKVSharedPreferences	(Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   42: invokeinterface 114 1 0
    //   47: astore_0
    //   48: aload_0
    //   49: ldc 49
    //   51: invokeinterface 120 2 0
    //   56: pop
    //   57: aload_0
    //   58: invokeinterface 123 1 0
    //   63: pop
    //   64: ldc 152
    //   66: invokestatic 36	org/xwalk/core/XWalkInitializer:addXWalkInitializeLog	(Ljava/lang/String;)V
    //   69: ldc 150
    //   71: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: goto -55 -> 19
    //   77: astore_0
    //   78: ldc 2
    //   80: monitorexit
    //   81: aload_0
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   47	11	0	localEditor	android.content.SharedPreferences.Editor
    //   77	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	19	77	finally
    //   23	74	77	finally
  }
  
  public static long izT()
  {
    return aaln;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.b.i
 * JD-Core Version:    0.7.0.1
 */