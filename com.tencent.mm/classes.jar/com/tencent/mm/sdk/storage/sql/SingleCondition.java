package com.tencent.mm.sdk.storage.sql;

import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/SingleCondition;", "Lcom/tencent/mm/sdk/storage/sql/ISqlCondition;", "()V", "and", "cond", "getAllCondition", "", "or", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class SingleCondition
  implements ISqlCondition
{
  public ISqlCondition and(ISqlCondition paramISqlCondition)
  {
    s.u(paramISqlCondition, "cond");
    return (ISqlCondition)new MultiCondition(this).and(paramISqlCondition);
  }
  
  public Set<ISqlCondition> getAllCondition()
  {
    return ar.setOf(this);
  }
  
  public ISqlCondition or(ISqlCondition paramISqlCondition)
  {
    s.u(paramISqlCondition, "cond");
    return (ISqlCondition)new MultiCondition(this).or(paramISqlCondition);
  }
  
  public String[] params()
  {
    return ISqlCondition.DefaultImpls.params((ISqlCondition)this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.SingleCondition
 * JD-Core Version:    0.7.0.1
 */