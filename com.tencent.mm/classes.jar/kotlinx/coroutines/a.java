package kotlinx.coroutines;

import d.d.a.b;
import d.d.d;
import d.d.f;
import d.d.f.c;
import d.l;
import d.z;
import kotlinx.coroutines.internal.x;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlinx/coroutines/AbstractCoroutine;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/CoroutineScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "context", "context$annotations", "()V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "getCoroutineContext", "isActive", "()Z", "afterResume", "", "state", "", "cancellationExceptionMessage", "", "handleOnCompletionException", "exception", "", "handleOnCompletionException$kotlinx_coroutines_core", "initParentJob", "initParentJob$kotlinx_coroutines_core", "nameString", "nameString$kotlinx_coroutines_core", "onCancelled", "cause", "handled", "onCompleted", "value", "(Ljava/lang/Object;)V", "onCompletionInternal", "onStart", "onStartInternal", "onStartInternal$kotlinx_coroutines_core", "resumeWith", "result", "Lkotlin/Result;", "start", "R", "Lkotlinx/coroutines/CoroutineStart;", "receiver", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function1;", "(Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"})
public abstract class a<T>
  extends bv
  implements d<T>, ah, br
{
  protected final f OeA;
  final f Oez;
  
  public a(f paramf, boolean paramBoolean)
  {
    super(paramBoolean);
    this.OeA = paramf;
    this.Oez = this.OeA.plus((f)this);
  }
  
  public final <R> void a(aj paramaj, R paramR, d.g.a.m<? super R, ? super d<? super T>, ? extends Object> paramm)
  {
    gzh();
    d locald = (d)this;
    switch (ak.gpL[paramaj.ordinal()])
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
      paramR = z.Nhr;
      paramm = d.p.Nhh;
      paramaj.eQ(d.p.eO(paramR));
      return;
      d.g.b.p.h(locald, "completion");
      Object localObject;
      try
      {
        paramaj = locald.gkg();
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
        paramR = d.p.Nhh;
        locald.eQ(d.p.eO(d.q.p(paramaj)));
        return;
      }
      x.b(paramaj, localObject);
    } while (paramR == d.d.a.a.Nif);
    paramaj = d.p.Nhh;
    locald.eQ(d.p.eO(paramR));
  }
  
  public final void eQ(Object paramObject)
  {
    paramObject = fU(v.fM(paramObject));
    if (paramObject == bw.Oge) {
      return;
    }
    fI(paramObject);
  }
  
  protected void fI(Object paramObject)
  {
    fO(paramObject);
  }
  
  public final f gkg()
  {
    return this.Oez;
  }
  
  public final f gzg()
  {
    return this.Oez;
  }
  
  public final void gzh()
  {
    Object localObject = (br)this.OeA.get((f.c)br.OfS);
    int i;
    if (am.gzF())
    {
      if ((q)this._parentHandle == null) {}
      for (i = 1; i == 0; i = 0) {
        throw ((Throwable)new AssertionError());
      }
    }
    if (localObject == null) {
      this._parentHandle = ((q)cb.Ogk);
    }
    for (;;)
    {
      return;
      ((br)localObject).start();
      localObject = ((br)localObject).a((s)this);
      this._parentHandle = localObject;
      if (!(gAg() instanceof bm)) {}
      for (i = 1; i != 0; i = 0)
      {
        ((q)localObject).dispose();
        this._parentHandle = ((q)cb.Ogk);
        return;
      }
    }
  }
  
  public final void gzi()
  {
    onStart();
  }
  
  protected final String gzj()
  {
    return getClass().getSimpleName() + " was cancelled";
  }
  
  public final String gzk()
  {
    String str = ab.a(this.Oez);
    if (str == null) {
      return super.gzk();
    }
    return "\"" + str + "\":" + super.gzk();
  }
  
  public final boolean isActive()
  {
    return super.isActive();
  }
  
  protected void onStart() {}
  
  public final void v(Throwable paramThrowable)
  {
    ae.b(this.Oez, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     kotlinx.coroutines.a
 * JD-Core Version:    0.7.0.1
 */