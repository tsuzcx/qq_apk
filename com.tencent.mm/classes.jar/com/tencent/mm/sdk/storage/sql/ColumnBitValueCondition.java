package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/ColumnBitValueCondition;", "Lcom/tencent/mm/sdk/storage/sql/SingleCondition;", "column", "", "bitValue", "", "bitOperation", "Lcom/tencent/mm/sdk/storage/sql/ISqlObj$ConditionBitOperation;", "compareValue", "operator", "Lcom/tencent/mm/sdk/storage/sql/ISqlObj$ConditionOperation;", "(Ljava/lang/String;ILcom/tencent/mm/sdk/storage/sql/ISqlObj$ConditionBitOperation;ILcom/tencent/mm/sdk/storage/sql/ISqlObj$ConditionOperation;)V", "getBitOperation", "()Lcom/tencent/mm/sdk/storage/sql/ISqlObj$ConditionBitOperation;", "getBitValue", "()I", "getColumn", "()Ljava/lang/String;", "getCompareValue", "getOperator", "()Lcom/tencent/mm/sdk/storage/sql/ISqlObj$ConditionOperation;", "toSql", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
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
    AppMethodBeat.i(244270);
    this.column = paramString;
    this.bitValue = paramInt1;
    this.bitOperation = paramConditionBitOperation;
    this.compareValue = paramInt2;
    this.operator = paramConditionOperation;
    AppMethodBeat.o(244270);
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
    AppMethodBeat.i(244294);
    String str = "(" + this.column + ' ' + this.bitOperation + ' ' + this.bitValue + ") " + this.operator + ' ' + this.compareValue;
    AppMethodBeat.o(244294);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.ColumnBitValueCondition
 * JD-Core Version:    0.7.0.1
 */