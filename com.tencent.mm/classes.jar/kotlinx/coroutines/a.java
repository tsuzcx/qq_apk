package kotlinx.coroutines;

import d.d.a.b;
import d.d.d;
import d.d.f;
import d.d.f.c;
import d.g.b.k;
import d.l;
import d.p;
import d.v;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lkotlinx/coroutines/AbstractCoroutine;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/CoroutineScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "context", "context$annotations", "()V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "getCoroutineContext", "isActive", "()Z", "afterResume", "", "state", "", "cancellationExceptionMessage", "", "handleOnCompletionException", "exception", "", "handleOnCompletionException$kotlinx_coroutines_core", "initParentJob", "initParentJob$kotlinx_coroutines_core", "nameString", "nameString$kotlinx_coroutines_core", "onCancelled", "cause", "handled", "onCompleted", "value", "(Ljava/lang/Object;)V", "onCompletionInternal", "onStart", "onStartInternal", "onStartInternal$kotlinx_coroutines_core", "resumeWith", "result", "Lkotlin/Result;", "start", "R", "Lkotlinx/coroutines/CoroutineStart;", "receiver", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function1;", "(Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"})
public abstract class a<T>
  extends bn
  implements d<T>, ad, bj
{
  final f Kdd;
  protected final f Kde;
  
  public a(f paramf, boolean paramBoolean)
  {
    super(paramBoolean);
    this.Kde = paramf;
    this.Kdd = this.Kde.plus((f)this);
  }
  
  public final <R> void a(ae paramae, R paramR, d.g.a.m<? super R, ? super d<? super T>, ? extends Object> paramm)
  {
    gaB();
    d locald = (d)this;
    switch (af.fPQ[paramae.ordinal()])
    {
    default: 
      throw new d.m();
    case 1: 
      kotlinx.coroutines.b.a.b(paramm, paramR, locald);
    }
    do
    {
      return;
      k.h(paramm, "$this$startCoroutine");
      k.h(locald, "completion");
      paramae = b.d(b.a(paramm, paramR, locald));
      paramR = y.JfV;
      paramm = p.JfM;
      paramae.eH(p.eF(paramR));
      return;
      k.h(locald, "completion");
      Object localObject;
      try
      {
        paramae = locald.fvA();
        localObject = kotlinx.coroutines.a.q.a(paramae, null);
        if (paramm == null) {
          try
          {
            throw new v("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
          }
          finally
          {
            kotlinx.coroutines.a.q.b(paramae, localObject);
          }
        }
        paramR = ((d.g.a.m)d.g.b.aa.eR(paramm)).n(paramR, locald);
      }
      catch (Throwable paramae)
      {
        paramR = p.JfM;
        locald.eH(p.eF(d.q.n(paramae)));
        return;
      }
      kotlinx.coroutines.a.q.b(paramae, localObject);
    } while (paramR == d.d.a.a.JgJ);
    paramae = p.JfM;
    locald.eH(p.eF(paramR));
  }
  
  public final void eH(Object paramObject)
  {
    paramObject = gj(r.fB(paramObject));
    if (paramObject == bo.KeC) {
      return;
    }
    gg(paramObject);
  }
  
  public final f fKB()
  {
    return this.Kdd;
  }
  
  public final void fKC()
  {
    onStart();
  }
  
  protected final String fKD()
  {
    return getClass().getSimpleName() + " was cancelled";
  }
  
  public final String fKE()
  {
    String str = x.a(this.Kdd);
    if (str == null) {
      return super.fKE();
    }
    return "\"" + str + "\":" + super.fKE();
  }
  
  public final f fvA()
  {
    return this.Kdd;
  }
  
  public final void gaB()
  {
    Object localObject = (bj)this.Kde.get((f.c)bj.Keq);
    int i;
    if (ah.fKW())
    {
      if ((m)this._parentHandle == null) {}
      for (i = 1; i == 0; i = 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    if (localObject == null) {
      this._parentHandle = ((m)bt.KeI);
    }
    for (;;)
    {
      return;
      ((bj)localObject).start();
      localObject = ((bj)localObject).a((o)this);
      this._parentHandle = localObject;
      if (!(fLv() instanceof be)) {}
      for (i = 1; i != 0; i = 0)
      {
        ((m)localObject).dispose();
        this._parentHandle = ((m)bt.KeI);
        return;
      }
    }
  }
  
  protected void gg(Object paramObject)
  {
    gi(paramObject);
  }
  
  public final boolean isActive()
  {
    return super.isActive();
  }
  
  protected void onStart() {}
  
  public final void t(Throwable paramThrowable)
  {
    aa.b(this.Kdd, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.a
 * JD-Core Version:    0.7.0.1
 */