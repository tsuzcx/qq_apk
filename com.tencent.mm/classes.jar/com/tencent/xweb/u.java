package com.tencent.xweb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.Log;

public final class u
{
  private static boolean aieU;
  private static final List<a> eTv;
  
  static
  {
    AppMethodBeat.i(185174);
    aieU = false;
    eTv = new ArrayList();
    AppMethodBeat.o(185174);
  }
  
  public static void a(a parama)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(212405);
        init();
        if (parama == null)
        {
          AppMethodBeat.o(212405);
          return;
        }
        if (eTv.contains(parama))
        {
          AppMethodBeat.o(212405);
          continue;
        }
        eTv.add(parama);
      }
      finally {}
      AppMethodBeat.o(212405);
    }
  }
  
  private static void aJw(int paramInt)
  {
    try
    {
      AppMethodBeat.i(212420);
      Iterator localIterator = eTv.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).ET(paramInt);
      }
      AppMethodBeat.o(212420);
    }
    finally {}
  }
  
  private static void aJx(int paramInt)
  {
    try
    {
      AppMethodBeat.i(212427);
      Iterator localIterator = eTv.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).EV(paramInt);
      }
      AppMethodBeat.o(212427);
    }
    finally {}
  }
  
  private static void aJy(int paramInt)
  {
    try
    {
      AppMethodBeat.i(185171);
      Iterator localIterator = eTv.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).EU(paramInt);
      }
      AppMethodBeat.o(185171);
    }
    finally {}
  }
  
  public static void b(a parama)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(212413);
        init();
        if (parama == null)
        {
          AppMethodBeat.o(212413);
          return;
        }
        if (!eTv.contains(parama))
        {
          AppMethodBeat.o(212413);
          continue;
        }
        eTv.remove(parama);
      }
      finally {}
      AppMethodBeat.o(212413);
    }
  }
  
  /* Error */
  public static void init()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 103
    //   5: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 26	com/tencent/xweb/u:aieU	Z
    //   11: ifeq +12 -> 23
    //   14: ldc 103
    //   16: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: invokestatic 109	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   26: ifnonnull +17 -> 43
    //   29: ldc 103
    //   31: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: goto -15 -> 19
    //   37: astore_0
    //   38: ldc 2
    //   40: monitorexit
    //   41: aload_0
    //   42: athrow
    //   43: invokestatic 109	org/xwalk/core/XWalkEnvironment:getApplicationContext	()Landroid/content/Context;
    //   46: new 9	com/tencent/xweb/u$b
    //   49: dup
    //   50: iconst_0
    //   51: invokespecial 112	com/tencent/xweb/u$b:<init>	(B)V
    //   54: new 114	android/content/IntentFilter
    //   57: dup
    //   58: ldc 116
    //   60: invokespecial 119	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   63: invokevirtual 125	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   66: pop
    //   67: iconst_1
    //   68: putstatic 26	com/tencent/xweb/u:aieU	Z
    //   71: ldc 103
    //   73: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: goto -57 -> 19
    //   79: astore_0
    //   80: ldc 127
    //   82: ldc 129
    //   84: aload_0
    //   85: invokestatic 135	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   88: invokevirtual 139	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   91: invokestatic 145	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: ldc 103
    //   96: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: goto -80 -> 19
    // Local variable table:
    //   start	length	slot	name	signature
    //   37	5	0	localObject1	Object
    //   79	6	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	19	37	finally
    //   23	34	37	finally
    //   71	76	37	finally
    //   80	99	37	finally
    //   43	71	79	finally
  }
  
  private static void kft()
  {
    try
    {
      AppMethodBeat.i(185172);
      Iterator localIterator = eTv.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).cTB();
      }
      AppMethodBeat.o(185172);
    }
    finally {}
  }
  
  private static void kfu()
  {
    try
    {
      AppMethodBeat.i(185173);
      Iterator localIterator = eTv.iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).cTC();
      }
      AppMethodBeat.o(185173);
    }
    finally {}
  }
  
  public static abstract interface a
  {
    public abstract void ET(int paramInt);
    
    public abstract void EU(int paramInt);
    
    public abstract void EV(int paramInt);
    
    public abstract void cTB();
    
    public abstract void cTC();
  }
  
  static final class b
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(213638);
      if (!"com.tencent.xweb.update".equals(paramIntent.getAction()))
      {
        AppMethodBeat.o(213638);
        return;
      }
      paramContext = paramIntent.getStringExtra("stage");
      int i;
      if ("start".equals(paramContext))
      {
        i = paramIntent.getIntExtra("extra_data", 0);
        Log.i("UpdateReceiver", "update start, schedulerType:".concat(String.valueOf(i)));
        u.aJz(i);
        AppMethodBeat.o(213638);
        return;
      }
      if ("updating".equals(paramContext))
      {
        u.access$200(paramIntent.getIntExtra("extra_data", 0));
        AppMethodBeat.o(213638);
        return;
      }
      if ("finished".equals(paramContext))
      {
        i = paramIntent.getIntExtra("extra_data", 0);
        Log.i("UpdateReceiver", "update finish, code:".concat(String.valueOf(i)));
        u.nA(i);
        AppMethodBeat.o(213638);
        return;
      }
      if ("cfg_update".equals(paramContext))
      {
        Log.i("UpdateReceiver", "update main config");
        u.access$400();
        AppMethodBeat.o(213638);
        return;
      }
      if ("plugin_update".equals(paramContext))
      {
        Log.i("UpdateReceiver", "update plugin config");
        u.aBU();
      }
      AppMethodBeat.o(213638);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.u
 * JD-Core Version:    0.7.0.1
 */