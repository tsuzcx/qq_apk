package com.tencent.view;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c
{
  private static c BzO;
  private a BzP;
  String BzQ;
  private Handler handler;
  public HandlerThread mGlThread;
  
  private c()
  {
    AppMethodBeat.i(86633);
    this.BzP = null;
    c.1 local1 = new c.1(this);
    this.mGlThread = new c.2(this, "GlThread");
    this.mGlThread.start();
    this.handler = new Handler(this.mGlThread.getLooper());
    this.handler.post(local1);
    AppMethodBeat.o(86633);
  }
  
  /* Error */
  public static c dXd()
  {
    // Byte code:
    //   0: ldc 71
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 73	com/tencent/view/c:BzO	Lcom/tencent/view/c;
    //   8: ifnonnull +33 -> 41
    //   11: ldc 2
    //   13: monitorenter
    //   14: getstatic 73	com/tencent/view/c:BzO	Lcom/tencent/view/c;
    //   17: ifnonnull +21 -> 38
    //   20: ldc 2
    //   22: monitorenter
    //   23: new 2	com/tencent/view/c
    //   26: dup
    //   27: invokespecial 74	com/tencent/view/c:<init>	()V
    //   30: astore_0
    //   31: ldc 2
    //   33: monitorexit
    //   34: aload_0
    //   35: putstatic 73	com/tencent/view/c:BzO	Lcom/tencent/view/c;
    //   38: ldc 2
    //   40: monitorexit
    //   41: getstatic 73	com/tencent/view/c:BzO	Lcom/tencent/view/c;
    //   44: astore_0
    //   45: ldc 71
    //   47: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: aload_0
    //   51: areturn
    //   52: astore_0
    //   53: ldc 2
    //   55: monitorexit
    //   56: ldc 71
    //   58: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: aload_0
    //   62: athrow
    //   63: astore_0
    //   64: ldc 2
    //   66: monitorexit
    //   67: ldc 71
    //   69: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aload_0
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   30	21	0	localc	c
    //   52	10	0	localObject1	Object
    //   63	10	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   23	34	52	finally
    //   53	56	52	finally
    //   14	23	63	finally
    //   34	38	63	finally
    //   38	41	63	finally
    //   56	63	63	finally
    //   64	67	63	finally
  }
  
  public final void queue(Runnable paramRunnable)
  {
    AppMethodBeat.i(86635);
    this.handler.post(paramRunnable);
    AppMethodBeat.o(86635);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.view.c
 * JD-Core Version:    0.7.0.1
 */