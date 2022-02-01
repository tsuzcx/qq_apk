package com.tencent.mm.sdk.statecenter;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/statecenter/IState;", "", "action", "Lcom/tencent/mm/sdk/statecenter/IStateAction;", "getAction", "()Lcom/tencent/mm/sdk/statecenter/IStateAction;", "setAction", "(Lcom/tencent/mm/sdk/statecenter/IStateAction;)V", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface IState
{
  public abstract IStateAction getAction();
  
  public abstract void setAction(IStateAction paramIStateAction);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.statecenter.IState
 * JD-Core Version:    0.7.0.1
 */