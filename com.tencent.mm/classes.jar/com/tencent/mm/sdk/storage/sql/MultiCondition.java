package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/MultiCondition;", "Lcom/tencent/mm/sdk/storage/sql/ISqlCondition;", "cond", "Lcom/tencent/mm/sdk/storage/sql/SingleCondition;", "(Lcom/tencent/mm/sdk/storage/sql/SingleCondition;)V", "allConditionSet", "", "params", "", "", "[Ljava/lang/String;", "sql", "and", "getAllCondition", "", "merge", "operator", "Lcom/tencent/mm/sdk/storage/sql/ISqlObj$ConditionConnectOperation;", "or", "()[Ljava/lang/String;", "toSql", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MultiCondition
  implements ISqlCondition
{
  private final Set<ISqlCondition> allConditionSet;
  private String[] params;
  private String sql;
  
  public MultiCondition(SingleCondition paramSingleCondition)
  {
    AppMethodBeat.i(244404);
    this.sql = paramSingleCondition.toSql();
    this.params = paramSingleCondition.params();
    this.allConditionSet = ar.mutableSetOf(new ISqlCondition[] { (ISqlCondition)paramSingleCondition });
    AppMethodBeat.o(244404);
  }
  
  public final MultiCondition and(ISqlCondition paramISqlCondition)
  {
    AppMethodBeat.i(244431);
    s.u(paramISqlCondition, "cond");
    paramISqlCondition = merge(paramISqlCondition, ISqlObj.ConditionConnectOperation.AND);
    AppMethodBeat.o(244431);
    return paramISqlCondition;
  }
  
  public final Set<ISqlCondition> getAllCondition()
  {
    return this.allConditionSet;
  }
  
  public final MultiCondition merge(ISqlCondition paramISqlCondition, ISqlObj.ConditionConnectOperation paramConditionConnectOperation)
  {
    AppMethodBeat.i(244422);
    s.u(paramISqlCondition, "cond");
    s.u(paramConditionConnectOperation, "operator");
    switch (WhenMappings.$EnumSwitchMapping$0[paramConditionConnectOperation.ordinal()])
    {
    default: 
      paramISqlCondition = new kotlin.p();
      AppMethodBeat.o(244422);
      throw paramISqlCondition;
    }
    for (paramConditionConnectOperation = "AND";; paramConditionConnectOperation = "OR")
    {
      this.sql = ("(" + this.sql + ") " + paramConditionConnectOperation + ' ' + paramISqlCondition.toSql());
      paramConditionConnectOperation = new LinkedList();
      String[] arrayOfString = this.params;
      if (arrayOfString != null) {
        kotlin.a.p.a((Collection)paramConditionConnectOperation, arrayOfString);
      }
      arrayOfString = paramISqlCondition.params();
      if (arrayOfString != null) {
        kotlin.a.p.a((Collection)paramConditionConnectOperation, arrayOfString);
      }
      paramConditionConnectOperation = ((Collection)paramConditionConnectOperation).toArray(new String[0]);
      if (paramConditionConnectOperation != null) {
        break;
      }
      paramISqlCondition = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(244422);
      throw paramISqlCondition;
    }
    this.params = ((String[])paramConditionConnectOperation);
    this.allConditionSet.addAll((Collection)paramISqlCondition.getAllCondition());
    AppMethodBeat.o(244422);
    return this;
  }
  
  public final MultiCondition or(ISqlCondition paramISqlCondition)
  {
    AppMethodBeat.i(244438);
    s.u(paramISqlCondition, "cond");
    paramISqlCondition = merge(paramISqlCondition, ISqlObj.ConditionConnectOperation.OR);
    AppMethodBeat.o(244438);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.MultiCondition
 * JD-Core Version:    0.7.0.1
 */