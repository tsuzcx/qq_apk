package com.tencent.mm.plugin.music.model.notification;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.np;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import junit.framework.Assert;

public final class b
{
  public MMMusicPlayerService FSg;
  volatile boolean FSm = false;
  public IListener ozM;
  
  /* Error */
  final void ffc()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 23
    //   4: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 31	com/tencent/mm/plugin/music/model/notification/b:FSg	Lcom/tencent/mm/plugin/music/model/notification/MMMusicPlayerService;
    //   11: ifnull +18 -> 29
    //   14: aload_0
    //   15: getfield 20	com/tencent/mm/plugin/music/model/notification/b:FSm	Z
    //   18: ifeq +11 -> 29
    //   21: ldc 23
    //   23: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: aload_0
    //   30: iconst_1
    //   31: putfield 20	com/tencent/mm/plugin/music/model/notification/b:FSm	Z
    //   34: new 36	android/content/Intent
    //   37: dup
    //   38: invokespecial 37	android/content/Intent:<init>	()V
    //   41: astore_1
    //   42: aload_1
    //   43: invokestatic 43	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   46: ldc 45
    //   48: invokevirtual 49	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   51: pop
    //   52: ldc 51
    //   54: ldc 53
    //   56: iconst_1
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: invokestatic 43	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   65: aload_1
    //   66: new 8	com/tencent/mm/plugin/music/model/notification/b$2
    //   69: dup
    //   70: aload_0
    //   71: invokespecial 56	com/tencent/mm/plugin/music/model/notification/b$2:<init>	(Lcom/tencent/mm/plugin/music/model/notification/b;)V
    //   74: iconst_1
    //   75: invokevirtual 62	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   78: invokestatic 68	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   81: aastore
    //   82: invokestatic 73	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   85: ldc 23
    //   87: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   90: goto -64 -> 26
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	b
    //   41	25	1	localIntent	android.content.Intent
    //   93	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	93	finally
    //   29	90	93	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.notification.b
 * JD-Core Version:    0.7.0.1
 */