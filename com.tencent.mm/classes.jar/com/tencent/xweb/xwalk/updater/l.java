package com.tencent.xweb.xwalk.updater;

public final class l
{
  private static boolean aira = false;
  private static long airb = 0L;
  
  public static long kkl()
  {
    return airb;
  }
  
  /* Error */
  public static boolean kkm()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 20
    //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 12	com/tencent/xweb/xwalk/updater/l:aira	Z
    //   11: ifeq +22 -> 33
    //   14: ldc 28
    //   16: ldc 30
    //   18: invokestatic 36	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc 20
    //   23: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: iconst_1
    //   27: istore_2
    //   28: ldc 2
    //   30: monitorexit
    //   31: iload_2
    //   32: ireturn
    //   33: invokestatic 45	org/xwalk/core/XWalkSharedPreferenceUtil:getMMKVSharedPreferencesForUpdatingTag	()Landroid/content/SharedPreferences;
    //   36: astore_3
    //   37: aload_3
    //   38: ldc 47
    //   40: iconst_m1
    //   41: invokeinterface 53 3 0
    //   46: istore_0
    //   47: iload_0
    //   48: invokestatic 59	android/os/Process:myPid	()I
    //   51: if_icmpne +39 -> 90
    //   54: ldc 28
    //   56: new 61	java/lang/StringBuilder
    //   59: dup
    //   60: ldc 63
    //   62: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   65: iload_0
    //   66: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   69: ldc 73
    //   71: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 36	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: ldc 20
    //   82: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: iconst_1
    //   86: istore_2
    //   87: goto -59 -> 28
    //   90: iload_0
    //   91: ifge +13 -> 104
    //   94: ldc 20
    //   96: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: iconst_0
    //   100: istore_2
    //   101: goto -73 -> 28
    //   104: invokestatic 84	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   107: ldc 86
    //   109: invokevirtual 92	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   112: checkcast 94	android/app/ActivityManager
    //   115: astore 4
    //   117: aload 4
    //   119: ifnull +11 -> 130
    //   122: aload 4
    //   124: invokevirtual 98	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   127: ifnonnull +13 -> 140
    //   130: ldc 20
    //   132: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: iconst_0
    //   136: istore_2
    //   137: goto -109 -> 28
    //   140: invokestatic 101	android/os/Process:myUid	()I
    //   143: istore_1
    //   144: aload 4
    //   146: invokevirtual 98	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   149: invokeinterface 107 1 0
    //   154: astore 4
    //   156: aload 4
    //   158: invokeinterface 112 1 0
    //   163: ifeq +69 -> 232
    //   166: aload 4
    //   168: invokeinterface 116 1 0
    //   173: checkcast 118	android/app/ActivityManager$RunningAppProcessInfo
    //   176: astore 5
    //   178: aload 5
    //   180: getfield 122	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   183: iload_0
    //   184: if_icmpne -28 -> 156
    //   187: aload 5
    //   189: getfield 125	android/app/ActivityManager$RunningAppProcessInfo:uid	I
    //   192: iload_1
    //   193: if_icmpne +39 -> 232
    //   196: ldc 28
    //   198: new 61	java/lang/StringBuilder
    //   201: dup
    //   202: ldc 127
    //   204: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   207: iload_0
    //   208: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: ldc 73
    //   213: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 36	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: ldc 20
    //   224: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   227: iconst_1
    //   228: istore_2
    //   229: goto -201 -> 28
    //   232: aload_3
    //   233: invokeinterface 131 1 0
    //   238: astore_3
    //   239: aload_3
    //   240: ldc 47
    //   242: invokeinterface 137 2 0
    //   247: pop
    //   248: aload_3
    //   249: invokeinterface 140 1 0
    //   254: pop
    //   255: ldc 20
    //   257: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   260: iconst_0
    //   261: istore_2
    //   262: goto -234 -> 28
    //   265: astore_3
    //   266: ldc 2
    //   268: monitorexit
    //   269: aload_3
    //   270: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   46	162	0	i	int
    //   143	51	1	j	int
    //   27	235	2	bool	boolean
    //   36	213	3	localObject1	Object
    //   265	5	3	localObject2	Object
    //   115	52	4	localObject3	Object
    //   176	12	5	localRunningAppProcessInfo	android.app.ActivityManager.RunningAppProcessInfo
    // Exception table:
    //   from	to	target	type
    //   3	26	265	finally
    //   33	85	265	finally
    //   94	99	265	finally
    //   104	117	265	finally
    //   122	130	265	finally
    //   130	135	265	finally
    //   140	156	265	finally
    //   156	227	265	finally
    //   232	260	265	finally
  }
  
  /* Error */
  public static boolean kkn()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 142
    //   7: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: invokestatic 144	com/tencent/xweb/xwalk/updater/l:kkm	()Z
    //   13: ifeq +22 -> 35
    //   16: ldc 28
    //   18: ldc 30
    //   20: invokestatic 36	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: iconst_0
    //   24: istore_1
    //   25: ldc 142
    //   27: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: ldc 2
    //   32: monitorexit
    //   33: iload_1
    //   34: ireturn
    //   35: iconst_1
    //   36: putstatic 12	com/tencent/xweb/xwalk/updater/l:aira	Z
    //   39: invokestatic 59	android/os/Process:myPid	()I
    //   42: istore_0
    //   43: invokestatic 45	org/xwalk/core/XWalkSharedPreferenceUtil:getMMKVSharedPreferencesForUpdatingTag	()Landroid/content/SharedPreferences;
    //   46: invokeinterface 131 1 0
    //   51: astore_2
    //   52: aload_2
    //   53: ldc 47
    //   55: iload_0
    //   56: invokeinterface 148 3 0
    //   61: pop
    //   62: aload_2
    //   63: ldc 150
    //   65: invokestatic 155	java/lang/System:currentTimeMillis	()J
    //   68: invokeinterface 159 4 0
    //   73: pop
    //   74: aload_2
    //   75: invokeinterface 140 1 0
    //   80: pop
    //   81: ldc 28
    //   83: ldc 161
    //   85: invokestatic 36	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: ldc 142
    //   90: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: goto -63 -> 30
    //   96: astore_2
    //   97: ldc 2
    //   99: monitorexit
    //   100: aload_2
    //   101: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   42	14	0	i	int
    //   1	33	1	bool	boolean
    //   51	24	2	localEditor	android.content.SharedPreferences.Editor
    //   96	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	23	96	finally
    //   25	30	96	finally
    //   35	93	96	finally
  }
  
  /* Error */
  public static void kko()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 163
    //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 12	com/tencent/xweb/xwalk/updater/l:aira	Z
    //   11: ifne +19 -> 30
    //   14: ldc 28
    //   16: ldc 165
    //   18: invokestatic 36	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc 163
    //   23: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: ldc 2
    //   28: monitorexit
    //   29: return
    //   30: iconst_0
    //   31: putstatic 12	com/tencent/xweb/xwalk/updater/l:aira	Z
    //   34: invokestatic 155	java/lang/System:currentTimeMillis	()J
    //   37: putstatic 14	com/tencent/xweb/xwalk/updater/l:airb	J
    //   40: invokestatic 45	org/xwalk/core/XWalkSharedPreferenceUtil:getMMKVSharedPreferencesForUpdatingTag	()Landroid/content/SharedPreferences;
    //   43: invokeinterface 131 1 0
    //   48: astore_0
    //   49: aload_0
    //   50: ldc 47
    //   52: invokeinterface 137 2 0
    //   57: pop
    //   58: aload_0
    //   59: invokeinterface 140 1 0
    //   64: pop
    //   65: ldc 28
    //   67: ldc 167
    //   69: invokestatic 36	org/xwalk/core/XWalkEnvironment:addXWalkInitializeLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: ldc 163
    //   74: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: goto -51 -> 26
    //   80: astore_0
    //   81: ldc 2
    //   83: monitorexit
    //   84: aload_0
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   48	11	0	localEditor	android.content.SharedPreferences.Editor
    //   80	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	26	80	finally
    //   30	77	80	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.updater.l
 * JD-Core Version:    0.7.0.1
 */