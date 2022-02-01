package com.tencent.mm.sdk.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/sql/ISqlObj$ConditionBitOperation;", "", "opName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getOpName", "()Ljava/lang/String;", "toString", "And", "Or", "wechat-sdk_release"})
public enum ISqlObj$ConditionBitOperation
{
  private final String opName;
  
  static
  {
    AppMethodBeat.i(189839);
    ConditionBitOperation localConditionBitOperation1 = new ConditionBitOperation("And", 0, "&");
    And = localConditionBitOperation1;
    ConditionBitOperation localConditionBitOperation2 = new ConditionBitOperation("Or", 1, "|");
    Or = localConditionBitOperation2;
    $VALUES = new ConditionBitOperation[] { localConditionBitOperation1, localConditionBitOperation2 };
    AppMethodBeat.o(189839);
  }
  
  private ISqlObj$ConditionBitOperation(String paramString)
  {
    this.opName = paramString;
  }
  
  public final String getOpName()
  {
    return this.opName;
  }
  
  public final String toString()
  {
    return this.opName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.sql.ISqlObj.ConditionBitOperation
 * JD-Core Version:    0.7.0.1
 */