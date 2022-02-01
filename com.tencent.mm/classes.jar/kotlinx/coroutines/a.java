package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.b;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.p;
import kotlinx.coroutines.internal.ag;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/AbstractCoroutine;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/CoroutineScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "initParentJob", "", "active", "(Lkotlin/coroutines/CoroutineContext;ZZ)V", "context", "getContext$annotations", "()V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "getCoroutineContext", "isActive", "()Z", "afterResume", "", "state", "", "cancellationExceptionMessage", "", "handleOnCompletionException", "exception", "", "handleOnCompletionException$kotlinx_coroutines_core", "nameString", "nameString$kotlinx_coroutines_core", "onCancelled", "cause", "handled", "onCompleted", "value", "(Ljava/lang/Object;)V", "onCompletionInternal", "resumeWith", "result", "Lkotlin/Result;", "start", "R", "Lkotlinx/coroutines/CoroutineStart;", "receiver", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a<T>
  extends ci
  implements d<T>, aq
{
  private final f aMa;
  
  public a(f paramf, boolean paramBoolean)
  {
    super(paramBoolean);
    f((cb)paramf.get((f.c)cb.ajws));
    this.aMa = paramf.plus((f)this);
  }
  
  public final void M(Throwable paramThrowable)
  {
    an.b(this.aMa, paramThrowable);
  }
  
  public final <R> void a(as paramas, R paramR, m<? super R, ? super d<? super T>, ? extends Object> paramm)
  {
    d locald = (d)this;
    switch (as.a.$EnumSwitchMapping$0[paramas.ordinal()])
    {
    default: 
      throw new p();
    case 1: 
      kotlinx.coroutines.c.a.b(paramm, paramR, locald);
    }
    do
    {
      return;
      s.u(paramm, "$this$startCoroutine");
      s.u(locald, "completion");
      paramas = b.au(b.a(paramm, paramR, locald));
      paramR = ah.aiuX;
      paramm = Result.Companion;
      paramas.resumeWith(Result.constructor-impl(paramR));
      return;
      s.u(locald, "completion");
      Object localObject;
      try
      {
        paramas = locald.getContext();
        localObject = ag.b(paramas, null);
        if (paramm == null) {
          try
          {
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
          }
          finally
          {
            ag.c(paramas, localObject);
          }
        }
        paramR = ((m)kotlin.g.b.an.y(paramm, 2)).invoke(paramR, locald);
      }
      finally
      {
        paramR = Result.Companion;
        locald.resumeWith(Result.constructor-impl(ResultKt.createFailure(paramas)));
        return;
      }
      ag.c(paramas, localObject);
    } while (paramR == kotlin.d.a.a.aiwj);
    paramas = Result.Companion;
    locald.resumeWith(Result.constructor-impl(paramR));
  }
  
  protected void b(Throwable paramThrowable, boolean paramBoolean) {}
  
  public final f getContext()
  {
    return this.aMa;
  }
  
  public f getCoroutineContext()
  {
    return this.aMa;
  }
  
  public boolean isActive()
  {
    return super.isActive();
  }
  
  protected final void iu(Object paramObject)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected void iv(Object paramObject)
  {
    iw(paramObject);
  }
  
  protected void kBs() {}
  
  protected final String kBt()
  {
    return s.X(getClass().getSimpleName(), " was cancelled");
  }
  
  public String kBu()
  {
    String str = ak.b(this.aMa);
    if (str == null) {
      return super.kBu();
    }
    return "\"" + str + "\":" + super.kBu();
  }
  
  public final void resumeWith(Object paramObject)
  {
    paramObject = iK(ai.e(paramObject, null));
    if (paramObject == cj.ajwE) {
      return;
    }
    iv(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.a
 * JD-Core Version:    0.7.0.1
 */