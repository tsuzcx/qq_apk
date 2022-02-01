package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.l;
import kotlinx.coroutines.internal.y;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/DispatchedContinuation;", "T", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlin/coroutines/Continuation;", "continuation", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "Lkotlinx/coroutines/CancellableContinuation;", "", "checkPostponedCancellation", "(Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Throwable;", "Lkotlinx/coroutines/CancellableContinuationImpl;", "claimReusableCancellableContinuation", "()Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlin/coroutines/CoroutineContext;", "context", "value", "", "dispatchYield$kotlinx_coroutines_core", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "dispatchYield", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "cause", "", "postponeCancellation", "(Ljava/lang/Throwable;)Z", "Lkotlin/Result;", "result", "resumeCancellableWith", "(Ljava/lang/Object;)V", "resumeCancelled", "()Z", "resumeUndispatchedWith", "resumeWith", "", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "", "toString", "()Ljava/lang/String;", "_state", "Ljava/lang/Object;", "_state$annotations", "()V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "countOrElement", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "delegate", "Lkotlinx/coroutines/CoroutineDispatcher;", "isReusable", "getReusableCancellableContinuation", "reusableCancellableContinuation", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;"})
public final class av<T>
  extends ay<T>
  implements e, d<T>
{
  static final AtomicReferenceFieldUpdater TUl;
  private final e TUj;
  public final Object TUk;
  public final ad TUm;
  public final d<T> TUn;
  volatile Object _reusableCancellableContinuation;
  public Object _state;
  
  static
  {
    AppMethodBeat.i(192405);
    TUl = AtomicReferenceFieldUpdater.newUpdater(av.class, Object.class, "_reusableCancellableContinuation");
    AppMethodBeat.o(192405);
  }
  
  public av(ad paramad, d<? super T> paramd)
  {
    super(0);
    AppMethodBeat.i(118200);
    this.TUm = paramad;
    this.TUn = paramd;
    this._state = aw.hMT();
    paramd = this.TUn;
    paramad = paramd;
    if (!(paramd instanceof e)) {
      paramad = null;
    }
    this.TUj = ((e)paramad);
    this.TUk = y.d(getContext());
    this._reusableCancellableContinuation = null;
    AppMethodBeat.o(118200);
  }
  
  public final e getCallerFrame()
  {
    return this.TUj;
  }
  
  public final f getContext()
  {
    AppMethodBeat.i(118201);
    f localf = this.TUn.getContext();
    AppMethodBeat.o(118201);
    return localf;
  }
  
  public final StackTraceElement getStackTraceElement()
  {
    return null;
  }
  
  public final Object hMt()
  {
    AppMethodBeat.i(192404);
    Object localObject = this._state;
    if (an.hMK())
    {
      if (localObject != aw.hMT()) {}
      for (int i = 1; i == 0; i = 0)
      {
        localObject = (Throwable)new AssertionError();
        AppMethodBeat.o(192404);
        throw ((Throwable)localObject);
      }
    }
    this._state = aw.hMT();
    AppMethodBeat.o(192404);
    return localObject;
  }
  
  public final d<T> hMz()
  {
    return (d)this;
  }
  
  /* Error */
  public final void resumeWith(Object paramObject)
  {
    // Byte code:
    //   0: ldc 164
    //   2: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 119	kotlinx/coroutines/av:TUn	Lkotlin/d/d;
    //   9: invokeinterface 147 1 0
    //   14: astore_3
    //   15: aload_1
    //   16: invokestatic 170	kotlinx/coroutines/w:fQ	(Ljava/lang/Object;)Ljava/lang/Object;
    //   19: astore 4
    //   21: aload_0
    //   22: getfield 117	kotlinx/coroutines/av:TUm	Lkotlinx/coroutines/ad;
    //   25: invokevirtual 175	kotlinx/coroutines/ad:hMH	()Z
    //   28: ifeq +32 -> 60
    //   31: aload_0
    //   32: aload 4
    //   34: putfield 127	kotlinx/coroutines/av:_state	Ljava/lang/Object;
    //   37: aload_0
    //   38: iconst_0
    //   39: putfield 179	kotlinx/coroutines/av:TUq	I
    //   42: aload_0
    //   43: getfield 117	kotlinx/coroutines/av:TUm	Lkotlinx/coroutines/ad;
    //   46: aload_3
    //   47: aload_0
    //   48: checkcast 181	java/lang/Runnable
    //   51: invokevirtual 185	kotlinx/coroutines/ad:a	(Lkotlin/d/f;Ljava/lang/Runnable;)V
    //   54: ldc 164
    //   56: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: return
    //   60: getstatic 191	kotlinx/coroutines/cp:TVk	Lkotlinx/coroutines/cp;
    //   63: astore_3
    //   64: invokestatic 195	kotlinx/coroutines/cp:hNz	()Lkotlinx/coroutines/bg;
    //   67: astore_3
    //   68: aload_3
    //   69: invokevirtual 200	kotlinx/coroutines/bg:hNb	()Z
    //   72: ifeq +28 -> 100
    //   75: aload_0
    //   76: aload 4
    //   78: putfield 127	kotlinx/coroutines/av:_state	Ljava/lang/Object;
    //   81: aload_0
    //   82: iconst_0
    //   83: putfield 179	kotlinx/coroutines/av:TUq	I
    //   86: aload_3
    //   87: aload_0
    //   88: checkcast 5	kotlinx/coroutines/ay
    //   91: invokevirtual 204	kotlinx/coroutines/bg:b	(Lkotlinx/coroutines/ay;)V
    //   94: ldc 164
    //   96: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: return
    //   100: aload_0
    //   101: checkcast 5	kotlinx/coroutines/ay
    //   104: astore 4
    //   106: aload_3
    //   107: iconst_1
    //   108: invokevirtual 208	kotlinx/coroutines/bg:EX	(Z)V
    //   111: aload_0
    //   112: invokevirtual 132	kotlinx/coroutines/av:getContext	()Lkotlin/d/f;
    //   115: astore 5
    //   117: aload 5
    //   119: aload_0
    //   120: getfield 140	kotlinx/coroutines/av:TUk	Ljava/lang/Object;
    //   123: invokestatic 211	kotlinx/coroutines/internal/y:a	(Lkotlin/d/f;Ljava/lang/Object;)Ljava/lang/Object;
    //   126: astore 6
    //   128: aload_0
    //   129: getfield 119	kotlinx/coroutines/av:TUn	Lkotlin/d/d;
    //   132: aload_1
    //   133: invokeinterface 213 2 0
    //   138: getstatic 219	kotlin/x:SXb	Lkotlin/x;
    //   141: astore_1
    //   142: aload 5
    //   144: aload 6
    //   146: invokestatic 222	kotlinx/coroutines/internal/y:b	(Lkotlin/d/f;Ljava/lang/Object;)V
    //   149: aload_3
    //   150: invokevirtual 225	kotlinx/coroutines/bg:hNa	()Z
    //   153: istore_2
    //   154: iload_2
    //   155: ifne -6 -> 149
    //   158: aload_3
    //   159: invokevirtual 228	kotlinx/coroutines/bg:hNd	()V
    //   162: ldc 164
    //   164: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   167: return
    //   168: astore_1
    //   169: aload 5
    //   171: aload 6
    //   173: invokestatic 222	kotlinx/coroutines/internal/y:b	(Lkotlin/d/f;Ljava/lang/Object;)V
    //   176: ldc 164
    //   178: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: aload_1
    //   182: athrow
    //   183: astore_1
    //   184: aload 4
    //   186: aload_1
    //   187: aconst_null
    //   188: invokevirtual 232	kotlinx/coroutines/ay:c	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   191: aload_3
    //   192: invokevirtual 228	kotlinx/coroutines/bg:hNd	()V
    //   195: ldc 164
    //   197: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: return
    //   201: astore_1
    //   202: aload_3
    //   203: invokevirtual 228	kotlinx/coroutines/bg:hNd	()V
    //   206: ldc 164
    //   208: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: aload_1
    //   212: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	av
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
  
  public final String toString()
  {
    AppMethodBeat.i(118199);
    String str = "DispatchedContinuation[" + this.TUm + ", " + ao.f(this.TUn) + ']';
    AppMethodBeat.o(118199);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.av
 * JD-Core Version:    0.7.0.1
 */