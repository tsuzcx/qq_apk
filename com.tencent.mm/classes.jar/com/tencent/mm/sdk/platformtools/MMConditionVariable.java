package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMConditionVariable
{
  private volatile boolean mCondition;
  
  public MMConditionVariable()
  {
    this.mCondition = false;
  }
  
  public MMConditionVariable(boolean paramBoolean)
  {
    this.mCondition = paramBoolean;
  }
  
  public void block()
  {
    AppMethodBeat.i(157616);
    try
    {
      for (;;)
      {
        boolean bool = this.mCondition;
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
  
  /* Error */
  public boolean block(long paramLong)
  {
    // Byte code:
    //   0: ldc 32
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: lload_1
    //   6: lconst_0
    //   7: lcmp
    //   8: ifeq +77 -> 85
    //   11: aload_0
    //   12: monitorenter
    //   13: invokestatic 38	java/lang/System:currentTimeMillis	()J
    //   16: lstore_3
    //   17: lload_3
    //   18: lload_1
    //   19: ladd
    //   20: lstore 5
    //   22: lload_3
    //   23: lstore_1
    //   24: aload_0
    //   25: getfield 12	com/tencent/mm/sdk/platformtools/MMConditionVariable:mCondition	Z
    //   28: istore 7
    //   30: iload 7
    //   32: ifne +25 -> 57
    //   35: lload_1
    //   36: lload 5
    //   38: lcmp
    //   39: ifge +18 -> 57
    //   42: aload_0
    //   43: lload 5
    //   45: lload_1
    //   46: lsub
    //   47: invokevirtual 41	java/lang/Object:wait	(J)V
    //   50: invokestatic 38	java/lang/System:currentTimeMillis	()J
    //   53: lstore_1
    //   54: goto -30 -> 24
    //   57: aload_0
    //   58: getfield 12	com/tencent/mm/sdk/platformtools/MMConditionVariable:mCondition	Z
    //   61: istore 7
    //   63: aload_0
    //   64: monitorexit
    //   65: ldc 32
    //   67: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: iload 7
    //   72: ireturn
    //   73: astore 8
    //   75: aload_0
    //   76: monitorexit
    //   77: ldc 32
    //   79: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   82: aload 8
    //   84: athrow
    //   85: aload_0
    //   86: invokevirtual 43	com/tencent/mm/sdk/platformtools/MMConditionVariable:block	()V
    //   89: ldc 32
    //   91: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: iconst_1
    //   95: ireturn
    //   96: astore 8
    //   98: goto -48 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	MMConditionVariable
    //   0	101	1	paramLong	long
    //   16	7	3	l1	long
    //   20	24	5	l2	long
    //   28	43	7	bool	boolean
    //   73	10	8	localObject	Object
    //   96	1	8	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   13	17	73	finally
    //   24	30	73	finally
    //   42	50	73	finally
    //   50	54	73	finally
    //   57	65	73	finally
    //   42	50	96	java/lang/InterruptedException
  }
  
  public void close()
  {
    try
    {
      this.mCondition = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isOpen()
  {
    return this.mCondition;
  }
  
  public void open()
  {
    AppMethodBeat.i(157615);
    try
    {
      boolean bool = this.mCondition;
      this.mCondition = true;
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
  
  public String toString()
  {
    AppMethodBeat.i(157618);
    String str = "MMConditionVariable[" + hashCode() + "," + isOpen() + "]";
    AppMethodBeat.o(157618);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMConditionVariable
 * JD-Core Version:    0.7.0.1
 */