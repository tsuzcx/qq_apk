package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.d.a.b;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.internal.y;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlinx/coroutines/AbstractCoroutine;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/CoroutineScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "context", "context$annotations", "()V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "getCoroutineContext", "isActive", "()Z", "afterResume", "", "state", "", "cancellationExceptionMessage", "", "handleOnCompletionException", "exception", "", "handleOnCompletionException$kotlinx_coroutines_core", "initParentJob", "initParentJob$kotlinx_coroutines_core", "nameString", "nameString$kotlinx_coroutines_core", "onCancelled", "cause", "handled", "onCompleted", "value", "(Ljava/lang/Object;)V", "onCompletionInternal", "onStart", "onStartInternal", "onStartInternal$kotlinx_coroutines_core", "resumeWith", "result", "Lkotlin/Result;", "start", "R", "Lkotlinx/coroutines/CoroutineStart;", "receiver", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function1;", "(Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"})
public abstract class a<T>
  extends ca
  implements d<T>, ai, bu
{
  private final f TTt;
  protected final f TTu;
  
  public a(f paramf, boolean paramBoolean)
  {
    super(paramBoolean);
    this.TTu = paramf;
    this.TTt = this.TTu.plus((f)this);
  }
  
  public final <R> void a(ak paramak, R paramR, kotlin.g.a.m<? super R, ? super d<? super T>, ? extends Object> paramm)
  {
    hMl();
    d locald = (d)this;
    switch (al.haE[paramak.ordinal()])
    {
    default: 
      throw new kotlin.m();
    case 1: 
      kotlinx.coroutines.a.a.b(paramm, paramR, locald);
    }
    do
    {
      return;
      p.h(paramm, "$this$startCoroutine");
      p.h(locald, "completion");
      paramak = b.e(b.a(paramm, paramR, locald));
      paramR = x.SXb;
      paramm = Result.Companion;
      paramak.resumeWith(Result.constructor-impl(paramR));
      return;
      p.h(locald, "completion");
      Object localObject;
      try
      {
        paramak = locald.getContext();
        localObject = y.a(paramak, null);
        if (paramm == null) {
          try
          {
            throw new t("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
          }
          finally
          {
            y.b(paramak, localObject);
          }
        }
        paramR = ((kotlin.g.a.m)kotlin.g.b.af.r(paramm, 2)).invoke(paramR, locald);
      }
      catch (Throwable paramak)
      {
        paramR = Result.Companion;
        locald.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramak)));
        return;
      }
      y.b(paramak, localObject);
    } while (paramR == kotlin.d.a.a.SXO);
    paramak = Result.Companion;
    locald.resumeWith(Result.constructor-impl(paramR));
  }
  
  protected void fM(Object paramObject)
  {
    fS(paramObject);
  }
  
  public final f getContext()
  {
    return this.TTt;
  }
  
  public final f hMk()
  {
    return this.TTt;
  }
  
  public final void hMl()
  {
    b((bu)this.TTu.get((f.c)bu.TUO));
  }
  
  public final void hMm()
  {
    onStart();
  }
  
  protected final String hMn()
  {
    return getClass().getSimpleName() + " was cancelled";
  }
  
  public String hMo()
  {
    String str = ac.a(this.TTt);
    if (str == null) {
      return super.hMo();
    }
    return "\"" + str + "\":" + super.hMo();
  }
  
  public final boolean isActive()
  {
    return super.isActive();
  }
  
  protected void onStart() {}
  
  public final void resumeWith(Object paramObject)
  {
    paramObject = fZ(w.fQ(paramObject));
    if (paramObject == cb.TVb) {
      return;
    }
    fM(paramObject);
  }
  
  public final void x(Throwable paramThrowable)
  {
    af.b(this.TTt, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     kotlinx.coroutines.a
 * JD-Core Version:    0.7.0.1
 */