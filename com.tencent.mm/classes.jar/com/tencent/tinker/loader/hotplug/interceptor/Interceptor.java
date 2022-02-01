package com.tencent.tinker.loader.hotplug.interceptor;

public abstract class Interceptor<T_TARGET>
{
  private static final String TAG = "Tinker.Interceptor";
  private volatile boolean mInstalled = false;
  private T_TARGET mTarget = null;
  
  protected T_TARGET decorate(T_TARGET paramT_TARGET)
  {
    return paramT_TARGET;
  }
  
  protected abstract T_TARGET fetchTarget();
  
  protected abstract void inject(T_TARGET paramT_TARGET);
  
  /* Error */
  public void install()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 39	com/tencent/tinker/loader/hotplug/interceptor/Interceptor:fetchTarget	()Ljava/lang/Object;
    //   6: astore_1
    //   7: aload_0
    //   8: aload_1
    //   9: putfield 23	com/tencent/tinker/loader/hotplug/interceptor/Interceptor:mTarget	Ljava/lang/Object;
    //   12: aload_0
    //   13: aload_1
    //   14: invokevirtual 41	com/tencent/tinker/loader/hotplug/interceptor/Interceptor:decorate	(Ljava/lang/Object;)Ljava/lang/Object;
    //   17: astore_2
    //   18: aload_2
    //   19: aload_1
    //   20: if_acmpeq +16 -> 36
    //   23: aload_0
    //   24: aload_2
    //   25: invokevirtual 43	com/tencent/tinker/loader/hotplug/interceptor/Interceptor:inject	(Ljava/lang/Object;)V
    //   28: aload_0
    //   29: iconst_1
    //   30: putfield 25	com/tencent/tinker/loader/hotplug/interceptor/Interceptor:mInstalled	Z
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: new 45	java/lang/StringBuilder
    //   39: dup
    //   40: ldc 47
    //   42: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   45: aload_1
    //   46: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   49: ldc 56
    //   51: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: goto -27 -> 28
    //   58: astore_1
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield 23	com/tencent/tinker/loader/hotplug/interceptor/Interceptor:mTarget	Ljava/lang/Object;
    //   64: new 61	com/tencent/tinker/loader/hotplug/interceptor/InterceptFailedException
    //   67: dup
    //   68: aload_1
    //   69: invokespecial 64	com/tencent/tinker/loader/hotplug/interceptor/InterceptFailedException:<init>	(Ljava/lang/Throwable;)V
    //   72: athrow
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	Interceptor
    //   6	40	1	localObject1	Object
    //   58	11	1	localThrowable	java.lang.Throwable
    //   73	4	1	localObject2	Object
    //   17	8	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	58	java/lang/Throwable
    //   23	28	58	java/lang/Throwable
    //   28	33	58	java/lang/Throwable
    //   36	55	58	java/lang/Throwable
    //   2	18	73	finally
    //   23	28	73	finally
    //   28	33	73	finally
    //   36	55	73	finally
    //   59	73	73	finally
  }
  
  /* Error */
  public void uninstall()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	com/tencent/tinker/loader/hotplug/interceptor/Interceptor:mInstalled	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +21 -> 29
    //   11: aload_0
    //   12: aload_0
    //   13: getfield 23	com/tencent/tinker/loader/hotplug/interceptor/Interceptor:mTarget	Ljava/lang/Object;
    //   16: invokevirtual 43	com/tencent/tinker/loader/hotplug/interceptor/Interceptor:inject	(Ljava/lang/Object;)V
    //   19: aload_0
    //   20: aconst_null
    //   21: putfield 23	com/tencent/tinker/loader/hotplug/interceptor/Interceptor:mTarget	Ljava/lang/Object;
    //   24: aload_0
    //   25: iconst_0
    //   26: putfield 25	com/tencent/tinker/loader/hotplug/interceptor/Interceptor:mInstalled	Z
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: astore_2
    //   33: new 61	com/tencent/tinker/loader/hotplug/interceptor/InterceptFailedException
    //   36: dup
    //   37: aload_2
    //   38: invokespecial 64	com/tencent/tinker/loader/hotplug/interceptor/InterceptFailedException:<init>	(Ljava/lang/Throwable;)V
    //   41: athrow
    //   42: astore_2
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_2
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	Interceptor
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
  
  protected static abstract interface ITinkerHotplugProxy {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.loader.hotplug.interceptor.Interceptor
 * JD-Core Version:    0.7.0.1
 */