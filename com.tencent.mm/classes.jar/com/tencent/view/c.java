package com.tencent.view;

import android.os.Handler;
import android.os.HandlerThread;

public class c
{
  private static c xdg;
  public Handler handler;
  private HandlerThread mGlThread;
  private a xdh = null;
  String xdi;
  
  private c()
  {
    c.1 local1 = new c.1(this);
    this.mGlThread = new c.2(this, "GlThread");
    this.mGlThread.start();
    this.handler = new Handler(this.mGlThread.getLooper());
    this.handler.post(local1);
  }
  
  /* Error */
  public static c cRn()
  {
    // Byte code:
    //   0: getstatic 62	com/tencent/view/c:xdg	Lcom/tencent/view/c;
    //   3: ifnonnull +33 -> 36
    //   6: ldc 2
    //   8: monitorenter
    //   9: getstatic 62	com/tencent/view/c:xdg	Lcom/tencent/view/c;
    //   12: ifnonnull +21 -> 33
    //   15: ldc 2
    //   17: monitorenter
    //   18: new 2	com/tencent/view/c
    //   21: dup
    //   22: invokespecial 63	com/tencent/view/c:<init>	()V
    //   25: astore_0
    //   26: ldc 2
    //   28: monitorexit
    //   29: aload_0
    //   30: putstatic 62	com/tencent/view/c:xdg	Lcom/tencent/view/c;
    //   33: ldc 2
    //   35: monitorexit
    //   36: getstatic 62	com/tencent/view/c:xdg	Lcom/tencent/view/c;
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
    //   25	5	0	localc	c
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   18	29	40	finally
    //   41	44	40	finally
    //   9	18	46	finally
    //   29	33	46	finally
    //   33	36	46	finally
    //   44	46	46	finally
    //   47	50	46	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.view.c
 * JD-Core Version:    0.7.0.1
 */