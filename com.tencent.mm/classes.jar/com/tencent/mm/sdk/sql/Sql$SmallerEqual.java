package com.tencent.mm.sdk.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/sql/Sql$SmallerEqual;", "Lcom/tencent/mm/sdk/sql/ColumnValueCondition;", "column", "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "wechat-sdk_release"})
public final class Sql$SmallerEqual
  extends ColumnValueCondition
{
  public Sql$SmallerEqual(String paramString1, String paramString2)
  {
    super(paramString1, paramString2, ISqlObj.ConditionOperation.SmallerEqual);
    AppMethodBeat.i(194082);
    AppMethodBeat.o(194082);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.sql.Sql.SmallerEqual
 * JD-Core Version:    0.7.0.1
 */