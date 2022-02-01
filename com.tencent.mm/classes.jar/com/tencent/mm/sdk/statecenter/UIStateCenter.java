package com.tencent.mm.sdk.statecenter;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.observer.IMvvmObserver;
import com.tencent.mm.sdk.observer.MvvmObserverOwner;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/statecenter/UIStateCenter;", "State", "Lcom/tencent/mm/sdk/statecenter/BaseState;", "", "initState", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "logTag", "", "lifecycleScope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "(Lcom/tencent/mm/sdk/statecenter/BaseState;Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;Lcom/tencent/mm/sdk/coroutines/LifecycleScope;)V", "_state", "Lcom/tencent/mm/sdk/statecenter/BaseState;", "getInitState", "()Lcom/tencent/mm/sdk/statecenter/BaseState;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getLifecycleScope", "()Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "getLogTag", "()Ljava/lang/String;", "observerOwner", "com/tencent/mm/sdk/statecenter/UIStateCenter$observerOwner$1", "Lcom/tencent/mm/sdk/statecenter/UIStateCenter$observerOwner$1;", "rootProcessor", "Lcom/tencent/mm/sdk/statecenter/RootProcessor;", "dispatch", "", "action", "Lcom/tencent/mm/sdk/statecenter/IStateAction;", "getState", "observe", "owner", "observer", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "state", "Lcom/tencent/mm/sdk/observer/IMvvmObserver;", "process", "processor", "Lcom/tencent/mm/sdk/statecenter/IProcessor;", "Companion", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class UIStateCenter<State extends BaseState>
{
  public static final Companion Companion;
  public static final String SCOPE_NAME = "StateCenter.LifecycleScope";
  private State _state;
  private final State initState;
  private final q lifecycleOwner;
  private final LifecycleScope lifecycleScope;
  private final String logTag;
  private final observerOwner.1 observerOwner;
  private final RootProcessor<State> rootProcessor;
  
  static
  {
    AppMethodBeat.i(243365);
    Companion = new Companion(null);
    AppMethodBeat.o(243365);
  }
  
  public UIStateCenter(State paramState, q paramq, String paramString, LifecycleScope paramLifecycleScope)
  {
    AppMethodBeat.i(243320);
    this.initState = paramState;
    this.lifecycleOwner = paramq;
    this.logTag = paramString;
    this.lifecycleScope = paramLifecycleScope;
    this._state = this.initState;
    this.rootProcessor = new RootProcessor();
    this.observerOwner = new MvvmObserverOwner()
    {
      public final String getLogTag()
      {
        AppMethodBeat.i(243362);
        String str = this.this$0.getLogTag();
        AppMethodBeat.o(243362);
        return str;
      }
    };
    AppMethodBeat.o(243320);
  }
  
  private static final void observe$lambda-1(b paramb, BaseState paramBaseState)
  {
    AppMethodBeat.i(243345);
    s.u(paramb, "$tmp0");
    s.u(paramBaseState, "event");
    paramb.invoke(paramBaseState);
    AppMethodBeat.o(243345);
  }
  
  private static final void process$lambda-0(b paramb, BaseState paramBaseState)
  {
    AppMethodBeat.i(243337);
    s.u(paramb, "$tmp0");
    s.u(paramBaseState, "state");
    paramb.invoke(paramBaseState);
    AppMethodBeat.o(243337);
  }
  
  public final void dispatch(final IStateAction paramIStateAction)
  {
    AppMethodBeat.i(243398);
    s.u(paramIStateAction, "action");
    Log.i(this.logTag, s.X("dispatch action:", paramIStateAction));
    LifecycleScope.launchDefault$default(this.lifecycleScope, null, (m)new k(paramIStateAction, null)
    {
      int label;
      
      public final d<ah> create(Object paramAnonymousObject, d<?> paramAnonymousd)
      {
        AppMethodBeat.i(243323);
        paramAnonymousObject = (d)new 1(this.this$0, paramIStateAction, paramAnonymousd);
        AppMethodBeat.o(243323);
        return paramAnonymousObject;
      }
      
      public final Object invoke(aq paramAnonymousaq, d<? super ah> paramAnonymousd)
      {
        AppMethodBeat.i(243333);
        paramAnonymousaq = ((1)create(paramAnonymousaq, paramAnonymousd)).invokeSuspend(ah.aiuX);
        AppMethodBeat.o(243333);
        return paramAnonymousaq;
      }
      
      public final Object invokeSuspend(final Object paramAnonymousObject)
      {
        AppMethodBeat.i(243316);
        a locala = a.aiwj;
        switch (this.label)
        {
        default: 
          paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(243316);
          throw paramAnonymousObject;
        }
        ResultKt.throwOnFailure(paramAnonymousObject);
        paramAnonymousObject = UIStateCenter.access$get_state$p(this.this$0).cloneState();
        paramAnonymousObject.setAction(paramIStateAction);
        UIStateCenter.access$getRootProcessor$p(this.this$0).process(paramAnonymousObject);
        UIStateCenter.access$set_state$p(this.this$0, paramAnonymousObject);
        paramAnonymousObject = paramAnonymousObject.cloneState();
        j.a((aq)this.this$0.getLifecycleScope(), (f)bg.kCh(), null, (m)new k(this.this$0, paramAnonymousObject)
        {
          int label;
          
          public final d<ah> create(Object paramAnonymous2Object, d<?> paramAnonymous2d)
          {
            AppMethodBeat.i(243324);
            paramAnonymous2Object = (d)new 1(this.this$0, paramAnonymousObject, paramAnonymous2d);
            AppMethodBeat.o(243324);
            return paramAnonymous2Object;
          }
          
          public final Object invoke(aq paramAnonymous2aq, d<? super ah> paramAnonymous2d)
          {
            AppMethodBeat.i(243334);
            paramAnonymous2aq = ((1)create(paramAnonymous2aq, paramAnonymous2d)).invokeSuspend(ah.aiuX);
            AppMethodBeat.o(243334);
            return paramAnonymous2aq;
          }
          
          public final Object invokeSuspend(Object paramAnonymous2Object)
          {
            AppMethodBeat.i(243317);
            a locala = a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymous2Object = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(243317);
              throw paramAnonymous2Object;
            }
            ResultKt.throwOnFailure(paramAnonymous2Object);
            UIStateCenter.access$getObserverOwner$p(this.this$0).notify(paramAnonymousObject);
            paramAnonymous2Object = ah.aiuX;
            AppMethodBeat.o(243317);
            return paramAnonymous2Object;
          }
        }, 2);
        paramAnonymousObject = ah.aiuX;
        AppMethodBeat.o(243316);
        return paramAnonymousObject;
      }
    }, 1, null);
    AppMethodBeat.o(243398);
  }
  
  public final State getInitState()
  {
    return this.initState;
  }
  
  public final q getLifecycleOwner()
  {
    return this.lifecycleOwner;
  }
  
  public final LifecycleScope getLifecycleScope()
  {
    return this.lifecycleScope;
  }
  
  public final String getLogTag()
  {
    return this.logTag;
  }
  
  public final State getState()
  {
    return this._state;
  }
  
  public final void observe(q paramq, IMvvmObserver<State> paramIMvvmObserver)
  {
    AppMethodBeat.i(243416);
    s.u(paramq, "owner");
    s.u(paramIMvvmObserver, "observer");
    this.observerOwner.observe(paramq, "%MainThread%", paramIMvvmObserver);
    AppMethodBeat.o(243416);
  }
  
  public final void observe(q paramq, b<? super State, ah> paramb)
  {
    AppMethodBeat.i(243419);
    s.u(paramq, "owner");
    s.u(paramb, "observer");
    this.observerOwner.observe(paramq, "%MainThread%", new UIStateCenter..ExternalSyntheticLambda0(paramb));
    AppMethodBeat.o(243419);
  }
  
  public final void process(q paramq, IProcessor<State> paramIProcessor)
  {
    AppMethodBeat.i(243404);
    s.u(paramq, "owner");
    s.u(paramIProcessor, "processor");
    this.rootProcessor.addProcessor(paramq, paramIProcessor);
    AppMethodBeat.o(243404);
  }
  
  public final void process(q paramq, b<? super State, ah> paramb)
  {
    AppMethodBeat.i(243410);
    s.u(paramq, "owner");
    s.u(paramb, "processor");
    this.rootProcessor.addProcessor(paramq, new UIStateCenter..ExternalSyntheticLambda1(paramb));
    AppMethodBeat.o(243410);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/statecenter/UIStateCenter$Companion;", "", "()V", "SCOPE_NAME", "", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.statecenter.UIStateCenter
 * JD-Core Version:    0.7.0.1
 */