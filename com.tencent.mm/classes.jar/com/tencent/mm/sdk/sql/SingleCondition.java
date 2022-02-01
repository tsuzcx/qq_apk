package com.tencent.mm.sdk.sql;

import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/sql/SingleCondition;", "Lcom/tencent/mm/sdk/sql/ISqlCondition;", "()V", "and", "cond", "or", "wechat-sdk_release"})
public abstract class SingleCondition
  implements ISqlCondition
{
  public ISqlCondition and(ISqlCondition paramISqlCondition)
  {
    p.k(paramISqlCondition, "cond");
    return (ISqlCondition)new MultiCondition((ISqlCondition)this).and(paramISqlCondition);
  }
  
  public ISqlCondition or(ISqlCondition paramISqlCondition)
  {
    p.k(paramISqlCondition, "cond");
    return (ISqlCondition)new MultiCondition((ISqlCondition)this).or(paramISqlCondition);
  }
  
  public String[] params()
  {
    return ISqlCondition.DefaultImpls.params(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.sql.SingleCondition
 * JD-Core Version:    0.7.0.1
 */