package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.b.a.e;
import d.d.d;
import d.d.f;
import d.l;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.a.q;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/DispatchedContinuation;", "T", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlin/coroutines/Continuation;", "continuation", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "Lkotlinx/coroutines/CancellableContinuation;", "", "checkPostponedCancellation", "(Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Throwable;", "Lkotlinx/coroutines/CancellableContinuationImpl;", "claimReusableCancellableContinuation", "()Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlin/coroutines/CoroutineContext;", "context", "value", "", "dispatchYield$kotlinx_coroutines_core", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "dispatchYield", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "cause", "", "postponeCancellation", "(Ljava/lang/Throwable;)Z", "Lkotlin/Result;", "result", "resumeCancellableWith", "(Ljava/lang/Object;)V", "resumeCancelled", "()Z", "resumeUndispatchedWith", "resumeWith", "", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "", "toString", "()Ljava/lang/String;", "_state", "Ljava/lang/Object;", "_state$annotations", "()V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "countOrElement", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "delegate", "Lkotlinx/coroutines/CoroutineDispatcher;", "isReusable", "getReusableCancellableContinuation", "reusableCancellableContinuation", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;"})
public final class ap<T>
  extends ar<T>
  implements e, d<T>
{
  static final AtomicReferenceFieldUpdater KdO;
  private final e KdM;
  public final Object KdN;
  public final y KdP;
  public final d<T> KdQ;
  volatile Object _reusableCancellableContinuation;
  public Object _state;
  
  static
  {
    AppMethodBeat.i(190040);
    KdO = AtomicReferenceFieldUpdater.newUpdater(ap.class, Object.class, "_reusableCancellableContinuation");
    AppMethodBeat.o(190040);
  }
  
  public ap(y paramy, d<? super T> paramd)
  {
    super(0);
    AppMethodBeat.i(118200);
    this.KdP = paramy;
    this.KdQ = paramd;
    this._state = aq.fLe();
    paramd = this.KdQ;
    paramy = paramd;
    if (!(paramd instanceof e)) {
      paramy = null;
    }
    this.KdM = ((e)paramy);
    this.KdN = q.d(fvA());
    this._reusableCancellableContinuation = null;
    AppMethodBeat.o(118200);
  }
  
  /* Error */
  public final void eH(Object paramObject)
  {
    // Byte code:
    //   0: ldc 149
    //   2: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 119	kotlinx/coroutines/ap:KdQ	Ld/d/d;
    //   9: invokeinterface 150 1 0
    //   14: astore_3
    //   15: aload_1
    //   16: invokestatic 156	kotlinx/coroutines/r:fB	(Ljava/lang/Object;)Ljava/lang/Object;
    //   19: astore 4
    //   21: aload_0
    //   22: getfield 117	kotlinx/coroutines/ap:KdP	Lkotlinx/coroutines/y;
    //   25: invokevirtual 161	kotlinx/coroutines/y:fKU	()Z
    //   28: ifeq +32 -> 60
    //   31: aload_0
    //   32: aload 4
    //   34: putfield 127	kotlinx/coroutines/ap:_state	Ljava/lang/Object;
    //   37: aload_0
    //   38: iconst_0
    //   39: putfield 165	kotlinx/coroutines/ap:KdT	I
    //   42: aload_0
    //   43: getfield 117	kotlinx/coroutines/ap:KdP	Lkotlinx/coroutines/y;
    //   46: aload_3
    //   47: aload_0
    //   48: checkcast 167	java/lang/Runnable
    //   51: invokevirtual 171	kotlinx/coroutines/y:a	(Ld/d/f;Ljava/lang/Runnable;)V
    //   54: ldc 149
    //   56: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: return
    //   60: getstatic 177	kotlinx/coroutines/bz:KeL	Lkotlinx/coroutines/bz;
    //   63: astore_3
    //   64: invokestatic 181	kotlinx/coroutines/bz:fLG	()Lkotlinx/coroutines/ax;
    //   67: astore_3
    //   68: aload_3
    //   69: invokevirtual 186	kotlinx/coroutines/ax:fLl	()Z
    //   72: ifeq +28 -> 100
    //   75: aload_0
    //   76: aload 4
    //   78: putfield 127	kotlinx/coroutines/ap:_state	Ljava/lang/Object;
    //   81: aload_0
    //   82: iconst_0
    //   83: putfield 165	kotlinx/coroutines/ap:KdT	I
    //   86: aload_3
    //   87: aload_0
    //   88: checkcast 5	kotlinx/coroutines/ar
    //   91: invokevirtual 190	kotlinx/coroutines/ax:b	(Lkotlinx/coroutines/ar;)V
    //   94: ldc 149
    //   96: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: return
    //   100: aload_0
    //   101: checkcast 5	kotlinx/coroutines/ar
    //   104: astore 4
    //   106: aload_3
    //   107: iconst_1
    //   108: invokevirtual 194	kotlinx/coroutines/ax:yo	(Z)V
    //   111: aload_0
    //   112: invokevirtual 133	kotlinx/coroutines/ap:fvA	()Ld/d/f;
    //   115: astore 5
    //   117: aload 5
    //   119: aload_0
    //   120: getfield 141	kotlinx/coroutines/ap:KdN	Ljava/lang/Object;
    //   123: invokestatic 197	kotlinx/coroutines/a/q:a	(Ld/d/f;Ljava/lang/Object;)Ljava/lang/Object;
    //   126: astore 6
    //   128: aload_0
    //   129: getfield 119	kotlinx/coroutines/ap:KdQ	Ld/d/d;
    //   132: aload_1
    //   133: invokeinterface 199 2 0
    //   138: getstatic 205	d/y:JfV	Ld/y;
    //   141: astore_1
    //   142: aload 5
    //   144: aload 6
    //   146: invokestatic 208	kotlinx/coroutines/a/q:b	(Ld/d/f;Ljava/lang/Object;)V
    //   149: aload_3
    //   150: invokevirtual 211	kotlinx/coroutines/ax:fLk	()Z
    //   153: istore_2
    //   154: iload_2
    //   155: ifne -6 -> 149
    //   158: aload_3
    //   159: invokevirtual 214	kotlinx/coroutines/ax:fLn	()V
    //   162: ldc 149
    //   164: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: return
    //   168: astore_1
    //   169: aload 5
    //   171: aload 6
    //   173: invokestatic 208	kotlinx/coroutines/a/q:b	(Ld/d/f;Ljava/lang/Object;)V
    //   176: ldc 149
    //   178: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: aload_1
    //   182: athrow
    //   183: astore_1
    //   184: aload 4
    //   186: aload_1
    //   187: aconst_null
    //   188: invokevirtual 218	kotlinx/coroutines/ar:c	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   191: aload_3
    //   192: invokevirtual 214	kotlinx/coroutines/ax:fLn	()V
    //   195: ldc 149
    //   197: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: return
    //   201: astore_1
    //   202: aload_3
    //   203: invokevirtual 214	kotlinx/coroutines/ax:fLn	()V
    //   206: ldc 149
    //   208: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: aload_1
    //   212: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	ap
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
  
  public final Object fKG()
  {
    AppMethodBeat.i(190039);
    Object localObject = this._state;
    if (ah.fKW())
    {
      if (localObject != aq.fLe()) {}
      for (int i = 1; i == 0; i = 0)
      {
        localObject = (Throwable)new AssertionError();
        AppMethodBeat.o(190039);
        throw ((Throwable)localObject);
      }
    }
    this._state = aq.fLe();
    AppMethodBeat.o(190039);
    return localObject;
  }
  
  public final d<T> fKM()
  {
    return (d)this;
  }
  
  public final f fvA()
  {
    AppMethodBeat.i(118201);
    f localf = this.KdQ.fvA();
    AppMethodBeat.o(118201);
    return localf;
  }
  
  public final e fvC()
  {
    return this.KdM;
  }
  
  public final StackTraceElement fvD()
  {
    return null;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118199);
    String str = "DispatchedContinuation[" + this.KdP + ", " + ai.e(this.KdQ) + ']';
    AppMethodBeat.o(118199);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.ap
 * JD-Core Version:    0.7.0.1
 */