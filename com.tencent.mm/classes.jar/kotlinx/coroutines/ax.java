package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.l;
import kotlinx.coroutines.internal.z;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/DispatchedContinuation;", "T", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlin/coroutines/Continuation;", "continuation", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "Lkotlinx/coroutines/CancellableContinuation;", "", "checkPostponedCancellation", "(Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Throwable;", "Lkotlinx/coroutines/CancellableContinuationImpl;", "claimReusableCancellableContinuation", "()Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlin/coroutines/CoroutineContext;", "context", "value", "", "dispatchYield$kotlinx_coroutines_core", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "dispatchYield", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "requester", "", "isReusable", "(Lkotlinx/coroutines/CancellableContinuationImpl;)Z", "cause", "postponeCancellation", "(Ljava/lang/Throwable;)Z", "Lkotlin/Result;", "result", "resumeCancellableWith", "(Ljava/lang/Object;)V", "resumeCancelled", "()Z", "resumeUndispatchedWith", "resumeWith", "", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "", "toString", "()Ljava/lang/String;", "_state", "Ljava/lang/Object;", "_state$annotations", "()V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "countOrElement", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "delegate", "Lkotlinx/coroutines/CoroutineDispatcher;", "getReusableCancellableContinuation", "reusableCancellableContinuation", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;"})
public final class ax<T>
  extends ba<T>
  implements e, d<T>
{
  static final AtomicReferenceFieldUpdater abwO;
  volatile Object _reusableCancellableContinuation;
  public Object _state;
  private final e abwM;
  public final Object abwN;
  public final af abwP;
  public final d<T> abwQ;
  
  static
  {
    AppMethodBeat.i(204928);
    abwO = AtomicReferenceFieldUpdater.newUpdater(ax.class, Object.class, "_reusableCancellableContinuation");
    AppMethodBeat.o(204928);
  }
  
  public ax(af paramaf, d<? super T> paramd)
  {
    super(0);
    AppMethodBeat.i(118200);
    this.abwP = paramaf;
    this.abwQ = paramd;
    this._state = ay.iRp();
    paramd = this.abwQ;
    paramaf = paramd;
    if (!(paramd instanceof e)) {
      paramaf = null;
    }
    this.abwM = ((e)paramaf);
    this.abwN = z.f(getContext());
    this._reusableCancellableContinuation = null;
    AppMethodBeat.o(118200);
  }
  
  public final Throwable a(m<?> paramm)
  {
    AppMethodBeat.i(204925);
    Object localObject;
    do
    {
      localObject = this._reusableCancellableContinuation;
      if (localObject != ay.abwS) {
        break;
      }
    } while (!abwO.compareAndSet(this, ay.abwS, paramm));
    AppMethodBeat.o(204925);
    return null;
    if (localObject == null)
    {
      AppMethodBeat.o(204925);
      return null;
    }
    if ((localObject instanceof Throwable))
    {
      if (!abwO.compareAndSet(this, localObject, null))
      {
        paramm = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
        AppMethodBeat.o(204925);
        throw paramm;
      }
      paramm = (Throwable)localObject;
      AppMethodBeat.o(204925);
      return paramm;
    }
    paramm = (Throwable)new IllegalStateException("Inconsistent state ".concat(String.valueOf(localObject)).toString());
    AppMethodBeat.o(204925);
    throw paramm;
  }
  
  public final e getCallerFrame()
  {
    return this.abwM;
  }
  
  public final f getContext()
  {
    AppMethodBeat.i(118201);
    f localf = this.abwQ.getContext();
    AppMethodBeat.o(118201);
    return localf;
  }
  
  public final StackTraceElement getStackTraceElement()
  {
    return null;
  }
  
  public final Object iQO()
  {
    AppMethodBeat.i(204926);
    Object localObject = this._state;
    if (ap.iRg())
    {
      if (localObject != ay.iRp()) {}
      for (int i = 1; i == 0; i = 0)
      {
        localObject = (Throwable)new AssertionError();
        AppMethodBeat.o(204926);
        throw ((Throwable)localObject);
      }
    }
    this._state = ay.iRp();
    AppMethodBeat.o(204926);
    return localObject;
  }
  
  public final d<T> iQU()
  {
    return (d)this;
  }
  
  /* Error */
  public final void resumeWith(Object paramObject)
  {
    // Byte code:
    //   0: ldc 202
    //   2: invokestatic 98	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 121	kotlinx/coroutines/ax:abwQ	Lkotlin/d/d;
    //   9: invokeinterface 187 1 0
    //   14: astore_3
    //   15: aload_1
    //   16: invokestatic 208	kotlinx/coroutines/y:ga	(Ljava/lang/Object;)Ljava/lang/Object;
    //   19: astore 4
    //   21: aload_0
    //   22: getfield 119	kotlinx/coroutines/ax:abwP	Lkotlinx/coroutines/af;
    //   25: invokevirtual 213	kotlinx/coroutines/af:iRd	()Z
    //   28: ifeq +32 -> 60
    //   31: aload_0
    //   32: aload 4
    //   34: putfield 129	kotlinx/coroutines/ax:_state	Ljava/lang/Object;
    //   37: aload_0
    //   38: iconst_0
    //   39: putfield 217	kotlinx/coroutines/ax:abwT	I
    //   42: aload_0
    //   43: getfield 119	kotlinx/coroutines/ax:abwP	Lkotlinx/coroutines/af;
    //   46: aload_3
    //   47: aload_0
    //   48: checkcast 219	java/lang/Runnable
    //   51: invokevirtual 222	kotlinx/coroutines/af:a	(Lkotlin/d/f;Ljava/lang/Runnable;)V
    //   54: ldc 202
    //   56: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: return
    //   60: getstatic 228	kotlinx/coroutines/cv:abxO	Lkotlinx/coroutines/cv;
    //   63: astore_3
    //   64: invokestatic 232	kotlinx/coroutines/cv:iRX	()Lkotlinx/coroutines/bi;
    //   67: astore_3
    //   68: aload_3
    //   69: invokevirtual 237	kotlinx/coroutines/bi:iRw	()Z
    //   72: ifeq +28 -> 100
    //   75: aload_0
    //   76: aload 4
    //   78: putfield 129	kotlinx/coroutines/ax:_state	Ljava/lang/Object;
    //   81: aload_0
    //   82: iconst_0
    //   83: putfield 217	kotlinx/coroutines/ax:abwT	I
    //   86: aload_3
    //   87: aload_0
    //   88: checkcast 5	kotlinx/coroutines/ba
    //   91: invokevirtual 241	kotlinx/coroutines/bi:b	(Lkotlinx/coroutines/ba;)V
    //   94: ldc 202
    //   96: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: return
    //   100: aload_0
    //   101: checkcast 5	kotlinx/coroutines/ba
    //   104: astore 4
    //   106: aload_3
    //   107: iconst_1
    //   108: invokevirtual 245	kotlinx/coroutines/bi:JE	(Z)V
    //   111: aload_0
    //   112: invokevirtual 134	kotlinx/coroutines/ax:getContext	()Lkotlin/d/f;
    //   115: astore 5
    //   117: aload 5
    //   119: aload_0
    //   120: getfield 142	kotlinx/coroutines/ax:abwN	Ljava/lang/Object;
    //   123: invokestatic 248	kotlinx/coroutines/internal/z:a	(Lkotlin/d/f;Ljava/lang/Object;)Ljava/lang/Object;
    //   126: astore 6
    //   128: aload_0
    //   129: getfield 121	kotlinx/coroutines/ax:abwQ	Lkotlin/d/d;
    //   132: aload_1
    //   133: invokeinterface 250 2 0
    //   138: getstatic 256	kotlin/x:aazN	Lkotlin/x;
    //   141: astore_1
    //   142: aload 5
    //   144: aload 6
    //   146: invokestatic 259	kotlinx/coroutines/internal/z:b	(Lkotlin/d/f;Ljava/lang/Object;)V
    //   149: aload_3
    //   150: invokevirtual 262	kotlinx/coroutines/bi:iRv	()Z
    //   153: istore_2
    //   154: iload_2
    //   155: ifne -6 -> 149
    //   158: aload_3
    //   159: iconst_1
    //   160: invokevirtual 265	kotlinx/coroutines/bi:JF	(Z)V
    //   163: ldc 202
    //   165: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: return
    //   169: astore_1
    //   170: aload 5
    //   172: aload 6
    //   174: invokestatic 259	kotlinx/coroutines/internal/z:b	(Lkotlin/d/f;Ljava/lang/Object;)V
    //   177: ldc 202
    //   179: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: aload_1
    //   183: athrow
    //   184: astore_1
    //   185: aload 4
    //   187: aload_1
    //   188: aconst_null
    //   189: invokevirtual 269	kotlinx/coroutines/ba:c	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   192: aload_3
    //   193: iconst_1
    //   194: invokevirtual 265	kotlinx/coroutines/bi:JF	(Z)V
    //   197: ldc 202
    //   199: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: return
    //   203: astore_1
    //   204: aload_3
    //   205: iconst_1
    //   206: invokevirtual 265	kotlinx/coroutines/bi:JF	(Z)V
    //   209: ldc 202
    //   211: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: aload_1
    //   215: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	ax
    //   0	216	1	paramObject	Object
    //   153	2	2	bool	boolean
    //   14	191	3	localObject1	Object
    //   19	167	4	localObject2	Object
    //   115	56	5	localf	f
    //   126	47	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   128	142	169	finally
    //   111	128	184	java/lang/Throwable
    //   142	149	184	java/lang/Throwable
    //   149	154	184	java/lang/Throwable
    //   170	184	184	java/lang/Throwable
    //   111	128	203	finally
    //   142	149	203	finally
    //   149	154	203	finally
    //   170	184	203	finally
    //   185	192	203	finally
  }
  
  public final String toString()
  {
    AppMethodBeat.i(118199);
    String str = "DispatchedContinuation[" + this.abwP + ", " + aq.m(this.abwQ) + ']';
    AppMethodBeat.o(118199);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.ax
 * JD-Core Version:    0.7.0.1
 */