package com.tencent.mm.sdk.statecenter;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/statecenter/IStateAction;", "", "result", "Lcom/tencent/mm/sdk/statecenter/IStateActionResult;", "getResult", "()Lcom/tencent/mm/sdk/statecenter/IStateActionResult;", "setResult", "(Lcom/tencent/mm/sdk/statecenter/IStateActionResult;)V", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface IStateAction
{
  public abstract IStateActionResult getResult();
  
  public abstract void setResult(IStateActionResult paramIStateActionResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.statecenter.IStateAction
 * JD-Core Version:    0.7.0.1
 */