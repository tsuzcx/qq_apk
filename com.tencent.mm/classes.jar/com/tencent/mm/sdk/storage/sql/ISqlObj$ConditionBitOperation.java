package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/ISqlObj$ConditionBitOperation;", "", "opName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getOpName", "()Ljava/lang/String;", "toString", "And", "Or", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum ISqlObj$ConditionBitOperation
{
  private final String opName;
  
  static
  {
    AppMethodBeat.i(244368);
    And = new ConditionBitOperation("And", 0, "&");
    Or = new ConditionBitOperation("Or", 1, "|");
    $VALUES = $values();
    AppMethodBeat.o(244368);
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
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.ISqlObj.ConditionBitOperation
 * JD-Core Version:    0.7.0.1
 */