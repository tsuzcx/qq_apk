package com.tencent.mm.sdk.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/sql/Sql$StringIn;", "Lcom/tencent/mm/sdk/sql/InCondition;", "column", "", "values", "", "(Ljava/lang/String;Ljava/util/List;)V", "wechat-sdk_release"})
public final class Sql$StringIn
  extends InCondition
{
  public Sql$StringIn(String paramString, List<String> paramList)
  {
    super(paramString, false, true, paramList);
    AppMethodBeat.i(191766);
    AppMethodBeat.o(191766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.sql.Sql.StringIn
 * JD-Core Version:    0.7.0.1
 */