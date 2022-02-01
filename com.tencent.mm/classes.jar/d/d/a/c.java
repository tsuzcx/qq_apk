package d.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.d.b.a.a;
import d.d.b.a.i;
import d.d.f;
import d.d.g;
import d.g.a.m;
import d.g.b.ae;
import d.g.b.p;
import d.l;
import d.v;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"createCoroutineFromSuspendFunction", "Lkotlin/coroutines/Continuation;", "", "T", "completion", "block", "Lkotlin/Function1;", "", "createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt", "createCoroutineUnintercepted", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "R", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "intercepted", "startCoroutineUninterceptedOrReturn", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlin-stdlib"}, gkc=1)
public class c
{
  public static final <R, T> d.d.d<z> a(final m<? super R, ? super d.d.d<? super T>, ? extends Object> paramm, final R paramR, d.d.d<? super T> paramd)
  {
    AppMethodBeat.i(129593);
    p.h(paramm, "$this$createCoroutineUnintercepted");
    p.h(paramd, "completion");
    p.h(paramd, "completion");
    if ((paramm instanceof a))
    {
      paramm = ((a)paramm).a(paramR, paramd);
      AppMethodBeat.o(129593);
      return paramm;
    }
    final f localf = paramd.gkg();
    if (localf == g.Nib)
    {
      if (paramd == null)
      {
        paramm = new v("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        AppMethodBeat.o(129593);
        throw paramm;
      }
      paramm = (d.d.d)new a(paramd, paramd, paramm, paramR);
      AppMethodBeat.o(129593);
      return paramm;
    }
    if (paramd == null)
    {
      paramm = new v("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
      AppMethodBeat.o(129593);
      throw paramm;
    }
    paramm = (d.d.d)new b(paramd, localf, paramd, localf, paramm, paramR);
    AppMethodBeat.o(129593);
    return paramm;
  }
  
  public static final <T> d.d.d<T> d(d.d.d<? super T> paramd)
  {
    AppMethodBeat.i(129594);
    p.h(paramd, "$this$intercepted");
    if (!(paramd instanceof d.d.b.a.d)) {}
    for (Object localObject = null;; localObject = paramd)
    {
      d.d.b.a.d locald = (d.d.b.a.d)localObject;
      localObject = paramd;
      if (locald != null)
      {
        localObject = locald.gkl();
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1", "Lkotlin/coroutines/jvm/internal/RestrictedContinuationImpl;", "label", "", "invokeSuspend", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"})
  public static final class a
    extends i
  {
    private int label;
    
    public a(d.d.d paramd1, d.d.d paramd2, m paramm, Object paramObject)
    {
      super();
    }
    
    public final Object cR(Object paramObject)
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
        paramObject = (d.d.d)this;
        m localm = paramm;
        if (localm == null)
        {
          paramObject = new v("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
          AppMethodBeat.o(129592);
          throw paramObject;
        }
        paramObject = ((m)ae.p(localm, 2)).p(paramR, paramObject);
        AppMethodBeat.o(129592);
        return paramObject;
      }
      this.label = 2;
      AppMethodBeat.o(129592);
      return paramObject;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"kotlin/coroutines/intrinsics/IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "label", "", "invokeSuspend", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"})
  public static final class b
    extends d.d.b.a.d
  {
    private int label;
    
    public b(d.d.d paramd1, f paramf1, d.d.d paramd2, f paramf2, m paramm, Object paramObject)
    {
      super(paramf2);
    }
    
    public final Object cR(Object paramObject)
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
        paramObject = (d.d.d)this;
        m localm = paramm;
        if (localm == null)
        {
          paramObject = new v("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
          AppMethodBeat.o(129598);
          throw paramObject;
        }
        paramObject = ((m)ae.p(localm, 2)).p(paramR, paramObject);
        AppMethodBeat.o(129598);
        return paramObject;
      }
      this.label = 2;
      AppMethodBeat.o(129598);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.d.a.c
 * JD-Core Version:    0.7.0.1
 */