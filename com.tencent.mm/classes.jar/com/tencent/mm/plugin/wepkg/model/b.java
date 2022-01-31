package com.tencent.mm.plugin.wepkg.model;

public class b
{
  private static b rOX = null;
  
  /* Error */
  public static b cjX()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 12	com/tencent/mm/plugin/wepkg/model/b:rOX	Lcom/tencent/mm/plugin/wepkg/model/b;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 12	com/tencent/mm/plugin/wepkg/model/b:rOX	Lcom/tencent/mm/plugin/wepkg/model/b;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	com/tencent/mm/plugin/wepkg/model/b
    //   21: dup
    //   22: invokespecial 47	com/tencent/mm/plugin/wepkg/model/b:<init>	()V
    //   25: putstatic 12	com/tencent/mm/plugin/wepkg/model/b:rOX	Lcom/tencent/mm/plugin/wepkg/model/b;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 12	com/tencent/mm/plugin/wepkg/model/b:rOX	Lcom/tencent/mm/plugin/wepkg/model/b;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localb	b
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  /* Error */
  public final void cjY()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 54	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   7: ldc 56
    //   9: iconst_0
    //   10: invokevirtual 62	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   13: astore 5
    //   15: aload 5
    //   17: ldc 64
    //   19: lconst_0
    //   20: invokeinterface 70 4 0
    //   25: lstore_2
    //   26: invokestatic 76	java/lang/System:currentTimeMillis	()J
    //   29: lload_2
    //   30: lsub
    //   31: ldc2_w 77
    //   34: lcmp
    //   35: ifle +139 -> 174
    //   38: iconst_1
    //   39: istore 4
    //   41: ldc 80
    //   43: ldc 82
    //   45: iconst_1
    //   46: anewarray 4	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: iload 4
    //   53: invokestatic 88	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   56: aastore
    //   57: invokestatic 94	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   60: iload 4
    //   62: ifeq +39 -> 101
    //   65: aload 5
    //   67: invokeinterface 98 1 0
    //   72: ldc 64
    //   74: invokestatic 76	java/lang/System:currentTimeMillis	()J
    //   77: invokeinterface 104 4 0
    //   82: invokeinterface 108 1 0
    //   87: pop
    //   88: new 110	com/tencent/mm/plugin/wepkg/model/b$1
    //   91: dup
    //   92: aload_0
    //   93: invokespecial 113	com/tencent/mm/plugin/wepkg/model/b$1:<init>	(Lcom/tencent/mm/plugin/wepkg/model/b;)V
    //   96: ldc 115
    //   98: invokestatic 121	com/tencent/mm/sdk/f/e:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   101: aload 5
    //   103: ldc 123
    //   105: lconst_0
    //   106: invokeinterface 70 4 0
    //   111: lstore_2
    //   112: invokestatic 76	java/lang/System:currentTimeMillis	()J
    //   115: lload_2
    //   116: lsub
    //   117: ldc2_w 124
    //   120: lcmp
    //   121: ifle +59 -> 180
    //   124: iload_1
    //   125: ifeq +46 -> 171
    //   128: ldc 80
    //   130: ldc 127
    //   132: invokestatic 129	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload 5
    //   137: invokeinterface 98 1 0
    //   142: ldc 123
    //   144: invokestatic 76	java/lang/System:currentTimeMillis	()J
    //   147: invokeinterface 104 4 0
    //   152: invokeinterface 108 1 0
    //   157: pop
    //   158: new 131	com/tencent/mm/plugin/wepkg/model/b$2
    //   161: dup
    //   162: aload_0
    //   163: invokespecial 132	com/tencent/mm/plugin/wepkg/model/b$2:<init>	(Lcom/tencent/mm/plugin/wepkg/model/b;)V
    //   166: ldc 134
    //   168: invokestatic 121	com/tencent/mm/sdk/f/e:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   171: aload_0
    //   172: monitorexit
    //   173: return
    //   174: iconst_0
    //   175: istore 4
    //   177: goto -136 -> 41
    //   180: iconst_0
    //   181: istore_1
    //   182: goto -58 -> 124
    //   185: astore 5
    //   187: aload_0
    //   188: monitorexit
    //   189: aload 5
    //   191: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	b
    //   1	181	1	i	int
    //   25	91	2	l	long
    //   39	137	4	bool	boolean
    //   13	123	5	localSharedPreferences	android.content.SharedPreferences
    //   185	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	38	185	finally
    //   41	60	185	finally
    //   65	101	185	finally
    //   101	124	185	finally
    //   128	171	185	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wepkg.model.b
 * JD-Core Version:    0.7.0.1
 */