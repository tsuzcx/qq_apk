package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/Sql$ColumnNotEqual;", "Lcom/tencent/mm/sdk/storage/sql/ColumnCompareCondition;", "column1", "", "column2", "(Ljava/lang/String;Ljava/lang/String;)V", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class Sql$ColumnNotEqual
  extends ColumnCompareCondition
{
  public Sql$ColumnNotEqual(String paramString1, String paramString2)
  {
    super(paramString1, paramString2, ISqlObj.ConditionOperation.NotEqual);
    AppMethodBeat.i(244309);
    AppMethodBeat.o(244309);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.Sql.ColumnNotEqual
 * JD-Core Version:    0.7.0.1
 */