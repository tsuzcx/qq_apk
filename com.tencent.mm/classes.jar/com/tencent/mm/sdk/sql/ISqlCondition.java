package com.tencent.mm.sdk.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/sql/ISqlCondition;", "Lcom/tencent/mm/sdk/sql/ISqlObj;", "and", "cond", "or", "wechat-sdk_release"})
public abstract interface ISqlCondition
  extends ISqlObj
{
  public abstract ISqlCondition and(ISqlCondition paramISqlCondition);
  
  public abstract ISqlCondition or(ISqlCondition paramISqlCondition);
  
  @l(iBK={1, 1, 16})
  public static final class DefaultImpls
  {
    public static String[] params(ISqlCondition paramISqlCondition)
    {
      AppMethodBeat.i(193478);
      paramISqlCondition = ISqlObj.DefaultImpls.params((ISqlObj)paramISqlCondition);
      AppMethodBeat.o(193478);
      return paramISqlCondition;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.sql.ISqlCondition
 * JD-Core Version:    0.7.0.1
 */