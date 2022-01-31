package com.tencent.mm.plugin.music.model.notification;

import com.tencent.mm.sdk.b.c;

public final class b
{
  public c giK;
  public MMMusicPlayerService mzL;
  volatile boolean mzR = false;
  
  /* Error */
  final void bnw()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 20	com/tencent/mm/plugin/music/model/notification/b:mzL	Lcom/tencent/mm/plugin/music/model/notification/MMMusicPlayerService;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 16	com/tencent/mm/plugin/music/model/notification/b:mzR	Z
    //   13: istore_1
    //   14: iload_1
    //   15: ifeq +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: iconst_1
    //   23: putfield 16	com/tencent/mm/plugin/music/model/notification/b:mzR	Z
    //   26: new 22	android/content/Intent
    //   29: dup
    //   30: invokespecial 23	android/content/Intent:<init>	()V
    //   33: astore_2
    //   34: aload_2
    //   35: invokestatic 29	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   38: ldc 31
    //   40: invokevirtual 35	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   43: pop
    //   44: ldc 37
    //   46: ldc 39
    //   48: iconst_1
    //   49: anewarray 4	java/lang/Object
    //   52: dup
    //   53: iconst_0
    //   54: invokestatic 29	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   57: aload_2
    //   58: new 41	com/tencent/mm/plugin/music/model/notification/b$2
    //   61: dup
    //   62: aload_0
    //   63: invokespecial 44	com/tencent/mm/plugin/music/model/notification/b$2:<init>	(Lcom/tencent/mm/plugin/music/model/notification/b;)V
    //   66: iconst_1
    //   67: invokevirtual 50	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   70: invokestatic 56	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   73: aastore
    //   74: invokestatic 62	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   77: goto -59 -> 18
    //   80: astore_2
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_2
    //   84: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	b
    //   13	2	1	bool	boolean
    //   33	25	2	localIntent	android.content.Intent
    //   80	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	80	finally
    //   21	77	80	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.notification.b
 * JD-Core Version:    0.7.0.1
 */