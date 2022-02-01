package com.tencent.mm.sdk.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/sql/Sql$ColumnSmallerThan;", "Lcom/tencent/mm/sdk/sql/ColumnCompareCondition;", "column1", "", "column2", "(Ljava/lang/String;Ljava/lang/String;)V", "wechat-sdk_release"})
public final class Sql$ColumnSmallerThan
  extends ColumnCompareCondition
{
  public Sql$ColumnSmallerThan(String paramString1, String paramString2)
  {
    super(paramString1, paramString2, ISqlObj.ConditionOperation.SmallerThan);
    AppMethodBeat.i(189994);
    AppMethodBeat.o(189994);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.sql.Sql.ColumnSmallerThan
 * JD-Core Version:    0.7.0.1
 */