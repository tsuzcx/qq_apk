package com.tencent.mm.sdk.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/sql/ColumnBitValueCondition;", "Lcom/tencent/mm/sdk/sql/SingleCondition;", "column", "", "bitValue", "", "bitOperation", "Lcom/tencent/mm/sdk/sql/ISqlObj$ConditionBitOperation;", "compareValue", "operator", "Lcom/tencent/mm/sdk/sql/ISqlObj$ConditionOperation;", "(Ljava/lang/String;ILcom/tencent/mm/sdk/sql/ISqlObj$ConditionBitOperation;ILcom/tencent/mm/sdk/sql/ISqlObj$ConditionOperation;)V", "getBitOperation", "()Lcom/tencent/mm/sdk/sql/ISqlObj$ConditionBitOperation;", "getBitValue", "()I", "getColumn", "()Ljava/lang/String;", "getCompareValue", "getOperator", "()Lcom/tencent/mm/sdk/sql/ISqlObj$ConditionOperation;", "toSql", "wechat-sdk_release"})
public class ColumnBitValueCondition
  extends SingleCondition
{
  private final ISqlObj.ConditionBitOperation bitOperation;
  private final int bitValue;
  private final String column;
  private final int compareValue;
  private final ISqlObj.ConditionOperation operator;
  
  public ColumnBitValueCondition(String paramString, int paramInt1, ISqlObj.ConditionBitOperation paramConditionBitOperation, int paramInt2, ISqlObj.ConditionOperation paramConditionOperation)
  {
    AppMethodBeat.i(192494);
    this.column = paramString;
    this.bitValue = paramInt1;
    this.bitOperation = paramConditionBitOperation;
    this.compareValue = paramInt2;
    this.operator = paramConditionOperation;
    AppMethodBeat.o(192494);
  }
  
  public final ISqlObj.ConditionBitOperation getBitOperation()
  {
    return this.bitOperation;
  }
  
  public final int getBitValue()
  {
    return this.bitValue;
  }
  
  public final String getColumn()
  {
    return this.column;
  }
  
  public final int getCompareValue()
  {
    return this.compareValue;
  }
  
  public final ISqlObj.ConditionOperation getOperator()
  {
    return this.operator;
  }
  
  public String toSql()
  {
    AppMethodBeat.i(192486);
    String str = "(" + this.column + ' ' + this.bitOperation + ' ' + this.bitValue + ") " + this.operator + ' ' + this.compareValue;
    AppMethodBeat.o(192486);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.sql.ColumnBitValueCondition
 * JD-Core Version:    0.7.0.1
 */