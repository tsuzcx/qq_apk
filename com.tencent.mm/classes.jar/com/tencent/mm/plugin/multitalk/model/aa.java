package com.tencent.mm.plugin.multitalk.model;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.SensorEventCallBack;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/model/ScreenSensorController;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "screenOffLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "sensorCallback", "Lcom/tencent/mm/sdk/platformtools/SensorController$SensorEventCallBack;", "sensorController", "Lcom/tencent/mm/sdk/platformtools/SensorController;", "disable", "", "enable", "turnOff", "turnOn", "Companion", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
{
  public static final aa.a LqB;
  private PowerManager.WakeLock HnS;
  final SensorController.SensorEventCallBack LqC;
  final SensorController xCV;
  
  static
  {
    AppMethodBeat.i(284886);
    LqB = new aa.a((byte)0);
    AppMethodBeat.o(284886);
  }
  
  public aa(Context paramContext)
  {
    AppMethodBeat.i(284869);
    this.xCV = new SensorController(paramContext);
    this.LqC = new aa..ExternalSyntheticLambda0(this);
    AppMethodBeat.o(284869);
  }
  
  private static final void a(aa paramaa, boolean paramBoolean)
  {
    AppMethodBeat.i(284883);
    s.u(paramaa, "this$0");
    Log.w("MicroMsg.ScreenSensorController", s.X("Sensor callback: on=", Boolean.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      paramaa.cMI();
      AppMethodBeat.o(284883);
      return;
    }
    paramaa.ggM();
    AppMethodBeat.o(284883);
  }
  
  /* Error */
  private final void cMI()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 117
    //   4: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 119	com/tencent/mm/plugin/multitalk/model/aa:HnS	Landroid/os/PowerManager$WakeLock;
    //   11: astore_1
    //   12: aload_1
    //   13: ifnull +87 -> 100
    //   16: aload_1
    //   17: invokevirtual 125	android/os/PowerManager$WakeLock:isHeld	()Z
    //   20: ifeq +80 -> 100
    //   23: aload_1
    //   24: ldc 127
    //   26: ldc 128
    //   28: ldc 129
    //   30: ldc 131
    //   32: ldc 133
    //   34: ldc 129
    //   36: invokestatic 139	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_1
    //   40: invokevirtual 141	android/os/PowerManager$WakeLock:release	()V
    //   43: aload_1
    //   44: ldc 127
    //   46: ldc 128
    //   48: ldc 129
    //   50: ldc 131
    //   52: ldc 133
    //   54: ldc 129
    //   56: invokestatic 144	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   59: ldc 92
    //   61: ldc 146
    //   63: iconst_2
    //   64: anewarray 4	java/lang/Object
    //   67: dup
    //   68: iconst_0
    //   69: aload_0
    //   70: invokevirtual 150	com/tencent/mm/plugin/multitalk/model/aa:toString	()Ljava/lang/String;
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: aload_1
    //   77: invokevirtual 125	android/os/PowerManager$WakeLock:isHeld	()Z
    //   80: invokestatic 100	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   83: aastore
    //   84: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   87: aload_0
    //   88: aconst_null
    //   89: putfield 119	com/tencent/mm/plugin/multitalk/model/aa:HnS	Landroid/os/PowerManager$WakeLock;
    //   92: ldc 117
    //   94: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: aload_0
    //   98: monitorexit
    //   99: return
    //   100: ldc 92
    //   102: ldc 155
    //   104: iconst_1
    //   105: anewarray 4	java/lang/Object
    //   108: dup
    //   109: iconst_0
    //   110: aload_0
    //   111: invokevirtual 150	com/tencent/mm/plugin/multitalk/model/aa:toString	()Ljava/lang/String;
    //   114: aastore
    //   115: invokestatic 157	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   118: ldc 117
    //   120: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: goto -26 -> 97
    //   126: astore_1
    //   127: aload_0
    //   128: monitorexit
    //   129: aload_1
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	aa
    //   11	66	1	localWakeLock	PowerManager.WakeLock
    //   126	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	126	finally
    //   16	97	126	finally
    //   100	123	126	finally
  }
  
  private final void ggM()
  {
    try
    {
      AppMethodBeat.i(284873);
      Object localObject1 = MMApplicationContext.getContext().getSystemService("power");
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.os.PowerManager");
        AppMethodBeat.o(284873);
        throw ((Throwable)localObject1);
      }
    }
    finally {}
    PowerManager localPowerManager = (PowerManager)localObject2;
    PowerManager.WakeLock localWakeLock = this.HnS;
    if (localWakeLock == null)
    {
      localWakeLock = localPowerManager.newWakeLock(32, "wechat:screen multi-talk");
      this.HnS = localWakeLock;
      if (localWakeLock.isHeld()) {
        break label152;
      }
      a.b(localWakeLock, "com/tencent/mm/plugin/multitalk/model/ScreenSensorController", "turnOff", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
      localWakeLock.acquire();
      a.c(localWakeLock, "com/tencent/mm/plugin/multitalk/model/ScreenSensorController", "turnOff", "()V", "android/os/PowerManager$WakeLock_EXEC_", "acquire", "()V");
      Log.i("MicroMsg.ScreenSensorController", "after acquire screen off wakelock from object: %s, isHeld: %s", new Object[] { toString(), Boolean.valueOf(localWakeLock.isHeld()) });
      AppMethodBeat.o(284873);
    }
    for (;;)
    {
      return;
      break;
      label152:
      Log.w("MicroMsg.ScreenSensorController", "repeatedly acquire screen off wakelock from object: %s, drop this call.", new Object[] { toString() });
      AppMethodBeat.o(284873);
    }
  }
  
  public final void disable()
  {
    AppMethodBeat.i(284894);
    Log.i("MicroMsg.ScreenSensorController", "disable()");
    this.xCV.removeSensorCallBack();
    cMI();
    AppMethodBeat.o(284894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.aa
 * JD-Core Version:    0.7.0.1
 */