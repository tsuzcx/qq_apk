package com.tencent.mm.sdk.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.m;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/sql/MultiCondition;", "Lcom/tencent/mm/sdk/sql/ISqlCondition;", "cond", "(Lcom/tencent/mm/sdk/sql/ISqlCondition;)V", "params", "", "", "[Ljava/lang/String;", "sql", "and", "merge", "Lcom/tencent/mm/sdk/sql/ISqlObj;", "operator", "Lcom/tencent/mm/sdk/sql/ISqlObj$ConditionConnectOperation;", "or", "()[Ljava/lang/String;", "toSql", "wechat-sdk_release"})
public final class MultiCondition
  implements ISqlCondition
{
  private String[] params;
  private String sql;
  
  public MultiCondition(ISqlCondition paramISqlCondition)
  {
    AppMethodBeat.i(190630);
    this.sql = paramISqlCondition.toSql();
    this.params = paramISqlCondition.params();
    AppMethodBeat.o(190630);
  }
  
  public final MultiCondition and(ISqlCondition paramISqlCondition)
  {
    AppMethodBeat.i(190613);
    p.k(paramISqlCondition, "cond");
    paramISqlCondition = merge((ISqlObj)paramISqlCondition, ISqlObj.ConditionConnectOperation.AND);
    AppMethodBeat.o(190613);
    return paramISqlCondition;
  }
  
  public final MultiCondition merge(ISqlObj paramISqlObj, ISqlObj.ConditionConnectOperation paramConditionConnectOperation)
  {
    AppMethodBeat.i(190612);
    p.k(paramISqlObj, "cond");
    p.k(paramConditionConnectOperation, "operator");
    switch (MultiCondition.WhenMappings.$EnumSwitchMapping$0[paramConditionConnectOperation.ordinal()])
    {
    default: 
      paramISqlObj = new m();
      AppMethodBeat.o(190612);
      throw paramISqlObj;
    }
    for (paramConditionConnectOperation = "AND";; paramConditionConnectOperation = "OR")
    {
      this.sql = ("(" + this.sql + ") " + paramConditionConnectOperation + ' ' + paramISqlObj.toSql());
      paramConditionConnectOperation = new LinkedList();
      String[] arrayOfString = this.params;
      if (arrayOfString != null) {
        j.a((Collection)paramConditionConnectOperation, arrayOfString);
      }
      paramISqlObj = paramISqlObj.params();
      if (paramISqlObj != null) {
        j.a((Collection)paramConditionConnectOperation, paramISqlObj);
      }
      paramISqlObj = ((Collection)paramConditionConnectOperation).toArray(new String[0]);
      if (paramISqlObj != null) {
        break;
      }
      paramISqlObj = new t("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(190612);
      throw paramISqlObj;
    }
    this.params = ((String[])paramISqlObj);
    AppMethodBeat.o(190612);
    return this;
  }
  
  public final MultiCondition or(ISqlCondition paramISqlCondition)
  {
    AppMethodBeat.i(190619);
    p.k(paramISqlCondition, "cond");
    paramISqlCondition = merge((ISqlObj)paramISqlCondition, ISqlObj.ConditionConnectOperation.OR);
    AppMethodBeat.o(190619);
    return paramISqlCondition;
  }
  
  public final String[] params()
  {
    return this.params;
  }
  
  public final String toSql()
  {
    return this.sql;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.sql.MultiCondition
 * JD-Core Version:    0.7.0.1
 */