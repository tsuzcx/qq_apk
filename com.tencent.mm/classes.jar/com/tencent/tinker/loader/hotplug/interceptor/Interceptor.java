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
    //   36: ldc 12
    //   38: new 45	java/lang/StringBuilder
    //   41: dup
    //   42: ldc 47
    //   44: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   47: aload_1
    //   48: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   51: ldc 56
    //   53: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: iconst_0
    //   60: anewarray 5	java/lang/Object
    //   63: invokestatic 69	com/tencent/tinker/loader/shareutil/ShareTinkerLog:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: goto -38 -> 28
    //   69: astore_1
    //   70: aload_0
    //   71: aconst_null
    //   72: putfield 23	com/tencent/tinker/loader/hotplug/interceptor/Interceptor:mTarget	Ljava/lang/Object;
    //   75: new 71	com/tencent/tinker/loader/hotplug/interceptor/InterceptFailedException
    //   78: dup
    //   79: aload_1
    //   80: invokespecial 74	com/tencent/tinker/loader/hotplug/interceptor/InterceptFailedException:<init>	(Ljava/lang/Throwable;)V
    //   83: athrow
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	Interceptor
    //   6	42	1	localObject1	Object
    //   69	11	1	localThrowable	java.lang.Throwable
    //   84	4	1	localObject2	Object
    //   17	8	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	18	69	java/lang/Throwable
    //   23	28	69	java/lang/Throwable
    //   28	33	69	java/lang/Throwable
    //   36	66	69	java/lang/Throwable
    //   2	18	84	finally
    //   23	28	84	finally
    //   28	33	84	finally
    //   36	66	84	finally
    //   70	84	84	finally
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
    //   33: new 71	com/tencent/tinker/loader/hotplug/interceptor/InterceptFailedException
    //   36: dup
    //   37: aload_2
    //   38: invokespecial 74	com/tencent/tinker/loader/hotplug/interceptor/InterceptFailedException:<init>	(Ljava/lang/Throwable;)V
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