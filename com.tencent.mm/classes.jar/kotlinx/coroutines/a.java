package kotlinx.coroutines;

import d.d.a.b;
import d.d.d;
import d.d.f;
import d.d.f.c;
import d.l;
import d.z;
import kotlinx.coroutines.internal.x;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlinx/coroutines/AbstractCoroutine;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/CoroutineScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "context", "context$annotations", "()V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "getCoroutineContext", "isActive", "()Z", "afterResume", "", "state", "", "cancellationExceptionMessage", "", "handleOnCompletionException", "exception", "", "handleOnCompletionException$kotlinx_coroutines_core", "initParentJob", "initParentJob$kotlinx_coroutines_core", "nameString", "nameString$kotlinx_coroutines_core", "onCancelled", "cause", "handled", "onCompleted", "value", "(Ljava/lang/Object;)V", "onCompletionInternal", "onStart", "onStartInternal", "onStartInternal$kotlinx_coroutines_core", "resumeWith", "result", "Lkotlin/Result;", "start", "R", "Lkotlinx/coroutines/CoroutineStart;", "receiver", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function1;", "(Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"})
public abstract class a<T>
  extends bv
  implements d<T>, ah, br
{
  final f NHt;
  protected final f NHu;
  
  public a(f paramf, boolean paramBoolean)
  {
    super(paramBoolean);
    this.NHu = paramf;
    this.NHt = this.NHu.plus((f)this);
  }
  
  public final <R> void a(aj paramaj, R paramR, d.g.a.m<? super R, ? super d<? super T>, ? extends Object> paramm)
  {
    guF();
    d locald = (d)this;
    switch (ak.gnp[paramaj.ordinal()])
    {
    default: 
      throw new d.m();
    case 1: 
      kotlinx.coroutines.a.a.b(paramm, paramR, locald);
    }
    do
    {
      return;
      d.g.b.p.h(paramm, "$this$startCoroutine");
      d.g.b.p.h(locald, "completion");
      paramaj = b.d(b.a(paramm, paramR, locald));
      paramR = z.MKo;
      paramm = d.p.MKe;
      paramaj.eN(d.p.eL(paramR));
      return;
      d.g.b.p.h(locald, "completion");
      Object localObject;
      try
      {
        paramaj = locald.gfE();
        localObject = x.a(paramaj, null);
        if (paramm == null) {
          try
          {
            throw new d.v("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
          }
          finally
          {
            x.b(paramaj, localObject);
          }
        }
        paramR = ((d.g.a.m)d.g.b.ae.p(paramm, 2)).p(paramR, locald);
      }
      catch (Throwable paramaj)
      {
        paramR = d.p.MKe;
        locald.eN(d.p.eL(d.q.o(paramaj)));
        return;
      }
      x.b(paramaj, localObject);
    } while (paramR == d.d.a.a.MLc);
    paramaj = d.p.MKe;
    locald.eN(d.p.eL(paramR));
  }
  
  public final void eN(Object paramObject)
  {
    paramObject = fR(v.fJ(paramObject));
    if (paramObject == bw.NIY) {
      return;
    }
    fF(paramObject);
  }
  
  protected void fF(Object paramObject)
  {
    fL(paramObject);
  }
  
  public final f gfE()
  {
    return this.NHt;
  }
  
  public final f guE()
  {
    return this.NHt;
  }
  
  public final void guF()
  {
    Object localObject = (br)this.NHu.get((f.c)br.NIM);
    int i;
    if (am.gvd())
    {
      if ((q)this._parentHandle == null) {}
      for (i = 1; i == 0; i = 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    if (localObject == null) {
      this._parentHandle = ((q)cb.NJe);
    }
    for (;;)
    {
      return;
      ((br)localObject).start();
      localObject = ((br)localObject).a((s)this);
      this._parentHandle = localObject;
      if (!(gvE() instanceof bm)) {}
      for (i = 1; i != 0; i = 0)
      {
        ((q)localObject).dispose();
        this._parentHandle = ((q)cb.NJe);
        return;
      }
    }
  }
  
  public final void guG()
  {
    onStart();
  }
  
  protected final String guH()
  {
    return getClass().getSimpleName() + " was cancelled";
  }
  
  public final String guI()
  {
    String str = ab.a(this.NHt);
    if (str == null) {
      return super.guI();
    }
    return "\"" + str + "\":" + super.guI();
  }
  
  public final boolean isActive()
  {
    return super.isActive();
  }
  
  protected void onStart() {}
  
  public final void u(Throwable paramThrowable)
  {
    ae.b(this.NHt, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.a
 * JD-Core Version:    0.7.0.1
 */