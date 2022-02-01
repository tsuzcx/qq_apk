package com.tencent.mm.sdk.statecenter;

import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/statecenter/BaseStateAction;", "Lcom/tencent/mm/sdk/statecenter/IStateAction;", "()V", "result", "Lcom/tencent/mm/sdk/statecenter/IStateActionResult;", "getResult", "()Lcom/tencent/mm/sdk/statecenter/IStateActionResult;", "setResult", "(Lcom/tencent/mm/sdk/statecenter/IStateActionResult;)V", "checkResult", "T", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "action", "", "(Lkotlin/jvm/functions/Function1;)Lcom/tencent/mm/sdk/statecenter/IStateActionResult;", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class BaseStateAction
  implements IStateAction
{
  private IStateActionResult result;
  
  public IStateActionResult getResult()
  {
    return this.result;
  }
  
  public void setResult(IStateActionResult paramIStateActionResult)
  {
    this.result = paramIStateActionResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.statecenter.BaseStateAction
 * JD-Core Version:    0.7.0.1
 */