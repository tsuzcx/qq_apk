package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/ColumnValueCondition;", "Lcom/tencent/mm/sdk/storage/sql/SingleCondition;", "column", "", "value", "operator", "Lcom/tencent/mm/sdk/storage/sql/ISqlObj$ConditionOperation;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/sdk/storage/sql/ISqlObj$ConditionOperation;)V", "getColumn", "()Ljava/lang/String;", "getOperator", "()Lcom/tencent/mm/sdk/storage/sql/ISqlObj$ConditionOperation;", "getValue", "params", "", "()[Ljava/lang/String;", "toSql", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class ColumnValueCondition
  extends SingleCondition
{
  private final String column;
  private final ISqlObj.ConditionOperation operator;
  private final String value;
  
  public ColumnValueCondition(String paramString1, String paramString2, ISqlObj.ConditionOperation paramConditionOperation)
  {
    AppMethodBeat.i(244299);
    this.column = paramString1;
    this.value = paramString2;
    this.operator = paramConditionOperation;
    AppMethodBeat.o(244299);
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
    AppMethodBeat.i(244321);
    String str = this.column + ' ' + this.operator + " ?";
    AppMethodBeat.o(244321);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.ColumnValueCondition
 * JD-Core Version:    0.7.0.1
 */