package com.tencent.mm.vending.e;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b<_Target extends a>
  implements a
{
  private boolean YJ = true;
  private List<WeakReference<_Target>> ZX = new ArrayList();
  
  /* Error */
  public final void a(_Target param_Target)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	com/tencent/mm/vending/e/b:YJ	Z
    //   6: ifne +16 -> 22
    //   9: aload_1
    //   10: invokestatic 32	junit/framework/Assert:assertNotNull	(Ljava/lang/Object;)V
    //   13: aload_1
    //   14: invokeinterface 35 1 0
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 21	com/tencent/mm/vending/e/b:ZX	Ljava/util/List;
    //   26: new 37	java/lang/ref/WeakReference
    //   29: dup
    //   30: aload_1
    //   31: invokespecial 39	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   34: invokeinterface 45 2 0
    //   39: pop
    //   40: goto -21 -> 19
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	b
    //   0	48	1	param_Target	_Target
    // Exception table:
    //   from	to	target	type
    //   2	19	43	finally
    //   22	40	43	finally
  }
  
  public final void lw()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.YJ;
        if (!bool) {
          return;
        }
        Iterator localIterator = this.ZX.iterator();
        if (localIterator.hasNext())
        {
          a locala = (a)((WeakReference)localIterator.next()).get();
          if (locala == null) {
            continue;
          }
          locala.lw();
          continue;
        }
        this.ZX.clear();
      }
      finally {}
      this.YJ = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.e.b
 * JD-Core Version:    0.7.0.1
 */