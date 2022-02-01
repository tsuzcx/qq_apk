package kotlinx.coroutines;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.d.a.b;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlin.g.b.ag;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.internal.z;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlinx/coroutines/AbstractCoroutine;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/CoroutineScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "context", "context$annotations", "()V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "getCoroutineContext", "isActive", "()Z", "afterResume", "", "state", "", "cancellationExceptionMessage", "", "handleOnCompletionException", "exception", "", "handleOnCompletionException$kotlinx_coroutines_core", "initParentJob", "initParentJob$kotlinx_coroutines_core", "nameString", "nameString$kotlinx_coroutines_core", "onCancelled", "cause", "handled", "onCompleted", "value", "(Ljava/lang/Object;)V", "onCompletionInternal", "onStart", "onStartInternal", "onStartInternal$kotlinx_coroutines_core", "resumeWith", "result", "Lkotlin/Result;", "start", "R", "Lkotlinx/coroutines/CoroutineStart;", "receiver", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function1;", "(Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"})
public abstract class a<T>
  extends ce
  implements d<T>, ak
{
  private final f abvW;
  protected final f abvX;
  
  public a(f paramf, boolean paramBoolean)
  {
    super(paramBoolean);
    this.abvX = paramf;
    this.abvW = this.abvX.plus((f)this);
  }
  
  public final <R> void a(am paramam, R paramR, kotlin.g.a.m<? super R, ? super d<? super T>, ? extends Object> paramm)
  {
    iQC();
    d locald = (d)this;
    switch (an.jLJ[paramam.ordinal()])
    {
    default: 
      throw new kotlin.m();
    case 1: 
      kotlinx.coroutines.c.a.b(paramm, paramR, locald);
    }
    do
    {
      return;
      p.k(paramm, "$this$startCoroutine");
      p.k(locald, "completion");
      paramam = b.k(b.a(paramm, paramR, locald));
      paramR = x.aazN;
      paramm = Result.Companion;
      paramam.resumeWith(Result.constructor-impl(paramR));
      return;
      p.k(locald, "completion");
      Object localObject;
      try
      {
        paramam = locald.getContext();
        localObject = z.a(paramam, null);
        if (paramm == null) {
          try
          {
            throw new t("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
          }
          finally
          {
            z.b(paramam, localObject);
          }
        }
        paramR = ((kotlin.g.a.m)ag.x(paramm, 2)).invoke(paramR, locald);
      }
      catch (Throwable paramam)
      {
        paramR = Result.Companion;
        locald.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramam)));
        return;
      }
      z.b(paramam, localObject);
    } while (paramR == kotlin.d.a.a.aaAA);
    paramam = Result.Companion;
    locald.resumeWith(Result.constructor-impl(paramR));
  }
  
  protected void b(Throwable paramThrowable, boolean paramBoolean) {}
  
  protected final void fS(Object paramObject)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void fT(Object paramObject)
  {
    fU(paramObject);
  }
  
  public final f getContext()
  {
    return this.abvW;
  }
  
  public f getCoroutineContext()
  {
    return this.abvW;
  }
  
  public final void iQC()
  {
    c((by)this.abvX.get((f.c)by.abxs));
  }
  
  public final void iQD()
  {
    onStart();
  }
  
  protected void iQE() {}
  
  protected final String iQF()
  {
    return getClass().getSimpleName() + " was cancelled";
  }
  
  public String iQG()
  {
    String str = ae.a(this.abvW);
    if (str == null) {
      return super.iQG();
    }
    return "\"" + str + "\":" + super.iQG();
  }
  
  public boolean isActive()
  {
    return super.isActive();
  }
  
  protected void onStart() {}
  
  public final void resumeWith(Object paramObject)
  {
    paramObject = gi(y.ga(paramObject));
    if (paramObject == cf.abxE) {
      return;
    }
    fT(paramObject);
  }
  
  public final void x(Throwable paramThrowable)
  {
    ah.b(this.abvW, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlinx.coroutines.a
 * JD-Core Version:    0.7.0.1
 */