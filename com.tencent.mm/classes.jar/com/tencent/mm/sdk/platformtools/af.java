package com.tencent.mm.sdk.platformtools;

public final class af
{
  public volatile boolean ufm;
  
  public af()
  {
    this.ufm = false;
  }
  
  public af(boolean paramBoolean)
  {
    this.ufm = paramBoolean;
  }
  
  public final void block()
  {
    try
    {
      for (;;)
      {
        boolean bool = this.ufm;
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
    finally {}
  }
  
  public final void close()
  {
    try
    {
      this.ufm = false;
      return;
    }
    finally {}
  }
  
  /* Error */
  public final boolean crb()
  {
    // Byte code:
    //   0: ldc2_w 24
    //   3: lconst_0
    //   4: lcmp
    //   5: ifeq +64 -> 69
    //   8: aload_0
    //   9: monitorenter
    //   10: invokestatic 31	java/lang/System:currentTimeMillis	()J
    //   13: lstore_1
    //   14: ldc2_w 24
    //   17: lload_1
    //   18: ladd
    //   19: lstore_3
    //   20: aload_0
    //   21: getfield 12	com/tencent/mm/sdk/platformtools/af:ufm	Z
    //   24: istore 5
    //   26: iload 5
    //   28: ifne +23 -> 51
    //   31: lload_1
    //   32: lload_3
    //   33: lcmp
    //   34: ifge +17 -> 51
    //   37: aload_0
    //   38: lload_3
    //   39: lload_1
    //   40: lsub
    //   41: invokevirtual 34	java/lang/Object:wait	(J)V
    //   44: invokestatic 31	java/lang/System:currentTimeMillis	()J
    //   47: lstore_1
    //   48: goto -28 -> 20
    //   51: aload_0
    //   52: getfield 12	com/tencent/mm/sdk/platformtools/af:ufm	Z
    //   55: istore 5
    //   57: aload_0
    //   58: monitorexit
    //   59: iload 5
    //   61: ireturn
    //   62: astore 6
    //   64: aload_0
    //   65: monitorexit
    //   66: aload 6
    //   68: athrow
    //   69: aload_0
    //   70: invokevirtual 36	com/tencent/mm/sdk/platformtools/af:block	()V
    //   73: iconst_1
    //   74: ireturn
    //   75: astore 6
    //   77: goto -33 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	af
    //   13	35	1	l1	long
    //   19	20	3	l2	long
    //   24	36	5	bool	boolean
    //   62	5	6	localObject	Object
    //   75	1	6	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   10	14	62	finally
    //   20	26	62	finally
    //   37	44	62	finally
    //   44	48	62	finally
    //   51	59	62	finally
    //   64	66	62	finally
    //   37	44	75	java/lang/InterruptedException
  }
  
  public final void open()
  {
    try
    {
      boolean bool = this.ufm;
      this.ufm = true;
      if (!bool) {
        notifyAll();
      }
      return;
    }
    finally {}
  }
  
  public final String toString()
  {
    return "MMConditionVariable[" + hashCode() + "," + this.ufm + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.af
 * JD-Core Version:    0.7.0.1
 */