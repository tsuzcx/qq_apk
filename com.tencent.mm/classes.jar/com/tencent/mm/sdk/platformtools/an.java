package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class an
{
  public volatile boolean IxQ;
  
  public an()
  {
    this.IxQ = false;
  }
  
  public an(boolean paramBoolean)
  {
    this.IxQ = paramBoolean;
  }
  
  public final void block()
  {
    AppMethodBeat.i(157616);
    try
    {
      for (;;)
      {
        boolean bool = this.IxQ;
        if (bool) {
          break;
        }
        try
        {
          wait();
        }
        catch (InterruptedException localInterruptedException) {}
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(157616);
    }
  }
  
  public final void close()
  {
    try
    {
      this.IxQ = false;
      return;
    }
    finally {}
  }
  
  /* Error */
  public final boolean foL()
  {
    // Byte code:
    //   0: ldc 34
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc2_w 35
    //   8: lconst_0
    //   9: lcmp
    //   10: ifeq +74 -> 84
    //   13: aload_0
    //   14: monitorenter
    //   15: invokestatic 42	java/lang/System:currentTimeMillis	()J
    //   18: lstore_1
    //   19: ldc2_w 35
    //   22: lload_1
    //   23: ladd
    //   24: lstore_3
    //   25: aload_0
    //   26: getfield 12	com/tencent/mm/sdk/platformtools/an:IxQ	Z
    //   29: istore 5
    //   31: iload 5
    //   33: ifne +23 -> 56
    //   36: lload_1
    //   37: lload_3
    //   38: lcmp
    //   39: ifge +17 -> 56
    //   42: aload_0
    //   43: lload_3
    //   44: lload_1
    //   45: lsub
    //   46: invokevirtual 45	java/lang/Object:wait	(J)V
    //   49: invokestatic 42	java/lang/System:currentTimeMillis	()J
    //   52: lstore_1
    //   53: goto -28 -> 25
    //   56: aload_0
    //   57: getfield 12	com/tencent/mm/sdk/platformtools/an:IxQ	Z
    //   60: istore 5
    //   62: aload_0
    //   63: monitorexit
    //   64: ldc 34
    //   66: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: iload 5
    //   71: ireturn
    //   72: astore 6
    //   74: aload_0
    //   75: monitorexit
    //   76: ldc 34
    //   78: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload 6
    //   83: athrow
    //   84: aload_0
    //   85: invokevirtual 47	com/tencent/mm/sdk/platformtools/an:block	()V
    //   88: ldc 34
    //   90: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: iconst_1
    //   94: ireturn
    //   95: astore 6
    //   97: goto -48 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	an
    //   18	35	1	l1	long
    //   24	20	3	l2	long
    //   29	41	5	bool	boolean
    //   72	10	6	localObject	Object
    //   95	1	6	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   15	19	72	finally
    //   25	31	72	finally
    //   42	49	72	finally
    //   49	53	72	finally
    //   56	64	72	finally
    //   74	76	72	finally
    //   42	49	95	java/lang/InterruptedException
  }
  
  public final void open()
  {
    AppMethodBeat.i(157615);
    try
    {
      boolean bool = this.IxQ;
      this.IxQ = true;
      if (!bool) {
        notifyAll();
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(157615);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(157618);
    String str = "MMConditionVariable[" + hashCode() + "," + this.IxQ + "]";
    AppMethodBeat.o(157618);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.an
 * JD-Core Version:    0.7.0.1
 */