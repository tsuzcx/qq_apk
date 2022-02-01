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
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/statecenter/ServiceStateCenter;", "State", "Lcom/tencent/mm/sdk/statecenter/BaseState;", "", "initState", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "logTag", "", "lifecycleScope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "(Lcom/tencent/mm/sdk/statecenter/BaseState;Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;Lcom/tencent/mm/sdk/coroutines/LifecycleScope;)V", "_state", "Lcom/tencent/mm/sdk/statecenter/BaseState;", "getInitState", "()Lcom/tencent/mm/sdk/statecenter/BaseState;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getLifecycleScope", "()Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "getLogTag", "()Ljava/lang/String;", "observerOwner", "com/tencent/mm/sdk/statecenter/ServiceStateCenter$observerOwner$1", "Lcom/tencent/mm/sdk/statecenter/ServiceStateCenter$observerOwner$1;", "rootProcessor", "Lcom/tencent/mm/sdk/statecenter/RootProcessor;", "dispatch", "", "action", "Lcom/tencent/mm/sdk/statecenter/IStateAction;", "getState", "observe", "owner", "observer", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "state", "Lcom/tencent/mm/sdk/observer/IMvvmObserver;", "process", "processor", "Lcom/tencent/mm/sdk/statecenter/IProcessor;", "Companion", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ServiceStateCenter<State extends BaseState>
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
    AppMethodBeat.i(243403);
    Companion = new Companion(null);
    AppMethodBeat.o(243403);
  }
  
  public ServiceStateCenter(State paramState, q paramq, String paramString, LifecycleScope paramLifecycleScope)
  {
    AppMethodBeat.i(243369);
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
        AppMethodBeat.i(243322);
        String str = this.this$0.getLogTag();
        AppMethodBeat.o(243322);
        return str;
      }
    };
    AppMethodBeat.o(243369);
  }
  
  private static final void observe$lambda-1(b paramb, BaseState paramBaseState)
  {
    AppMethodBeat.i(243387);
    s.u(paramb, "$tmp0");
    s.u(paramBaseState, "event");
    paramb.invoke(paramBaseState);
    AppMethodBeat.o(243387);
  }
  
  private static final void process$lambda-0(b paramb, BaseState paramBaseState)
  {
    AppMethodBeat.i(243383);
    s.u(paramb, "$tmp0");
    s.u(paramBaseState, "state");
    paramb.invoke(paramBaseState);
    AppMethodBeat.o(243383);
  }
  
  public final void dispatch(final IStateAction paramIStateAction)
  {
    AppMethodBeat.i(243434);
    s.u(paramIStateAction, "action");
    Log.i(this.logTag, s.X("dispatch action:", paramIStateAction));
    LifecycleScope.launchDefault$default(this.lifecycleScope, null, (m)new k(paramIStateAction, null)
    {
      int label;
      
      public final d<ah> create(Object paramAnonymousObject, d<?> paramAnonymousd)
      {
        AppMethodBeat.i(243364);
        paramAnonymousObject = (d)new 1(this.this$0, paramIStateAction, paramAnonymousd);
        AppMethodBeat.o(243364);
        return paramAnonymousObject;
      }
      
      public final Object invoke(aq paramAnonymousaq, d<? super ah> paramAnonymousd)
      {
        AppMethodBeat.i(243370);
        paramAnonymousaq = ((1)create(paramAnonymousaq, paramAnonymousd)).invokeSuspend(ah.aiuX);
        AppMethodBeat.o(243370);
        return paramAnonymousaq;
      }
      
      public final Object invokeSuspend(Object paramAnonymousObject)
      {
        AppMethodBeat.i(243357);
        a locala = a.aiwj;
        switch (this.label)
        {
        default: 
          paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(243357);
          throw paramAnonymousObject;
        }
        ResultKt.throwOnFailure(paramAnonymousObject);
        paramAnonymousObject = ServiceStateCenter.access$get_state$p(this.this$0).cloneState();
        paramAnonymousObject.setAction(paramIStateAction);
        ServiceStateCenter.access$getRootProcessor$p(this.this$0).process(paramAnonymousObject);
        ServiceStateCenter.access$set_state$p(this.this$0, paramAnonymousObject);
        paramAnonymousObject = paramAnonymousObject.cloneState();
        ServiceStateCenter.access$getObserverOwner$p(this.this$0).notify(paramAnonymousObject);
        paramAnonymousObject = ah.aiuX;
        AppMethodBeat.o(243357);
        return paramAnonymousObject;
      }
    }, 1, null);
    AppMethodBeat.o(243434);
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
    AppMethodBeat.i(243453);
    s.u(paramq, "owner");
    s.u(paramIMvvmObserver, "observer");
    this.observerOwner.observe(paramq, "%MainThread%", paramIMvvmObserver);
    AppMethodBeat.o(243453);
  }
  
  public final void observe(q paramq, b<? super State, ah> paramb)
  {
    AppMethodBeat.i(243459);
    s.u(paramq, "owner");
    s.u(paramb, "observer");
    this.observerOwner.observe(paramq, "%MainThread%", new ServiceStateCenter..ExternalSyntheticLambda0(paramb));
    AppMethodBeat.o(243459);
  }
  
  public final void process(q paramq, IProcessor<State> paramIProcessor)
  {
    AppMethodBeat.i(243439);
    s.u(paramq, "owner");
    s.u(paramIProcessor, "processor");
    this.rootProcessor.addProcessor(paramq, paramIProcessor);
    AppMethodBeat.o(243439);
  }
  
  public final void process(q paramq, b<? super State, ah> paramb)
  {
    AppMethodBeat.i(243446);
    s.u(paramq, "owner");
    s.u(paramb, "processor");
    this.rootProcessor.addProcessor(paramq, new ServiceStateCenter..ExternalSyntheticLambda1(paramb));
    AppMethodBeat.o(243446);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/statecenter/ServiceStateCenter$Companion;", "", "()V", "SCOPE_NAME", "", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.statecenter.ServiceStateCenter
 * JD-Core Version:    0.7.0.1
 */