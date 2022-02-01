package kotlinx.coroutines.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.d.b.a.e;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlinx.coroutines.af;
import kotlinx.coroutines.al;
import kotlinx.coroutines.au;
import kotlinx.coroutines.av;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.p;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/internal/DispatchedContinuation;", "T", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlin/coroutines/Continuation;", "continuation", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", "", "awaitReusability", "()V", "", "takenState", "", "cause", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", "Lkotlinx/coroutines/CancellableContinuationImpl;", "claimReusableCancellableContinuation", "()Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlin/coroutines/CoroutineContext;", "context", "value", "dispatchYield$kotlinx_coroutines_core", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "dispatchYield", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "", "isReusable", "()Z", "postponeCancellation", "(Ljava/lang/Throwable;)Z", "release", "Lkotlin/Result;", "result", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onCancellation", "resumeCancellableWith", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "state", "resumeCancelled", "(Ljava/lang/Object;)Z", "resumeUndispatchedWith", "(Ljava/lang/Object;)V", "resumeWith", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/CancellableContinuation;", "tryReleaseClaimedContinuation", "(Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Throwable;", "_state", "Ljava/lang/Object;", "get_state$kotlinx_coroutines_core$annotations", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "countOrElement", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "delegate", "Lkotlinx/coroutines/CoroutineDispatcher;", "getReusableCancellableContinuation", "reusableCancellableContinuation", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;"}, k=1, mv={1, 5, 1}, xi=48)
public final class h<T>
  extends bd<T>
  implements e, d<T>
{
  public Object _state;
  public final Object ajAa;
  public final d<T> alw;
  public final al bRx;
  
  static
  {
    AppMethodBeat.i(189403);
    ajAm = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "_reusableCancellableContinuation");
    AppMethodBeat.o(189403);
  }
  
  public h(al paramal, d<? super T> paramd)
  {
    super(-1);
    AppMethodBeat.i(189394);
    this.bRx = paramal;
    this.alw = paramd;
    this._state = i.kDV();
    this.ajAa = ag.i(getContext());
    this._reusableCancellableContinuation = null;
    AppMethodBeat.o(189394);
  }
  
  public final Throwable a(p<?> paramp)
  {
    AppMethodBeat.i(189428);
    Object localObject;
    do
    {
      localObject = this._reusableCancellableContinuation;
      if (localObject != i.ajAn) {
        break;
      }
    } while (!ajAm.compareAndSet(this, i.ajAn, paramp));
    AppMethodBeat.o(189428);
    return null;
    if ((localObject instanceof Throwable))
    {
      if (!ajAm.compareAndSet(this, localObject, null))
      {
        paramp = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
        AppMethodBeat.o(189428);
        throw paramp;
      }
      paramp = (Throwable)localObject;
      AppMethodBeat.o(189428);
      return paramp;
    }
    paramp = (Throwable)new IllegalStateException(s.X("Inconsistent state ", localObject).toString());
    AppMethodBeat.o(189428);
    throw paramp;
  }
  
  public final void a(Object paramObject, Throwable paramThrowable)
  {
    AppMethodBeat.i(189453);
    if ((paramObject instanceof af)) {
      ((af)paramObject).ajvz.invoke(paramThrowable);
    }
    AppMethodBeat.o(189453);
  }
  
  public final void a(f paramf, T paramT)
  {
    AppMethodBeat.i(189456);
    this._state = paramT;
    this.ajvU = 1;
    this.bRx.b(paramf, (Runnable)this);
    AppMethodBeat.o(189456);
  }
  
  public final e getCallerFrame()
  {
    d locald = this.alw;
    if ((locald instanceof e)) {
      return (e)locald;
    }
    return null;
  }
  
  public final f getContext()
  {
    AppMethodBeat.i(189411);
    f localf = this.alw.getContext();
    AppMethodBeat.o(189411);
    return localf;
  }
  
  public final StackTraceElement getStackTraceElement()
  {
    return null;
  }
  
  public final Object kBC()
  {
    AppMethodBeat.i(189436);
    Object localObject = this._state;
    if (au.ASSERTIONS_ENABLED)
    {
      if (localObject != i.kDV()) {}
      for (int i = 1; i == 0; i = 0)
      {
        localObject = new AssertionError();
        AppMethodBeat.o(189436);
        throw ((Throwable)localObject);
      }
    }
    this._state = i.kDV();
    AppMethodBeat.o(189436);
    return localObject;
  }
  
  public final d<T> kBz()
  {
    return (d)this;
  }
  
  /* Error */
  public final void resumeWith(Object paramObject)
  {
    // Byte code:
    //   0: ldc 236
    //   2: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 133	kotlinx/coroutines/internal/h:alw	Lkotlin/d/d;
    //   9: invokeinterface 220 1 0
    //   14: astore_3
    //   15: aload_1
    //   16: aconst_null
    //   17: invokestatic 242	kotlinx/coroutines/ai:e	(Ljava/lang/Object;Lkotlin/g/a/b;)Ljava/lang/Object;
    //   20: astore 4
    //   22: aload_0
    //   23: getfield 131	kotlinx/coroutines/internal/h:bRx	Lkotlinx/coroutines/al;
    //   26: invokevirtual 245	kotlinx/coroutines/al:kBY	()Z
    //   29: ifeq +32 -> 61
    //   32: aload_0
    //   33: aload 4
    //   35: putfield 141	kotlinx/coroutines/internal/h:_state	Ljava/lang/Object;
    //   38: aload_0
    //   39: iconst_0
    //   40: putfield 208	kotlinx/coroutines/internal/h:ajvU	I
    //   43: aload_0
    //   44: getfield 131	kotlinx/coroutines/internal/h:bRx	Lkotlinx/coroutines/al;
    //   47: aload_3
    //   48: aload_0
    //   49: checkcast 210	java/lang/Runnable
    //   52: invokevirtual 247	kotlinx/coroutines/al:a	(Lkotlin/d/f;Ljava/lang/Runnable;)V
    //   55: ldc 236
    //   57: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: return
    //   61: getstatic 253	kotlinx/coroutines/cz:ajwN	Lkotlinx/coroutines/cz;
    //   64: astore_3
    //   65: invokestatic 257	kotlinx/coroutines/cz:kCM	()Lkotlinx/coroutines/bm;
    //   68: astore_3
    //   69: aload_3
    //   70: invokevirtual 262	kotlinx/coroutines/bm:kCn	()Z
    //   73: ifeq +28 -> 101
    //   76: aload_0
    //   77: aload 4
    //   79: putfield 141	kotlinx/coroutines/internal/h:_state	Ljava/lang/Object;
    //   82: aload_0
    //   83: iconst_0
    //   84: putfield 208	kotlinx/coroutines/internal/h:ajvU	I
    //   87: aload_3
    //   88: aload_0
    //   89: checkcast 5	kotlinx/coroutines/bd
    //   92: invokevirtual 265	kotlinx/coroutines/bm:b	(Lkotlinx/coroutines/bd;)V
    //   95: ldc 236
    //   97: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: return
    //   101: aload_0
    //   102: checkcast 5	kotlinx/coroutines/bd
    //   105: astore 4
    //   107: aload_3
    //   108: iconst_1
    //   109: invokevirtual 269	kotlinx/coroutines/bm:PI	(Z)V
    //   112: aload_0
    //   113: invokevirtual 144	kotlinx/coroutines/internal/h:getContext	()Lkotlin/d/f;
    //   116: astore 5
    //   118: aload 5
    //   120: aload_0
    //   121: getfield 151	kotlinx/coroutines/internal/h:ajAa	Ljava/lang/Object;
    //   124: invokestatic 272	kotlinx/coroutines/internal/ag:b	(Lkotlin/d/f;Ljava/lang/Object;)Ljava/lang/Object;
    //   127: astore 6
    //   129: aload_0
    //   130: getfield 133	kotlinx/coroutines/internal/h:alw	Lkotlin/d/d;
    //   133: aload_1
    //   134: invokeinterface 274 2 0
    //   139: getstatic 280	kotlin/ah:aiuX	Lkotlin/ah;
    //   142: astore_1
    //   143: aload 5
    //   145: aload 6
    //   147: invokestatic 283	kotlinx/coroutines/internal/ag:c	(Lkotlin/d/f;Ljava/lang/Object;)V
    //   150: aload_3
    //   151: invokevirtual 286	kotlinx/coroutines/bm:kCl	()Z
    //   154: istore_2
    //   155: iload_2
    //   156: ifne -6 -> 150
    //   159: aload_3
    //   160: iconst_1
    //   161: invokevirtual 289	kotlinx/coroutines/bm:PJ	(Z)V
    //   164: ldc 236
    //   166: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: return
    //   170: astore_1
    //   171: aload 5
    //   173: aload 6
    //   175: invokestatic 283	kotlinx/coroutines/internal/ag:c	(Lkotlin/d/f;Ljava/lang/Object;)V
    //   178: ldc 236
    //   180: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aload_1
    //   184: athrow
    //   185: astore_1
    //   186: aload 4
    //   188: aload_1
    //   189: aconst_null
    //   190: invokevirtual 292	kotlinx/coroutines/bd:c	(Ljava/lang/Throwable;Ljava/lang/Throwable;)V
    //   193: aload_3
    //   194: iconst_1
    //   195: invokevirtual 289	kotlinx/coroutines/bm:PJ	(Z)V
    //   198: ldc 236
    //   200: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   203: return
    //   204: astore_1
    //   205: aload_3
    //   206: iconst_1
    //   207: invokevirtual 289	kotlinx/coroutines/bm:PJ	(Z)V
    //   210: ldc 236
    //   212: invokestatic 124	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   215: aload_1
    //   216: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	h
    //   0	217	1	paramObject	Object
    //   154	2	2	bool	boolean
    //   14	192	3	localObject1	Object
    //   20	167	4	localObject2	Object
    //   116	56	5	localf	f
    //   127	47	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   129	143	170	finally
    //   112	129	185	finally
    //   143	150	185	finally
    //   150	155	185	finally
    //   171	185	185	finally
    //   186	193	204	finally
  }
  
  public final String toString()
  {
    AppMethodBeat.i(189460);
    String str = "DispatchedContinuation[" + this.bRx + ", " + av.aw(this.alw) + ']';
    AppMethodBeat.o(189460);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.internal.h
 * JD-Core Version:    0.7.0.1
 */