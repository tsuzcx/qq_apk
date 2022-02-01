package kotlinx.coroutines;

import d.d.a.b;
import d.d.d;
import d.d.f;
import d.d.f.c;
import d.g.b.k;
import d.l;
import d.q;
import d.v;
import d.y;
import kotlinx.coroutines.internal.w;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lkotlinx/coroutines/AbstractCoroutine;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/CoroutineScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "context", "context$annotations", "()V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "getCoroutineContext", "isActive", "()Z", "afterResume", "", "state", "", "cancellationExceptionMessage", "", "handleOnCompletionException", "exception", "", "handleOnCompletionException$kotlinx_coroutines_core", "initParentJob", "initParentJob$kotlinx_coroutines_core", "nameString", "nameString$kotlinx_coroutines_core", "onCancelled", "cause", "handled", "onCompleted", "value", "(Ljava/lang/Object;)V", "onCompletionInternal", "onStart", "onStartInternal", "onStartInternal$kotlinx_coroutines_core", "resumeWith", "result", "Lkotlin/Result;", "start", "R", "Lkotlinx/coroutines/CoroutineStart;", "receiver", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function1;", "(Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"})
public abstract class a<T>
  extends bs
  implements d<T>, ag, bo
{
  final f LQy;
  protected final f LQz;
  
  public a(f paramf, boolean paramBoolean)
  {
    super(paramBoolean);
    this.LQz = paramf;
    this.LQy = this.LQz.plus((f)this);
  }
  
  public final <R> void a(ai paramai, R paramR, d.g.a.m<? super R, ? super d<? super T>, ? extends Object> paramm)
  {
    gdf();
    d locald = (d)this;
    switch (aj.fTL[paramai.ordinal()])
    {
    default: 
      throw new d.m();
    case 1: 
      kotlinx.coroutines.a.a.b(paramm, paramR, locald);
    }
    do
    {
      return;
      k.h(paramm, "$this$startCoroutine");
      k.h(locald, "completion");
      paramai = b.d(b.a(paramm, paramR, locald));
      paramR = y.KTp;
      paramm = d.p.KTg;
      paramai.eK(d.p.eI(paramR));
      return;
      k.h(locald, "completion");
      Object localObject;
      try
      {
        paramai = locald.fOf();
        localObject = w.a(paramai, null);
        if (paramm == null) {
          try
          {
            throw new v("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
          }
          finally
          {
            w.b(paramai, localObject);
          }
        }
        paramR = ((d.g.a.m)d.g.b.aa.eU(paramm)).n(paramR, locald);
      }
      catch (Throwable paramai)
      {
        paramR = d.p.KTg;
        locald.eK(d.p.eI(q.n(paramai)));
        return;
      }
      w.b(paramai, localObject);
    } while (paramR == d.d.a.a.KUd);
    paramai = d.p.KTg;
    locald.eK(d.p.eI(paramR));
  }
  
  public final void eK(Object paramObject)
  {
    paramObject = fO(u.fG(paramObject));
    if (paramObject == bt.LSc) {
      return;
    }
    fC(paramObject);
  }
  
  protected void fC(Object paramObject)
  {
    fI(paramObject);
  }
  
  public final f fOf()
  {
    return this.LQy;
  }
  
  public final f gde()
  {
    return this.LQy;
  }
  
  public final void gdf()
  {
    Object localObject = (bo)this.LQz.get((f.c)bo.LRQ);
    int i;
    if (al.gdD())
    {
      if ((p)this._parentHandle == null) {}
      for (i = 1; i == 0; i = 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    if (localObject == null) {
      this._parentHandle = ((p)by.LSi);
    }
    for (;;)
    {
      return;
      ((bo)localObject).start();
      localObject = ((bo)localObject).a((r)this);
      this._parentHandle = localObject;
      if (!(gee() instanceof bj)) {}
      for (i = 1; i != 0; i = 0)
      {
        ((p)localObject).dispose();
        this._parentHandle = ((p)by.LSi);
        return;
      }
    }
  }
  
  public final void gdg()
  {
    onStart();
  }
  
  protected final String gdh()
  {
    return getClass().getSimpleName() + " was cancelled";
  }
  
  public final String gdi()
  {
    String str = aa.a(this.LQy);
    if (str == null) {
      return super.gdi();
    }
    return "\"" + str + "\":" + super.gdi();
  }
  
  public final boolean isActive()
  {
    return super.isActive();
  }
  
  protected void onStart() {}
  
  public final void t(Throwable paramThrowable)
  {
    ad.b(this.LQy, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.a
 * JD-Core Version:    0.7.0.1
 */