package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.f;
import d.l;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.w;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/DispatchedContinuation;", "T", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlin/coroutines/Continuation;", "continuation", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "Lkotlinx/coroutines/CancellableContinuation;", "", "checkPostponedCancellation", "(Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Throwable;", "Lkotlinx/coroutines/CancellableContinuationImpl;", "claimReusableCancellableContinuation", "()Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlin/coroutines/CoroutineContext;", "context", "value", "", "dispatchYield$kotlinx_coroutines_core", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "dispatchYield", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "cause", "", "postponeCancellation", "(Ljava/lang/Throwable;)Z", "Lkotlin/Result;", "result", "resumeCancellableWith", "(Ljava/lang/Object;)V", "resumeCancelled", "()Z", "resumeUndispatchedWith", "resumeWith", "", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "", "toString", "()Ljava/lang/String;", "_state", "Ljava/lang/Object;", "_state$annotations", "()V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "countOrElement", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "delegate", "Lkotlinx/coroutines/CoroutineDispatcher;", "isReusable", "getReusableCancellableContinuation", "reusableCancellableContinuation", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;"})
public final class at<T>
  extends aw<T>
  implements d.d.b.a.d, d.d.d<T>
{
  static final AtomicReferenceFieldUpdater LRp;
  private final d.d.b.a.d LRn;
  public final Object LRo;
  public final ab LRq;
  public final d.d.d<T> LRr;
  volatile Object _reusableCancellableContinuation;
  public Object _state;
  
  static
  {
    AppMethodBeat.i(191161);
    LRp = AtomicReferenceFieldUpdater.newUpdater(at.class, Object.class, "_reusableCancellableContinuation");
    AppMethodBeat.o(191161);
  }
  
  public at(ab paramab, d.d.d<? super T> paramd)
  {
    super(0);
    AppMethodBeat.i(118200);
    this.LRq = paramab;
    this.LRr = paramd;
    this._state = au.gdM();
    paramd = this.LRr;
    paramab = paramd;
    if (!(paramd instanceof d.d.b.a.d)) {
      paramab = null;
    }
    this.LRn = ((d.d.b.a.d)paramab);
    this.LRo = w.d(fOf());
    this._reusableCancellableContinuation = null;
    AppMethodBeat.o(118200);
  }
  
  /* Error */
  public final void eK(Object paramObject)
  {
    // Byte code:
    //   0: ldc 149
    //   2: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 119	kotlinx/coroutines/at:LRr	Ld/d/d;
    //   9: invokeinterface 150 1 0
    //   14: astore_3
    //   15: aload_1
    //   16: invokestatic 156	kotlinx/coroutines/u:fG	(Ljava/lang/Object;)Ljava/lang/Object;
    //   19: astore 4
    //   21: aload_0
    //   22: getfield 117	kotlinx/coroutines/at:LRq	Lkotlinx/coroutines/ab;
    //   25: invokevirtual 161	kotlinx/coroutines/ab:gdB	()Z
    //   28: ifeq +32 -> 60
    //   31: aload_0
    //   32: aload 4
    //   34: putfield 127	kotlinx/coroutines/at:_state	Ljava/lang/Object;
    //   37: aload_0
    //   38: iconst_0
    //   39: putfield 165	kotlinx/coroutines/at:LRu	I
    //   42: aload_0
    //   43: getfield 117	kotlinx/coroutines/at:LRq	Lkotlinx/coroutines/ab;
    //   46: aload_3
    //   47: aload_0
    //   48: checkcast 167	java/lang/Runnable
    //   51: invokevirtual 171	kotlinx/coroutines/ab:a	(Ld/d/f;Ljava/lang/Runnable;)V
    //   54: ldc 149
    //   56: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: return
    //   60: getstatic 177	kotlinx/coroutines/ce:LSl	Lkotlinx/coroutines/ce;
    //   63: astore_3
    //   64: invokestatic 181	kotlinx/coroutines/ce:geq	()Lkotlinx/coroutines/bc;
    //   67: astore_3
    //   68: aload_3
    //   69: invokevirtual 186	kotlinx/coroutines/bc:gdU	()Z
    //   72: ifeq +28 -> 100
    //   75: aload_0
    //   76: aload 4
    //   78: putfield 127	kotlinx/coroutines/at:_state	Ljava/lang/Object;
    //   81: aload_0
    //   82: iconst_0
    //   83: putfield 165	kotlinx/coroutines/at:LRu	I
    //   86: aload_3
    //   87: aload_0
    //   88: checkcast 5	kotlinx/coroutines/aw
    //   91: invokevirtual 190	kotlinx/coroutines/bc:b	(Lkotlinx/coroutines/aw;)V
    //   94: ldc 149
    //   96: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: return
    //   100: aload_0
    //   101: checkcast 5	kotlinx/coroutines/aw
    //   104: astore 4
    //   106: aload_3
    //   107: iconst_1
    //   108: invokevirtual 194	kotlinx/coroutines/bc:zG	(Z)V
    //   111: aload_0
    //   112: invokevirtual 133	kotlinx/coroutines/at:fOf	()Ld/d/f;
    //   115: astore 5
    //   117: aload 5
    //   119: aload_0
    //   120: getfield 141	kotlinx/coroutines/at:LRo	Ljava/lang/Object;
    //   123: invokestatic 197	kotlinx/coroutines/internal/w:a	(Ld/d/f;Ljava/lang/Object;)Ljava/lang/Object;
    //   126: astore 6
    //   128: aload_0
    //   129: getfield 119	kotlinx/coroutines/at:LRr	Ld/d/d;
    //   132: aload_1
    //   133: invokeinterface 199 2 0
    //   138: getstatic 205	d/y:KTp	Ld/y;
    //   141: astore_1
    //   142: aload 5
    //   144: aload 6
    //   146: invokestatic 208	kotlinx/coroutines/internal/w:b	(Ld/d/f;Ljava/lang/Object;)V
    //   149: aload_3
    //   150: invokevirtual 211	kotlinx/coroutines/bc:gdT	()Z
    //   153: istore_2
    //   154: iload_2
    //   155: ifne -6 -> 149
    //   158: aload_3
    //   159: invokevirtual 214	kotlinx/coroutines/bc:gdW	()V
    //   162: ldc 149
    //   164: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: return
    //   168: astore_1
    //   169: aload 5
    //   171: aload 6
    //   173: invokestatic 208	kotlinx/coroutines/internal/w:b	(Ld/d/f;Ljava/lang/Object;)V
    //   176: ldc 149
    //   178: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: aload_1
    //   182: athrow
    //   183: astore_1
    //   184: aload 4
    //   186: aload_1
    //   187: aconst_null
    //   188: invokevirtual 218	kotlinx/coroutines/aw:c	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   191: aload_3
    //   192: invokevirtual 214	kotlinx/coroutines/bc:gdW	()V
    //   195: ldc 149
    //   197: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: return
    //   201: astore_1
    //   202: aload_3
    //   203: invokevirtual 214	kotlinx/coroutines/bc:gdW	()V
    //   206: ldc 149
    //   208: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: aload_1
    //   212: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	at
    //   0	213	1	paramObject	Object
    //   153	2	2	bool	boolean
    //   14	189	3	localObject1	Object
    //   19	166	4	localObject2	Object
    //   115	55	5	localf	f
    //   126	46	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   128	142	168	finally
    //   111	128	183	java/lang/Throwable
    //   142	149	183	java/lang/Throwable
    //   149	154	183	java/lang/Throwable
    //   169	183	183	java/lang/Throwable
    //   111	128	201	finally
    //   142	149	201	finally
    //   149	154	201	finally
    //   169	183	201	finally
    //   184	191	201	finally
  }
  
  public final f fOf()
  {
    AppMethodBeat.i(118201);
    f localf = this.LRr.fOf();
    AppMethodBeat.o(118201);
    return localf;
  }
  
  public final d.d.b.a.d fOh()
  {
    return this.LRn;
  }
  
  public final StackTraceElement fOi()
  {
    return null;
  }
  
  public final Object gdn()
  {
    AppMethodBeat.i(191160);
    Object localObject = this._state;
    if (al.gdD())
    {
      if (localObject != au.gdM()) {}
      for (int i = 1; i == 0; i = 0)
      {
        localObject = (Throwable)new AssertionError();
        AppMethodBeat.o(191160);
        throw ((Throwable)localObject);
      }
    }
    this._state = au.gdM();
    AppMethodBeat.o(191160);
    return localObject;
  }
  
  public final d.d.d<T> gdt()
  {
    return (d.d.d)this;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118199);
    String str = "DispatchedContinuation[" + this.LRq + ", " + am.e(this.LRr) + ']';
    AppMethodBeat.o(118199);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.at
 * JD-Core Version:    0.7.0.1
 */