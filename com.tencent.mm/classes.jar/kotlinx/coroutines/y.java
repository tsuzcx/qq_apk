package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.d.f;
import kotlin.g.b.s;
import kotlin.k.k;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/CommonPool;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "()V", "DEFAULT_PARALLELISM_PROPERTY_NAME", "", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "parallelism", "", "getParallelism", "()I", "pool", "requestedParallelism", "usePrivatePool", "", "Try", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "close", "", "createPlainPool", "Ljava/util/concurrent/ExecutorService;", "createPool", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "getOrCreatePoolSync", "isGoodCommonPool", "fjpClass", "Ljava/lang/Class;", "isGoodCommonPool$kotlinx_coroutines_core", "restore", "restore$kotlinx_coroutines_core", "shutdown", "timeout", "", "shutdown$kotlinx_coroutines_core", "toString", "usePrivatePool$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
  extends br
{
  public static final y ajvv = new y();
  private static final int ajvw;
  private static boolean ajvx;
  private static volatile Executor pool;
  
  static
  {
    AppMethodBeat.i(118258);
    try
    {
      String str = System.getProperty("kotlinx.coroutines.default.parallelism");
      if (str == null)
      {
        i = -1;
        ajvw = i;
        AppMethodBeat.o(118258);
        return;
      }
    }
    finally
    {
      for (;;)
      {
        Object localObject2 = null;
        continue;
        Integer localInteger = n.bJF((String)localObject2);
        if ((localInteger == null) || (localInteger.intValue() <= 0))
        {
          localObject2 = (Throwable)new IllegalStateException(s.X("Expected positive number in kotlinx.coroutines.default.parallelism, but has ", localObject2).toString());
          AppMethodBeat.o(118258);
          throw ((Throwable)localObject2);
        }
        int i = localInteger.intValue();
      }
    }
  }
  
  private static final Thread a(AtomicInteger paramAtomicInteger, Runnable paramRunnable)
  {
    AppMethodBeat.i(188912);
    paramAtomicInteger = new Thread(paramRunnable, s.X("CommonPool-worker-", Integer.valueOf(paramAtomicInteger.incrementAndGet())));
    paramAtomicInteger.setDaemon(true);
    AppMethodBeat.o(188912);
    return paramAtomicInteger;
  }
  
  /* Error */
  private static boolean a(java.lang.Class<?> paramClass, ExecutorService paramExecutorService)
  {
    // Byte code:
    //   0: ldc 155
    //   2: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: getstatic 161	kotlinx/coroutines/y$$ExternalSyntheticLambda0:INSTANCE	Lkotlinx/coroutines/y$$ExternalSyntheticLambda0;
    //   9: invokeinterface 167 2 0
    //   14: pop
    //   15: aload_0
    //   16: ldc 169
    //   18: iconst_0
    //   19: anewarray 171	java/lang/Class
    //   22: invokevirtual 175	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   25: aload_1
    //   26: iconst_0
    //   27: anewarray 123	java/lang/Object
    //   30: invokevirtual 181	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   33: astore_0
    //   34: aload_0
    //   35: instanceof 108
    //   38: ifeq +19 -> 57
    //   41: aload_0
    //   42: checkcast 108	java/lang/Integer
    //   45: astore_0
    //   46: aload_0
    //   47: ifnonnull +21 -> 68
    //   50: ldc 155
    //   52: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: iconst_0
    //   56: ireturn
    //   57: aconst_null
    //   58: astore_0
    //   59: goto -13 -> 46
    //   62: astore_0
    //   63: aconst_null
    //   64: astore_0
    //   65: goto -19 -> 46
    //   68: aload_0
    //   69: invokevirtual 111	java/lang/Integer:intValue	()I
    //   72: ifle +10 -> 82
    //   75: ldc 155
    //   77: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: iconst_1
    //   81: ireturn
    //   82: ldc 155
    //   84: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: iconst_0
    //   88: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramClass	java.lang.Class<?>
    //   0	89	1	paramExecutorService	ExecutorService
    // Exception table:
    //   from	to	target	type
    //   15	46	62	finally
  }
  
  private static int kBM()
  {
    AppMethodBeat.i(118251);
    Integer localInteger = Integer.valueOf(ajvw);
    if (((Number)localInteger).intValue() > 0)
    {
      i = 1;
      if (i == 0) {
        break label57;
      }
    }
    for (;;)
    {
      if (localInteger != null) {
        break label62;
      }
      i = k.qu(Runtime.getRuntime().availableProcessors() - 1, 1);
      AppMethodBeat.o(118251);
      return i;
      i = 0;
      break;
      label57:
      localInteger = null;
    }
    label62:
    int i = localInteger.intValue();
    AppMethodBeat.o(118251);
    return i;
  }
  
  /* Error */
  private static ExecutorService kBN()
  {
    // Byte code:
    //   0: ldc 206
    //   2: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 210	java/lang/System:getSecurityManager	()Ljava/lang/SecurityManager;
    //   8: ifnull +14 -> 22
    //   11: invokestatic 213	kotlinx/coroutines/y:kBO	()Ljava/util/concurrent/ExecutorService;
    //   14: astore_0
    //   15: ldc 206
    //   17: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: aload_0
    //   21: areturn
    //   22: ldc 215
    //   24: invokestatic 219	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   27: astore_1
    //   28: aload_1
    //   29: ifnonnull +20 -> 49
    //   32: invokestatic 213	kotlinx/coroutines/y:kBO	()Ljava/util/concurrent/ExecutorService;
    //   35: astore_0
    //   36: ldc 206
    //   38: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: aload_0
    //   42: areturn
    //   43: astore_0
    //   44: aconst_null
    //   45: astore_1
    //   46: goto -18 -> 28
    //   49: getstatic 221	kotlinx/coroutines/y:ajvx	Z
    //   52: ifne +79 -> 131
    //   55: getstatic 100	kotlinx/coroutines/y:ajvw	I
    //   58: ifge +73 -> 131
    //   61: aload_1
    //   62: ldc 223
    //   64: iconst_0
    //   65: anewarray 171	java/lang/Class
    //   68: invokevirtual 175	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   71: aconst_null
    //   72: iconst_0
    //   73: anewarray 123	java/lang/Object
    //   76: invokevirtual 181	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   79: astore_0
    //   80: aload_0
    //   81: instanceof 163
    //   84: ifeq +31 -> 115
    //   87: aload_0
    //   88: checkcast 163	java/util/concurrent/ExecutorService
    //   91: astore_0
    //   92: aload_0
    //   93: ifnull +38 -> 131
    //   96: aload_1
    //   97: aload_0
    //   98: invokestatic 225	kotlinx/coroutines/y:a	(Ljava/lang/Class;Ljava/util/concurrent/ExecutorService;)Z
    //   101: ifeq +25 -> 126
    //   104: aload_0
    //   105: ifnull +26 -> 131
    //   108: ldc 206
    //   110: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_0
    //   114: areturn
    //   115: aconst_null
    //   116: astore_0
    //   117: goto -25 -> 92
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_0
    //   123: goto -31 -> 92
    //   126: aconst_null
    //   127: astore_0
    //   128: goto -24 -> 104
    //   131: aload_1
    //   132: iconst_1
    //   133: anewarray 171	java/lang/Class
    //   136: dup
    //   137: iconst_0
    //   138: getstatic 228	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   141: aastore
    //   142: invokevirtual 232	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   145: iconst_1
    //   146: anewarray 123	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: invokestatic 234	kotlinx/coroutines/y:kBM	()I
    //   154: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   157: aastore
    //   158: invokevirtual 240	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   161: astore_0
    //   162: aload_0
    //   163: instanceof 163
    //   166: ifeq +19 -> 185
    //   169: aload_0
    //   170: checkcast 163	java/util/concurrent/ExecutorService
    //   173: astore_0
    //   174: aload_0
    //   175: ifnull +21 -> 196
    //   178: ldc 206
    //   180: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aload_0
    //   184: areturn
    //   185: aconst_null
    //   186: astore_0
    //   187: goto -13 -> 174
    //   190: astore_0
    //   191: aconst_null
    //   192: astore_0
    //   193: goto -19 -> 174
    //   196: invokestatic 213	kotlinx/coroutines/y:kBO	()Ljava/util/concurrent/ExecutorService;
    //   199: astore_0
    //   200: ldc 206
    //   202: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: aload_0
    //   206: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   14	28	0	localExecutorService1	ExecutorService
    //   43	1	0	localObject1	Object
    //   79	38	0	localObject2	Object
    //   120	1	0	localObject3	Object
    //   122	65	0	localObject4	Object
    //   190	1	0	localObject5	Object
    //   192	14	0	localExecutorService2	ExecutorService
    //   27	105	1	localClass	java.lang.Class
    // Exception table:
    //   from	to	target	type
    //   22	28	43	finally
    //   61	92	120	finally
    //   131	174	190	finally
  }
  
  private static ExecutorService kBO()
  {
    AppMethodBeat.i(118254);
    Object localObject = new AtomicInteger();
    localObject = Executors.newFixedThreadPool(kBM(), new y..ExternalSyntheticLambda1((AtomicInteger)localObject));
    AppMethodBeat.o(118254);
    return localObject;
  }
  
  /* Error */
  private final Executor kBP()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 255
    //   4: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: getstatic 257	kotlinx/coroutines/y:pool	Ljava/util/concurrent/Executor;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnonnull +28 -> 40
    //   15: invokestatic 259	kotlinx/coroutines/y:kBN	()Ljava/util/concurrent/ExecutorService;
    //   18: astore_1
    //   19: aload_1
    //   20: checkcast 261	java/util/concurrent/Executor
    //   23: putstatic 257	kotlinx/coroutines/y:pool	Ljava/util/concurrent/Executor;
    //   26: aload_1
    //   27: checkcast 261	java/util/concurrent/Executor
    //   30: astore_1
    //   31: ldc 255
    //   33: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: areturn
    //   40: ldc 255
    //   42: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: goto -9 -> 36
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	y
    //   10	29	1	localObject1	Object
    //   48	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	48	finally
    //   15	36	48	finally
    //   40	45	48	finally
  }
  
  private static final void kBQ() {}
  
  public final void a(f paramf, Runnable paramRunnable)
  {
    AppMethodBeat.i(118256);
    try
    {
      Executor localExecutor = pool;
      paramf = localExecutor;
      if (localExecutor == null) {
        paramf = kBP();
      }
      if (c.ajvf == null)
      {
        paramf.execute(paramRunnable);
        AppMethodBeat.o(118256);
        return;
      }
      AppMethodBeat.o(118256);
      throw null;
    }
    catch (RejectedExecutionException paramf)
    {
      aw.ajvR.bs(paramRunnable);
      AppMethodBeat.o(118256);
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(118257);
    Throwable localThrowable = (Throwable)new IllegalStateException("Close cannot be invoked on CommonPool".toString());
    AppMethodBeat.o(118257);
    throw localThrowable;
  }
  
  public final String toString()
  {
    return "CommonPool";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.y
 * JD-Core Version:    0.7.0.1
 */