package kotlin.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.a;
import kotlin.d.b.a.i;
import kotlin.d.f;
import kotlin.d.g;
import kotlin.g.a.m;
import kotlin.g.b.an;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"createCoroutineFromSuspendFunction", "Lkotlin/coroutines/Continuation;", "", "T", "completion", "block", "Lkotlin/Function1;", "", "createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt", "createCoroutineUnintercepted", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "intercepted", "startCoroutineUninterceptedOrReturn", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "P", "Lkotlin/Function3;", "param", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/coroutines/intrinsics/IntrinsicsKt")
public class c
{
  public static final <R, T> kotlin.d.d<ah> a(final m<? super R, ? super kotlin.d.d<? super T>, ? extends Object> paramm, final R paramR, kotlin.d.d<? super T> paramd)
  {
    AppMethodBeat.i(129593);
    s.u(paramm, "$this$createCoroutineUnintercepted");
    s.u(paramd, "completion");
    s.u(paramd, "completion");
    if ((paramm instanceof a))
    {
      paramm = ((a)paramm).create(paramR, paramd);
      AppMethodBeat.o(129593);
      return paramm;
    }
    final f localf = paramd.getContext();
    if (localf == g.aiwf)
    {
      if (paramd == null)
      {
        paramm = new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        AppMethodBeat.o(129593);
        throw paramm;
      }
      paramm = (kotlin.d.d)new a(paramd, paramd, paramm, paramR);
      AppMethodBeat.o(129593);
      return paramm;
    }
    if (paramd == null)
    {
      paramm = new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
      AppMethodBeat.o(129593);
      throw paramm;
    }
    paramm = (kotlin.d.d)new b(paramd, localf, paramd, localf, paramm, paramR);
    AppMethodBeat.o(129593);
    return paramm;
  }
  
  public static final <T> kotlin.d.d<T> au(kotlin.d.d<? super T> paramd)
  {
    AppMethodBeat.i(129594);
    s.u(paramd, "$this$intercepted");
    if (!(paramd instanceof kotlin.d.b.a.d)) {}
    for (Object localObject = null;; localObject = paramd)
    {
      kotlin.d.b.a.d locald = (kotlin.d.b.a.d)localObject;
      localObject = paramd;
      if (locald != null)
      {
        localObject = locald.intercepted();
        if (localObject != null) {
          break label49;
        }
        localObject = paramd;
      }
      label49:
      for (;;)
      {
        AppMethodBeat.o(129594);
        return localObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1", "Lkotlin/coroutines/jvm/internal/RestrictedContinuationImpl;", "label", "", "invokeSuspend", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class a
    extends i
  {
    private int label;
    
    public a(kotlin.d.d paramd1, kotlin.d.d paramd2, m paramm, Object paramObject)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(129592);
      switch (this.label)
      {
      default: 
        paramObject = (Throwable)new IllegalStateException("This coroutine had already completed".toString());
        AppMethodBeat.o(129592);
        throw paramObject;
      case 0: 
        this.label = 1;
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlin.d.d)this;
        m localm = paramm;
        if (localm == null)
        {
          paramObject = new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
          AppMethodBeat.o(129592);
          throw paramObject;
        }
        paramObject = ((m)an.y(localm, 2)).invoke(paramR, paramObject);
        AppMethodBeat.o(129592);
        return paramObject;
      }
      this.label = 2;
      ResultKt.throwOnFailure(paramObject);
      AppMethodBeat.o(129592);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "label", "", "invokeSuspend", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static final class b
    extends kotlin.d.b.a.d
  {
    private int label;
    
    public b(kotlin.d.d paramd1, f paramf1, kotlin.d.d paramd2, f paramf2, m paramm, Object paramObject)
    {
      super(paramf2);
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(129598);
      switch (this.label)
      {
      default: 
        paramObject = (Throwable)new IllegalStateException("This coroutine had already completed".toString());
        AppMethodBeat.o(129598);
        throw paramObject;
      case 0: 
        this.label = 1;
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlin.d.d)this;
        m localm = paramm;
        if (localm == null)
        {
          paramObject = new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
          AppMethodBeat.o(129598);
          throw paramObject;
        }
        paramObject = ((m)an.y(localm, 2)).invoke(paramR, paramObject);
        AppMethodBeat.o(129598);
        return paramObject;
      }
      this.label = 2;
      ResultKt.throwOnFailure(paramObject);
      AppMethodBeat.o(129598);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.d.a.c
 * JD-Core Version:    0.7.0.1
 */