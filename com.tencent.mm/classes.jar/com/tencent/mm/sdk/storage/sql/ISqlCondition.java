package com.tencent.mm.sdk.storage.sql;

import java.util.Set;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/ISqlCondition;", "Lcom/tencent/mm/sdk/storage/sql/ISqlObj;", "and", "cond", "getAllCondition", "", "or", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface ISqlCondition
  extends ISqlObj
{
  public abstract ISqlCondition and(ISqlCondition paramISqlCondition);
  
  public abstract Set<ISqlCondition> getAllCondition();
  
  public abstract ISqlCondition or(ISqlCondition paramISqlCondition);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.ISqlCondition
 * JD-Core Version:    0.7.0.1
 */