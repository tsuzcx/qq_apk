package com.tencent.mm.sdk.statecenter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/statecenter/BaseState;", "Lcom/tencent/mm/sdk/statecenter/IState;", "", "()V", "action", "Lcom/tencent/mm/sdk/statecenter/IStateAction;", "getAction", "()Lcom/tencent/mm/sdk/statecenter/IStateAction;", "setAction", "(Lcom/tencent/mm/sdk/statecenter/IStateAction;)V", "check", "", "Action", "State", "handler", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "state", "stateClazz", "Ljava/lang/Class;", "actionClazz", "checkAction", "T", "Lkotlin/Function1;", "clazz", "(Ljava/lang/Class;)Lcom/tencent/mm/sdk/statecenter/IStateAction;", "cloneState", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class BaseState
  implements IState, Cloneable
{
  private IStateAction action;
  
  public final <Action extends IStateAction, State extends IState> void check(Class<State> paramClass, Class<Action> paramClass1, m<? super State, ? super Action, ah> paramm)
  {
    AppMethodBeat.i(243363);
    s.u(paramClass, "stateClazz");
    s.u(paramClass1, "actionClazz");
    s.u(paramm, "handler");
    if (getClass().isAssignableFrom(paramClass))
    {
      paramClass = (IState)this;
      if (!getClass().isAssignableFrom(paramClass1)) {
        break label83;
      }
    }
    label83:
    for (paramClass1 = (IStateAction)this;; paramClass1 = null)
    {
      if ((paramClass != null) && (paramClass1 != null)) {
        paramm.invoke(paramClass, paramClass1);
      }
      AppMethodBeat.o(243363);
      return;
      paramClass = null;
      break;
    }
  }
  
  public final <T extends IStateAction> T checkAction(Class<T> paramClass)
  {
    AppMethodBeat.i(243352);
    s.u(paramClass, "clazz");
    IStateAction localIStateAction = getAction();
    if ((localIStateAction != null) && (localIStateAction.getClass().isAssignableFrom(paramClass)))
    {
      AppMethodBeat.o(243352);
      return localIStateAction;
    }
    AppMethodBeat.o(243352);
    return null;
  }
  
  public Object clone()
  {
    AppMethodBeat.i(243382);
    Object localObject = super.clone();
    AppMethodBeat.o(243382);
    return localObject;
  }
  
  public final BaseState cloneState()
  {
    AppMethodBeat.i(243375);
    BaseState localBaseState = (BaseState)super.clone();
    AppMethodBeat.o(243375);
    return localBaseState;
  }
  
  public IStateAction getAction()
  {
    return this.action;
  }
  
  public void setAction(IStateAction paramIStateAction)
  {
    this.action = paramIStateAction;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.statecenter.BaseState
 * JD-Core Version:    0.7.0.1
 */