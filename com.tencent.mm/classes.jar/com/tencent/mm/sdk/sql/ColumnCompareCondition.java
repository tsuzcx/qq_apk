package com.tencent.mm.sdk.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/sql/ColumnCompareCondition;", "Lcom/tencent/mm/sdk/sql/SingleCondition;", "column1", "", "column2", "operator", "Lcom/tencent/mm/sdk/sql/ISqlObj$ConditionOperation;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/sdk/sql/ISqlObj$ConditionOperation;)V", "getColumn1", "()Ljava/lang/String;", "getColumn2", "getOperator", "()Lcom/tencent/mm/sdk/sql/ISqlObj$ConditionOperation;", "params", "", "()[Ljava/lang/String;", "toSql", "wechat-sdk_release"})
public class ColumnCompareCondition
  extends SingleCondition
{
  private final String column1;
  private final String column2;
  private final ISqlObj.ConditionOperation operator;
  
  public ColumnCompareCondition(String paramString1, String paramString2, ISqlObj.ConditionOperation paramConditionOperation)
  {
    AppMethodBeat.i(191621);
    this.column1 = paramString1;
    this.column2 = paramString2;
    this.operator = paramConditionOperation;
    AppMethodBeat.o(191621);
  }
  
  public final String getColumn1()
  {
    return this.column1;
  }
  
  public final String getColumn2()
  {
    return this.column2;
  }
  
  public final ISqlObj.ConditionOperation getOperator()
  {
    return this.operator;
  }
  
  public String[] params()
  {
    return null;
  }
  
  public String toSql()
  {
    AppMethodBeat.i(191611);
    String str = this.column1 + ' ' + this.operator + ' ' + this.column2;
    AppMethodBeat.o(191611);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.sql.ColumnCompareCondition
 * JD-Core Version:    0.7.0.1
 */