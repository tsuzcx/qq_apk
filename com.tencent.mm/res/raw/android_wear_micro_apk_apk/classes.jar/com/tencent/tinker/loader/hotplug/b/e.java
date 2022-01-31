package com.tencent.tinker.loader.hotplug.b;

public abstract class e<T_TARGET>
{
  private T_TARGET alE = null;
  private volatile boolean alF = false;
  
  protected abstract void S(T_TARGET paramT_TARGET);
  
  protected T_TARGET T(T_TARGET paramT_TARGET)
  {
    return paramT_TARGET;
  }
  
  /* Error */
  public final void og()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/tencent/tinker/loader/hotplug/b/e:alF	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +21 -> 29
    //   11: aload_0
    //   12: aload_0
    //   13: getfield 16	com/tencent/tinker/loader/hotplug/b/e:alE	Ljava/lang/Object;
    //   16: invokevirtual 30	com/tencent/tinker/loader/hotplug/b/e:S	(Ljava/lang/Object;)V
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 16	com/tencent/tinker/loader/hotplug/b/e:alE	Ljava/lang/Object;
    //   24: aload_0
    //   25: iconst_0
    //   26: putfield 18	com/tencent/tinker/loader/hotplug/b/e:alF	Z
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: astore_2
    //   33: new 32	com/tencent/tinker/loader/hotplug/b/d
    //   36: dup
    //   37: aload_2
    //   38: invokespecial 35	com/tencent/tinker/loader/hotplug/b/d:<init>	(Ljava/lang/Throwable;)V
    //   41: athrow
    //   42: astore_2
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_2
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	e
    //   6	2	1	bool	boolean
    //   32	6	2	localThrowable	java.lang.Throwable
    //   42	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	29	32	java/lang/Throwable
    //   2	7	42	finally
    //   11	29	42	finally
    //   33	42	42	finally
  }
  
  protected abstract T_TARGET oj();
  
  /* Error */
  public final void ok()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 40	com/tencent/tinker/loader/hotplug/b/e:oj	()Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_0
    //   8: aload_1
    //   9: putfield 16	com/tencent/tinker/loader/hotplug/b/e:alE	Ljava/lang/Object;
    //   12: aload_0
    //   13: aload_1
    //   14: invokevirtual 42	com/tencent/tinker/loader/hotplug/b/e:T	(Ljava/lang/Object;)Ljava/lang/Object;
    //   17: astore_2
    //   18: aload_2
    //   19: aload_1
    //   20: if_acmpeq +16 -> 36
    //   23: aload_0
    //   24: aload_2
    //   25: invokevirtual 30	com/tencent/tinker/loader/hotplug/b/e:S	(Ljava/lang/Object;)V
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 18	com/tencent/tinker/loader/hotplug/b/e:alF	Z
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: ldc 44
    //   38: new 46	java/lang/StringBuilder
    //   41: dup
    //   42: ldc 48
    //   44: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   47: aload_1
    //   48: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   51: ldc 57
    //   53: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 70	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   62: pop
    //   63: goto -35 -> 28
    //   66: astore_1
    //   67: aload_0
    //   68: aconst_null
    //   69: putfield 16	com/tencent/tinker/loader/hotplug/b/e:alE	Ljava/lang/Object;
    //   72: new 32	com/tencent/tinker/loader/hotplug/b/d
    //   75: dup
    //   76: aload_1
    //   77: invokespecial 35	com/tencent/tinker/loader/hotplug/b/d:<init>	(Ljava/lang/Throwable;)V
    //   80: athrow
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	e
    //   6	42	1	localObject1	Object
    //   66	11	1	localThrowable	java.lang.Throwable
    //   81	4	1	localObject2	Object
    //   17	8	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	66	java/lang/Throwable
    //   23	28	66	java/lang/Throwable
    //   28	33	66	java/lang/Throwable
    //   36	63	66	java/lang/Throwable
    //   2	18	81	finally
    //   23	28	81	finally
    //   28	33	81	finally
    //   36	63	81	finally
    //   67	81	81	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.b.e
 * JD-Core Version:    0.7.0.1
 */