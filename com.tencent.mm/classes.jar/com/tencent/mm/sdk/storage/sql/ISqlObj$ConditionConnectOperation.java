package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/ISqlObj$ConditionConnectOperation;", "", "(Ljava/lang/String;I)V", "AND", "OR", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum ISqlObj$ConditionConnectOperation
{
  static
  {
    AppMethodBeat.i(244286);
    AND = new ConditionConnectOperation("AND", 0);
    OR = new ConditionConnectOperation("OR", 1);
    $VALUES = $values();
    AppMethodBeat.o(244286);
  }
  
  private ISqlObj$ConditionConnectOperation() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.ISqlObj.ConditionConnectOperation
 * JD-Core Version:    0.7.0.1
 */