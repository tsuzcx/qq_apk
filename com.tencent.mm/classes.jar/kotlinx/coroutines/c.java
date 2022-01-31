package kotlinx.coroutines;

import a.c.a.b;
import a.c.e;
import a.c.e.c;
import a.f.b.j;
import a.l;
import a.p;
import a.y;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlinx/coroutines/AbstractCoroutine;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/CoroutineScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "context", "context$annotations", "()V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "getCoroutineContext", "defaultResumeMode", "", "getDefaultResumeMode$kotlinx_coroutines_core", "()I", "isActive", "()Z", "handleOnCompletionException", "", "exception", "", "handleOnCompletionException$kotlinx_coroutines_core", "initParentJob", "initParentJob$kotlinx_coroutines_core", "nameString", "", "nameString$kotlinx_coroutines_core", "onCancellation", "cause", "onCompleted", "value", "(Ljava/lang/Object;)V", "onCompletedExceptionally", "onCompletionInternal", "state", "", "mode", "suppressed", "onCompletionInternal$kotlinx_coroutines_core", "onStart", "onStartInternal", "onStartInternal$kotlinx_coroutines_core", "resumeWith", "result", "Lkotlin/Result;", "start", "R", "Lkotlinx/coroutines/CoroutineStart;", "receiver", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function1;", "(Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"})
public abstract class c<T>
  extends bg
  implements a.c.c<T>, ac, bc
{
  private final e CHl;
  protected final e CHm;
  
  public c(e parame, boolean paramBoolean)
  {
    super(paramBoolean);
    this.CHm = parame;
    this.CHl = this.CHm.plus((e)this);
  }
  
  public final <R> void a(ad paramad, R paramR, a.f.a.m<? super R, ? super a.c.c<? super T>, ? extends Object> paramm)
  {
    j.q(paramad, "start");
    j.q(paramm, "block");
    Object localObject1 = (bc)this.CHm.get((e.c)bc.CIk);
    if (this.CIn == null) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalStateException("Check failed.".toString()));
    }
    if (localObject1 == null)
    {
      this.CIn = ((m)bl.CIC);
      localObject1 = (a.c.c)this;
      j.q(paramm, "block");
      j.q(localObject1, "completion");
    }
    switch (ae.pRV[paramad.ordinal()])
    {
    default: 
      throw new a.m();
      ((bc)localObject1).start();
      localObject1 = ((bc)localObject1).a((o)this);
      this.CIn = ((m)localObject1);
      if (!(epR() instanceof ay)) {}
      for (i = 1; i != 0; i = 0)
      {
        ((m)localObject1).dispose();
        this.CIn = ((m)bl.CIC);
        break;
      }
    case 1: 
      kotlinx.coroutines.b.a.b(paramm, paramR, (a.c.c)localObject1);
    }
    for (;;)
    {
      return;
      j.q(paramm, "receiver$0");
      j.q(localObject1, "completion");
      paramad = b.c(b.a(paramm, paramR, (a.c.c)localObject1));
      paramR = y.BMg;
      paramm = p.BLX;
      paramad.dg(p.de(paramR));
      return;
      j.q(paramm, "receiver$0");
      j.q(localObject1, "completion");
      try
      {
        paramad = ((a.c.c)localObject1).eaV();
        Object localObject2 = kotlinx.coroutines.a.o.b(paramad, null);
        try
        {
          paramR = ((a.f.a.m)a.f.b.z.jdMethod_do(paramm)).h(paramR, localObject1);
          kotlinx.coroutines.a.o.a(paramad, localObject2);
          if (paramR == a.c.a.a.BMS) {
            continue;
          }
          paramad = p.BLX;
          ((a.c.c)localObject1).dg(p.de(paramR));
          return;
        }
        finally
        {
          kotlinx.coroutines.a.o.a(paramad, localObject2);
        }
        return;
      }
      catch (Throwable paramad)
      {
        paramR = p.BLX;
        ((a.c.c)localObject1).dg(p.de(a.q.n(paramad)));
      }
    }
  }
  
  public final void dW(Object paramObject)
  {
    if ((paramObject instanceof q)) {
      j.q(((q)paramObject).cause, "exception");
    }
  }
  
  public final void dg(Object paramObject)
  {
    Object localObject1 = null;
    Object localObject2 = r.dY(paramObject);
    switch (super.I(epR(), localObject2))
    {
    case 3: 
    default: 
      throw ((Throwable)new IllegalStateException("unexpected result".toString()));
    case 0: 
      String str = "Job " + this + " is already complete or completing, but is being completed with " + localObject2;
      paramObject = localObject2;
      if (!(localObject2 instanceof q)) {
        paramObject = null;
      }
      localObject2 = (q)paramObject;
      paramObject = localObject1;
      if (localObject2 != null) {
        paramObject = ((q)localObject2).cause;
      }
      throw ((Throwable)new IllegalStateException(str, paramObject));
    }
  }
  
  public final e eaV()
  {
    return this.CHl;
  }
  
  public final e epr()
  {
    return this.CHl;
  }
  
  public final void eps()
  {
    onStart();
  }
  
  public final String ept()
  {
    String str = v.a(this.CHl);
    if (str == null) {
      return super.ept();
    }
    return "\"" + str + "\":" + super.ept();
  }
  
  public final boolean isActive()
  {
    return super.isActive();
  }
  
  protected void onStart() {}
  
  public final void u(Throwable paramThrowable)
  {
    j.q(paramThrowable, "exception");
    z.a(this.CHm, paramThrowable, (bc)this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlinx.coroutines.c
 * JD-Core Version:    0.7.0.1
 */