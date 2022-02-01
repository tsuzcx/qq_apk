package com.tencent.mm.vending.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c<_Target extends a>
  implements a, b<_Target>
{
  private List<WeakReference<_Target>> HPT;
  private boolean HPU;
  
  public c()
  {
    AppMethodBeat.i(74908);
    this.HPT = new ArrayList();
    this.HPU = true;
    AppMethodBeat.o(74908);
  }
  
  public final void dead()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(74910);
        if (!this.HPU)
        {
          AppMethodBeat.o(74910);
          return;
        }
        Iterator localIterator = this.HPT.iterator();
        if (localIterator.hasNext())
        {
          a locala = (a)((WeakReference)localIterator.next()).get();
          if (locala == null) {
            continue;
          }
          locala.dead();
          continue;
        }
        this.HPT.clear();
      }
      finally {}
      this.HPU = false;
      AppMethodBeat.o(74910);
    }
  }
  
  /* Error */
  public final void keep(_Target param_Target)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 67
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 32	com/tencent/mm/vending/e/c:HPU	Z
    //   11: ifne +21 -> 32
    //   14: aload_1
    //   15: invokestatic 73	junit/framework/Assert:assertNotNull	(Ljava/lang/Object;)V
    //   18: aload_1
    //   19: invokeinterface 61 1 0
    //   24: ldc 67
    //   26: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_0
    //   33: getfield 30	com/tencent/mm/vending/e/c:HPT	Ljava/util/List;
    //   36: new 56	java/lang/ref/WeakReference
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 75	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   44: invokeinterface 79 2 0
    //   49: pop
    //   50: ldc 67
    //   52: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: goto -26 -> 29
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	c
    //   0	63	1	param_Target	_Target
    // Exception table:
    //   from	to	target	type
    //   2	29	58	finally
    //   32	55	58	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.e.c
 * JD-Core Version:    0.7.0.1
 */