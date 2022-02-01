package com.tencent.mm.sdk.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/sql/ColumnValueCondition;", "Lcom/tencent/mm/sdk/sql/SingleCondition;", "column", "", "value", "operator", "Lcom/tencent/mm/sdk/sql/ISqlObj$ConditionOperation;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/sdk/sql/ISqlObj$ConditionOperation;)V", "getColumn", "()Ljava/lang/String;", "getOperator", "()Lcom/tencent/mm/sdk/sql/ISqlObj$ConditionOperation;", "getValue", "params", "", "()[Ljava/lang/String;", "toSql", "wechat-sdk_release"})
public class ColumnValueCondition
  extends SingleCondition
{
  private final String column;
  private final ISqlObj.ConditionOperation operator;
  private final String value;
  
  public ColumnValueCondition(String paramString1, String paramString2, ISqlObj.ConditionOperation paramConditionOperation)
  {
    AppMethodBeat.i(190037);
    this.column = paramString1;
    this.value = paramString2;
    this.operator = paramConditionOperation;
    AppMethodBeat.o(190037);
  }
  
  public final String getColumn()
  {
    return this.column;
  }
  
  public final ISqlObj.ConditionOperation getOperator()
  {
    return this.operator;
  }
  
  public final String getValue()
  {
    return this.value;
  }
  
  public String[] params()
  {
    return new String[] { this.value };
  }
  
  public String toSql()
  {
    AppMethodBeat.i(190027);
    String str = this.column + ' ' + this.operator + " ?";
    AppMethodBeat.o(190027);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.sql.ColumnValueCondition
 * JD-Core Version:    0.7.0.1
 */