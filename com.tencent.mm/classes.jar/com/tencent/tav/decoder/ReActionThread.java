package com.tencent.tav.decoder;

import com.tencent.tav.decoder.logger.Logger;

public abstract class ReActionThread
  extends Thread
{
  public static boolean LOG_VERBOSE = false;
  private static final String TAG = "ReActionThread";
  private boolean hasAction = false;
  private boolean release = false;
  
  public ReActionThread(String paramString)
  {
    super(paramString);
  }
  
  public void action()
  {
    this.hasAction = true;
    try
    {
      notifyAll();
      if (LOG_VERBOSE) {
        Logger.d("ReActionThread", "action: " + this + " " + hashCode());
      }
      return;
    }
    finally {}
  }
  
  protected abstract void doAction();
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	com/tencent/tav/decoder/ReActionThread:release	Z
    //   6: ifne +27 -> 33
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield 24	com/tencent/tav/decoder/ReActionThread:release	Z
    //   14: aload_0
    //   15: monitorenter
    //   16: aload_0
    //   17: invokevirtual 32	java/lang/Object:notifyAll	()V
    //   20: aload_0
    //   21: monitorexit
    //   22: aload_0
    //   23: monitorenter
    //   24: aload_0
    //   25: ldc2_w 67
    //   28: invokevirtual 72	java/lang/Object:wait	(J)V
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    //   51: astore_1
    //   52: goto -19 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	ReActionThread
    //   36	4	1	localObject1	Object
    //   41	4	1	localObject2	Object
    //   46	4	1	localObject3	Object
    //   51	1	1	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   16	22	36	finally
    //   37	39	36	finally
    //   2	16	41	finally
    //   22	24	41	finally
    //   39	41	41	finally
    //   49	51	41	finally
    //   24	33	46	finally
    //   47	49	46	finally
    //   22	24	51	java/lang/InterruptedException
    //   49	51	51	java/lang/InterruptedException
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 11
    //   2: new 34	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 75
    //   8: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   15: ldc 43
    //   17: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_0
    //   21: invokevirtual 50	java/lang/Object:hashCode	()I
    //   24: invokevirtual 53	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 63	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_0
    //   34: getfield 24	com/tencent/tav/decoder/ReActionThread:release	Z
    //   37: ifne +68 -> 105
    //   40: aload_0
    //   41: getfield 26	com/tencent/tav/decoder/ReActionThread:hasAction	Z
    //   44: ifne +29 -> 73
    //   47: aload_0
    //   48: getfield 24	com/tencent/tav/decoder/ReActionThread:release	Z
    //   51: ifne +22 -> 73
    //   54: aload_0
    //   55: monitorenter
    //   56: aload_0
    //   57: ldc2_w 76
    //   60: invokevirtual 72	java/lang/Object:wait	(J)V
    //   63: aload_0
    //   64: monitorexit
    //   65: goto -25 -> 40
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    //   73: aload_0
    //   74: iconst_0
    //   75: putfield 26	com/tencent/tav/decoder/ReActionThread:hasAction	Z
    //   78: aload_0
    //   79: getfield 24	com/tencent/tav/decoder/ReActionThread:release	Z
    //   82: ifne +7 -> 89
    //   85: aload_0
    //   86: invokevirtual 79	com/tencent/tav/decoder/ReActionThread:doAction	()V
    //   89: aload_0
    //   90: monitorenter
    //   91: aload_0
    //   92: invokevirtual 32	java/lang/Object:notifyAll	()V
    //   95: aload_0
    //   96: monitorexit
    //   97: goto -64 -> 33
    //   100: astore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_1
    //   104: athrow
    //   105: ldc 11
    //   107: new 34	java/lang/StringBuilder
    //   110: dup
    //   111: ldc 81
    //   113: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   116: aload_0
    //   117: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   120: ldc 43
    //   122: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload_0
    //   126: invokevirtual 50	java/lang/Object:hashCode	()I
    //   129: invokevirtual 53	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   132: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 63	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: return
    //   139: astore_1
    //   140: goto -77 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	ReActionThread
    //   68	4	1	localObject1	Object
    //   100	4	1	localObject2	Object
    //   139	1	1	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   56	63	68	finally
    //   63	65	68	finally
    //   69	71	68	finally
    //   91	97	100	finally
    //   101	103	100	finally
    //   56	63	139	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.decoder.ReActionThread
 * JD-Core Version:    0.7.0.1
 */